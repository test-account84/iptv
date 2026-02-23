package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b {
    public final SharedPreferences a;

    public static class a {
        public static final long d = TimeUnit.DAYS.toMillis(7);
        public final String a;
        public final String b;
        public final long c;

        public a(String str, String str2, long j) {
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public static String a(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.w("FirebaseMessaging", "Failed to encode token: ".concat(e.toString()));
                return null;
            }
        }

        public static a c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e) {
                Log.w("FirebaseMessaging", "Failed to parse token: ".concat(e.toString()));
                return null;
            }
        }

        public boolean b(String str) {
            return System.currentTimeMillis() > this.c + d || !str.equals(this.b);
        }
    }

    public b(Context context) {
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    public final void a(Context context, String str) {
        File file = new File(E.b.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || e()) {
                return;
            }
            Log.i("FirebaseMessaging", "App restored, clearing state");
            c();
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    public final String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|*");
        return sb.toString();
    }

    public synchronized void c() {
        this.a.edit().clear().commit();
    }

    public synchronized a d(String str, String str2) {
        return a.c(this.a.getString(b(str, str2), (String) null));
    }

    public synchronized boolean e() {
        return this.a.getAll().isEmpty();
    }

    public synchronized void f(String str, String str2, String str3, String str4) {
        String a2 = a.a(str3, str4, System.currentTimeMillis());
        if (a2 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(b(str, str2), a2);
        edit.commit();
    }
}
