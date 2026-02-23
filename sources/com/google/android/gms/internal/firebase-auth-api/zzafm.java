package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafm implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        Long l = null;
        String str3 = null;
        Long l2 = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l3 = y4.b.l(s);
            if (l3 == 2) {
                str = y4.b.f(parcel, s);
            } else if (l3 == 3) {
                str2 = y4.b.f(parcel, s);
            } else if (l3 == 4) {
                l = y4.b.x(parcel, s);
            } else if (l3 == 5) {
                str3 = y4.b.f(parcel, s);
            } else if (l3 != 6) {
                y4.b.A(parcel, s);
            } else {
                l2 = y4.b.x(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new zzafn(str, str2, l, str3, l2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzafn[i];
    }
}
