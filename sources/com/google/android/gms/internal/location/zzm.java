package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import y4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzm implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = b.B(parcel);
        zzj zzjVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i = 1;
        while (parcel.dataPosition() < B) {
            int s = b.s(parcel);
            int l = b.l(s);
            if (l == 1) {
                i = b.u(parcel, s);
            } else if (l == 2) {
                zzjVar = (zzj) b.e(parcel, s, zzj.CREATOR);
            } else if (l == 3) {
                iBinder = b.t(parcel, s);
            } else if (l != 4) {
                b.A(parcel, s);
            } else {
                iBinder2 = b.t(parcel, s);
            }
        }
        b.k(parcel, B);
        return new zzl(i, zzjVar, iBinder, iBinder2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }
}
