package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    public AnimatorSet b;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.I(ExpandableTransformationBehavior.this, null);
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public static /* synthetic */ AnimatorSet I(ExpandableTransformationBehavior expandableTransformationBehavior, AnimatorSet animatorSet) {
        expandableTransformationBehavior.b = animatorSet;
        return animatorSet;
    }

    public boolean H(View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = this.b;
        boolean z3 = animatorSet != null;
        if (z3) {
            animatorSet.cancel();
        }
        AnimatorSet J = J(view, view2, z, z3);
        this.b = J;
        J.addListener(new a());
        this.b.start();
        if (!z2) {
            this.b.end();
        }
        return true;
    }

    public abstract AnimatorSet J(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
