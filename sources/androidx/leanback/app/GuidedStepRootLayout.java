package androidx.leanback.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.leanback.widget.a0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class GuidedStepRootLayout extends LinearLayout {
    public boolean a;
    public boolean c;

    public GuidedStepRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.c = false;
    }

    public View focusSearch(View view, int i) {
        View focusSearch = super.focusSearch(view, i);
        if ((i != 17 && i != 66) || a0.a(this, focusSearch)) {
            return focusSearch;
        }
        if (getLayoutDirection() != 0 ? i != 66 : i != 17) {
            if (!this.c) {
                return view;
            }
        } else if (!this.a) {
            return view;
        }
        return focusSearch;
    }
}
