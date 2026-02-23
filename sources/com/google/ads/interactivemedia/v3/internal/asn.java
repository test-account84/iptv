package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asn extends app implements aso {
    public asn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final asl e(ask askVar) throws RemoteException {
        Parcel a = a();
        apr.d(a, askVar);
        Parcel v = v(1, a);
        asl aslVar = (asl) apr.a(v, asl.CREATOR);
        v.recycle();
        return aslVar;
    }

    public final ast f(ass assVar) throws RemoteException {
        Parcel a = a();
        apr.d(a, assVar);
        Parcel v = v(3, a);
        ast astVar = (ast) apr.a(v, ast.CREATOR);
        v.recycle();
        return astVar;
    }
}
