package h0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import g0.b;
import g0.e;
import g0.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public final float a;
    public final float b;
    public final Paint c;
    public int d;
    public float e;

    public a(int i, float f, float f2) {
        f = f > 1.0f ? 1.0f : f;
        f = f < 0.0f ? 0.0f : f;
        f2 = f2 > 1.0f ? 1.0f : f2;
        float f3 = f2 >= 0.0f ? f2 : 0.0f;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.a = f;
        this.b = f3;
        c(1.0f);
    }

    public static a a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(l.k);
        int color = obtainStyledAttributes.getColor(l.o, context.getResources().getColor(b.n));
        float fraction = obtainStyledAttributes.getFraction(l.m, 1, 1, context.getResources().getFraction(e.h, 1, 0));
        float fraction2 = obtainStyledAttributes.getFraction(l.n, 1, 1, context.getResources().getFraction(e.i, 1, 1));
        obtainStyledAttributes.recycle();
        return new a(color, fraction, fraction2);
    }

    public Paint b() {
        return this.c;
    }

    public void c(float f) {
        float f2 = this.b;
        float f3 = f2 + (f * (this.a - f2));
        this.e = f3;
        int i = (int) (f3 * 255.0f);
        this.d = i;
        this.c.setAlpha(i);
    }
}
