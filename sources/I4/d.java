package i4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends y4.a {
    public static final Parcelable.Creator CREATOR = new e();
    public final String f;
    public final String g;

    public d(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, this.f, false);
        y4.c.t(parcel, 2, this.g, false);
        y4.c.b(parcel, a);
    }
}
