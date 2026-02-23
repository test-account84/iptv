package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzagi implements zzacp {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private zzaee zzh;

    private zzagi(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = r.g(str);
        this.zzb = r.g(str2);
        this.zzc = r.g(str3);
        this.zze = str4;
        this.zzd = str5;
        this.zzf = str6;
        this.zzg = str7;
    }

    public static zzagi zza(String str, String str2, String str3, String str4, String str5, String str6) {
        r.g(str3);
        return new zzagi("phone", str, str2, str3, str4, str5, str6);
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaPendingCredential", this.zzb);
        jSONObject.put("mfaEnrollmentId", this.zzc);
        this.zza.hashCode();
        jSONObject.put("mfaProvider", 1);
        if (this.zze != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zze);
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("recaptchaToken", this.zzf);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject2.put("playIntegrityToken", this.zzg);
            }
            zzaee zzaeeVar = this.zzh;
            if (zzaeeVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzaeeVar.zza());
            }
            jSONObject.put("phoneSignInInfo", jSONObject2);
        }
        return jSONObject.toString();
    }

    public final void zza(zzaee zzaeeVar) {
        this.zzh = zzaeeVar;
    }
}
