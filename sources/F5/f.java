package f5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f extends androidx.appcompat.widget.b {
    public Drawable q;
    public final Rect r;
    public final Rect s;
    public int t;
    public boolean u;
    public boolean v;

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = new Rect();
        this.s = new Rect();
        this.t = 119;
        this.u = true;
        this.v = false;
        TypedArray h = u.h(context, attributeSet, R4.l.l2, i, 0, new int[0]);
        this.t = h.getInt(R4.l.n2, this.t);
        Drawable drawable = h.getDrawable(R4.l.m2);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.u = h.getBoolean(R4.l.o2, true);
        h.recycle();
    }

    public void draw(Canvas canvas) {
        super/*android.view.ViewGroup*/.draw(canvas);
        Drawable drawable = this.q;
        if (drawable != null) {
            if (this.v) {
                this.v = false;
                Rect rect = this.r;
                Rect rect2 = this.s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super/*android.view.ViewGroup*/.drawableHotspotChanged(f, f2);
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    public void drawableStateChanged() {
        super/*android.view.ViewGroup*/.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.q.setState(getDrawableState());
    }

    public Drawable getForeground() {
        return this.q;
    }

    public int getForegroundGravity() {
        return this.t;
    }

    public void jumpDrawablesToCurrentState() {
        super/*android.view.ViewGroup*/.jumpDrawablesToCurrentState();
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.v = z | this.v;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.view.ViewGroup*/.onSizeChanged(i, i2, i3, i4);
        this.v = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.q);
            }
            this.q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.t != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.t = i;
            if (i == 119 && this.q != null) {
                this.q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super/*android.view.ViewGroup*/.verifyDrawable(drawable) || drawable == this.q;
    }
}
