package com.google.android.gms.internal.cast;

import android.animation.Animator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzeb extends zzdz {
    protected final Animator zza;
    private int zzc;
    private final zzef zzd = new zzea(this);
    private final int zzb = -1;

    private zzeb(Animator animator, int i, Runnable runnable) {
        this.zza = animator;
    }

    public static /* bridge */ /* synthetic */ int zzb(zzeb zzebVar) {
        return zzebVar.zzc;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzeb zzebVar, int i) {
        zzebVar.zzc = i;
    }

    public static void zzd(Animator animator, int i, Runnable runnable) {
        animator.addListener(new zzeb(animator, -1, null));
    }

    public static /* bridge */ /* synthetic */ boolean zze(zzeb zzebVar) {
        return zzebVar.zzb != -1 && zzebVar.zzc >= 0;
    }

    public final void onAnimationEnd(Animator animator) {
        if (zza(animator)) {
            return;
        }
        zzei.zzb().zza(this.zzd);
    }
}
