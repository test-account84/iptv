package com.google.android.gms.internal.firebase-auth-api;

import C4.h;
import C4.o;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzafn extends y4.a implements zzacs {
    public static final Parcelable.Creator CREATOR = new zzafm();
    private static final String zza = "zzafn";
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;

    public zzafn() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzafn zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = o.a(jSONObject.optString("refresh_token"));
            this.zzc = o.a(jSONObject.optString("access_token"));
            this.zzd = Long.valueOf(jSONObject.optLong("expires_in", 0L));
            this.zze = o.a(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (JSONException | NullPointerException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.t(parcel, 2, this.zzb, false);
        c.t(parcel, 3, this.zzc, false);
        c.q(parcel, 4, Long.valueOf(zza()), false);
        c.t(parcel, 5, this.zze, false);
        Long l = this.zzf;
        l.longValue();
        c.q(parcel, 6, l, false);
        c.b(parcel, a);
    }

    public final long zza() {
        Long l = this.zzd;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final long zzb() {
        return this.zzf.longValue();
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzb);
            jSONObject.put("access_token", this.zzc);
            jSONObject.put("expires_in", this.zzd);
            jSONObject.put("token_type", this.zze);
            jSONObject.put("issued_at", this.zzf);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d(zza, "Failed to convert GetTokenResponse to JSON");
            throw new zzxw(e);
        }
    }

    public final boolean zzg() {
        return h.c().a() + 300000 < this.zzf.longValue() + (this.zzd.longValue() * 1000);
    }

    public zzafn(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }

    public static zzafn zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzafn zzafnVar = new zzafn();
            zzafnVar.zzb = jSONObject.optString("refresh_token", (String) null);
            zzafnVar.zzc = jSONObject.optString("access_token", (String) null);
            zzafnVar.zzd = Long.valueOf(jSONObject.optLong("expires_in"));
            zzafnVar.zze = jSONObject.optString("token_type", (String) null);
            zzafnVar.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzafnVar;
        } catch (JSONException e) {
            Log.d(zza, "Failed to read GetTokenResponse from JSONObject");
            throw new zzxw(e);
        }
    }

    public final void zzc(String str) {
        this.zzb = r.g(str);
    }

    public final String zzd() {
        return this.zzb;
    }

    public zzafn(String str, String str2, Long l, String str3, Long l2) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l;
        this.zze = str3;
        this.zzf = l2;
    }
}
