package com.google.android.material.textview;

import R4.l;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import i5.b;
import i5.c;
import p5.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public static boolean s(Context context) {
        return b.b(context, R4.b.H, true);
    }

    public static int t(Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.T3, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(l.U3, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int u(Context context, TypedArray typedArray, int... iArr) {
        int i = -1;
        for (int i2 = 0; i2 < iArr.length && i < 0; i2++) {
            i = c.c(context, typedArray, iArr[i2], -1);
        }
        return i;
    }

    public static boolean v(Context context, Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.T3, i, i2);
        int u = u(context, obtainStyledAttributes, l.V3, l.W3);
        obtainStyledAttributes.recycle();
        return u != -1;
    }

    public final void r(Resources.Theme theme, int i) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i, l.P3);
        int u = u(getContext(), obtainStyledAttributes, l.R3, l.S3);
        obtainStyledAttributes.recycle();
        if (u >= 0) {
            setLineHeight(u);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (s(context)) {
            r(context.getTheme(), i);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        int t;
        super(a.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        if (s(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (v(context2, theme, attributeSet, i, i2) || (t = t(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            r(theme, t);
        }
    }
}
