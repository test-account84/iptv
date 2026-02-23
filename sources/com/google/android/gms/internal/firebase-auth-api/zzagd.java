package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzagd implements zzacs {
    private static final String zza = "zzagd";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagd zza(String str) throws zzaaf {
        try {
            this.zzb = o.a(new JSONObject(str).optString("sessionInfo", (String) null));
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
