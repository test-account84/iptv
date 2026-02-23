package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class atc extends apq implements atd {
    public atc() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    public static atd b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
        return queryLocalInterface instanceof atd ? (atd) queryLocalInterface : new atb(iBinder);
    }

    public final boolean a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i) {
            case 2:
                arn.b(parcel.readStrongBinder());
                parcel.readString();
                apr.b(parcel);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.createIntArray();
                apr.b(parcel);
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.createByteArray();
                apr.b(parcel);
                parcel2.writeNoException();
                return true;
            case 6:
            case 7:
                parcel.readInt();
                apr.b(parcel);
                parcel2.writeNoException();
                return true;
            case 8:
                arn.b(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                apr.b(parcel);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }

    public final void e() {
    }

    public final void f(int i) {
    }

    public final void g(int i) {
    }

    public final void h(byte[] bArr) {
    }

    public final void i(aro aroVar, String str) {
    }

    public final void j() {
    }

    public atc(byte[] bArr) {
        this();
    }
}
