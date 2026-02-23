package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;

    @NotNull
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public Http2Writer(@NotNull BufferedSink sink, boolean z) {
        l.e(sink, "sink");
        this.sink = sink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i, long j) throws IOException {
        while (j > 0) {
            long min = Math.min(this.maxFrameSize, j);
            j -= min;
            frameHeader(i, (int) min, 9, j == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(@NotNull Settings peerSettings) throws IOException {
        try {
            l.e(peerSettings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void data(boolean z, int i, @Nullable Buffer buffer, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i, z ? 1 : 0, buffer, i2);
    }

    public final void dataFrame(int i, int i2, @Nullable Buffer buffer, int i3) throws IOException {
        frameHeader(i, i3, 0, i2);
        if (i3 > 0) {
            BufferedSink bufferedSink = this.sink;
            l.b(buffer);
            bufferedSink.write(buffer, i3);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i, int i2, int i3, int i4) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i, i2, i3, i4));
        }
        if (!(i2 <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i2).toString());
        }
        if (!((((int) 2147483648L) & i) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + i).toString());
        }
        Util.writeMedium(this.sink, i2);
        this.sink.writeByte(i3 & 255);
        this.sink.writeByte(i4 & 255);
        this.sink.writeInt(i & Integer.MAX_VALUE);
    }

    @NotNull
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i, @NotNull ErrorCode errorCode, @NotNull byte[] debugData) throws IOException {
        try {
            l.e(errorCode, "errorCode");
            l.e(debugData, "debugData");
            if (this.closed) {
                throw new IOException("closed");
            }
            if (!(errorCode.getHttpCode() != -1)) {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
            frameHeader(0, debugData.length + 8, 7, 0);
            this.sink.writeInt(i);
            this.sink.writeInt(errorCode.getHttpCode());
            if (!(debugData.length == 0)) {
                this.sink.write(debugData);
            }
            this.sink.flush();
        } finally {
        }
    }

    public final synchronized void headers(boolean z, int i, @NotNull List headerBlock) throws IOException {
        l.e(headerBlock, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(headerBlock);
        long size = this.hpackBuffer.size();
        long min = Math.min(this.maxFrameSize, size);
        int i2 = size == min ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        frameHeader(i, (int) min, 1, i2);
        this.sink.write(this.hpackBuffer, min);
        if (size > min) {
            writeContinuationFrames(i, size - min);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z ? 1 : 0);
        this.sink.writeInt(i);
        this.sink.writeInt(i2);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i, int i2, @NotNull List requestHeaders) throws IOException {
        l.e(requestHeaders, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(requestHeaders);
        long size = this.hpackBuffer.size();
        int min = (int) Math.min(this.maxFrameSize - 4, size);
        long j = min;
        frameHeader(i, min + 4, 5, size == j ? 4 : 0);
        this.sink.writeInt(i2 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j);
        if (size > j) {
            writeContinuationFrames(i, size - j);
        }
    }

    public final synchronized void rstStream(int i, @NotNull ErrorCode errorCode) throws IOException {
        l.e(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        frameHeader(i, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(@NotNull Settings settings) throws IOException {
        try {
            l.e(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i < 10) {
                if (settings.isSet(i)) {
                    this.sink.writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                    this.sink.writeInt(settings.get(i));
                }
                i++;
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(j != 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        frameHeader(i, 4, 8, 0);
        this.sink.writeInt((int) j);
        this.sink.flush();
    }
}
