package G5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.firebase-auth-api.zzagt;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class y extends g {
    public static final Parcelable.Creator CREATOR = new V();
    public final String f;
    public final String g;

    public y(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (str2 != null && str2.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.f = str;
        this.g = str2;
    }

    public static zzagt K(y yVar, String str) {
        com.google.android.gms.common.internal.r.m(yVar);
        return new zzagt(yVar.f, yVar.g, yVar.H(), null, null, null, str, null, null);
    }

    public String H() {
        return "google.com";
    }

    public String I() {
        return "google.com";
    }

    public final g J() {
        return new y(this.f, this.g);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, this.f, false);
        y4.c.t(parcel, 2, this.g, false);
        y4.c.b(parcel, a);
    }
}
