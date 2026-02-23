package Z0;

import d.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class o implements n {
    public final C0.e a;
    public final C0.b b;
    public final C0.k c;
    public final C0.k d;

    public class a extends C0.b {
        public a(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        public /* bridge */ /* synthetic */ void g(G0.f fVar, Object obj) {
            D.a(obj);
            i(fVar, null);
        }

        public void i(G0.f fVar, m mVar) {
            throw null;
        }
    }

    public class b extends C0.k {
        public b(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends C0.k {
        public c(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(C0.e eVar) {
        this.a = eVar;
        this.b = new a(eVar);
        this.c = new b(eVar);
        this.d = new c(eVar);
    }

    public void a(String str) {
        this.a.b();
        G0.f a2 = this.c.a();
        if (str == null) {
            a2.X(1);
        } else {
            a2.x(1, str);
        }
        this.a.c();
        try {
            a2.E();
            this.a.r();
        } finally {
            this.a.g();
            this.c.f(a2);
        }
    }

    public void b() {
        this.a.b();
        G0.f a2 = this.d.a();
        this.a.c();
        try {
            a2.E();
            this.a.r();
        } finally {
            this.a.g();
            this.d.f(a2);
        }
    }
}
