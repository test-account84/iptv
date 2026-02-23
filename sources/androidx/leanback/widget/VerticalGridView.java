package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VerticalGridView extends b {
    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void F1(Context context, AttributeSet attributeSet) {
        D1(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.l.k0);
        setColumnWidth(obtainStyledAttributes);
        setNumColumns(obtainStyledAttributes.getInt(g0.l.m0, 1));
        obtainStyledAttributes.recycle();
    }

    public void setColumnWidth(int i) {
        this.M0.s4(i);
        requestLayout();
    }

    public void setNumColumns(int i) {
        this.M0.m4(i);
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.M0.q4(1);
        F1(context, attributeSet);
    }

    public void setColumnWidth(TypedArray typedArray) {
        if (typedArray.peekValue(g0.l.l0) != null) {
            setColumnWidth(typedArray.getLayoutDimension(g0.l.l0, 0));
        }
    }
}
