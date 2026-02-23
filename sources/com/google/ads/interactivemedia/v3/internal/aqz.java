package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class aqz extends apq implements ara {
    public static ara b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.signalsdk.ISignalSdkService");
        return queryLocalInterface instanceof ara ? (ara) queryLocalInterface : new aqy(iBinder);
    }
}
