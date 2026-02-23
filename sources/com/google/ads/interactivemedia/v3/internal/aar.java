package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aar extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(0);
    public final byte[] a;

    /* JADX WARN: Illegal instructions before constructor call */
    public aar(Parcel parcel) {
        String readString = parcel.readString();
        int i = cq.a;
        super(readString);
        this.a = (byte[]) cq.G(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aar.class == obj.getClass()) {
            aar aarVar = (aar) obj;
            if (this.f.equals(aarVar.f) && Arrays.equals(this.a, aarVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f.hashCode() + 527) * 31) + Arrays.hashCode(this.a);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeByteArray(this.a);
    }

    public aar(String str, byte[] bArr) {
        super(str);
        this.a = bArr;
    }
}
