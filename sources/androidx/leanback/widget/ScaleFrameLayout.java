package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ScaleFrameLayout extends FrameLayout {
    public float a;
    public float c;
    public float d;

    public ScaleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int a(int i, float f) {
        return f == 1.0f ? i : View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i) / f) + 0.5f), View.MeasureSpec.getMode(i));
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        view.setScaleX(this.d);
        view.setScaleY(this.d);
    }

    public boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        boolean addViewInLayout = super.addViewInLayout(view, i, layoutParams, z);
        if (addViewInLayout) {
            view.setScaleX(this.d);
            view.setScaleY(this.d);
        }
        return addViewInLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ScaleFrameLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i, int i2) {
        float f = this.a;
        if (f == 1.0f && this.c == 1.0f) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(a(i, f), a(i2, this.c));
            setMeasuredDimension((int) ((getMeasuredWidth() * this.a) + 0.5f), (int) ((getMeasuredHeight() * this.c) + 0.5f));
        }
    }

    public void setChildScale(float f) {
        if (this.d != f) {
            this.d = f;
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setScaleX(f);
                getChildAt(i).setScaleY(f);
            }
        }
    }

    public void setForeground(Drawable drawable) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutScaleX(float f) {
        if (f != this.a) {
            this.a = f;
            requestLayout();
        }
    }

    public void setLayoutScaleY(float f) {
        if (f != this.c) {
            this.c = f;
            requestLayout();
        }
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1.0f;
        this.c = 1.0f;
        this.d = 1.0f;
    }
}
