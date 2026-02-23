package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import G5.f0;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzagv implements zzacs {
    private static final String zza = "zzagv";
    private boolean zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private boolean zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private String zzs;
    private List zzt;
    private String zzu;

    public final long zza() {
        return this.zzf;
    }

    public final f0 zzb() {
        if (TextUtils.isEmpty(this.zzn) && TextUtils.isEmpty(this.zzo)) {
            return null;
        }
        return f0.O(this.zzk, this.zzo, this.zzn, this.zzr, this.zzp);
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzq;
    }

    public final String zze() {
        return this.zzd;
    }

    public final String zzf() {
        return this.zzu;
    }

    public final String zzg() {
        return this.zzk;
    }

    public final String zzh() {
        return this.zzl;
    }

    public final String zzi() {
        return this.zze;
    }

    public final String zzj() {
        return this.zzs;
    }

    public final List zzk() {
        return this.zzt;
    }

    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzu);
    }

    public final boolean zzm() {
        return this.zzb;
    }

    public final boolean zzn() {
        return this.zzm;
    }

    public final boolean zzo() {
        return this.zzb || !TextUtils.isEmpty(this.zzq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagv zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optBoolean("needConfirmation", false);
            this.zzc = jSONObject.optBoolean("needEmail", false);
            this.zzd = o.a(jSONObject.optString("idToken", (String) null));
            this.zze = o.a(jSONObject.optString("refreshToken", (String) null));
            this.zzf = jSONObject.optLong("expiresIn", 0L);
            this.zzg = o.a(jSONObject.optString("localId", (String) null));
            this.zzh = o.a(jSONObject.optString("email", (String) null));
            this.zzi = o.a(jSONObject.optString("displayName", (String) null));
            this.zzj = o.a(jSONObject.optString("photoUrl", (String) null));
            this.zzk = o.a(jSONObject.optString("providerId", (String) null));
            this.zzl = o.a(jSONObject.optString("rawUserInfo", (String) null));
            this.zzm = jSONObject.optBoolean("isNewUser", false);
            this.zzn = jSONObject.optString("oauthAccessToken", (String) null);
            this.zzo = jSONObject.optString("oauthIdToken", (String) null);
            this.zzq = o.a(jSONObject.optString("errorMessage", (String) null));
            this.zzr = o.a(jSONObject.optString("pendingToken", (String) null));
            this.zzs = o.a(jSONObject.optString("tenantId", (String) null));
            this.zzt = zzafr.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzu = o.a(jSONObject.optString("mfaPendingCredential", (String) null));
            this.zzp = o.a(jSONObject.optString("oauthTokenSecret", (String) null));
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }
}
