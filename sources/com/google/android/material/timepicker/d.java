package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final b a;
    public final b c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public d(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.d = i4;
        this.h = d(i);
        this.a = new b(59);
        this.c = new b(i4 == 1 ? 24 : 12);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return c(resources, charSequence, "%02d");
    }

    public static String c(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
    }

    public static int d(int i) {
        return i >= 12 ? 1 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.e == dVar.e && this.f == dVar.f && this.d == dVar.d && this.g == dVar.g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.d);
    }

    public d(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
