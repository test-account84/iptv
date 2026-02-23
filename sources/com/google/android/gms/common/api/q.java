package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        w4.b bVar = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                i = y4.b.u(parcel, s);
            } else if (l == 2) {
                str = y4.b.f(parcel, s);
            } else if (l == 3) {
                pendingIntent = (PendingIntent) y4.b.e(parcel, s, PendingIntent.CREATOR);
            } else if (l != 4) {
                y4.b.A(parcel, s);
            } else {
                bVar = (w4.b) y4.b.e(parcel, s, w4.b.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new Status(i, str, pendingIntent, bVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
