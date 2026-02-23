package com.nst.iptvsmarterstvbox;

import a7.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MaxHeightLayout extends FrameLayout {
    public float a;
    public float c;

    public MaxHeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.6f;
        this.c = 0.0f;
        c(context, attributeSet);
        b();
    }

    public final int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public final void b() {
        float f = this.c;
        this.c = f <= 0.0f ? this.a * a(getContext()) : Math.min(f, this.a * a(getContext()));
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.e);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == l.g) {
                this.a = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == l.f) {
                this.c = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            float f = size;
            float f2 = this.c;
            if (f > f2) {
                size = (int) f2;
            }
        }
        if (mode == 0) {
            float f3 = size;
            float f4 = this.c;
            if (f3 > f4) {
                size = (int) f4;
            }
        }
        if (mode == Integer.MIN_VALUE) {
            float f5 = size;
            float f6 = this.c;
            if (f5 > f6) {
                size = (int) f6;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }
}
