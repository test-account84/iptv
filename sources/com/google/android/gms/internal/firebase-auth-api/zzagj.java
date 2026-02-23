package com.google.android.gms.internal.firebase-auth-api;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzagj implements zzacs {
    private static final String zza = "zzagj";

    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public zzagj zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                return (zzagn) ((zzagj) new zzagn().zza(str));
            }
            if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                return (zzagp) ((zzagj) new zzagp().zza(str));
            }
            throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
        } catch (NullPointerException e) {
            e = e;
            throw zzahc.zza((Exception) e, zza, str);
        } catch (JSONException e2) {
            e = e2;
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public String zza() {
        return null;
    }
}
