package O5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public final String a;
    public final String b;
    public final List c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final L5.e h;

    public a(String str, String str2, List list, String str3, String str4, String str5, String str6, L5.e eVar) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = eVar;
    }

    public static a a(Context context, y yVar, String str, String str2, List list, L5.e eVar) {
        String packageName = context.getPackageName();
        String g = yVar.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String b = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, list, g, packageName, b, str3, eVar);
    }

    public static String b(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(com.google.android.recaptcha.internal.e.a(packageInfo)) : Integer.toString(packageInfo.versionCode);
    }
}
