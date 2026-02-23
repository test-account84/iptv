package b4;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface f {

    public interface a {

        public static final class a {
            public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

            public static final class a {
                public final Handler a;
                public final a b;
                public boolean c;

                public a(Handler handler, a aVar) {
                    this.a = handler;
                    this.b = aVar;
                }

                public static /* synthetic */ a a(a aVar) {
                    return aVar.b;
                }

                public static /* synthetic */ boolean b(a aVar) {
                    return aVar.c;
                }

                public static /* synthetic */ Handler c(a aVar) {
                    return aVar.a;
                }

                public void d() {
                    this.c = true;
                }
            }

            public static /* synthetic */ void a(a aVar, int i, long j, long j2) {
                d(aVar, i, j, j2);
            }

            public static /* synthetic */ void d(a aVar, int i, long j, long j2) {
                a.a(aVar).F(i, j, j2);
            }

            public void b(Handler handler, a aVar) {
                d4.a.e(handler);
                d4.a.e(aVar);
                e(aVar);
                this.a.add(new a(handler, aVar));
            }

            public void c(int i, long j, long j2) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (!a.b(aVar)) {
                        a.c(aVar).post(new e(aVar, i, j, j2));
                    }
                }
            }

            public void e(a aVar) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    a aVar2 = (a) it.next();
                    if (a.a(aVar2) == aVar) {
                        aVar2.d();
                        this.a.remove(aVar2);
                    }
                }
            }
        }

        void F(int i, long j, long j2);
    }

    long b();

    S d();

    long e();

    void g(Handler handler, a aVar);

    void h(a aVar);
}
