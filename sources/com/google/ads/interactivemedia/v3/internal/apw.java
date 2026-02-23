package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class apw extends apq implements apx {
    public apw() {
        super("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    public final boolean a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        String j;
        boolean p;
        aro d;
        switch (i) {
            case 1:
                parcel2.writeNoException();
                j = j();
                parcel2.writeString(j);
                return true;
            case 2:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                apr.b(parcel);
                n(readString, readString2);
                parcel2.writeNoException();
                return true;
            case 3:
                aro b = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                p = p(b);
                parcel2.writeNoException();
                apr.c(parcel2, p);
                return true;
            case 4:
                aro b2 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                p = q(b2);
                parcel2.writeNoException();
                apr.c(parcel2, p);
                return true;
            case 5:
                String readString3 = parcel.readString();
                apr.b(parcel);
                o(readString3);
                parcel2.writeNoException();
                return true;
            case 6:
                aro b3 = arn.b(parcel.readStrongBinder());
                aro b4 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                d = d(b3, b4);
                parcel2.writeNoException();
                apr.e(parcel2, d);
                return true;
            case 7:
                aro b5 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                j = f(b5);
                parcel2.writeNoException();
                parcel2.writeString(j);
                return true;
            case 8:
                aro b6 = arn.b(parcel.readStrongBinder());
                String readString4 = parcel.readString();
                apr.b(parcel);
                j = e(b6, readString4);
                parcel2.writeNoException();
                parcel2.writeString(j);
                return true;
            case 9:
                aro b7 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                l(b7);
                parcel2.writeNoException();
                return true;
            case 10:
                aro b8 = arn.b(parcel.readStrongBinder());
                aro b9 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                d = c(b8, b9);
                parcel2.writeNoException();
                apr.e(parcel2, d);
                return true;
            case 11:
                String readString5 = parcel.readString();
                boolean f = apr.f(parcel);
                apr.b(parcel);
                p = s(readString5, f);
                parcel2.writeNoException();
                apr.c(parcel2, p);
                return true;
            case 12:
                aro b10 = arn.b(parcel.readStrongBinder());
                byte[] createByteArray = parcel.createByteArray();
                apr.b(parcel);
                j = g(b10, createByteArray);
                parcel2.writeNoException();
                parcel2.writeString(j);
                return true;
            case 13:
                aro b11 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                j = i(b11);
                parcel2.writeNoException();
                parcel2.writeString(j);
                return true;
            case 14:
                aro b12 = arn.b(parcel.readStrongBinder());
                aro b13 = arn.b(parcel.readStrongBinder());
                aro b14 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                j = k(b12, b13, b14);
                parcel2.writeNoException();
                parcel2.writeString(j);
                return true;
            case 15:
                aro b15 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                m(b15);
                parcel2.writeNoException();
                return true;
            case 16:
            default:
                return false;
            case 17:
                aro b16 = arn.b(parcel.readStrongBinder());
                aro b17 = arn.b(parcel.readStrongBinder());
                aro b18 = arn.b(parcel.readStrongBinder());
                aro b19 = arn.b(parcel.readStrongBinder());
                apr.b(parcel);
                j = h(b16, b17, b18, b19);
                parcel2.writeNoException();
                parcel2.writeString(j);
                return true;
            case 18:
                p = r();
                parcel2.writeNoException();
                apr.c(parcel2, p);
                return true;
            case 19:
                p = t();
                parcel2.writeNoException();
                apr.c(parcel2, p);
                return true;
            case 20:
                int b20 = b();
                parcel2.writeNoException();
                parcel2.writeInt(b20);
                return true;
        }
    }
}
