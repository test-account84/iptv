package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abd extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(8);
    public final String a;
    public final byte[] b;

    public abd(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = (byte[]) cq.G(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && abd.class == obj.getClass()) {
            abd abdVar = (abd) obj;
            if (cq.V(this.a, abdVar.a) && Arrays.equals(this.b, abdVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.b);
    }

    public final String toString() {
        return this.f + ": owner=" + this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
    }

    public abd(String str, byte[] bArr) {
        super("PRIV");
        this.a = str;
        this.b = bArr;
    }
}
