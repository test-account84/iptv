package x2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e extends f {
    public Paint F;
    public int G;
    public int H;

    public e() {
        u(-1);
        Paint paint = new Paint();
        this.F = paint;
        paint.setAntiAlias(true);
        this.F.setColor(this.G);
    }

    public abstract void J(Canvas canvas, Paint paint);

    public final void K() {
        int alpha = getAlpha();
        int i = this.H;
        this.G = ((((i >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | ((i << 8) >>> 8);
    }

    public final void b(Canvas canvas) {
        this.F.setColor(this.G);
        J(canvas, this.F);
    }

    public int c() {
        return this.H;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        K();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.F.setColorFilter(colorFilter);
    }

    public void u(int i) {
        this.H = i;
        K();
    }
}
