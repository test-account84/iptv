package B3;

import O2.n;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i0 implements O2.n {
    public static final i0 e = new i0(new g0[0]);
    public static final String f = d4.k0.A0(0);
    public static final n.a g = new h0();
    public final int a;
    public final s5.y c;
    public int d;

    public i0(g0... g0VarArr) {
        this.c = s5.y.s(g0VarArr);
        this.a = g0VarArr.length;
        e();
    }

    public static /* synthetic */ i0 a(Bundle bundle) {
        return d(bundle);
    }

    public static /* synthetic */ i0 d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f);
        return parcelableArrayList == null ? new i0(new g0[0]) : new i0((g0[]) d4.d.d(g0.i, parcelableArrayList).toArray(new g0[0]));
    }

    private void e() {
        int i = 0;
        while (i < this.c.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.c.size(); i3++) {
                if (((g0) this.c.get(i)).equals(this.c.get(i3))) {
                    d4.B.e("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public g0 b(int i) {
        return (g0) this.c.get(i);
    }

    public int c(g0 g0Var) {
        int indexOf = this.c.indexOf(g0Var);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i0.class != obj.getClass()) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.a == i0Var.a && this.c.equals(i0Var.c);
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f, d4.d.i(this.c));
        return bundle;
    }

    public int hashCode() {
        if (this.d == 0) {
            this.d = this.c.hashCode();
        }
        return this.d;
    }
}
