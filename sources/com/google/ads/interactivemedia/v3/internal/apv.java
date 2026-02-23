package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apv extends app implements apx {
    public apv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    public final int b() throws RemoteException {
        throw null;
    }

    public final aro c(aro aroVar, aro aroVar2) throws RemoteException {
        throw null;
    }

    public final aro d(aro aroVar, aro aroVar2) throws RemoteException {
        Parcel a = a();
        apr.e(a, aroVar);
        apr.e(a, aroVar2);
        Parcel v = v(6, a);
        aro b = arn.b(v.readStrongBinder());
        v.recycle();
        return b;
    }

    public final String e(aro aroVar, String str) throws RemoteException {
        throw null;
    }

    public final String f(aro aroVar) throws RemoteException {
        throw null;
    }

    public final String g(aro aroVar, byte[] bArr) throws RemoteException {
        Parcel a = a();
        apr.e(a, aroVar);
        a.writeByteArray((byte[]) null);
        Parcel v = v(12, a);
        String readString = v.readString();
        v.recycle();
        return readString;
    }

    public final String h(aro aroVar, aro aroVar2, aro aroVar3, aro aroVar4) throws RemoteException {
        throw null;
    }

    public final String i(aro aroVar) throws RemoteException {
        throw null;
    }

    public final String j() throws RemoteException {
        throw null;
    }

    public final String k(aro aroVar, aro aroVar2, aro aroVar3) throws RemoteException {
        throw null;
    }

    public final void l(aro aroVar) throws RemoteException {
        throw null;
    }

    public final void m(aro aroVar) throws RemoteException {
        throw null;
    }

    public final void n(String str, String str2) throws RemoteException {
        throw null;
    }

    public final void o(String str) throws RemoteException {
        throw null;
    }

    public final boolean p(aro aroVar) throws RemoteException {
        throw null;
    }

    public final boolean q(aro aroVar) throws RemoteException {
        Parcel a = a();
        apr.e(a, aroVar);
        Parcel v = v(4, a);
        boolean f = apr.f(v);
        v.recycle();
        return f;
    }

    public final boolean r() throws RemoteException {
        throw null;
    }

    public final boolean s(String str, boolean z) throws RemoteException {
        throw null;
    }

    public final boolean t() throws RemoteException {
        throw null;
    }
}
