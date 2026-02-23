package com.google.android.material.timepicker;

import P.L;
import R4.f;
import R4.h;
import R4.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import l5.g;
import l5.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c extends ConstraintLayout {
    public g A;
    public final Runnable y;
    public int z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.x();
        }
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(h.h, this);
        L.w0(this, t());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.w4, i, 0);
        this.z = obtainStyledAttributes.getDimensionPixelSize(l.x4, 0);
        this.y = new a();
        obtainStyledAttributes.recycle();
    }

    public static boolean w(View view) {
        return "skip".equals(view.getTag());
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(L.m());
        }
        y();
    }

    public void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        x();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        y();
    }

    public void setBackgroundColor(int i) {
        this.A.W(ColorStateList.valueOf(i));
    }

    public final Drawable t() {
        g gVar = new g();
        this.A = gVar;
        gVar.U(new i(0.5f));
        this.A.W(ColorStateList.valueOf(-1));
        return this.A;
    }

    public int u() {
        return this.z;
    }

    public void v(int i) {
        this.z = i;
        x();
    }

    public void x() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (w(getChildAt(i2))) {
                i++;
            }
        }
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.g(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != f.b && !w(childAt)) {
                cVar.h(childAt.getId(), f.b, this.z, f);
                f += 360.0f / (childCount - i);
            }
        }
        cVar.c(this);
    }

    public final void y() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.y);
            handler.post(this.y);
        }
    }
}
