package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aap extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(1);
    public final String a;
    public final String b;
    public final int c;
    public final byte[] d;

    public aap(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = (byte[]) cq.G(parcel.createByteArray());
    }

    public final void a(ak akVar) {
        akVar.v(this.d, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aap.class == obj.getClass()) {
            aap aapVar = (aap) obj;
            if (this.c == aapVar.c && cq.V(this.a, aapVar.a) && cq.V(this.b, aapVar.b) && Arrays.equals(this.d, aapVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.c + 527) * 31;
        String str = this.a;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.d);
    }

    public final String toString() {
        return this.f + ": mimeType=" + this.a + ", description=" + this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeByteArray(this.d);
    }

    public aap(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = bArr;
    }
}
