package com.google.android.gms.internal.cast;

import android.text.format.DateUtils;
import android.widget.TextView;
import o4.e;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcp extends zzcq implements i.e {
    private final TextView zza;
    private final long zzb;
    private final String zzc;
    private boolean zzd = true;

    public zzcp(TextView textView, long j, String str) {
        this.zza = textView;
        this.zzb = j;
        this.zzc = str;
    }

    public final void onProgressUpdated(long j, long j2) {
        if (this.zzd) {
            TextView textView = this.zza;
            if (j == -1000) {
                j = j2;
            }
            textView.setText(DateUtils.formatElapsedTime(j / 1000));
        }
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.c(this, this.zzb);
            if (remoteMediaClient.q()) {
                this.zza.setText(DateUtils.formatElapsedTime(remoteMediaClient.g() / 1000));
            } else {
                this.zza.setText(this.zzc);
            }
        }
    }

    public final void onSessionEnded() {
        this.zza.setText(this.zzc);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.P(this);
        }
        super.onSessionEnded();
    }

    public final void zza(boolean z) {
        this.zzd = z;
    }

    public final void zzb(long j) {
        this.zza.setText(DateUtils.formatElapsedTime(j / 1000));
    }
}
