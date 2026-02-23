package com.google.android.gms.internal.cast;

import R.a;
import android.view.animation.Interpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzej {
    private static final Interpolator zza = a.a(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator zzb = a.a(0.4f, 0.0f, 1.0f, 1.0f);
    private static final Interpolator zzc = a.a(0.4f, 0.0f, 0.2f, 1.0f);

    public static /* bridge */ /* synthetic */ Interpolator zza() {
        return zzb;
    }

    public static /* bridge */ /* synthetic */ Interpolator zzb() {
        return zzc;
    }

    public static /* bridge */ /* synthetic */ Interpolator zzc() {
        return zza;
    }
}
