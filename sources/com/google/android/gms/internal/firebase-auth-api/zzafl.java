package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafl implements zzacp {
    private final String zza;
    private final String zzb = "CLIENT_TYPE_ANDROID";
    private final String zzc;

    private zzafl(String str, String str2) {
        this.zza = str;
        this.zzc = str2;
    }

    public static zzafl zza(String str, String str2) {
        return new zzafl(str, str2);
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zza)) {
            jSONObject.put("tenantId", this.zza);
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("clientType", this.zzb);
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            jSONObject.put("recaptchaVersion", this.zzc);
        }
        return jSONObject.toString();
    }
}
