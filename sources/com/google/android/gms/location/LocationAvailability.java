package com.google.android.gms.location;

import J4.D;
import J4.N;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import java.util.Arrays;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class LocationAvailability extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new D();
    public int f;
    public int g;
    public long h;
    public int i;
    public N[] j;

    public LocationAvailability(int i, int i2, int i3, long j, N[] nArr) {
        this.i = i;
        this.f = i2;
        this.g = i3;
        this.h = j;
        this.j = nArr;
    }

    public boolean H() {
        return this.i < 1000;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f == locationAvailability.f && this.g == locationAvailability.g && this.h == locationAvailability.h && this.i == locationAvailability.i && Arrays.equals(this.j, locationAvailability.j)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return q.c(Integer.valueOf(this.i), Integer.valueOf(this.f), Integer.valueOf(this.g), Long.valueOf(this.h), this.j);
    }

    public String toString() {
        boolean H = H();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(H);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.l(parcel, 1, this.f);
        c.l(parcel, 2, this.g);
        c.o(parcel, 3, this.h);
        c.l(parcel, 4, this.i);
        c.w(parcel, 5, this.j, i, false);
        c.b(parcel, a);
    }
}
