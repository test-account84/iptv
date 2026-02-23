package M4;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class z3 {
    public static String a(String str, String[] strArr, String[] strArr2) {
        com.google.android.gms.common.internal.r.m(strArr);
        com.google.android.gms.common.internal.r.m(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i];
            }
        }
        return null;
    }

    public static String b(Context context, String str, String str2) {
        com.google.android.gms.common.internal.r.m(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = d2.a(context);
        }
        return d2.b("google_app_id", resources, str2);
    }
}
