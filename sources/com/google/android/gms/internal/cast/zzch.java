package com.google.android.gms.internal.cast;

import android.widget.ProgressBar;
import o4.e;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzch extends a implements i.e {
    private final ProgressBar zza;
    private final long zzb;

    public zzch(ProgressBar progressBar, long j) {
        this.zza = progressBar;
        this.zzb = j;
        progressBar.setMax(1);
        progressBar.setProgress(0);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j, long j2) {
        zza();
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.c(this, this.zzb);
        }
        zza();
    }

    public final void onSessionEnded() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.P(this);
        }
        super.onSessionEnded();
        zza();
    }

    public final void zza() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q() || remoteMediaClient.s()) {
            this.zza.setMax(1);
            this.zza.setProgress(0);
        } else {
            this.zza.setMax((int) remoteMediaClient.p());
            this.zza.setProgress((int) remoteMediaClient.g());
        }
    }
}
