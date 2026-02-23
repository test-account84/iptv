package x;

import java.util.Arrays;
import x.e;
import y.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends k {
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public y.b x0 = new y.b(this);
    public y.e y0 = new y.e(this);
    public b.b z0 = null;
    public boolean A0 = false;
    public w.d B0 = new w.d();
    public int G0 = 0;
    public int H0 = 0;
    public c[] I0 = new c[4];
    public c[] J0 = new c[4];
    public boolean K0 = false;
    public boolean L0 = false;
    public boolean M0 = false;
    public int N0 = 0;
    public int O0 = 0;
    public int P0 = 263;
    public boolean Q0 = false;
    public boolean R0 = false;
    public boolean S0 = false;
    public int T0 = 0;

    public void E0(boolean z, boolean z2) {
        super.E0(z, z2);
        int size = this.w0.size();
        for (int i = 0; i < size; i++) {
            ((e) this.w0.get(i)).E0(z, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x01c6 A[PHI: r0 r5
      0x01c6: PHI (r0v26 boolean) = (r0v25 boolean), (r0v28 boolean), (r0v28 boolean), (r0v28 boolean) binds: [B:62:0x018b, B:70:0x01ae, B:71:0x01b0, B:73:0x01b6] A[DONT_GENERATE, DONT_INLINE]
      0x01c6: PHI (r5v11 boolean) = (r5v10 boolean), (r5v13 boolean), (r5v13 boolean), (r5v13 boolean) binds: [B:62:0x018b, B:70:0x01ae, B:71:0x01b0, B:73:0x01b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void G0() {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x.f.G0():void");
    }

    public void J0(e eVar, int i) {
        if (i == 0) {
            L0(eVar);
        } else if (i == 1) {
            M0(eVar);
        }
    }

    public boolean K0(w.d dVar) {
        f(dVar);
        int size = this.w0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            e eVar = (e) this.w0.get(i);
            eVar.l0(0, false);
            eVar.l0(1, false);
            if (eVar instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                e eVar2 = (e) this.w0.get(i2);
                if (eVar2 instanceof a) {
                    ((a) eVar2).J0();
                }
            }
        }
        for (int i3 = 0; i3 < size; i3++) {
            e eVar3 = (e) this.w0.get(i3);
            if (eVar3.e()) {
                eVar3.f(dVar);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            e eVar4 = (e) this.w0.get(i4);
            if (eVar4 instanceof f) {
                e.b[] bVarArr = eVar4.M;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    eVar4.i0(e.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    eVar4.w0(e.b.FIXED);
                }
                eVar4.f(dVar);
                if (bVar == bVar3) {
                    eVar4.i0(bVar);
                }
                if (bVar2 == bVar3) {
                    eVar4.w0(bVar2);
                }
            } else {
                j.a(this, dVar, eVar4);
                if (!eVar4.e()) {
                    eVar4.f(dVar);
                }
            }
        }
        if (this.G0 > 0) {
            b.a(this, dVar, 0);
        }
        if (this.H0 > 0) {
            b.a(this, dVar, 1);
        }
        return true;
    }

    public final void L0(e eVar) {
        int i = this.G0 + 1;
        c[] cVarArr = this.J0;
        if (i >= cVarArr.length) {
            this.J0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.J0[this.G0] = new c(eVar, 0, V0());
        this.G0++;
    }

    public final void M0(e eVar) {
        int i = this.H0 + 1;
        c[] cVarArr = this.I0;
        if (i >= cVarArr.length) {
            this.I0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.I0[this.H0] = new c(eVar, 1, V0());
        this.H0++;
    }

    public boolean N0(boolean z) {
        return this.y0.f(z);
    }

    public boolean O0(boolean z) {
        return this.y0.g(z);
    }

    public boolean P0(boolean z, int i) {
        return this.y0.h(z, i);
    }

    public b.b Q0() {
        return this.z0;
    }

    public int R0() {
        return this.P0;
    }

    public void S0() {
        this.y0.j();
    }

    public void T0() {
        this.y0.k();
    }

    public boolean U0() {
        return this.S0;
    }

    public boolean V0() {
        return this.A0;
    }

    public void W() {
        this.B0.D();
        this.C0 = 0;
        this.E0 = 0;
        this.D0 = 0;
        this.F0 = 0;
        this.Q0 = false;
        super.W();
    }

    public boolean W0() {
        return this.R0;
    }

    public long X0(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.C0 = i8;
        this.D0 = i9;
        return this.x0.d(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public boolean Y0(int i) {
        return (this.P0 & i) == i;
    }

    public final void Z0() {
        this.G0 = 0;
        this.H0 = 0;
    }

    public void a1(b.b bVar) {
        this.z0 = bVar;
        this.y0.n(bVar);
    }

    public void b1(int i) {
        this.P0 = i;
        w.d.r = j.b(i, 256);
    }

    public void c1(boolean z) {
        this.A0 = z;
    }

    public void d1(w.d dVar, boolean[] zArr) {
        zArr[2] = false;
        F0(dVar);
        int size = this.w0.size();
        for (int i = 0; i < size; i++) {
            ((e) this.w0.get(i)).F0(dVar);
        }
    }

    public void e1() {
        this.x0.e(this);
    }
}
