package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class arc extends y4.a {
    public static final Parcelable.Creator CREATOR = new ard(0);
    private final String a;

    @Hide
    public arc(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, a(), false);
        y4.c.b(parcel, a);
    }
}
