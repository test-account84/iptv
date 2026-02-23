package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class HideBottomViewOnScrollBehavior extends CoordinatorLayout.c {
    public int a;
    public int b;
    public int c;
    public ViewPropertyAnimator d;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.E(HideBottomViewOnScrollBehavior.this, null);
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.b = 2;
        this.c = 0;
    }

    public static /* synthetic */ ViewPropertyAnimator E(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, ViewPropertyAnimator viewPropertyAnimator) {
        hideBottomViewOnScrollBehavior.d = viewPropertyAnimator;
        return viewPropertyAnimator;
    }

    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public final void F(View view, int i, long j, TimeInterpolator timeInterpolator) {
        this.d = view.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a());
    }

    public boolean G() {
        return this.b == 1;
    }

    public boolean H() {
        return this.b == 2;
    }

    public void I(View view) {
        J(view, true);
    }

    public void J(View view, boolean z) {
        if (G()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.b = 1;
        int i = this.a + this.c;
        if (z) {
            F(view, i, 175L, S4.a.c);
        } else {
            view.setTranslationY(i);
        }
    }

    public void K(View view) {
        L(view, true);
    }

    public void L(View view, boolean z) {
        if (H()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.b = 2;
        if (z) {
            F(view, 0, 225L, S4.a.d);
        } else {
            view.setTranslationY(0);
        }
    }

    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.a = view.getMeasuredHeight() + view.getLayoutParams().bottomMargin;
        return super.l(coordinatorLayout, view, i);
    }

    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            I(view);
        } else if (i2 < 0) {
            K(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 2;
        this.c = 0;
    }
}
