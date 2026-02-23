package com.google.android.exoplayer2.ui;

import O2.H0;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.u;
import O2.v1;
import O2.w0;
import Z3.z;
import a4.k;
import a4.l;
import a4.q;
import a4.s;
import a4.t;
import a4.w;
import a4.y;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.f;
import d4.P;
import d4.k0;
import e4.C;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c extends FrameLayout {
    public final String A;
    public final Drawable B;
    public final Drawable C;
    public final float D;
    public final float E;
    public final String F;
    public final String G;
    public t1 H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public long U;
    public long[] V;
    public boolean[] W;
    public final c a;
    public final CopyOnWriteArrayList c;
    public final View d;
    public final View e;
    public long[] e0;
    public final View f;
    public boolean[] f0;
    public final View g;
    public long g0;
    public final View h;
    public long h0;
    public final View i;
    public long i0;
    public final ImageView j;
    public final ImageView k;
    public final View l;
    public final TextView m;
    public final TextView n;
    public final f o;
    public final StringBuilder p;
    public final Formatter q;
    public final Q1.b r;
    public final Q1.d s;
    public final Runnable t;
    public final Runnable u;
    public final Drawable v;
    public final Drawable w;
    public final Drawable x;
    public final String y;
    public final String z;

    public static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    public final class c implements t1.d, f.a, View.OnClickListener {
        public c() {
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void C(f fVar, long j, boolean z) {
            c.t(c.this, false);
            if (z || c.d(c.this) == null) {
                return;
            }
            c cVar = c.this;
            c.e(cVar, c.d(cVar), j);
        }

        public void D(f fVar, long j) {
            c.t(c.this, true);
            if (c.u(c.this) != null) {
                c.u(c.this).setText(k0.m0(c.v(c.this), c.c(c.this), j));
            }
        }

        public /* synthetic */ void E(int i) {
            v1.p(this, i);
        }

        public /* synthetic */ void J(boolean z) {
            v1.y(this, z);
        }

        public /* synthetic */ void M(int i, boolean z) {
            v1.f(this, i, z);
        }

        public /* synthetic */ void O(t1.b bVar) {
            v1.b(this, bVar);
        }

        public /* synthetic */ void P() {
            v1.w(this);
        }

        public /* synthetic */ void S(t1.e eVar, t1.e eVar2, int i) {
            v1.v(this, eVar, eVar2, i);
        }

        public /* synthetic */ void U(int i, int i2) {
            v1.A(this, i, i2);
        }

        public /* synthetic */ void V(Q1 q1, int i) {
            v1.B(this, q1, i);
        }

        public /* synthetic */ void W(p1 p1Var) {
            v1.s(this, p1Var);
        }

        public /* synthetic */ void Y(z zVar) {
            v1.C(this, zVar);
        }

        public /* synthetic */ void a(boolean z) {
            v1.z(this, z);
        }

        public /* synthetic */ void a0(u uVar) {
            v1.e(this, uVar);
        }

        public /* synthetic */ void b0(int i) {
            v1.u(this, i);
        }

        public /* synthetic */ void d0(boolean z) {
            v1.h(this, z);
        }

        public /* synthetic */ void e(q3.a aVar) {
            v1.m(this, aVar);
        }

        public /* synthetic */ void f0(V1 v1) {
            v1.D(this, v1);
        }

        public /* synthetic */ void g0(boolean z, int i) {
            v1.t(this, z, i);
        }

        public /* synthetic */ void h0(H0 h0, int i) {
            v1.k(this, h0, i);
        }

        public /* synthetic */ void i0(R0 r0) {
            v1.l(this, r0);
        }

        public /* synthetic */ void j(C c) {
            v1.E(this, c);
        }

        public /* synthetic */ void j0(boolean z, int i) {
            v1.n(this, z, i);
        }

        public /* synthetic */ void k(List list) {
            v1.d(this, list);
        }

        public /* synthetic */ void l0(p1 p1Var) {
            v1.r(this, p1Var);
        }

        public void m0(t1 t1Var, t1.c cVar) {
            if (cVar.b(4, 5)) {
                c.b(c.this);
            }
            if (cVar.b(4, 5, 7)) {
                c.m(c.this);
            }
            if (cVar.a(8)) {
                c.p(c.this);
            }
            if (cVar.a(9)) {
                c.q(c.this);
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                c.r(c.this);
            }
            if (cVar.b(11, 0)) {
                c.s(c.this);
            }
        }

        public /* synthetic */ void n0(boolean z) {
            v1.i(this, z);
        }

        public void o(f fVar, long j) {
            if (c.u(c.this) != null) {
                c.u(c.this).setText(k0.m0(c.v(c.this), c.c(c.this), j));
            }
        }

        public void onClick(View view) {
            t1 d = c.d(c.this);
            if (d == null) {
                return;
            }
            if (c.f(c.this) == view) {
                d.z();
                return;
            }
            if (c.g(c.this) == view) {
                d.m();
                return;
            }
            if (c.h(c.this) == view) {
                if (d.getPlaybackState() != 4) {
                    d.b0();
                    return;
                }
                return;
            }
            if (c.i(c.this) == view) {
                d.d0();
                return;
            }
            if (c.j(c.this) == view) {
                k0.u0(d);
                return;
            }
            if (c.k(c.this) == view) {
                k0.t0(d);
            } else if (c.l(c.this) == view) {
                d.setRepeatMode(P.a(d.getRepeatMode(), c.n(c.this)));
            } else if (c.o(c.this) == view) {
                d.F(!d.Z());
            }
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            v1.x(this, i);
        }

        public /* synthetic */ void t(s1 s1Var) {
            v1.o(this, s1Var);
        }

        public /* synthetic */ void u(P3.f fVar) {
            v1.c(this, fVar);
        }

        public /* synthetic */ void z(int i) {
            v1.q(this, i);
        }

        public /* synthetic */ c(c cVar, a aVar) {
            this();
        }
    }

    public interface d {
    }

    public interface e {
        void o(int i);
    }

    static {
        w0.a("goog.exo.ui");
    }

    public c(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int i2 = a4.u.b;
        this.M = 5000;
        this.O = 0;
        this.N = 200;
        this.U = -9223372036854775807L;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, y.r, i, 0);
            try {
                this.M = obtainStyledAttributes.getInt(y.z, this.M);
                i2 = obtainStyledAttributes.getResourceId(y.s, i2);
                this.O = z(obtainStyledAttributes, this.O);
                this.P = obtainStyledAttributes.getBoolean(y.x, this.P);
                this.Q = obtainStyledAttributes.getBoolean(y.u, this.Q);
                this.R = obtainStyledAttributes.getBoolean(y.w, this.R);
                this.S = obtainStyledAttributes.getBoolean(y.v, this.S);
                this.T = obtainStyledAttributes.getBoolean(y.y, this.T);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(y.A, this.N));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.c = new CopyOnWriteArrayList();
        this.r = new Q1.b();
        this.s = new Q1.d();
        StringBuilder sb = new StringBuilder();
        this.p = sb;
        this.q = new Formatter(sb, Locale.getDefault());
        this.V = new long[0];
        this.W = new boolean[0];
        this.e0 = new long[0];
        this.f0 = new boolean[0];
        c cVar = new c(this, null);
        this.a = cVar;
        this.t = new k(this);
        this.u = new l(this);
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        f findViewById = findViewById(s.H);
        View findViewById2 = findViewById(s.I);
        if (findViewById != null) {
            this.o = findViewById;
        } else if (findViewById2 != null) {
            findViewById = new com.google.android.exoplayer2.ui.b(context, null, 0, attributeSet2);
            findViewById.setId(s.H);
            findViewById.setLayoutParams(findViewById2.getLayoutParams());
            ViewGroup parent = findViewById2.getParent();
            int indexOfChild = parent.indexOfChild(findViewById2);
            parent.removeView(findViewById2);
            parent.addView(findViewById, indexOfChild);
            this.o = findViewById;
        } else {
            this.o = null;
        }
        this.m = findViewById(s.m);
        this.n = findViewById(s.F);
        f fVar = this.o;
        if (fVar != null) {
            fVar.a(cVar);
        }
        View findViewById3 = findViewById(s.C);
        this.f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar);
        }
        View findViewById4 = findViewById(s.B);
        this.g = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(cVar);
        }
        View findViewById5 = findViewById(s.G);
        this.d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(cVar);
        }
        View findViewById6 = findViewById(s.x);
        this.e = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(cVar);
        }
        View findViewById7 = findViewById(s.K);
        this.i = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(cVar);
        }
        View findViewById8 = findViewById(s.q);
        this.h = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(cVar);
        }
        ImageView findViewById9 = findViewById(s.J);
        this.j = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(cVar);
        }
        ImageView findViewById10 = findViewById(s.N);
        this.k = findViewById10;
        if (findViewById10 != null) {
            findViewById10.setOnClickListener(cVar);
        }
        View findViewById11 = findViewById(s.V);
        this.l = findViewById11;
        setShowVrButton(false);
        L(false, false, findViewById11);
        Resources resources = context.getResources();
        this.D = resources.getInteger(t.b) / 100.0f;
        this.E = resources.getInteger(t.a) / 100.0f;
        this.v = k0.X(context, resources, q.b);
        this.w = k0.X(context, resources, q.c);
        this.x = k0.X(context, resources, q.a);
        this.B = k0.X(context, resources, q.e);
        this.C = k0.X(context, resources, q.d);
        this.y = resources.getString(w.j);
        this.z = resources.getString(w.k);
        this.A = resources.getString(w.i);
        this.F = resources.getString(w.n);
        this.G = resources.getString(w.m);
        this.h0 = -9223372036854775807L;
        this.i0 = -9223372036854775807L;
    }

    public static boolean C(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    public static /* synthetic */ void a(c cVar) {
        cVar.O();
    }

    public static /* synthetic */ void b(c cVar) {
        cVar.N();
    }

    public static /* synthetic */ Formatter c(c cVar) {
        return cVar.q;
    }

    public static /* synthetic */ t1 d(c cVar) {
        return cVar.H;
    }

    public static /* synthetic */ void e(c cVar, t1 t1Var, long j) {
        cVar.I(t1Var, j);
    }

    public static /* synthetic */ View f(c cVar) {
        return cVar.e;
    }

    public static /* synthetic */ View g(c cVar) {
        return cVar.d;
    }

    public static /* synthetic */ View h(c cVar) {
        return cVar.h;
    }

    public static /* synthetic */ View i(c cVar) {
        return cVar.i;
    }

    public static /* synthetic */ View j(c cVar) {
        return cVar.f;
    }

    public static /* synthetic */ View k(c cVar) {
        return cVar.g;
    }

    public static /* synthetic */ ImageView l(c cVar) {
        return cVar.j;
    }

    public static /* synthetic */ void m(c cVar) {
        cVar.O();
    }

    public static /* synthetic */ int n(c cVar) {
        return cVar.O;
    }

    public static /* synthetic */ ImageView o(c cVar) {
        return cVar.k;
    }

    public static /* synthetic */ void p(c cVar) {
        cVar.P();
    }

    public static /* synthetic */ void q(c cVar) {
        cVar.Q();
    }

    public static /* synthetic */ void r(c cVar) {
        cVar.M();
    }

    public static /* synthetic */ void s(c cVar) {
        cVar.R();
    }

    public static /* synthetic */ boolean t(c cVar, boolean z) {
        cVar.L = z;
        return z;
    }

    public static /* synthetic */ TextView u(c cVar) {
        return cVar.n;
    }

    public static /* synthetic */ StringBuilder v(c cVar) {
        return cVar.p;
    }

    public static boolean x(Q1 q1, Q1.d dVar) {
        if (q1.u() > 100) {
            return false;
        }
        int u = q1.u();
        for (int i = 0; i < u; i++) {
            if (q1.s(i, dVar).o == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public static int z(TypedArray typedArray, int i) {
        return typedArray.getInt(y.t, i);
    }

    public void A() {
        if (D()) {
            setVisibility(8);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((e) it.next()).o(getVisibility());
            }
            removeCallbacks(this.t);
            removeCallbacks(this.u);
            this.U = -9223372036854775807L;
        }
    }

    public final void B() {
        removeCallbacks(this.u);
        if (this.M <= 0) {
            this.U = -9223372036854775807L;
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = this.M;
        this.U = uptimeMillis + i;
        if (this.I) {
            postDelayed(this.u, i);
        }
    }

    public boolean D() {
        return getVisibility() == 0;
    }

    public void E(e eVar) {
        this.c.remove(eVar);
    }

    public final void F() {
        View view;
        View view2;
        boolean f1 = k0.f1(this.H);
        if (f1 && (view2 = this.f) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (f1 || (view = this.g) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    public final void G() {
        View view;
        View view2;
        boolean f1 = k0.f1(this.H);
        if (f1 && (view2 = this.f) != null) {
            view2.requestFocus();
        } else {
            if (f1 || (view = this.g) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    public final void H(t1 t1Var, int i, long j) {
        t1Var.C(i, j);
    }

    public final void I(t1 t1Var, long j) {
        int X;
        Q1 w = t1Var.w();
        if (this.K && !w.v()) {
            int u = w.u();
            X = 0;
            while (true) {
                long f = w.s(X, this.s).f();
                if (j < f) {
                    break;
                }
                if (X == u - 1) {
                    j = f;
                    break;
                } else {
                    j -= f;
                    X++;
                }
            }
        } else {
            X = t1Var.X();
        }
        H(t1Var, X, j);
        O();
    }

    public void J() {
        if (!D()) {
            setVisibility(0);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((e) it.next()).o(getVisibility());
            }
            K();
            G();
            F();
        }
        B();
    }

    public final void K() {
        N();
        M();
        P();
        Q();
        R();
    }

    public final void L(boolean z, boolean z2, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.D : this.E);
        view.setVisibility(z ? 0 : 8);
    }

    public final void M() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (D() && this.I) {
            t1 t1Var = this.H;
            if (t1Var != null) {
                z = t1Var.t(5);
                z3 = t1Var.t(7);
                z4 = t1Var.t(11);
                z5 = t1Var.t(12);
                z2 = t1Var.t(9);
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            L(this.R, z3, this.d);
            L(this.P, z4, this.i);
            L(this.Q, z5, this.h);
            L(this.S, z2, this.e);
            f fVar = this.o;
            if (fVar != null) {
                fVar.setEnabled(z);
            }
        }
    }

    public final void N() {
        boolean z;
        boolean z2;
        if (D() && this.I) {
            boolean f1 = k0.f1(this.H);
            View view = this.f;
            boolean z3 = true;
            if (view != null) {
                z = !f1 && view.isFocused();
                z2 = k0.a < 21 ? z : !f1 && b.a(this.f);
                this.f.setVisibility(f1 ? 0 : 8);
            } else {
                z = false;
                z2 = false;
            }
            View view2 = this.g;
            if (view2 != null) {
                z |= f1 && view2.isFocused();
                if (k0.a < 21) {
                    z3 = z;
                } else if (!f1 || !b.a(this.g)) {
                    z3 = false;
                }
                z2 |= z3;
                this.g.setVisibility(f1 ? 8 : 0);
            }
            if (z) {
                G();
            }
            if (z2) {
                F();
            }
        }
    }

    public final void O() {
        long j;
        long j2;
        if (D() && this.I) {
            t1 t1Var = this.H;
            if (t1Var != null) {
                j = this.g0 + t1Var.R();
                j2 = this.g0 + t1Var.a0();
            } else {
                j = 0;
                j2 = 0;
            }
            boolean z = j != this.h0;
            this.h0 = j;
            this.i0 = j2;
            TextView textView = this.n;
            if (textView != null && !this.L && z) {
                textView.setText(k0.m0(this.p, this.q, j));
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.setPosition(j);
                this.o.setBufferedPosition(j2);
            }
            removeCallbacks(this.t);
            int playbackState = t1Var == null ? 1 : t1Var.getPlaybackState();
            if (t1Var == null || !t1Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.t, 1000L);
                return;
            }
            f fVar2 = this.o;
            long min = Math.min(fVar2 != null ? fVar2.getPreferredUpdateDelay() : 1000L, 1000 - (j % 1000));
            float f = t1Var.c().a;
            postDelayed(this.t, k0.s(f > 0.0f ? (long) (min / f) : 1000L, this.N, 1000L));
        }
    }

    public final void P() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (D() && this.I && (imageView = this.j) != null) {
            if (this.O == 0) {
                L(false, false, imageView);
                return;
            }
            t1 t1Var = this.H;
            if (t1Var == null) {
                L(true, false, imageView);
                this.j.setImageDrawable(this.v);
                this.j.setContentDescription(this.y);
                return;
            }
            L(true, true, imageView);
            int repeatMode = t1Var.getRepeatMode();
            if (repeatMode == 0) {
                this.j.setImageDrawable(this.v);
                imageView2 = this.j;
                str = this.y;
            } else {
                if (repeatMode != 1) {
                    if (repeatMode == 2) {
                        this.j.setImageDrawable(this.x);
                        imageView2 = this.j;
                        str = this.A;
                    }
                    this.j.setVisibility(0);
                }
                this.j.setImageDrawable(this.w);
                imageView2 = this.j;
                str = this.z;
            }
            imageView2.setContentDescription(str);
            this.j.setVisibility(0);
        }
    }

    public final void Q() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (D() && this.I && (imageView = this.k) != null) {
            t1 t1Var = this.H;
            if (!this.T) {
                L(false, false, imageView);
                return;
            }
            if (t1Var != null) {
                L(true, true, imageView);
                this.k.setImageDrawable(t1Var.Z() ? this.B : this.C);
                imageView2 = this.k;
                if (t1Var.Z()) {
                    str = this.F;
                }
                imageView2.setContentDescription(str);
            }
            L(true, false, imageView);
            this.k.setImageDrawable(this.C);
            imageView2 = this.k;
            str = this.G;
            imageView2.setContentDescription(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void R() {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.c.R():void");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return y(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.u);
        } else if (motionEvent.getAction() == 1) {
            B();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public t1 getPlayer() {
        return this.H;
    }

    public int getRepeatToggleModes() {
        return this.O;
    }

    public boolean getShowShuffleButton() {
        return this.T;
    }

    public int getShowTimeoutMs() {
        return this.M;
    }

    public boolean getShowVrButton() {
        View view = this.l;
        return view != null && view.getVisibility() == 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        long j = this.U;
        if (j != -9223372036854775807L) {
            long uptimeMillis = j - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                A();
            } else {
                postDelayed(this.u, uptimeMillis);
            }
        } else if (D()) {
            B();
        }
        K();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        removeCallbacks(this.t);
        removeCallbacks(this.u);
    }

    public void setPlayer(t1 t1Var) {
        d4.a.g(Looper.myLooper() == Looper.getMainLooper());
        d4.a.a(t1Var == null || t1Var.x() == Looper.getMainLooper());
        t1 t1Var2 = this.H;
        if (t1Var2 == t1Var) {
            return;
        }
        if (t1Var2 != null) {
            t1Var2.l(this.a);
        }
        this.H = t1Var;
        if (t1Var != null) {
            t1Var.B(this.a);
        }
        K();
    }

    public void setProgressUpdateListener(d dVar) {
    }

    public void setRepeatToggleModes(int i) {
        this.O = i;
        t1 t1Var = this.H;
        if (t1Var != null) {
            int repeatMode = t1Var.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.H.setRepeatMode(0);
            } else if (i == 1 && repeatMode == 2) {
                this.H.setRepeatMode(1);
            } else if (i == 2 && repeatMode == 1) {
                this.H.setRepeatMode(2);
            }
        }
        P();
    }

    public void setShowFastForwardButton(boolean z) {
        this.Q = z;
        M();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.J = z;
        R();
    }

    public void setShowNextButton(boolean z) {
        this.S = z;
        M();
    }

    public void setShowPreviousButton(boolean z) {
        this.R = z;
        M();
    }

    public void setShowRewindButton(boolean z) {
        this.P = z;
        M();
    }

    public void setShowShuffleButton(boolean z) {
        this.T = z;
        Q();
    }

    public void setShowTimeoutMs(int i) {
        this.M = i;
        if (D()) {
            B();
        }
    }

    public void setShowVrButton(boolean z) {
        View view = this.l;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.N = k0.r(i, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            L(getShowVrButton(), onClickListener != null, this.l);
        }
    }

    public void w(e eVar) {
        d4.a.e(eVar);
        this.c.add(eVar);
    }

    public boolean y(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        t1 t1Var = this.H;
        if (t1Var == null || !C(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (t1Var.getPlaybackState() == 4) {
                return true;
            }
            t1Var.b0();
            return true;
        }
        if (keyCode == 89) {
            t1Var.d0();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            k0.v0(t1Var);
            return true;
        }
        if (keyCode == 87) {
            t1Var.z();
            return true;
        }
        if (keyCode == 88) {
            t1Var.m();
            return true;
        }
        if (keyCode == 126) {
            k0.u0(t1Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        k0.t0(t1Var);
        return true;
    }
}
