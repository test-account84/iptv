package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class vu extends bi {
    public static final vu B = new vt().v();
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    private final SparseArray P;
    private final SparseBooleanArray Q;

    public /* synthetic */ vu(vt vtVar) {
        super(vtVar);
        this.C = vt.B(vtVar);
        this.D = false;
        this.E = vt.x(vtVar);
        this.F = false;
        this.G = vt.z(vtVar);
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = vt.y(vtVar);
        this.M = vt.A(vtVar);
        this.N = false;
        this.O = vt.w(vtVar);
        this.P = vt.t(vtVar);
        this.Q = vt.u(vtVar);
    }

    public static vu a(Context context) {
        return new vt(context).v();
    }

    @Deprecated
    public final vv b(int i, um umVar) {
        Map map = (Map) this.P.get(i);
        if (map != null) {
            return (vv) map.get(umVar);
        }
        return null;
    }

    public final boolean c(int i) {
        return this.Q.get(i);
    }

    @Deprecated
    public final boolean d(int i, um umVar) {
        Map map = (Map) this.P.get(i);
        return map != null && map.containsKey(umVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vu.class == obj.getClass()) {
            vu vuVar = (vu) obj;
            if (super.equals(vuVar) && this.C == vuVar.C && this.E == vuVar.E && this.G == vuVar.G && this.L == vuVar.L && this.M == vuVar.M && this.O == vuVar.O) {
                SparseBooleanArray sparseBooleanArray = this.Q;
                SparseBooleanArray sparseBooleanArray2 = vuVar.Q;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray sparseArray = this.P;
                            SparseArray sparseArray2 = vuVar.P;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                um umVar = (um) entry.getKey();
                                                if (map2.containsKey(umVar) && cq.V(entry.getValue(), map2.get(umVar))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((super.hashCode() + 31) * 31) + (this.C ? 1 : 0)) * 961) + (this.E ? 1 : 0)) * 961) + (this.G ? 1 : 0)) * 28629151) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 961) + (this.O ? 1 : 0);
    }
}
