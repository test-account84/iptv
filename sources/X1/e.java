package x1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e extends d {
    public final Object a;

    public class a implements c {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public Object apply(Object obj) {
            this.a.apply(obj);
            return obj;
        }
    }

    public e(Object obj) {
        this.a = obj;
    }

    public d b(b bVar) {
        g.b(bVar);
        return g(new a(bVar));
    }

    public d c(c cVar) {
        g.b(cVar);
        return (d) g.c(cVar.apply(this.a), "the Function passed to Optional.flatMap() must not return null.");
    }

    public Object e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.a.equals(((e) obj).a);
        }
        return false;
    }

    public boolean f() {
        return true;
    }

    public d g(c cVar) {
        return new e(g.c(cVar.apply(this.a), "the Function passed to Optional.map() must not return null."));
    }

    public int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public Object i(Object obj) {
        g.c(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.a;
    }

    public d j(d dVar) {
        g.b(dVar);
        return this;
    }

    public Object k() {
        return this.a;
    }

    public String toString() {
        return "Optional.of(" + this.a + ")";
    }
}
