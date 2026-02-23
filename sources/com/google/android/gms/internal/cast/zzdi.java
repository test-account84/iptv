package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;

@TargetApi(19)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdi extends zzdh {
    final /* synthetic */ zzdk zza;
    private final zzdp zzb;

    public zzdi(zzdk zzdkVar, zzdp zzdpVar) {
        this.zza = zzdkVar;
        this.zzb = zzdpVar;
    }

    public final void zzb(int i, int i2, Surface surface) {
        zzdk zzdkVar;
        zzdl zzdlVar;
        zzdm.zzb().a("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzb.getContext().getSystemService("display");
        if (displayManager == null) {
            zzdm.zzb().c("Unable to get the display manager", new Object[0]);
            zzdkVar = this.zza;
            zzdlVar = new zzdl(Status.m);
        } else {
            zzdm.zzf(this.zza.zzc);
            zzdm.zze(this.zza.zzc, displayManager.createVirtualDisplay("private_display", i, i2, ((i < i2 ? i : i2) * 320) / 1080, surface, 2));
            zzdm zzdmVar = this.zza.zzc;
            if (zzdm.zza(zzdmVar) == null) {
                zzdm.zzb().c("Unable to create virtual display", new Object[0]);
                zzdkVar = this.zza;
                zzdlVar = new zzdl(Status.m);
            } else if (zzdm.zza(zzdmVar).getDisplay() == null) {
                zzdm.zzb().c("Virtual display does not have a display", new Object[0]);
                zzdkVar = this.zza;
                zzdlVar = new zzdl(Status.m);
            } else {
                try {
                    ((zzds) this.zzb.getService()).zzf(this, zzdm.zza(this.zza.zzc).getDisplay().getDisplayId());
                    return;
                } catch (RemoteException | IllegalStateException unused) {
                    zzdm.zzb().c("Unable to provision the route's new virtual Display", new Object[0]);
                    zzdkVar = this.zza;
                    zzdlVar = new zzdl(Status.m);
                }
            }
        }
        zzdkVar.setResult((h) zzdlVar);
    }

    public final void zzc() {
        zzdm.zzb().a("onConnectedWithDisplay", new Object[0]);
        zzdm zzdmVar = this.zza.zzc;
        if (zzdm.zza(zzdmVar) == null) {
            zzdm.zzb().c("There is no virtual display", new Object[0]);
            this.zza.setResult((h) new zzdl(Status.m));
            return;
        }
        Display display = zzdm.zza(zzdmVar).getDisplay();
        if (display != null) {
            this.zza.setResult((h) new zzdl(display));
        } else {
            zzdm.zzb().c("Virtual display no longer has a display", new Object[0]);
            this.zza.setResult((h) new zzdl(Status.m));
        }
    }

    public final void zzd(int i) throws RemoteException {
        zzdm.zzb().a("onError: %d", Integer.valueOf(i));
        zzdm.zzf(this.zza.zzc);
        this.zza.setResult((h) new zzdl(Status.m));
    }
}
