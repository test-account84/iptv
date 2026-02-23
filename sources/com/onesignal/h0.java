package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class H0 {
    public static final H0 a = new H0();

    public static final String a(JSONObject payload) {
        JSONObject optJSONObject;
        kotlin.jvm.internal.l.e(payload, "payload");
        try {
            JSONObject b = T.b(payload);
            kotlin.jvm.internal.l.d(b, "{\n            Notificati…Object(payload)\n        }");
            if (b.has("a") && (optJSONObject = b.optJSONObject("a")) != null && optJSONObject.has("os_in_app_message_preview_id")) {
                return optJSONObject.optString("os_in_app_message_preview_id");
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static final boolean b(Activity activity, JSONObject jsonData) {
        kotlin.jvm.internal.l.e(activity, "activity");
        kotlin.jvm.internal.l.e(jsonData, "jsonData");
        String a2 = a(jsonData);
        if (a2 == null) {
            return false;
        }
        F1.d1(activity, new JSONArray().put(jsonData));
        F1.b0().G(a2);
        return true;
    }

    public static final boolean c(Context context, Bundle bundle) {
        JSONObject a2 = T.a(bundle);
        kotlin.jvm.internal.l.d(a2, "bundleAsJSONObject(bundle)");
        String a3 = a(a2);
        if (a3 == null) {
            return false;
        }
        if (F1.M0()) {
            F1.b0().G(a3);
            return true;
        }
        if (!a.d()) {
            return true;
        }
        x.m(new V0(context, a2));
        return true;
    }

    public final boolean d() {
        return true;
    }
}
