package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class t extends y4.a {
    public static final Parcelable.Creator CREATOR = new b0();
    public final int f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;

    public t(int i, boolean z, boolean z2, int i2, int i3) {
        this.f = i;
        this.g = z;
        this.h = z2;
        this.i = i2;
        this.j = i3;
    }

    public int H() {
        return this.i;
    }

    public int I() {
        return this.j;
    }

    public boolean J() {
        return this.g;
    }

    public boolean K() {
        return this.h;
    }

    public int L() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, L());
        y4.c.c(parcel, 2, J());
        y4.c.c(parcel, 3, K());
        y4.c.l(parcel, 4, H());
        y4.c.l(parcel, 5, I());
        y4.c.b(parcel, a);
    }
}
