package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcm implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 1:
                    j = y4.b.w(parcel, s);
                    break;
                case 2:
                    j2 = y4.b.w(parcel, s);
                    break;
                case 3:
                    z = y4.b.m(parcel, s);
                    break;
                case 4:
                    str = y4.b.f(parcel, s);
                    break;
                case 5:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 6:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 7:
                    bundle = y4.b.a(parcel, s);
                    break;
                case 8:
                    str4 = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new zzcl(j, j2, z, str, str2, str3, bundle, str4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcl[i];
    }
}
