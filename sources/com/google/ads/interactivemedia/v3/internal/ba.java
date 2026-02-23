package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ba implements Comparable, Parcelable {
    public static final Parcelable.Creator CREATOR = new m(3);
    public final int a;
    public final int b;
    public final int c;

    public ba() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        ba baVar = (ba) obj;
        int i = this.a - baVar.a;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - baVar.b;
        return i2 == 0 ? this.c - baVar.c : i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ba.class == obj.getClass()) {
            ba baVar = (ba) obj;
            if (this.a == baVar.a && this.b == baVar.b && this.c == baVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return this.a + "." + this.b + "." + this.c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    public ba(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }
}
