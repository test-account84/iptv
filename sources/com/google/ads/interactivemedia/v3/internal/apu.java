package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Hide;
import java.util.concurrent.Executor;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apu extends arr {
    private static final apu a = new apu();

    private apu() {
    }

    public static apx a(Context context, Executor executor, aff affVar) {
        apx apxVar = null;
        if (affVar.d() && w4.i.h().j(context, 12800000) == 0) {
            apxVar = a.d(context, executor, affVar);
        }
        return apxVar == null ? new apt(context, executor, affVar) : apxVar;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.ads.interactivemedia.v3.internal.apz, java.lang.Object] */
    private final apx d(Context context, Executor executor, aff affVar) {
        try {
            IBinder e = c(context).e(arp.c(context), arp.c(executor), affVar.av());
            if (e == null) {
                return null;
            }
            IInterface queryLocalInterface = e.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return queryLocalInterface instanceof apx ? (apx) queryLocalInterface : new apv(e);
        } catch (IllegalArgumentException | RemoteException | arq | LinkageError unused) {
            return null;
        }
    }

    public final /* synthetic */ Object b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        return queryLocalInterface instanceof apz ? (apz) queryLocalInterface : new apy(iBinder);
    }
}
