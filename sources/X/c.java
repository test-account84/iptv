package x;

import java.util.ArrayList;
import x.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public e a;
    public e b;
    public e c;
    public e d;
    public e e;
    public e f;
    public e g;
    public ArrayList h;
    public int i;
    public int j;
    public float k = 0.0f;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;

    public c(e eVar, int i, boolean z) {
        this.a = eVar;
        this.p = i;
        this.q = z;
    }

    public static boolean c(e eVar, int i) {
        int i2;
        return eVar.M() != 8 && eVar.M[i] == e.b.MATCH_CONSTRAINT && ((i2 = eVar.n[i]) == 0 || i2 == 3);
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }

    public final void b() {
        int i = this.p * 2;
        e eVar = this.a;
        this.o = true;
        e eVar2 = eVar;
        boolean z = false;
        while (!z) {
            this.i++;
            e[] eVarArr = eVar.s0;
            int i2 = this.p;
            e eVar3 = null;
            eVarArr[i2] = null;
            eVar.r0[i2] = null;
            if (eVar.M() != 8) {
                this.l++;
                e.b q = eVar.q(this.p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (q != bVar) {
                    this.m += eVar.y(this.p);
                }
                int b = this.m + eVar.J[i].b();
                this.m = b;
                int i3 = i + 1;
                this.m = b + eVar.J[i3].b();
                int b2 = this.n + eVar.J[i].b();
                this.n = b2;
                this.n = b2 + eVar.J[i3].b();
                if (this.b == null) {
                    this.b = eVar;
                }
                this.d = eVar;
                e.b[] bVarArr = eVar.M;
                int i4 = this.p;
                if (bVarArr[i4] == bVar) {
                    int i5 = eVar.n[i4];
                    if (i5 == 0 || i5 == 3 || i5 == 2) {
                        this.j++;
                        float f = eVar.q0[i4];
                        if (f > 0.0f) {
                            this.k += f;
                        }
                        if (c(eVar, i4)) {
                            if (f < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList();
                            }
                            this.h.add(eVar);
                        }
                        if (this.f == null) {
                            this.f = eVar;
                        }
                        e eVar4 = this.g;
                        if (eVar4 != null) {
                            eVar4.r0[this.p] = eVar;
                        }
                        this.g = eVar;
                    }
                    if (this.p != 0 ? !(eVar.m == 0 && eVar.r == 0 && eVar.s == 0) : !(eVar.l == 0 && eVar.o == 0 && eVar.p == 0)) {
                        this.o = false;
                    }
                    if (eVar.Q != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.s0[this.p] = eVar;
            }
            d dVar = eVar.J[i + 1].d;
            if (dVar != null) {
                e eVar5 = dVar.b;
                d dVar2 = eVar5.J[i].d;
                if (dVar2 != null && dVar2.b == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.b;
        if (eVar6 != null) {
            this.m -= eVar6.J[i].b();
        }
        e eVar7 = this.d;
        if (eVar7 != null) {
            this.m -= eVar7.J[i + 1].b();
        }
        this.c = eVar;
        if (this.p == 0 && this.q) {
            this.e = eVar;
        } else {
            this.e = this.a;
        }
        this.t = this.s && this.r;
    }
}
