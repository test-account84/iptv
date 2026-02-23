package me.zhanghai.android.materialprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class BaseSingleCircularProgressDrawable extends BaseProgressDrawable {
    private static final RectF RECT_BOUND = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-24.0f, -24.0f, 24.0f, 24.0f);
    private static final RectF RECT_PROGRESS = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);

    public void drawRing(Canvas canvas, Paint paint, float f, float f2) {
        canvas.drawArc(RECT_PROGRESS, f - 90.0f, f2, false, paint);
    }

    public void onDraw(Canvas canvas, int i, int i2, Paint paint) {
        float f = i;
        RectF rectF = this.mUseIntrinsicPadding ? RECT_PADDED_BOUND : RECT_BOUND;
        canvas.scale(f / rectF.width(), i2 / rectF.height());
        canvas.translate(rectF.width() / 2.0f, rectF.height() / 2.0f);
        onDrawRing(canvas, paint);
    }

    public abstract void onDrawRing(Canvas canvas, Paint paint);

    public void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
    }
}
