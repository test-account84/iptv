package a1;

import Q0.n;
import Q0.t;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a implements Runnable {
    public final R0.c a = new R0.c();

    public class a extends a {
        public final /* synthetic */ R0.j c;
        public final /* synthetic */ UUID d;

        public a(R0.j jVar, UUID uuid) {
            this.c = jVar;
            this.d = uuid;
        }

        public void h() {
            WorkDatabase q = this.c.q();
            q.c();
            try {
                a(this.c, this.d.toString());
                q.r();
                q.g();
                g(this.c);
            } catch (Throwable th) {
                q.g();
                throw th;
            }
        }
    }

    public class b extends a {
        public final /* synthetic */ R0.j c;
        public final /* synthetic */ String d;

        public b(R0.j jVar, String str) {
            this.c = jVar;
            this.d = str;
        }

        public void h() {
            WorkDatabase q = this.c.q();
            q.c();
            try {
                Iterator it = q.B().i(this.d).iterator();
                while (it.hasNext()) {
                    a(this.c, (String) it.next());
                }
                q.r();
                q.g();
                g(this.c);
            } catch (Throwable th) {
                q.g();
                throw th;
            }
        }
    }

    public class c extends a {
        public final /* synthetic */ R0.j c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        public c(R0.j jVar, String str, boolean z) {
            this.c = jVar;
            this.d = str;
            this.e = z;
        }

        public void h() {
            WorkDatabase q = this.c.q();
            q.c();
            try {
                Iterator it = q.B().e(this.d).iterator();
                while (it.hasNext()) {
                    a(this.c, (String) it.next());
                }
                q.r();
                q.g();
                if (this.e) {
                    g(this.c);
                }
            } catch (Throwable th) {
                q.g();
                throw th;
            }
        }
    }

    public static a b(UUID uuid, R0.j jVar) {
        return new a(jVar, uuid);
    }

    public static a c(String str, R0.j jVar, boolean z) {
        return new c(jVar, str, z);
    }

    public static a d(String str, R0.j jVar) {
        return new b(jVar, str);
    }

    public void a(R0.j jVar, String str) {
        f(jVar.q(), str);
        jVar.o().l(str);
        Iterator it = jVar.p().iterator();
        while (it.hasNext()) {
            ((R0.e) it.next()).a(str);
        }
    }

    public Q0.n e() {
        return this.a;
    }

    public final void f(WorkDatabase workDatabase, String str) {
        Z0.q B = workDatabase.B();
        Z0.b t = workDatabase.t();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            t g = B.g(str2);
            if (g != t.SUCCEEDED && g != t.FAILED) {
                B.d(t.CANCELLED, str2);
            }
            linkedList.addAll(t.a(str2));
        }
    }

    public void g(R0.j jVar) {
        R0.f.b(jVar.k(), jVar.q(), jVar.p());
    }

    public abstract void h();

    public void run() {
        try {
            h();
            this.a.a(Q0.n.a);
        } catch (Throwable th) {
            this.a.a(new n.b.a(th));
        }
    }
}
