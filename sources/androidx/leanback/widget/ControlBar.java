package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ControlBar extends LinearLayout {
    public int a;
    public int c;
    public boolean d;

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.d = true;
    }

    public int a() {
        if (this.d) {
            return getChildCount() / 2;
        }
        return 0;
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int a;
        if (i != 33 && i != 130) {
            super.addFocusables(arrayList, i, i2);
            return;
        }
        int i3 = this.c;
        if (i3 >= 0 && i3 < getChildCount()) {
            a = this.c;
        } else if (getChildCount() <= 0) {
            return;
        } else {
            a = a();
        }
        arrayList.add(getChildAt(a));
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a <= 0) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < getChildCount() - 1) {
            View childAt = getChildAt(i3);
            i3++;
            View childAt2 = getChildAt(i3);
            int measuredWidth = this.a - ((childAt.getMeasuredWidth() + childAt2.getMeasuredWidth()) / 2);
            LinearLayout.LayoutParams layoutParams = childAt2.getLayoutParams();
            int marginStart = measuredWidth - layoutParams.getMarginStart();
            layoutParams.setMarginStart(measuredWidth);
            childAt2.setLayoutParams(layoutParams);
            i4 += marginStart;
        }
        setMeasuredDimension(getMeasuredWidth() + i4, getMeasuredHeight());
    }

    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (getChildCount() > 0) {
            int i2 = this.c;
            if (getChildAt((i2 < 0 || i2 >= getChildCount()) ? a() : this.c).requestFocus(i, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.c = indexOfChild(view);
    }
}
