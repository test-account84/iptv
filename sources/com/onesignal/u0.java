package com.onesignal;

import android.content.Intent;
import android.os.Bundle;
import com.onesignal.F1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class U0 {
    public static String a(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            String string = bundle.getString("custom", (String) null);
            if (string != null) {
                return c(string);
            }
            F1.a(F1.v.DEBUG, "Not a OneSignal formatted Bundle. No 'custom' field in the bundle.");
        }
        return null;
    }

    public static String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return c(jSONObject.optString("custom", (String) null));
    }

    public static String c(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            F1.a(F1.v.DEBUG, "Not a OneSignal formatted JSON String, error parsing string as JSON.");
        }
        if (jSONObject.has("i")) {
            return jSONObject.optString("i", (String) null);
        }
        F1.a(F1.v.DEBUG, "Not a OneSignal formatted JSON string. No 'i' field in custom.");
        return null;
    }

    public static boolean d(Bundle bundle) {
        return a(bundle) != null;
    }

    public static boolean e(Intent intent) {
        if (intent == null) {
            return false;
        }
        return d(intent.getExtras());
    }
}
