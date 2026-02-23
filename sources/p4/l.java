package P4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.P;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends y4.a {
    public static final Parcelable.Creator CREATOR = new m();
    public final int f;
    public final w4.b g;
    public final P h;

    public l(int i, w4.b bVar, P p) {
        this.f = i;
        this.g = bVar;
        this.h = p;
    }

    public final w4.b H() {
        return this.g;
    }

    public final P I() {
        return this.h;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, this.f);
        y4.c.r(parcel, 2, this.g, i, false);
        y4.c.r(parcel, 3, this.h, i, false);
        y4.c.b(parcel, a);
    }
}
