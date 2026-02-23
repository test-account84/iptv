package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import k8.q;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;

    @NotNull
    private final String connectionName;
    private final Set currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;

    @NotNull
    private final Listener listener;
    private int nextStreamId;

    @NotNull
    private final Settings okHttpSettings;

    @NotNull
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;

    @NotNull
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;

    @NotNull
    private final Socket socket;

    @NotNull
    private final Map streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;

    @NotNull
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    public static final class Builder {
        private boolean client;

        @NotNull
        public String connectionName;

        @NotNull
        private Listener listener;
        private int pingIntervalMillis;

        @NotNull
        private PushObserver pushObserver;

        @NotNull
        public BufferedSink sink;

        @NotNull
        public Socket socket;

        @NotNull
        public BufferedSource source;

        @NotNull
        private final TaskRunner taskRunner;

        public Builder(boolean z, @NotNull TaskRunner taskRunner) {
            l.e(taskRunner, "taskRunner");
            this.client = z;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i, Object obj) throws IOException {
            if ((i & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((i & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, str, bufferedSource, bufferedSink);
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str == null) {
                l.s("connectionName");
            }
            return str;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink == null) {
                l.s("sink");
            }
            return bufferedSink;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket == null) {
                l.s("socket");
            }
            return socket;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource == null) {
                l.s("source");
            }
            return bufferedSource;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Builder listener(@NotNull Listener listener) {
            l.e(listener, "listener");
            this.listener = listener;
            return this;
        }

        @NotNull
        public final Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver) {
            l.e(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final void setConnectionName$okhttp(@NotNull String str) {
            l.e(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(@NotNull Listener listener) {
            l.e(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver) {
            l.e(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(@NotNull BufferedSink bufferedSink) {
            l.e(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final void setSocket$okhttp(@NotNull Socket socket) {
            l.e(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(@NotNull BufferedSource bufferedSource) {
            l.e(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket) throws IOException {
            return socket$default(this, socket, null, null, null, 14, null);
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String str) throws IOException {
            return socket$default(this, socket, str, null, null, 12, null);
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String str, @NotNull BufferedSource bufferedSource) throws IOException {
            return socket$default(this, socket, str, bufferedSource, null, 8, null);
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName, @NotNull BufferedSource source, @NotNull BufferedSink sink) throws IOException {
            StringBuilder sb;
            l.e(socket, "socket");
            l.e(peerName, "peerName");
            l.e(source, "source");
            l.e(sink, "sink");
            this.socket = socket;
            if (this.client) {
                sb = new StringBuilder();
                sb.append(Util.okHttpName);
                sb.append(' ');
            } else {
                sb = new StringBuilder();
                sb.append("MockWebServer ");
            }
            sb.append(peerName);
            this.connectionName = sb.toString();
            this.source = source;
            this.sink = sink;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.access$getDEFAULT_SETTINGS$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        public void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
            l.e(connection, "connection");
            l.e(settings, "settings");
        }

        public abstract void onStream(@NotNull Http2Stream http2Stream) throws IOException;
    }

    public final class ReaderRunnable implements Http2Reader.Handler, a {

        @NotNull
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(@NotNull Http2Connection http2Connection, Http2Reader reader) {
            l.e(reader, "reader");
            this.this$0 = http2Connection;
            this.reader = reader;
        }

        public void ackSettings() {
        }

        public void alternateService(int i, @NotNull String origin, @NotNull ByteString protocol, @NotNull String host, int i2, long j) {
            l.e(origin, "origin");
            l.e(protocol, "protocol");
            l.e(host, "host");
        }

        public final void applyAndAckSettings(boolean z, @NotNull Settings settings) {
            Http2Connection http2Connection;
            Settings settings2;
            Http2Stream[] http2StreamArr;
            TaskQueue access$getSettingsListenerQueue$p;
            String str;
            l.e(settings, "settings");
            A a = new A();
            B b = new B();
            B b2 = new B();
            synchronized (this.this$0.getWriter()) {
                Http2Connection http2Connection2 = this.this$0;
                synchronized (http2Connection2) {
                    try {
                        Settings peerSettings = this.this$0.getPeerSettings();
                        if (z) {
                            settings2 = settings;
                        } else {
                            settings2 = new Settings();
                            settings2.merge(peerSettings);
                            settings2.merge(settings);
                            q qVar = q.a;
                        }
                        b2.a = settings2;
                        long initialWindowSize = settings2.getInitialWindowSize() - peerSettings.getInitialWindowSize();
                        a.a = initialWindowSize;
                        if (initialWindowSize == 0 || this.this$0.getStreams$okhttp().isEmpty()) {
                            http2StreamArr = null;
                        } else {
                            Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            http2StreamArr = (Http2Stream[]) array;
                        }
                        b.a = http2StreamArr;
                        this.this$0.setPeerSettings((Settings) b2.a);
                        access$getSettingsListenerQueue$p = Http2Connection.access$getSettingsListenerQueue$p(this.this$0);
                        str = this.this$0.getConnectionName$okhttp() + " onSettings";
                        http2Connection = http2Connection2;
                    } catch (Throwable th) {
                        th = th;
                        http2Connection = http2Connection2;
                    }
                    try {
                        access$getSettingsListenerQueue$p.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(str, true, str, true, this, b2, z, settings, a, b), 0L);
                        q qVar2 = q.a;
                        try {
                            this.this$0.getWriter().applyAndAckSettings((Settings) b2.a);
                        } catch (IOException e) {
                            Http2Connection.access$failConnection(this.this$0, e);
                        }
                        q qVar3 = q.a;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
            Object obj = b.a;
            if (((Http2Stream[]) obj) != null) {
                Http2Stream[] http2StreamArr2 = (Http2Stream[]) obj;
                l.b(http2StreamArr2);
                for (Http2Stream http2Stream : http2StreamArr2) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(a.a);
                        q qVar4 = q.a;
                    }
                }
            }
        }

        public void data(boolean z, int i, @NotNull BufferedSource source, int i2) throws IOException {
            l.e(source, "source");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushDataLater$okhttp(i, source, i2, z);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                this.this$0.updateConnectionFlowControl$okhttp(j);
                source.skip(j);
                return;
            }
            stream.receiveData(source, i2);
            if (z) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        public void goAway(int i, @NotNull ErrorCode errorCode, @NotNull ByteString debugData) {
            int i2;
            Http2Stream[] http2StreamArr;
            l.e(errorCode, "errorCode");
            l.e(debugData, "debugData");
            debugData.size();
            synchronized (this.this$0) {
                Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                Http2Connection.access$setShutdown$p(this.this$0, true);
                q qVar = q.a;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        public void headers(boolean z, int i, int i2, @NotNull List headerBlock) {
            l.e(headerBlock, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushHeadersLater$okhttp(i, headerBlock, z);
                return;
            }
            synchronized (this.this$0) {
                Http2Stream stream = this.this$0.getStream(i);
                if (stream != null) {
                    q qVar = q.a;
                    stream.receiveHeaders(Util.toHeaders(headerBlock), z);
                    return;
                }
                if (Http2Connection.access$isShutdown$p(this.this$0)) {
                    return;
                }
                if (i <= this.this$0.getLastGoodStreamId$okhttp()) {
                    return;
                }
                if (i % 2 == this.this$0.getNextStreamId$okhttp() % 2) {
                    return;
                }
                Http2Stream http2Stream = new Http2Stream(i, this.this$0, false, z, Util.toHeaders(headerBlock));
                this.this$0.setLastGoodStreamId$okhttp(i);
                this.this$0.getStreams$okhttp().put(Integer.valueOf(i), http2Stream);
                TaskQueue newQueue = Http2Connection.access$getTaskRunner$p(this.this$0).newQueue();
                String str = this.this$0.getConnectionName$okhttp() + '[' + i + "] onStream";
                newQueue.schedule(new Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1(str, true, str, true, http2Stream, this, stream, i, headerBlock, z), 0L);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            invoke();
            return q.a;
        }

        public void ping(boolean z, int i, int i2) {
            if (!z) {
                TaskQueue access$getWriterQueue$p = Http2Connection.access$getWriterQueue$p(this.this$0);
                String str = this.this$0.getConnectionName$okhttp() + " ping";
                access$getWriterQueue$p.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$1(str, true, str, true, this, i, i2), 0L);
                return;
            }
            synchronized (this.this$0) {
                try {
                    if (i == 1) {
                        Http2Connection http2Connection = this.this$0;
                        Http2Connection.access$setIntervalPongsReceived$p(http2Connection, Http2Connection.access$getIntervalPongsReceived$p(http2Connection) + 1);
                    } else if (i != 2) {
                        if (i == 3) {
                            Http2Connection http2Connection2 = this.this$0;
                            Http2Connection.access$setAwaitPongsReceived$p(http2Connection2, Http2Connection.access$getAwaitPongsReceived$p(http2Connection2) + 1);
                            Http2Connection http2Connection3 = this.this$0;
                            if (http2Connection3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            http2Connection3.notifyAll();
                        }
                        q qVar = q.a;
                    } else {
                        Http2Connection http2Connection4 = this.this$0;
                        Http2Connection.access$setDegradedPongsReceived$p(http2Connection4, Http2Connection.access$getDegradedPongsReceived$p(http2Connection4) + 1);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        public void pushPromise(int i, int i2, @NotNull List requestHeaders) {
            l.e(requestHeaders, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i2, requestHeaders);
        }

        public void rstStream(int i, @NotNull ErrorCode errorCode) {
            l.e(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushResetLater$okhttp(i, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = this.this$0.removeStream$okhttp(i);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z, @NotNull Settings settings) {
            l.e(settings, "settings");
            TaskQueue access$getWriterQueue$p = Http2Connection.access$getWriterQueue$p(this.this$0);
            String str = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            access$getWriterQueue$p.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$1(str, true, str, true, this, z, settings), 0L);
        }

        public void windowUpdate(int i, long j) {
            Closeable stream;
            if (i == 0) {
                stream = this.this$0;
                synchronized (stream) {
                    Http2Connection http2Connection = this.this$0;
                    Http2Connection.access$setWriteBytesMaximum$p(http2Connection, http2Connection.getWriteBytesMaximum() + j);
                    Http2Connection http2Connection2 = this.this$0;
                    if (http2Connection2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    http2Connection2.notifyAll();
                    q qVar = q.a;
                }
            } else {
                stream = this.this$0.getStream(i);
                if (stream == null) {
                    return;
                }
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                    q qVar2 = q.a;
                }
            }
        }

        public void invoke() {
            Closeable closeable;
            Closeable closeable2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    Closeable closeable3 = ErrorCode.NO_ERROR;
                    try {
                        this.this$0.close$okhttp(closeable3, ErrorCode.CANCEL, null);
                        closeable = closeable3;
                    } catch (IOException e2) {
                        e = e2;
                        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection http2Connection = this.this$0;
                        http2Connection.close$okhttp(errorCode, errorCode, e);
                        closeable = http2Connection;
                        closeable2 = this.reader;
                        Util.closeQuietly(closeable2);
                    }
                } catch (Throwable th) {
                    th = th;
                    this.this$0.close$okhttp(closeable, closeable2, e);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                closeable = closeable2;
                this.this$0.close$okhttp(closeable, closeable2, e);
                Util.closeQuietly(this.reader);
                throw th;
            }
            closeable2 = this.reader;
            Util.closeQuietly(closeable2);
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(@NotNull Builder builder) {
        l.e(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, 16777216);
        }
        q qVar = q.a;
        this.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.writeBytesMaximum = r2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            String str = connectionName$okhttp + " ping";
            newQueue.schedule(new Http2Connection$$special$$inlined$schedule$1(str, str, this, nanos), nanos);
        }
    }

    public static final /* synthetic */ void access$failConnection(Http2Connection http2Connection, IOException iOException) {
        http2Connection.failConnection(iOException);
    }

    public static final /* synthetic */ long access$getAwaitPongsReceived$p(Http2Connection http2Connection) {
        return http2Connection.awaitPongsReceived;
    }

    public static final /* synthetic */ Set access$getCurrentPushRequests$p(Http2Connection http2Connection) {
        return http2Connection.currentPushRequests;
    }

    public static final /* synthetic */ Settings access$getDEFAULT_SETTINGS$cp() {
        return DEFAULT_SETTINGS;
    }

    public static final /* synthetic */ long access$getDegradedPongsReceived$p(Http2Connection http2Connection) {
        return http2Connection.degradedPongsReceived;
    }

    public static final /* synthetic */ long access$getIntervalPingsSent$p(Http2Connection http2Connection) {
        return http2Connection.intervalPingsSent;
    }

    public static final /* synthetic */ long access$getIntervalPongsReceived$p(Http2Connection http2Connection) {
        return http2Connection.intervalPongsReceived;
    }

    public static final /* synthetic */ PushObserver access$getPushObserver$p(Http2Connection http2Connection) {
        return http2Connection.pushObserver;
    }

    public static final /* synthetic */ TaskQueue access$getSettingsListenerQueue$p(Http2Connection http2Connection) {
        return http2Connection.settingsListenerQueue;
    }

    public static final /* synthetic */ TaskRunner access$getTaskRunner$p(Http2Connection http2Connection) {
        return http2Connection.taskRunner;
    }

    public static final /* synthetic */ long access$getWriteBytesMaximum$p(Http2Connection http2Connection) {
        return http2Connection.writeBytesMaximum;
    }

    public static final /* synthetic */ TaskQueue access$getWriterQueue$p(Http2Connection http2Connection) {
        return http2Connection.writerQueue;
    }

    public static final /* synthetic */ boolean access$isShutdown$p(Http2Connection http2Connection) {
        return http2Connection.isShutdown;
    }

    public static final /* synthetic */ void access$setAwaitPongsReceived$p(Http2Connection http2Connection, long j) {
        http2Connection.awaitPongsReceived = j;
    }

    public static final /* synthetic */ void access$setDegradedPongsReceived$p(Http2Connection http2Connection, long j) {
        http2Connection.degradedPongsReceived = j;
    }

    public static final /* synthetic */ void access$setIntervalPingsSent$p(Http2Connection http2Connection, long j) {
        http2Connection.intervalPingsSent = j;
    }

    public static final /* synthetic */ void access$setIntervalPongsReceived$p(Http2Connection http2Connection, long j) {
        http2Connection.intervalPongsReceived = j;
    }

    public static final /* synthetic */ void access$setShutdown$p(Http2Connection http2Connection, boolean z) {
        http2Connection.isShutdown = z;
    }

    public static final /* synthetic */ void access$setWriteBytesMaximum$p(Http2Connection http2Connection, long j) {
        http2Connection.writeBytesMaximum = j;
    }

    private final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    private final Http2Stream newStream(int i, List list, boolean z) throws IOException {
        int i2;
        Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.writer) {
            try {
                synchronized (this) {
                    try {
                        if (this.nextStreamId > 1073741823) {
                            shutdown(ErrorCode.REFUSED_STREAM);
                        }
                        if (this.isShutdown) {
                            throw new ConnectionShutdownException();
                        }
                        i2 = this.nextStreamId;
                        this.nextStreamId = i2 + 2;
                        http2Stream = new Http2Stream(i2, this, z3, false, null);
                        z2 = !z || this.writeBytesTotal >= this.writeBytesMaximum || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                        if (http2Stream.isOpen()) {
                            this.streams.put(Integer.valueOf(i2), http2Stream);
                        }
                        q qVar = q.a;
                    } finally {
                    }
                }
                if (i == 0) {
                    this.writer.headers(z3, i2, list);
                } else {
                    if (!(true ^ this.client)) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                    }
                    this.writer.pushPromise(i, i2, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, TaskRunner taskRunner, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z, taskRunner);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(@NotNull ErrorCode connectionCode, @NotNull ErrorCode streamCode, @Nullable IOException iOException) {
        int i;
        Http2Stream[] http2StreamArr;
        l.e(connectionCode, "connectionCode");
        l.e(streamCode, "streamCode");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        try {
            shutdown(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (!this.streams.isEmpty()) {
                    Object[] array = this.streams.values().toArray(new Http2Stream[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    http2StreamArr = (Http2Stream[]) array;
                    this.streams.clear();
                } else {
                    http2StreamArr = null;
                }
                q qVar = q.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @NotNull
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @Nullable
    public final synchronized Http2Stream getStream(int i) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i));
    }

    @NotNull
    public final Map getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived < this.degradedPingsSent) {
            if (j >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(int i, @NotNull BufferedSource source, int i2, boolean z) throws IOException {
        l.e(source, "source");
        Buffer buffer = new Buffer();
        long j = i2;
        source.require(j);
        source.read(buffer, j);
        TaskQueue taskQueue = this.pushQueue;
        String str = this.connectionName + '[' + i + "] onData";
        taskQueue.schedule(new Http2Connection$pushDataLater$$inlined$execute$1(str, true, str, true, this, i, buffer, i2, z), 0L);
    }

    public final void pushHeadersLater$okhttp(int i, @NotNull List requestHeaders, boolean z) {
        l.e(requestHeaders, "requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        String str = this.connectionName + '[' + i + "] onHeaders";
        taskQueue.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$1(str, true, str, true, this, i, requestHeaders, z), 0L);
    }

    public final void pushRequestLater$okhttp(int i, @NotNull List requestHeaders) {
        l.e(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            TaskQueue taskQueue = this.pushQueue;
            String str = this.connectionName + '[' + i + "] onRequest";
            taskQueue.schedule(new Http2Connection$pushRequestLater$$inlined$execute$1(str, true, str, true, this, i, requestHeaders), 0L);
        }
    }

    public final void pushResetLater$okhttp(int i, @NotNull ErrorCode errorCode) {
        l.e(errorCode, "errorCode");
        TaskQueue taskQueue = this.pushQueue;
        String str = this.connectionName + '[' + i + "] onReset";
        taskQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$1(str, true, str, true, this, i, errorCode), 0L);
    }

    @NotNull
    public final Http2Stream pushStream(int i, @NotNull List requestHeaders, boolean z) throws IOException {
        l.e(requestHeaders, "requestHeaders");
        if (!this.client) {
            return newStream(i, requestHeaders, z);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Nullable
    public final synchronized Http2Stream removeStream$okhttp(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j = this.degradedPongsReceived;
            long j2 = this.degradedPingsSent;
            if (j < j2) {
                return;
            }
            this.degradedPingsSent = j2 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
            q qVar = q.a;
            TaskQueue taskQueue = this.writerQueue;
            String str = this.connectionName + " ping";
            taskQueue.schedule(new Http2Connection$sendDegradedPingLater$$inlined$execute$1(str, true, str, true, this), 0L);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    public final void setPeerSettings(@NotNull Settings settings) {
        l.e(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(@NotNull Settings settings) throws IOException {
        l.e(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
                q qVar = q.a;
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(@NotNull ErrorCode statusCode) throws IOException {
        l.e(statusCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i = this.lastGoodStreamId;
                q qVar = q.a;
                this.writer.goAway(i, statusCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.readBytesTotal + j;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.writer.maxDataLength());
        r6 = r3;
        r8.writeBytesTotal += r6;
        r4 = k8.q.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeData(int r9, boolean r10, @org.jetbrains.annotations.Nullable okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L6c
            monitor-enter(r8)
        L12:
            long r3 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            long r5 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L34
            java.util.Map r3 = r8.streams     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            if (r3 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            goto L12
        L2a:
            r9 = move-exception
            goto L6a
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
        L34:
            long r5 = r5 - r3
            long r3 = java.lang.Math.min(r12, r5)     // Catch: java.lang.Throwable -> L2a
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L2a
            okhttp3.internal.http2.Http2Writer r3 = r8.writer     // Catch: java.lang.Throwable -> L2a
            int r3 = r3.maxDataLength()     // Catch: java.lang.Throwable -> L2a
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L2a
            k8.q r4 = k8.q.a     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L58
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L58
            r5 = 1
            goto L59
        L58:
            r5 = 0
        L59:
            r4.data(r5, r9, r11, r3)
            goto Ld
        L5d:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L6a:
            monitor-exit(r8)
            throw r9
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public final void writeHeaders$okhttp(int i, boolean z, @NotNull List alternating) throws IOException {
        l.e(alternating, "alternating");
        this.writer.headers(z, i, alternating);
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i, @NotNull ErrorCode statusCode) throws IOException {
        l.e(statusCode, "statusCode");
        this.writer.rstStream(i, statusCode);
    }

    public final void writeSynResetLater$okhttp(int i, @NotNull ErrorCode errorCode) {
        l.e(errorCode, "errorCode");
        TaskQueue taskQueue = this.writerQueue;
        String str = this.connectionName + '[' + i + "] writeSynReset";
        taskQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$1(str, true, str, true, this, i, errorCode), 0L);
    }

    public final void writeWindowUpdateLater$okhttp(int i, long j) {
        TaskQueue taskQueue = this.writerQueue;
        String str = this.connectionName + '[' + i + "] windowUpdate";
        taskQueue.schedule(new Http2Connection$writeWindowUpdateLater$$inlined$execute$1(str, true, str, true, this, i, j), 0L);
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List requestHeaders, boolean z) throws IOException {
        l.e(requestHeaders, "requestHeaders");
        return newStream(0, requestHeaders, z);
    }

    public final void start(boolean z) throws IOException {
        start$default(this, z, null, 2, null);
    }

    public final void writePing(boolean z, int i, int i2) {
        try {
            this.writer.ping(z, i, i2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void start(boolean z, @NotNull TaskRunner taskRunner) throws IOException {
        l.e(taskRunner, "taskRunner");
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            if (this.okHttpSettings.getInitialWindowSize() != 65535) {
                this.writer.windowUpdate(0, r7 - 65535);
            }
        }
        TaskQueue newQueue = taskRunner.newQueue();
        String str = this.connectionName;
        newQueue.schedule(new TaskQueue.1(this.readerRunnable, str, true, str, true), 0L);
    }
}
