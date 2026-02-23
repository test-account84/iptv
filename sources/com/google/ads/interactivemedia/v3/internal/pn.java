package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class pn implements an {
    public static final Parcelable.Creator CREATOR = new pl(1);
    public final String a;
    public final String b;
    public final List c;

    public pn(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((pm) parcel.readParcelable(pm.class.getClassLoader()));
        }
        this.c = Collections.unmodifiableList(arrayList);
    }

    public final /* synthetic */ void a(ak akVar) {
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && pn.class == obj.getClass()) {
            pn pnVar = (pn) obj;
            if (TextUtils.equals(this.a, pnVar.a) && TextUtils.equals(this.b, pnVar.b) && this.c.equals(pnVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode();
    }

    public final String toString() {
        String str;
        String str2 = this.a;
        if (str2 != null) {
            str = " [" + str2 + ", " + this.b + "]";
        } else {
            str = "";
        }
        return "HlsTrackMetadataEntry".concat(String.valueOf(str));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        int size = this.c.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((Parcelable) this.c.get(i2), 0);
        }
    }

    public pn(String str, String str2, List list) {
        this.a = str;
        this.b = str2;
        this.c = Collections.unmodifiableList(new ArrayList(list));
    }
}
