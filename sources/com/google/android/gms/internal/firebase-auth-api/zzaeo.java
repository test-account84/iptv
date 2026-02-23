package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzaeo implements zzacs {
    private static final String zza = "zzaeo";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private long zzg;
    private List zzh;
    private String zzi;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaeo zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("localId", (String) null);
            this.zzc = jSONObject.optString("email", (String) null);
            this.zzd = jSONObject.optString("idToken", (String) null);
            this.zze = jSONObject.optString("refreshToken", (String) null);
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = jSONObject.optLong("expiresIn", 0L);
            this.zzh = zzafr.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzi = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final long zza() {
        return this.zzg;
    }

    public final String zzc() {
        return this.zzi;
    }

    public final String zzd() {
        return this.zze;
    }

    public final List zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzi);
    }

    public final boolean zzg() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zzd;
    }
}
