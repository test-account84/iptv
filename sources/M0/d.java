package m0;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import m0.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d extends a {
    public d() {
        this(null, 1, null);
    }

    public Object a(a.b bVar) {
        l.e(bVar, "key");
        return b().get(bVar);
    }

    public final void c(a.b bVar, Object obj) {
        l.e(bVar, "key");
        b().put(bVar, obj);
    }

    public d(a aVar) {
        l.e(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    public /* synthetic */ d(a aVar, int i, g gVar) {
        this((i & 1) != 0 ? a.a.b : aVar);
    }
}
