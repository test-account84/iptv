package com.google.android.exoplayer2.ui;

import B3.g0;
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
import O2.z0;
import Z3.x;
import Z3.z;
import a4.B;
import a4.D;
import a4.E;
import a4.F;
import a4.G;
import a4.H;
import a4.I;
import a4.X;
import a4.c0;
import a4.n;
import a4.p;
import a4.q;
import a4.r;
import a4.s;
import a4.t;
import a4.v;
import a4.w;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.f;
import d4.P;
import d4.k0;
import e4.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e extends FrameLayout {
    public static final float[] C0;
    public final View A;
    public long A0;
    public final View B;
    public boolean B0;
    public final View C;
    public final TextView D;
    public final TextView E;
    public final com.google.android.exoplayer2.ui.f F;
    public final StringBuilder G;
    public final Formatter H;
    public final Q1.b I;
    public final Q1.d J;
    public final Runnable K;
    public final Drawable L;
    public final Drawable M;
    public final Drawable N;
    public final String O;
    public final String P;
    public final String Q;
    public final Drawable R;
    public final Drawable S;
    public final float T;
    public final float U;
    public final String V;
    public final String W;
    public final X a;
    public final Resources c;
    public final c d;
    public final CopyOnWriteArrayList e;
    public final Drawable e0;
    public final RecyclerView f;
    public final Drawable f0;
    public final h g;
    public final String g0;
    public final e h;
    public final String h0;
    public final j i;
    public final Drawable i0;
    public final b j;
    public final Drawable j0;
    public final c0 k;
    public final String k0;
    public final PopupWindow l;
    public final String l0;
    public final int m;
    public t1 m0;
    public final View n;
    public d n0;
    public final View o;
    public boolean o0;
    public final View p;
    public boolean p0;
    public final View q;
    public boolean q0;
    public final View r;
    public boolean r0;
    public final TextView s;
    public boolean s0;
    public final TextView t;
    public int t0;
    public final ImageView u;
    public int u0;
    public final ImageView v;
    public int v0;
    public final View w;
    public long[] w0;
    public final ImageView x;
    public boolean[] x0;
    public final ImageView y;
    public long[] y0;
    public final ImageView z;
    public boolean[] z0;

    public final class b extends l {
        public b() {
            super();
        }

        public static /* synthetic */ void r0(b bVar, View view) {
            bVar.x0(view);
        }

        public void n0(i iVar) {
            iVar.t.setText(w.w);
            iVar.u.setVisibility(s0(((t1) d4.a.e(e.j(e.this))).y()) ? 4 : 0);
            ((RecyclerView.D) iVar).a.setOnClickListener(new E(this));
        }

        public void q0(String str) {
            e.v(e.this).m0(1, str);
        }

        public final boolean s0(z zVar) {
            for (int i = 0; i < this.d.size(); i++) {
                if (zVar.z.containsKey(((k) this.d.get(i)).a.b())) {
                    return true;
                }
            }
            return false;
        }

        public void t0(List list) {
            h v;
            String str;
            Resources resources;
            int i;
            this.d = list;
            z y = ((t1) d4.a.e(e.j(e.this))).y();
            if (list.isEmpty()) {
                v = e.v(e.this);
                resources = e.this.getResources();
                i = w.x;
            } else {
                if (s0(y)) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        k kVar = (k) list.get(i2);
                        if (kVar.a()) {
                            v = e.v(e.this);
                            str = kVar.c;
                            v.m0(1, str);
                        }
                    }
                    return;
                }
                v = e.v(e.this);
                resources = e.this.getResources();
                i = w.w;
            }
            str = resources.getString(i);
            v.m0(1, str);
        }

        public final /* synthetic */ void x0(View view) {
            if (e.j(e.this) == null || !e.j(e.this).t(29)) {
                return;
            }
            ((t1) k0.j(e.j(e.this))).i(e.j(e.this).y().B().C(1).L(1, false).B());
            e.v(e.this).m0(1, e.this.getResources().getString(w.w));
            e.H(e.this).dismiss();
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this();
        }
    }

    public final class c implements t1.d, f.a, View.OnClickListener, PopupWindow.OnDismissListener {
        public c() {
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void C(com.google.android.exoplayer2.ui.f fVar, long j, boolean z) {
            e.e(e.this, false);
            if (!z && e.j(e.this) != null) {
                e eVar = e.this;
                e.k(eVar, e.j(eVar), j);
            }
            e.i(e.this).W();
        }

        public void D(com.google.android.exoplayer2.ui.f fVar, long j) {
            e.e(e.this, true);
            if (e.f(e.this) != null) {
                e.f(e.this).setText(k0.m0(e.g(e.this), e.h(e.this), j));
            }
            e.i(e.this).V();
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
            if (cVar.b(4, 5, 13)) {
                e.x(e.this);
            }
            if (cVar.b(4, 5, 7, 13)) {
                e.F(e.this);
            }
            if (cVar.b(8, 13)) {
                e.M(e.this);
            }
            if (cVar.b(9, 13)) {
                e.N(e.this);
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                e.O(e.this);
            }
            if (cVar.b(11, 0, 13)) {
                e.P(e.this);
            }
            if (cVar.b(12, 13)) {
                e.Q(e.this);
            }
            if (cVar.b(2, 13)) {
                e.d(e.this);
            }
        }

        public /* synthetic */ void n0(boolean z) {
            v1.i(this, z);
        }

        public void o(com.google.android.exoplayer2.ui.f fVar, long j) {
            if (e.f(e.this) != null) {
                e.f(e.this).setText(k0.m0(e.g(e.this), e.h(e.this), j));
            }
        }

        public void onClick(View view) {
            e eVar;
            RecyclerView.g D;
            View C;
            t1 j = e.j(e.this);
            if (j == null) {
                return;
            }
            e.i(e.this).W();
            if (e.m(e.this) == view) {
                if (j.t(9)) {
                    j.z();
                    return;
                }
                return;
            }
            if (e.n(e.this) == view) {
                if (j.t(7)) {
                    j.m();
                    return;
                }
                return;
            }
            if (e.o(e.this) == view) {
                if (j.getPlaybackState() == 4 || !j.t(12)) {
                    return;
                }
                j.b0();
                return;
            }
            if (e.p(e.this) == view) {
                if (j.t(11)) {
                    j.d0();
                    return;
                }
                return;
            }
            if (e.q(e.this) == view) {
                k0.v0(j);
                return;
            }
            if (e.r(e.this) == view) {
                if (j.t(15)) {
                    j.setRepeatMode(P.a(j.getRepeatMode(), e.s(e.this)));
                    return;
                }
                return;
            }
            if (e.t(e.this) == view) {
                if (j.t(14)) {
                    j.F(!j.Z());
                    return;
                }
                return;
            }
            if (e.u(e.this) == view) {
                e.i(e.this).V();
                eVar = e.this;
                D = e.v(eVar);
                C = e.u(e.this);
            } else if (e.y(e.this) == view) {
                e.i(e.this).V();
                eVar = e.this;
                D = e.z(eVar);
                C = e.y(e.this);
            } else if (e.A(e.this) == view) {
                e.i(e.this).V();
                eVar = e.this;
                D = e.B(eVar);
                C = e.A(e.this);
            } else {
                if (e.C(e.this) != view) {
                    return;
                }
                e.i(e.this).V();
                eVar = e.this;
                D = e.D(eVar);
                C = e.C(e.this);
            }
            e.w(eVar, D, C);
        }

        public void onDismiss() {
            if (e.l(e.this)) {
                e.i(e.this).W();
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

        public /* synthetic */ c(e eVar, a aVar) {
            this();
        }
    }

    public interface d {
        void C(boolean z);
    }

    public final class e extends RecyclerView.g {
        public final String[] d;
        public final float[] e;
        public int f;

        public e(String[] strArr, float[] fArr) {
            this.d = strArr;
            this.e = fArr;
        }

        public static /* synthetic */ void j0(e eVar, int i, View view) {
            eVar.l0(i, view);
        }

        public String k0() {
            return this.d[this.f];
        }

        public final /* synthetic */ void l0(int i, View view) {
            if (i != this.f) {
                e.G(e.this, this.e[i]);
            }
            e.H(e.this).dismiss();
        }

        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void E(i iVar, int i) {
            View view;
            CharSequence[] charSequenceArr = this.d;
            if (i < charSequenceArr.length) {
                iVar.t.setText(charSequenceArr[i]);
            }
            int i2 = 0;
            if (i == this.f) {
                ((RecyclerView.D) iVar).a.setSelected(true);
                view = iVar.u;
            } else {
                ((RecyclerView.D) iVar).a.setSelected(false);
                view = iVar.u;
                i2 = 4;
            }
            view.setVisibility(i2);
            ((RecyclerView.D) iVar).a.setOnClickListener(new F(this, i));
        }

        public int n() {
            return this.d.length;
        }

        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public i L(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(e.this.getContext()).inflate(a4.u.h, viewGroup, false));
        }

        public void p0(float f) {
            int i = 0;
            int i2 = 0;
            float f2 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.e;
                if (i >= fArr.length) {
                    this.f = i2;
                    return;
                }
                float abs = Math.abs(f - fArr[i]);
                if (abs < f2) {
                    i2 = i;
                    f2 = abs;
                }
                i++;
            }
        }
    }

    public interface f {
    }

    public final class g extends RecyclerView.D {
        public final TextView t;
        public final TextView u;
        public final ImageView v;

        public g(View view) {
            super(view);
            if (k0.a < 26) {
                view.setFocusable(true);
            }
            this.t = view.findViewById(s.u);
            this.u = view.findViewById(s.P);
            this.v = view.findViewById(s.t);
            view.setOnClickListener(new G(this));
        }

        public static /* synthetic */ void P(g gVar, View view) {
            gVar.T(view);
        }

        public static /* synthetic */ TextView Q(g gVar) {
            return gVar.t;
        }

        public static /* synthetic */ TextView R(g gVar) {
            return gVar.u;
        }

        public static /* synthetic */ ImageView S(g gVar) {
            return gVar.v;
        }

        public final /* synthetic */ void T(View view) {
            e.E(e.this, m());
        }
    }

    public class h extends RecyclerView.g {
        public final String[] d;
        public final String[] e;
        public final Drawable[] f;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.d = strArr;
            this.e = new String[strArr.length];
            this.f = drawableArr;
        }

        public boolean j0() {
            return n0(1) || n0(0);
        }

        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void E(g gVar, int i) {
            View view;
            RecyclerView.p pVar;
            if (n0(i)) {
                view = ((RecyclerView.D) gVar).a;
                pVar = new RecyclerView.p(-1, -2);
            } else {
                view = ((RecyclerView.D) gVar).a;
                pVar = new RecyclerView.p(0, 0);
            }
            view.setLayoutParams(pVar);
            g.Q(gVar).setText(this.d[i]);
            if (this.e[i] == null) {
                g.R(gVar).setVisibility(8);
            } else {
                g.R(gVar).setText(this.e[i]);
            }
            Drawable drawable = this.f[i];
            ImageView S = g.S(gVar);
            if (drawable == null) {
                S.setVisibility(8);
            } else {
                S.setImageDrawable(this.f[i]);
            }
        }

        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public g L(ViewGroup viewGroup, int i) {
            return e.this.new g(LayoutInflater.from(e.this.getContext()).inflate(a4.u.g, viewGroup, false));
        }

        public void m0(int i, String str) {
            this.e[i] = str;
        }

        public int n() {
            return this.d.length;
        }

        public final boolean n0(int i) {
            if (e.j(e.this) == null) {
                return false;
            }
            if (i == 0) {
                return e.j(e.this).t(13);
            }
            if (i != 1) {
                return true;
            }
            return e.j(e.this).t(30) && e.j(e.this).t(29);
        }

        public long o(int i) {
            return i;
        }
    }

    public static class i extends RecyclerView.D {
        public final TextView t;
        public final View u;

        public i(View view) {
            super(view);
            if (k0.a < 26) {
                view.setFocusable(true);
            }
            this.t = view.findViewById(s.S);
            this.u = view.findViewById(s.h);
        }
    }

    public final class j extends l {
        public j() {
            super();
        }

        public static /* synthetic */ void r0(j jVar, View view) {
            jVar.t0(view);
        }

        private /* synthetic */ void t0(View view) {
            if (e.j(e.this) == null || !e.j(e.this).t(29)) {
                return;
            }
            e.j(e.this).i(e.j(e.this).y().B().C(3).H(-3).B());
            e.H(e.this).dismiss();
        }

        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void E(i iVar, int i) {
            super.E(iVar, i);
            if (i > 0) {
                iVar.u.setVisibility(((k) this.d.get(i + (-1))).a() ? 0 : 4);
            }
        }

        public void n0(i iVar) {
            boolean z;
            iVar.t.setText(w.x);
            int i = 0;
            while (true) {
                if (i >= this.d.size()) {
                    z = true;
                    break;
                } else {
                    if (((k) this.d.get(i)).a()) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            iVar.u.setVisibility(z ? 0 : 4);
            ((RecyclerView.D) iVar).a.setOnClickListener(new H(this));
        }

        public void q0(String str) {
        }

        public void s0(List list) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (((k) list.get(i)).a()) {
                    z = true;
                    break;
                }
                i++;
            }
            if (e.C(e.this) != null) {
                ImageView C = e.C(e.this);
                e eVar = e.this;
                C.setImageDrawable(z ? e.I(eVar) : e.J(eVar));
                e.C(e.this).setContentDescription(z ? e.K(e.this) : e.L(e.this));
            }
            this.d = list;
        }

        public /* synthetic */ j(e eVar, a aVar) {
            this();
        }
    }

    public static final class k {
        public final V1.a a;
        public final int b;
        public final String c;

        public k(V1 v1, int i, int i2, String str) {
            this.a = (V1.a) v1.c().get(i);
            this.b = i2;
            this.c = str;
        }

        public boolean a() {
            return this.a.j(this.b);
        }
    }

    public abstract class l extends RecyclerView.g {
        public List d = new ArrayList();

        public l() {
        }

        public static /* synthetic */ void j0(l lVar, t1 t1Var, g0 g0Var, k kVar, View view) {
            lVar.l0(t1Var, g0Var, kVar, view);
        }

        public void k0() {
            this.d = Collections.emptyList();
        }

        public final /* synthetic */ void l0(t1 t1Var, g0 g0Var, k kVar, View view) {
            if (t1Var.t(29)) {
                t1Var.i(t1Var.y().B().I(new x(g0Var, y.A(Integer.valueOf(kVar.b)))).L(kVar.a.e(), false).B());
                q0(kVar.c);
                e.H(e.this).dismiss();
            }
        }

        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void E(i iVar, int i) {
            t1 j = e.j(e.this);
            if (j == null) {
                return;
            }
            if (i == 0) {
                n0(iVar);
                return;
            }
            k kVar = (k) this.d.get(i - 1);
            g0 b = kVar.a.b();
            boolean z = j.y().z.get(b) != null && kVar.a();
            iVar.t.setText(kVar.c);
            iVar.u.setVisibility(z ? 0 : 4);
            ((RecyclerView.D) iVar).a.setOnClickListener(new I(this, j, b, kVar));
        }

        public int n() {
            if (this.d.isEmpty()) {
                return 0;
            }
            return this.d.size() + 1;
        }

        public abstract void n0(i iVar);

        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public i L(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(e.this.getContext()).inflate(a4.u.h, viewGroup, false));
        }

        public abstract void q0(String str);
    }

    public interface m {
        void o(int i);
    }

    static {
        w0.a("goog.exo.ui");
        C0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public e(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        c cVar;
        boolean z9;
        boolean z10;
        TextView textView;
        super(context, attributeSet, i2);
        int i3 = a4.u.d;
        this.t0 = 5000;
        this.v0 = 0;
        this.u0 = 200;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a4.y.P, i2, 0);
            try {
                i3 = obtainStyledAttributes.getResourceId(a4.y.R, i3);
                this.t0 = obtainStyledAttributes.getInt(a4.y.Z, this.t0);
                this.v0 = W(obtainStyledAttributes, this.v0);
                boolean z11 = obtainStyledAttributes.getBoolean(a4.y.W, true);
                boolean z12 = obtainStyledAttributes.getBoolean(a4.y.T, true);
                boolean z13 = obtainStyledAttributes.getBoolean(a4.y.V, true);
                boolean z14 = obtainStyledAttributes.getBoolean(a4.y.U, true);
                boolean z15 = obtainStyledAttributes.getBoolean(a4.y.X, false);
                boolean z16 = obtainStyledAttributes.getBoolean(a4.y.Y, false);
                boolean z17 = obtainStyledAttributes.getBoolean(a4.y.a0, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(a4.y.b0, this.u0));
                boolean z18 = obtainStyledAttributes.getBoolean(a4.y.Q, true);
                obtainStyledAttributes.recycle();
                z8 = z16;
                z5 = z13;
                z2 = z17;
                z6 = z14;
                z3 = z11;
                z4 = z12;
                z = z18;
                z7 = z15;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = true;
            z2 = false;
            z3 = true;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = false;
            z8 = false;
        }
        LayoutInflater.from(context).inflate(i3, this);
        setDescendantFocusability(262144);
        c cVar2 = new c(this, null);
        this.d = cVar2;
        this.e = new CopyOnWriteArrayList();
        this.I = new Q1.b();
        this.J = new Q1.d();
        StringBuilder sb = new StringBuilder();
        this.G = sb;
        this.H = new Formatter(sb, Locale.getDefault());
        this.w0 = new long[0];
        this.x0 = new boolean[0];
        this.y0 = new long[0];
        this.z0 = new boolean[0];
        this.K = new B(this);
        this.D = findViewById(s.m);
        this.E = findViewById(s.F);
        View view = (ImageView) findViewById(s.Q);
        this.x = view;
        if (view != null) {
            view.setOnClickListener(cVar2);
        }
        ImageView findViewById = findViewById(s.s);
        this.y = findViewById;
        a0(findViewById, new a4.C(this));
        ImageView findViewById2 = findViewById(s.w);
        this.z = findViewById2;
        a0(findViewById2, new a4.C(this));
        View findViewById3 = findViewById(s.M);
        this.A = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar2);
        }
        View findViewById4 = findViewById(s.E);
        this.B = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(cVar2);
        }
        View findViewById5 = findViewById(s.c);
        this.C = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(cVar2);
        }
        com.google.android.exoplayer2.ui.f findViewById6 = findViewById(s.H);
        View findViewById7 = findViewById(s.I);
        if (findViewById6 != null) {
            this.F = findViewById6;
            cVar = cVar2;
            z9 = z;
            z10 = z2;
            textView = null;
        } else if (findViewById7 != null) {
            textView = null;
            cVar = cVar2;
            z9 = z;
            z10 = z2;
            com.google.android.exoplayer2.ui.b bVar = new com.google.android.exoplayer2.ui.b(context, null, 0, attributeSet2, a4.x.a);
            bVar.setId(s.H);
            bVar.setLayoutParams(findViewById7.getLayoutParams());
            ViewGroup parent = findViewById7.getParent();
            int indexOfChild = parent.indexOfChild(findViewById7);
            parent.removeView(findViewById7);
            parent.addView(bVar, indexOfChild);
            this.F = bVar;
        } else {
            cVar = cVar2;
            z9 = z;
            z10 = z2;
            textView = null;
            this.F = null;
        }
        com.google.android.exoplayer2.ui.f fVar = this.F;
        c cVar3 = cVar;
        if (fVar != null) {
            fVar.a(cVar3);
        }
        View findViewById8 = findViewById(s.D);
        this.p = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(cVar3);
        }
        View findViewById9 = findViewById(s.G);
        this.n = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(cVar3);
        }
        View findViewById10 = findViewById(s.x);
        this.o = findViewById10;
        if (findViewById10 != null) {
            findViewById10.setOnClickListener(cVar3);
        }
        Typeface h2 = F.h.h(context, r.a);
        TextView findViewById11 = findViewById(s.K);
        TextView findViewById12 = findViewById11 == null ? findViewById(s.L) : textView;
        this.t = findViewById12;
        if (findViewById12 != null) {
            findViewById12.setTypeface(h2);
        }
        findViewById11 = findViewById11 == null ? findViewById12 : findViewById11;
        this.r = findViewById11;
        if (findViewById11 != null) {
            findViewById11.setOnClickListener(cVar3);
        }
        TextView findViewById13 = findViewById(s.q);
        TextView findViewById14 = findViewById13 == null ? findViewById(s.r) : null;
        this.s = findViewById14;
        if (findViewById14 != null) {
            findViewById14.setTypeface(h2);
        }
        findViewById13 = findViewById13 == null ? findViewById14 : findViewById13;
        this.q = findViewById13;
        if (findViewById13 != null) {
            findViewById13.setOnClickListener(cVar3);
        }
        View view2 = (ImageView) findViewById(s.J);
        this.u = view2;
        if (view2 != null) {
            view2.setOnClickListener(cVar3);
        }
        View view3 = (ImageView) findViewById(s.N);
        this.v = view3;
        if (view3 != null) {
            view3.setOnClickListener(cVar3);
        }
        Resources resources = context.getResources();
        this.c = resources;
        this.T = resources.getInteger(t.b) / 100.0f;
        this.U = resources.getInteger(t.a) / 100.0f;
        View findViewById15 = findViewById(s.V);
        this.w = findViewById15;
        boolean z19 = z8;
        if (findViewById15 != null) {
            o0(false, findViewById15);
        }
        X x = new X(this);
        this.a = x;
        x.X(z9);
        boolean z20 = z7;
        h hVar = new h(new String[]{resources.getString(w.h), resources.getString(w.y)}, new Drawable[]{k0.X(context, resources, q.q), k0.X(context, resources, q.g)});
        this.g = hVar;
        this.m = resources.getDimensionPixelSize(p.a);
        RecyclerView inflate = LayoutInflater.from(context).inflate(a4.u.f, (ViewGroup) null);
        this.f = inflate;
        inflate.setAdapter(hVar);
        inflate.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        this.l = popupWindow;
        if (k0.a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(cVar3);
        this.B0 = true;
        this.k = new a4.h(getResources());
        this.e0 = k0.X(context, resources, q.s);
        this.f0 = k0.X(context, resources, q.r);
        this.g0 = resources.getString(w.b);
        this.h0 = resources.getString(w.a);
        this.i = new j(this, null);
        this.j = new b(this, null);
        this.h = new e(resources.getStringArray(n.a), C0);
        this.i0 = k0.X(context, resources, q.i);
        this.j0 = k0.X(context, resources, q.h);
        this.L = k0.X(context, resources, q.m);
        this.M = k0.X(context, resources, q.n);
        this.N = k0.X(context, resources, q.l);
        this.R = k0.X(context, resources, q.p);
        this.S = k0.X(context, resources, q.o);
        this.k0 = resources.getString(w.d);
        this.l0 = resources.getString(w.c);
        this.O = resources.getString(w.j);
        this.P = resources.getString(w.k);
        this.Q = resources.getString(w.i);
        this.V = resources.getString(w.n);
        this.W = resources.getString(w.m);
        x.Y(findViewById(s.e), true);
        x.Y(findViewById13, z4);
        x.Y(findViewById11, z3);
        x.Y(findViewById9, z5);
        x.Y(findViewById10, z6);
        x.Y(view3, z20);
        x.Y(view, z19);
        x.Y(findViewById15, z10);
        x.Y(view2, this.v0 != 0);
        addOnLayoutChangeListener(new D(this));
    }

    public static /* synthetic */ View A(e eVar) {
        return eVar.C;
    }

    public static /* synthetic */ b B(e eVar) {
        return eVar.j;
    }

    public static /* synthetic */ ImageView C(e eVar) {
        return eVar.x;
    }

    public static /* synthetic */ j D(e eVar) {
        return eVar.i;
    }

    public static /* synthetic */ void E(e eVar, int i2) {
        eVar.h0(i2);
    }

    public static /* synthetic */ void F(e eVar) {
        eVar.v0();
    }

    public static /* synthetic */ void G(e eVar, float f2) {
        eVar.setPlaybackSpeed(f2);
    }

    public static /* synthetic */ PopupWindow H(e eVar) {
        return eVar.l;
    }

    public static /* synthetic */ Drawable I(e eVar) {
        return eVar.e0;
    }

    public static /* synthetic */ Drawable J(e eVar) {
        return eVar.f0;
    }

    public static /* synthetic */ String K(e eVar) {
        return eVar.g0;
    }

    public static /* synthetic */ String L(e eVar) {
        return eVar.h0;
    }

    public static /* synthetic */ void M(e eVar) {
        eVar.w0();
    }

    public static /* synthetic */ void N(e eVar) {
        eVar.A0();
    }

    public static /* synthetic */ void O(e eVar) {
        eVar.s0();
    }

    public static /* synthetic */ void P(e eVar) {
        eVar.B0();
    }

    public static /* synthetic */ void Q(e eVar) {
        eVar.u0();
    }

    public static boolean S(t1 t1Var, Q1.d dVar) {
        Q1 w;
        int u;
        if (!t1Var.t(17) || (u = (w = t1Var.w()).u()) <= 1 || u > 100) {
            return false;
        }
        for (int i2 = 0; i2 < u; i2++) {
            if (w.s(i2, dVar).o == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public static int W(TypedArray typedArray, int i2) {
        return typedArray.getInt(a4.y.S, i2);
    }

    public static /* synthetic */ void a(e eVar) {
        eVar.v0();
    }

    public static void a0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    public static /* synthetic */ void b(e eVar, View view) {
        eVar.f0(view);
    }

    public static /* synthetic */ void c(e eVar, View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        eVar.g0(view, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public static boolean c0(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    public static /* synthetic */ void d(e eVar) {
        eVar.C0();
    }

    public static /* synthetic */ boolean e(e eVar, boolean z) {
        eVar.s0 = z;
        return z;
    }

    public static /* synthetic */ TextView f(e eVar) {
        return eVar.E;
    }

    public static /* synthetic */ StringBuilder g(e eVar) {
        return eVar.G;
    }

    public static /* synthetic */ Formatter h(e eVar) {
        return eVar.H;
    }

    public static /* synthetic */ X i(e eVar) {
        return eVar.a;
    }

    public static /* synthetic */ t1 j(e eVar) {
        return eVar.m0;
    }

    public static /* synthetic */ void k(e eVar, t1 t1Var, long j2) {
        eVar.k0(t1Var, j2);
    }

    public static /* synthetic */ boolean l(e eVar) {
        return eVar.B0;
    }

    public static /* synthetic */ View m(e eVar) {
        return eVar.o;
    }

    public static /* synthetic */ View n(e eVar) {
        return eVar.n;
    }

    public static /* synthetic */ View o(e eVar) {
        return eVar.q;
    }

    public static /* synthetic */ View p(e eVar) {
        return eVar.r;
    }

    public static /* synthetic */ View q(e eVar) {
        return eVar.p;
    }

    public static /* synthetic */ ImageView r(e eVar) {
        return eVar.u;
    }

    public static void r0(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public static /* synthetic */ int s(e eVar) {
        return eVar.v0;
    }

    private void setPlaybackSpeed(float f2) {
        t1 t1Var = this.m0;
        if (t1Var == null || !t1Var.t(13)) {
            return;
        }
        t1 t1Var2 = this.m0;
        t1Var2.b(t1Var2.c().d(f2));
    }

    public static /* synthetic */ ImageView t(e eVar) {
        return eVar.v;
    }

    public static /* synthetic */ View u(e eVar) {
        return eVar.A;
    }

    public static /* synthetic */ h v(e eVar) {
        return eVar.g;
    }

    public static /* synthetic */ void w(e eVar, RecyclerView.g gVar, View view) {
        eVar.U(gVar, view);
    }

    public static /* synthetic */ void x(e eVar) {
        eVar.t0();
    }

    public static /* synthetic */ View y(e eVar) {
        return eVar.B;
    }

    public static /* synthetic */ e z(e eVar) {
        return eVar.h;
    }

    public final void A0() {
        View view;
        ImageView imageView;
        String str;
        if (d0() && this.p0 && (view = this.v) != null) {
            t1 t1Var = this.m0;
            if (!this.a.A(view)) {
                o0(false, this.v);
                return;
            }
            if (t1Var != null && t1Var.t(14)) {
                o0(true, this.v);
                this.v.setImageDrawable(t1Var.Z() ? this.R : this.S);
                imageView = this.v;
                if (t1Var.Z()) {
                    str = this.V;
                }
                imageView.setContentDescription(str);
            }
            o0(false, this.v);
            this.v.setImageDrawable(this.S);
            imageView = this.v;
            str = this.W;
            imageView.setContentDescription(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B0() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.e.B0():void");
    }

    public final void C0() {
        Z();
        o0(this.i.n() > 0, this.x);
        y0();
    }

    public void R(m mVar) {
        d4.a.e(mVar);
        this.e.add(mVar);
    }

    public boolean T(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        t1 t1Var = this.m0;
        if (t1Var == null || !c0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (t1Var.getPlaybackState() == 4 || !t1Var.t(12)) {
                return true;
            }
            t1Var.b0();
            return true;
        }
        if (keyCode == 89 && t1Var.t(11)) {
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
            if (!t1Var.t(9)) {
                return true;
            }
            t1Var.z();
            return true;
        }
        if (keyCode == 88) {
            if (!t1Var.t(7)) {
                return true;
            }
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

    public final void U(RecyclerView.g gVar, View view) {
        this.f.setAdapter(gVar);
        z0();
        this.B0 = false;
        this.l.dismiss();
        this.B0 = true;
        this.l.showAsDropDown(view, (getWidth() - this.l.getWidth()) - this.m, (-this.l.getHeight()) - this.m);
    }

    public final y V(V1 v1, int i2) {
        y.a aVar = new y.a();
        y c2 = v1.c();
        for (int i3 = 0; i3 < c2.size(); i3++) {
            V1.a aVar2 = (V1.a) c2.get(i3);
            if (aVar2.e() == i2) {
                for (int i4 = 0; i4 < aVar2.a; i4++) {
                    if (aVar2.k(i4)) {
                        z0 c3 = aVar2.c(i4);
                        if ((c3.e & 2) == 0) {
                            aVar.a(new k(v1, i3, i4, this.k.a(c3)));
                        }
                    }
                }
            }
        }
        return aVar.k();
    }

    public void X() {
        this.a.C();
    }

    public void Y() {
        this.a.F();
    }

    public final void Z() {
        this.i.k0();
        this.j.k0();
        t1 t1Var = this.m0;
        if (t1Var != null && t1Var.t(30) && this.m0.t(29)) {
            V1 p = this.m0.p();
            this.j.t0(V(p, 1));
            if (this.a.A(this.x)) {
                this.i.s0(V(p, 3));
            } else {
                this.i.s0(y.z());
            }
        }
    }

    public boolean b0() {
        return this.a.I();
    }

    public boolean d0() {
        return getVisibility() == 0;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return T(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void e0() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((m) it.next()).o(getVisibility());
        }
    }

    public final void f0(View view) {
        if (this.n0 == null) {
            return;
        }
        boolean z = !this.o0;
        this.o0 = z;
        q0(this.y, z);
        q0(this.z, this.o0);
        d dVar = this.n0;
        if (dVar != null) {
            dVar.C(this.o0);
        }
    }

    public final void g0(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.l.isShowing()) {
            z0();
            this.l.update(view, (getWidth() - this.l.getWidth()) - this.m, (-this.l.getHeight()) - this.m, -1, -1);
        }
    }

    public t1 getPlayer() {
        return this.m0;
    }

    public int getRepeatToggleModes() {
        return this.v0;
    }

    public boolean getShowShuffleButton() {
        return this.a.A(this.v);
    }

    public boolean getShowSubtitleButton() {
        return this.a.A(this.x);
    }

    public int getShowTimeoutMs() {
        return this.t0;
    }

    public boolean getShowVrButton() {
        return this.a.A(this.w);
    }

    public final void h0(int i2) {
        RecyclerView.g gVar;
        if (i2 == 0) {
            gVar = this.h;
        } else {
            if (i2 != 1) {
                this.l.dismiss();
                return;
            }
            gVar = this.j;
        }
        U(gVar, (View) d4.a.e(this.A));
    }

    public void i0(m mVar) {
        this.e.remove(mVar);
    }

    public void j0() {
        View view = this.p;
        if (view != null) {
            view.requestFocus();
        }
    }

    public final void k0(t1 t1Var, long j2) {
        if (this.r0) {
            if (t1Var.t(17) && t1Var.t(10)) {
                Q1 w = t1Var.w();
                int u = w.u();
                int i2 = 0;
                while (true) {
                    long f2 = w.s(i2, this.J).f();
                    if (j2 < f2) {
                        break;
                    }
                    if (i2 == u - 1) {
                        j2 = f2;
                        break;
                    } else {
                        j2 -= f2;
                        i2++;
                    }
                }
                t1Var.C(i2, j2);
            }
        } else if (t1Var.t(5)) {
            t1Var.seekTo(j2);
        }
        v0();
    }

    public final boolean l0() {
        t1 t1Var = this.m0;
        return (t1Var == null || !t1Var.t(1) || (this.m0.t(17) && this.m0.w().v())) ? false : true;
    }

    public void m0() {
        this.a.b0();
    }

    public void n0() {
        t0();
        s0();
        w0();
        A0();
        C0();
        u0();
        B0();
    }

    public final void o0(boolean z, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.T : this.U);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.O();
        this.p0 = true;
        if (b0()) {
            this.a.W();
        }
        n0();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.P();
        this.p0 = false;
        removeCallbacks(this.K);
        this.a.V();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.a.Q(z, i2, i3, i4, i5);
    }

    public final void p0() {
        t1 t1Var = this.m0;
        int P = (int) ((t1Var != null ? t1Var.P() : 15000L) / 1000);
        TextView textView = this.s;
        if (textView != null) {
            textView.setText(String.valueOf(P));
        }
        View view = this.q;
        if (view != null) {
            view.setContentDescription(this.c.getQuantityString(v.a, P, new Object[]{Integer.valueOf(P)}));
        }
    }

    public final void q0(ImageView imageView, boolean z) {
        String str;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(this.i0);
            str = this.k0;
        } else {
            imageView.setImageDrawable(this.j0);
            str = this.l0;
        }
        imageView.setContentDescription(str);
    }

    public final void s0() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (d0() && this.p0) {
            t1 t1Var = this.m0;
            if (t1Var != null) {
                z = t1Var.t((this.q0 && S(t1Var, this.J)) ? 10 : 5);
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
            if (z4) {
                x0();
            }
            if (z5) {
                p0();
            }
            o0(z3, this.n);
            o0(z4, this.r);
            o0(z5, this.q);
            o0(z2, this.o);
            com.google.android.exoplayer2.ui.f fVar = this.F;
            if (fVar != null) {
                fVar.setEnabled(z);
            }
        }
    }

    public void setAnimationEnabled(boolean z) {
        this.a.X(z);
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(d dVar) {
        this.n0 = dVar;
        r0(this.y, dVar != null);
        r0(this.z, dVar != null);
    }

    public void setPlayer(t1 t1Var) {
        d4.a.g(Looper.myLooper() == Looper.getMainLooper());
        d4.a.a(t1Var == null || t1Var.x() == Looper.getMainLooper());
        t1 t1Var2 = this.m0;
        if (t1Var2 == t1Var) {
            return;
        }
        if (t1Var2 != null) {
            t1Var2.l(this.d);
        }
        this.m0 = t1Var;
        if (t1Var != null) {
            t1Var.B(this.d);
        }
        n0();
    }

    public void setProgressUpdateListener(f fVar) {
    }

    public void setRepeatToggleModes(int i2) {
        this.v0 = i2;
        t1 t1Var = this.m0;
        if (t1Var != null && t1Var.t(15)) {
            int repeatMode = this.m0.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.m0.setRepeatMode(0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.m0.setRepeatMode(1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.m0.setRepeatMode(2);
            }
        }
        this.a.Y(this.u, i2 != 0);
        w0();
    }

    public void setShowFastForwardButton(boolean z) {
        this.a.Y(this.q, z);
        s0();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.q0 = z;
        B0();
    }

    public void setShowNextButton(boolean z) {
        this.a.Y(this.o, z);
        s0();
    }

    public void setShowPreviousButton(boolean z) {
        this.a.Y(this.n, z);
        s0();
    }

    public void setShowRewindButton(boolean z) {
        this.a.Y(this.r, z);
        s0();
    }

    public void setShowShuffleButton(boolean z) {
        this.a.Y(this.v, z);
        A0();
    }

    public void setShowSubtitleButton(boolean z) {
        this.a.Y(this.x, z);
    }

    public void setShowTimeoutMs(int i2) {
        this.t0 = i2;
        if (b0()) {
            this.a.W();
        }
    }

    public void setShowVrButton(boolean z) {
        this.a.Y(this.w, z);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.u0 = k0.r(i2, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.w;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            o0(onClickListener != null, this.w);
        }
    }

    public final void t0() {
        if (d0() && this.p0 && this.p != null) {
            boolean f1 = k0.f1(this.m0);
            int i2 = f1 ? q.k : q.j;
            int i3 = f1 ? w.g : w.f;
            this.p.setImageDrawable(k0.X(getContext(), this.c, i2));
            this.p.setContentDescription(this.c.getString(i3));
            o0(l0(), this.p);
        }
    }

    public final void u0() {
        t1 t1Var = this.m0;
        if (t1Var == null) {
            return;
        }
        this.h.p0(t1Var.c().a);
        this.g.m0(0, this.h.k0());
        y0();
    }

    public final void v0() {
        long j2;
        long j3;
        if (d0() && this.p0) {
            t1 t1Var = this.m0;
            if (t1Var == null || !t1Var.t(16)) {
                j2 = 0;
                j3 = 0;
            } else {
                j2 = this.A0 + t1Var.R();
                j3 = this.A0 + t1Var.a0();
            }
            TextView textView = this.E;
            if (textView != null && !this.s0) {
                textView.setText(k0.m0(this.G, this.H, j2));
            }
            com.google.android.exoplayer2.ui.f fVar = this.F;
            if (fVar != null) {
                fVar.setPosition(j2);
                this.F.setBufferedPosition(j3);
            }
            removeCallbacks(this.K);
            int playbackState = t1Var == null ? 1 : t1Var.getPlaybackState();
            if (t1Var == null || !t1Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.K, 1000L);
                return;
            }
            com.google.android.exoplayer2.ui.f fVar2 = this.F;
            long min = Math.min(fVar2 != null ? fVar2.getPreferredUpdateDelay() : 1000L, 1000 - (j2 % 1000));
            float f2 = t1Var.c().a;
            postDelayed(this.K, k0.s(f2 > 0.0f ? (long) (min / f2) : 1000L, this.u0, 1000L));
        }
    }

    public final void w0() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (d0() && this.p0 && (imageView = this.u) != null) {
            if (this.v0 == 0) {
                o0(false, imageView);
                return;
            }
            t1 t1Var = this.m0;
            if (t1Var == null || !t1Var.t(15)) {
                o0(false, this.u);
                this.u.setImageDrawable(this.L);
                this.u.setContentDescription(this.O);
                return;
            }
            o0(true, this.u);
            int repeatMode = t1Var.getRepeatMode();
            if (repeatMode == 0) {
                this.u.setImageDrawable(this.L);
                imageView2 = this.u;
                str = this.O;
            } else if (repeatMode == 1) {
                this.u.setImageDrawable(this.M);
                imageView2 = this.u;
                str = this.P;
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.u.setImageDrawable(this.N);
                imageView2 = this.u;
                str = this.Q;
            }
            imageView2.setContentDescription(str);
        }
    }

    public final void x0() {
        t1 t1Var = this.m0;
        int f0 = (int) ((t1Var != null ? t1Var.f0() : 5000L) / 1000);
        TextView textView = this.t;
        if (textView != null) {
            textView.setText(String.valueOf(f0));
        }
        View view = this.r;
        if (view != null) {
            view.setContentDescription(this.c.getQuantityString(v.b, f0, new Object[]{Integer.valueOf(f0)}));
        }
    }

    public final void y0() {
        o0(this.g.j0(), this.A);
    }

    public final void z0() {
        this.f.measure(0, 0);
        this.l.setWidth(Math.min(this.f.getMeasuredWidth(), getWidth() - (this.m * 2)));
        this.l.setHeight(Math.min(getHeight() - (this.m * 2), this.f.getMeasuredHeight()));
    }
}
