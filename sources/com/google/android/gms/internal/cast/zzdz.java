package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import s.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzdz extends AnimatorListenerAdapter {
    private final i zza = new i();

    public final void onAnimationCancel(Animator animator) {
        this.zza.put(animator, Boolean.TRUE);
    }

    public final void onAnimationStart(Animator animator) {
        this.zza.put(animator, Boolean.FALSE);
    }

    public final boolean zza(Animator animator) {
        return this.zza.containsKey(animator) && ((Boolean) this.zza.get(animator)).booleanValue();
    }
}
