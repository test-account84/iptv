package l2;

import java.util.HashMap;
import java.util.Map;
import q2.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public static final g b = new g();
    public final Map a = new HashMap();

    public b a(Class cls, Class cls2) {
        b bVar;
        g gVar = b;
        synchronized (gVar) {
            gVar.a(cls, cls2);
            bVar = (b) this.a.get(gVar);
        }
        return bVar == null ? d.a() : bVar;
    }

    public void b(Class cls, Class cls2, b bVar) {
        this.a.put(new g(cls, cls2), bVar);
    }
}
