package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import y4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzab implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = b.B(parcel);
        Status status = null;
        while (parcel.dataPosition() < B) {
            int s = b.s(parcel);
            if (b.l(s) != 1) {
                b.A(parcel, s);
            } else {
                status = (Status) b.e(parcel, s, Status.CREATOR);
            }
        }
        b.k(parcel, B);
        return new zzaa(status);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzaa[i];
    }
}
