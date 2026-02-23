package b7;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {
    public static SharedPreferences a = null;
    public static SharedPreferences.Editor b = null;
    public static String c = "";
    public static Boolean d = Boolean.FALSE;

    public static String a(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        String string = defaultSharedPreferences.getString("url", "");
        c = string;
        return string.toLowerCase();
    }

    public static String b(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        String string = defaultSharedPreferences.getString("notificationkey", "");
        c = string;
        return string;
    }

    public static String c(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        String string = defaultSharedPreferences.getString("key", "");
        c = string;
        return string;
    }

    public static String d(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        String string = defaultSharedPreferences.getString("salt", "");
        c = string;
        return string;
    }

    public static void e(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        b = edit;
        edit.putString("url", str);
        b.commit();
    }

    public static void f(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        b = edit;
        edit.putString("notificationkey", str);
        b.commit();
    }

    public static void g(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        b = edit;
        edit.putString("key", str);
        b.commit();
    }

    public static void h(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a = defaultSharedPreferences;
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        b = edit;
        edit.putString("salt", str);
        b.commit();
    }
}
