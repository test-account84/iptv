package P;

import android.view.MotionEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class y {
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean b(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
