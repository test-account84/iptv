package k3;

import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.C;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements g {
    public final long a;
    public final C b;
    public final C c;
    public long d;

    public b(long j, long j2, long j3) {
        this.d = j;
        this.a = j3;
        C c = new C();
        this.b = c;
        C c2 = new C();
        this.c = c2;
        c.a(0L);
        c2.a(j2);
    }

    public boolean a(long j) {
        C c = this.b;
        return j - c.b(c.c() - 1) < 100000;
    }

    public void b(long j, long j2) {
        if (a(j)) {
            return;
        }
        this.b.a(j);
        this.c.a(j2);
    }

    public long c(long j) {
        return this.b.b(k0.f(this.c, j, true, true));
    }

    public void d(long j) {
        this.d = j;
    }

    public g.a e(long j) {
        int f = k0.f(this.b, j, true, true);
        u uVar = new u(this.b.b(f), this.c.b(f));
        if (uVar.a == j || f == this.b.c() - 1) {
            return new g.a(uVar);
        }
        int i = f + 1;
        return new g.a(uVar, new u(this.b.b(i), this.c.b(i)));
    }

    public long f() {
        return this.a;
    }

    public boolean g() {
        return true;
    }

    public long i() {
        return this.d;
    }
}
