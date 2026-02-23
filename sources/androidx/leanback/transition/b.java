package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import g0.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b {

    public static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final View a;
        public final View c;
        public final int d;
        public final int e;
        public int[] f;
        public float g;
        public float h;
        public final float i;
        public final float j;

        public a(View view, View view2, int i, int i2, float f, float f2) {
            this.c = view;
            this.a = view2;
            this.d = i - Math.round(view.getTranslationX());
            this.e = i2 - Math.round(view.getTranslationY());
            this.i = f;
            this.j = f2;
            int[] iArr = (int[]) view2.getTag(f.E);
            this.f = iArr;
            if (iArr != null) {
                view2.setTag(f.E, (Object) null);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f == null) {
                this.f = new int[2];
            }
            this.f[0] = Math.round(this.d + this.c.getTranslationX());
            this.f[1] = Math.round(this.e + this.c.getTranslationY());
            this.a.setTag(f.E, this.f);
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationPause(Animator animator) {
            this.g = this.c.getTranslationX();
            this.h = this.c.getTranslationY();
            this.c.setTranslationX(this.i);
            this.c.setTranslationY(this.j);
        }

        public void onAnimationResume(Animator animator) {
            this.c.setTranslationX(this.g);
            this.c.setTranslationY(this.h);
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.c.setTranslationX(this.i);
            this.c.setTranslationY(this.j);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    public static Animator a(View view, TransitionValues transitionValues, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(f.E)) != null) {
            f = (r2[0] - i) + translationX;
            f2 = (r2[1] - i2) + translationY;
        }
        int round = Math.round(f - translationX) + i;
        int round2 = i2 + Math.round(f2 - translationY);
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, View.TRANSLATION_Y, path);
        a aVar = new a(view, transitionValues.view, round, round2, translationX, translationY);
        transition.addListener(aVar);
        ofFloat.addListener(aVar);
        ofFloat.addPauseListener(aVar);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }
}
