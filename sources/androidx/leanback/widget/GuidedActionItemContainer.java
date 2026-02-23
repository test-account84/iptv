package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class GuidedActionItemContainer extends x {
    public boolean e;

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View focusSearch(View view, int i) {
        if (this.e || !a0.a(this, view)) {
            return super.focusSearch(view, i);
        }
        View focusSearch = super.focusSearch(view, i);
        if (a0.a(this, focusSearch)) {
            return focusSearch;
        }
        return null;
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
    }
}
