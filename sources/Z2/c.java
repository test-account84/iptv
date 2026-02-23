package z2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c {
    public static c d(int i, Object obj) {
        return new a(Integer.valueOf(i), obj, d.DEFAULT);
    }

    public static c e(Object obj) {
        return new a(null, obj, d.DEFAULT);
    }

    public static c f(int i, Object obj) {
        return new a(Integer.valueOf(i), obj, d.VERY_LOW);
    }

    public static c g(Object obj) {
        return new a(null, obj, d.VERY_LOW);
    }

    public static c h(Object obj) {
        return new a(null, obj, d.HIGHEST);
    }

    public abstract Integer a();

    public abstract Object b();

    public abstract d c();
}
