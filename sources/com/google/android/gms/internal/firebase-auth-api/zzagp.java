package com.google.android.gms.internal.firebase-auth-api;

import android.util.Log;
import java.text.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzagp extends zzagj {
    private static final String zza = "zzagp";
    private String zzb;
    private String zzc;
    private int zzd;
    private String zze;
    private int zzf;
    private long zzg;

    public final /* synthetic */ zzacs zza(String str) throws zzaaf {
        return (zzagp) zza(str);
    }

    public final int zzb() {
        return this.zzf;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzagp zzb(String str) throws zzaaf {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("totpSessionInfo");
            if (optJSONObject != null) {
                this.zzc = zzag.zza(optJSONObject.optString("sharedSecretKey"));
                this.zzd = optJSONObject.optInt("verificationCodeLength");
                this.zze = zzag.zza(optJSONObject.optString("hashingAlgorithm"));
                this.zzf = optJSONObject.optInt("periodSec");
                this.zzb = zzag.zza(optJSONObject.optString("sessionInfo"));
                String optString = optJSONObject.optString("finalizeEnrollmentTime");
                try {
                    this.zzg = zzanc.zza(zzanc.zza(optString));
                } catch (ParseException unused) {
                    Log.e(zza, "Failed to parse timestamp: " + optString);
                }
            }
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
