package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class GuidanceStylingRelativeLayout extends RelativeLayout {
    public float a;

    public GuidanceStylingRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static float a(Context context) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(g0.l.h);
        float f = obtainStyledAttributes.getFloat(g0.l.i, 40.0f);
        obtainStyledAttributes.recycle();
        return f;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View findViewById = getRootView().findViewById(g0.f.h);
        View findViewById2 = getRootView().findViewById(g0.f.e);
        View findViewById3 = getRootView().findViewById(g0.f.f);
        ImageView findViewById4 = getRootView().findViewById(g0.f.g);
        int measuredHeight = (int) ((getMeasuredHeight() * this.a) / 100.0f);
        if (findViewById != null && findViewById.getParent() == this) {
            int baseline = (((measuredHeight - findViewById.getBaseline()) - findViewById2.getMeasuredHeight()) - findViewById.getPaddingTop()) - findViewById2.getTop();
            if (findViewById2.getParent() == this) {
                findViewById2.offsetTopAndBottom(baseline);
            }
            findViewById.offsetTopAndBottom(baseline);
            if (findViewById3 != null && findViewById3.getParent() == this) {
                findViewById3.offsetTopAndBottom(baseline);
            }
        }
        if (findViewById4 == null || findViewById4.getParent() != this || findViewById4.getDrawable() == null) {
            return;
        }
        findViewById4.offsetTopAndBottom(measuredHeight - (findViewById4.getMeasuredHeight() / 2));
    }

    public GuidanceStylingRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = a(context);
    }
}
