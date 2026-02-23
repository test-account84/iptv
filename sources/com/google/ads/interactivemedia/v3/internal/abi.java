package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abi implements an {
    public static final Parcelable.Creator CREATOR = new abh(0);
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public /* synthetic */ abi(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
    }

    public final /* synthetic */ void a(ak akVar) {
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && abi.class == obj.getClass()) {
            abi abiVar = (abi) obj;
            if (this.a == abiVar.a && this.b == abiVar.b && this.c == abiVar.c && this.d == abiVar.d && this.e == abiVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((azh.f(this.a) + 527) * 31) + azh.f(this.b)) * 31) + azh.f(this.c)) * 31) + azh.f(this.d)) * 31) + azh.f(this.e);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.a + ", photoSize=" + this.b + ", photoPresentationTimestampUs=" + this.c + ", videoStartPosition=" + this.d + ", videoSize=" + this.e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
    }
}
