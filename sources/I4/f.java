package i4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f extends y4.a {
    public static final Parcelable.Creator CREATOR = new g();
    public final String f;
    public final int g;

    public f(String str, int i) {
        this.f = str;
        this.g = i;
    }

    public final int H() {
        return this.g;
    }

    public final String I() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, this.f, false);
        y4.c.l(parcel, 2, this.g);
        y4.c.b(parcel, a);
    }
}
