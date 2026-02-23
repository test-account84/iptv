package R6;

import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h extends g {
    public final boolean c;

    public h(c cVar, boolean z) {
        super(cVar);
        this.c = z;
    }

    public void g(a aVar) {
        d[] d = d();
        m();
        l(d, aVar);
        c a = a();
        q h = this.c ? a.h() : a.i();
        q b = this.c ? a.b() : a.c();
        int e = e((int) h.d());
        int e2 = e((int) b.d());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (e < e2) {
            d dVar = d[e];
            if (dVar != null) {
                int c = dVar.c() - i;
                if (c == 0) {
                    i2++;
                } else {
                    if (c == 1) {
                        i3 = Math.max(i3, i2);
                    } else if (c < 0 || dVar.c() >= aVar.c() || c > e) {
                        d[e] = null;
                    } else {
                        if (i3 > 2) {
                            c *= i3 - 2;
                        }
                        boolean z = c >= e;
                        for (int i4 = 1; i4 <= c && !z; i4++) {
                            z = d[e - i4] != null;
                        }
                        if (z) {
                            d[e] = null;
                        }
                    }
                    i = dVar.c();
                    i2 = 1;
                }
            }
            e++;
        }
    }

    public final void h(a aVar) {
        c a = a();
        q h = this.c ? a.h() : a.i();
        q b = this.c ? a.b() : a.c();
        int e = e((int) b.d());
        d[] d = d();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int e2 = e((int) h.d()); e2 < e; e2++) {
            d dVar = d[e2];
            if (dVar != null) {
                dVar.j();
                int c = dVar.c() - i;
                if (c == 0) {
                    i2++;
                } else {
                    if (c == 1) {
                        i3 = Math.max(i3, i2);
                    } else if (dVar.c() >= aVar.c()) {
                        d[e2] = null;
                    }
                    i = dVar.c();
                    i2 = 1;
                }
            }
        }
    }

    public a i() {
        d[] d = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : d) {
            if (dVar != null) {
                dVar.j();
                int e = dVar.e() % 30;
                int c = dVar.c();
                if (!this.c) {
                    c += 2;
                }
                int i = c % 3;
                if (i == 0) {
                    bVar2.b((e * 3) + 1);
                } else if (i == 1) {
                    bVar4.b(e / 3);
                    bVar3.b(e % 3);
                } else if (i == 2) {
                    bVar.b(e + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        l(d, aVar);
        return aVar;
    }

    public int[] j() {
        int c;
        a i = i();
        if (i == null) {
            return null;
        }
        h(i);
        int c2 = i.c();
        int[] iArr = new int[c2];
        for (d dVar : d()) {
            if (dVar != null && (c = dVar.c()) < c2) {
                iArr[c] = iArr[c] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.c;
    }

    public final void l(d[] dVarArr, a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            d dVar = dVarArr[i];
            if (dVar != null) {
                int e = dVar.e() % 30;
                int c = dVar.c();
                if (c > aVar.c()) {
                    dVarArr[i] = null;
                } else {
                    if (!this.c) {
                        c += 2;
                    }
                    int i2 = c % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && e + 1 != aVar.a()) {
                                dVarArr[i] = null;
                            }
                        } else if (e / 3 != aVar.b() || e % 3 != aVar.d()) {
                            dVarArr[i] = null;
                        }
                    } else if ((e * 3) + 1 != aVar.e()) {
                        dVarArr[i] = null;
                    }
                }
            }
        }
    }

    public final void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }
}
