package u5;

import java.io.File;
import r5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public static final t5.a a = new a();

    public class a implements t5.a {
    }

    public static String a(String str) {
        m.k(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }
}
