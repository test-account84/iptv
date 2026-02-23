package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.c;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asj extends aqc {
    private final int a;

    public asj(Context context, Looper looper, c.a aVar, c.b bVar, int i) {
        super(context, looper, aVar, bVar);
        this.a = i;
    }

    public final aso a() throws DeadObjectException {
        return (aso) super.getService();
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        return queryLocalInterface instanceof aso ? (aso) queryLocalInterface : new asn(iBinder);
    }

    public final int getMinApkVersion() {
        return this.a;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.gass.START";
    }
}
