package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzee implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzef zza;

    public zzee(zzef zzefVar) {
        this.zza = zzefVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzef.zzu(this.zza, new zzdx(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        zzef.zzu(this.zza, new zzed(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zzef.zzu(this.zza, new zzea(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zzef.zzu(this.zza, new zzdz(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbz zzbzVar = new zzbz();
        zzef.zzu(this.zza, new zzec(this, activity, zzbzVar));
        Bundle zzb = zzbzVar.zzb(50L);
        if (zzb != null) {
            bundle.putAll(zzb);
        }
    }

    public final void onActivityStarted(Activity activity) {
        zzef.zzu(this.zza, new zzdy(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zzef.zzu(this.zza, new zzeb(this, activity));
    }
}
