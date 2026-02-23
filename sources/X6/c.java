package x6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public final b a;
    public D6.b b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = bVar;
    }

    public D6.b a() {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public D6.a b(int i, D6.a aVar) {
        return this.a.c(i, aVar);
    }

    public int c() {
        return this.a.d();
    }

    public int d() {
        return this.a.f();
    }

    public boolean e() {
        return this.a.e().f();
    }

    public c f() {
        return new c(this.a.a(this.a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (k unused) {
            return "";
        }
    }
}
