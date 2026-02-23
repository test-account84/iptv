package G1;

import D1.a;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e implements C1.a {

    public static final class b implements D1.a {
        public b() {
        }

        public void interceptAsync(a.c cVar, D1.b bVar, Executor executor, a.a aVar) {
            bVar.a(cVar.b().c(false).a(), executor, aVar);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public void dispose() {
        }
    }

    public D1.a a(E1.b bVar) {
        return new b(null);
    }
}
