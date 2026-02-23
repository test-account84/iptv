package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzca extends zzbm implements zzcc {
    public zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(23, zza);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zzc(9, zza);
    }

    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(43, zza);
    }

    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(24, zza);
    }

    public final void generateEventId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zzc(22, zza);
    }

    public final void getAppInstanceId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zzc(20, zza);
    }

    public final void getCachedAppInstanceId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zzc(19, zza);
    }

    public final void getConditionalUserProperties(String str, String str2, zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, zzcfVar);
        zzc(10, zza);
    }

    public final void getCurrentScreenClass(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zzc(17, zza);
    }

    public final void getCurrentScreenName(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zzc(16, zza);
    }

    public final void getGmpAppId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zzc(21, zza);
    }

    public final void getMaxUserProperties(String str, zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbo.zze(zza, zzcfVar);
        zzc(6, zza);
    }

    public final void getSessionId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zzc(46, zza);
    }

    public final void getTestFlag(zzcf zzcfVar, int i) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcfVar);
        zza.writeInt(i);
        zzc(38, zza);
    }

    public final void getUserProperties(String str, String str2, boolean z, zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zzbo.zze(zza, zzcfVar);
        zzc(5, zza);
    }

    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    public final void initialize(F4.a aVar, zzcl zzclVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zzbo.zzd(zza, zzclVar);
        zza.writeLong(j);
        zzc(1, zza);
    }

    public final void isDataCollectionEnabled(zzcf zzcfVar) throws RemoteException {
        throw null;
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zza.writeLong(j);
        zzc(2, zza);
    }

    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcfVar, long j) throws RemoteException {
        throw null;
    }

    public final void logHealthData(int i, String str, F4.a aVar, F4.a aVar2, F4.a aVar3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzbo.zze(zza, aVar);
        zzbo.zze(zza, aVar2);
        zzbo.zze(zza, aVar3);
        zzc(33, zza);
    }

    public final void onActivityCreated(F4.a aVar, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(27, zza);
    }

    public final void onActivityDestroyed(F4.a aVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j);
        zzc(28, zza);
    }

    public final void onActivityPaused(F4.a aVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j);
        zzc(29, zza);
    }

    public final void onActivityResumed(F4.a aVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j);
        zzc(30, zza);
    }

    public final void onActivitySaveInstanceState(F4.a aVar, zzcf zzcfVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zzbo.zze(zza, zzcfVar);
        zza.writeLong(j);
        zzc(31, zza);
    }

    public final void onActivityStarted(F4.a aVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j);
        zzc(25, zza);
    }

    public final void onActivityStopped(F4.a aVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j);
        zzc(26, zza);
    }

    public final void performAction(Bundle bundle, zzcf zzcfVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzbo.zze(zza, zzcfVar);
        zza.writeLong(j);
        zzc(32, zza);
    }

    public final void registerOnMeasurementEventListener(zzci zzciVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzciVar);
        zzc(35, zza);
    }

    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(12, zza);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(8, zza);
    }

    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(44, zza);
    }

    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(45, zza);
    }

    public final void setCurrentScreen(F4.a aVar, String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(15, zza);
    }

    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(39, zza);
    }

    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzc(42, zza);
    }

    public final void setEventInterceptor(zzci zzciVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzciVar);
        zzc(34, zza);
    }

    public final void setInstanceIdProvider(zzck zzckVar) throws RemoteException {
        throw null;
    }

    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(11, zza);
    }

    public final void setMinimumSessionDuration(long j) throws RemoteException {
        throw null;
    }

    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(14, zza);
    }

    public final void setUserId(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(7, zza);
    }

    public final void setUserProperty(String str, String str2, F4.a aVar, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, aVar);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(4, zza);
    }

    public final void unregisterOnMeasurementEventListener(zzci zzciVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzciVar);
        zzc(36, zza);
    }
}
