package com.google.android.gms.internal.firebase-auth-api;

import G5.d;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafe implements zzacp {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private d zze;
    private String zzf;
    private String zzg;

    public zzafe(int i) {
        this.zza = zza(i);
    }

    public final zzafe zza(d dVar) {
        this.zze = (d) r.m(dVar);
        return this;
    }

    public final d zzb() {
        return this.zze;
    }

    public final zzafe zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzafe zzd(String str) {
        this.zzd = r.g(str);
        return this;
    }

    private zzafe(int i, d dVar, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (d) r.m(dVar);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public static zzafe zza(d dVar, String str, String str2) {
        r.g(str);
        r.g(str2);
        r.m(dVar);
        return new zzafe(7, dVar, null, str2, str, null, null);
    }

    public final zzafe zzb(String str) {
        this.zzb = r.g(str);
        return this;
    }

    public final zzafe zza(String str) {
        this.zzg = str;
        return this;
    }

    public final String zza() throws JSONException {
        int i;
        i = 1;
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.hashCode();
        switch (str) {
            case "PASSWORD_RESET":
                break;
            case "VERIFY_EMAIL":
                i = 4;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i = 7;
                break;
            case "EMAIL_SIGNIN":
                i = 6;
                break;
            default:
                i = 0;
                break;
        }
        jSONObject.put("requestType", i);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("email", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        d dVar = this.zze;
        if (dVar != null) {
            jSONObject.put("androidInstallApp", dVar.I());
            jSONObject.put("canHandleCodeInApp", this.zze.H());
            if (this.zze.M() != null) {
                jSONObject.put("continueUrl", this.zze.M());
            }
            if (this.zze.L() != null) {
                jSONObject.put("iosBundleId", this.zze.L());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.K() != null) {
                jSONObject.put("androidPackageName", this.zze.K());
            }
            if (this.zze.J() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.J());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzahc.zza(jSONObject, "captchaResp", str6);
        } else {
            zzahc.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    private static String zza(int i) {
        return i != 1 ? i != 4 ? i != 6 ? i != 7 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_AND_CHANGE_EMAIL" : "EMAIL_SIGNIN" : "VERIFY_EMAIL" : "PASSWORD_RESET";
    }
}
