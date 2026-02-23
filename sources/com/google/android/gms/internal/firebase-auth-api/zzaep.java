package com.google.android.gms.internal.firebase-auth-api;

import G5.e;
import G5.h;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzaep implements zzacp {
    private static final String zza = "zzaep";
    private static final A4.a zzb = new A4.a(zzaep.class.getSimpleName(), new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    public zzaep(h hVar, String str, String str2) {
        this.zzc = r.g(hVar.zzc());
        this.zzd = r.g(hVar.zze());
        this.zze = str;
        this.zzf = str2;
    }

    public final String zza() throws JSONException {
        e b = e.b(this.zzd);
        String a = b != null ? b.a() : null;
        String c = b != null ? b.c() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzc);
        if (a != null) {
            jSONObject.put("oobCode", a);
        }
        if (c != null) {
            jSONObject.put("tenantId", c);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            zzahc.zza(jSONObject, "captchaResp", str2);
        } else {
            zzahc.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
