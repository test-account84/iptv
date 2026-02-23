package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import g0.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SlideKitkat extends Visibility {
    public static final TimeInterpolator d = new DecelerateInterpolator();
    public static final TimeInterpolator e = new AccelerateInterpolator();
    public static final g f = new a();
    public static final g g = new b();
    public static final g h = new c();
    public static final g i = new d();
    public static final g j = new e();
    public static final g k = new f();
    public int a;
    public g c;

    public static class a extends h {
        public float a(View view) {
            return view.getTranslationX() - view.getWidth();
        }
    }

    public static class b extends i {
        public float a(View view) {
            return view.getTranslationY() - view.getHeight();
        }
    }

    public static class c extends h {
        public float a(View view) {
            return view.getTranslationX() + view.getWidth();
        }
    }

    public static class d extends i {
        public float a(View view) {
            return view.getTranslationY() + view.getHeight();
        }
    }

    public static class e extends h {
        public float a(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() + view.getWidth() : view.getTranslationX() - view.getWidth();
        }
    }

    public static class f extends h {
        public float a(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() - view.getWidth() : view.getTranslationX() + view.getWidth();
        }
    }

    public interface g {
        float a(View view);

        float b(View view);

        Property c();
    }

    public static abstract class h implements g {
        public float b(View view) {
            return view.getTranslationX();
        }

        public Property c() {
            return View.TRANSLATION_X;
        }
    }

    public static abstract class i implements g {
        public float b(View view) {
            return view.getTranslationY();
        }

        public Property c() {
            return View.TRANSLATION_Y;
        }
    }

    public static class j extends AnimatorListenerAdapter {
        public boolean a = false;
        public float c;
        public final View d;
        public final float e;
        public final float f;
        public final int g;
        public final Property h;

        public j(View view, Property property, float f, float f2, int i) {
            this.h = property;
            this.d = view;
            this.f = f;
            this.e = f2;
            this.g = i;
            view.setVisibility(0);
        }

        public void onAnimationCancel(Animator animator) {
            this.d.setTag(g0.f.u, new float[]{this.d.getTranslationX(), this.d.getTranslationY()});
            this.h.set(this.d, Float.valueOf(this.f));
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                this.h.set(this.d, Float.valueOf(this.f));
            }
            this.d.setVisibility(this.g);
        }

        public void onAnimationPause(Animator animator) {
            this.c = ((Float) this.h.get(this.d)).floatValue();
            this.h.set(this.d, Float.valueOf(this.e));
            this.d.setVisibility(this.g);
        }

        public void onAnimationResume(Animator animator) {
            this.h.set(this.d, Float.valueOf(this.c));
            this.d.setVisibility(0);
        }
    }

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.e0);
        c(obtainStyledAttributes.getInt(l.i0, 80));
        long j2 = obtainStyledAttributes.getInt(l.g0, -1);
        if (j2 >= 0) {
            setDuration(j2);
        }
        long j3 = obtainStyledAttributes.getInt(l.h0, -1);
        if (j3 > 0) {
            setStartDelay(j3);
        }
        int resourceId = obtainStyledAttributes.getResourceId(l.f0, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
    }

    public final Animator b(View view, Property property, float f2, float f3, float f4, TimeInterpolator timeInterpolator, int i2) {
        float[] fArr = (float[]) view.getTag(g0.f.u);
        if (fArr != null) {
            f2 = View.TRANSLATION_Y == property ? fArr[1] : fArr[0];
            view.setTag(g0.f.u, (Object) null);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, new float[]{f2, f3});
        j jVar = new j(view, property, f4, f3, i2);
        ofFloat.addListener(jVar);
        ofFloat.addPauseListener(jVar);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    public void c(int i2) {
        g gVar;
        if (i2 == 3) {
            gVar = f;
        } else if (i2 == 5) {
            gVar = h;
        } else if (i2 == 48) {
            gVar = g;
        } else if (i2 == 80) {
            gVar = i;
        } else if (i2 == 8388611) {
            gVar = j;
        } else {
            if (i2 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            gVar = k;
        }
        this.c = gVar;
        this.a = i2;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i2, TransitionValues transitionValues2, int i3) {
        View view = transitionValues2 != null ? transitionValues2.view : null;
        if (view == null) {
            return null;
        }
        float b2 = this.c.b(view);
        return b(view, this.c.c(), this.c.a(view), b2, b2, d, 0);
    }

    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i2, TransitionValues transitionValues2, int i3) {
        View view = transitionValues != null ? transitionValues.view : null;
        if (view == null) {
            return null;
        }
        float b2 = this.c.b(view);
        return b(view, this.c.c(), b2, this.c.a(view), b2, e, 4);
    }
}
