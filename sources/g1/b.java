package G1;

import D1.a;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements C1.a {

    public static final class b implements D1.a {
        public volatile boolean a;

        public class a implements a.a {
            public final /* synthetic */ a.a a;
            public final /* synthetic */ a.c b;
            public final /* synthetic */ D1.b c;
            public final /* synthetic */ Executor d;

            public a(a.a aVar, a.c cVar, D1.b bVar, Executor executor) {
                this.a = aVar;
                this.b = cVar;
                this.c = bVar;
                this.d = executor;
            }

            public void onCompleted() {
                this.a.onCompleted();
            }

            public void onFailure(B1.b bVar) {
                if (b.a(b.this)) {
                    return;
                }
                this.c.a(this.b.b().c(false).a(), this.d, this.a);
            }

            public void onFetch(a.b bVar) {
                this.a.onFetch(bVar);
            }

            public void onResponse(a.d dVar) {
                this.a.onResponse(dVar);
            }
        }

        public b() {
        }

        public static /* synthetic */ boolean a(b bVar) {
            return bVar.a;
        }

        public void dispose() {
            this.a = true;
        }

        public void interceptAsync(a.c cVar, D1.b bVar, Executor executor, a.a aVar) {
            bVar.a(cVar.b().c(true).a(), executor, new a(aVar, cVar, bVar, executor));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public D1.a a(E1.b bVar) {
        return new b(null);
    }
}
