package com.google.android.gms.internal.cast;

import android.widget.TextView;
import o4.e;
import o4.t;
import p4.i;
import r4.a;
import r4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzct extends a implements i.e {
    private final TextView zza;
    private final c zzb;

    public zzct(TextView textView, c cVar) {
        this.zza = textView;
        this.zzb = cVar;
        textView.setText(textView.getContext().getString(t.l));
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
            remoteMediaClient.c(this, 1000L);
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
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            TextView textView = this.zza;
            textView.setText(textView.getContext().getString(t.l));
        } else {
            if (remoteMediaClient.s() && this.zzb.i() == null) {
                this.zza.setVisibility(8);
                return;
            }
            this.zza.setVisibility(0);
            TextView textView2 = this.zza;
            c cVar = this.zzb;
            textView2.setText(cVar.l(cVar.b() + cVar.e()));
        }
    }
}
