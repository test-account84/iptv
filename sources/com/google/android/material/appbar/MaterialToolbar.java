package com.google.android.material.appbar;

import H.a;
import P.L;
import R4.b;
import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import f5.u;
import f5.v;
import l5.g;
import l5.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MaterialToolbar extends Toolbar {
    public static final int h0 = k.v;
    public static final ImageView.ScaleType[] i0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer V;
    public boolean W;
    public boolean e0;
    public ImageView.ScaleType f0;
    public Boolean g0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.K);
    }

    public final Pair S(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    public final void T(Context context) {
        ColorDrawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.W(ColorStateList.valueOf(background != null ? background.getColor() : 0));
            gVar.L(context);
            gVar.V(L.y(this));
            L.w0(this, gVar);
        }
    }

    public final void U(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i += max;
            i2 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i, view.getTop(), i2, view.getBottom());
    }

    public final void V() {
        if (this.W || this.e0) {
            TextView e = v.e(this);
            TextView c = v.c(this);
            if (e == null && c == null) {
                return;
            }
            Pair S = S(e, c);
            if (this.W && e != null) {
                U(e, S);
            }
            if (!this.e0 || c == null) {
                return;
            }
            U(c, S);
        }
    }

    public final Drawable W(Drawable drawable) {
        if (drawable == null || this.V == null) {
            return drawable;
        }
        Drawable r = a.r(drawable.mutate());
        a.n(r, this.V.intValue());
        return r;
    }

    public final void X() {
        ImageView b = v.b(this);
        if (b != null) {
            Boolean bool = this.g0;
            if (bool != null) {
                b.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f0;
            if (scaleType != null) {
                b.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f0;
    }

    public Integer getNavigationIconTint() {
        return this.V;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        V();
        X();
    }

    public void setElevation(float f) {
        super/*android.view.ViewGroup*/.setElevation(f);
        h.d(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.g0;
        if (bool == null || bool.booleanValue() != z) {
            this.g0 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f0 != scaleType) {
            this.f0 = scaleType;
            requestLayout();
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(W(drawable));
    }

    public void setNavigationIconTint(int i) {
        this.V = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.e0 != z) {
            this.e0 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.W != z) {
            this.W = z;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        int i2 = h0;
        super(p5.a.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray h = u.h(context2, attributeSet, l.Y3, i, i2, new int[0]);
        if (h.hasValue(l.b4)) {
            setNavigationIconTint(h.getColor(l.b4, -1));
        }
        this.W = h.getBoolean(l.d4, false);
        this.e0 = h.getBoolean(l.c4, false);
        int i3 = h.getInt(l.a4, -1);
        if (i3 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = i0;
            if (i3 < scaleTypeArr.length) {
                this.f0 = scaleTypeArr[i3];
            }
        }
        if (h.hasValue(l.Z3)) {
            this.g0 = Boolean.valueOf(h.getBoolean(l.Z3, false));
        }
        h.recycle();
        T(context2);
    }
}
