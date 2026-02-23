package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzagy implements zzacp {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzagy() {
    }

    public static zzagy zza(String str, String str2, boolean z) {
        zzagy zzagyVar = new zzagy();
        zzagyVar.zzb = r.g(str);
        zzagyVar.zzc = r.g(str2);
        zzagyVar.zzf = z;
        return zzagyVar;
    }

    public static zzagy zzb(String str, String str2, boolean z) {
        zzagy zzagyVar = new zzagy();
        zzagyVar.zza = r.g(str);
        zzagyVar.zzd = r.g(str2);
        zzagyVar.zzf = z;
        return zzagyVar;
    }

    public final String zza() throws JSONException {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("sessionInfo", this.zzb);
            str = "code";
            str2 = this.zzc;
        } else {
            jSONObject.put("phoneNumber", this.zza);
            str = "temporaryProof";
            str2 = this.zzd;
        }
        jSONObject.put(str, str2);
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("idToken", str3);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
