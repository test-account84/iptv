package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abc extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(7);
    public final int a;
    public final int b;
    public final int c;
    public final int[] d;
    public final int[] e;

    public abc(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
        this.e = iArr2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && abc.class == obj.getClass()) {
            abc abcVar = (abc) obj;
            if (this.a == abcVar.a && this.b == abcVar.b && this.c == abcVar.c && Arrays.equals(this.d, abcVar.d) && Arrays.equals(this.e, abcVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a + 527) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeIntArray(this.e);
    }

    public abc(Parcel parcel) {
        super("MLLT");
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = (int[]) cq.G(parcel.createIntArray());
        this.e = (int[]) cq.G(parcel.createIntArray());
    }
}
