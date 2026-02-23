package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class FramedConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set currentPushRequests;
    final FrameWriter frameWriter;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextPingId;
    private int nextStreamId;
    Settings okHttpSettings;
    final Settings peerSettings;
    private Map pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    public class 1 extends NamedRunnable {
        final /* synthetic */ ErrorCode val$errorCode;
        final /* synthetic */ int val$streamId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.val$streamId = i;
            this.val$errorCode = errorCode;
        }

        public void execute() {
            try {
                FramedConnection.this.writeSynReset(this.val$streamId, this.val$errorCode);
            } catch (IOException unused) {
            }
        }
    }

    public class 2 extends NamedRunnable {
        final /* synthetic */ int val$streamId;
        final /* synthetic */ long val$unacknowledgedBytesRead;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 2(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.val$streamId = i;
            this.val$unacknowledgedBytesRead = j;
        }

        public void execute() {
            try {
                FramedConnection.this.frameWriter.windowUpdate(this.val$streamId, this.val$unacknowledgedBytesRead);
            } catch (IOException unused) {
            }
        }
    }

    public class 3 extends NamedRunnable {
        final /* synthetic */ int val$payload1;
        final /* synthetic */ int val$payload2;
        final /* synthetic */ Ping val$ping;
        final /* synthetic */ boolean val$reply;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 3(String str, Object[] objArr, boolean z, int i, int i2, Ping ping) {
            super(str, objArr);
            this.val$reply = z;
            this.val$payload1 = i;
            this.val$payload2 = i2;
            this.val$ping = ping;
        }

        public void execute() {
            try {
                FramedConnection.access$900(FramedConnection.this, this.val$reply, this.val$payload1, this.val$payload2, this.val$ping);
            } catch (IOException unused) {
            }
        }
    }

    public class 4 extends NamedRunnable {
        final /* synthetic */ List val$requestHeaders;
        final /* synthetic */ int val$streamId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 4(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.val$streamId = i;
            this.val$requestHeaders = list;
        }

        public void execute() {
            if (FramedConnection.access$2700(FramedConnection.this).onRequest(this.val$streamId, this.val$requestHeaders)) {
                try {
                    FramedConnection.this.frameWriter.rstStream(this.val$streamId, ErrorCode.CANCEL);
                    synchronized (FramedConnection.this) {
                        FramedConnection.access$2800(FramedConnection.this).remove(Integer.valueOf(this.val$streamId));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    public class 5 extends NamedRunnable {
        final /* synthetic */ boolean val$inFinished;
        final /* synthetic */ List val$requestHeaders;
        final /* synthetic */ int val$streamId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 5(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.val$streamId = i;
            this.val$requestHeaders = list;
            this.val$inFinished = z;
        }

        public void execute() {
            boolean onHeaders = FramedConnection.access$2700(FramedConnection.this).onHeaders(this.val$streamId, this.val$requestHeaders, this.val$inFinished);
            if (onHeaders) {
                try {
                    FramedConnection.this.frameWriter.rstStream(this.val$streamId, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.val$inFinished) {
                synchronized (FramedConnection.this) {
                    FramedConnection.access$2800(FramedConnection.this).remove(Integer.valueOf(this.val$streamId));
                }
            }
        }
    }

    public class 6 extends NamedRunnable {
        final /* synthetic */ Buffer val$buffer;
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ boolean val$inFinished;
        final /* synthetic */ int val$streamId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 6(String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
            super(str, objArr);
            this.val$streamId = i;
            this.val$buffer = buffer;
            this.val$byteCount = i2;
            this.val$inFinished = z;
        }

        public void execute() {
            try {
                boolean onData = FramedConnection.access$2700(FramedConnection.this).onData(this.val$streamId, this.val$buffer, this.val$byteCount, this.val$inFinished);
                if (onData) {
                    FramedConnection.this.frameWriter.rstStream(this.val$streamId, ErrorCode.CANCEL);
                }
                if (onData || this.val$inFinished) {
                    synchronized (FramedConnection.this) {
                        FramedConnection.access$2800(FramedConnection.this).remove(Integer.valueOf(this.val$streamId));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public class 7 extends NamedRunnable {
        final /* synthetic */ ErrorCode val$errorCode;
        final /* synthetic */ int val$streamId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 7(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.val$streamId = i;
            this.val$errorCode = errorCode;
        }

        public void execute() {
            FramedConnection.access$2700(FramedConnection.this).onReset(this.val$streamId, this.val$errorCode);
            synchronized (FramedConnection.this) {
                FramedConnection.access$2800(FramedConnection.this).remove(Integer.valueOf(this.val$streamId));
            }
        }
    }

    public static class Builder {
        private boolean client;
        private String hostName;
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        private Protocol protocol = Protocol.SPDY_3;
        private PushObserver pushObserver = PushObserver.CANCEL;
        private BufferedSink sink;
        private Socket socket;
        private BufferedSource source;

        public Builder(boolean z) throws IOException {
            this.client = z;
        }

        public static /* synthetic */ Protocol access$000(Builder builder) {
            return builder.protocol;
        }

        public static /* synthetic */ PushObserver access$100(Builder builder) {
            return builder.pushObserver;
        }

        public static /* synthetic */ boolean access$200(Builder builder) {
            return builder.client;
        }

        public static /* synthetic */ Listener access$300(Builder builder) {
            return builder.listener;
        }

        public static /* synthetic */ String access$400(Builder builder) {
            return builder.hostName;
        }

        public static /* synthetic */ Socket access$500(Builder builder) {
            return builder.socket;
        }

        public static /* synthetic */ BufferedSink access$600(Builder builder) {
            return builder.sink;
        }

        public static /* synthetic */ BufferedSource access$700(Builder builder) {
            return builder.source;
        }

        public FramedConnection build() throws IOException {
            return new FramedConnection(this, null);
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) throws IOException {
            return socket(socket, socket.getRemoteSocketAddress().getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostName = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new 1();

        public static class 1 extends Listener {
            public void onStream(FramedStream framedStream) throws IOException {
                framedStream.close(ErrorCode.REFUSED_STREAM);
            }
        }

        public void onSettings(FramedConnection framedConnection) {
        }

        public abstract void onStream(FramedStream framedStream) throws IOException;
    }

    public class Reader extends NamedRunnable implements FrameReader.Handler {
        final FrameReader frameReader;

        public class 1 extends NamedRunnable {
            final /* synthetic */ FramedStream val$newStream;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public 1(String str, Object[] objArr, FramedStream framedStream) {
                super(str, objArr);
                this.val$newStream = framedStream;
            }

            public void execute() {
                try {
                    FramedConnection.access$2000(FramedConnection.this).onStream(this.val$newStream);
                } catch (IOException e) {
                    Internal.logger.log(Level.INFO, "FramedConnection.Listener failure for " + FramedConnection.access$1100(FramedConnection.this), e);
                    try {
                        this.val$newStream.close(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public class 2 extends NamedRunnable {
            public 2(String str, Object... objArr) {
                super(str, objArr);
            }

            public void execute() {
                FramedConnection.access$2000(FramedConnection.this).onSettings(FramedConnection.this);
            }
        }

        public class 3 extends NamedRunnable {
            final /* synthetic */ Settings val$peerSettings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public 3(String str, Object[] objArr, Settings settings) {
                super(str, objArr);
                this.val$peerSettings = settings;
            }

            public void execute() {
                try {
                    FramedConnection.this.frameWriter.ackSettings(this.val$peerSettings);
                } catch (IOException unused) {
                }
            }
        }

        private Reader(FrameReader frameReader) {
            super("OkHttp %s", FramedConnection.access$1100(FramedConnection.this));
            this.frameReader = frameReader;
        }

        private void ackSettingsLater(Settings settings) {
            FramedConnection.access$2100().execute(new 3("OkHttp %s ACK Settings", new Object[]{FramedConnection.access$1100(FramedConnection.this)}, settings));
        }

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (FramedConnection.access$1300(FramedConnection.this, i)) {
                FramedConnection.access$1400(FramedConnection.this, i, bufferedSource, i2, z);
                return;
            }
            FramedStream stream = FramedConnection.this.getStream(i);
            if (stream == null) {
                FramedConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                bufferedSource.skip(i2);
            } else {
                stream.receiveData(bufferedSource, i2);
                if (z) {
                    stream.receiveFin();
                }
            }
        }

        public void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    if (!FramedConnection.this.client) {
                        this.frameReader.readConnectionPreface();
                    }
                    while (this.frameReader.nextFrame(this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                    try {
                        try {
                            FramedConnection.access$1200(FramedConnection.this, errorCode2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                            FramedConnection.access$1200(FramedConnection.this, errorCode4, errorCode4);
                            Util.closeQuietly(this.frameReader);
                        }
                    } catch (Throwable th) {
                        errorCode = errorCode2;
                        th = th;
                        try {
                            FramedConnection.access$1200(FramedConnection.this, errorCode, errorCode3);
                        } catch (IOException unused2) {
                        }
                        Util.closeQuietly(this.frameReader);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                errorCode2 = errorCode3;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode3;
                FramedConnection.access$1200(FramedConnection.this, errorCode, errorCode3);
                Util.closeQuietly(this.frameReader);
                throw th;
            }
            Util.closeQuietly(this.frameReader);
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            FramedStream[] framedStreamArr;
            byteString.size();
            synchronized (FramedConnection.this) {
                framedStreamArr = (FramedStream[]) FramedConnection.access$1900(FramedConnection.this).values().toArray(new FramedStream[FramedConnection.access$1900(FramedConnection.this).size()]);
                FramedConnection.access$1602(FramedConnection.this, true);
            }
            for (FramedStream framedStream : framedStreamArr) {
                if (framedStream.getId() > i && framedStream.isLocallyInitiated()) {
                    framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.removeStream(framedStream.getId());
                }
            }
        }

        public void headers(boolean z, boolean z2, int i, int i2, List list, HeadersMode headersMode) {
            if (FramedConnection.access$1300(FramedConnection.this, i)) {
                FramedConnection.access$1500(FramedConnection.this, i, list, z2);
                return;
            }
            synchronized (FramedConnection.this) {
                try {
                    if (FramedConnection.access$1600(FramedConnection.this)) {
                        return;
                    }
                    FramedStream stream = FramedConnection.this.getStream(i);
                    if (stream != null) {
                        if (headersMode.failIfStreamPresent()) {
                            stream.closeLater(ErrorCode.PROTOCOL_ERROR);
                            FramedConnection.this.removeStream(i);
                            return;
                        } else {
                            stream.receiveHeaders(list, headersMode);
                            if (z2) {
                                stream.receiveFin();
                                return;
                            }
                            return;
                        }
                    }
                    if (headersMode.failIfStreamAbsent()) {
                        FramedConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                        return;
                    }
                    if (i <= FramedConnection.access$1700(FramedConnection.this)) {
                        return;
                    }
                    if (i % 2 == FramedConnection.access$1800(FramedConnection.this) % 2) {
                        return;
                    }
                    FramedStream framedStream = new FramedStream(i, FramedConnection.this, z, z2, list);
                    FramedConnection.access$1702(FramedConnection.this, i);
                    FramedConnection.access$1900(FramedConnection.this).put(Integer.valueOf(i), framedStream);
                    FramedConnection.access$2100().execute(new 1("OkHttp %s stream %d", new Object[]{FramedConnection.access$1100(FramedConnection.this), Integer.valueOf(i)}, framedStream));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void ping(boolean z, int i, int i2) {
            if (!z) {
                FramedConnection.access$2500(FramedConnection.this, true, i, i2, null);
                return;
            }
            Ping access$2400 = FramedConnection.access$2400(FramedConnection.this, i);
            if (access$2400 != null) {
                access$2400.receive();
            }
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        public void pushPromise(int i, int i2, List list) {
            FramedConnection.access$2600(FramedConnection.this, i2, list);
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (FramedConnection.access$1300(FramedConnection.this, i)) {
                FramedConnection.access$2200(FramedConnection.this, i, errorCode);
                return;
            }
            FramedStream removeStream = FramedConnection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z, Settings settings) {
            FramedStream[] framedStreamArr;
            long j;
            synchronized (FramedConnection.this) {
                try {
                    int initialWindowSize = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
                    if (z) {
                        FramedConnection.this.peerSettings.clear();
                    }
                    FramedConnection.this.peerSettings.merge(settings);
                    if (FramedConnection.this.getProtocol() == Protocol.HTTP_2) {
                        ackSettingsLater(settings);
                    }
                    int initialWindowSize2 = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
                    framedStreamArr = null;
                    if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                        j = 0;
                    } else {
                        j = initialWindowSize2 - initialWindowSize;
                        if (!FramedConnection.access$2300(FramedConnection.this)) {
                            FramedConnection.this.addBytesToWriteWindow(j);
                            FramedConnection.access$2302(FramedConnection.this, true);
                        }
                        if (!FramedConnection.access$1900(FramedConnection.this).isEmpty()) {
                            framedStreamArr = (FramedStream[]) FramedConnection.access$1900(FramedConnection.this).values().toArray(new FramedStream[FramedConnection.access$1900(FramedConnection.this).size()]);
                        }
                    }
                    FramedConnection.access$2100().execute(new 2("OkHttp %s settings", FramedConnection.access$1100(FramedConnection.this)));
                } finally {
                }
            }
            if (framedStreamArr == null || j == 0) {
                return;
            }
            for (FramedStream framedStream : framedStreamArr) {
                synchronized (framedStream) {
                    framedStream.addBytesToWriteWindow(j);
                }
            }
        }

        public void windowUpdate(int i, long j) {
            FramedConnection framedConnection = FramedConnection.this;
            if (i == 0) {
                synchronized (framedConnection) {
                    FramedConnection framedConnection2 = FramedConnection.this;
                    framedConnection2.bytesLeftInWriteWindow += j;
                    framedConnection2.notifyAll();
                }
                return;
            }
            FramedStream stream = framedConnection.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        public /* synthetic */ Reader(FramedConnection framedConnection, FrameReader frameReader, 1 r3) {
            this(frameReader);
        }
    }

    private FramedConnection(Builder builder) throws IOException {
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0L;
        this.okHttpSettings = new Settings();
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        Protocol access$000 = Builder.access$000(builder);
        this.protocol = access$000;
        this.pushObserver = Builder.access$100(builder);
        boolean access$200 = Builder.access$200(builder);
        this.client = access$200;
        this.listener = Builder.access$300(builder);
        this.nextStreamId = Builder.access$200(builder) ? 1 : 2;
        if (Builder.access$200(builder) && access$000 == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        this.nextPingId = Builder.access$200(builder) ? 1 : 2;
        if (Builder.access$200(builder)) {
            this.okHttpSettings.set(7, 0, 16777216);
        }
        String access$400 = Builder.access$400(builder);
        this.hostName = access$400;
        if (access$000 == Protocol.HTTP_2) {
            this.variant = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[]{access$400}), true));
            settings.set(7, 0, 65535);
            settings.set(5, 0, 16384);
        } else {
            if (access$000 != Protocol.SPDY_3) {
                throw new AssertionError(access$000);
            }
            this.variant = new Spdy3();
            this.pushExecutor = null;
        }
        this.bytesLeftInWriteWindow = settings.getInitialWindowSize(65536);
        this.socket = Builder.access$500(builder);
        this.frameWriter = this.variant.newWriter(Builder.access$600(builder), access$200);
        Reader reader = new Reader(this, this.variant.newReader(Builder.access$700(builder), access$200), null);
        this.readerRunnable = reader;
        new Thread(reader).start();
    }

    public static /* synthetic */ String access$1100(FramedConnection framedConnection) {
        return framedConnection.hostName;
    }

    public static /* synthetic */ void access$1200(FramedConnection framedConnection, ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        framedConnection.close(errorCode, errorCode2);
    }

    public static /* synthetic */ boolean access$1300(FramedConnection framedConnection, int i) {
        return framedConnection.pushedStream(i);
    }

    public static /* synthetic */ void access$1400(FramedConnection framedConnection, int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        framedConnection.pushDataLater(i, bufferedSource, i2, z);
    }

    public static /* synthetic */ void access$1500(FramedConnection framedConnection, int i, List list, boolean z) {
        framedConnection.pushHeadersLater(i, list, z);
    }

    public static /* synthetic */ boolean access$1600(FramedConnection framedConnection) {
        return framedConnection.shutdown;
    }

    public static /* synthetic */ boolean access$1602(FramedConnection framedConnection, boolean z) {
        framedConnection.shutdown = z;
        return z;
    }

    public static /* synthetic */ int access$1700(FramedConnection framedConnection) {
        return framedConnection.lastGoodStreamId;
    }

    public static /* synthetic */ int access$1702(FramedConnection framedConnection, int i) {
        framedConnection.lastGoodStreamId = i;
        return i;
    }

    public static /* synthetic */ int access$1800(FramedConnection framedConnection) {
        return framedConnection.nextStreamId;
    }

    public static /* synthetic */ Map access$1900(FramedConnection framedConnection) {
        return framedConnection.streams;
    }

    public static /* synthetic */ Listener access$2000(FramedConnection framedConnection) {
        return framedConnection.listener;
    }

    public static /* synthetic */ ExecutorService access$2100() {
        return executor;
    }

    public static /* synthetic */ void access$2200(FramedConnection framedConnection, int i, ErrorCode errorCode) {
        framedConnection.pushResetLater(i, errorCode);
    }

    public static /* synthetic */ boolean access$2300(FramedConnection framedConnection) {
        return framedConnection.receivedInitialPeerSettings;
    }

    public static /* synthetic */ boolean access$2302(FramedConnection framedConnection, boolean z) {
        framedConnection.receivedInitialPeerSettings = z;
        return z;
    }

    public static /* synthetic */ Ping access$2400(FramedConnection framedConnection, int i) {
        return framedConnection.removePing(i);
    }

    public static /* synthetic */ void access$2500(FramedConnection framedConnection, boolean z, int i, int i2, Ping ping) {
        framedConnection.writePingLater(z, i, i2, ping);
    }

    public static /* synthetic */ void access$2600(FramedConnection framedConnection, int i, List list) {
        framedConnection.pushRequestLater(i, list);
    }

    public static /* synthetic */ PushObserver access$2700(FramedConnection framedConnection) {
        return framedConnection.pushObserver;
    }

    public static /* synthetic */ Set access$2800(FramedConnection framedConnection) {
        return framedConnection.currentPushRequests;
    }

    public static /* synthetic */ void access$900(FramedConnection framedConnection, boolean z, int i, int i2, Ping ping) throws IOException {
        framedConnection.writePing(z, i, i2, ping);
    }

    private FramedStream newStream(int i, List list, boolean z, boolean z2) throws IOException {
        int i2;
        FramedStream framedStream;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.frameWriter) {
            try {
                synchronized (this) {
                    try {
                        if (this.shutdown) {
                            throw new IOException("shutdown");
                        }
                        i2 = this.nextStreamId;
                        this.nextStreamId = i2 + 2;
                        framedStream = new FramedStream(i2, this, z3, z4, list);
                        if (framedStream.isOpen()) {
                            this.streams.put(Integer.valueOf(i2), framedStream);
                            setIdle(false);
                        }
                    } finally {
                    }
                }
                if (i == 0) {
                    this.frameWriter.synStream(z3, z4, i2, i, list);
                } else {
                    if (this.client) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.frameWriter.pushPromise(i, i2, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            this.frameWriter.flush();
        }
        return framedStream;
    }

    private void pushDataLater(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            this.pushExecutor.execute(new 6("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    private void pushHeadersLater(int i, List list, boolean z) {
        this.pushExecutor.execute(new 5("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(i)}, i, list, z));
    }

    private void pushRequestLater(int i, List list) {
        synchronized (this) {
            try {
                if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                    writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                } else {
                    this.currentPushRequests.add(Integer.valueOf(i));
                    this.pushExecutor.execute(new 4("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(i)}, i, list));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void pushResetLater(int i, ErrorCode errorCode) {
        this.pushExecutor.execute(new 7("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(i)}, i, errorCode));
    }

    private boolean pushedStream(int i) {
        return this.protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private synchronized Ping removePing(int i) {
        Map map;
        map = this.pings;
        return map != null ? (Ping) map.remove(Integer.valueOf(i)) : null;
    }

    private synchronized void setIdle(boolean z) {
        long nanoTime;
        if (z) {
            try {
                nanoTime = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            nanoTime = Long.MAX_VALUE;
        }
        this.idleStartTimeNs = nanoTime;
    }

    private void writePing(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                try {
                    ping.send();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.frameWriter.ping(z, i, i2);
        }
    }

    private void writePingLater(boolean z, int i, int i2, Ping ping) {
        executor.execute(new 3("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, ping));
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public synchronized FramedStream getStream(int i) {
        return (FramedStream) this.streams.get(Integer.valueOf(i));
    }

    public synchronized boolean isIdle() {
        return this.idleStartTimeNs != Long.MAX_VALUE;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            try {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                i = this.nextPingId;
                this.nextPingId = i + 2;
                if (this.pings == null) {
                    this.pings = new HashMap();
                }
                this.pings.put(Integer.valueOf(i), ping);
            } catch (Throwable th) {
                throw th;
            }
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    public FramedStream pushStream(int i, List list, boolean z) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        if (this.protocol == Protocol.HTTP_2) {
            return newStream(i, list, z, false);
        }
        throw new IllegalStateException("protocol != HTTP_2");
    }

    public synchronized FramedStream removeStream(int i) {
        FramedStream framedStream;
        try {
            framedStream = (FramedStream) this.streams.remove(Integer.valueOf(i));
            if (framedStream != null && this.streams.isEmpty()) {
                setIdle(true);
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
        return framedStream;
    }

    public void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        if (this.okHttpSettings.getInitialWindowSize(65536) != 65536) {
            this.frameWriter.windowUpdate(0, r0 - 65536);
        }
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                this.okHttpSettings.merge(settings);
                this.frameWriter.settings(settings);
            }
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.frameWriter.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.frameWriter.maxDataLength());
        r6 = r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeData(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            com.squareup.okhttp.internal.framed.FrameWriter r12 = r8.frameWriter
            r12.data(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L32
            java.util.Map r3 = r8.streams     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L5e
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L28
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L28
            com.squareup.okhttp.internal.framed.FrameWriter r3 = r8.frameWriter     // Catch: java.lang.Throwable -> L28
            int r3 = r3.maxDataLength()     // Catch: java.lang.Throwable -> L28
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.squareup.okhttp.internal.framed.FrameWriter r4 = r8.frameWriter
            if (r10 == 0) goto L53
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = 0
        L54:
            r4.data(r5, r9, r11, r3)
            goto Ld
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public void writeSynReply(int i, boolean z, List list) throws IOException {
        this.frameWriter.synReply(z, i, list);
    }

    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i, errorCode);
    }

    public void writeSynResetLater(int i, ErrorCode errorCode) {
        executor.submit(new 1("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}, i, errorCode));
    }

    public void writeWindowUpdateLater(int i, long j) {
        executor.execute(new 2("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}, i, j));
    }

    public /* synthetic */ FramedConnection(Builder builder, 1 r2) throws IOException {
        this(builder);
    }

    private void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i;
        FramedStream[] framedStreamArr;
        Ping[] pingArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    framedStreamArr = null;
                } else {
                    framedStreamArr = (FramedStream[]) this.streams.values().toArray(new FramedStream[this.streams.size()]);
                    this.streams.clear();
                    setIdle(false);
                }
                Map map = this.pings;
                if (map != null) {
                    Ping[] pingArr2 = (Ping[]) map.values().toArray(new Ping[this.pings.size()]);
                    this.pings = null;
                    pingArr = pingArr2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (framedStreamArr != null) {
            for (FramedStream framedStream : framedStreamArr) {
                try {
                    framedStream.close(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.cancel();
            }
        }
        try {
            this.frameWriter.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public FramedStream newStream(List list, boolean z, boolean z2) throws IOException {
        return newStream(0, list, z, z2);
    }
}
