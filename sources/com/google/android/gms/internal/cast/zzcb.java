package com.google.android.gms.internal.cast;

import android.view.View;
import o4.e;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcb extends a {
    private final View zza;

    public zzcb(View view) {
        this.zza = view;
    }

    private final void zza() {
        View view;
        int i;
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q() || remoteMediaClient.r()) {
            view = this.zza;
            i = 0;
        } else {
            view = this.zza;
            i = 8;
        }
        view.setVisibility(i);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setVisibility(0);
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setVisibility(8);
        super.onSessionEnded();
    }
}
