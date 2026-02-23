package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdn extends h {
    public zzdn(Context context, Looper looper, e eVar, GoogleApiClient.b bVar, GoogleApiClient.c cVar) {
        super(context, looper, 83, eVar, bVar, cVar);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        return queryLocalInterface instanceof zzds ? (zzds) queryLocalInterface : new zzds(iBinder);
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }
}
