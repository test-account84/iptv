package p7;

import android.content.Context;
import android.util.Log;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class p1 {
    public static c4.t a;

    public static c4.t a(Context context) {
        if (a == null) {
            File file = new File(context.getExternalFilesDir((String) null), "downloads");
            Log.i("directoryIS", file.toString());
            a = new c4.t(file, new c4.r());
        }
        return a;
    }
}
