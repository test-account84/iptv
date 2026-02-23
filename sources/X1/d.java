package x1;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d implements Serializable {
    public static d a() {
        return a.l();
    }

    public static d d(Object obj) {
        return obj == null ? a() : new e(obj);
    }

    public static d h(Object obj) {
        return new e(g.b(obj));
    }

    public abstract d b(b bVar);

    public abstract d c(c cVar);

    public abstract Object e();

    public abstract boolean f();

    public abstract d g(c cVar);

    public abstract Object i(Object obj);

    public abstract d j(d dVar);

    public abstract Object k();
}
