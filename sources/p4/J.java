package P4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.N;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends y4.a {
    public static final Parcelable.Creator CREATOR = new k();
    public final int f;
    public final N g;

    public j(int i, N n) {
        this.f = i;
        this.g = n;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, this.f);
        y4.c.r(parcel, 2, this.g, i, false);
        y4.c.b(parcel, a);
    }
}
