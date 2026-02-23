package com.google.android.gms.internal.appset;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.h;
import w4.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzd extends h {
    public zzd(Context context, Looper looper, e eVar, f fVar, n nVar) {
        super(context, looper, 300, eVar, fVar, nVar);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appset.internal.IAppSetService");
        return queryLocalInterface instanceof zzg ? (zzg) queryLocalInterface : new zzg(iBinder);
    }

    public final d[] getApiFeatures() {
        return i4.h.b;
    }

    public final int getMinApkVersion() {
        return 212800000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.appset.internal.IAppSetService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.appset.service.START";
    }

    public final boolean getUseDynamicLookup() {
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
