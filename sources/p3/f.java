package P3;

import O2.n;
import android.os.Bundle;
import d4.k0;
import java.util.ArrayList;
import java.util.List;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements O2.n {
    public static final f d = new f(y.z(), 0);
    public static final String e = k0.A0(0);
    public static final String f = k0.A0(1);
    public static final n.a g = new e();
    public final y a;
    public final long c;

    public f(List list, long j) {
        this.a = y.r(list);
        this.c = j;
    }

    public static /* synthetic */ f a(Bundle bundle) {
        return c(bundle);
    }

    public static y b(List list) {
        y.a p = y.p();
        for (int i = 0; i < list.size(); i++) {
            if (((b) list.get(i)).e == null) {
                p.h((b) list.get(i));
            }
        }
        return p.k();
    }

    public static final f c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e);
        return new f(parcelableArrayList == null ? y.z() : d4.d.d(b.K, parcelableArrayList), bundle.getLong(f));
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e, d4.d.i(b(this.a)));
        bundle.putLong(f, this.c);
        return bundle;
    }
}
