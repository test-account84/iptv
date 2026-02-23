package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ass extends y4.a {
    public static final Parcelable.Creator CREATOR = new asm(2);
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;

    public ass(int i, int i2, int i3, String str, String str2) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, this.a);
        y4.c.l(parcel, 2, this.b);
        y4.c.t(parcel, 3, this.c, false);
        y4.c.t(parcel, 4, this.d, false);
        y4.c.l(parcel, 5, this.e);
        y4.c.b(parcel, a);
    }

    public ass(int i, String str, String str2) {
        this(1, 1, apl.b(i), str, str2);
    }
}
