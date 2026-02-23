package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzagz implements zzacs {
    private static final String zza = "zzagz";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private List zzi;
    private String zzj;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagz zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = o.a(jSONObject.optString("localId", (String) null));
            this.zzc = o.a(jSONObject.optString("email", (String) null));
            this.zzd = o.a(jSONObject.optString("displayName", (String) null));
            this.zze = o.a(jSONObject.optString("idToken", (String) null));
            this.zzf = o.a(jSONObject.optString("photoUrl", (String) null));
            this.zzg = o.a(jSONObject.optString("refreshToken", (String) null));
            this.zzh = jSONObject.optLong("expiresIn", 0L);
            this.zzi = zzafr.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzj = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final long zza() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zzj;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final List zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzj);
    }

    public final String zzb() {
        return this.zze;
    }
}
