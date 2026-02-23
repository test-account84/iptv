package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aqy extends app implements ara {
    public aqy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.signalsdk.ISignalSdkService");
    }

    public final void e(arb arbVar, aqx aqxVar) throws RemoteException {
        Parcel a = a();
        apr.d(a, arbVar);
        apr.e(a, aqxVar);
        x(a);
    }
}
