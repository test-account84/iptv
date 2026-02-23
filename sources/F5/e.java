package f5;

import P.L;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e extends ViewGroup {
    public int a;
    public int c;
    public boolean d;
    public int e;

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        d(context, attributeSet);
    }

    public static int a(int i, int i2, int i3) {
        return i2 != Integer.MIN_VALUE ? i2 != 1073741824 ? i3 : i : Math.min(i3, i);
    }

    public int b(View view) {
        Object tag = view.getTag(R4.f.F);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.d;
    }

    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R4.l.g2, 0, 0);
        this.a = obtainStyledAttributes.getDimensionPixelSize(R4.l.i2, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R4.l.h2, 0);
        obtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.c;
    }

    public int getLineSpacing() {
        return this.a;
    }

    public int getRowCount() {
        return this.e;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            this.e = 0;
            return;
        }
        this.e = 1;
        boolean z2 = L.E(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i7 = (i3 - i) - paddingLeft;
        int i8 = paddingRight;
        int i9 = paddingTop;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R4.f.F, -1);
            } else {
                ViewGroup.MarginLayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams;
                    i6 = P.s.b(marginLayoutParams);
                    i5 = P.s.a(marginLayoutParams);
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                int measuredWidth = i8 + i6 + childAt.getMeasuredWidth();
                if (!this.d && measuredWidth > i7) {
                    i9 = this.a + paddingTop;
                    this.e++;
                    i8 = paddingRight;
                }
                childAt.setTag(R4.f.F, Integer.valueOf(this.e - 1));
                int i11 = i8 + i6;
                int measuredWidth2 = childAt.getMeasuredWidth() + i11;
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                if (z2) {
                    i11 = i7 - measuredWidth2;
                    measuredWidth2 = (i7 - i8) - i6;
                }
                childAt.layout(i11, i9, measuredWidth2, measuredHeight);
                i8 += i6 + i5 + childAt.getMeasuredWidth() + this.c;
                paddingTop = measuredHeight;
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i7 = paddingTop;
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams;
                    i3 = marginLayoutParams.leftMargin;
                    i4 = marginLayoutParams.rightMargin;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                int i10 = paddingLeft;
                if (paddingLeft + i3 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    i5 = i10;
                } else {
                    i5 = getPaddingLeft();
                    i7 = this.a + paddingTop;
                }
                int measuredWidth = i5 + i3 + childAt.getMeasuredWidth();
                int measuredHeight = i7 + childAt.getMeasuredHeight();
                if (measuredWidth > i8) {
                    i8 = measuredWidth;
                }
                paddingLeft = i5 + i3 + i4 + childAt.getMeasuredWidth() + this.c;
                if (i9 == getChildCount() - 1) {
                    i8 += i4;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i8 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i) {
        this.c = i;
    }

    public void setLineSpacing(int i) {
        this.a = i;
    }

    public void setSingleLine(boolean z) {
        this.d = z;
    }
}
