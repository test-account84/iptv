package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abf extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(10);
    public final String a;
    public final String b;

    /* JADX WARN: Illegal instructions before constructor call */
    public abf(Parcel parcel) {
        String readString = parcel.readString();
        int i = cq.a;
        super(readString);
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && abf.class == obj.getClass()) {
            abf abfVar = (abf) obj;
            if (this.f.equals(abfVar.f) && cq.V(this.a, abfVar.a) && cq.V(this.b, abfVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f.hashCode() + 527) * 31;
        String str = this.a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return this.f + ": url=" + this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public abf(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }
}
