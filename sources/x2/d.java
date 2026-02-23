package x2;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d extends e {
    public void J(Canvas canvas, Paint paint) {
        if (d() != null) {
            paint.setStyle(Paint.Style.STROKE);
            int min = Math.min(d().width(), d().height()) / 2;
            paint.setStrokeWidth(min / 12);
            canvas.drawCircle(d().centerX(), d().centerY(), min, paint);
        }
    }
}
