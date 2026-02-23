package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzagk implements zzagg {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private zzaee zzg;
    private final String zzh = null;

    private zzagk(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = r.g(str);
        this.zzb = r.g(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }

    public static zzagk zza(String str, String str2, String str3, String str4, String str5, String str6) {
        r.g(str2);
        return new zzagk(str, "phone", str2, str3, str4, str5, null);
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        jSONObject.put("mfaProvider", 1);
        if (this.zzc != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zzc);
            if (!TextUtils.isEmpty(this.zze)) {
                jSONObject2.put("recaptchaToken", this.zze);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("playIntegrityToken", this.zzf);
            }
            zzaee zzaeeVar = this.zzg;
            if (zzaeeVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzaeeVar.zza());
            }
            jSONObject.put("phoneEnrollmentInfo", jSONObject2);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            jSONObject.put("tenantId", (Object) null);
        }
        return jSONObject.toString();
    }

    public final void zza(zzaee zzaeeVar) {
        this.zzg = zzaeeVar;
    }
}
