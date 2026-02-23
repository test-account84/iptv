package c5;

import android.content.Context;
import android.graphics.Color;
import i5.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public static final int f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public a(Context context) {
        this(b.b(context, R4.b.q, false), Z4.a.b(context, R4.b.p, 0), Z4.a.b(context, R4.b.o, 0), Z4.a.b(context, R4.b.m, 0), context.getResources().getDisplayMetrics().density);
    }

    public float a(float f2) {
        if (this.e <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f2) {
        int i2;
        float a = a(f2);
        int alpha = Color.alpha(i);
        int h = Z4.a.h(G.a.o(i, 255), this.b, a);
        if (a > 0.0f && (i2 = this.c) != 0) {
            h = Z4.a.g(h, G.a.o(i2, f));
        }
        return G.a.o(h, alpha);
    }

    public int c(int i, float f2) {
        return (this.a && e(i)) ? b(i, f2) : i;
    }

    public boolean d() {
        return this.a;
    }

    public final boolean e(int i) {
        return G.a.o(i, 255) == this.d;
    }

    public a(boolean z, int i, int i2, int i3, float f2) {
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f2;
    }
}
