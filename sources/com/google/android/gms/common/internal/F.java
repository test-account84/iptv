package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class f extends y4.a {
    public static final Parcelable.Creator CREATOR = new m0();
    public final t f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final int j;
    public final int[] k;

    public f(t tVar, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.f = tVar;
        this.g = z;
        this.h = z2;
        this.i = iArr;
        this.j = i;
        this.k = iArr2;
    }

    public int H() {
        return this.j;
    }

    public int[] I() {
        return this.i;
    }

    public int[] J() {
        return this.k;
    }

    public boolean K() {
        return this.g;
    }

    public boolean L() {
        return this.h;
    }

    public final t M() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.r(parcel, 1, this.f, i, false);
        y4.c.c(parcel, 2, K());
        y4.c.c(parcel, 3, L());
        y4.c.m(parcel, 4, I(), false);
        y4.c.l(parcel, 5, H());
        y4.c.m(parcel, 6, J(), false);
        y4.c.b(parcel, a);
    }
}
