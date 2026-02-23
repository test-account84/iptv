package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asl extends y4.a {
    public static final Parcelable.Creator CREATOR = new asm(0);
    public final int a;
    private agc b = null;
    private byte[] c;

    public asl(int i, byte[] bArr) {
        this.a = i;
        this.c = bArr;
        b();
    }

    private final void b() {
        agc agcVar = this.b;
        if (agcVar != null || this.c == null) {
            if (agcVar == null || this.c != null) {
                if (agcVar != null && this.c != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (agcVar != null || this.c != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    public final agc a() {
        if (this.b == null) {
            try {
                this.b = agc.c(this.c, bqb.a());
                this.c = null;
            } catch (bqw | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        b();
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, this.a);
        byte[] bArr = this.c;
        if (bArr == null) {
            bArr = this.b.av();
        }
        y4.c.f(parcel, 2, bArr, false);
        y4.c.b(parcel, a);
    }
}
