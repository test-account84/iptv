package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        Bundle bundle = null;
        w4.d[] dVarArr = null;
        f fVar = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                bundle = y4.b.a(parcel, s);
            } else if (l == 2) {
                dVarArr = (w4.d[]) y4.b.i(parcel, s, w4.d.CREATOR);
            } else if (l == 3) {
                i = y4.b.u(parcel, s);
            } else if (l != 4) {
                y4.b.A(parcel, s);
            } else {
                fVar = (f) y4.b.e(parcel, s, f.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new k0(bundle, dVarArr, i, fVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new k0[i];
    }
}
