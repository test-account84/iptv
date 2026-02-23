package o6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import g6.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public final Context a;
    public final SharedPreferences b;
    public final c c;
    public boolean d;

    public a(Context context, String str, c cVar) {
        Context a = a(context);
        this.a = a;
        this.b = a.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.c = cVar;
        this.d = c();
    }

    public static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : E.b.createDeviceProtectedStorageContext(context);
    }

    public synchronized boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.b.contains("firebase_data_collection_default_enabled") ? this.b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
