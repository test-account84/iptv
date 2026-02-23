package W0;

import Q0.l;
import X0.i;
import Z0.p;
import android.content.Context;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends c {
    public d(Context context, c1.a aVar) {
        super(i.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        return pVar.j.b() == l.CONNECTED;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(V0.b bVar) {
        return Build.VERSION.SDK_INT >= 26 ? (bVar.a() && bVar.d()) ? false : true : !bVar.a();
    }
}
