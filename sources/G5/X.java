package G5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.firebase-auth-api.zzagt;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class x extends g {
    public static final Parcelable.Creator CREATOR = new U();
    public String f;

    public x(String str) {
        this.f = com.google.android.gms.common.internal.r.g(str);
    }

    public static zzagt K(x xVar, String str) {
        com.google.android.gms.common.internal.r.m(xVar);
        return new zzagt(null, xVar.f, xVar.H(), null, null, null, str, null, null);
    }

    public String H() {
        return "github.com";
    }

    public String I() {
        return "github.com";
    }

    public final g J() {
        return new x(this.f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, this.f, false);
        y4.c.b(parcel, a);
    }
}
