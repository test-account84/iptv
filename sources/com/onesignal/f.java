package com.onesignal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.onesignal.F1;
import com.onesignal.t;
import com.onesignal.v2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class F {
    public static final int v = Color.parseColor("#00000000");
    public static final int w = Color.parseColor("#BB000000");
    public static final int x = C1.b(4);
    public PopupWindow a;
    public Activity b;
    public int e;
    public double j;
    public boolean k;
    public boolean n;
    public A0 o;
    public v2.m p;
    public WebView q;
    public RelativeLayout r;
    public t s;
    public j t;
    public Runnable u;
    public final Handler c = new Handler();
    public int f = C1.b(24);
    public int g = C1.b(24);
    public int h = C1.b(24);
    public int i = C1.b(24);
    public boolean l = false;
    public boolean m = false;
    public int d = -1;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        public void run() {
            F1.v vVar;
            String str;
            if (F.a(F.this) == null) {
                vVar = F1.v.WARN;
                str = "WebView height update skipped, new height will be used once it is displayed.";
            } else {
                ViewGroup.LayoutParams layoutParams = F.a(F.this).getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.a;
                    F.a(F.this).setLayoutParams(layoutParams);
                    if (F.b(F.this) != null) {
                        t b = F.b(F.this);
                        F f = F.this;
                        b.i(F.p(f, this.a, F.m(f), F.o(F.this)));
                        return;
                    }
                    return;
                }
                vVar = F1.v.WARN;
                str = "WebView height update skipped because of null layoutParams, new height will be used once it is displayed.";
            }
            F1.c1(vVar, str);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ RelativeLayout.LayoutParams a;
        public final /* synthetic */ RelativeLayout.LayoutParams c;
        public final /* synthetic */ t.c d;
        public final /* synthetic */ v2.m e;

        public b(RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, t.c cVar, v2.m mVar) {
            this.a = layoutParams;
            this.c = layoutParams2;
            this.d = cVar;
            this.e = mVar;
        }

        public void run() {
            if (F.a(F.this) == null) {
                return;
            }
            F.a(F.this).setLayoutParams(this.a);
            Context applicationContext = F.q(F.this).getApplicationContext();
            F.r(F.this, applicationContext, this.c, this.d);
            F.s(F.this, applicationContext);
            F f = F.this;
            F.u(f, F.t(f));
            if (F.c(F.this) != null) {
                F f2 = F.this;
                F.d(f2, this.e, F.b(f2), F.t(F.this));
            }
            F.e(F.this);
        }
    }

    public class c implements t.b {
        public c() {
        }

        public void a() {
            F.g(F.this, false);
        }

        public void b() {
            F.g(F.this, true);
        }

        public void onDismiss() {
            if (F.c(F.this) != null) {
                F.c(F.this).c();
            }
            F.f(F.this, null);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            if (F.c(F.this) != null) {
                F.c(F.this).c();
            }
            if (F.q(F.this) == null) {
                F.i(F.this, true);
            } else {
                F.this.K(null);
                F.h(F.this, null);
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Activity a;

        public e(Activity activity) {
            this.a = activity;
        }

        public void run() {
            F.j(F.this, this.a);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ v2.l a;

        public f(v2.l lVar) {
            this.a = lVar;
        }

        public void run() {
            if (F.k(F.this) && F.t(F.this) != null) {
                F f = F.this;
                F.l(f, F.t(f), this.a);
                return;
            }
            F.n(F.this);
            v2.l lVar = this.a;
            if (lVar != null) {
                lVar.a();
            }
        }
    }

    public class g implements Animation.AnimationListener {
        public final /* synthetic */ CardView a;

        public g(CardView cardView) {
            this.a = cardView;
        }

        public void onAnimationEnd(Animation animation) {
            if (Build.VERSION.SDK_INT == 23) {
                this.a.setCardElevation(C1.b(5));
            }
            if (F.c(F.this) != null) {
                F.c(F.this).a();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ v2.l a;

        public h(v2.l lVar) {
            this.a = lVar;
        }

        public void onAnimationEnd(Animator animator) {
            F.n(F.this);
            v2.l lVar = this.a;
            if (lVar != null) {
                lVar.a();
            }
        }
    }

    public static /* synthetic */ class i {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[v2.m.values().length];
            a = iArr;
            try {
                iArr[v2.m.TOP_BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[v2.m.BOTTOM_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[v2.m.CENTER_MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[v2.m.FULL_SCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface j {
        void a();

        void b();

        void c();
    }

    public F(WebView webView, A0 a0, boolean z) {
        this.n = false;
        this.q = webView;
        this.p = a0.c();
        this.e = a0.d();
        this.j = a0.b() == null ? 0.0d : a0.b().doubleValue();
        this.k = !this.p.isBanner();
        this.n = z;
        this.o = a0;
        Q(a0);
    }

    public static /* synthetic */ WebView a(F f2) {
        return f2.q;
    }

    public static /* synthetic */ t b(F f2) {
        return f2.s;
    }

    public static /* synthetic */ j c(F f2) {
        return f2.t;
    }

    public static /* synthetic */ void d(F f2, v2.m mVar, View view, View view2) {
        f2.z(mVar, view, view2);
    }

    public static /* synthetic */ void e(F f2) {
        f2.Y();
    }

    public static /* synthetic */ void f(F f2, v2.l lVar) {
        f2.L(lVar);
    }

    public static /* synthetic */ boolean g(F f2, boolean z) {
        f2.m = z;
        return z;
    }

    public static /* synthetic */ Runnable h(F f2, Runnable runnable) {
        f2.u = runnable;
        return runnable;
    }

    public static /* synthetic */ boolean i(F f2, boolean z) {
        f2.l = z;
        return z;
    }

    public static /* synthetic */ void j(F f2, Activity activity) {
        f2.I(activity);
    }

    public static /* synthetic */ boolean k(F f2) {
        return f2.k;
    }

    public static /* synthetic */ void l(F f2, View view, v2.l lVar) {
        f2.v(view, lVar);
    }

    public static /* synthetic */ v2.m m(F f2) {
        return f2.p;
    }

    public static /* synthetic */ void n(F f2) {
        f2.C();
    }

    public static /* synthetic */ boolean o(F f2) {
        return f2.n;
    }

    public static /* synthetic */ t.c p(F f2, int i2, v2.m mVar, boolean z) {
        return f2.F(i2, mVar, z);
    }

    public static /* synthetic */ Activity q(F f2) {
        return f2.b;
    }

    public static /* synthetic */ void r(F f2, Context context, RelativeLayout.LayoutParams layoutParams, t.c cVar) {
        f2.S(context, layoutParams, cVar);
    }

    public static /* synthetic */ void s(F f2, Context context) {
        f2.T(context);
    }

    public static /* synthetic */ RelativeLayout t(F f2) {
        return f2.r;
    }

    public static /* synthetic */ void u(F f2, RelativeLayout relativeLayout) {
        f2.H(relativeLayout);
    }

    public final void A(View view, int i2, Animation.AnimationListener animationListener) {
        H1.a(view, (-i2) - this.h, 0.0f, 1000, new J1(0.1d, 8.0d), animationListener).start();
    }

    public void B() {
        if (this.l) {
            this.l = false;
            L(null);
        }
    }

    public final void C() {
        P();
        j jVar = this.t;
        if (jVar != null) {
            jVar.b();
        }
    }

    public final Animation.AnimationListener D(CardView cardView) {
        return new g(cardView);
    }

    public final CardView E(Context context) {
        CardView cardView = new CardView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.p == v2.m.FULL_SCREEN ? -1 : -2);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        cardView.setCardElevation(Build.VERSION.SDK_INT == 23 ? 0.0f : C1.b(5));
        cardView.setRadius(C1.b(8));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.setPreventCornerOverlap(false);
        cardView.setCardBackgroundColor(0);
        return cardView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.onesignal.t.c F(int r5, com.onesignal.v2.m r6, boolean r7) {
        /*
            r4 = this;
            com.onesignal.t$c r0 = new com.onesignal.t$c
            r0.<init>()
            int r1 = r4.g
            r0.d = r1
            int r1 = r4.h
            r0.b = r1
            r0.h = r7
            r0.f = r5
            int r7 = r4.N()
            r0.e = r7
            int[] r7 = com.onesignal.F.i.a
            int r1 = r6.ordinal()
            r7 = r7[r1]
            r1 = 1
            if (r7 == r1) goto L58
            r2 = 2
            if (r7 == r2) goto L49
            r3 = 3
            if (r7 == r3) goto L38
            r5 = 4
            if (r7 == r5) goto L2c
            goto L5e
        L2c:
            int r5 = r4.N()
            int r7 = r4.i
            int r3 = r4.h
            int r7 = r7 + r3
            int r5 = r5 - r7
            r0.f = r5
        L38:
            int r7 = r4.N()
            int r7 = r7 / r2
            int r5 = r5 / r2
            int r7 = r7 - r5
            int r5 = com.onesignal.F.x
            int r5 = r5 + r7
            r0.c = r5
            r0.b = r7
            r0.a = r7
            goto L5e
        L49:
            int r7 = r4.N()
            int r7 = r7 - r5
            r0.a = r7
            int r5 = r4.i
            int r7 = com.onesignal.F.x
            int r5 = r5 + r7
        L55:
            r0.c = r5
            goto L5e
        L58:
            int r5 = r4.h
            int r7 = com.onesignal.F.x
            int r5 = r5 - r7
            goto L55
        L5e:
            com.onesignal.v2$m r5 = com.onesignal.v2.m.TOP_BANNER
            if (r6 != r5) goto L63
            r1 = 0
        L63:
            r0.g = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.F.F(int, com.onesignal.v2$m, boolean):com.onesignal.t$c");
    }

    public final RelativeLayout.LayoutParams G() {
        int i2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.d, -1);
        int i3 = i.a[this.p.ordinal()];
        if (i3 == 1) {
            i2 = 10;
        } else {
            if (i3 != 2) {
                if (i3 == 3 || i3 == 4) {
                    layoutParams.addRule(13);
                }
                return layoutParams;
            }
            i2 = 12;
        }
        layoutParams.addRule(i2);
        layoutParams.addRule(14);
        return layoutParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H(android.widget.RelativeLayout r5) {
        /*
            r4 = this;
            android.widget.PopupWindow r0 = new android.widget.PopupWindow
            boolean r1 = r4.k
            r2 = -1
            if (r1 == 0) goto L9
            r3 = -1
            goto Lb
        L9:
            int r3 = r4.d
        Lb:
            if (r1 == 0) goto Le
            goto Lf
        Le:
            r2 = -2
        Lf:
            r1 = 1
            r0.<init>(r5, r3, r2, r1)
            r4.a = r0
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            r2 = 0
            r5.<init>(r2)
            r0.setBackgroundDrawable(r5)
            android.widget.PopupWindow r5 = r4.a
            r5.setTouchable(r1)
            android.widget.PopupWindow r5 = r4.a
            r5.setClippingEnabled(r2)
            boolean r5 = r4.k
            if (r5 != 0) goto L48
            int[] r5 = com.onesignal.F.i.a
            com.onesignal.v2$m r0 = r4.p
            int r0 = r0.ordinal()
            r5 = r5[r0]
            if (r5 == r1) goto L45
            r0 = 2
            if (r5 == r0) goto L42
            r0 = 3
            if (r5 == r0) goto L49
            r0 = 4
            if (r5 == r0) goto L49
            goto L48
        L42:
            r1 = 81
            goto L49
        L45:
            r1 = 49
            goto L49
        L48:
            r1 = 0
        L49:
            com.onesignal.A0 r5 = r4.o
            boolean r5 = r5.g()
            if (r5 == 0) goto L54
            r5 = 1000(0x3e8, float:1.401E-42)
            goto L56
        L54:
            r5 = 1003(0x3eb, float:1.406E-42)
        L56:
            android.widget.PopupWindow r0 = r4.a
            T.h.b(r0, r5)
            android.widget.PopupWindow r5 = r4.a
            android.app.Activity r0 = r4.b
            android.view.Window r0 = r0.getWindow()
            android.view.View r0 = r0.getDecorView()
            android.view.View r0 = r0.getRootView()
            r5.showAtLocation(r0, r1, r2, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.F.H(android.widget.RelativeLayout):void");
    }

    public final void I(Activity activity) {
        if (C1.k(activity) && this.r == null) {
            W(activity);
        } else {
            new Handler().postDelayed(new e(activity), 200L);
        }
    }

    public final void J() {
        this.r = null;
        this.s = null;
        this.q = null;
    }

    public void K(v2.l lVar) {
        t tVar = this.s;
        if (tVar != null) {
            tVar.g();
            L(lVar);
            return;
        }
        F1.b(F1.v.ERROR, "No host presenter to trigger dismiss animation, counting as dismissed already", new Throwable());
        J();
        if (lVar != null) {
            lVar.a();
        }
    }

    public final void L(v2.l lVar) {
        OSUtils.R(new f(lVar), 600);
    }

    public v2.m M() {
        return this.p;
    }

    public final int N() {
        return C1.f(this.b);
    }

    public boolean O() {
        return this.m;
    }

    public void P() {
        F1.c1(F1.v.DEBUG, "InAppMessageView removing views");
        Runnable runnable = this.u;
        if (runnable != null) {
            this.c.removeCallbacks(runnable);
            this.u = null;
        }
        t tVar = this.s;
        if (tVar != null) {
            tVar.removeAllViews();
        }
        PopupWindow popupWindow = this.a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        J();
    }

    public final void Q(A0 a0) {
        this.h = a0.e() ? C1.b(24) : 0;
        this.i = a0.e() ? C1.b(24) : 0;
        this.f = a0.f() ? C1.b(24) : 0;
        this.g = a0.f() ? C1.b(24) : 0;
    }

    public void R(j jVar) {
        this.t = jVar;
    }

    public final void S(Context context, RelativeLayout.LayoutParams layoutParams, t.c cVar) {
        t tVar = new t(context);
        this.s = tVar;
        if (layoutParams != null) {
            tVar.setLayoutParams(layoutParams);
        }
        this.s.i(cVar);
        this.s.h(new c());
        if (this.q.getParent() != null) {
            this.q.getParent().removeAllViews();
        }
        CardView E = E(context);
        E.setTag("IN_APP_MESSAGE_CARD_VIEW_TAG");
        E.addView(this.q);
        this.s.setPadding(this.f, this.h, this.g, this.i);
        this.s.setClipChildren(false);
        this.s.setClipToPadding(false);
        this.s.addView(E);
    }

    public final void T(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.r = relativeLayout;
        relativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        this.r.setClipChildren(false);
        this.r.setClipToPadding(false);
        this.r.addView(this.s);
    }

    public void U(WebView webView) {
        this.q = webView;
        webView.setBackgroundColor(0);
    }

    public final void V(v2.m mVar, RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, t.c cVar) {
        OSUtils.S(new b(layoutParams, layoutParams2, cVar, mVar));
    }

    public void W(Activity activity) {
        this.b = activity;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
        layoutParams.addRule(13);
        RelativeLayout.LayoutParams G = this.k ? G() : null;
        v2.m mVar = this.p;
        V(mVar, layoutParams, G, F(this.e, mVar, this.n));
    }

    public void X(Activity activity) {
        I(activity);
    }

    public final void Y() {
        if (this.j > 0.0d && this.u == null) {
            d dVar = new d();
            this.u = dVar;
            this.c.postDelayed(dVar, ((long) this.j) * 1000);
        }
    }

    public void Z(int i2) {
        this.e = i2;
        OSUtils.S(new a(i2));
    }

    public String toString() {
        return "InAppMessageView{currentActivity=" + this.b + ", pageWidth=" + this.d + ", pageHeight=" + this.e + ", displayDuration=" + this.j + ", hasBackground=" + this.k + ", shouldDismissWhenActive=" + this.l + ", isDragging=" + this.m + ", disableDragDismiss=" + this.n + ", displayLocation=" + this.p + ", webView=" + this.q + '}';
    }

    public final void v(View view, v2.l lVar) {
        w(view, 400, w, v, new h(lVar)).start();
    }

    public final ValueAnimator w(View view, int i2, int i3, int i4, Animator.AnimatorListener animatorListener) {
        return H1.b(view, i2, i3, i4, animatorListener);
    }

    public final void x(View view, int i2, Animation.AnimationListener animationListener) {
        H1.a(view, i2 + this.i, 0.0f, 1000, new J1(0.1d, 8.0d), animationListener).start();
    }

    public final void y(View view, View view2, Animation.AnimationListener animationListener, Animator.AnimatorListener animatorListener) {
        Animation c2 = H1.c(view, 1000, new J1(0.1d, 8.0d), animationListener);
        ValueAnimator w2 = w(view2, 400, v, w, animatorListener);
        c2.start();
        w2.start();
    }

    public final void z(v2.m mVar, View view, View view2) {
        CardView cardView = (CardView) view.findViewWithTag("IN_APP_MESSAGE_CARD_VIEW_TAG");
        Animation.AnimationListener D = D(cardView);
        int i2 = i.a[mVar.ordinal()];
        if (i2 == 1) {
            A(cardView, this.q.getHeight(), D);
            return;
        }
        if (i2 == 2) {
            x(cardView, this.q.getHeight(), D);
        } else if (i2 == 3 || i2 == 4) {
            y(view, view2, D, null);
        }
    }
}
