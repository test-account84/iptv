package androidx.leanback.preference.internal;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class OutlineOnlyWithChildrenFrameLayout extends FrameLayout {
    public ViewOutlineProvider a;
    public ViewOutlineProvider c;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public void getOutline(View view, Outline outline) {
            (OutlineOnlyWithChildrenFrameLayout.this.getChildCount() > 0 ? OutlineOnlyWithChildrenFrameLayout.this.c : ViewOutlineProvider.BACKGROUND).getOutline(view, outline);
        }
    }

    public OutlineOnlyWithChildrenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        invalidateOutline();
    }

    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
        this.c = viewOutlineProvider;
        if (this.a == null) {
            this.a = new a();
        }
        super.setOutlineProvider(this.a);
    }
}
