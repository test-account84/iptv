package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import y4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbf implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = b.B(parcel);
        String str = null;
        double d = 0.0d;
        double d2 = 0.0d;
        long j = 0;
        int i = 0;
        short s = 0;
        float f = 0.0f;
        int i2 = 0;
        int i3 = -1;
        while (parcel.dataPosition() < B) {
            int s2 = b.s(parcel);
            switch (b.l(s2)) {
                case 1:
                    str = b.f(parcel, s2);
                    break;
                case 2:
                    j = b.w(parcel, s2);
                    break;
                case 3:
                    s = b.y(parcel, s2);
                    break;
                case 4:
                    d = b.o(parcel, s2);
                    break;
                case 5:
                    d2 = b.o(parcel, s2);
                    break;
                case 6:
                    f = b.q(parcel, s2);
                    break;
                case 7:
                    i = b.u(parcel, s2);
                    break;
                case 8:
                    i2 = b.u(parcel, s2);
                    break;
                case 9:
                    i3 = b.u(parcel, s2);
                    break;
                default:
                    b.A(parcel, s2);
                    break;
            }
        }
        b.k(parcel, B);
        return new zzbe(str, i, s, d, d2, f, j, i2, i3);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzbe[i];
    }
}
