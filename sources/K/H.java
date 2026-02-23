package k;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h {
    public final CompoundButton a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public h(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public void a() {
        Drawable a = T.c.a(this.a);
        if (a != null) {
            if (this.d || this.e) {
                Drawable mutate = H.a.r(a).mutate();
                if (this.d) {
                    H.a.o(mutate, this.b);
                }
                if (this.e) {
                    H.a.p(mutate, this.c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(mutate);
            }
        }
    }

    public ColorStateList c() {
        return this.b;
    }

    public PorterDuff.Mode d() {
        return this.c;
    }

    public void e(AttributeSet attributeSet, int i) {
        int n;
        int n2;
        d0 v = d0.v(this.a.getContext(), attributeSet, c.j.U0, i, 0);
        CompoundButton compoundButton = this.a;
        P.L.q0(compoundButton, compoundButton.getContext(), c.j.U0, attributeSet, v.r(), i, 0);
        try {
            if (v.s(c.j.W0) && (n2 = v.n(c.j.W0, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(e.a.b(compoundButton2.getContext(), n2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (v.s(c.j.V0) && (n = v.n(c.j.V0, 0)) != 0) {
                CompoundButton compoundButton3 = this.a;
                compoundButton3.setButtonDrawable(e.a.b(compoundButton3.getContext(), n));
            }
            if (v.s(c.j.X0)) {
                T.c.c(this.a, v.c(c.j.X0));
            }
            if (v.s(c.j.Y0)) {
                T.c.d(this.a, M.e(v.k(c.j.Y0, -1), null));
            }
        } finally {
            v.w();
        }
    }

    public void f() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    public void g(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    public void h(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }

    public int b(int i) {
        return i;
    }
}
