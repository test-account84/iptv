package E1;

import j$.util.concurrent.ConcurrentHashMap;
import v1.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i {
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    public l a(v1.f fVar) {
        x1.g.c(fVar, "operation == null");
        Class cls = fVar.getClass();
        l lVar = (l) this.a.get(cls);
        if (lVar != null) {
            return lVar;
        }
        this.a.putIfAbsent(cls, fVar.responseFieldMapper());
        return (l) this.a.get(cls);
    }
}
