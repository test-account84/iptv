package androidx.appcompat.view.menu;

import P.L;
import P.p;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.S;
import k.T;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b extends j.d implements i, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = c.g.e;
    public PopupWindow.OnDismissListener A;
    public boolean B;
    public final Context c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final Handler h;
    public View p;
    public View q;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public boolean x;
    public i.a y;
    public ViewTreeObserver z;
    public final List i = new ArrayList();
    public final List j = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    public final View.OnAttachStateChangeListener l = new b();
    public final S m = new c();
    public int n = 0;
    public int o = 0;
    public boolean w = false;
    public int r = C();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (!b.this.a() || b.this.j.size() <= 0 || ((d) b.this.j.get(0)).a.A()) {
                return;
            }
            View view = b.this.q;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.j.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a.show();
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.z = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.z.removeGlobalOnLayoutListener(bVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements S {

        public class a implements Runnable {
            public final /* synthetic */ d a;
            public final /* synthetic */ MenuItem c;
            public final /* synthetic */ e d;

            public a(d dVar, MenuItem menuItem, e eVar) {
                this.a = dVar;
                this.c = menuItem;
                this.d = eVar;
            }

            public void run() {
                d dVar = this.a;
                if (dVar != null) {
                    b.this.B = true;
                    dVar.b.e(false);
                    b.this.B = false;
                }
                if (this.c.isEnabled() && this.c.hasSubMenu()) {
                    this.d.L(this.c, 4);
                }
            }
        }

        public c() {
        }

        public void d(e eVar, MenuItem menuItem) {
            b.this.h.removeCallbacksAndMessages((Object) null);
            int size = b.this.j.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (eVar == ((d) b.this.j.get(i)).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            b.this.h.postAtTime(new a(i2 < b.this.j.size() ? (d) b.this.j.get(i2) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        public void n(e eVar, MenuItem menuItem) {
            b.this.h.removeCallbacksAndMessages(eVar);
        }
    }

    public static class d {
        public final T a;
        public final e b;
        public final int c;

        public d(T t, e eVar, int i) {
            this.a = t;
            this.b = eVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.o();
        }
    }

    public b(Context context, View view, int i, int i2, boolean z) {
        this.c = context;
        this.p = view;
        this.e = i;
        this.f = i2;
        this.g = z;
        Resources resources = context.getResources();
        this.d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c.d.b));
        this.h = new Handler();
    }

    public final MenuItem A(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = eVar.getItem(i);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View B(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int i;
        int firstVisiblePosition;
        MenuItem A = A(dVar.b, eVar);
        if (A == null) {
            return null;
        }
        ListView a2 = dVar.a();
        HeaderViewListAdapter adapter = a2.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = adapter;
            i = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            i = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (A == dVar2.c(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int C() {
        return L.E(this.p) == 1 ? 0 : 1;
    }

    public final int D(int i) {
        List list = this.j;
        ListView a2 = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        return this.r == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    public final void E(e eVar) {
        d dVar;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.c);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, from, this.g, C);
        if (!a() && this.w) {
            dVar2.d(true);
        } else if (a()) {
            dVar2.d(j.d.w(eVar));
        }
        int m = j.d.m(dVar2, null, this.c, this.d);
        T y = y();
        y.m(dVar2);
        y.E(m);
        y.F(this.o);
        if (this.j.size() > 0) {
            List list = this.j;
            dVar = (d) list.get(list.size() - 1);
            view = B(dVar, eVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            y.T(false);
            y.Q(null);
            int D = D(m);
            boolean z = D == 1;
            this.r = D;
            if (Build.VERSION.SDK_INT >= 26) {
                y.C(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (!z) {
                    m = view.getWidth();
                    i3 = i - m;
                }
                i3 = i + m;
            } else {
                if (z) {
                    m = view.getWidth();
                    i3 = i + m;
                }
                i3 = i - m;
            }
            y.e(i3);
            y.L(true);
            y.i(i2);
        } else {
            if (this.s) {
                y.e(this.u);
            }
            if (this.t) {
                y.i(this.v);
            }
            y.G(l());
        }
        this.j.add(new d(y, eVar, this.r));
        y.show();
        ListView o = y.o();
        o.setOnKeyListener(this);
        if (dVar == null && this.x && eVar.x() != null) {
            FrameLayout inflate = from.inflate(c.g.l, o, false);
            TextView findViewById = inflate.findViewById(16908310);
            inflate.setEnabled(false);
            findViewById.setText(eVar.x());
            o.addHeaderView(inflate, (Object) null, false);
            y.show();
        }
    }

    public boolean a() {
        return this.j.size() > 0 && ((d) this.j.get(0)).a.a();
    }

    public void b(e eVar, boolean z) {
        int z2 = z(eVar);
        if (z2 < 0) {
            return;
        }
        int i = z2 + 1;
        if (i < this.j.size()) {
            ((d) this.j.get(i)).b.e(false);
        }
        d dVar = (d) this.j.remove(z2);
        dVar.b.O(this);
        if (this.B) {
            dVar.a.R(null);
            dVar.a.D(0);
        }
        dVar.a.dismiss();
        int size = this.j.size();
        this.r = size > 0 ? ((d) this.j.get(size - 1)).c : C();
        if (size != 0) {
            if (z) {
                ((d) this.j.get(0)).b.e(false);
                return;
            }
            return;
        }
        dismiss();
        i.a aVar = this.y;
        if (aVar != null) {
            aVar.b(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.z.removeGlobalOnLayoutListener(this.k);
            }
            this.z = null;
        }
        this.q.removeOnAttachStateChangeListener(this.l);
        this.A.onDismiss();
    }

    public void d(i.a aVar) {
        this.y = aVar;
    }

    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.j.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.a.a()) {
                    dVar.a.dismiss();
                }
            }
        }
    }

    public boolean e(l lVar) {
        for (d dVar : this.j) {
            if (lVar == dVar.b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        j(lVar);
        i.a aVar = this.y;
        if (aVar != null) {
            aVar.c(lVar);
        }
        return true;
    }

    public void f(boolean z) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            j.d.x(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean g() {
        return false;
    }

    public void j(e eVar) {
        eVar.c(this, this.c);
        if (a()) {
            E(eVar);
        } else {
            this.i.add(eVar);
        }
    }

    public boolean k() {
        return false;
    }

    public void n(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = p.b(this.n, L.E(view));
        }
    }

    public ListView o() {
        if (this.j.isEmpty()) {
            return null;
        }
        return ((d) this.j.get(r0.size() - 1)).a();
    }

    public void onDismiss() {
        d dVar;
        int size = this.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.j.get(i);
            if (!dVar.a.a()) {
                break;
            } else {
                i++;
            }
        }
        if (dVar != null) {
            dVar.b.e(false);
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
        this.w = z;
    }

    public void r(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = p.b(i, L.E(this.p));
        }
    }

    public void s(int i) {
        this.s = true;
        this.u = i;
    }

    public void show() {
        if (a()) {
            return;
        }
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            E((e) it.next());
        }
        this.i.clear();
        View view = this.p;
        this.q = view;
        if (view != null) {
            boolean z = this.z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.z = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.k);
            }
            this.q.addOnAttachStateChangeListener(this.l);
        }
    }

    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    public void u(boolean z) {
        this.x = z;
    }

    public void v(int i) {
        this.t = true;
        this.v = i;
    }

    public final T y() {
        T t = new T(this.c, null, this.e, this.f);
        t.S(this.m);
        t.K(this);
        t.J(this);
        t.C(this.p);
        t.F(this.o);
        t.I(true);
        t.H(2);
        return t;
    }

    public final int z(e eVar) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (eVar == ((d) this.j.get(i)).b) {
                return i;
            }
        }
        return -1;
    }
}
