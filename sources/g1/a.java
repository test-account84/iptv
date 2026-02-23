package G1;

import D1.a;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a implements C1.a {

    public static final class b implements D1.a {
        public x1.d a;
        public x1.d b;
        public x1.d c;
        public x1.d d;
        public boolean e;
        public a.a f;
        public volatile boolean g;

        public b() {
            this.a = x1.d.a();
            this.b = x1.d.a();
            this.c = x1.d.a();
            this.d = x1.d.a();
        }

        public static /* synthetic */ void a(b bVar, a.d dVar) {
            bVar.g(dVar);
        }

        public static /* synthetic */ void b(b bVar, B1.b bVar2) {
            bVar.f(bVar2);
        }

        public static /* synthetic */ void c(b bVar, a.d dVar) {
            bVar.i(dVar);
        }

        public static /* synthetic */ void d(b bVar, B1.b bVar2) {
            bVar.h(bVar2);
        }

        public void dispose() {
            this.g = true;
        }

        public final synchronized void e() {
            a.a aVar;
            try {
                if (this.g) {
                    return;
                }
                if (!this.e) {
                    if (this.a.f()) {
                        this.f.onResponse((a.d) this.a.e());
                    } else if (this.c.f()) {
                    }
                    this.e = true;
                }
                if (this.e) {
                    if (this.b.f()) {
                        this.f.onResponse((a.d) this.b.e());
                        aVar = this.f;
                    } else if (this.d.f()) {
                        if (this.c.f()) {
                            this.f.onFailure((B1.b) this.d.e());
                        } else {
                            aVar = this.f;
                        }
                    }
                    aVar.onCompleted();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void f(B1.b bVar) {
            this.c = x1.d.h(bVar);
            e();
        }

        public final synchronized void g(a.d dVar) {
            this.a = x1.d.h(dVar);
            e();
        }

        public final synchronized void h(B1.b bVar) {
            this.d = x1.d.h(bVar);
            e();
        }

        public final synchronized void i(a.d dVar) {
            this.b = x1.d.h(dVar);
            e();
        }

        public void interceptAsync(a.c cVar, D1.b bVar, Executor executor, a.a aVar) {
            if (this.g) {
                return;
            }
            this.f = aVar;
            bVar.a(cVar.b().c(true).a(), executor, new a(aVar));
            bVar.a(cVar.b().c(false).a(), executor, new b(aVar));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public class a implements a.a {
            public final /* synthetic */ a.a a;

            public a(a.a aVar) {
                this.a = aVar;
            }

            public void onFailure(B1.b bVar) {
                b.b(b.this, bVar);
            }

            public void onFetch(a.b bVar) {
                this.a.onFetch(bVar);
            }

            public void onResponse(a.d dVar) {
                b.a(b.this, dVar);
            }

            public void onCompleted() {
            }
        }

        public class b implements a.a {
            public final /* synthetic */ a.a a;

            public b(a.a aVar) {
                this.a = aVar;
            }

            public void onFailure(B1.b bVar) {
                b.d(b.this, bVar);
            }

            public void onFetch(a.b bVar) {
                this.a.onFetch(bVar);
            }

            public void onResponse(a.d dVar) {
                b.c(b.this, dVar);
            }

            public void onCompleted() {
            }
        }
    }

    public D1.a a(E1.b bVar) {
        return new b(null);
    }
}
