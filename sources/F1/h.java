package F1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import v1.f;
import z1.i;
import z1.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h implements K1.c {
    public static final h h = new a();
    public M1.b a;
    public M1.b b;
    public M1.b c;
    public List d;
    public i.a e;
    public k f = new k();
    public Set g = Collections.emptySet();

    public void a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(0, this.c.b());
        }
        this.c.c(arrayList);
    }

    public void b(v1.k kVar, x1.d dVar) {
        this.a.c(this.d);
        z1.b n = dVar.f() ? n(kVar, dVar.e()) : z1.b.b;
        String b = n.b();
        if (n == z1.b.b) {
            b = l();
        } else {
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            arrayList.add(b);
        }
        this.b.c(this.e.c());
        this.e = z1.i.b(b);
    }

    public void c(Object obj) {
        this.c.c(obj);
    }

    public void d(v1.k kVar, x1.d dVar) {
        this.d = (List) this.a.b();
        if (dVar.f()) {
            z1.i c = this.e.c();
            this.c.c(new z1.d(c.g()));
            this.g.add(c.g());
            this.f.b(c);
        }
        this.e = ((z1.i) this.b.b()).i();
    }

    public void e(int i) {
        this.d.remove(r2.size() - 1);
    }

    public void f(int i) {
        this.d.add(Integer.toString(i));
    }

    public void g() {
        this.c.c(null);
    }

    public void h(v1.k kVar, f.b bVar) {
        this.d.add(j().a(kVar, bVar));
    }

    public void i(v1.k kVar, f.b bVar) {
        this.d.remove(r0.size() - 1);
        Object b = this.c.b();
        String a2 = j().a(kVar, bVar);
        this.g.add(this.e.d() + "." + a2);
        this.e.a(a2, b);
        if (this.b.a()) {
            this.f.b(this.e.c());
        }
    }

    public abstract F1.a j();

    public Set k() {
        return this.g;
    }

    public final String l() {
        StringBuilder sb = new StringBuilder();
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) this.d.get(i));
            if (i < size - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public Collection m() {
        return this.f.a();
    }

    public abstract z1.b n(v1.k kVar, Object obj);

    public void o(z1.b bVar) {
        this.a = new M1.b();
        this.b = new M1.b();
        this.c = new M1.b();
        this.g = new HashSet();
        this.d = new ArrayList();
        this.e = z1.i.b(bVar.b());
        this.f = new k();
    }

    public void p(v1.f fVar) {
        o(z1.c.rootKeyForOperation(fVar));
    }

    public static class a extends h {

        public class a implements F1.a {
            public a() {
            }

            public String a(v1.k kVar, f.b bVar) {
                return z1.b.b.b();
            }
        }

        public F1.a j() {
            return new a();
        }

        public Set k() {
            return Collections.emptySet();
        }

        public Collection m() {
            return Collections.emptyList();
        }

        public z1.b n(v1.k kVar, Object obj) {
            return z1.b.b;
        }

        public void a(List list) {
        }

        public void c(Object obj) {
        }

        public void e(int i) {
        }

        public void f(int i) {
        }

        public void p(v1.f fVar) {
        }

        public void g() {
        }

        public void b(v1.k kVar, x1.d dVar) {
        }

        public void d(v1.k kVar, x1.d dVar) {
        }

        public void h(v1.k kVar, f.b bVar) {
        }

        public void i(v1.k kVar, f.b bVar) {
        }
    }
}
