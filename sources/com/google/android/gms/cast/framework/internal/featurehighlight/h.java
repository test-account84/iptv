package com.google.android.gms.cast.framework.internal.featurehighlight;

import P.o;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.cast.zzeb;
import com.google.android.gms.internal.cast.zzek;
import o4.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends ViewGroup {
    public final int[] a;
    public final Rect c;
    public final Rect d;
    public final OuterHighlightDrawable e;
    public final InnerZoneDrawable f;
    public View g;
    public Animator h;
    public final i i;
    public final o j;
    public o k;
    public g l;
    public boolean m;
    public HelpTextView n;

    public h(Context context) {
        super(context);
        this.a = new int[2];
        this.c = new Rect();
        this.d = new Rect();
        setId(q.I);
        setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable = new InnerZoneDrawable(context);
        this.f = innerZoneDrawable;
        innerZoneDrawable.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable = new OuterHighlightDrawable(context);
        this.e = outerHighlightDrawable;
        outerHighlightDrawable.setCallback(this);
        this.i = new i(this);
        o oVar = new o(context, new a(this));
        this.j = oVar;
        oVar.b(false);
        setVisibility(8);
    }

    public static /* synthetic */ Animator a(h hVar) {
        InnerZoneDrawable innerZoneDrawable = hVar.f;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", new float[]{1.0f, 1.1f}).setDuration(500L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", new float[]{1.1f, 1.0f}).setDuration(500L);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(innerZoneDrawable, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("pulseScale", new float[]{1.1f, 2.0f}), PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{1.0f, 0.0f})}).setDuration(500L);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(zzek.zzb());
        animatorSet.setStartDelay(500L);
        zzeb.zzd(animatorSet, -1, null);
        return animatorSet;
    }

    public static /* bridge */ /* synthetic */ g c(h hVar) {
        return hVar.l;
    }

    public static /* bridge */ /* synthetic */ OuterHighlightDrawable e(h hVar) {
        return hVar.e;
    }

    public static /* bridge */ /* synthetic */ boolean m(h hVar, float f, float f2) {
        return hVar.d.contains(Math.round(f), Math.round(f2));
    }

    public final View b() {
        return this.n.asView();
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    public final InnerZoneDrawable d() {
        return this.f;
    }

    public final OuterHighlightDrawable f() {
        return this.e;
    }

    public final void g(Runnable runnable) {
        Animator duration = ObjectAnimator.ofFloat(this.n.asView(), "alpha", new float[]{0.0f}).setDuration(200L);
        duration.setInterpolator(zzek.zza());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.e, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{1.125f}), PropertyValuesHolder.ofInt("alpha", new int[]{0})});
        ofPropertyValuesHolder.setInterpolator(zzek.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200L);
        Animator a = this.f.a();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{duration, duration2, a});
        animatorSet.addListener(new e(this, runnable));
        o(animatorSet);
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public final void h(Runnable runnable) {
        Animator duration = ObjectAnimator.ofFloat(this.n.asView(), "alpha", new float[]{0.0f}).setDuration(200L);
        duration.setInterpolator(zzek.zza());
        float exactCenterX = this.c.exactCenterX() - this.e.a();
        float exactCenterY = this.c.exactCenterY() - this.e.b();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.e, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f}), PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, exactCenterX}), PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, exactCenterY}), PropertyValuesHolder.ofInt("alpha", new int[]{0})});
        ofPropertyValuesHolder.setInterpolator(zzek.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200L);
        Animator a = this.f.a();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{duration, duration2, a});
        animatorSet.addListener(new f(this, runnable));
        o(animatorSet);
    }

    public final void i(View view, View view2, boolean z, g gVar) {
        this.g = view;
        this.l = gVar;
        o oVar = new o(getContext(), new b(this, view, true, gVar));
        this.k = oVar;
        oVar.b(false);
        setVisibility(4);
    }

    public final void j(int i) {
        this.e.e(i);
    }

    public final void k() {
        if (this.g == null) {
            throw new IllegalStateException("Target view must be set before animation");
        }
        setVisibility(0);
        Animator duration = ObjectAnimator.ofFloat(this.n.asView(), "alpha", new float[]{0.0f, 1.0f}).setDuration(350L);
        duration.setInterpolator(zzek.zzc());
        Animator d = this.e.d(this.c.exactCenterX() - this.e.a(), this.c.exactCenterY() - this.e.b());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, 255})});
        ofPropertyValuesHolder.setInterpolator(zzek.zzc());
        Animator duration2 = ofPropertyValuesHolder.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{duration, d, duration2});
        animatorSet.addListener(new d(this));
        o(animatorSet);
    }

    public final void l(Runnable runnable) {
        addOnLayoutChangeListener(new c(this, null));
    }

    public final void n(HelpTextView helpTextView) {
        helpTextView.getClass();
        this.n = helpTextView;
        addView(helpTextView.asView(), 0);
    }

    public final void o(Animator animator) {
        Animator animator2 = this.h;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.h = animator;
        animator.start();
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        this.e.draw(canvas);
        this.f.draw(canvas);
        View view = this.g;
        if (view == null) {
            throw new IllegalStateException("Neither target view nor drawable was set");
        }
        if (view.getParent() != null) {
            Bitmap createBitmap = Bitmap.createBitmap(this.g.getWidth(), this.g.getHeight(), Bitmap.Config.ARGB_8888);
            this.g.draw(new Canvas(createBitmap));
            int c = this.e.c();
            int red = Color.red(c);
            int green = Color.green(c);
            int blue = Color.blue(c);
            for (int i = 0; i < createBitmap.getHeight(); i++) {
                for (int i2 = 0; i2 < createBitmap.getWidth(); i2++) {
                    int pixel = createBitmap.getPixel(i2, i);
                    if (Color.alpha(pixel) != 0) {
                        createBitmap.setPixel(i2, i, Color.argb(Color.alpha(pixel), red, green, blue));
                    }
                }
            }
            Rect rect = this.c;
            canvas.drawBitmap(createBitmap, rect.left, rect.top, (Paint) null);
        }
        canvas.restore();
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.g;
        if (view == null) {
            throw new IllegalStateException("Target view must be set before layout");
        }
        if (view.getParent() != null) {
            int[] iArr = this.a;
            View view2 = this.g;
            getLocationInWindow(iArr);
            int i5 = iArr[0];
            int i6 = iArr[1];
            view2.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i5;
            iArr[1] = iArr[1] - i6;
        }
        Rect rect = this.c;
        int[] iArr2 = this.a;
        int i7 = iArr2[0];
        rect.set(i7, iArr2[1], this.g.getWidth() + i7, this.a[1] + this.g.getHeight());
        this.d.set(i, i2, i3, i4);
        this.e.setBounds(this.d);
        this.f.setBounds(this.d);
        this.i.a(this.c, this.d);
    }

    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(View.MeasureSpec.getSize(i), i), View.resolveSize(View.MeasureSpec.getSize(i2), i2));
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.m = this.c.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            actionMasked = 0;
        }
        if (this.m) {
            o oVar = this.k;
            if (oVar != null) {
                oVar.a(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.g.getParent() != null) {
                this.g.onTouchEvent(motionEvent);
            }
        } else {
            this.j.a(motionEvent);
        }
        return true;
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.e || drawable == this.f || drawable == null;
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
