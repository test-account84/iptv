package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asm implements Parcelable.Creator {
    private final /* synthetic */ int a;

    public asm(int i) {
        this.a = i;
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = this.a;
        byte[] bArr = null;
        byte[] bArr2 = null;
        String str = null;
        int i2 = 0;
        if (i == 0) {
            int B = y4.b.B(parcel);
            while (parcel.dataPosition() < B) {
                int s = y4.b.s(parcel);
                int l = y4.b.l(s);
                if (l == 1) {
                    i2 = y4.b.u(parcel, s);
                } else if (l != 2) {
                    y4.b.A(parcel, s);
                } else {
                    bArr = y4.b.b(parcel, s);
                }
            }
            y4.b.k(parcel, B);
            return new asl(i2, bArr);
        }
        if (i == 1) {
            int B2 = y4.b.B(parcel);
            String str2 = null;
            int i3 = 0;
            while (parcel.dataPosition() < B2) {
                int s2 = y4.b.s(parcel);
                int l2 = y4.b.l(s2);
                if (l2 == 1) {
                    i3 = y4.b.u(parcel, s2);
                } else if (l2 == 2) {
                    str = y4.b.f(parcel, s2);
                } else if (l2 != 3) {
                    y4.b.A(parcel, s2);
                } else {
                    str2 = y4.b.f(parcel, s2);
                }
            }
            y4.b.k(parcel, B2);
            return new ask(i3, str, str2);
        }
        if (i != 2) {
            int B3 = y4.b.B(parcel);
            int i4 = 0;
            while (parcel.dataPosition() < B3) {
                int s3 = y4.b.s(parcel);
                int l3 = y4.b.l(s3);
                if (l3 == 1) {
                    i2 = y4.b.u(parcel, s3);
                } else if (l3 == 2) {
                    bArr2 = y4.b.b(parcel, s3);
                } else if (l3 != 3) {
                    y4.b.A(parcel, s3);
                } else {
                    i4 = y4.b.u(parcel, s3);
                }
            }
            y4.b.k(parcel, B3);
            return new ast(i2, bArr2, i4);
        }
        int B4 = y4.b.B(parcel);
        String str3 = null;
        String str4 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < B4) {
            int s4 = y4.b.s(parcel);
            int l4 = y4.b.l(s4);
            if (l4 == 1) {
                i5 = y4.b.u(parcel, s4);
            } else if (l4 == 2) {
                i6 = y4.b.u(parcel, s4);
            } else if (l4 == 3) {
                str3 = y4.b.f(parcel, s4);
            } else if (l4 == 4) {
                str4 = y4.b.f(parcel, s4);
            } else if (l4 != 5) {
                y4.b.A(parcel, s4);
            } else {
                i7 = y4.b.u(parcel, s4);
            }
        }
        y4.b.k(parcel, B4);
        return new ass(i5, i6, i7, str3, str4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        int i2 = this.a;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? new ast[i] : new ass[i] : new ask[i] : new asl[i];
    }
}
