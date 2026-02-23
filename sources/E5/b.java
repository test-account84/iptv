package e5;

import O.h;
import R4.c;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import l5.g;
import l5.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b extends com.google.android.material.floatingactionbutton.a {

    public static class a extends g {
        public a(k kVar) {
            super(kVar);
        }

        public boolean isStateful() {
            return true;
        }
    }

    public b(FloatingActionButton floatingActionButton, k5.b bVar) {
        super(floatingActionButton, bVar);
    }

    public void A(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.w.isEnabled()) {
                this.w.setElevation(this.h);
                if (this.w.isPressed()) {
                    floatingActionButton = this.w;
                    f = this.j;
                } else if (this.w.isFocused() || this.w.isHovered()) {
                    floatingActionButton = this.w;
                    f = this.i;
                }
                floatingActionButton.setTranslationZ(f);
            }
            this.w.setElevation(0.0f);
            floatingActionButton = this.w;
            floatingActionButton.setTranslationZ(f);
        }
    }

    public void B(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.w.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.E, f0(f, f3));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.F, f0(f, f2));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.G, f0(f, f2));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.H, f0(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.w, "elevation", new float[]{f}).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.w;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.D);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.I, animatorSet);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.J, f0(0.0f, 0.0f));
            this.w.setStateListAnimator(stateListAnimator);
        }
        if (V()) {
            b0();
        }
    }

    public boolean G() {
        return false;
    }

    public void R(ColorStateList colorStateList) {
        RippleDrawable rippleDrawable = this.c;
        if (rippleDrawable instanceof RippleDrawable) {
            rippleDrawable.setColor(j5.b.d(colorStateList));
        } else {
            super.R(colorStateList);
        }
    }

    public boolean V() {
        return this.x.c() || !X();
    }

    public e5.a e0(int i, ColorStateList colorStateList) {
        Context context = this.w.getContext();
        e5.a aVar = new e5.a((k) h.f(this.a));
        aVar.e(E.b.getColor(context, c.e), E.b.getColor(context, c.d), E.b.getColor(context, c.b), E.b.getColor(context, c.c));
        aVar.d(i);
        aVar.c(colorStateList);
        return aVar;
    }

    public final Animator f0(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.w, "elevation", new float[]{f}).setDuration(0L)).with(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, new float[]{f2}).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.D);
        return animatorSet;
    }

    public g g0() {
        return new a((k) h.f(this.a));
    }

    public float j() {
        return this.w.getElevation();
    }

    public void o(Rect rect) {
        if (this.x.c()) {
            super.o(rect);
        } else {
            int sizeDimension = !X() ? (this.k - this.w.getSizeDimension()) / 2 : 0;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    public void t(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        LayerDrawable layerDrawable;
        g g0 = g0();
        this.b = g0;
        g0.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.L(this.w.getContext());
        if (i > 0) {
            this.d = e0(i, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) h.f(this.d), (Drawable) h.f(this.b)});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(j5.b.d(colorStateList2), layerDrawable, (Drawable) null);
        this.c = rippleDrawable;
        this.e = rippleDrawable;
    }

    public void y() {
        b0();
    }

    public void Z() {
    }

    public void w() {
    }
}
