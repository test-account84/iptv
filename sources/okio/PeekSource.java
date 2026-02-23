package okio;

import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(@NotNull BufferedSource upstream) {
        l.e(upstream, "upstream");
        this.upstream = upstream;
        Buffer buffer = upstream.getBuffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(@org.jetbrains.annotations.NotNull okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.l.e(r9, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 < 0) goto Lf
            r5 = 1
            goto L10
        Lf:
            r5 = 0
        L10:
            if (r5 == 0) goto L87
            boolean r5 = r8.closed
            r5 = r5 ^ r1
            if (r5 == 0) goto L7b
            okio.Segment r5 = r8.expectedSegment
            if (r5 == 0) goto L2a
            okio.Buffer r6 = r8.buffer
            okio.Segment r6 = r6.head
            if (r5 != r6) goto L2b
            int r5 = r8.expectedPos
            kotlin.jvm.internal.l.b(r6)
            int r6 = r6.pos
            if (r5 != r6) goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L6f
            if (r4 != 0) goto L30
            return r2
        L30:
            okio.BufferedSource r0 = r8.upstream
            long r1 = r8.pos
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L40
            r9 = -1
            return r9
        L40:
            okio.Segment r0 = r8.expectedSegment
            if (r0 != 0) goto L53
            okio.Buffer r0 = r8.buffer
            okio.Segment r0 = r0.head
            if (r0 == 0) goto L53
            r8.expectedSegment = r0
            kotlin.jvm.internal.l.b(r0)
            int r0 = r0.pos
            r8.expectedPos = r0
        L53:
            okio.Buffer r0 = r8.buffer
            long r0 = r0.size()
            long r2 = r8.pos
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.buffer
            long r4 = r8.pos
            r3 = r9
            r6 = r10
            r2.copyTo(r3, r4, r6)
            long r0 = r8.pos
            long r0 = r0 + r10
            r8.pos = r0
            return r10
        L6f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L7b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L87:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    @NotNull
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
