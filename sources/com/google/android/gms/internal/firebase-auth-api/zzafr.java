package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafr {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzagr zze;
    private String zzf;

    private zzafr(String str, String str2, String str3, long j, zzagr zzagrVar) {
        if (!TextUtils.isEmpty(str) && zzagrVar != null) {
            Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
            throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
        }
        this.zza = str;
        this.zzb = r.g(str2);
        this.zzc = str3;
        this.zzd = j;
        this.zze = zzagrVar;
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzagr zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zza;
    }

    private static long zza(String str) {
        try {
            return zzanc.zza(zzanc.zza(str));
        } catch (ParseException e) {
            Log.w("MfaInfo", "Could not parse timestamp as ISOString. Invalid ISOString \"" + str + "\"", e);
            return 0L;
        }
    }

    public static zzafr zza(JSONObject jSONObject) {
        zzafr zzafrVar = new zzafr(jSONObject.optString("phoneInfo", (String) null), jSONObject.optString("mfaEnrollmentId", (String) null), jSONObject.optString("displayName", (String) null), zza(jSONObject.optString("enrolledAt", "")), jSONObject.opt("totpInfo") != null ? new zzagr() : null);
        zzafrVar.zzf = jSONObject.optString("unobfuscatedPhoneInfo");
        return zzafrVar;
    }

    public static List zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }
}
