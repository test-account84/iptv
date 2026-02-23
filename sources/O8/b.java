package o8;

import o8.g;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b implements g.c {
    public final l a;
    public final g.c c;

    public b(g.c baseKey, l safeCast) {
        kotlin.jvm.internal.l.e(baseKey, "baseKey");
        kotlin.jvm.internal.l.e(safeCast, "safeCast");
        this.a = safeCast;
        this.c = baseKey instanceof b ? ((b) baseKey).c : baseKey;
    }

    public final boolean a(g.c key) {
        kotlin.jvm.internal.l.e(key, "key");
        return key == this || this.c == key;
    }

    public final g.b b(g.b element) {
        kotlin.jvm.internal.l.e(element, "element");
        return (g.b) this.a.invoke(element);
    }
}
