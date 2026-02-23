package com.google.android.gms.internal.firebase-auth-api;

import H5.V;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzagt extends y4.a implements zzacp {
    public static final Parcelable.Creator CREATOR = new zzags();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private boolean zzo;
    private String zzp;

    public zzagt() {
        this.zzi = true;
        this.zzj = true;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.t(parcel, 2, this.zza, false);
        c.t(parcel, 3, this.zzb, false);
        c.t(parcel, 4, this.zzc, false);
        c.t(parcel, 5, this.zzd, false);
        c.t(parcel, 6, this.zze, false);
        c.t(parcel, 7, this.zzf, false);
        c.t(parcel, 8, this.zzg, false);
        c.t(parcel, 9, this.zzh, false);
        c.c(parcel, 10, this.zzi);
        c.c(parcel, 11, this.zzj);
        c.t(parcel, 12, this.zzk, false);
        c.t(parcel, 13, this.zzl, false);
        c.t(parcel, 14, this.zzm, false);
        c.t(parcel, 15, this.zzn, false);
        c.c(parcel, 16, this.zzo);
        c.t(parcel, 17, this.zzp, false);
        c.b(parcel, a);
    }

    public final zzagt zza(String str) {
        this.zzb = r.g(str);
        return this;
    }

    public final zzagt zzb(String str) {
        this.zzn = str;
        return this;
    }

    public final zzagt zzc(boolean z) {
        this.zzi = true;
        return this;
    }

    public zzagt(V v, String str) {
        r.m(v);
        this.zzl = r.g(v.d());
        this.zzm = r.g(str);
        this.zze = r.g(v.c());
        this.zzi = true;
        this.zzg = "providerId=" + this.zze;
    }

    public final zzagt zza(boolean z) {
        this.zzj = false;
        return this;
    }

    public final zzagt zzb(boolean z) {
        this.zzo = true;
        return this;
    }

    public zzagt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = "http://localhost";
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.zzd) && TextUtils.isEmpty(this.zzk)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        this.zze = r.g(str3);
        this.zzf = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.zzc)) {
            sb.append("id_token=");
            sb.append(this.zzc);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            sb.append("access_token=");
            sb.append(this.zzd);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzf)) {
            sb.append("identifier=");
            sb.append(this.zzf);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            sb.append("oauth_token_secret=");
            sb.append(this.zzh);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzk)) {
            sb.append("code=");
            sb.append(this.zzk);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(str9)) {
            sb.append("nonce=");
            sb.append(str9);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.zze);
        this.zzg = sb.toString();
        this.zzj = true;
    }

    public final String zza() throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        String str3 = this.zzg;
        if (str3 != null) {
            jSONObject.put("postBody", str3);
        }
        String str4 = this.zzn;
        if (str4 != null) {
            jSONObject.put("tenantId", str4);
        }
        String str5 = this.zzp;
        if (str5 != null) {
            jSONObject.put("pendingToken", str5);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            jSONObject.put("sessionId", this.zzl);
        }
        if (TextUtils.isEmpty(this.zzm)) {
            str = this.zza;
            if (str != null) {
            }
            jSONObject.put("returnIdpCredential", this.zzo);
            return jSONObject.toString();
        }
        str = this.zzm;
        jSONObject.put("requestUri", str);
        jSONObject.put("returnIdpCredential", this.zzo);
        return jSONObject.toString();
    }

    public zzagt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, String str11, String str12, boolean z3, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z;
        this.zzj = z2;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z3;
        this.zzp = str13;
    }
}
