package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzael implements zzacs {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzael";
    private String zzb;
    private int zzc;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzael zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            this.zzc = jSONObject.getInt("code");
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (JSONException | NullPointerException e) {
            Log.e(zza, "Failed to parse error for string [" + str + "] with exception: " + e.getMessage());
            throw new zzaaf("Failed to parse error for string [" + str + "]", e);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
