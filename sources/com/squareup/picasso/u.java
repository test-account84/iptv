package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class u extends BitmapDrawable {
    public static final Paint h = new Paint();
    public final boolean a;
    public final float b;
    public final t.e c;
    public Drawable d;
    public long e;
    public boolean f;
    public int g;

    public u(Context context, Bitmap bitmap, Drawable drawable, t.e eVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.g = 255;
        this.a = z2;
        this.b = context.getResources().getDisplayMetrics().density;
        this.c = eVar;
        if (eVar == t.e.MEMORY || z) {
            return;
        }
        this.d = drawable;
        this.f = true;
        this.e = SystemClock.uptimeMillis();
    }

    public static Path b(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }

    public static void c(ImageView imageView, Context context, Bitmap bitmap, t.e eVar, boolean z, boolean z2) {
        AnimationDrawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            drawable.stop();
        }
        imageView.setImageDrawable(new u(context, bitmap, drawable, eVar, z, z2));
    }

    public static void d(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            imageView.getDrawable().start();
        }
    }

    public final void a(Canvas canvas) {
        Paint paint = h;
        paint.setColor(-1);
        canvas.drawPath(b(new Point(0, 0), (int) (this.b * 16.0f)), paint);
        paint.setColor(this.c.debugColor);
        canvas.drawPath(b(new Point(0, 0), (int) (this.b * 15.0f)), paint);
    }

    public void draw(Canvas canvas) {
        if (this.f) {
            float uptimeMillis = (SystemClock.uptimeMillis() - this.e) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f = false;
                this.d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.g * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.g);
            }
        } else {
            super.draw(canvas);
        }
        if (this.a) {
            a(canvas);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i) {
        this.g = i;
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
