package k;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class q extends PopupWindow {
    public static final boolean b = false;
    public boolean a;

    public q(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    public final void a(Context context, AttributeSet attributeSet, int i, int i2) {
        d0 v = d0.v(context, attributeSet, c.j.g2, i, i2);
        if (v.s(c.j.i2)) {
            b(v.a(c.j.i2, false));
        }
        setBackgroundDrawable(v.g(c.j.h2));
        v.w();
    }

    public final void b(boolean z) {
        if (b) {
            this.a = z;
        } else {
            T.h.a(this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}
