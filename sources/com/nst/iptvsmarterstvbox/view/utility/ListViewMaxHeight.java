package com.nst.iptvsmarterstvbox.view.utility;

import a7.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ListViewMaxHeight extends ListView {
    public final int a;

    public ListViewMaxHeight(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.a;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.a, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    public ListViewMaxHeight(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet == null) {
            this.a = 0;
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, l.c);
        this.a = obtainStyledAttributes.getDimensionPixelSize(l.d, Integer.MAX_VALUE);
        obtainStyledAttributes.recycle();
    }
}
