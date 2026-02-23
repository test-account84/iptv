package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abg implements an {
    public static final Parcelable.Creator CREATOR = new abh(1);
    public final String a;
    public final byte[] b;
    public final int c;
    public final int d;

    public /* synthetic */ abg(Parcel parcel) {
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = (byte[]) cq.G(parcel.createByteArray());
        this.c = parcel.readInt();
        this.d = parcel.readInt();
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
        if (obj != null && abg.class == obj.getClass()) {
            abg abgVar = (abg) obj;
            if (this.a.equals(abgVar.a) && Arrays.equals(this.b, abgVar.b) && this.c == abgVar.c && this.d == abgVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() + 527) * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "mdta: key=".concat(String.valueOf(this.a));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    public abg(String str, byte[] bArr, int i, int i2) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }
}
