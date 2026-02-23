package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import n4.p;
import p4.b;
import p4.c;
import p4.e;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbw extends a {
    private final ImageView zza;
    private final b zzb;
    private final Bitmap zzc;
    private final c zzd;
    private final q4.b zze;

    public zzbw(ImageView imageView, Context context, b bVar, int i) {
        p4.a H;
        q4.b bVar2 = new q4.b(context.getApplicationContext());
        this.zza = imageView;
        this.zzb = bVar;
        this.zzc = BitmapFactory.decodeResource(context.getResources(), i);
        o4.b g = o4.b.g(context);
        if (g != null && (H = g.a().H()) != null) {
            H.I();
        }
        this.zze = bVar2;
    }

    public static /* bridge */ /* synthetic */ ImageView zza(zzbw zzbwVar) {
        return zzbwVar.zza;
    }

    private final void zzb() {
        MediaInfo L;
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q()) {
            this.zza.setImageBitmap(this.zzc);
            return;
        }
        p o = remoteMediaClient.o();
        Uri uri = null;
        if (o != null && (L = o.L()) != null) {
            L.Q();
            uri = e.a(L, 0);
        }
        if (uri == null) {
            this.zza.setImageBitmap(this.zzc);
        } else {
            this.zze.d(uri);
        }
    }

    public final void onMediaStatusUpdated() {
        zzb();
    }

    public final void onSessionConnected(o4.e eVar) {
        super.onSessionConnected(eVar);
        this.zze.c(new zzbv(this));
        this.zza.setImageBitmap(this.zzc);
        zzb();
    }

    public final void onSessionEnded() {
        this.zze.a();
        this.zza.setImageBitmap(this.zzc);
        super.onSessionEnded();
    }
}
