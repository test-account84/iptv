package M4;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a2 implements zzr {
    public final /* synthetic */ c2 a;

    public a2(c2 c2Var) {
        this.a = c2Var;
    }

    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        x1 q;
        int i2 = i - 1;
        if (i2 == 0) {
            q = this.a.a.d().q();
        } else if (i2 == 1) {
            z1 d = this.a.a.d();
            q = z ? d.t() : !z2 ? d.s() : d.r();
        } else if (i2 == 3) {
            q = this.a.a.d().v();
        } else if (i2 != 4) {
            q = this.a.a.d().u();
        } else {
            z1 d2 = this.a.a.d();
            q = z ? d2.y() : !z2 ? d2.x() : d2.w();
        }
        int size = list.size();
        if (size == 1) {
            q.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            q.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            q.a(str);
        } else {
            q.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
