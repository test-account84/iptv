package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ark extends com.google.android.gms.common.internal.h {
    public ark(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, GoogleApiClient.b bVar, GoogleApiClient.c cVar) {
        super(context, looper, 203, eVar, bVar, cVar);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        return aqz.b(iBinder);
    }

    public final w4.d[] getApiFeatures() {
        return ate.c;
    }

    public final int getMinApkVersion() {
        return 17108000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.signalsdk.ISignalSdkService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.SDK_SIGNAL";
    }
}
