package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafq extends y4.a {
    public static final Parcelable.Creator CREATOR = new zzaft();
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzafq(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public static zzap zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return zzap.zza((Collection) new ArrayList());
        }
        zzao zzg = zzap.zzg();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            zzg.zza(new zzafq(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
        }
        return zzg.zza();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.t(parcel, 1, this.zza, false);
        c.t(parcel, 2, this.zzb, false);
        c.t(parcel, 3, this.zzc, false);
        c.b(parcel, a);
    }
}
