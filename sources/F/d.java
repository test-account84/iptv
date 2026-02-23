package f;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import c.i;
import c.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends Drawable {
    public static final float m = (float) Math.toRadians(45.0d);
    public final Paint a;
    public float b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public final Path g;
    public final int h;
    public boolean i;
    public float j;
    public float k;
    public int l;

    public d(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        this.g = new Path();
        this.i = false;
        this.l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, j.Z0, c.a.z, i.b);
        d(obtainStyledAttributes.getColor(j.d1, 0));
        c(obtainStyledAttributes.getDimension(j.h1, 0.0f));
        f(obtainStyledAttributes.getBoolean(j.g1, true));
        e(Math.round(obtainStyledAttributes.getDimension(j.f1, 0.0f)));
        this.h = obtainStyledAttributes.getDimensionPixelSize(j.e1, 0);
        this.c = Math.round(obtainStyledAttributes.getDimension(j.c1, 0.0f));
        this.b = Math.round(obtainStyledAttributes.getDimension(j.a1, 0.0f));
        this.d = obtainStyledAttributes.getDimension(j.b1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float b(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public float a() {
        return this.j;
    }

    public void c(float f) {
        if (this.a.getStrokeWidth() != f) {
            this.a.setStrokeWidth(f);
            this.k = (float) ((f / 2.0f) * Math.cos(m));
            invalidateSelf();
        }
    }

    public void d(int i) {
        if (i != this.a.getColor()) {
            this.a.setColor(i);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.l;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? H.a.f(this) == 0 : H.a.f(this) == 1))) {
            z = true;
        }
        float f = this.b;
        float b = b(this.c, (float) Math.sqrt(f * f * 2.0f), this.j);
        float b2 = b(this.c, this.d, this.j);
        float round = Math.round(b(0.0f, this.k, this.j));
        float b3 = b(0.0f, m, this.j);
        float b4 = b(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.j);
        double d = b;
        double d2 = b3;
        boolean z2 = z;
        float round2 = Math.round(Math.cos(d2) * d);
        float round3 = Math.round(d * Math.sin(d2));
        this.g.rewind();
        float b5 = b(this.e + this.a.getStrokeWidth(), -this.k, this.j);
        float f2 = (-b2) / 2.0f;
        this.g.moveTo(f2 + round, 0.0f);
        this.g.rLineTo(b2 - (round * 2.0f), 0.0f);
        this.g.moveTo(f2, b5);
        this.g.rLineTo(round2, round3);
        this.g.moveTo(f2, -b5);
        this.g.rLineTo(round2, -round3);
        this.g.close();
        canvas.save();
        float strokeWidth = this.a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.e);
        if (this.f) {
            canvas.rotate(b4 * (this.i ^ z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.g, this.a);
        canvas.restore();
    }

    public void e(float f) {
        if (f != this.e) {
            this.e = f;
            invalidateSelf();
        }
    }

    public void f(boolean z) {
        if (this.f != z) {
            this.f = z;
            invalidateSelf();
        }
    }

    public int getIntrinsicHeight() {
        return this.h;
    }

    public int getIntrinsicWidth() {
        return this.h;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        if (i != this.a.getAlpha()) {
            this.a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f) {
        if (this.j != f) {
            this.j = f;
            invalidateSelf();
        }
    }
}
