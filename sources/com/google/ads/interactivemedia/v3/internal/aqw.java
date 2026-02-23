package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class aqw extends apq implements aqx {
    public aqw() {
        super("com.google.android.gms.ads.signalsdk.INetworkRequestCallback");
    }

    public final boolean a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i == 1) {
            arc arcVar = (arc) apr.a(parcel, arc.CREATOR);
            apr.b(parcel);
            c(arcVar);
        } else {
            if (i != 2) {
                return false;
            }
            int readInt = parcel.readInt();
            apr.b(parcel);
            b(readInt);
        }
        return true;
    }
}
