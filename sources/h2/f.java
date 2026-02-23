package h2;

import U1.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements S1.g {
    public final S1.g a;
    public final S1.g b;

    public f(S1.g gVar, S1.g gVar2) {
        this.a = gVar;
        this.b = gVar2;
    }

    public l a(l lVar, int i, int i2) {
        S1.g gVar;
        S1.g gVar2;
        l a = ((a) lVar.get()).a();
        l b = ((a) lVar.get()).b();
        if (a != null && (gVar2 = this.a) != null) {
            l a2 = gVar2.a(a, i, i2);
            return !a.equals(a2) ? new b(new a(a2, ((a) lVar.get()).b())) : lVar;
        }
        if (b == null || (gVar = this.b) == null) {
            return lVar;
        }
        l a3 = gVar.a(b, i, i2);
        return !b.equals(a3) ? new b(new a(((a) lVar.get()).a(), a3)) : lVar;
    }

    public String getId() {
        return this.a.getId();
    }

    public f(V1.b bVar, S1.g gVar) {
        this(gVar, new g2.e(gVar, bVar));
    }
}
