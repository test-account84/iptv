package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class FramedStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    private final FramedConnection connection;
    private final int id;
    private final List requestHeaders;
    private List responseHeaders;
    final FramedDataSink sink;
    private final FramedDataSource source;
    long unacknowledgedBytesRead = 0;
    private final StreamTimeout readTimeout = new StreamTimeout();
    private final StreamTimeout writeTimeout = new StreamTimeout();
    private ErrorCode errorCode = null;

    public final class FramedDataSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer = new Buffer();

        public FramedDataSink() {
        }

        public static /* synthetic */ boolean access$200(FramedDataSink framedDataSink) {
            return framedDataSink.finished;
        }

        public static /* synthetic */ boolean access$202(FramedDataSink framedDataSink, boolean z) {
            framedDataSink.finished = z;
            return z;
        }

        public static /* synthetic */ boolean access$400(FramedDataSink framedDataSink) {
            return framedDataSink.closed;
        }

        private void emitDataFrame(boolean z) throws IOException {
            long min;
            FramedStream framedStream;
            synchronized (FramedStream.this) {
                FramedStream.access$1100(FramedStream.this).enter();
                while (true) {
                    try {
                        FramedStream framedStream2 = FramedStream.this;
                        if (framedStream2.bytesLeftInWriteWindow > 0 || this.finished || this.closed || FramedStream.access$800(framedStream2) != null) {
                            break;
                        } else {
                            FramedStream.access$900(FramedStream.this);
                        }
                    } finally {
                        FramedStream.access$1100(FramedStream.this).exitAndThrowIfTimedOut();
                    }
                }
                FramedStream.access$1100(FramedStream.this).exitAndThrowIfTimedOut();
                FramedStream.access$1200(FramedStream.this);
                min = Math.min(FramedStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                framedStream = FramedStream.this;
                framedStream.bytesLeftInWriteWindow -= min;
            }
            FramedStream.access$1100(framedStream).enter();
            try {
                FramedStream.access$500(FramedStream.this).writeData(FramedStream.access$600(FramedStream.this), z && min == this.sendBuffer.size(), this.sendBuffer, min);
            } catch (Throwable th) {
                throw th;
            }
        }

        public void close() throws IOException {
            synchronized (FramedStream.this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    if (!FramedStream.this.sink.finished) {
                        if (this.sendBuffer.size() > 0) {
                            while (this.sendBuffer.size() > 0) {
                                emitDataFrame(true);
                            }
                        } else {
                            FramedStream.access$500(FramedStream.this).writeData(FramedStream.access$600(FramedStream.this), true, null, 0L);
                        }
                    }
                    synchronized (FramedStream.this) {
                        this.closed = true;
                    }
                    FramedStream.access$500(FramedStream.this).flush();
                    FramedStream.access$1000(FramedStream.this);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void flush() throws IOException {
            synchronized (FramedStream.this) {
                FramedStream.access$1200(FramedStream.this);
            }
            while (this.sendBuffer.size() > 0) {
                emitDataFrame(false);
                FramedStream.access$500(FramedStream.this).flush();
            }
        }

        public Timeout timeout() {
            return FramedStream.access$1100(FramedStream.this);
        }

        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitDataFrame(false);
            }
        }
    }

    public final class FramedDataSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        private FramedDataSource(long j) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = j;
        }

        public static /* synthetic */ boolean access$100(FramedDataSource framedDataSource) {
            return framedDataSource.finished;
        }

        public static /* synthetic */ boolean access$102(FramedDataSource framedDataSource, boolean z) {
            framedDataSource.finished = z;
            return z;
        }

        public static /* synthetic */ boolean access$300(FramedDataSource framedDataSource) {
            return framedDataSource.closed;
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            }
            if (FramedStream.access$800(FramedStream.this) == null) {
                return;
            }
            throw new IOException("stream was reset: " + FramedStream.access$800(FramedStream.this));
        }

        private void waitUntilReadable() throws IOException {
            FramedStream.access$700(FramedStream.this).enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && FramedStream.access$800(FramedStream.this) == null) {
                try {
                    FramedStream.access$900(FramedStream.this);
                } finally {
                    FramedStream.access$700(FramedStream.this).exitAndThrowIfTimedOut();
                }
            }
        }

        public void close() throws IOException {
            synchronized (FramedStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                FramedStream.this.notifyAll();
            }
            FramedStream.access$1000(FramedStream.this);
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (FramedStream.this) {
                try {
                    waitUntilReadable();
                    checkNotClosed();
                    if (this.readBuffer.size() == 0) {
                        return -1L;
                    }
                    Buffer buffer2 = this.readBuffer;
                    long read = buffer2.read(buffer, Math.min(j, buffer2.size()));
                    FramedStream framedStream = FramedStream.this;
                    long j2 = framedStream.unacknowledgedBytesRead + read;
                    framedStream.unacknowledgedBytesRead = j2;
                    if (j2 >= FramedStream.access$500(framedStream).okHttpSettings.getInitialWindowSize(65536) / 2) {
                        FramedStream.access$500(FramedStream.this).writeWindowUpdateLater(FramedStream.access$600(FramedStream.this), FramedStream.this.unacknowledgedBytesRead);
                        FramedStream.this.unacknowledgedBytesRead = 0L;
                    }
                    synchronized (FramedStream.access$500(FramedStream.this)) {
                        try {
                            FramedStream.access$500(FramedStream.this).unacknowledgedBytesRead += read;
                            if (FramedStream.access$500(FramedStream.this).unacknowledgedBytesRead >= FramedStream.access$500(FramedStream.this).okHttpSettings.getInitialWindowSize(65536) / 2) {
                                FramedStream.access$500(FramedStream.this).writeWindowUpdateLater(0, FramedStream.access$500(FramedStream.this).unacknowledgedBytesRead);
                                FramedStream.access$500(FramedStream.this).unacknowledgedBytesRead = 0L;
                            }
                        } finally {
                        }
                    }
                    return read;
                } finally {
                }
            }
        }

        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            while (j > 0) {
                synchronized (FramedStream.this) {
                    z = this.finished;
                    z2 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z2) {
                    bufferedSource.skip(j);
                    FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long read = bufferedSource.read(this.receiveBuffer, j);
                if (read == -1) {
                    throw new EOFException();
                }
                j -= read;
                synchronized (FramedStream.this) {
                    try {
                        boolean z3 = this.readBuffer.size() == 0;
                        this.readBuffer.writeAll(this.receiveBuffer);
                        if (z3) {
                            FramedStream.this.notifyAll();
                        }
                    } finally {
                    }
                }
            }
        }

        public Timeout timeout() {
            return FramedStream.access$700(FramedStream.this);
        }

        public /* synthetic */ FramedDataSource(FramedStream framedStream, long j, 1 r4) {
            this(j);
        }
    }

    public class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void timedOut() {
            FramedStream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    public FramedStream(int i, FramedConnection framedConnection, boolean z, boolean z2, List list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.id = i;
        this.connection = framedConnection;
        this.bytesLeftInWriteWindow = framedConnection.peerSettings.getInitialWindowSize(65536);
        FramedDataSource framedDataSource = new FramedDataSource(this, framedConnection.okHttpSettings.getInitialWindowSize(65536), null);
        this.source = framedDataSource;
        FramedDataSink framedDataSink = new FramedDataSink();
        this.sink = framedDataSink;
        FramedDataSource.access$102(framedDataSource, z2);
        FramedDataSink.access$202(framedDataSink, z);
        this.requestHeaders = list;
    }

    public static /* synthetic */ void access$1000(FramedStream framedStream) throws IOException {
        framedStream.cancelStreamIfNecessary();
    }

    public static /* synthetic */ StreamTimeout access$1100(FramedStream framedStream) {
        return framedStream.writeTimeout;
    }

    public static /* synthetic */ void access$1200(FramedStream framedStream) throws IOException {
        framedStream.checkOutNotClosed();
    }

    public static /* synthetic */ FramedConnection access$500(FramedStream framedStream) {
        return framedStream.connection;
    }

    public static /* synthetic */ int access$600(FramedStream framedStream) {
        return framedStream.id;
    }

    public static /* synthetic */ StreamTimeout access$700(FramedStream framedStream) {
        return framedStream.readTimeout;
    }

    public static /* synthetic */ ErrorCode access$800(FramedStream framedStream) {
        return framedStream.errorCode;
    }

    public static /* synthetic */ void access$900(FramedStream framedStream) throws InterruptedIOException {
        framedStream.waitForIo();
    }

    private void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            try {
                z = !FramedDataSource.access$100(this.source) && FramedDataSource.access$300(this.source) && (FramedDataSink.access$200(this.sink) || FramedDataSink.access$400(this.sink));
                isOpen = isOpen();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else {
            if (isOpen) {
                return;
            }
            this.connection.removeStream(this.id);
        }
    }

    private void checkOutNotClosed() throws IOException {
        if (FramedDataSink.access$400(this.sink)) {
            throw new IOException("stream closed");
        }
        if (FramedDataSink.access$200(this.sink)) {
            throw new IOException("stream finished");
        }
        if (this.errorCode == null) {
            return;
        }
        throw new IOException("stream was reset: " + this.errorCode);
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.errorCode != null) {
                    return false;
                }
                if (FramedDataSource.access$100(this.source) && FramedDataSink.access$200(this.sink)) {
                    return false;
                }
                this.errorCode = errorCode;
                notifyAll();
                this.connection.removeStream(this.id);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    public FramedConnection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public List getRequestHeaders() {
        return this.requestHeaders;
    }

    public synchronized List getResponseHeaders() throws IOException {
        List list;
        try {
            this.readTimeout.enter();
            while (this.responseHeaders == null && this.errorCode == null) {
                try {
                    waitForIo();
                } catch (Throwable th) {
                    this.readTimeout.exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            this.readTimeout.exitAndThrowIfTimedOut();
            list = this.responseHeaders;
            if (list == null) {
                throw new IOException("stream was reset: " + this.errorCode);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return list;
    }

    public Sink getSink() {
        synchronized (this) {
            try {
                if (this.responseHeaders == null && !isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            if (FramedDataSource.access$100(this.source) || FramedDataSource.access$300(this.source)) {
                if (FramedDataSink.access$200(this.sink) || FramedDataSink.access$400(this.sink)) {
                    if (this.responseHeaders != null) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        this.source.receive(bufferedSource, i);
    }

    public void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            FramedDataSource.access$102(this.source, true);
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    public void receiveHeaders(List list, HeadersMode headersMode) {
        ErrorCode errorCode;
        boolean z;
        synchronized (this) {
            try {
                errorCode = null;
                z = true;
                if (this.responseHeaders == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.responseHeaders = list;
                        z = isOpen();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.responseHeaders);
                    arrayList.addAll(list);
                    this.responseHeaders = arrayList;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (errorCode != null) {
            closeLater(errorCode);
        } else {
            if (z) {
                return;
            }
            this.connection.removeStream(this.id);
        }
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public void reply(List list, boolean z) throws IOException {
        boolean z2;
        synchronized (this) {
            try {
                if (list == null) {
                    throw new NullPointerException("responseHeaders == null");
                }
                if (this.responseHeaders != null) {
                    throw new IllegalStateException("reply already sent");
                }
                this.responseHeaders = list;
                if (z) {
                    z2 = false;
                } else {
                    z2 = true;
                    FramedDataSink.access$202(this.sink, true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.connection.writeSynReply(this.id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
