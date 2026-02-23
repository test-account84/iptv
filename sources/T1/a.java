package t1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {
    public Context a;

    public a(Context context) {
        this.a = context;
    }

    public Context a() {
        return this.a;
    }

    public final SharedPreferences b() {
        return PreferenceManager.getDefaultSharedPreferences(a());
    }

    public String c() {
        return a().getPackageName() + "_preferences";
    }

    public boolean d(String str, boolean z) {
        SharedPreferences b = b();
        return b != null ? b.getBoolean(str, z) : z;
    }

    public String e(String str, String str2) {
        SharedPreferences b = b();
        return b != null ? b.getString(str, str2) : str2;
    }

    public boolean f(String str, Boolean bool) {
        SharedPreferences b = b();
        if (b == null) {
            return false;
        }
        SharedPreferences.Editor edit = b.edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.commit();
        return true;
    }

    public boolean g(String str, String str2) {
        SharedPreferences b = b();
        if (b == null) {
            return false;
        }
        SharedPreferences.Editor edit = b.edit();
        edit.putString(str, str2);
        edit.commit();
        return true;
    }
}
