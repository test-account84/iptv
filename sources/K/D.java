package k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d {
    public final View a;
    public b0 d;
    public b0 e;
    public b0 f;
    public int c = -1;
    public final i b = i.b();

    public d(View view) {
        this.a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new b0();
        }
        b0 b0Var = this.f;
        b0Var.a();
        ColorStateList u = P.L.u(this.a);
        if (u != null) {
            b0Var.d = true;
            b0Var.a = u;
        }
        PorterDuff.Mode v = P.L.v(this.a);
        if (v != null) {
            b0Var.c = true;
            b0Var.b = v;
        }
        if (!b0Var.d && !b0Var.c) {
            return false;
        }
        i.i(drawable, b0Var, this.a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            b0 b0Var = this.e;
            if (b0Var != null) {
                i.i(background, b0Var, this.a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.d;
            if (b0Var2 != null) {
                i.i(background, b0Var2, this.a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        b0 b0Var = this.e;
        if (b0Var != null) {
            return b0Var.a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        b0 b0Var = this.e;
        if (b0Var != null) {
            return b0Var.b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i) {
        d0 v = d0.v(this.a.getContext(), attributeSet, c.j.U3, i, 0);
        View view = this.a;
        P.L.q0(view, view.getContext(), c.j.U3, attributeSet, v.r(), i, 0);
        try {
            if (v.s(c.j.V3)) {
                this.c = v.n(c.j.V3, -1);
                ColorStateList f = this.b.f(this.a.getContext(), this.c);
                if (f != null) {
                    h(f);
                }
            }
            if (v.s(c.j.W3)) {
                P.L.x0(this.a, v.c(c.j.W3));
            }
            if (v.s(c.j.X3)) {
                P.L.y0(this.a, M.e(v.k(c.j.X3, -1), null));
            }
            v.w();
        } catch (Throwable th) {
            v.w();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.c = -1;
        h(null);
        b();
    }

    public void g(int i) {
        this.c = i;
        i iVar = this.b;
        h(iVar != null ? iVar.f(this.a.getContext(), i) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new b0();
            }
            b0 b0Var = this.d;
            b0Var.a = colorStateList;
            b0Var.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new b0();
        }
        b0 b0Var = this.e;
        b0Var.a = colorStateList;
        b0Var.d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new b0();
        }
        b0 b0Var = this.e;
        b0Var.b = mode;
        b0Var.c = true;
        b();
    }

    public final boolean k() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }
}
