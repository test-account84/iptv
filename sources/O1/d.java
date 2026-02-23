package O1;

import O1.j;
import Z1.l;
import android.content.Context;
import j2.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends c {
    public final l E;
    public final l F;
    public final j.d G;

    public d(Class cls, l lVar, l lVar2, Context context, g gVar, m mVar, j2.g gVar2, j.d dVar) {
        super(context, cls, J(gVar, lVar, lVar2, h2.a.class, e2.b.class, null), gVar, mVar, gVar2);
        this.E = lVar;
        this.F = lVar2;
        this.G = dVar;
    }

    public static l2.e J(g gVar, l lVar, l lVar2, Class cls, Class cls2, i2.c cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = gVar.f(cls, cls2);
        }
        return new l2.e(new Z1.f(lVar, lVar2), cVar, gVar.a(Z1.g.class, cls));
    }

    public b I() {
        j.d dVar = this.G;
        return (b) dVar.a(new b(this, this.E, this.F, dVar));
    }
}
