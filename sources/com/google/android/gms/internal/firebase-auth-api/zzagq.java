package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzagq implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            y4.b.l(s);
            y4.b.A(parcel, s);
        }
        y4.b.k(parcel, B);
        return new zzagr();
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzagr[i];
    }
}
