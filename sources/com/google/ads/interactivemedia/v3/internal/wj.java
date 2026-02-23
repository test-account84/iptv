package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class wj {
    private wi a;
    private wq b;

    public wj() {
    }

    public void g() {
        this.a = null;
        this.b = null;
    }

    public void h(f fVar) {
        throw null;
    }

    public void k() {
        throw null;
    }

    public abstract Pair l(wg wgVar, int[][][] iArr, int[] iArr2) throws ev;

    public final wq m() {
        wq wqVar = this.b;
        af.t(wqVar);
        return wqVar;
    }

    public final void n(wi wiVar, wq wqVar) {
        this.a = wiVar;
        this.b = wqVar;
    }

    public final void o() {
        wi wiVar = this.a;
        if (wiVar != null) {
            wiVar.j();
        }
    }

    public final wk p(hi[] hiVarArr, um umVar, te teVar, be beVar) throws ev {
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        bf[][] bfVarArr = new bf[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = umVar.b;
            bfVarArr[i] = new bf[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = hiVarArr[i4].e();
        }
        int i5 = 0;
        while (i5 < umVar.b) {
            bf b = umVar.b(i5);
            int i6 = b.c;
            int i7 = 0;
            int i8 = 2;
            int i9 = 0;
            boolean z2 = true;
            while (i7 < i3) {
                hi hiVar = hiVarArr[i7];
                int i10 = 0;
                for (int i11 = 0; i11 < b.a; i11++) {
                    i10 = Math.max(i10, fz.f(hiVar.P(b.b(i11))));
                }
                boolean z3 = iArr2[i7] == 0;
                if (i10 > i9) {
                    z2 = z3;
                    i8 = i7;
                    i9 = i10;
                } else if (i10 == i9 && i6 == 5 && !z2 && z3) {
                    i8 = i7;
                    i9 = i10;
                    z2 = true;
                }
                i7++;
                i3 = 2;
            }
            if (i8 == i3) {
                iArr = new int[b.a];
            } else {
                hi hiVar2 = hiVarArr[i8];
                int[] iArr5 = new int[b.a];
                for (int i12 = 0; i12 < b.a; i12++) {
                    iArr5[i12] = hiVar2.P(b.b(i12));
                }
                iArr = iArr5;
            }
            int i13 = iArr2[i8];
            bfVarArr[i8][i13] = b;
            iArr3[i8][i13] = iArr;
            iArr2[i8] = i13 + 1;
            i5++;
            i3 = 2;
        }
        um[] umVarArr = new um[2];
        int[] iArr6 = new int[2];
        int i14 = 0;
        for (int i15 = 2; i14 < i15; i15 = 2) {
            int i16 = iArr2[i14];
            umVarArr[i14] = new um((bf[]) cq.ai(bfVarArr[i14], i16));
            iArr3[i14] = (int[][]) cq.ai(iArr3[i14], i16);
            hiVarArr[i14].L();
            iArr6[i14] = hiVarArr[i14].b();
            i14++;
        }
        wg wgVar = new wg(iArr6, umVarArr, iArr4, iArr3, new um((bf[]) cq.ai(bfVarArr[2], iArr2[2])));
        Pair l = l(wgVar, iArr3, iArr4);
        wh[] whVarArr = (wh[]) l.second;
        List[] listArr = new List[whVarArr.length];
        for (int i17 = 0; i17 < whVarArr.length; i17++) {
            wh whVar = whVarArr[i17];
            listArr[i17] = whVar != null ? avo.p(whVar) : avo.o();
        }
        avk avkVar = new avk();
        for (int i18 = 0; i18 < wgVar.a(); i18++) {
            um d = wgVar.d(i18);
            List list = listArr[i18];
            for (int i19 = 0; i19 < d.b; i19++) {
                bf b2 = d.b(i19);
                boolean z4 = wgVar.f(i18, i19) != 0;
                int i20 = b2.a;
                int[] iArr7 = new int[i20];
                boolean[] zArr = new boolean[i20];
                for (int i21 = 0; i21 < b2.a; i21++) {
                    iArr7[i21] = wgVar.c(i18, i19, i21);
                    int i22 = 0;
                    while (true) {
                        if (i22 >= list.size()) {
                            z = false;
                            break;
                        }
                        wh whVar2 = (wh) list.get(i22);
                        if (whVar2.q().equals(b2) && whVar2.l(i21) != -1) {
                            z = true;
                            break;
                        }
                        i22++;
                    }
                    zArr[i21] = z;
                }
                avkVar.g(new bj(b2, z4, iArr7, zArr));
            }
        }
        um e = wgVar.e();
        for (int i23 = 0; i23 < e.b; i23++) {
            bf b3 = e.b(i23);
            int[] iArr8 = new int[b3.a];
            Arrays.fill(iArr8, 0);
            avkVar.g(new bj(b3, false, iArr8, new boolean[b3.a]));
        }
        return new wk((hj[]) l.first, (we[]) l.second, new bk(avkVar.f()), wgVar);
    }

    public wj(byte[] bArr) {
        this();
    }
}
