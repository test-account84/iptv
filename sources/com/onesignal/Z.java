package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class z {
    public static final z a = new z();

    public final y a(Context context, JSONObject fcmPayload) {
        kotlin.jvm.internal.l.e(context, "context");
        kotlin.jvm.internal.l.e(fcmPayload, "fcmPayload");
        Y0 y0 = new Y0(context, fcmPayload);
        return new y(context, b(y0.b()), c(y0.a(), fcmPayload));
    }

    public final Intent b(Uri uri) {
        if (uri == null) {
            return null;
        }
        return OSUtils.O(uri);
    }

    public final boolean c(boolean z, JSONObject jSONObject) {
        return z | (H0.a(jSONObject) != null);
    }
}
