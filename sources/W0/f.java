package W0;

import Q0.k;
import Q0.l;
import X0.i;
import Z0.p;
import android.content.Context;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends c {
    public static final String e = k.f("NetworkNotRoamingCtrlr");

    public f(Context context, c1.a aVar) {
        super(i.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        return pVar.j.b() == l.NOT_ROAMING;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(V0.b bVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return (bVar.a() && bVar.c()) ? false : true;
        }
        k.c().a(e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }
}
