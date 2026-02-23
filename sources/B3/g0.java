package B3;

import O2.n;
import O2.z0;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g0 implements O2.n {
    public static final String g = d4.k0.A0(0);
    public static final String h = d4.k0.A0(1);
    public static final n.a i = new f0();
    public final int a;
    public final String c;
    public final int d;
    public final z0[] e;
    public int f;

    public g0(String str, z0... z0VarArr) {
        d4.a.a(z0VarArr.length > 0);
        this.c = str;
        this.e = z0VarArr;
        this.a = z0VarArr.length;
        int k = d4.F.k(z0VarArr[0].m);
        this.d = k == -1 ? d4.F.k(z0VarArr[0].l) : k;
        j();
    }

    public static /* synthetic */ g0 a(Bundle bundle) {
        return e(bundle);
    }

    public static /* synthetic */ g0 e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(g);
        return new g0(bundle.getString(h, ""), (z0[]) (parcelableArrayList == null ? s5.y.z() : d4.d.d(z0.u0, parcelableArrayList)).toArray(new z0[0]));
    }

    public static void f(String str, String str2, String str3, int i2) {
        d4.B.e("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i2 + ")"));
    }

    public static String g(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    public static int i(int i2) {
        return i2 | 16384;
    }

    public g0 b(String str) {
        return new g0(str, this.e);
    }

    public z0 c(int i2) {
        return this.e[i2];
    }

    public int d(z0 z0Var) {
        int i2 = 0;
        while (true) {
            z0[] z0VarArr = this.e;
            if (i2 >= z0VarArr.length) {
                return -1;
            }
            if (z0Var == z0VarArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.c.equals(g0Var.c) && Arrays.equals(this.e, g0Var.e);
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList(this.e.length);
        for (z0 z0Var : this.e) {
            arrayList.add(z0Var.j(true));
        }
        bundle.putParcelableArrayList(g, arrayList);
        bundle.putString(h, this.c);
        return bundle;
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = ((527 + this.c.hashCode()) * 31) + Arrays.hashCode(this.e);
        }
        return this.f;
    }

    public final void j() {
        String g2 = g(this.e[0].d);
        int i2 = i(this.e[0].f);
        int i3 = 1;
        while (true) {
            z0[] z0VarArr = this.e;
            if (i3 >= z0VarArr.length) {
                return;
            }
            if (!g2.equals(g(z0VarArr[i3].d))) {
                z0[] z0VarArr2 = this.e;
                f("languages", z0VarArr2[0].d, z0VarArr2[i3].d, i3);
                return;
            } else {
                if (i2 != i(this.e[i3].f)) {
                    f("role flags", Integer.toBinaryString(this.e[0].f), Integer.toBinaryString(this.e[i3].f), i3);
                    return;
                }
                i3++;
            }
        }
    }

    public g0(z0... z0VarArr) {
        this("", z0VarArr);
    }
}
