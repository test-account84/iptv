package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aas extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(2);
    public final String a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    private final aba[] g;

    public aas(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        int readInt = parcel.readInt();
        this.g = new aba[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.g[i2] = (aba) parcel.readParcelable(aba.class.getClassLoader());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aas.class == obj.getClass()) {
            aas aasVar = (aas) obj;
            if (this.b == aasVar.b && this.c == aasVar.c && this.d == aasVar.d && this.e == aasVar.e && cq.V(this.a, aasVar.a) && Arrays.equals(this.g, aasVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((this.b + 527) * 31) + this.c) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31;
        String str = this.a;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.g.length);
        for (aba abaVar : this.g) {
            parcel.writeParcelable(abaVar, 0);
        }
    }

    public aas(String str, int i, int i2, long j, long j2, aba[] abaVarArr) {
        super("CHAP");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.g = abaVarArr;
    }
}
