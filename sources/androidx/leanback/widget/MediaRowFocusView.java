package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class MediaRowFocusView extends View {
    public final Paint a;
    public final RectF c;
    public int d;

    public MediaRowFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new RectF();
        this.a = a(context);
    }

    public final Paint a(Context context) {
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(g0.b.e));
        return paint;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        this.d = height;
        int height2 = ((height * 2) - getHeight()) / 2;
        this.c.set(0.0f, -height2, getWidth(), getHeight() + height2);
        RectF rectF = this.c;
        int i = this.d;
        canvas.drawRoundRect(rectF, i, i, this.a);
    }
}
