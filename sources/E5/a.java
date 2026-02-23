package e5;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import l5.k;
import l5.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends Drawable {
    public final Paint b;
    public float h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public k o;
    public ColorStateList p;
    public final l a = l.k();
    public final Path c = new Path();
    public final Rect d = new Rect();
    public final RectF e = new RectF();
    public final RectF f = new RectF();
    public final b g = new b(this, null);
    public boolean n = true;

    public class b extends Drawable.ConstantState {
        public b() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return a.this;
        }

        public /* synthetic */ b(a aVar, a aVar2) {
            this();
        }
    }

    public a(k kVar) {
        this.o = kVar;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public final Shader a() {
        copyBounds(this.d);
        float height = this.h / r1.height();
        return new LinearGradient(0.0f, r1.top, 0.0f, r1.bottom, new int[]{G.a.j(this.i, this.m), G.a.j(this.j, this.m), G.a.j(G.a.o(this.j, 0), this.m), G.a.j(G.a.o(this.l, 0), this.m), G.a.j(this.l, this.m), G.a.j(this.k, this.m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    public RectF b() {
        this.f.set(getBounds());
        return this.f;
    }

    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    public void d(float f) {
        if (this.h != f) {
            this.h = f;
            this.b.setStrokeWidth(f * 1.3333f);
            this.n = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.n) {
            this.b.setShader(a());
            this.n = false;
        }
        float strokeWidth = this.b.getStrokeWidth() / 2.0f;
        copyBounds(this.d);
        this.e.set(this.d);
        float min = Math.min(this.o.r().a(b()), this.e.width() / 2.0f);
        if (this.o.u(b())) {
            this.e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.e, min, min, this.b);
        }
    }

    public void e(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    public void f(k kVar) {
        this.o = kVar;
        invalidateSelf();
    }

    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    public int getOpacity() {
        return this.h > 0.0f ? -3 : -2;
    }

    public void getOutline(Outline outline) {
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
            return;
        }
        copyBounds(this.d);
        this.e.set(this.d);
        this.a.d(this.o, 1.0f, this.e, this.c);
        if (this.c.isConvex()) {
            outline.setConvexPath(this.c);
        }
    }

    public boolean getPadding(Rect rect) {
        if (!this.o.u(b())) {
            return true;
        }
        int round = Math.round(this.h);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public void onBoundsChange(Rect rect) {
        this.n = true;
    }

    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.m)) != this.m) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    public void setAlpha(int i) {
        this.b.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
