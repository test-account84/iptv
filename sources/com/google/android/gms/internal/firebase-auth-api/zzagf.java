package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzagf implements zzacs {
    private static final String zza = "zzagf";
    private String zzb;
    private String zzc;
    private Boolean zzd;
    private String zze;
    private String zzf;
    private zzafv zzg;
    private String zzh;
    private String zzi;
    private long zzj;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagf zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = o.a(jSONObject.optString("email", (String) null));
            this.zzc = o.a(jSONObject.optString("passwordHash", (String) null));
            this.zzd = Boolean.valueOf(jSONObject.optBoolean("emailVerified", false));
            this.zze = o.a(jSONObject.optString("displayName", (String) null));
            this.zzf = o.a(jSONObject.optString("photoUrl", (String) null));
            this.zzg = zzafv.zza(jSONObject.optJSONArray("providerUserInfo"));
            this.zzh = o.a(jSONObject.optString("idToken", (String) null));
            this.zzi = o.a(jSONObject.optString("refreshToken", (String) null));
            this.zzj = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final long zza() {
        return this.zzj;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final List zze() {
        zzafv zzafvVar = this.zzg;
        if (zzafvVar != null) {
            return zzafvVar.zza();
        }
        return null;
    }

    public final String zzb() {
        return this.zzb;
    }
}
