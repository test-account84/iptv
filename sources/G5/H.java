package G5;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h extends g {
    public static final Parcelable.Creator CREATOR = new g0();
    public String f;
    public String g;
    public final String h;
    public String i;
    public boolean j;

    public h(String str, String str2, String str3, String str4, boolean z) {
        this.f = com.google.android.gms.common.internal.r.g(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = z;
    }

    public String H() {
        return "password";
    }

    public String I() {
        return !TextUtils.isEmpty(this.g) ? "password" : "emailLink";
    }

    public final g J() {
        return new h(this.f, this.g, this.h, this.i, this.j);
    }

    public final h K(u uVar) {
        this.i = uVar.zze();
        this.j = true;
        return this;
    }

    public final String L() {
        return this.i;
    }

    public final boolean M() {
        return !TextUtils.isEmpty(this.h);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, this.f, false);
        y4.c.t(parcel, 2, this.g, false);
        y4.c.t(parcel, 3, this.h, false);
        y4.c.t(parcel, 4, this.i, false);
        y4.c.c(parcel, 5, this.j);
        y4.c.b(parcel, a);
    }

    public final String zzc() {
        return this.f;
    }

    public final String zzd() {
        return this.g;
    }

    public final String zze() {
        return this.h;
    }

    public final boolean zzg() {
        return this.j;
    }
}
