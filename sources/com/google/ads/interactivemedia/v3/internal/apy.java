package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apy extends app implements apz {
    public apy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
    }

    public final IBinder e(aro aroVar, aro aroVar2, byte[] bArr) throws RemoteException {
        Parcel a = a();
        apr.e(a, aroVar);
        apr.e(a, aroVar2);
        a.writeByteArray(bArr);
        Parcel v = v(3, a);
        IBinder readStrongBinder = v.readStrongBinder();
        v.recycle();
        return readStrongBinder;
    }
}
