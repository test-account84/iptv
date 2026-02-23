package androidx.datastore.preferences.protobuf;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a0 {
    public static final a0 c = new a0();
    public final ConcurrentMap b = new ConcurrentHashMap();
    public final f0 a = new G();

    public static a0 a() {
        return c;
    }

    public e0 b(Class cls, e0 e0Var) {
        y.b(cls, "messageType");
        y.b(e0Var, "schema");
        return (e0) this.b.putIfAbsent(cls, e0Var);
    }

    public e0 c(Class cls) {
        y.b(cls, "messageType");
        e0 e0Var = (e0) this.b.get(cls);
        if (e0Var != null) {
            return e0Var;
        }
        e0 a = this.a.a(cls);
        e0 b = b(cls, a);
        return b != null ? b : a;
    }

    public e0 d(Object obj) {
        return c(obj.getClass());
    }
}
