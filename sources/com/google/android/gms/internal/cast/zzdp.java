package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.h;
import n4.g;
import t4.b;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdp extends h implements IBinder.DeathRecipient {
    private static final b zze = new b("CastRemoteDisplayClientImpl");
    private final g zzf;
    private final CastDevice zzg;
    private final Bundle zzh;

    public zzdp(Context context, Looper looper, e eVar, CastDevice castDevice, Bundle bundle, g gVar, GoogleApiClient.b bVar, GoogleApiClient.c cVar) {
        super(context, looper, 83, eVar, bVar, cVar);
        zze.a("instance created", new Object[0]);
        this.zzg = castDevice;
        this.zzh = bundle;
    }

    public static /* bridge */ /* synthetic */ g zzp(zzdp zzdpVar) {
        zzdpVar.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ b zzq() {
        return zze;
    }

    public final void binderDied() {
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        return queryLocalInterface instanceof zzds ? (zzds) queryLocalInterface : new zzds(iBinder);
    }

    public final void disconnect() {
        zze.a("disconnect", new Object[0]);
        try {
            ((zzds) getService()).zze();
        } catch (RemoteException | IllegalStateException unused) {
        } finally {
            super.disconnect();
        }
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

    public final void zzr(zzdr zzdrVar, zzdu zzduVar, String str) throws RemoteException {
        zze.a("startRemoteDisplay", new Object[0]);
        ((zzds) getService()).zzg(zzdrVar, new zzdo(this, zzduVar), this.zzg.H(), str, this.zzh);
    }

    public final void zzs(zzdr zzdrVar) throws RemoteException {
        zze.a("stopRemoteDisplay", new Object[0]);
        ((zzds) getService()).zzi(zzdrVar);
    }
}
