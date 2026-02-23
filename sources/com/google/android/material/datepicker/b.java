package com.google.android.material.datepicker;

import P.L;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public final Rect a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;
    public final l5.k f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, l5.k kVar, Rect rect) {
        O.h.c(rect.left);
        O.h.c(rect.top);
        O.h.c(rect.right);
        O.h.c(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.d = colorStateList3;
        this.e = i;
        this.f = kVar;
    }

    public static b a(Context context, int i) {
        O.h.a(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R4.l.s3);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R4.l.t3, 0), obtainStyledAttributes.getDimensionPixelOffset(R4.l.v3, 0), obtainStyledAttributes.getDimensionPixelOffset(R4.l.u3, 0), obtainStyledAttributes.getDimensionPixelOffset(R4.l.w3, 0));
        ColorStateList a = i5.c.a(context, obtainStyledAttributes, R4.l.x3);
        ColorStateList a2 = i5.c.a(context, obtainStyledAttributes, R4.l.C3);
        ColorStateList a3 = i5.c.a(context, obtainStyledAttributes, R4.l.A3);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R4.l.B3, 0);
        l5.k m = l5.k.b(context, obtainStyledAttributes.getResourceId(R4.l.y3, 0), obtainStyledAttributes.getResourceId(R4.l.z3, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a, a2, a3, dimensionPixelSize, m, rect);
    }

    public void b(TextView textView) {
        l5.g gVar = new l5.g();
        l5.g gVar2 = new l5.g();
        gVar.setShapeAppearanceModel(this.f);
        gVar2.setShapeAppearanceModel(this.f);
        gVar.W(this.c);
        gVar.b0(this.e, this.d);
        textView.setTextColor(this.b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.b.withAlpha(30), gVar, gVar2);
        Rect rect = this.a;
        L.w0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
