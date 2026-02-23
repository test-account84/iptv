package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzage implements zzacp {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;

    public zzage(String str) {
        this.zzd = str;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        if (str != null) {
            jSONObject.put("email", str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("password", str2);
        }
        String str3 = this.zzd;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zze;
        if (str4 != null) {
            zzahc.zza(jSONObject, "captchaResponse", str4);
        } else {
            zzahc.zza(jSONObject);
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("idToken", str5);
        }
        return jSONObject.toString();
    }

    public zzage(String str, String str2, String str3, String str4, String str5, String str6) {
        this.zza = r.g(str);
        this.zzb = r.g(str2);
        this.zzc = null;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }
}
