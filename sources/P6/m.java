package P6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class m {
    public int a = 0;
    public a b = a.NUMERIC;

    public enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.a;
    }

    public void b(int i) {
        this.a += i;
    }

    public boolean c() {
        return this.b == a.ALPHA;
    }

    public boolean d() {
        return this.b == a.ISO_IEC_646;
    }

    public void e() {
        this.b = a.ALPHA;
    }

    public void f() {
        this.b = a.ISO_IEC_646;
    }

    public void g() {
        this.b = a.NUMERIC;
    }

    public void h(int i) {
        this.a = i;
    }
}
