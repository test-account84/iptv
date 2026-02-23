package G1;

import D1.a;
import java.util.concurrent.Executor;
import v1.f;
import v1.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c implements C1.a {

    public static final class b implements D1.a {

        public class a implements a.a {
            public final /* synthetic */ a.a a;
            public final /* synthetic */ a.c b;

            public a(a.a aVar, a.c cVar) {
                this.a = aVar;
                this.b = cVar;
            }

            public void onCompleted() {
                this.a.onCompleted();
            }

            public void onFailure(B1.b bVar) {
                this.a.onResponse(b.a(b.this, this.b.b));
                this.a.onCompleted();
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

        public static /* synthetic */ a.d a(b bVar, f fVar) {
            return bVar.b(fVar);
        }

        public final a.d b(f fVar) {
            return new a.d(null, i.a(fVar).j(true).f(), null);
        }

        public void interceptAsync(a.c cVar, D1.b bVar, Executor executor, a.a aVar) {
            bVar.a(cVar.b().c(true).a(), executor, new a(aVar, cVar));
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
