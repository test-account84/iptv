package f4;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import f4.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, d.a {
    public final a d;
    public final float e;
    public final GestureDetector f;
    public final PointF a = new PointF();
    public final PointF c = new PointF();
    public volatile float g = 3.1415927f;

    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public m(Context context, a aVar, float f) {
        this.d = aVar;
        this.e = f;
        this.f = new GestureDetector(context, this);
    }

    public void a(float[] fArr, float f) {
        this.g = -f;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = (motionEvent2.getX() - this.a.x) / this.e;
        float y = motionEvent2.getY();
        PointF pointF = this.a;
        float f3 = (y - pointF.y) / this.e;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.g;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        PointF pointF2 = this.c;
        pointF2.x -= (cos * x) - (sin * f3);
        float f4 = pointF2.y + (sin * x) + (cos * f3);
        pointF2.y = f4;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f4));
        this.d.b(this.c);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.d.onSingleTapUp(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f.onTouchEvent(motionEvent);
    }
}
