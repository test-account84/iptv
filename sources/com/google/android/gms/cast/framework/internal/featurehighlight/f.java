package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ h c;

    public f(h hVar, Runnable runnable) {
        this.c = hVar;
        this.a = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        this.c.setVisibility(8);
        this.c.h = null;
        this.a.run();
    }
}
