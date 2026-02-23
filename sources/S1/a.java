package s1;

import com.google.gson.Gson;
import p1.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {
    public static e.a a;

    public static e.a a() {
        if (a == null) {
            a = new n1.a(new Gson());
        }
        return a;
    }
}
