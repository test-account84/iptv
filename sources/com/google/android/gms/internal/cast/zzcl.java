package com.google.android.gms.internal.cast;

import android.view.View;
import o4.e;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcl extends a {
    private final View zza;
    private final int zzb;

    public zzcl(View view, int i) {
        this.zza = view;
        this.zzb = i;
        view.setEnabled(false);
    }

    private final void zza() {
        View view;
        i remoteMediaClient = getRemoteMediaClient();
        boolean z = false;
        if (remoteMediaClient == null || !remoteMediaClient.o0() || remoteMediaClient.w()) {
            this.zza.setVisibility(this.zzb);
            view = this.zza;
        } else {
            this.zza.setVisibility(0);
            view = this.zza;
            z = true;
        }
        view.setEnabled(z);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}
