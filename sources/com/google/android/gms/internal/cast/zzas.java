package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.internal.r;
import java.util.Iterator;
import t4.b;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzas extends L.a {
    private static final b zza = new b("MediaRouterCallback");
    private final zzan zzb;

    public zzas(zzan zzanVar) {
        this.zzb = (zzan) r.m(zzanVar);
    }

    public final void onRouteAdded(L l, L.h hVar) {
        try {
            this.zzb.zzf(hVar.k(), hVar.i());
        } catch (RemoteException e) {
            zza.b(e, "Unable to call %s on %s.", "onRouteAdded", zzan.class.getSimpleName());
        }
    }

    public final void onRouteChanged(L l, L.h hVar) {
        try {
            this.zzb.zzg(hVar.k(), hVar.i());
        } catch (RemoteException e) {
            zza.b(e, "Unable to call %s on %s.", "onRouteChanged", zzan.class.getSimpleName());
        }
    }

    public final void onRouteRemoved(L l, L.h hVar) {
        try {
            this.zzb.zzh(hVar.k(), hVar.i());
        } catch (RemoteException e) {
            zza.b(e, "Unable to call %s on %s.", "onRouteRemoved", zzan.class.getSimpleName());
        }
    }

    public final void onRouteSelected(L l, L.h hVar, int i) {
        CastDevice K;
        CastDevice K2;
        zza.e("onRouteSelected with reason = %d, routeId = %s", Integer.valueOf(i), hVar.k());
        if (hVar.o() != 1) {
            return;
        }
        try {
            String k = hVar.k();
            String k2 = hVar.k();
            if (k2 != null && k2.endsWith("-groupRoute") && (K = CastDevice.K(hVar.i())) != null) {
                String H = K.H();
                Iterator it = l.m().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    L.h hVar2 = (L.h) it.next();
                    String k3 = hVar2.k();
                    if (k3 != null && !k3.endsWith("-groupRoute") && (K2 = CastDevice.K(hVar2.i())) != null && TextUtils.equals(K2.H(), H)) {
                        zza.a("routeId is changed from %s to %s", k2, hVar2.k());
                        k2 = hVar2.k();
                        break;
                    }
                }
            }
            if (this.zzb.zze() >= 220400000) {
                this.zzb.zzj(k2, k, hVar.i());
            } else {
                this.zzb.zzi(k2, hVar.i());
            }
        } catch (RemoteException e) {
            zza.b(e, "Unable to call %s on %s.", "onRouteSelected", zzan.class.getSimpleName());
        }
    }

    public final void onRouteUnselected(L l, L.h hVar, int i) {
        b bVar = zza;
        bVar.e("onRouteUnselected with reason = %d, routeId = %s", Integer.valueOf(i), hVar.k());
        if (hVar.o() != 1) {
            bVar.a("skip route unselection for non-cast route", new Object[0]);
            return;
        }
        try {
            this.zzb.zzk(hVar.k(), hVar.i(), i);
        } catch (RemoteException e) {
            zza.b(e, "Unable to call %s on %s.", "onRouteUnselected", zzan.class.getSimpleName());
        }
    }
}
