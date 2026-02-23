package com.google.android.gms.internal.cast;

import android.view.View;
import o4.e;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcs extends a {
    private final View zza;
    private final int zzb;

    public zzcs(View view, int i) {
        this.zza = view;
        this.zzb = i;
    }

    private final void zza() {
        View view;
        int i;
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            view = this.zza;
            i = this.zzb;
        } else {
            view = this.zza;
            i = 0;
        }
        view.setVisibility(i);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setVisibility(this.zzb);
        super.onSessionEnded();
    }
}
