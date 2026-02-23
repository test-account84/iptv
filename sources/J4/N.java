package J4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n extends y4.a {
    public static final Parcelable.Creator CREATOR = new M();
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public n(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = z6;
    }

    public boolean H() {
        return this.k;
    }

    public boolean I() {
        return this.h;
    }

    public boolean J() {
        return this.i;
    }

    public boolean K() {
        return this.f;
    }

    public boolean L() {
        return this.j;
    }

    public boolean M() {
        return this.g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.c(parcel, 1, K());
        y4.c.c(parcel, 2, M());
        y4.c.c(parcel, 3, I());
        y4.c.c(parcel, 4, J());
        y4.c.c(parcel, 5, L());
        y4.c.c(parcel, 6, H());
        y4.c.b(parcel, a);
    }
}
