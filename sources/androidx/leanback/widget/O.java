package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class o extends G {
    public int e;
    public int f;
    public int[] g = new int[2];
    public Rect h = new Rect();

    public void d(View view) {
        b().addView(view);
    }

    public void e(View view) {
        int i;
        int width = b().getWidth() - b().getPaddingRight();
        int paddingLeft = b().getPaddingLeft();
        view.measure(0, 0);
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        boolean z = P.L.E(view) == 1;
        if (!z && this.e + view.getMeasuredWidth() > width) {
            i = width - view.getMeasuredWidth();
            layoutParams.leftMargin = i;
        } else if (z && this.e < paddingLeft) {
            layoutParams.leftMargin = paddingLeft;
        } else if (z) {
            width = this.f;
            i = width - view.getMeasuredWidth();
            layoutParams.leftMargin = i;
        } else {
            i = this.e;
            layoutParams.leftMargin = i;
        }
        view.requestLayout();
    }

    public void k(HorizontalGridView horizontalGridView, View view, Object obj) {
        ViewGroup b = b();
        horizontalGridView.C1(view, this.g);
        this.h.set(0, 0, view.getWidth(), view.getHeight());
        b.offsetDescendantRectToMyCoords(view, this.h);
        Rect rect = this.h;
        int i = rect.left;
        int i2 = this.g[0];
        this.e = i - i2;
        this.f = rect.right - i2;
        f(obj);
    }
}
