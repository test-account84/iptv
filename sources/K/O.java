package k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o {
    public final ImageView a;
    public b0 b;
    public b0 c;
    public b0 d;
    public int e = 0;

    public o(ImageView imageView) {
        this.a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new b0();
        }
        b0 b0Var = this.d;
        b0Var.a();
        ColorStateList a = T.e.a(this.a);
        if (a != null) {
            b0Var.d = true;
            b0Var.a = a;
        }
        PorterDuff.Mode b = T.e.b(this.a);
        if (b != null) {
            b0Var.c = true;
            b0Var.b = b;
        }
        if (!b0Var.d && !b0Var.c) {
            return false;
        }
        i.i(drawable, b0Var, this.a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.a.getDrawable() != null) {
            this.a.getDrawable().setLevel(this.e);
        }
    }

    public void c() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            M.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            b0 b0Var = this.c;
            if (b0Var != null) {
                i.i(drawable, b0Var, this.a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.b;
            if (b0Var2 != null) {
                i.i(drawable, b0Var2, this.a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        b0 b0Var = this.c;
        if (b0Var != null) {
            return b0Var.a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        b0 b0Var = this.c;
        if (b0Var != null) {
            return b0Var.b;
        }
        return null;
    }

    public boolean f() {
        return !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i) {
        int n;
        d0 v = d0.v(this.a.getContext(), attributeSet, c.j.P, i, 0);
        ImageView imageView = this.a;
        P.L.q0(imageView, imageView.getContext(), c.j.P, attributeSet, v.r(), i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (n = v.n(c.j.Q, -1)) != -1 && (drawable = e.a.b(this.a.getContext(), n)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                M.b(drawable);
            }
            if (v.s(c.j.R)) {
                T.e.c(this.a, v.c(c.j.R));
            }
            if (v.s(c.j.S)) {
                T.e.d(this.a, M.e(v.k(c.j.S, -1), null));
            }
            v.w();
        } catch (Throwable th) {
            v.w();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.e = drawable.getLevel();
    }

    public void i(int i) {
        if (i != 0) {
            Drawable b = e.a.b(this.a.getContext(), i);
            if (b != null) {
                M.b(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable((Drawable) null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new b0();
        }
        b0 b0Var = this.c;
        b0Var.a = colorStateList;
        b0Var.d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new b0();
        }
        b0 b0Var = this.c;
        b0Var.b = mode;
        b0Var.c = true;
        c();
    }

    public final boolean l() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }
}
