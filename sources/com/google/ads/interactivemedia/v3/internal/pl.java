package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class pl implements Parcelable.Creator {
    private final /* synthetic */ int a;

    public pl(int i) {
        this.a = i;
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a != 0 ? new pn(parcel) : new pm(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return this.a != 0 ? new pn[i] : new pm[i];
    }
}
