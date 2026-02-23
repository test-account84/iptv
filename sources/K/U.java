package k;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class u extends SeekBar {
    public final v a;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.L);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.h();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.i();
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.g(canvas);
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Z.a(this, getContext());
        v vVar = new v(this);
        this.a = vVar;
        vVar.c(attributeSet, i);
    }
}
