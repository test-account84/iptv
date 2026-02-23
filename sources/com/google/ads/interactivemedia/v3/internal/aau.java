package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aau extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(4);
    public final String a;
    public final String b;
    public final String c;

    public aau(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aau.class == obj.getClass()) {
            aau aauVar = (aau) obj;
            if (cq.V(this.b, aauVar.b) && cq.V(this.a, aauVar.a) && cq.V(this.c, aauVar.c)) {
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
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return this.f + ": language=" + this.a + ", description=" + this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.a);
        parcel.writeString(this.c);
    }

    public aau(String str, String str2, String str3) {
        super("COMM");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }
}
