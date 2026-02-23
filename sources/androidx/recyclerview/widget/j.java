package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j {
    public final RecyclerView.o a;
    public int b;
    public final Rect c;

    public static class a extends j {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        public int d(View view) {
            return this.a.r0(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
        }

        public int e(View view) {
            RecyclerView.p layoutParams = view.getLayoutParams();
            return this.a.q0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        public int f(View view) {
            RecyclerView.p layoutParams = view.getLayoutParams();
            return this.a.p0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        public int g(View view) {
            return this.a.o0(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
        }

        public int h() {
            return this.a.I0();
        }

        public int i() {
            return this.a.I0() - this.a.k();
        }

        public int j() {
            return this.a.k();
        }

        public int k() {
            return this.a.J0();
        }

        public int l() {
            return this.a.v0();
        }

        public int m() {
            return this.a.o();
        }

        public int n() {
            return (this.a.I0() - this.a.o()) - this.a.k();
        }

        public int p(View view) {
            this.a.H0(view, true, this.c);
            return this.c.right;
        }

        public int q(View view) {
            this.a.H0(view, true, this.c);
            return this.c.left;
        }

        public void r(int i) {
            this.a.Y0(i);
        }
    }

    public static class b extends j {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        public int d(View view) {
            return this.a.m0(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        }

        public int e(View view) {
            RecyclerView.p layoutParams = view.getLayoutParams();
            return this.a.p0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        public int f(View view) {
            RecyclerView.p layoutParams = view.getLayoutParams();
            return this.a.q0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        public int g(View view) {
            return this.a.s0(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
        }

        public int h() {
            return this.a.u0();
        }

        public int i() {
            return this.a.u0() - this.a.b();
        }

        public int j() {
            return this.a.b();
        }

        public int k() {
            return this.a.v0();
        }

        public int l() {
            return this.a.J0();
        }

        public int m() {
            return this.a.n();
        }

        public int n() {
            return (this.a.u0() - this.a.n()) - this.a.b();
        }

        public int p(View view) {
            this.a.H0(view, true, this.c);
            return this.c.bottom;
        }

        public int q(View view) {
            this.a.H0(view, true, this.c);
            return this.c.top;
        }

        public void r(int i) {
            this.a.Z0(i);
        }
    }

    public j(RecyclerView.o oVar) {
        this.b = Integer.MIN_VALUE;
        this.c = new Rect();
        this.a = oVar;
    }

    public static j a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static j b(RecyclerView.o oVar, int i) {
        if (i == 0) {
            return a(oVar);
        }
        if (i == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static j c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return n() - this.b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.b = n();
    }

    public /* synthetic */ j(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }
}
