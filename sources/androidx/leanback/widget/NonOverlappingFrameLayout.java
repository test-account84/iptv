package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class NonOverlappingFrameLayout extends FrameLayout {
    public NonOverlappingFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }
}
