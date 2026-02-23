package i5;

import F.h;
import R4.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d {
    public final ColorStateList a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final boolean k;
    public final float l;
    public ColorStateList m;
    public float n;
    public final int o;
    public boolean p = false;
    public Typeface q;

    public class a extends h.e {
        public final /* synthetic */ f a;

        public a(f fVar) {
            this.a = fVar;
        }

        public void h(int i) {
            d.c(d.this, true);
            this.a.a(i);
        }

        public void i(Typeface typeface) {
            d dVar = d.this;
            d.b(dVar, Typeface.create(typeface, dVar.e));
            d.c(d.this, true);
            this.a.b(d.a(d.this), false);
        }
    }

    public class b extends f {
        public final /* synthetic */ Context a;
        public final /* synthetic */ TextPaint b;
        public final /* synthetic */ f c;

        public b(Context context, TextPaint textPaint, f fVar) {
            this.a = context;
            this.b = textPaint;
            this.c = fVar;
        }

        public void a(int i) {
            this.c.a(i);
        }

        public void b(Typeface typeface, boolean z) {
            d.this.p(this.a, this.b, typeface);
            this.c.b(typeface, z);
        }
    }

    public d(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, l.L5);
        l(obtainStyledAttributes.getDimension(l.M5, 0.0f));
        k(c.a(context, obtainStyledAttributes, l.P5));
        this.a = c.a(context, obtainStyledAttributes, l.Q5);
        this.b = c.a(context, obtainStyledAttributes, l.R5);
        this.e = obtainStyledAttributes.getInt(l.O5, 0);
        this.f = obtainStyledAttributes.getInt(l.N5, 1);
        int e = c.e(obtainStyledAttributes, l.X5, l.W5);
        this.o = obtainStyledAttributes.getResourceId(e, 0);
        this.d = obtainStyledAttributes.getString(e);
        this.g = obtainStyledAttributes.getBoolean(l.Y5, false);
        this.c = c.a(context, obtainStyledAttributes, l.S5);
        this.h = obtainStyledAttributes.getFloat(l.T5, 0.0f);
        this.i = obtainStyledAttributes.getFloat(l.U5, 0.0f);
        this.j = obtainStyledAttributes.getFloat(l.V5, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, l.P3);
        this.k = obtainStyledAttributes2.hasValue(l.Q3);
        this.l = obtainStyledAttributes2.getFloat(l.Q3, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public static /* synthetic */ Typeface a(d dVar) {
        return dVar.q;
    }

    public static /* synthetic */ Typeface b(d dVar, Typeface typeface) {
        dVar.q = typeface;
        return typeface;
    }

    public static /* synthetic */ boolean c(d dVar, boolean z) {
        dVar.p = z;
        return z;
    }

    public final void d() {
        String str;
        if (this.q == null && (str = this.d) != null) {
            this.q = Typeface.create(str, this.e);
        }
        if (this.q == null) {
            int i = this.f;
            this.q = i != 1 ? i != 2 ? i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.q = Typeface.create(this.q, this.e);
        }
    }

    public Typeface e() {
        d();
        return this.q;
    }

    public Typeface f(Context context) {
        if (this.p) {
            return this.q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface h = F.h.h(context, this.o);
                this.q = h;
                if (h != null) {
                    this.q = Typeface.create(h, this.e);
                }
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.d, e);
            } catch (UnsupportedOperationException | Resources.NotFoundException unused) {
            }
        }
        d();
        this.p = true;
        return this.q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i = this.o;
        if (i == 0) {
            this.p = true;
        }
        if (this.p) {
            fVar.b(this.q, true);
            return;
        }
        try {
            F.h.j(context, i, new a(fVar), (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.p = true;
            fVar.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.d, e);
            this.p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.m;
    }

    public float j() {
        return this.n;
    }

    public void k(ColorStateList colorStateList) {
        this.m = colorStateList;
    }

    public void l(float f) {
        this.n = f;
    }

    public final boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i = this.o;
        return (i != 0 ? F.h.c(context, i) : null) != null;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.j;
        float f2 = this.h;
        float f3 = this.i;
        ColorStateList colorStateList2 = this.c;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface a2 = j.a(context, typeface);
        if (a2 != null) {
            typeface = a2;
        }
        textPaint.setTypeface(typeface);
        int i = this.e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.n);
        if (this.k) {
            textPaint.setLetterSpacing(this.l);
        }
    }
}
