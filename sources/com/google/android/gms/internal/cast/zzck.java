package com.google.android.gms.internal.cast;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.SeekBar;
import com.google.android.gms.common.util.VisibleForTesting;
import o4.e;
import p4.i;
import r4.a;
import r4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzck extends a implements i.e {
    private final SeekBar zza;
    private final long zzb;
    private final c zzc;
    private boolean zzd = true;
    private Boolean zze;
    private Drawable zzf;

    public zzck(SeekBar seekBar, long j, c cVar) {
        this.zzf = null;
        this.zza = seekBar;
        this.zzb = j;
        this.zzc = cVar;
        seekBar.setEnabled(false);
        this.zzf = seekBar.getThumb();
    }

    public final void onMediaStatusUpdated() {
        zzb();
    }

    public final void onProgressUpdated(long j, long j2) {
        zzb();
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.c(this, this.zzb);
        }
        zzb();
    }

    public final void onSessionEnded() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.P(this);
        }
        super.onSessionEnded();
        zzb();
    }

    public final void zza(boolean z) {
        this.zzd = z;
    }

    @VisibleForTesting
    public final void zzb() {
        SeekBar seekBar;
        int a;
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            this.zza.setMax(this.zzc.b());
            this.zza.setProgress(this.zzc.a());
            this.zza.setEnabled(false);
            return;
        }
        if (this.zzd) {
            this.zza.setMax(this.zzc.b());
            if (remoteMediaClient.s() && this.zzc.m()) {
                seekBar = this.zza;
                a = this.zzc.c();
            } else {
                seekBar = this.zza;
                a = this.zzc.a();
            }
            seekBar.setProgress(a);
            if (remoteMediaClient.w()) {
                this.zza.setEnabled(false);
            } else {
                this.zza.setEnabled(true);
            }
            i remoteMediaClient2 = getRemoteMediaClient();
            if (remoteMediaClient2 == null || !remoteMediaClient2.q()) {
                return;
            }
            Boolean bool = this.zze;
            if (bool == null || bool.booleanValue() != remoteMediaClient2.r0()) {
                Boolean valueOf = Boolean.valueOf(remoteMediaClient2.r0());
                this.zze = valueOf;
                if (!valueOf.booleanValue()) {
                    this.zza.setThumb(new ColorDrawable(0));
                    this.zza.setClickable(false);
                    this.zza.setOnTouchListener(new zzcj(this));
                    return;
                }
                Drawable drawable = this.zzf;
                if (drawable != null) {
                    this.zza.setThumb(drawable);
                }
                this.zza.setClickable(true);
                this.zza.setOnTouchListener((View.OnTouchListener) null);
            }
        }
    }
}
