package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class CheckableImageView extends ImageView implements Checkable {
    public static final int[] c = {16842912};
    public boolean a;

    public CheckableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean isChecked() {
        return this.a;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, c);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        if (this.a != z) {
            this.a = z;
            refreshDrawableState();
        }
    }

    public void toggle() {
        setChecked(!this.a);
    }

    public CheckableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
