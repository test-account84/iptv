package a0;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b {
    public static final File a(Context context, String str) {
        l.e(context, "<this>");
        l.e(str, "name");
        return X.a.a(context, l.l(str, ".preferences_pb"));
    }
}
