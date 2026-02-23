package e3;

import O2.l1;
import O2.z0;
import com.google.android.exoplayer2.extractor.c;
import com.google.android.exoplayer2.extractor.g;
import d3.i;
import d3.j;
import d3.k;
import d3.o;
import d3.t;
import d3.w;
import d4.k0;
import java.io.EOFException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements i {
    public static final int[] r;
    public static final int u;
    public final byte[] a;
    public final int b;
    public boolean c;
    public long d;
    public int e;
    public int f;
    public boolean g;
    public long h;
    public int i;
    public int j;
    public long k;
    public k l;
    public w m;
    public g n;
    public boolean o;
    public static final o p = new a();
    public static final int[] q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final byte[] s = k0.s0("#!AMR\n");
    public static final byte[] t = k0.s0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        r = iArr;
        u = iArr[8];
    }

    public b() {
        this(0);
    }

    public static /* synthetic */ i[] c() {
        return m();
    }

    public static int f(int i, long j) {
        return (int) ((i * 8000000) / j);
    }

    private static /* synthetic */ i[] m() {
        return new i[]{new b()};
    }

    public static boolean p(j jVar, byte[] bArr) {
        jVar.f();
        byte[] bArr2 = new byte[bArr.length];
        jVar.s(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    public void a(long j, long j2) {
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        if (j != 0) {
            g gVar = this.n;
            if (gVar instanceof c) {
                this.k = ((c) gVar).b(j);
                return;
            }
        }
        this.k = 0L;
    }

    public void b(k kVar) {
        this.l = kVar;
        this.m = kVar.e(0, 1);
        kVar.q();
    }

    public int d(j jVar, t tVar) {
        e();
        if (jVar.getPosition() == 0 && !r(jVar)) {
            throw l1.a("Could not find AMR header.", null);
        }
        n();
        int s2 = s(jVar);
        o(jVar.getLength(), s2);
        return s2;
    }

    public final void e() {
        d4.a.i(this.m);
        k0.j(this.l);
    }

    public final g g(long j, boolean z) {
        return new c(j, this.h, f(this.i, 20000L), this.i, z);
    }

    public boolean h(j jVar) {
        return r(jVar);
    }

    public final int i(int i) {
        if (k(i)) {
            return this.c ? r[i] : q[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw l1.a(sb.toString(), null);
    }

    public final boolean j(int i) {
        return !this.c && (i < 12 || i > 14);
    }

    public final boolean k(int i) {
        return i >= 0 && i <= 15 && (l(i) || j(i));
    }

    public final boolean l(int i) {
        return this.c && (i < 10 || i > 13);
    }

    public final void n() {
        if (this.o) {
            return;
        }
        this.o = true;
        boolean z = this.c;
        this.m.d(new z0.b().g0(z ? "audio/amr-wb" : "audio/3gpp").Y(u).J(1).h0(z ? 16000 : 8000).G());
    }

    public final void o(long j, int i) {
        g bVar;
        int i2;
        if (this.g) {
            return;
        }
        int i3 = this.b;
        if ((i3 & 1) == 0 || j == -1 || !((i2 = this.i) == -1 || i2 == this.e)) {
            bVar = new g.b(-9223372036854775807L);
        } else if (this.j < 20 && i != -1) {
            return;
        } else {
            bVar = g(j, (i3 & 2) != 0);
        }
        this.n = bVar;
        this.l.n(bVar);
        this.g = true;
    }

    public final int q(j jVar) {
        jVar.f();
        jVar.s(this.a, 0, 1);
        byte b = this.a[0];
        if ((b & 131) <= 0) {
            return i((b >> 3) & 15);
        }
        throw l1.a("Invalid padding bits for frame header " + b, null);
    }

    public final boolean r(j jVar) {
        int length;
        byte[] bArr = s;
        if (p(jVar, bArr)) {
            this.c = false;
            length = bArr.length;
        } else {
            byte[] bArr2 = t;
            if (!p(jVar, bArr2)) {
                return false;
            }
            this.c = true;
            length = bArr2.length;
        }
        jVar.q(length);
        return true;
    }

    public final int s(j jVar) {
        if (this.f == 0) {
            try {
                int q2 = q(jVar);
                this.e = q2;
                this.f = q2;
                if (this.i == -1) {
                    this.h = jVar.getPosition();
                    this.i = this.e;
                }
                if (this.i == this.e) {
                    this.j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int a = this.m.a(jVar, this.f, true);
        if (a == -1) {
            return -1;
        }
        int i = this.f - a;
        this.f = i;
        if (i > 0) {
            return 0;
        }
        this.m.f(this.k + this.d, 1, this.e, 0, null);
        this.d += 20000;
        return 0;
    }

    public b(int i) {
        this.b = (i & 2) != 0 ? i | 1 : i;
        this.a = new byte[1];
        this.i = -1;
    }

    public void release() {
    }
}
