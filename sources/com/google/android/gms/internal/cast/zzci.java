package com.google.android.gms.internal.cast;

import android.view.View;
import o4.e;
import p4.i;
import r4.a;
import r4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzci extends a implements i.e {
    private final View zza;
    private final c zzb;

    public zzci(View view, c cVar) {
        this.zza = view;
        this.zzb = cVar;
        view.setEnabled(false);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j, long j2) {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.c(this, 1000L);
        }
        zza();
    }

    public final void onSessionEnded() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.P(this);
        }
        this.zza.setEnabled(false);
        super.onSessionEnded();
        zza();
    }

    public final void zza() {
        i remoteMediaClient = getRemoteMediaClient();
        boolean z = false;
        if (remoteMediaClient == null || !remoteMediaClient.q() || remoteMediaClient.w()) {
            this.zza.setEnabled(false);
            return;
        }
        if (!remoteMediaClient.s()) {
            this.zza.setEnabled(true);
            return;
        }
        View view = this.zza;
        if (remoteMediaClient.r0()) {
            c cVar = this.zzb;
            if ((cVar.a() + cVar.e()) - (cVar.d() + cVar.e()) >= 10000) {
                z = true;
            }
        }
        view.setEnabled(z);
    }
}
