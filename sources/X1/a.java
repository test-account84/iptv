package x1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a extends d {
    public static final a a = new a();

    public static d l() {
        return a;
    }

    public d b(b bVar) {
        g.b(bVar);
        return d.a();
    }

    public d c(c cVar) {
        g.b(cVar);
        return d.a();
    }

    public Object e() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public boolean f() {
        return false;
    }

    public d g(c cVar) {
        g.b(cVar);
        return d.a();
    }

    public int hashCode() {
        return 2040732332;
    }

    public Object i(Object obj) {
        return g.c(obj, "use Optional.orNull() instead of Optional.or(null)");
    }

    public d j(d dVar) {
        return (d) g.b(dVar);
    }

    public Object k() {
        return null;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
