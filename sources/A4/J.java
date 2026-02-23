package a4;

import android.graphics.Color;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class j {
    public static String a(String str) {
        return "." + str + ",." + str + " *";
    }

    public static String b(int i) {
        return k0.D("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }
}
