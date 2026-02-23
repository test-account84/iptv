package P;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class o {
    public final a a;

    public interface a {
        void a(boolean z);

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    public static class b implements a {
        public final GestureDetector a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }

        public void a(boolean z) {
            this.a.setIsLongpressEnabled(z);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public o(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }

    public void b(boolean z) {
        this.a.a(z);
    }

    public o(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.a = new b(context, onGestureListener, handler);
    }
}
