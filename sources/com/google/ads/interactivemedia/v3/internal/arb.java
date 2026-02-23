package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class arb extends y4.a {
    public static final Parcelable.Creator CREATOR = new ard(1);
    private final String a;
    private final int b;
    private final String c;

    @Hide
    public arb(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, this.a, false);
        y4.c.l(parcel, 2, this.b);
        y4.c.t(parcel, 3, this.c, false);
        y4.c.b(parcel, a);
    }
}
