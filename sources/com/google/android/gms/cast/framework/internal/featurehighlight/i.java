package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import o4.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i {
    public final Rect a = new Rect();
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final h f;

    public i(h hVar) {
        this.f = hVar;
        Resources resources = hVar.getResources();
        this.b = resources.getDimensionPixelSize(o.d);
        this.c = resources.getDimensionPixelOffset(o.c);
        this.d = resources.getDimensionPixelSize(o.g);
        this.e = resources.getDimensionPixelSize(o.f);
    }

    public final void a(Rect rect, Rect rect2) {
        View b = this.f.b();
        if (rect.isEmpty() || rect2.isEmpty()) {
            b.layout(0, 0, 0, 0);
        } else {
            int centerY = rect.centerY();
            int centerX = rect.centerX();
            int centerY2 = rect2.centerY();
            int height = rect.height();
            int i = this.b;
            int max = Math.max(i + i, height) / 2;
            int i2 = this.c;
            int i3 = centerY + max + i2;
            if (centerY < centerY2) {
                c(b, rect2.width(), rect2.bottom - i3);
                int b2 = b(b, rect2.left, rect2.right, b.getMeasuredWidth(), centerX);
                b.layout(b2, i3, b.getMeasuredWidth() + b2, b.getMeasuredHeight() + i3);
            } else {
                int i4 = (centerY - max) - i2;
                c(b, rect2.width(), i4 - rect2.top);
                int b3 = b(b, rect2.left, rect2.right, b.getMeasuredWidth(), centerX);
                b.layout(b3, i4 - b.getMeasuredHeight(), b.getMeasuredWidth() + b3, i4);
            }
        }
        this.a.set(b.getLeft(), b.getTop(), b.getRight(), b.getBottom());
        this.f.f().f(rect, this.a);
        this.f.d().b(rect);
    }

    public final int b(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        int i5 = i4 - i;
        int i6 = i2 - i4;
        int i7 = i4 - (i3 / 2);
        int i8 = i5 <= i6 ? i7 + this.e : i7 - this.e;
        int i9 = layoutParams.leftMargin;
        if (i8 - i9 < i) {
            return i + i9;
        }
        int i10 = layoutParams.rightMargin;
        return (i8 + i3) + i10 > i2 ? (i2 - i3) - i10 : i8;
    }

    public final void c(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.min((i - layoutParams.leftMargin) - layoutParams.rightMargin, this.d), 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
    }
}
