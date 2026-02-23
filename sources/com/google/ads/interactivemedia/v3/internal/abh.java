package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class abh implements Parcelable.Creator {
    private final /* synthetic */ int a;

    public abh(int i) {
        this.a = i;
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = this.a;
        return i != 0 ? i != 1 ? new abj(parcel) : new abg(parcel) : new abi(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        int i2 = this.a;
        return i2 != 0 ? i2 != 1 ? new abj[i] : new abg[i] : new abi[i];
    }
}
