package com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ClientSharepreferenceHandler {
    public static int a(Context context) {
        return context.getSharedPreferences("sharedPreference", 0).getInt("client_id", -1);
    }

    public static int b(Context context) {
        return context.getSharedPreferences("sharedPreference", 0).getInt("freetrailtime", 86400);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("sharedPreference", 0).getString("email", "abc@gmail.com");
    }

    public static String d(Context context) {
        return context.getSharedPreferences("sharedPreference", 0).getString("prefix", "$");
    }

    public static String e(Context context) {
        return context.getSharedPreferences("sharedPreference", 0).getString("Suffix", "USD");
    }

    public static void f(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("sharedPreference", 0).edit();
        edit.putInt("client_id", i);
        edit.apply();
    }

    public static void g(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("sharedPreference", 0).edit();
        edit.putInt("freetrailtime", i);
        edit.apply();
    }

    public static void h(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("sharedPreference", 0).edit();
        edit.putString("isfreetrial", str);
        edit.apply();
    }

    public static void i(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("sharedPreference", 0).edit();
        edit.putString("email", str);
        edit.apply();
    }

    public static void j(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("sharedPreference", 0).edit();
        edit.putString("prefix", str);
        edit.apply();
    }

    public static void k(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("sharedPreference", 0).edit();
        edit.putString("Suffix", str);
        edit.apply();
    }
}
