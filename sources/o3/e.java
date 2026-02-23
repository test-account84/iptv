package o3;

import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements g {
    public final c a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    public e(c cVar, int i, long j, long j2) {
        this.a = cVar;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / cVar.e;
        this.d = j3;
        this.e = a(j3);
    }

    public final long a(long j) {
        return k0.c1(j * this.b, 1000000L, this.a.c);
    }

    public g.a e(long j) {
        long s = k0.s((this.a.c * j) / (this.b * 1000000), 0L, this.d - 1);
        long j2 = this.c + (this.a.e * s);
        long a = a(s);
        u uVar = new u(a, j2);
        if (a >= j || s == this.d - 1) {
            return new g.a(uVar);
        }
        long j3 = s + 1;
        return new g.a(uVar, new u(a(j3), this.c + (this.a.e * j3)));
    }

    public boolean g() {
        return true;
    }

    public long i() {
        return this.e;
    }
}
