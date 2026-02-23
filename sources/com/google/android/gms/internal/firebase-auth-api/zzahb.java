package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzahb implements zzacs {
    private static final String zza = "zzahb";
    private String zzb;
    private String zzc;
    private long zzd;
    private String zze;
    private boolean zzf;
    private String zzg;
    private String zzh;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahb zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = o.a(jSONObject.optString("idToken", (String) null));
            this.zzc = o.a(jSONObject.optString("refreshToken", (String) null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            this.zze = o.a(jSONObject.optString("localId", (String) null));
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = o.a(jSONObject.optString("temporaryProof", (String) null));
            this.zzh = o.a(jSONObject.optString("phoneNumber", (String) null));
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zzb;
    }
}
