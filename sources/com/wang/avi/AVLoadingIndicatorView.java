package com.wang.avi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import d8.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AVLoadingIndicatorView extends View {
    public static final e8.a o = new e8.a();
    public long a;
    public boolean c;
    public boolean d;
    public boolean e;
    public final Runnable f;
    public final Runnable g;
    public int h;
    public int i;
    public int j;
    public int k;
    public d8.a l;
    public int m;
    public boolean n;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            AVLoadingIndicatorView.a(AVLoadingIndicatorView.this, false);
            AVLoadingIndicatorView.b(AVLoadingIndicatorView.this, -1L);
            AVLoadingIndicatorView.this.setVisibility(8);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            AVLoadingIndicatorView.c(AVLoadingIndicatorView.this, false);
            if (AVLoadingIndicatorView.d(AVLoadingIndicatorView.this)) {
                return;
            }
            AVLoadingIndicatorView.b(AVLoadingIndicatorView.this, System.currentTimeMillis());
            AVLoadingIndicatorView.this.setVisibility(0);
        }
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1L;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = new a();
        this.g = new b();
        g(context, attributeSet, 0, d8.b.a);
    }

    public static /* synthetic */ boolean a(AVLoadingIndicatorView aVLoadingIndicatorView, boolean z) {
        aVLoadingIndicatorView.c = z;
        return z;
    }

    public static /* synthetic */ long b(AVLoadingIndicatorView aVLoadingIndicatorView, long j) {
        aVLoadingIndicatorView.a = j;
        return j;
    }

    public static /* synthetic */ boolean c(AVLoadingIndicatorView aVLoadingIndicatorView, boolean z) {
        aVLoadingIndicatorView.d = z;
        return z;
    }

    public static /* synthetic */ boolean d(AVLoadingIndicatorView aVLoadingIndicatorView) {
        return aVLoadingIndicatorView.e;
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        d8.a aVar = this.l;
        if (aVar != null) {
            aVar.setHotspot(f, f2);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        l();
    }

    public void e(Canvas canvas) {
        d8.a aVar = this.l;
        if (aVar != null) {
            int save = canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            aVar.draw(canvas);
            canvas.restoreToCount(save);
            if (this.n) {
                aVar.start();
                this.n = false;
            }
        }
    }

    public void f() {
        this.e = true;
        removeCallbacks(this.g);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.a;
        long j2 = currentTimeMillis - j;
        if (j2 >= 500 || j == -1) {
            setVisibility(8);
        } else {
            if (this.c) {
                return;
            }
            postDelayed(this.f, 500 - j2);
            this.c = true;
        }
    }

    public final void g(Context context, AttributeSet attributeSet, int i, int i2) {
        this.h = 24;
        this.i = 48;
        this.j = 24;
        this.k = 48;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a, i, i2);
        this.h = obtainStyledAttributes.getDimensionPixelSize(c.g, this.h);
        this.i = obtainStyledAttributes.getDimensionPixelSize(c.e, this.i);
        this.j = obtainStyledAttributes.getDimensionPixelSize(c.f, this.j);
        this.k = obtainStyledAttributes.getDimensionPixelSize(c.d, this.k);
        String string = obtainStyledAttributes.getString(c.c);
        this.m = obtainStyledAttributes.getColor(c.b, -1);
        setIndicator(string);
        if (this.l == null) {
            setIndicator(o);
        }
        obtainStyledAttributes.recycle();
    }

    public d8.a getIndicator() {
        return this.l;
    }

    public final void h() {
        removeCallbacks(this.f);
        removeCallbacks(this.g);
    }

    public void i() {
        if (getVisibility() != 0) {
            return;
        }
        if (this.l instanceof Animatable) {
            this.n = true;
        }
        postInvalidate();
    }

    public void invalidateDrawable(Drawable drawable) {
        if (!verifyDrawable(drawable)) {
            super.invalidateDrawable(drawable);
            return;
        }
        Rect bounds = drawable.getBounds();
        int scrollX = getScrollX() + getPaddingLeft();
        int scrollY = getScrollY() + getPaddingTop();
        invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
    }

    public void j() {
        d8.a aVar = this.l;
        if (aVar instanceof Animatable) {
            aVar.stop();
            this.n = false;
        }
        postInvalidate();
    }

    public final void k(int i, int i2) {
        int i3;
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        if (this.l != null) {
            float intrinsicWidth = r0.getIntrinsicWidth() / this.l.getIntrinsicHeight();
            float f = paddingRight;
            float f2 = paddingTop;
            float f3 = f / f2;
            int i4 = 0;
            if (intrinsicWidth == f3) {
                i3 = 0;
            } else if (f3 > intrinsicWidth) {
                int i5 = (int) (f2 * intrinsicWidth);
                int i6 = (paddingRight - i5) / 2;
                i4 = i6;
                paddingRight = i5 + i6;
                i3 = 0;
            } else {
                int i7 = (int) (f * (1.0f / intrinsicWidth));
                int i8 = (paddingTop - i7) / 2;
                int i9 = i7 + i8;
                i3 = i8;
                paddingTop = i9;
            }
            this.l.setBounds(i4, i3, paddingRight, paddingTop);
        }
    }

    public final void l() {
        int[] drawableState = getDrawableState();
        d8.a aVar = this.l;
        if (aVar == null || !aVar.isStateful()) {
            return;
        }
        this.l.setState(drawableState);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
        h();
    }

    public void onDetachedFromWindow() {
        j();
        super.onDetachedFromWindow();
        h();
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e(canvas);
    }

    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        try {
            d8.a aVar = this.l;
            if (aVar != null) {
                i4 = Math.max(this.h, Math.min(this.i, aVar.getIntrinsicWidth()));
                i3 = Math.max(this.j, Math.min(this.k, aVar.getIntrinsicHeight()));
            } else {
                i3 = 0;
                i4 = 0;
            }
            l();
            setMeasuredDimension(View.resolveSizeAndState(i4 + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom(), i2, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        k(i, i2);
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8 || i == 4) {
            j();
        } else {
            i();
        }
    }

    public void setIndicator(d8.a aVar) {
        d8.a aVar2 = this.l;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.l);
            }
            this.l = aVar;
            setIndicatorColor(this.m);
            if (aVar != null) {
                aVar.setCallback(this);
            }
            postInvalidate();
        }
    }

    public void setIndicatorColor(int i) {
        this.m = i;
        this.l.i(i);
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                j();
            } else {
                i();
            }
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.l || super.verifyDrawable(drawable);
    }

    public void setIndicator(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!str.contains(".")) {
            sb.append(getClass().getPackage().getName());
            sb.append(".indicators");
            sb.append(".");
        }
        sb.append(str);
        try {
            setIndicator((d8.a) Class.forName(sb.toString()).newInstance());
        } catch (InstantiationException e) {
            e = e;
            e.printStackTrace();
        } catch (ClassNotFoundException unused) {
            Log.e("AVLoadingIndicatorView", "Didn't find your class , check the name again !");
        } catch (IllegalAccessException e2) {
            e = e2;
            e.printStackTrace();
        }
    }
}
