package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        t tVar = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 1:
                    tVar = (t) y4.b.e(parcel, s, t.CREATOR);
                    break;
                case 2:
                    z = y4.b.m(parcel, s);
                    break;
                case 3:
                    z2 = y4.b.m(parcel, s);
                    break;
                case 4:
                    iArr = y4.b.c(parcel, s);
                    break;
                case 5:
                    i = y4.b.u(parcel, s);
                    break;
                case 6:
                    iArr2 = y4.b.c(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new f(tVar, z, z2, iArr, i, iArr2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new f[i];
    }
}
