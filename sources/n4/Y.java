package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y extends y4.a {
    public static final Parcelable.Creator CREATOR = new z();
    public final float f;
    public final float g;
    public final float h;

    public y(float f, float f2, float f3) {
        this.f = f;
        this.g = f2;
        this.h = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f == yVar.f && this.g == yVar.g && this.h == yVar.h;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Float.valueOf(this.f), Float.valueOf(this.g), Float.valueOf(this.h));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.i(parcel, 2, this.f);
        y4.c.i(parcel, 3, this.g);
        y4.c.i(parcel, 4, this.h);
        y4.c.b(parcel, a);
    }
}
