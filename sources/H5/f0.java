package H5;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.firebase-auth-api.zzafc;
import com.google.android.gms.internal.firebase-auth-api.zzafs;
import com.google.android.gms.internal.firebase-auth-api.zzxw;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f0 extends y4.a implements G5.O {
    public static final Parcelable.Creator CREATOR = new i0();
    public String f;
    public String g;
    public String h;
    public String i;
    public Uri j;
    public String k;
    public String l;
    public boolean m;
    public String n;

    public f0(zzafc zzafcVar, String str) {
        com.google.android.gms.common.internal.r.m(zzafcVar);
        com.google.android.gms.common.internal.r.g(str);
        this.f = com.google.android.gms.common.internal.r.g(zzafcVar.zzi());
        this.g = str;
        this.k = zzafcVar.zzh();
        this.h = zzafcVar.zzg();
        Uri zzc = zzafcVar.zzc();
        if (zzc != null) {
            this.i = zzc.toString();
            this.j = zzc;
        }
        this.m = zzafcVar.zzm();
        this.n = null;
        this.l = zzafcVar.zzj();
    }

    public static f0 M(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new f0(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzxw(e);
        }
    }

    public final String H() {
        return this.h;
    }

    public final String I() {
        return this.k;
    }

    public final String J() {
        return this.l;
    }

    public final String K() {
        return this.f;
    }

    public final boolean L() {
        return this.m;
    }

    public final String N() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f);
            jSONObject.putOpt("providerId", this.g);
            jSONObject.putOpt("displayName", this.h);
            jSONObject.putOpt("photoUrl", this.i);
            jSONObject.putOpt("email", this.k);
            jSONObject.putOpt("phoneNumber", this.l);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.m));
            jSONObject.putOpt("rawUserInfo", this.n);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzxw(e);
        }
    }

    public final String g() {
        return this.g;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, K(), false);
        y4.c.t(parcel, 2, g(), false);
        y4.c.t(parcel, 3, H(), false);
        y4.c.t(parcel, 4, this.i, false);
        y4.c.t(parcel, 5, I(), false);
        y4.c.t(parcel, 6, J(), false);
        y4.c.c(parcel, 7, L());
        y4.c.t(parcel, 8, this.n, false);
        y4.c.b(parcel, a);
    }

    public final String zza() {
        return this.n;
    }

    public f0(zzafs zzafsVar) {
        com.google.android.gms.common.internal.r.m(zzafsVar);
        this.f = zzafsVar.zzd();
        this.g = com.google.android.gms.common.internal.r.g(zzafsVar.zzf());
        this.h = zzafsVar.zzb();
        Uri zza = zzafsVar.zza();
        if (zza != null) {
            this.i = zza.toString();
            this.j = zza;
        }
        this.k = zzafsVar.zzc();
        this.l = zzafsVar.zze();
        this.m = false;
        this.n = zzafsVar.zzg();
    }

    public f0(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.f = str;
        this.g = str2;
        this.k = str3;
        this.l = str4;
        this.h = str5;
        this.i = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.j = Uri.parse(this.i);
        }
        this.m = z;
        this.n = str7;
    }
}
