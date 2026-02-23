package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class GuidedActionsRelativeLayout extends RelativeLayout {
    public float a;
    public boolean c;

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = false;
    }

    public void onMeasure(int i, int i2) {
        View findViewById;
        int size = View.MeasureSpec.getSize(i2);
        if (size > 0 && (findViewById = findViewById(g0.f.i)) != null) {
            ViewGroup.MarginLayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams.topMargin < 0 && !this.c) {
                this.c = true;
            }
            if (this.c) {
                layoutParams.topMargin = (int) ((this.a * size) / 100.0f);
            }
        }
        super.onMeasure(i, i2);
    }

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.a = GuidanceStylingRelativeLayout.a(context);
    }
}
