package w;

import java.util.ArrayList;
import java.util.Iterator;
import w.d;
import w.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements d.a {
    public a e;
    public i a = null;
    public float b = 0.0f;
    public boolean c = false;
    public ArrayList d = new ArrayList();
    public boolean f = false;

    public interface a {
        boolean a(i iVar);

        i b(int i);

        void c();

        void clear();

        void d(i iVar, float f);

        float e(b bVar, boolean z);

        float f(i iVar);

        float g(i iVar, boolean z);

        void h(i iVar, float f, boolean z);

        int i();

        float j(int i);

        void k(float f);
    }

    public b() {
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    public java.lang.String A() {
        /*
            r10 = this;
            w.i r0 = r10.a
            java.lang.String r1 = ""
            if (r0 != 0) goto L18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
        L13:
            java.lang.String r0 = r0.toString()
            goto L26
        L18:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            w.i r1 = r10.a
            r0.append(r1)
            goto L13
        L26:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L53
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L54
        L53:
            r1 = 0
        L54:
            w.b$a r5 = r10.e
            int r5 = r5.i()
        L5a:
            if (r2 >= r5) goto Ld6
            w.b$a r6 = r10.e
            w.i r6 = r6.b(r2)
            if (r6 != 0) goto L66
            goto Ld3
        L66:
            w.b$a r7 = r10.e
            float r7 = r7.j(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L71
            goto Ld3
        L71:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L91
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto Lae
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
        L87:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r7 = r7 * r9
            goto Lae
        L91:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            if (r8 <= 0) goto La5
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto Lae
        La5:
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            goto L87
        Lae:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto Lc4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        Lb9:
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto Ld2
        Lc4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            goto Lb9
        Ld2:
            r1 = 1
        Ld3:
            int r2 = r2 + 1
            goto L5a
        Ld6:
            if (r1 != 0) goto Le9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        Le9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w.b.A():java.lang.String");
    }

    public void B(d dVar, i iVar, boolean z) {
        if (iVar.g) {
            this.b += iVar.f * this.e.f(iVar);
            this.e.g(iVar, z);
            if (z) {
                iVar.c(this);
            }
        }
    }

    public void C(b bVar, boolean z) {
        this.b += bVar.b * this.e.e(bVar, z);
        if (z) {
            bVar.a.c(this);
        }
    }

    public void D(d dVar) {
        if (dVar.f.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int i = this.e.i();
            for (int i2 = 0; i2 < i; i2++) {
                i b = this.e.b(i2);
                if (b.d != -1 || b.g) {
                    this.d.add(b);
                }
            }
            if (this.d.size() > 0) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar.g) {
                        B(dVar, iVar, true);
                    } else {
                        C(dVar.f[iVar.d], true);
                    }
                }
                this.d.clear();
            } else {
                z = true;
            }
        }
    }

    public i a(d dVar, boolean[] zArr) {
        return x(zArr, null);
    }

    public void b(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.a = null;
            this.e.clear();
            for (int i = 0; i < bVar.e.i(); i++) {
                this.e.h(bVar.e.b(i), bVar.e.j(i), true);
            }
        }
    }

    public void c(i iVar) {
        int i = iVar.e;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.e.d(iVar, f);
    }

    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(d dVar, int i) {
        this.e.d(dVar.o(i, "ep"), 1.0f);
        this.e.d(dVar.o(i, "em"), -1.0f);
        return this;
    }

    public b e(i iVar, int i) {
        this.e.d(iVar, i);
        return this;
    }

    public boolean f(d dVar) {
        boolean z;
        i g = g(dVar);
        if (g == null) {
            z = true;
        } else {
            y(g);
            z = false;
        }
        if (this.e.i() == 0) {
            this.f = true;
        }
        return z;
    }

    public i g(d dVar) {
        int i = this.e.i();
        i iVar = null;
        i iVar2 = null;
        boolean z = false;
        boolean z2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            float j = this.e.j(i2);
            i b = this.e.b(i2);
            if (b.j == i.a.UNRESTRICTED) {
                if (iVar == null || f > j) {
                    z = v(b, dVar);
                    f = j;
                    iVar = b;
                } else if (!z && v(b, dVar)) {
                    f = j;
                    iVar = b;
                    z = true;
                }
            } else if (iVar == null && j < 0.0f) {
                if (iVar2 == null || f2 > j) {
                    z2 = v(b, dVar);
                    f2 = j;
                    iVar2 = b;
                } else if (!z2 && v(b, dVar)) {
                    f2 = j;
                    iVar2 = b;
                    z2 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    public i getKey() {
        return this.a;
    }

    public b h(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2) {
        float f2;
        int i3;
        if (iVar2 == iVar3) {
            this.e.d(iVar, 1.0f);
            this.e.d(iVar4, 1.0f);
            this.e.d(iVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.e.d(iVar, 1.0f);
            this.e.d(iVar2, -1.0f);
            this.e.d(iVar3, -1.0f);
            this.e.d(iVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                i3 = (-i) + i2;
                f2 = i3;
            }
            return this;
        }
        if (f <= 0.0f) {
            this.e.d(iVar, -1.0f);
            this.e.d(iVar2, 1.0f);
            f2 = i;
        } else {
            if (f < 1.0f) {
                float f3 = 1.0f - f;
                this.e.d(iVar, f3 * 1.0f);
                this.e.d(iVar2, f3 * (-1.0f));
                this.e.d(iVar3, (-1.0f) * f);
                this.e.d(iVar4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    f2 = ((-i) * f3) + (i2 * f);
                }
                return this;
            }
            this.e.d(iVar4, -1.0f);
            this.e.d(iVar3, 1.0f);
            i3 = -i2;
            f2 = i3;
        }
        this.b = f2;
        return this;
    }

    public b i(i iVar, int i) {
        this.a = iVar;
        float f = i;
        iVar.f = f;
        this.b = f;
        this.f = true;
        return this;
    }

    public b j(i iVar, i iVar2, float f) {
        this.e.d(iVar, -1.0f);
        this.e.d(iVar2, f);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.e.d(iVar, -1.0f);
        this.e.d(iVar2, 1.0f);
        this.e.d(iVar3, f);
        this.e.d(iVar4, -f);
        return this;
    }

    public b l(float f, float f2, float f3, i iVar, i iVar2, i iVar3, i iVar4) {
        this.b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.e.d(iVar, 1.0f);
            this.e.d(iVar2, -1.0f);
            this.e.d(iVar4, 1.0f);
            this.e.d(iVar3, -1.0f);
        } else if (f == 0.0f) {
            this.e.d(iVar, 1.0f);
            this.e.d(iVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.e.d(iVar3, 1.0f);
            this.e.d(iVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.e.d(iVar, 1.0f);
            this.e.d(iVar2, -1.0f);
            this.e.d(iVar4, f4);
            this.e.d(iVar3, -f4);
        }
        return this;
    }

    public b m(i iVar, int i) {
        a aVar;
        float f;
        if (i < 0) {
            this.b = i * (-1);
            aVar = this.e;
            f = 1.0f;
        } else {
            this.b = i;
            aVar = this.e;
            f = -1.0f;
        }
        aVar.d(iVar, f);
        return this;
    }

    public b n(i iVar, i iVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.d(iVar, 1.0f);
            this.e.d(iVar2, -1.0f);
        } else {
            this.e.d(iVar, -1.0f);
            this.e.d(iVar2, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.d(iVar, 1.0f);
            this.e.d(iVar2, -1.0f);
            this.e.d(iVar3, -1.0f);
        } else {
            this.e.d(iVar, -1.0f);
            this.e.d(iVar2, 1.0f);
            this.e.d(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.d(iVar, 1.0f);
            this.e.d(iVar2, -1.0f);
            this.e.d(iVar3, 1.0f);
        } else {
            this.e.d(iVar, -1.0f);
            this.e.d(iVar2, 1.0f);
            this.e.d(iVar3, -1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.e.d(iVar3, 0.5f);
        this.e.d(iVar4, 0.5f);
        this.e.d(iVar, -0.5f);
        this.e.d(iVar2, -0.5f);
        this.b = -f;
        return this;
    }

    public void r() {
        float f = this.b;
        if (f < 0.0f) {
            this.b = f * (-1.0f);
            this.e.c();
        }
    }

    public boolean s() {
        i iVar = this.a;
        return iVar != null && (iVar.j == i.a.UNRESTRICTED || this.b >= 0.0f);
    }

    public boolean t(i iVar) {
        return this.e.a(iVar);
    }

    public String toString() {
        return A();
    }

    public boolean u() {
        return this.a == null && this.b == 0.0f && this.e.i() == 0;
    }

    public final boolean v(i iVar, d dVar) {
        return iVar.m <= 1;
    }

    public i w(i iVar) {
        return x(null, iVar);
    }

    public final i x(boolean[] zArr, i iVar) {
        i.a aVar;
        int i = this.e.i();
        i iVar2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            float j = this.e.j(i2);
            if (j < 0.0f) {
                i b = this.e.b(i2);
                if ((zArr == null || !zArr[b.c]) && b != iVar && (((aVar = b.j) == i.a.SLACK || aVar == i.a.ERROR) && j < f)) {
                    f = j;
                    iVar2 = b;
                }
            }
        }
        return iVar2;
    }

    public void y(i iVar) {
        i iVar2 = this.a;
        if (iVar2 != null) {
            this.e.d(iVar2, -1.0f);
            this.a = null;
        }
        float g = this.e.g(iVar, true) * (-1.0f);
        this.a = iVar;
        if (g == 1.0f) {
            return;
        }
        this.b /= g;
        this.e.k(g);
    }

    public void z() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    public b(c cVar) {
        this.e = new w.a(this, cVar);
    }
}
