package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import g0.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FadeAndShortSlide extends Visibility {
    public static final TimeInterpolator f = new DecelerateInterpolator();
    public static final g g = new a();
    public static final g h = new b();
    public static final g i = new c();
    public static final g j = new d();
    public static final g k = new e();
    public g a;
    public Visibility c;
    public float d;
    public final g e;

    public static class a extends g {
        public float a(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int layoutDirection = viewGroup.getLayoutDirection();
            float translationX = view.getTranslationX();
            float c = fadeAndShortSlide.c(viewGroup);
            return layoutDirection == 1 ? translationX + c : translationX - c;
        }
    }

    public static class b extends g {
        public float a(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int layoutDirection = viewGroup.getLayoutDirection();
            float translationX = view.getTranslationX();
            float c = fadeAndShortSlide.c(viewGroup);
            return layoutDirection == 1 ? translationX - c : translationX + c;
        }
    }

    public static class c extends g {
        public float a(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int width = iArr[0] + (view.getWidth() / 2);
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = fadeAndShortSlide.getEpicenter();
            int width2 = epicenter == null ? iArr[0] + (viewGroup.getWidth() / 2) : epicenter.centerX();
            float translationX = view.getTranslationX();
            float c = fadeAndShortSlide.c(viewGroup);
            return width < width2 ? translationX - c : translationX + c;
        }
    }

    public static class d extends g {
        public float b(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() + fadeAndShortSlide.d(viewGroup);
        }
    }

    public static class e extends g {
        public float b(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() - fadeAndShortSlide.d(viewGroup);
        }
    }

    public class f extends g {
        public f() {
        }

        public float b(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int height = iArr[1] + (view.getHeight() / 2);
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = FadeAndShortSlide.this.getEpicenter();
            int height2 = epicenter == null ? iArr[1] + (viewGroup.getHeight() / 2) : epicenter.centerY();
            float translationY = view.getTranslationY();
            float d = fadeAndShortSlide.d(viewGroup);
            return height < height2 ? translationY - d : translationY + d;
        }
    }

    public static abstract class g {
        public float a(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationX();
        }

        public float b(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY();
        }
    }

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Fade();
        this.d = -1.0f;
        this.e = new f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.e0);
        e(obtainStyledAttributes.getInt(l.i0, 8388611));
        obtainStyledAttributes.recycle();
    }

    public Transition addListener(Transition.TransitionListener transitionListener) {
        this.c.addListener(transitionListener);
        return super/*android.transition.Transition*/.addListener(transitionListener);
    }

    public final void b(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    public float c(ViewGroup viewGroup) {
        float f2 = this.d;
        return f2 >= 0.0f ? f2 : viewGroup.getWidth() / 4;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.c.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        b(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.c.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        b(transitionValues);
    }

    public Transition clone() {
        FadeAndShortSlide clone = super/*android.transition.Transition*/.clone();
        clone.c = this.c.clone();
        return clone;
    }

    public float d(ViewGroup viewGroup) {
        float f2 = this.d;
        return f2 >= 0.0f ? f2 : viewGroup.getHeight() / 4;
    }

    public void e(int i2) {
        g gVar;
        if (i2 == 48) {
            gVar = k;
        } else if (i2 == 80) {
            gVar = j;
        } else if (i2 == 112) {
            gVar = this.e;
        } else if (i2 == 8388611) {
            gVar = g;
        } else if (i2 == 8388613) {
            gVar = h;
        } else {
            if (i2 != 8388615) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            gVar = i;
        }
        this.a = gVar;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get("android:fadeAndShortSlideTransition:screenPosition");
        int i2 = iArr[0];
        int i3 = iArr[1];
        float translationX = view.getTranslationX();
        Animator a2 = androidx.leanback.transition.b.a(view, transitionValues2, i2, i3, this.a.a(this, viewGroup, view, iArr), this.a.b(this, viewGroup, view, iArr), translationX, view.getTranslationY(), f, this);
        Animator onAppear = this.c.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (a2 == null) {
            return onAppear;
        }
        if (onAppear == null) {
            return a2;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a2).with(onAppear);
        return animatorSet;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get("android:fadeAndShortSlideTransition:screenPosition");
        Animator a2 = androidx.leanback.transition.b.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.a.a(this, viewGroup, view, iArr), this.a.b(this, viewGroup, view, iArr), f, this);
        Animator onDisappear = this.c.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (a2 == null) {
            return onDisappear;
        }
        if (onDisappear == null) {
            return a2;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a2).with(onDisappear);
        return animatorSet;
    }

    public Transition removeListener(Transition.TransitionListener transitionListener) {
        this.c.removeListener(transitionListener);
        return super/*android.transition.Transition*/.removeListener(transitionListener);
    }

    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.c.setEpicenterCallback(epicenterCallback);
        super/*android.transition.Transition*/.setEpicenterCallback(epicenterCallback);
    }
}
