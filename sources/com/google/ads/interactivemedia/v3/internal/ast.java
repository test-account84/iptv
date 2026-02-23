package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import java.util.Arrays;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ast extends y4.a {
    public static final Parcelable.Creator CREATOR = new asm(3);
    public final int a;
    public final byte[] b;
    public final int c;

    public ast() {
        this(1, null, 1);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, this.a);
        y4.c.f(parcel, 2, this.b, false);
        y4.c.l(parcel, 3, this.c);
        y4.c.b(parcel, a);
    }

    public ast(int i, byte[] bArr, int i2) {
        this.a = i;
        this.b = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.c = i2;
    }
}
