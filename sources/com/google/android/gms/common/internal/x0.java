package com.google.android.gms.common.internal;

import F4.a;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x0 extends zza implements T {
    public x0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final int zzc() {
        Parcel zzB = zzB(2, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final F4.a zzd() {
        Parcel zzB = zzB(1, zza());
        F4.a A = a.a.A(zzB.readStrongBinder());
        zzB.recycle();
        return A;
    }
}
