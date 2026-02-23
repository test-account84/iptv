package d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import i.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {

    public static class a extends ViewGroup.MarginLayoutParams {
        public int a;

        public a(int i, int i2) {
            super(i, i2);
            this.a = 8388627;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.j.t);
            this.a = obtainStyledAttributes.getInt(c.j.u, 0);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public a(a aVar) {
            super(aVar);
            this.a = 0;
            this.a = aVar.a;
        }
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z);

    public abstract int j();

    public abstract Context k();

    public abstract void l();

    public boolean m() {
        return false;
    }

    public abstract boolean p(int i, KeyEvent keyEvent);

    public boolean q(KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public abstract void s(boolean z);

    public abstract void t(boolean z);

    public abstract void u(int i);

    public abstract void v(boolean z);

    public abstract void w(CharSequence charSequence);

    public abstract void x(CharSequence charSequence);

    public abstract void y(CharSequence charSequence);

    public i.b z(b.a aVar) {
        return null;
    }

    public void n(Configuration configuration) {
    }

    public void o() {
    }
}
