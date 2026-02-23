package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import p4.b;
import p4.c;
import p4.e;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbz extends a {
    private final ImageView zza;
    private final b zzb;
    private final Bitmap zzc;
    private final View zzd;
    private final c zze;
    private final zzby zzf;
    private final q4.b zzg;

    public zzbz(ImageView imageView, Context context, b bVar, int i, View view, zzby zzbyVar) {
        p4.a H;
        this.zza = imageView;
        this.zzb = bVar;
        this.zzf = zzbyVar;
        this.zzc = i != 0 ? BitmapFactory.decodeResource(context.getResources(), i) : null;
        this.zzd = view;
        o4.b g = o4.b.g(context);
        if (g != null && (H = g.a().H()) != null) {
            H.I();
        }
        this.zzg = new q4.b(context.getApplicationContext());
    }

    public static /* bridge */ /* synthetic */ View zza(zzbz zzbzVar) {
        return zzbzVar.zzd;
    }

    public static /* bridge */ /* synthetic */ ImageView zzb(zzbz zzbzVar) {
        return zzbzVar.zza;
    }

    public static /* bridge */ /* synthetic */ zzby zzc(zzbz zzbzVar) {
        return zzbzVar.zzf;
    }

    private final void zzd() {
        View view = this.zzd;
        if (view != null) {
            view.setVisibility(0);
            this.zza.setVisibility(4);
        }
        Bitmap bitmap = this.zzc;
        if (bitmap != null) {
            this.zza.setImageBitmap(bitmap);
        }
    }

    private final void zze() {
        Uri a;
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            zzd();
            return;
        }
        MediaInfo j = remoteMediaClient.j();
        if (j == null) {
            a = null;
        } else {
            j.Q();
            a = e.a(j, 0);
        }
        if (a == null) {
            zzd();
        } else {
            this.zzg.d(a);
        }
    }

    public final void onMediaStatusUpdated() {
        zze();
    }

    public final void onSessionConnected(o4.e eVar) {
        super.onSessionConnected(eVar);
        this.zzg.c(new zzbx(this));
        zzd();
        zze();
    }

    public final void onSessionEnded() {
        this.zzg.a();
        zzd();
        super.onSessionEnded();
    }
}
