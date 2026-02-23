package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ard implements Parcelable.Creator {
    private final /* synthetic */ int a;

    public ard(int i) {
        this.a = i;
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        if (this.a == 0) {
            int B = y4.b.B(parcel);
            while (parcel.dataPosition() < B) {
                int s = y4.b.s(parcel);
                if (y4.b.l(s) != 1) {
                    y4.b.A(parcel, s);
                } else {
                    str = y4.b.f(parcel, s);
                }
            }
            y4.b.k(parcel, B);
            return new arc(str);
        }
        int B2 = y4.b.B(parcel);
        String str2 = "";
        int i = 0;
        while (parcel.dataPosition() < B2) {
            int s2 = y4.b.s(parcel);
            int l = y4.b.l(s2);
            if (l == 1) {
                str = y4.b.f(parcel, s2);
            } else if (l == 2) {
                i = y4.b.u(parcel, s2);
            } else if (l != 3) {
                y4.b.A(parcel, s2);
            } else {
                str2 = y4.b.f(parcel, s2);
            }
        }
        y4.b.k(parcel, B2);
        return new arb(str, i, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return this.a != 0 ? new arb[i] : new arc[i];
    }
}
