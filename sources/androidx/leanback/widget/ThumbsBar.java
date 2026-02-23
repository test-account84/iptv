package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ThumbsBar extends LinearLayout {
    public int a;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final SparseArray h;
    public boolean i;

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int c(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public final int a(int i) {
        int c = c(i - this.e, this.c + this.g);
        if (c < 2) {
            c = 2;
        } else if ((c & 1) != 0) {
            c++;
        }
        return c + 1;
    }

    public View b(ViewGroup viewGroup) {
        return new ImageView(viewGroup.getContext());
    }

    public final void d() {
        int i;
        while (getChildCount() > this.a) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (getChildCount() < this.a) {
            addView(b(this), new LinearLayout.LayoutParams(this.c, this.d));
        }
        int heroIndex = getHeroIndex();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            LinearLayout.LayoutParams layoutParams = childAt.getLayoutParams();
            if (heroIndex == i2) {
                layoutParams.width = this.e;
                i = this.f;
            } else {
                layoutParams.width = this.c;
                i = this.d;
            }
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int width2 = (getWidth() / 2) + (childAt.getMeasuredWidth() / 2);
        childAt.layout(width, getPaddingTop(), width2, getPaddingTop() + childAt.getMeasuredHeight());
        int paddingTop = getPaddingTop() + (childAt.getMeasuredHeight() / 2);
        for (int i5 = heroIndex - 1; i5 >= 0; i5--) {
            int i6 = width - this.g;
            View childAt2 = getChildAt(i5);
            childAt2.layout(i6 - childAt2.getMeasuredWidth(), paddingTop - (childAt2.getMeasuredHeight() / 2), i6, (childAt2.getMeasuredHeight() / 2) + paddingTop);
            width = i6 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex >= this.a) {
                return;
            }
            int i7 = width2 + this.g;
            View childAt3 = getChildAt(heroIndex);
            childAt3.layout(i7, paddingTop - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i7, (childAt3.getMeasuredHeight() / 2) + paddingTop);
            width2 = i7 + childAt3.getMeasuredWidth();
        }
    }

    public void onMeasure(int i, int i2) {
        int a;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (this.i || this.a == (a = a(measuredWidth))) {
            return;
        }
        this.a = a;
        d();
    }

    public void setNumberOfThumbs(int i) {
        this.i = true;
        this.a = i;
        d();
    }

    public void setThumbSpace(int i) {
        this.g = i;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
        this.h = new SparseArray();
        this.i = false;
        this.c = context.getResources().getDimensionPixelSize(g0.c.s);
        this.d = context.getResources().getDimensionPixelSize(g0.c.q);
        this.f = context.getResources().getDimensionPixelSize(g0.c.m);
        this.e = context.getResources().getDimensionPixelSize(g0.c.l);
        this.g = context.getResources().getDimensionPixelSize(g0.c.r);
    }
}
