package androidx.appcompat.widget;

import P.L;
import P.S;
import P.U;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import c.e;
import c.f;
import c.h;
import c.j;
import k.H;
import k.d0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements H {
    public Toolbar a;
    public int b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public androidx.appcompat.widget.a n;
    public int o;
    public int p;
    public Drawable q;

    public class a implements View.OnClickListener {
        public final j.a a;

        public a() {
            this.a = new j.a(d.this.a.getContext(), 0, 16908332, 0, 0, d.this.i);
        }

        public void onClick(View view) {
            d dVar = d.this;
            Window.Callback callback = dVar.l;
            if (callback == null || !dVar.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.a);
        }
    }

    public class b extends U {
        public boolean a = false;
        public final /* synthetic */ int b;

        public b(int i) {
            this.b = i;
        }

        public void a(View view) {
            this.a = true;
        }

        public void b(View view) {
            if (this.a) {
                return;
            }
            d.this.a.setVisibility(this.b);
        }

        public void c(View view) {
            d.this.a.setVisibility(0);
        }
    }

    public d(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.a, e.n);
    }

    public void A(View view) {
        View view2 = this.d;
        if (view2 != null && (this.b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.d = view;
        if (view == null || (this.b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public void B(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            D(this.p);
        }
    }

    public void C(Drawable drawable) {
        this.f = drawable;
        J();
    }

    public void D(int i) {
        E(i == 0 ? null : getContext().getString(i));
    }

    public void E(CharSequence charSequence) {
        this.k = charSequence;
        H();
    }

    public void F(Drawable drawable) {
        this.g = drawable;
        I();
    }

    public final void G(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
            if (this.h) {
                L.v0(this.a.getRootView(), charSequence);
            }
        }
    }

    public final void H() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    public final void I() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.b & 4) != 0) {
            toolbar = this.a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void J() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.a.setLogo(drawable);
    }

    public boolean a() {
        return this.a.d();
    }

    public boolean b() {
        return this.a.w();
    }

    public boolean c() {
        return this.a.Q();
    }

    public void collapseActionView() {
        this.a.e();
    }

    public void d(Menu menu, i.a aVar) {
        if (this.n == null) {
            androidx.appcompat.widget.a aVar2 = new androidx.appcompat.widget.a(this.a.getContext());
            this.n = aVar2;
            aVar2.p(f.g);
        }
        this.n.d(aVar);
        this.a.K((androidx.appcompat.view.menu.e) menu, this.n);
    }

    public boolean e() {
        return this.a.B();
    }

    public void f() {
        this.m = true;
    }

    public boolean g() {
        return this.a.A();
    }

    public Context getContext() {
        return this.a.getContext();
    }

    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    public boolean h() {
        return this.a.v();
    }

    public void i(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i2 & 3) != 0) {
                J();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.i);
                    toolbar = this.a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.a.setTitle((CharSequence) null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    public void j(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public Menu k() {
        return this.a.getMenu();
    }

    public int l() {
        return this.o;
    }

    public S m(int i, long j) {
        return L.e(this.a).b(i == 0 ? 1.0f : 0.0f).h(j).j(new b(i));
    }

    public ViewGroup n() {
        return this.a;
    }

    public void o(boolean z) {
    }

    public void p() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void q(boolean z) {
        this.a.setCollapsible(z);
    }

    public void r() {
        this.a.f();
    }

    public void s(c cVar) {
        View view = this.c;
        if (view != null) {
            Toolbar parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = cVar;
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? e.a.b(getContext(), i) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.h = true;
        G(charSequence);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        G(charSequence);
    }

    public void t(int i) {
        C(i != 0 ? e.a.b(getContext(), i) : null);
    }

    public void u(int i) {
        F(i != 0 ? e.a.b(getContext(), i) : null);
    }

    public void v(i.a aVar, e.a aVar2) {
        this.a.L(aVar, aVar2);
    }

    public void w(int i) {
        this.a.setVisibility(i);
    }

    public int x() {
        return this.b;
    }

    public void y() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final int z() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    public d(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        d0 v = d0.v(toolbar.getContext(), null, j.a, c.a.c, 0);
        this.q = v.g(j.l);
        if (z) {
            CharSequence p = v.p(j.r);
            if (!TextUtils.isEmpty(p)) {
                setTitle(p);
            }
            CharSequence p2 = v.p(j.p);
            if (!TextUtils.isEmpty(p2)) {
                j(p2);
            }
            Drawable g = v.g(j.n);
            if (g != null) {
                C(g);
            }
            Drawable g2 = v.g(j.m);
            if (g2 != null) {
                setIcon(g2);
            }
            if (this.g == null && (drawable = this.q) != null) {
                F(drawable);
            }
            i(v.k(j.h, 0));
            int n = v.n(j.g, 0);
            if (n != 0) {
                A(LayoutInflater.from(this.a.getContext()).inflate(n, this.a, false));
                i(this.b | 16);
            }
            int m = v.m(j.j, 0);
            if (m > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = m;
                this.a.setLayoutParams(layoutParams);
            }
            int e = v.e(j.f, -1);
            int e2 = v.e(j.e, -1);
            if (e >= 0 || e2 >= 0) {
                this.a.J(Math.max(e, 0), Math.max(e2, 0));
            }
            int n2 = v.n(j.s, 0);
            if (n2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.N(toolbar2.getContext(), n2);
            }
            int n3 = v.n(j.q, 0);
            if (n3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.M(toolbar3.getContext(), n3);
            }
            int n4 = v.n(j.o, 0);
            if (n4 != 0) {
                this.a.setPopupTheme(n4);
            }
        } else {
            this.b = z();
        }
        v.w();
        B(i);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    public void setIcon(Drawable drawable) {
        this.e = drawable;
        J();
    }
}
