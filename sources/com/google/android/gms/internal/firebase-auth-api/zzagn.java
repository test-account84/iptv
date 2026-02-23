package com.google.android.gms.internal.firebase-auth-api;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzagn extends zzagj {
    private static final String zza = "zzagn";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzagn zzb(String str) throws zzaaf {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzag.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final /* synthetic */ zzacs zza(String str) throws zzaaf {
        return (zzagn) zza(str);
    }

    public final String zza() {
        return this.zzb;
    }
}
