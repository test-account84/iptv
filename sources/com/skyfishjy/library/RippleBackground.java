package com.skyfishjy.library;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import c8.b;
import c8.c;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RippleBackground extends RelativeLayout {
    public int a;
    public float c;
    public float d;
    public int e;
    public int f;
    public int g;
    public float h;
    public int i;
    public Paint j;
    public boolean k;
    public AnimatorSet l;
    public ArrayList m;
    public RelativeLayout.LayoutParams n;
    public ArrayList o;

    public class a extends View {
        public a(Context context) {
            super(context);
            setVisibility(4);
        }

        public void onDraw(Canvas canvas) {
            float min = Math.min(getWidth(), getHeight()) / 2;
            canvas.drawCircle(min, min, min - RippleBackground.a(RippleBackground.this), RippleBackground.b(RippleBackground.this));
        }
    }

    public RippleBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.o = new ArrayList();
        c(context, attributeSet);
    }

    public static /* synthetic */ float a(RippleBackground rippleBackground) {
        return rippleBackground.c;
    }

    public static /* synthetic */ Paint b(RippleBackground rippleBackground) {
        return rippleBackground.j;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        Paint paint;
        Paint.Style style;
        if (isInEditMode()) {
            return;
        }
        if (attributeSet == null) {
            throw new IllegalArgumentException("Attributes should be provided to this view,");
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a);
        this.a = obtainStyledAttributes.getColor(c.b, getResources().getColor(c8.a.a));
        this.c = obtainStyledAttributes.getDimension(c.g, getResources().getDimension(b.b));
        this.d = obtainStyledAttributes.getDimension(c.d, getResources().getDimension(b.a));
        this.e = obtainStyledAttributes.getInt(c.c, 3000);
        this.f = obtainStyledAttributes.getInt(c.e, 6);
        this.h = obtainStyledAttributes.getFloat(c.f, 6.0f);
        this.i = obtainStyledAttributes.getInt(c.h, 0);
        obtainStyledAttributes.recycle();
        this.g = this.e / this.f;
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setAntiAlias(true);
        if (this.i == 0) {
            this.c = 0.0f;
            paint = this.j;
            style = Paint.Style.FILL;
        } else {
            paint = this.j;
            style = Paint.Style.STROKE;
        }
        paint.setStyle(style);
        this.j.setColor(this.a);
        float f = this.d;
        float f2 = this.c;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((f + f2) * 2.0f), (int) ((f + f2) * 2.0f));
        this.n = layoutParams;
        layoutParams.addRule(13, -1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.setDuration(this.e);
        this.l.setInterpolator(new AccelerateDecelerateInterpolator());
        this.m = new ArrayList();
        for (int i = 0; i < this.f; i++) {
            a aVar = new a(getContext());
            addView(aVar, this.n);
            this.o.add(aVar);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "ScaleX", new float[]{1.0f, this.h});
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat.setStartDelay(this.g * i);
            this.m.add(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar, "ScaleY", new float[]{1.0f, this.h});
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setRepeatMode(1);
            ofFloat2.setStartDelay(this.g * i);
            this.m.add(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(aVar, "Alpha", new float[]{1.0f, 0.0f});
            ofFloat3.setRepeatCount(-1);
            ofFloat3.setRepeatMode(1);
            ofFloat3.setStartDelay(this.g * i);
            this.m.add(ofFloat3);
        }
        this.l.playTogether(this.m);
    }

    public boolean d() {
        return this.k;
    }

    public void e() {
        if (d()) {
            return;
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((a) it.next()).setVisibility(0);
        }
        this.l.start();
        this.k = true;
    }

    public void f() {
        if (d()) {
            this.l.end();
            this.k = false;
        }
    }
}
