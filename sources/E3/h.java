package E3;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements f {
    public final com.google.android.exoplayer2.extractor.b a;
    public final long b;

    public h(com.google.android.exoplayer2.extractor.b bVar, long j) {
        this.a = bVar;
        this.b = j;
    }

    public long c(long j) {
        return this.a.e[(int) j] - this.b;
    }

    public long d(long j, long j2) {
        return this.a.d[(int) j];
    }

    public long e(long j, long j2) {
        return 0L;
    }

    public long f(long j, long j2) {
        return -9223372036854775807L;
    }

    public F3.i g(long j) {
        return new F3.i(null, this.a.c[(int) j], r0.b[r9]);
    }

    public long h(long j, long j2) {
        return this.a.a(j + this.b);
    }

    public long i(long j) {
        return this.a.a;
    }

    public boolean j() {
        return true;
    }

    public long k() {
        return 0L;
    }

    public long l(long j, long j2) {
        return this.a.a;
    }
}
