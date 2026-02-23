package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ask extends y4.a {
    public static final Parcelable.Creator CREATOR = new asm(1);
    public final int a;
    public final String b;
    public final String c;

    public ask(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, this.a);
        y4.c.t(parcel, 2, this.b, false);
        y4.c.t(parcel, 3, this.c, false);
        y4.c.b(parcel, a);
    }

    public ask(String str, String str2) {
        this(1, str, str2);
    }
}
