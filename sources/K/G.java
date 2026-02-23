package k;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g {
    public final CheckedTextView a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public g(CheckedTextView checkedTextView) {
        this.a = checkedTextView;
    }

    public void a() {
        Drawable a = T.b.a(this.a);
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
                this.a.setCheckMarkDrawable(mutate);
            }
        }
    }

    public ColorStateList b() {
        return this.b;
    }

    public PorterDuff.Mode c() {
        return this.c;
    }

    public void d(AttributeSet attributeSet, int i) {
        int n;
        int n2;
        d0 v = d0.v(this.a.getContext(), attributeSet, c.j.P0, i, 0);
        CheckedTextView checkedTextView = this.a;
        P.L.q0(checkedTextView, checkedTextView.getContext(), c.j.P0, attributeSet, v.r(), i, 0);
        try {
            if (v.s(c.j.R0) && (n2 = v.n(c.j.R0, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.a;
                    checkedTextView2.setCheckMarkDrawable(e.a.b(checkedTextView2.getContext(), n2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (v.s(c.j.Q0) && (n = v.n(c.j.Q0, 0)) != 0) {
                CheckedTextView checkedTextView3 = this.a;
                checkedTextView3.setCheckMarkDrawable(e.a.b(checkedTextView3.getContext(), n));
            }
            if (v.s(c.j.S0)) {
                T.b.b(this.a, v.c(c.j.S0));
            }
            if (v.s(c.j.T0)) {
                T.b.c(this.a, M.e(v.k(c.j.T0, -1), null));
            }
        } finally {
            v.w();
        }
    }

    public void e() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }
}
