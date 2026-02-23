package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import q4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbx implements a {
    final /* synthetic */ zzbz zza;

    public zzbx(zzbz zzbzVar) {
        this.zza = zzbzVar;
    }

    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            zzbz zzbzVar = this.zza;
            if (zzbz.zza(zzbzVar) != null) {
                zzbz.zza(zzbzVar).setVisibility(4);
            }
            zzbz.zzb(this.zza).setVisibility(0);
            zzbz.zzb(this.zza).setImageBitmap(bitmap);
            zzbz zzbzVar2 = this.zza;
            if (zzbz.zzc(zzbzVar2) != null) {
                zzbz.zzc(zzbzVar2).zza();
            }
        }
    }
}
