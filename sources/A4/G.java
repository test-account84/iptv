package a4;

import android.animation.ValueAnimator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.b a;

    public /* synthetic */ g(com.google.android.exoplayer2.ui.b bVar) {
        this.a = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        com.google.android.exoplayer2.ui.b.c(this.a, valueAnimator);
    }
}
