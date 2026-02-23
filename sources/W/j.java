package w;

import java.util.Arrays;
import w.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j implements b.a {
    public static float n = 0.001f;
    public final int a = -1;
    public int b = 16;
    public int c = 16;
    public int[] d = new int[16];
    public int[] e = new int[16];
    public int[] f = new int[16];
    public float[] g = new float[16];
    public int[] h = new int[16];
    public int[] i = new int[16];
    public int j = 0;
    public int k = -1;
    public final b l;
    public final c m;

    public j(b bVar, c cVar) {
        this.l = bVar;
        this.m = cVar;
        clear();
    }

    public boolean a(i iVar) {
        return p(iVar) != -1;
    }

    public i b(int i) {
        int i2 = this.j;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.k;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.m.d[this.f[i3]];
            }
            i3 = this.i[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    public void c() {
        int i = this.j;
        int i2 = this.k;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.g;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.i[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    public void clear() {
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            i b = b(i2);
            if (b != null) {
                b.c(this.l);
            }
        }
        for (int i3 = 0; i3 < this.b; i3++) {
            this.f[i3] = -1;
            this.e[i3] = -1;
        }
        for (int i4 = 0; i4 < this.c; i4++) {
            this.d[i4] = -1;
        }
        this.j = 0;
        this.k = -1;
    }

    public void d(i iVar, float f) {
        float f2 = n;
        if (f > (-f2) && f < f2) {
            g(iVar, true);
            return;
        }
        if (this.j == 0) {
            m(0, iVar, f);
            l(iVar, 0);
            this.k = 0;
            return;
        }
        int p = p(iVar);
        if (p != -1) {
            this.g[p] = f;
            return;
        }
        if (this.j + 1 >= this.b) {
            o();
        }
        int i = this.j;
        int i2 = this.k;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = this.f[i2];
            int i6 = iVar.c;
            if (i5 == i6) {
                this.g[i2] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i2;
            }
            i2 = this.i[i2];
            if (i2 == -1) {
                break;
            }
        }
        q(i3, iVar, f);
    }

    public float e(b bVar, boolean z) {
        float f = f(bVar.a);
        g(bVar.a, z);
        j jVar = (j) bVar.e;
        int i = jVar.i();
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = jVar.f[i3];
            if (i4 != -1) {
                h(this.m.d[i4], jVar.g[i3] * f, z);
                i2++;
            }
            i3++;
        }
        return f;
    }

    public float f(i iVar) {
        int p = p(iVar);
        if (p != -1) {
            return this.g[p];
        }
        return 0.0f;
    }

    public float g(i iVar, boolean z) {
        int p = p(iVar);
        if (p == -1) {
            return 0.0f;
        }
        r(iVar);
        float f = this.g[p];
        if (this.k == p) {
            this.k = this.i[p];
        }
        this.f[p] = -1;
        int[] iArr = this.h;
        int i = iArr[p];
        if (i != -1) {
            int[] iArr2 = this.i;
            iArr2[i] = iArr2[p];
        }
        int i2 = this.i[p];
        if (i2 != -1) {
            iArr[i2] = iArr[p];
        }
        this.j--;
        iVar.m--;
        if (z) {
            iVar.c(this.l);
        }
        return f;
    }

    public void h(i iVar, float f, boolean z) {
        float f2 = n;
        if (f <= (-f2) || f >= f2) {
            int p = p(iVar);
            if (p == -1) {
                d(iVar, f);
                return;
            }
            float[] fArr = this.g;
            float f3 = fArr[p] + f;
            fArr[p] = f3;
            float f4 = n;
            if (f3 <= (-f4) || f3 >= f4) {
                return;
            }
            fArr[p] = 0.0f;
            g(iVar, z);
        }
    }

    public int i() {
        return this.j;
    }

    public float j(int i) {
        int i2 = this.j;
        int i3 = this.k;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.g[i3];
            }
            i3 = this.i[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public void k(float f) {
        int i = this.j;
        int i2 = this.k;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.g;
            fArr[i2] = fArr[i2] / f;
            i2 = this.i[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    public final void l(i iVar, int i) {
        int[] iArr;
        int i2 = iVar.c % this.c;
        int[] iArr2 = this.d;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.e;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            iArr[i3] = i;
        }
        this.e[i] = -1;
    }

    public final void m(int i, i iVar, float f) {
        this.f[i] = iVar.c;
        this.g[i] = f;
        this.h[i] = -1;
        this.i[i] = -1;
        iVar.a(this.l);
        iVar.m++;
        this.j++;
    }

    public final int n() {
        for (int i = 0; i < this.b; i++) {
            if (this.f[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    public final void o() {
        int i = this.b * 2;
        this.f = Arrays.copyOf(this.f, i);
        this.g = Arrays.copyOf(this.g, i);
        this.h = Arrays.copyOf(this.h, i);
        this.i = Arrays.copyOf(this.i, i);
        this.e = Arrays.copyOf(this.e, i);
        for (int i2 = this.b; i2 < i; i2++) {
            this.f[i2] = -1;
            this.e[i2] = -1;
        }
        this.b = i;
    }

    public int p(i iVar) {
        if (this.j == 0) {
            return -1;
        }
        int i = iVar.c;
        int i2 = this.d[i % this.c];
        if (i2 == -1) {
            return -1;
        }
        if (this.f[i2] == i) {
            return i2;
        }
        do {
            i2 = this.e[i2];
            if (i2 == -1) {
                break;
            }
        } while (this.f[i2] != i);
        if (i2 != -1 && this.f[i2] == i) {
            return i2;
        }
        return -1;
    }

    public final void q(int i, i iVar, float f) {
        int n2 = n();
        m(n2, iVar, f);
        if (i != -1) {
            this.h[n2] = i;
            int[] iArr = this.i;
            iArr[n2] = iArr[i];
            iArr[i] = n2;
        } else {
            this.h[n2] = -1;
            if (this.j > 0) {
                this.i[n2] = this.k;
                this.k = n2;
            } else {
                this.i[n2] = -1;
            }
        }
        int i2 = this.i[n2];
        if (i2 != -1) {
            this.h[i2] = n2;
        }
        l(iVar, n2);
    }

    public final void r(i iVar) {
        int[] iArr;
        int i;
        int i2 = iVar.c;
        int i3 = i2 % this.c;
        int[] iArr2 = this.d;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            return;
        }
        if (this.f[i4] == i2) {
            int[] iArr3 = this.e;
            iArr2[i3] = iArr3[i4];
            iArr3[i4] = -1;
            return;
        }
        while (true) {
            iArr = this.e;
            i = iArr[i4];
            if (i == -1 || this.f[i] == i2) {
                break;
            } else {
                i4 = i;
            }
        }
        if (i == -1 || this.f[i] != i2) {
            return;
        }
        iArr[i4] = iArr[i];
        iArr[i] = -1;
    }

    public String toString() {
        StringBuilder sb;
        String str = hashCode() + " { ";
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            i b = b(i2);
            if (b != null) {
                String str2 = str + b + " = " + j(i2) + " ";
                int p = p(b);
                String str3 = str2 + "[p: ";
                if (this.h[p] != -1) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(this.m.d[this.f[this.h[p]]]);
                } else {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append("none");
                }
                String str4 = sb.toString() + ", n: ";
                str = (this.i[p] != -1 ? str4 + this.m.d[this.f[this.i[p]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
