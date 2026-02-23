package W0;

import Q0.k;
import Q0.l;
import X0.i;
import Z0.p;
import android.content.Context;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends c {
    public static final String e = k.f("NetworkMeteredCtrlr");

    public e(Context context, c1.a aVar) {
        super(i.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        return pVar.j.b() == l.METERED;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(V0.b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return (bVar.a() && bVar.b()) ? false : true;
        }
        k.c().a(e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }
}
