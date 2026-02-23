package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.l;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(@NotNull BufferedSink sink, @NotNull Deflater deflater) {
        l.e(sink, "sink");
        l.e(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    @IgnoreJRERequirement
    private final void deflate(boolean z) {
        Segment writableSegment$okio;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            Deflater deflater = this.deflater;
            byte[] bArr = writableSegment$okio.data;
            int i = writableSegment$okio.limit;
            int i2 = 8192 - i;
            int deflate = z ? deflater.deflate(bArr, i, i2, 2) : deflater.deflate(bArr, i, i2);
            if (deflate > 0) {
                writableSegment$okio.limit += deflate;
                buffer.setSize$okio(buffer.size() + deflate);
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        try {
            finishDeflate$okio();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    public void write(@NotNull Buffer source, long j) throws IOException {
        l.e(source, "source");
        -Util.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment = source.head;
            l.b(segment);
            int min = (int) Math.min(j, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j2 = min;
            source.setSize$okio(source.size() - j2);
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j -= j2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink, @NotNull Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        l.e(sink, "sink");
        l.e(deflater, "deflater");
    }
}
