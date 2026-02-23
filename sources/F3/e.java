package f3;

import com.google.android.exoplayer2.extractor.g;
import d3.j;
import d3.u;
import d3.w;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public final w a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long[] k;
    public int[] l;

    public e(int i, int i2, long j, int i3, w wVar) {
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        d4.a.a(z);
        this.d = j;
        this.e = i3;
        this.a = wVar;
        this.b = d(i, i2 == 2 ? 1667497984 : 1651965952);
        this.c = i2 == 2 ? d(i, 1650720768) : -1;
        this.k = new long[512];
        this.l = new int[512];
    }

    public static int d(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    public void a() {
        this.h++;
    }

    public void b(long j) {
        if (this.j == this.l.length) {
            long[] jArr = this.k;
            this.k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.l;
            this.l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.k;
        int i = this.j;
        jArr2[i] = j;
        this.l[i] = this.i;
        this.j = i + 1;
    }

    public void c() {
        this.k = Arrays.copyOf(this.k, this.j);
        this.l = Arrays.copyOf(this.l, this.j);
    }

    public final long e(int i) {
        return (this.d * i) / this.e;
    }

    public long f() {
        return e(this.h);
    }

    public long g() {
        return e(1);
    }

    public final u h(int i) {
        return new u(this.l[i] * g(), this.k[i]);
    }

    public g.a i(long j) {
        int g = (int) (j / g());
        int h = k0.h(this.l, g, true, true);
        if (this.l[h] == g) {
            return new g.a(h(h));
        }
        u h2 = h(h);
        int i = h + 1;
        return i < this.k.length ? new g.a(h2, h(i)) : new g.a(h2);
    }

    public boolean j(int i) {
        return this.b == i || this.c == i;
    }

    public void k() {
        this.i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.l, this.h) >= 0;
    }

    public boolean m(j jVar) {
        int i = this.g;
        int a = i - this.a.a(jVar, i, false);
        this.g = a;
        boolean z = a == 0;
        if (z) {
            if (this.f > 0) {
                this.a.f(f(), l() ? 1 : 0, this.f, 0, null);
            }
            a();
        }
        return z;
    }

    public void n(int i) {
        this.f = i;
        this.g = i;
    }

    public void o(long j) {
        int i;
        if (this.j == 0) {
            i = 0;
        } else {
            i = this.l[k0.i(this.k, j, true, true)];
        }
        this.h = i;
    }
}
