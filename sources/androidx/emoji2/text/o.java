package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class o extends i {
    public static Paint f;

    public o(g gVar) {
        super(gVar);
    }

    public static Paint c() {
        if (f == null) {
            TextPaint textPaint = new TextPaint();
            f = textPaint;
            textPaint.setColor(e.b().c());
            f.setStyle(Paint.Style.FILL);
        }
        return f;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        if (e.b().i()) {
            canvas.drawRect(f2, i3, f2 + b(), i5, c());
        }
        a().a(canvas, f2, i4, paint);
    }
}
