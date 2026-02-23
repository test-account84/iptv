package com.google.android.gms.internal.cast;

import C4.m;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import o4.e;
import o4.t;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcg extends a {
    private final ImageView zza;
    private final View zzb;
    private final boolean zzc;
    private final Drawable zzd;
    private final String zze;
    private final Drawable zzf;
    private final String zzg;
    private final Drawable zzh;
    private final String zzi;
    private boolean zzj = false;

    public zzcg(ImageView imageView, Context context, Drawable drawable, Drawable drawable2, Drawable drawable3, View view, boolean z) {
        this.zza = imageView;
        this.zzd = drawable;
        this.zzf = drawable2;
        this.zzh = drawable3 != null ? drawable3 : drawable2;
        this.zze = context.getString(t.o);
        this.zzg = context.getString(t.n);
        this.zzi = context.getString(t.u);
        this.zzb = view;
        this.zzc = z;
        imageView.setEnabled(false);
    }

    private final void zza(Drawable drawable, String str) {
        boolean z = !drawable.equals(this.zza.getDrawable());
        this.zza.setImageDrawable(drawable);
        this.zza.setContentDescription(str);
        this.zza.setVisibility(0);
        this.zza.setEnabled(true);
        View view = this.zzb;
        if (view != null) {
            view.setVisibility(8);
        }
        if (z && this.zzj) {
            this.zza.sendAccessibilityEvent(8);
        }
    }

    @TargetApi(21)
    private final void zzb(boolean z) {
        if (m.f()) {
            this.zzj = this.zza.isAccessibilityFocused();
        }
        View view = this.zzb;
        if (view != null) {
            view.setVisibility(0);
            if (this.zzj) {
                this.zzb.sendAccessibilityEvent(8);
            }
        }
        this.zza.setVisibility(true == this.zzc ? 4 : 0);
        this.zza.setEnabled(!z);
    }

    private final void zzc() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            this.zza.setEnabled(false);
            return;
        }
        if (remoteMediaClient.v()) {
            if (remoteMediaClient.s()) {
                zza(this.zzh, this.zzi);
                return;
            } else {
                zza(this.zzf, this.zzg);
                return;
            }
        }
        if (remoteMediaClient.r()) {
            zzb(false);
        } else if (remoteMediaClient.u()) {
            zza(this.zzd, this.zze);
        } else if (remoteMediaClient.t()) {
            zzb(true);
        }
    }

    public final void onMediaStatusUpdated() {
        zzc();
    }

    public final void onSendingRemoteMediaRequest() {
        zzb(true);
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        zzc();
    }

    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}
