package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k0 extends y4.a {
    public static final Parcelable.Creator CREATOR = new l0();
    public Bundle f;
    public w4.d[] g;
    public int h;
    public f i;

    public k0(Bundle bundle, w4.d[] dVarArr, int i, f fVar) {
        this.f = bundle;
        this.g = dVarArr;
        this.h = i;
        this.i = fVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.e(parcel, 1, this.f, false);
        y4.c.w(parcel, 2, this.g, i, false);
        y4.c.l(parcel, 3, this.h);
        y4.c.r(parcel, 4, this.i, i, false);
        y4.c.b(parcel, a);
    }
}
