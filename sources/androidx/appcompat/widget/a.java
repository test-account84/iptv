package androidx.appcompat.widget;

import P.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import k.P;
import k.g0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends androidx.appcompat.view.menu.a implements b.a {
    public a A;
    public c B;
    public b C;
    public final f D;
    public int E;
    public d l;
    public Drawable m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public final SparseBooleanArray y;
    public e z;

    public class a extends h {
        public a(Context context, l lVar, View view) {
            super(context, lVar, view, false, c.a.i);
            if (!((g) lVar.getItem()).l()) {
                View view2 = a.this.l;
                f(view2 == null ? (View) a.t(a.this) : view2);
            }
            j(a.this.D);
        }

        public void e() {
            a aVar = a.this;
            aVar.A = null;
            aVar.E = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        public j.f a() {
            a aVar = a.this.A;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    public class c implements Runnable {
        public e a;

        public c(e eVar) {
            this.a = eVar;
        }

        public void run() {
            if (a.v(a.this) != null) {
                a.w(a.this).d();
            }
            View x = a.x(a.this);
            if (x != null && x.getWindowToken() != null && this.a.m()) {
                a.this.z = this.a;
            }
            a.this.B = null;
        }
    }

    public class d extends AppCompatImageView implements ActionMenuView.a {

        public class a extends P {
            public final /* synthetic */ a k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, a aVar) {
                super(view);
                this.k = aVar;
            }

            public j.f b() {
                e eVar = a.this.z;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            public boolean c() {
                a.this.K();
                return true;
            }

            public boolean d() {
                a aVar = a.this;
                if (aVar.B != null) {
                    return false;
                }
                aVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, c.a.h);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            g0.a(this, getContentDescription());
            setOnTouchListener(new a(this, a.this));
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            a.this.K();
            return true;
        }

        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                H.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class e extends h {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z) {
            super(context, eVar, view, z, c.a.i);
            h(8388613);
            j(a.this.D);
        }

        public void e() {
            if (a.r(a.this) != null) {
                a.s(a.this).close();
            }
            a.this.z = null;
            super.e();
        }
    }

    public class f implements i.a {
        public f() {
        }

        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
            if (eVar instanceof l) {
                eVar.D().e(false);
            }
            i.a m = a.this.m();
            if (m != null) {
                m.b(eVar, z);
            }
        }

        public boolean c(androidx.appcompat.view.menu.e eVar) {
            if (eVar == a.u(a.this)) {
                return false;
            }
            a.this.E = ((l) eVar).getItem().getItemId();
            i.a m = a.this.m();
            if (m != null) {
                return m.c(eVar);
            }
            return false;
        }
    }

    public a(Context context) {
        super(context, c.g.c, c.g.b);
        this.y = new SparseBooleanArray();
        this.D = new f();
    }

    public static /* synthetic */ androidx.appcompat.view.menu.e r(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ androidx.appcompat.view.menu.e s(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ j t(a aVar) {
        return aVar.j;
    }

    public static /* synthetic */ androidx.appcompat.view.menu.e u(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ androidx.appcompat.view.menu.e v(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ androidx.appcompat.view.menu.e w(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ j x(a aVar) {
        return aVar.j;
    }

    public Drawable A() {
        d dVar = this.l;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    public boolean B() {
        View view;
        c cVar = this.B;
        if (cVar != null && (view = this.j) != null) {
            view.removeCallbacks(cVar);
            this.B = null;
            return true;
        }
        e eVar = this.z;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.A;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.B != null || E();
    }

    public boolean E() {
        e eVar = this.z;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.t) {
            this.s = i.a.b(this.c).d();
        }
        androidx.appcompat.view.menu.e eVar = this.d;
        if (eVar != null) {
            eVar.K(true);
        }
    }

    public void G(boolean z) {
        this.w = z;
    }

    public void H(ActionMenuView actionMenuView) {
        this.j = actionMenuView;
        actionMenuView.a(this.d);
    }

    public void I(Drawable drawable) {
        d dVar = this.l;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.n = true;
            this.m = drawable;
        }
    }

    public void J(boolean z) {
        this.o = z;
        this.p = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.o || E() || (eVar = this.d) == null || this.j == null || this.B != null || eVar.z().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.c, this.d, this.l, true));
        this.B = cVar;
        this.j.post(cVar);
        return true;
    }

    public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
        y();
        super.b(eVar, z);
    }

    public boolean e(l lVar) {
        boolean z = false;
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        l lVar2 = lVar;
        while (lVar2.e0() != this.d) {
            lVar2 = (l) lVar2.e0();
        }
        View z2 = z(lVar2.getItem());
        if (z2 == null) {
            return false;
        }
        this.E = lVar.getItem().getItemId();
        int size = lVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = lVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        a aVar = new a(this.c, lVar, z2);
        this.A = aVar;
        aVar.g(z);
        this.A.k();
        super.e(lVar);
        return true;
    }

    public void f(boolean z) {
        super.f(z);
        this.j.requestLayout();
        androidx.appcompat.view.menu.e eVar = this.d;
        boolean z2 = false;
        if (eVar != null) {
            ArrayList s = eVar.s();
            int size = s.size();
            for (int i = 0; i < size; i++) {
                P.b b2 = ((g) s.get(i)).b();
                if (b2 != null) {
                    b2.k(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.d;
        ArrayList z3 = eVar2 != null ? eVar2.z() : null;
        if (this.o && z3 != null) {
            int size2 = z3.size();
            if (size2 == 1) {
                z2 = !((g) z3.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        d dVar = this.l;
        if (z2) {
            if (dVar == null) {
                this.l = new d(this.a);
            }
            j jVar = (ViewGroup) this.l.getParent();
            if (jVar != this.j) {
                if (jVar != null) {
                    jVar.removeView(this.l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.j;
                actionMenuView.addView(this.l, actionMenuView.F());
            }
        } else if (dVar != null) {
            ViewGroup parent = dVar.getParent();
            ViewGroup viewGroup = this.j;
            if (parent == viewGroup) {
                viewGroup.removeView(this.l);
            }
        }
        ((ActionMenuView) this.j).setOverflowReserved(this.o);
    }

    public boolean g() {
        ArrayList arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        a aVar = this;
        androidx.appcompat.view.menu.e eVar = aVar.d;
        View view = null;
        int i5 = 0;
        if (eVar != null) {
            arrayList = eVar.E();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = aVar.s;
        int i7 = aVar.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) aVar.j;
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            g gVar = (g) arrayList.get(i10);
            if (gVar.o()) {
                i8++;
            } else if (gVar.n()) {
                i9++;
            } else {
                z = true;
            }
            if (aVar.w && gVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (aVar.o && (z || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = aVar.y;
        sparseBooleanArray.clear();
        if (aVar.u) {
            int i12 = aVar.x;
            i3 = i7 / i12;
            i2 = i12 + ((i7 % i12) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            g gVar2 = (g) arrayList.get(i13);
            if (gVar2.o()) {
                View n = aVar.n(gVar2, view, viewGroup);
                if (aVar.u) {
                    i3 -= ActionMenuView.L(n, i2, i3, makeMeasureSpec, i5);
                } else {
                    n.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                i4 = i;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i11 > 0 || z2) && i7 > 0 && (!aVar.u || i3 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    View n2 = aVar.n(gVar2, null, viewGroup);
                    if (aVar.u) {
                        int L = ActionMenuView.L(n2, i2, i3, makeMeasureSpec, 0);
                        i3 -= L;
                        if (L == 0) {
                            z4 = false;
                        }
                    } else {
                        n2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = n2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z5 & (!aVar.u ? i7 + i14 <= 0 : i7 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        g gVar3 = (g) arrayList.get(i15);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i11++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z3) {
                    i11--;
                }
                gVar2.u(z3);
            } else {
                i4 = i;
                gVar2.u(false);
                i13++;
                view = null;
                aVar = this;
                i = i4;
                i5 = 0;
            }
            i13++;
            view = null;
            aVar = this;
            i = i4;
            i5 = 0;
        }
        return true;
    }

    public void i(Context context, androidx.appcompat.view.menu.e eVar) {
        super.i(context, eVar);
        Resources resources = context.getResources();
        i.a b2 = i.a.b(context);
        if (!this.p) {
            this.o = b2.f();
        }
        if (!this.v) {
            this.q = b2.c();
        }
        if (!this.t) {
            this.s = b2.d();
        }
        int i = this.q;
        if (this.o) {
            if (this.l == null) {
                d dVar = new d(this.a);
                this.l = dVar;
                if (this.n) {
                    dVar.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.l.getMeasuredWidth();
        } else {
            this.l = null;
        }
        this.r = i;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void j(g gVar, j.a aVar) {
        aVar.c(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.j);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    public boolean l(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.l) {
            return false;
        }
        return super.l(viewGroup, i);
    }

    public View n(g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.o(layoutParams));
        }
        return actionView;
    }

    public j o(ViewGroup viewGroup) {
        j jVar = this.j;
        j o = super.o(viewGroup);
        if (jVar != o) {
            ((ActionMenuView) o).setPresenter(this);
        }
        return o;
    }

    public boolean q(int i, g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return B() | C();
    }

    public final View z(MenuItem menuItem) {
        ViewGroup viewGroup = this.j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            j.a childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof j.a) && childAt.getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }
}
