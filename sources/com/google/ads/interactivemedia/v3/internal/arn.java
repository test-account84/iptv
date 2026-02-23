package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class arn extends apq implements aro {
    public arn() {
        super("com.google.android.gms.dynamic.IObjectWrapper");
    }

    public static aro b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return queryLocalInterface instanceof aro ? (aro) queryLocalInterface : new arm(iBinder);
    }
}
