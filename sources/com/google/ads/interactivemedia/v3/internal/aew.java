package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aew extends FrameLayout {
    private final aev a;
    private float b;
    private final int c;

    public aew(Context context) {
        super(context, (AttributeSet) null);
        this.c = 0;
        this.a = new aev(this);
    }

    public final void a(float f) {
        if (this.b != f) {
            this.b = f;
            requestLayout();
        }
    }

    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = (this.b / (f / f2)) - 1.0f;
        if (Math.abs(f3) <= 0.01f) {
            this.a.a();
            return;
        }
        if (f3 > 0.0f) {
            measuredHeight = (int) (f / this.b);
        } else {
            measuredWidth = (int) (f2 * this.b);
        }
        this.a.a();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }
}
