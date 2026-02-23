package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ao implements Parcelable {
    public static final Parcelable.Creator CREATOR = new m(2);
    public final long a;
    private final an[] b;

    public ao(long j, an... anVarArr) {
        this.a = j;
        this.b = anVarArr;
    }

    public final int a() {
        return this.b.length;
    }

    public final an b(int i) {
        return this.b[i];
    }

    public final ao c(an... anVarArr) {
        return anVarArr.length == 0 ? this : new ao(this.a, (an[]) cq.ah(this.b, anVarArr));
    }

    public final ao d(ao aoVar) {
        return aoVar == null ? this : c(aoVar.b);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ao.class == obj.getClass()) {
            ao aoVar = (ao) obj;
            if (Arrays.equals(this.b, aoVar.b) && this.a == aoVar.a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.b) * 31) + azh.f(this.a);
    }

    public final String toString() {
        String str;
        String arrays = Arrays.toString(this.b);
        long j = this.a;
        if (j == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j;
        }
        return "entries=" + arrays + str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b.length);
        for (an anVar : this.b) {
            parcel.writeParcelable(anVar, 0);
        }
        parcel.writeLong(this.a);
    }

    public ao(Parcel parcel) {
        this.b = new an[parcel.readInt()];
        int i = 0;
        while (true) {
            an[] anVarArr = this.b;
            if (i >= anVarArr.length) {
                this.a = parcel.readLong();
                return;
            } else {
                anVarArr[i] = (an) parcel.readParcelable(an.class.getClassLoader());
                i++;
            }
        }
    }

    public ao(List list) {
        this((an[]) list.toArray(new an[0]));
    }

    public ao(an... anVarArr) {
        this(-9223372036854775807L, anVarArr);
    }
}
