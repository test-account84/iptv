package com.google.android.gms.internal.cast;

import android.content.Context;
import android.widget.ImageView;
import n4.e;
import o4.b;
import o4.t;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcf extends a {
    private final ImageView zza;
    private final String zzb;
    private final String zzc;
    private final Context zzd;
    private e.d zze;

    public zzcf(ImageView imageView, Context context) {
        this.zza = imageView;
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        this.zzb = applicationContext.getString(t.m);
        this.zzc = applicationContext.getString(t.D);
        imageView.setEnabled(false);
        this.zze = null;
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    public final void onSessionConnected(o4.e eVar) {
        if (this.zze == null) {
            this.zze = new zzce(this);
        }
        eVar.p(this.zze);
        super.onSessionConnected(eVar);
        zza();
    }

    public final void onSessionEnded() {
        e.d dVar;
        this.zza.setEnabled(false);
        o4.e c = b.e(this.zzd).c().c();
        if (c != null && (dVar = this.zze) != null) {
            c.t(dVar);
        }
        super.onSessionEnded();
    }

    public final void zza() {
        o4.e c = b.e(this.zzd).c().c();
        if (c == null || !c.c()) {
            this.zza.setEnabled(false);
            return;
        }
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            this.zza.setEnabled(false);
        } else {
            this.zza.setEnabled(true);
        }
        boolean s = c.s();
        this.zza.setSelected(s);
        this.zza.setContentDescription(s ? this.zzc : this.zzb);
    }
}
