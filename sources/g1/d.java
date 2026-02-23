package G1;

import D1.a;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d implements C1.a {

    public static final class a implements D1.a {
        public volatile boolean a;
        public final E1.b b;

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
                a.a(a.this).b(bVar, "Failed to fetch network response for operation %s, trying to return cached one", this.b.b);
                if (a.b(a.this)) {
                    return;
                }
                this.c.a(this.b.b().c(true).a(), this.d, this.a);
            }

            public void onFetch(a.b bVar) {
                this.a.onFetch(bVar);
            }

            public void onResponse(a.d dVar) {
                this.a.onResponse(dVar);
            }
        }

        public a(E1.b bVar) {
            this.b = bVar;
        }

        public static /* synthetic */ E1.b a(a aVar) {
            return aVar.b;
        }

        public static /* synthetic */ boolean b(a aVar) {
            return aVar.a;
        }

        public void dispose() {
            this.a = true;
        }

        public void interceptAsync(a.c cVar, D1.b bVar, Executor executor, a.a aVar) {
            bVar.a(cVar.b().c(false).a(), executor, new a(aVar, cVar, bVar, executor));
        }
    }

    public D1.a a(E1.b bVar) {
        return new a(bVar);
    }
}
