package com.google.android.gms.internal.cast;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import o4.e;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzco extends a implements i.e {
    private final TextView zza;
    private final String zzb;
    private final View zzc;

    public zzco(TextView textView, String str, View view) {
        this.zza = textView;
        this.zzb = str;
        this.zzc = view;
    }

    private final void zza(long j, boolean z) {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            this.zza.setVisibility(0);
            this.zza.setText(this.zzb);
            View view = this.zzc;
            if (view != null) {
                view.setVisibility(4);
                return;
            }
            return;
        }
        if (remoteMediaClient.s()) {
            this.zza.setText(this.zzb);
            if (this.zzc != null) {
                this.zza.setVisibility(4);
                this.zzc.setVisibility(0);
                return;
            }
            return;
        }
        if (z) {
            j = remoteMediaClient.p();
        }
        this.zza.setVisibility(0);
        this.zza.setText(DateUtils.formatElapsedTime(j / 1000));
        View view2 = this.zzc;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }

    public final void onMediaStatusUpdated() {
        zza(-1L, true);
    }

    public final void onProgressUpdated(long j, long j2) {
        zza(j2, false);
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.c(this, 1000L);
        }
        zza(-1L, true);
    }

    public final void onSessionEnded() {
        this.zza.setText(this.zzb);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.P(this);
        }
        super.onSessionEnded();
    }
}
