package androidx.appcompat.view.menu;

import P.L;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import k.T;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class k extends j.d implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, i, View.OnKeyListener {
    public static final int w = c.g.m;
    public final Context c;
    public final e d;
    public final d e;
    public final boolean f;
    public final int g;
    public final int h;
    public final int i;
    public final T j;
    public PopupWindow.OnDismissListener m;
    public View n;
    public View o;
    public i.a p;
    public ViewTreeObserver q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean v;
    public final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    public final View.OnAttachStateChangeListener l = new b();
    public int u = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (!k.this.a() || k.this.j.A()) {
                return;
            }
            View view = k.this.o;
            if (view == null || !view.isShown()) {
                k.this.dismiss();
            } else {
                k.this.j.show();
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = k.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    k.this.q = view.getViewTreeObserver();
                }
                k kVar = k.this;
                kVar.q.removeGlobalOnLayoutListener(kVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public k(Context context, e eVar, View view, int i, int i2, boolean z) {
        this.c = context;
        this.d = eVar;
        this.f = z;
        this.e = new d(eVar, LayoutInflater.from(context), z, w);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c.d.b));
        this.n = view;
        this.j = new T(context, null, i, i2);
        eVar.c(this, context);
    }

    public boolean a() {
        return !this.r && this.j.a();
    }

    public void b(e eVar, boolean z) {
        if (eVar != this.d) {
            return;
        }
        dismiss();
        i.a aVar = this.p;
        if (aVar != null) {
            aVar.b(eVar, z);
        }
    }

    public void d(i.a aVar) {
        this.p = aVar;
    }

    public void dismiss() {
        if (a()) {
            this.j.dismiss();
        }
    }

    public boolean e(l lVar) {
        if (lVar.hasVisibleItems()) {
            h hVar = new h(this.c, lVar, this.o, this.f, this.h, this.i);
            hVar.j(this.p);
            hVar.g(j.d.w(lVar));
            hVar.i(this.m);
            this.m = null;
            this.d.e(false);
            int c = this.j.c();
            int l = this.j.l();
            if ((Gravity.getAbsoluteGravity(this.u, L.E(this.n)) & 7) == 5) {
                c += this.n.getWidth();
            }
            if (hVar.n(c, l)) {
                i.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.c(lVar);
                return true;
            }
        }
        return false;
    }

    public void f(boolean z) {
        this.s = false;
        d dVar = this.e;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    public boolean g() {
        return false;
    }

    public void j(e eVar) {
    }

    public void n(View view) {
        this.n = view;
    }

    public ListView o() {
        return this.j.o();
    }

    public void onDismiss() {
        this.r = true;
        this.d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void q(boolean z) {
        this.e.d(z);
    }

    public void r(int i) {
        this.u = i;
    }

    public void s(int i) {
        this.j.e(i);
    }

    public void show() {
        if (!y()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    public void u(boolean z) {
        this.v = z;
    }

    public void v(int i) {
        this.j.i(i);
    }

    public final boolean y() {
        View view;
        if (a()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.j.J(this);
        this.j.K(this);
        this.j.I(true);
        View view2 = this.o;
        boolean z = this.q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.q = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.j.C(view2);
        this.j.F(this.u);
        if (!this.s) {
            this.t = j.d.m(this.e, null, this.c, this.g);
            this.s = true;
        }
        this.j.E(this.t);
        this.j.H(2);
        this.j.G(l());
        this.j.show();
        ListView o = this.j.o();
        o.setOnKeyListener(this);
        if (this.v && this.d.x() != null) {
            FrameLayout inflate = LayoutInflater.from(this.c).inflate(c.g.l, o, false);
            TextView findViewById = inflate.findViewById(16908310);
            if (findViewById != null) {
                findViewById.setText(this.d.x());
            }
            inflate.setEnabled(false);
            o.addHeaderView(inflate, (Object) null, false);
        }
        this.j.m(this.e);
        this.j.show();
        return true;
    }
}
