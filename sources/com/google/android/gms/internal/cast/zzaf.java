package com.google.android.gms.internal.cast;

import F4.a;
import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Map;
import o4.E;
import o4.J;
import o4.M;
import o4.V;
import o4.c;
import o4.j;
import o4.t0;
import o4.w0;
import q4.i;
import q4.k;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaf {
    private static final b zza = new b("CastDynamiteModule");

    public static w0 zza(Context context, c cVar, zzal zzalVar, Map map) throws j, RemoteException {
        return zzf(context).zze(F4.b.Z(context.getApplicationContext()), cVar, zzalVar, map);
    }

    public static E zzb(Context context, c cVar, a aVar, t0 t0Var) {
        if (aVar == null) {
            return null;
        }
        try {
            return zzf(context).zzf(cVar, aVar, t0Var);
        } catch (RemoteException | j e) {
            zza.b(e, "Unable to call %s on %s.", "newCastSessionImpl", zzaj.class.getSimpleName());
            return null;
        }
    }

    public static J zzc(Service service, a aVar, a aVar2) {
        if (aVar != null && aVar2 != null) {
            try {
                return zzf(service.getApplicationContext()).zzg(F4.b.Z(service), aVar, aVar2);
            } catch (RemoteException | j e) {
                zza.b(e, "Unable to call %s on %s.", "newReconnectionServiceImpl", zzaj.class.getSimpleName());
            }
        }
        return null;
    }

    public static M zzd(Context context, String str, String str2, V v) {
        try {
            return zzf(context).zzh(str, str2, v);
        } catch (RemoteException | j e) {
            zza.b(e, "Unable to call %s on %s.", "newSessionImpl", zzaj.class.getSimpleName());
            return null;
        }
    }

    public static i zze(Context context, AsyncTask asyncTask, k kVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) {
        try {
            return zzf(context.getApplicationContext()).zzi(F4.b.Z(asyncTask), kVar, i, i2, false, 2097152L, 5, 333, 10000);
        } catch (RemoteException | j e) {
            zza.b(e, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", zzaj.class.getSimpleName());
            return null;
        }
    }

    private static zzaj zzf(Context context) throws j {
        try {
            IBinder d = DynamiteModule.e(context, DynamiteModule.b, "com.google.android.gms.cast.framework.dynamite").d("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (d == null) {
                return null;
            }
            IInterface queryLocalInterface = d.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            return queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzai(d);
        } catch (DynamiteModule.a e) {
            throw new j(e);
        }
    }
}
