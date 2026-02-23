package androidx.appcompat.view.menu;

import P.L;
import P.p;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h {
    public final Context a;
    public final e b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public int g;
    public boolean h;
    public i.a i;
    public j.d j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            h.this.e();
        }
    }

    public static class b {
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public h(Context context, e eVar, View view, boolean z, int i) {
        this(context, eVar, view, z, i, 0);
    }

    public final j.d a() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        b.a(defaultDisplay, point);
        j.d bVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(c.d.a) ? new androidx.appcompat.view.menu.b(this.a, this.f, this.d, this.e, this.c) : new k(this.a, this.b, this.f, this.d, this.e, this.c);
        bVar.j(this.b);
        bVar.t(this.l);
        bVar.n(this.f);
        bVar.d(this.i);
        bVar.q(this.h);
        bVar.r(this.g);
        return bVar;
    }

    public void b() {
        if (d()) {
            this.j.dismiss();
        }
    }

    public j.d c() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean d() {
        j.d dVar = this.j;
        return dVar != null && dVar.a();
    }

    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f = view;
    }

    public void g(boolean z) {
        this.h = z;
        j.d dVar = this.j;
        if (dVar != null) {
            dVar.q(z);
        }
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void j(i.a aVar) {
        this.i = aVar;
        j.d dVar = this.j;
        if (dVar != null) {
            dVar.d(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i, int i2, boolean z, boolean z2) {
        j.d c = c();
        c.u(z2);
        if (z) {
            if ((p.b(this.g, L.E(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            c.s(i);
            c.v(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c.p(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        c.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i, int i2) {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(i, i2, true, true);
        return true;
    }

    public h(Context context, e eVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new a();
        this.a = context;
        this.b = eVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }
}
