package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aao implements an {
    public static final Parcelable.Creator CREATOR = new aan();
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final int f;

    public aao(int i, String str, String str2, String str3, boolean z, int i2) {
        boolean z2 = true;
        if (i2 != -1 && i2 <= 0) {
            z2 = false;
        }
        af.u(z2);
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = i2;
    }

    public final void a(ak akVar) {
        String str = this.c;
        if (str != null) {
            akVar.K(str);
        }
        String str2 = this.b;
        if (str2 != null) {
            akVar.D(str2);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aao.class == obj.getClass()) {
            aao aaoVar = (aao) obj;
            if (this.a == aaoVar.a && cq.V(this.b, aaoVar.b) && cq.V(this.c, aaoVar.c) && cq.V(this.d, aaoVar.d) && this.e == aaoVar.e && this.f == aaoVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.a + 527) * 31;
        String str = this.b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.e ? 1 : 0)) * 31) + this.f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.c + "\", genre=\"" + this.b + "\", bitrate=" + this.a + ", metadataInterval=" + this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        cq.U(parcel, this.e);
        parcel.writeInt(this.f);
    }

    public aao(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = cq.ac(parcel);
        this.f = parcel.readInt();
    }
}
