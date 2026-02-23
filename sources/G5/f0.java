package G5;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.firebase-auth-api.zzag;
import com.google.android.gms.internal.firebase-auth-api.zzagt;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class f0 extends E {
    public static final Parcelable.Creator CREATOR = new e0();
    public final String f;
    public final String g;
    public final String h;
    public final zzagt i;
    public final String j;
    public final String k;
    public final String l;

    public f0(String str, String str2, String str3, zzagt zzagtVar, String str4, String str5, String str6) {
        this.f = zzag.zzb(str);
        this.g = str2;
        this.h = str3;
        this.i = zzagtVar;
        this.j = str4;
        this.k = str5;
        this.l = str6;
    }

    public static f0 N(zzagt zzagtVar) {
        com.google.android.gms.common.internal.r.n(zzagtVar, "Must specify a non-null webSignInCredential");
        return new f0(null, null, null, zzagtVar, null, null, null);
    }

    public static f0 O(String str, String str2, String str3, String str4, String str5) {
        com.google.android.gms.common.internal.r.h(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new f0(str, str2, str3, null, str4, str5, null);
    }

    public static zzagt P(f0 f0Var, String str) {
        com.google.android.gms.common.internal.r.m(f0Var);
        zzagt zzagtVar = f0Var.i;
        return zzagtVar != null ? zzagtVar : new zzagt(f0Var.L(), f0Var.K(), f0Var.H(), null, f0Var.M(), null, str, f0Var.j, f0Var.l);
    }

    public String H() {
        return this.f;
    }

    public String I() {
        return this.f;
    }

    public final g J() {
        return new f0(this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }

    public String K() {
        return this.h;
    }

    public String L() {
        return this.g;
    }

    public String M() {
        return this.k;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, H(), false);
        y4.c.t(parcel, 2, L(), false);
        y4.c.t(parcel, 3, K(), false);
        y4.c.r(parcel, 4, this.i, i, false);
        y4.c.t(parcel, 5, this.j, false);
        y4.c.t(parcel, 6, M(), false);
        y4.c.t(parcel, 7, this.l, false);
        y4.c.b(parcel, a);
    }
}
