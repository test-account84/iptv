package O1;

import O1.j;
import Z1.l;
import android.graphics.Bitmap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends a {
    public final l J;
    public final l K;
    public final g L;
    public final j.d M;

    public b(e eVar, l lVar, l lVar2, j.d dVar) {
        super(G(eVar.d, lVar, lVar2, Bitmap.class, null), Bitmap.class, eVar);
        this.J = lVar;
        this.K = lVar2;
        this.L = eVar.d;
        this.M = dVar;
    }

    public static l2.e G(g gVar, l lVar, l lVar2, Class cls, i2.c cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = gVar.f(Bitmap.class, cls);
        }
        return new l2.e(new Z1.f(lVar, lVar2), cVar, gVar.a(Z1.g.class, Bitmap.class));
    }
}
