package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public d(h hVar) {
        this.a = hVar;
    }

    public final void onAnimationEnd(Animator animator) {
        h hVar = this.a;
        hVar.h = h.a(hVar);
        this.a.h.start();
    }
}
