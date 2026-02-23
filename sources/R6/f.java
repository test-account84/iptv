package R6;

import java.util.Formatter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f {
    public final a a;
    public final g[] b;
    public c c;
    public final int d;

    public f(a aVar, c cVar) {
        this.a = aVar;
        int a = aVar.a();
        this.d = a;
        this.c = cVar;
        this.b = new g[a + 2];
    }

    public static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    public static int c(int i, int i2, d dVar) {
        if (dVar == null) {
            return i2;
        }
        if (dVar.g()) {
            return i2;
        }
        if (!dVar.h(i)) {
            return i2 + 1;
        }
        dVar.i(i);
        return 0;
    }

    public final void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).g(this.a);
        }
    }

    public final int d() {
        int f = f();
        if (f == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            d[] d = this.b[i].d();
            for (int i2 = 0; i2 < d.length; i2++) {
                d dVar = d[i2];
                if (dVar != null && !dVar.g()) {
                    e(i, i2, d);
                }
            }
        }
        return f;
    }

    public final void e(int i, int i2, d[] dVarArr) {
        d dVar = dVarArr[i2];
        d[] d = this.b[i - 1].d();
        g gVar = this.b[i + 1];
        d[] d2 = gVar != null ? gVar.d() : d;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = d[i2];
        dVarArr2[3] = d2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            dVarArr2[0] = dVarArr[i3];
            dVarArr2[4] = d[i3];
            dVarArr2[5] = d2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            dVarArr2[8] = dVarArr[i4];
            dVarArr2[10] = d[i4];
            dVarArr2[11] = d2[i4];
        }
        if (i2 < dVarArr.length - 1) {
            int i5 = i2 + 1;
            dVarArr2[1] = dVarArr[i5];
            dVarArr2[6] = d[i5];
            dVarArr2[7] = d2[i5];
        }
        if (i2 < dVarArr.length - 2) {
            int i6 = i2 + 2;
            dVarArr2[9] = dVarArr[i6];
            dVarArr2[12] = d[i6];
            dVarArr2[13] = d2[i6];
        }
        for (int i7 = 0; i7 < 14 && !b(dVar, dVarArr2[i7]); i7++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        g[] gVarArr = this.b;
        g gVar = gVarArr[0];
        if (gVar == null || gVarArr[this.d + 1] == null) {
            return;
        }
        d[] d = gVar.d();
        d[] d2 = this.b[this.d + 1].d();
        for (int i = 0; i < d.length; i++) {
            d dVar = d[i];
            if (dVar != null && d2[i] != null && dVar.c() == d2[i].c()) {
                for (int i2 = 1; i2 <= this.d; i2++) {
                    d dVar2 = this.b[i2].d()[i];
                    if (dVar2 != null) {
                        dVar2.i(d[i].c());
                        if (!dVar2.g()) {
                            this.b[i2].d()[i] = null;
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        g gVar = this.b[0];
        if (gVar == null) {
            return 0;
        }
        d[] d = gVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d.length; i2++) {
            d dVar = d[i2];
            if (dVar != null) {
                int c = dVar.c();
                int i3 = 0;
                for (int i4 = 1; i4 < this.d + 1 && i3 < 2; i4++) {
                    d dVar2 = this.b[i4].d()[i2];
                    if (dVar2 != null) {
                        i3 = c(c, i3, dVar2);
                        if (!dVar2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public final int i() {
        g[] gVarArr = this.b;
        int i = this.d;
        if (gVarArr[i + 1] == null) {
            return 0;
        }
        d[] d = gVarArr[i + 1].d();
        int i2 = 0;
        for (int i3 = 0; i3 < d.length; i3++) {
            d dVar = d[i3];
            if (dVar != null) {
                int c = dVar.c();
                int i4 = 0;
                for (int i5 = this.d + 1; i5 > 0 && i4 < 2; i5--) {
                    d dVar2 = this.b[i5].d()[i3];
                    if (dVar2 != null) {
                        i4 = c(c, i4, dVar2);
                        if (!dVar2.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public int j() {
        return this.d;
    }

    public int k() {
        return this.a.b();
    }

    public int l() {
        return this.a.c();
    }

    public c m() {
        return this.c;
    }

    public g n(int i) {
        return this.b[i];
    }

    public g[] o() {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i = 928;
        while (true) {
            int d = d();
            if (d <= 0 || d >= i) {
                break;
            }
            i = d;
        }
        return this.b;
    }

    public void p(c cVar) {
        this.c = cVar;
    }

    public void q(int i, g gVar) {
        this.b[i] = gVar;
    }

    public String toString() {
        g[] gVarArr = this.b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < gVar.d().length; i++) {
            try {
                formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    g gVar2 = this.b[i2];
                    if (gVar2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = gVar2.d()[i];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e())});
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
