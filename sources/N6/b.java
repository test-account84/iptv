package n6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b implements a {
    public static b a;

    public static b b() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public long a() {
        return System.currentTimeMillis();
    }
}
