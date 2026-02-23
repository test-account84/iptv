package com.google.android.material.transformation;

import S4.b;
import S4.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public final g c;
    public final g d;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View c;

        public a(boolean z, View view) {
            this.a = z;
            this.c = view;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.c.setVisibility(4);
        }

        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.c.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.c = new g(75L, 150L);
        this.d = new g(0L, 150L);
    }

    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.D(coordinatorLayout, view, motionEvent);
    }

    public AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        K(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2));
        return animatorSet;
    }

    public final void K(View view, boolean z, boolean z2, List list, List list2) {
        ObjectAnimator ofFloat;
        g gVar = z ? this.c : this.d;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f});
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
        }
        gVar.a(ofFloat);
        list.add(ofFloat);
    }

    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new g(75L, 150L);
        this.d = new g(0L, 150L);
    }
}
