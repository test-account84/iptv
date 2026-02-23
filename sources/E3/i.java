package E3;

import B3.Y;
import O2.A0;
import O2.z0;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements Y {
    public final z0 a;
    public long[] d;
    public boolean e;
    public F3.f f;
    public boolean g;
    public int h;
    public final s3.c c = new s3.c();
    public long i = -9223372036854775807L;

    public i(F3.f fVar, z0 z0Var, boolean z) {
        this.a = z0Var;
        this.f = fVar;
        this.d = fVar.b;
        d(fVar, z);
    }

    public String b() {
        return this.f.a();
    }

    public void c(long j) {
        int e = k0.e(this.d, j, true, false);
        this.h = e;
        if (!this.e || e != this.d.length) {
            j = -9223372036854775807L;
        }
        this.i = j;
    }

    public void d(F3.f fVar, boolean z) {
        int i = this.h;
        long j = i == 0 ? -9223372036854775807L : this.d[i - 1];
        this.e = z;
        this.f = fVar;
        long[] jArr = fVar.b;
        this.d = jArr;
        long j2 = this.i;
        if (j2 != -9223372036854775807L) {
            c(j2);
        } else if (j != -9223372036854775807L) {
            this.h = k0.e(jArr, j, false, false);
        }
    }

    public boolean e() {
        return true;
    }

    public int n(long j) {
        int max = Math.max(this.h, k0.e(this.d, j, true, false));
        int i = max - this.h;
        this.h = max;
        return i;
    }

    public int q(A0 a0, U2.g gVar, int i) {
        int i2 = this.h;
        boolean z = i2 == this.d.length;
        if (z && !this.e) {
            gVar.setFlags(4);
            return -4;
        }
        if ((i & 2) != 0 || !this.g) {
            a0.b = this.a;
            this.g = true;
            return -5;
        }
        if (z) {
            return -3;
        }
        if ((i & 1) == 0) {
            this.h = i2 + 1;
        }
        if ((i & 4) == 0) {
            byte[] a = this.c.a(this.f.a[i2]);
            gVar.e(a.length);
            gVar.d.put(a);
        }
        gVar.f = this.d[i2];
        gVar.setFlags(1);
        return -4;
    }

    public void a() {
    }
}
