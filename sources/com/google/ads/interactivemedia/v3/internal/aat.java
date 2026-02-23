package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aat extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(3);
    public final String a;
    public final boolean b;
    public final boolean c;
    public final String[] d;
    private final aba[] e;

    public aat(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = (String[]) cq.G(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.e = new aba[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.e[i2] = (aba) parcel.readParcelable(aba.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aat.class == obj.getClass()) {
            aat aatVar = (aat) obj;
            if (this.b == aatVar.b && this.c == aatVar.c && cq.V(this.a, aatVar.a) && Arrays.equals(this.d, aatVar.d) && Arrays.equals(this.e, aatVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((((this.b ? 1 : 0) + 527) * 31) + (this.c ? 1 : 0)) * 31;
        String str = this.a;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.d);
        parcel.writeInt(this.e.length);
        for (aba abaVar : this.e) {
            parcel.writeParcelable(abaVar, 0);
        }
    }

    public aat(String str, boolean z, boolean z2, String[] strArr, aba[] abaVarArr) {
        super("CTOC");
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = strArr;
        this.e = abaVarArr;
    }
}
