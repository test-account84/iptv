package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aav extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(5);
    public final String a;
    public final String b;
    public final String c;
    public final byte[] d;

    public aav(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (byte[]) cq.G(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aav.class == obj.getClass()) {
            aav aavVar = (aav) obj;
            if (cq.V(this.a, aavVar.a) && cq.V(this.b, aavVar.b) && cq.V(this.c, aavVar.c) && Arrays.equals(this.d, aavVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.d);
    }

    public final String toString() {
        return this.f + ": mimeType=" + this.a + ", filename=" + this.b + ", description=" + this.c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeByteArray(this.d);
    }

    public aav(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bArr;
    }
}
