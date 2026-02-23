package W0;

import Q0.l;
import X0.i;
import Z0.p;
import android.content.Context;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends c {
    public g(Context context, c1.a aVar) {
        super(i.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        return pVar.j.b() == l.UNMETERED || (Build.VERSION.SDK_INT >= 30 && pVar.j.b() == l.TEMPORARILY_UNMETERED);
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(V0.b bVar) {
        return !bVar.a() || bVar.b();
    }
}
