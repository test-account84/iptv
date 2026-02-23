package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p extends y4.a {
    public static final Parcelable.Creator CREATOR = new M();
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final long j;
    public final String k;
    public final String l;
    public final int m;
    public final int n;

    public p(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = j;
        this.j = j2;
        this.k = str;
        this.l = str2;
        this.m = i4;
        this.n = i5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f;
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, i2);
        y4.c.l(parcel, 2, this.g);
        y4.c.l(parcel, 3, this.h);
        y4.c.o(parcel, 4, this.i);
        y4.c.o(parcel, 5, this.j);
        y4.c.t(parcel, 6, this.k, false);
        y4.c.t(parcel, 7, this.l, false);
        y4.c.l(parcel, 8, this.m);
        y4.c.l(parcel, 9, this.n);
        y4.c.b(parcel, a);
    }
}
