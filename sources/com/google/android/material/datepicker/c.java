package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final Paint h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5.b.d(context, R4.b.v, i.class.getCanonicalName()), R4.l.j3);
        this.a = b.a(context, obtainStyledAttributes.getResourceId(R4.l.m3, 0));
        this.g = b.a(context, obtainStyledAttributes.getResourceId(R4.l.k3, 0));
        this.b = b.a(context, obtainStyledAttributes.getResourceId(R4.l.l3, 0));
        this.c = b.a(context, obtainStyledAttributes.getResourceId(R4.l.n3, 0));
        ColorStateList a = i5.c.a(context, obtainStyledAttributes, R4.l.o3);
        this.d = b.a(context, obtainStyledAttributes.getResourceId(R4.l.q3, 0));
        this.e = b.a(context, obtainStyledAttributes.getResourceId(R4.l.p3, 0));
        this.f = b.a(context, obtainStyledAttributes.getResourceId(R4.l.r3, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(a.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
