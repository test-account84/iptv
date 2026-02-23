package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class n extends RecyclerView.l {
    public boolean g = true;

    public abstract boolean A(RecyclerView.D d);

    public final void B(RecyclerView.D d) {
        J(d);
        h(d);
    }

    public final void C(RecyclerView.D d) {
        K(d);
    }

    public final void D(RecyclerView.D d, boolean z) {
        L(d, z);
        h(d);
    }

    public final void E(RecyclerView.D d, boolean z) {
        M(d, z);
    }

    public final void F(RecyclerView.D d) {
        N(d);
        h(d);
    }

    public final void G(RecyclerView.D d) {
        O(d);
    }

    public final void H(RecyclerView.D d) {
        P(d);
        h(d);
    }

    public final void I(RecyclerView.D d) {
        Q(d);
    }

    public void J(RecyclerView.D d) {
    }

    public void K(RecyclerView.D d) {
    }

    public void L(RecyclerView.D d, boolean z) {
    }

    public void M(RecyclerView.D d, boolean z) {
    }

    public void N(RecyclerView.D d) {
    }

    public void O(RecyclerView.D d) {
    }

    public void P(RecyclerView.D d) {
    }

    public void Q(RecyclerView.D d) {
    }

    public void R(boolean z) {
        this.g = z;
    }

    public boolean a(RecyclerView.D d, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i;
        int i2;
        return (cVar == null || ((i = cVar.a) == (i2 = cVar2.a) && cVar.b == cVar2.b)) ? x(d) : z(d, i, cVar.b, i2, cVar2.b);
    }

    public boolean b(RecyclerView.D d, RecyclerView.D d2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (d2.M()) {
            int i5 = cVar.a;
            i2 = cVar.b;
            i = i5;
        } else {
            i = cVar2.a;
            i2 = cVar2.b;
        }
        return y(d, d2, i3, i4, i, i2);
    }

    public boolean c(RecyclerView.D d, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = d.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (d.y() || (i == left && i2 == top)) {
            return A(d);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return z(d, i, i2, left, top);
    }

    public boolean d(RecyclerView.D d, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i = cVar.a;
        int i2 = cVar2.a;
        if (i != i2 || cVar.b != cVar2.b) {
            return z(d, i, cVar.b, i2, cVar2.b);
        }
        F(d);
        return false;
    }

    public boolean f(RecyclerView.D d) {
        return !this.g || d.w();
    }

    public abstract boolean x(RecyclerView.D d);

    public abstract boolean y(RecyclerView.D d, RecyclerView.D d2, int i, int i2, int i3, int i4);

    public abstract boolean z(RecyclerView.D d, int i, int i2, int i3, int i4);
}
