package x;

import x.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends i {
    public int y0 = 0;
    public boolean z0 = true;
    public int A0 = 0;

    public boolean G0() {
        return this.z0;
    }

    public int H0() {
        return this.y0;
    }

    public int I0() {
        return this.A0;
    }

    public void J0() {
        for (int i = 0; i < this.x0; i++) {
            e eVar = this.w0[i];
            int i2 = this.y0;
            if (i2 == 0 || i2 == 1) {
                eVar.l0(0, true);
            } else if (i2 == 2 || i2 == 3) {
                eVar.l0(1, true);
            }
        }
    }

    public void K0(boolean z) {
        this.z0 = z;
    }

    public void L0(int i) {
        this.y0 = i;
    }

    public void M0(int i) {
        this.A0 = i;
    }

    public void f(w.d dVar) {
        d[] dVarArr;
        boolean z;
        w.i iVar;
        d dVar2;
        int i;
        int i2;
        int i3;
        d[] dVarArr2 = this.J;
        dVarArr2[0] = this.B;
        dVarArr2[2] = this.C;
        dVarArr2[1] = this.D;
        dVarArr2[3] = this.E;
        int i4 = 0;
        while (true) {
            dVarArr = this.J;
            if (i4 >= dVarArr.length) {
                break;
            }
            d dVar3 = dVarArr[i4];
            dVar3.g = dVar.q(dVar3);
            i4++;
        }
        int i5 = this.y0;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        d dVar4 = dVarArr[i5];
        for (int i6 = 0; i6 < this.x0; i6++) {
            e eVar = this.w0[i6];
            if ((this.z0 || eVar.g()) && ((((i2 = this.y0) == 0 || i2 == 1) && eVar.w() == e.b.MATCH_CONSTRAINT && eVar.B.d != null && eVar.D.d != null) || (((i3 = this.y0) == 2 || i3 == 3) && eVar.K() == e.b.MATCH_CONSTRAINT && eVar.C.d != null && eVar.E.d != null))) {
                z = true;
                break;
            }
        }
        z = false;
        boolean z2 = this.B.h() || this.D.h();
        boolean z3 = this.C.h() || this.E.h();
        int i7 = !(!z && (((i = this.y0) == 0 && z2) || ((i == 2 && z3) || ((i == 1 && z2) || (i == 3 && z3))))) ? 4 : 5;
        for (int i8 = 0; i8 < this.x0; i8++) {
            e eVar2 = this.w0[i8];
            if (this.z0 || eVar2.g()) {
                w.i q = dVar.q(eVar2.J[this.y0]);
                d[] dVarArr3 = eVar2.J;
                int i9 = this.y0;
                d dVar5 = dVarArr3[i9];
                dVar5.g = q;
                d dVar6 = dVar5.d;
                int i10 = (dVar6 == null || dVar6.b != this) ? 0 : dVar5.e;
                if (i9 == 0 || i9 == 2) {
                    dVar.i(dVar4.g, q, this.A0 - i10, z);
                } else {
                    dVar.g(dVar4.g, q, this.A0 + i10, z);
                }
                dVar.e(dVar4.g, q, this.A0 + i10, i7);
            }
        }
        int i11 = this.y0;
        if (i11 == 0) {
            dVar.e(this.D.g, this.B.g, 0, 8);
            dVar.e(this.B.g, this.N.D.g, 0, 4);
            iVar = this.B.g;
            dVar2 = this.N.B;
        } else if (i11 == 1) {
            dVar.e(this.B.g, this.D.g, 0, 8);
            dVar.e(this.B.g, this.N.B.g, 0, 4);
            iVar = this.B.g;
            dVar2 = this.N.D;
        } else if (i11 == 2) {
            dVar.e(this.E.g, this.C.g, 0, 8);
            dVar.e(this.C.g, this.N.E.g, 0, 4);
            iVar = this.C.g;
            dVar2 = this.N.C;
        } else {
            if (i11 != 3) {
                return;
            }
            dVar.e(this.C.g, this.E.g, 0, 8);
            dVar.e(this.C.g, this.N.C.g, 0, 4);
            iVar = this.C.g;
            dVar2 = this.N.E;
        }
        dVar.e(iVar, dVar2.g, 0, 0);
    }

    public boolean g() {
        return true;
    }

    public String toString() {
        String str = "[Barrier] " + p() + " {";
        for (int i = 0; i < this.x0; i++) {
            e eVar = this.w0[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + eVar.p();
        }
        return str + "}";
    }
}
