package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class atb extends app implements atd {
    public atb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    public final void e() throws RemoteException {
        w(3, a());
    }

    public final void f(int i) throws RemoteException {
        Parcel a = a();
        a.writeInt(i);
        w(7, a);
    }

    public final void g(int i) throws RemoteException {
        Parcel a = a();
        a.writeInt(i);
        w(6, a);
    }

    public final void h(byte[] bArr) throws RemoteException {
        Parcel a = a();
        a.writeByteArray(bArr);
        w(5, a);
    }

    public final void i(aro aroVar, String str) throws RemoteException {
        Parcel a = a();
        apr.e(a, aroVar);
        a.writeString(str);
        a.writeString((String) null);
        w(8, a);
    }

    public final void j() throws RemoteException {
        Parcel a = a();
        a.writeIntArray((int[]) null);
        w(4, a);
    }
}
