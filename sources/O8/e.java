package o8;

import kotlin.jvm.internal.l;
import o8.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface e extends g.b {
    public static final b d0 = b.a;

    public static final class a {
        public static g.b a(e eVar, g.c key) {
            l.e(key, "key");
            if (!(key instanceof o8.b)) {
                if (e.d0 != key) {
                    return null;
                }
                l.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            o8.b bVar = (o8.b) key;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            g.b b = bVar.b(eVar);
            if (b instanceof g.b) {
                return b;
            }
            return null;
        }

        public static g b(e eVar, g.c key) {
            l.e(key, "key");
            if (!(key instanceof o8.b)) {
                return e.d0 == key ? h.a : eVar;
            }
            o8.b bVar = (o8.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.a;
        }
    }

    public static final class b implements g.c {
        public static final /* synthetic */ b a = new b();
    }

    void T(d dVar);

    d o(d dVar);
}
