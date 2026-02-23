package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzaen implements zzacs {
    private static final String zza = "zzaen";
    private String zzb;
    private boolean zzc;
    private String zzd;
    private boolean zze;
    private zzago zzf = zzago.zza();
    private List zzg;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaen zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", (String) null);
            this.zzc = jSONObject.optBoolean("registered", false);
            this.zzd = jSONObject.optString("providerId", (String) null);
            this.zze = jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                this.zzf = new zzago(1, zzahc.zza(jSONObject.optJSONArray("allProviders")));
            } else {
                this.zzf = zzago.zza();
            }
            this.zzg = zzahc.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (JSONException e) {
            e = e;
            throw zzahc.zza((Exception) e, zza, str);
        } catch (NullPointerException e2) {
            e = e2;
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final List zza() {
        return this.zzg;
    }
}
