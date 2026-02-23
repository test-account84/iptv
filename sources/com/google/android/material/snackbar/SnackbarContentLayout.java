package com.google.android.material.snackbar;

import P.L;
import R4.d;
import R4.f;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class SnackbarContentLayout extends LinearLayout {
    public TextView a;
    public Button c;
    public int d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void a(View view, int i, int i2) {
        if (L.Y(view)) {
            L.F0(view, L.J(view), i, L.I(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    public final boolean b(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.a.getPaddingTop() == i2 && this.a.getPaddingBottom() == i3) {
            return z;
        }
        a(this.a, i2, i3);
        return true;
    }

    public Button getActionView() {
        return this.c;
    }

    public TextView getMessageView() {
        return this.a;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.a = findViewById(f.I);
        this.c = findViewById(f.H);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.g);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f);
        boolean z = this.a.getLayout().getLineCount() > 1;
        if (!z || this.d <= 0 || this.c.getMeasuredWidth() <= this.d) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!b(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMaxInlineActionWidth(int i) {
        this.d = i;
    }
}
