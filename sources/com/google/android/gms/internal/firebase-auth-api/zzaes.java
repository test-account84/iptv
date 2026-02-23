package com.google.android.gms.internal.firebase-auth-api;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzaes implements zzacs {
    private static final String zza = "zzaes";
    private String zzb;
    private String zzc;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaes zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("idToken", (String) null);
            this.zzc = jSONObject.optString("refreshToken", (String) null);
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }
}
