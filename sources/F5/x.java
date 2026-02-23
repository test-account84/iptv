package f5;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class x extends ImageButton {
    public int a;

    public x(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getVisibility();
    }

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.a;
    }

    public void setVisibility(int i) {
        b(i, true);
    }
}
