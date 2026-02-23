package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g implements a.c {
    public static final Parcelable.Creator CREATOR = new a();
    public final long a;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i) {
            return new g[i];
        }
    }

    public g(long j) {
        this.a = j;
    }

    public static g a(long j) {
        return new g(j);
    }

    public boolean b(long j) {
        return j >= this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.a == ((g) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
    }

    public /* synthetic */ g(long j, a aVar) {
        this(j);
    }
}
