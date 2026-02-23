package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzagh implements zzacs {
    private static final String zza = "zzagh";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private long zzf;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagh zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = o.a(jSONObject.optString("idToken", (String) null));
            this.zzc = o.a(jSONObject.optString("displayName", (String) null));
            this.zzd = o.a(jSONObject.optString("email", (String) null));
            this.zze = o.a(jSONObject.optString("refreshToken", (String) null));
            this.zzf = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzb;
    }
}
