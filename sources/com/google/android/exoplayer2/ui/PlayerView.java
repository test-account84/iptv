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
import Z3.z;
import a4.m;
import a4.o;
import a4.q;
import a4.s;
import a4.w;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.c;
import d4.k0;
import d4.p;
import e4.C;
import e4.k;
import f4.l;
import java.util.ArrayList;
import java.util.List;
import s5.y;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class PlayerView extends FrameLayout implements a4.b {
    public static boolean B0 = false;
    public int A;
    public int A0;
    public LinearLayout B;
    public Animation C;
    public Animation D;
    public LinearLayout E;
    public Animation F;
    public Animation G;
    public Animation H;
    public RelativeLayout I;
    public boolean J;
    public boolean K;
    public String L;
    public String M;
    public Handler N;
    public Context O;
    public int P;
    public Handler Q;
    public Handler R;
    public boolean S;
    public ProgressBar T;
    public final b U;
    public final AspectRatioFrameLayout V;
    public final View W;
    public TextView a;
    public String c;
    public Activity d;
    public PlayerView e;
    public final View e0;
    public float f;
    public final boolean f0;
    public c g;
    public final ImageView g0;
    public Boolean h;
    public final SubtitleView h0;
    public Boolean i;
    public final View i0;
    public Boolean j;
    public final TextView j0;
    public Boolean k;
    public final com.google.android.exoplayer2.ui.c k0;
    public Boolean l;
    public final FrameLayout l0;
    public Boolean m;
    public final FrameLayout m0;
    public boolean n;
    public t1 n0;
    public boolean o;
    public boolean o0;
    public boolean p;
    public c.e p0;
    public boolean q;
    public boolean q0;
    public boolean r;
    public Drawable r0;
    public boolean s;
    public int s0;
    public LinearLayout t;
    public boolean t0;
    public Handler u;
    public p u0;
    public Runnable v;
    public CharSequence v0;
    public Handler w;
    public int w0;
    public Runnable x;
    public boolean x0;
    public Animation y;
    public boolean y0;
    public Animation z;
    public boolean z0;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            PlayerView.this.x();
        }
    }

    public final class b implements t1.d, View.OnLayoutChangeListener, View.OnClickListener, c.e {
        public final Q1.b a = new Q1.b();
        public Object c;

        public b() {
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void E(int i) {
            PlayerView.j(PlayerView.this);
            PlayerView.k(PlayerView.this);
            PlayerView.l(PlayerView.this);
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

        public void P() {
            if (PlayerView.g(PlayerView.this) != null) {
                PlayerView.g(PlayerView.this).setVisibility(4);
            }
        }

        public void S(t1.e eVar, t1.e eVar2, int i) {
            if (PlayerView.m(PlayerView.this) && PlayerView.n(PlayerView.this)) {
                PlayerView.this.w();
            }
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

        public void f0(V1 v1) {
            t1 t1Var = (t1) d4.a.e(PlayerView.h(PlayerView.this));
            Q1 w = t1Var.w();
            if (w.v()) {
                this.c = null;
            } else if (t1Var.p().d()) {
                Object obj = this.c;
                if (obj != null) {
                    int f = w.f(obj);
                    if (f != -1) {
                        if (t1Var.X() == w.k(f, this.a).d) {
                            return;
                        }
                    }
                    this.c = null;
                }
            } else {
                this.c = w.l(t1Var.J(), this.a, true).c;
            }
            PlayerView.i(PlayerView.this, false);
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

        public void j(C c) {
            PlayerView.b(PlayerView.this);
        }

        public void j0(boolean z, int i) {
            PlayerView.j(PlayerView.this);
            PlayerView.l(PlayerView.this);
        }

        public /* synthetic */ void k(List list) {
            v1.d(this, list);
        }

        public /* synthetic */ void l0(p1 p1Var) {
            v1.r(this, p1Var);
        }

        public /* synthetic */ void m0(t1 t1Var, t1.c cVar) {
            v1.g(this, t1Var, cVar);
        }

        public /* synthetic */ void n0(boolean z) {
            v1.i(this, z);
        }

        public void o(int i) {
            PlayerView.f(PlayerView.this);
        }

        public void onClick(View view) {
            PlayerView.e(PlayerView.this);
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            PlayerView.d((TextureView) view, PlayerView.c(PlayerView.this));
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            v1.x(this, i);
        }

        public /* synthetic */ void t(s1 s1Var) {
            v1.o(this, s1Var);
        }

        public void u(P3.f fVar) {
            if (PlayerView.a(PlayerView.this) != null) {
                PlayerView.a(PlayerView.this).setCues(fVar.a);
            }
        }

        public /* synthetic */ void z(int i) {
            v1.q(this, i);
        }
    }

    public class c {
        public final Activity a;
        public View b;

        public c(Activity activity) {
            this.a = activity;
        }

        public c a(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public c b(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static void I(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public static /* synthetic */ SubtitleView a(PlayerView playerView) {
        return playerView.h0;
    }

    public static /* synthetic */ void b(PlayerView playerView) {
        playerView.O();
    }

    public static /* synthetic */ int c(PlayerView playerView) {
        return playerView.A0;
    }

    public static /* synthetic */ void d(TextureView textureView, int i) {
        o(textureView, i);
    }

    public static /* synthetic */ void e(PlayerView playerView) {
        playerView.N();
    }

    public static /* synthetic */ void f(PlayerView playerView) {
        playerView.Q();
    }

    public static /* synthetic */ View g(PlayerView playerView) {
        return playerView.W;
    }

    public static /* synthetic */ t1 h(PlayerView playerView) {
        return playerView.n0;
    }

    public static /* synthetic */ void i(PlayerView playerView, boolean z) {
        playerView.T(z);
    }

    public static /* synthetic */ void j(PlayerView playerView) {
        playerView.P();
    }

    public static /* synthetic */ void k(PlayerView playerView) {
        playerView.S();
    }

    public static /* synthetic */ void l(PlayerView playerView) {
        playerView.R();
    }

    public static /* synthetic */ boolean m(PlayerView playerView) {
        return playerView.z();
    }

    public static /* synthetic */ boolean n(PlayerView playerView) {
        return playerView.y0;
    }

    public static void o(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    public static void r(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(k0.X(context, resources, q.f));
        imageView.setBackgroundColor(resources.getColor(o.a));
    }

    public static void s(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(k0.X(context, resources, q.f));
        imageView.setBackgroundColor(m.a(resources, o.a, null));
    }

    public final void A(boolean z) {
        if (!(z() && this.y0) && V()) {
            boolean z2 = this.k0.D() && this.k0.getShowTimeoutMs() <= 0;
            boolean J = J();
            if (z || z2 || J) {
                L(J);
            }
        }
    }

    public void B(AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public void C() {
        GLSurfaceView gLSurfaceView = this.e0;
        if (gLSurfaceView instanceof GLSurfaceView) {
            gLSurfaceView.onPause();
        }
    }

    public void D() {
        GLSurfaceView gLSurfaceView = this.e0;
        if (gLSurfaceView instanceof GLSurfaceView) {
            gLSurfaceView.onResume();
        }
    }

    public void E() {
        Handler handler = this.Q;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void F(Activity activity, PlayerView playerView, LinearLayout linearLayout, Animation animation, Animation animation2, LinearLayout linearLayout2, Animation animation3, Animation animation4, LinearLayout linearLayout3, Animation animation5, Animation animation6, RelativeLayout relativeLayout, Animation animation7, ProgressBar progressBar) {
        this.d = activity;
        this.e = playerView;
        this.Q = new Handler();
        this.R = new Handler();
        this.t = linearLayout;
        this.u = new Handler();
        this.w = new Handler();
        this.y = animation;
        this.z = animation2;
        this.B = linearLayout2;
        this.C = animation3;
        this.D = animation4;
        this.E = linearLayout3;
        this.F = animation5;
        this.G = animation6;
        this.I = relativeLayout;
        this.H = animation7;
        this.T = progressBar;
        this.g = new c(activity);
    }

    public final boolean G(R0 r0) {
        byte[] bArr = r0.k;
        if (bArr == null) {
            return false;
        }
        return H(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public final boolean H(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                B(this.V, intrinsicWidth / intrinsicHeight);
                this.g0.setImageDrawable(drawable);
                this.g0.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean J() {
        t1 t1Var = this.n0;
        if (t1Var == null) {
            return true;
        }
        int playbackState = t1Var.getPlaybackState();
        return this.x0 && (playbackState == 1 || playbackState == 4 || !this.n0.E());
    }

    public void K() {
        L(J());
    }

    public final void L(boolean z) {
        if (V()) {
            this.k0.setShowTimeoutMs(z ? 0 : this.w0);
            this.k0.J();
        }
    }

    public void M() {
        if (this.t.getVisibility() == 8) {
            this.E.startAnimation(this.F);
            this.E.setVisibility(0);
        }
    }

    public final void N() {
        if (!V() || this.n0 == null) {
            return;
        }
        if (!this.k0.D()) {
            A(true);
        } else if (this.z0) {
            this.k0.A();
        }
    }

    public final void O() {
        t1 t1Var = this.n0;
        C L = t1Var != null ? t1Var.L() : C.f;
        int i = L.a;
        int i2 = L.c;
        int i3 = L.d;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * L.e) / i2;
        View view = this.e0;
        if (view instanceof TextureView) {
            if (f > 0.0f && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            if (this.A0 != 0) {
                view.removeOnLayoutChangeListener(this.U);
            }
            this.A0 = i3;
            if (i3 != 0) {
                this.e0.addOnLayoutChangeListener(this.U);
            }
            o(this.e0, this.A0);
        }
        B(this.V, this.f0 ? 0.0f : f);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void P() {
        /*
            r4 = this;
            android.view.View r0 = r4.i0
            if (r0 == 0) goto L2b
            O2.t1 r0 = r4.n0
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.s0
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            O2.t1 r0 = r4.n0
            boolean r0 = r0.E()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = 0
        L21:
            android.view.View r0 = r4.i0
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerView.P():void");
    }

    public final void Q() {
        com.google.android.exoplayer2.ui.c cVar = this.k0;
        String str = null;
        if (cVar != null && this.o0) {
            if (cVar.getVisibility() != 0) {
                setContentDescription(getResources().getString(w.l));
                return;
            } else if (this.z0) {
                str = getResources().getString(w.e);
            }
        }
        setContentDescription(str);
    }

    public final void R() {
        if (z() && this.y0) {
            w();
        } else {
            A(false);
        }
    }

    public final void S() {
        p pVar;
        TextView textView = this.j0;
        if (textView != null) {
            CharSequence charSequence = this.v0;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.j0.setVisibility(0);
                return;
            }
            t1 t1Var = this.n0;
            p1 n = t1Var != null ? t1Var.n() : null;
            if (n == null || (pVar = this.u0) == null) {
                this.j0.setVisibility(8);
            } else {
                this.j0.setText((CharSequence) pVar.a(n).second);
                this.j0.setVisibility(0);
            }
        }
    }

    public final void T(boolean z) {
        t1 t1Var = this.n0;
        if (t1Var == null || !t1Var.t(30) || t1Var.p().d()) {
            if (this.t0) {
                return;
            }
            v();
            q();
            return;
        }
        if (z && !this.t0) {
            q();
        }
        if (t1Var.p().e(2)) {
            v();
            return;
        }
        q();
        if (U() && (G(t1Var.e0()) || H(this.r0))) {
            return;
        }
        v();
    }

    public final boolean U() {
        if (!this.q0) {
            return false;
        }
        d4.a.i(this.g0);
        return true;
    }

    public final boolean V() {
        if (!this.o0) {
            return false;
        }
        d4.a.i(this.k0);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        t1 t1Var = this.n0;
        if (t1Var != null && t1Var.d()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean y = y(keyEvent.getKeyCode());
        if ((y && V() && !this.k0.D()) || t(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            A(true);
            return true;
        }
        if (y && V()) {
            A(true);
        }
        return false;
    }

    public List getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.m0;
        if (frameLayout != null) {
            arrayList.add(new a4.a(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        com.google.android.exoplayer2.ui.c cVar = this.k0;
        if (cVar != null) {
            arrayList.add(new a4.a(cVar, 1));
        }
        return y.r(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) d4.a.j(this.l0, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.x0;
    }

    public boolean getControllerHideOnTouch() {
        return this.z0;
    }

    public int getControllerShowTimeoutMs() {
        return this.w0;
    }

    public int getCurrentWindowIndex() {
        return this.P;
    }

    public Drawable getDefaultArtwork() {
        return this.r0;
    }

    public Boolean getFullScreenValue() {
        return Boolean.valueOf(this.S);
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.m0;
    }

    public t1 getPlayer() {
        return this.n0;
    }

    public int getResizeMode() {
        d4.a.i(this.V);
        return this.V.getResizeMode();
    }

    public String getShowOrHideSubtitles() {
        return this.c;
    }

    public SubtitleView getSubtitleView() {
        return this.h0;
    }

    public boolean getUseArtwork() {
        return this.q0;
    }

    public boolean getUseController() {
        return this.o0;
    }

    public View getVideoSurfaceView() {
        return this.e0;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!V() || this.n0 == null) {
            return false;
        }
        A(true);
        return true;
    }

    public void p(int i) {
        a aVar = new a();
        this.x = aVar;
        this.w.postDelayed(aVar, i);
    }

    public boolean performClick() {
        N();
        return super.performClick();
    }

    public final void q() {
        View view = this.W;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (this.J == z) {
            return;
        }
        this.J = z;
        if (z) {
            setBackground((Drawable) null);
        } else {
            setBackgroundColor(-16777216);
        }
        requestLayout();
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.b bVar) {
        d4.a.i(this.V);
        this.V.setAspectRatioListener(bVar);
    }

    public void setContext(Context context) {
        this.O = context;
    }

    public void setControllerAutoShow(boolean z) {
        this.x0 = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.y0 = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        d4.a.i(this.k0);
        this.z0 = z;
        Q();
    }

    public void setControllerShowTimeoutMs(int i) {
        d4.a.i(this.k0);
        this.w0 = i;
        if (this.k0.D()) {
            K();
        }
    }

    public void setControllerVisibilityListener(c.e eVar) {
        d4.a.i(this.k0);
        c.e eVar2 = this.p0;
        if (eVar2 == eVar) {
            return;
        }
        if (eVar2 != null) {
            this.k0.E(eVar2);
        }
        this.p0 = eVar;
        if (eVar != null) {
            this.k0.w(eVar);
        }
    }

    public void setCurrentChannelLogo(String str) {
        this.M = str;
    }

    public void setCurrentEpgChannelID(String str) {
        this.L = str;
    }

    public void setCurrentWindowIndex(int i) {
        this.P = i;
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        d4.a.g(this.j0 != null);
        this.v0 = charSequence;
        S();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.r0 != drawable) {
            this.r0 = drawable;
            T(false);
        }
    }

    public void setEPGHandler(Handler handler) {
        this.N = handler;
    }

    public void setErrorMessageProvider(p pVar) {
        if (this.u0 != pVar) {
            this.u0 = pVar;
            S();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.t0 != z) {
            this.t0 = z;
            T(false);
        }
    }

    public void setPlayer(t1 t1Var) {
        d4.a.g(Looper.myLooper() == Looper.getMainLooper());
        d4.a.a(t1Var == null || t1Var.x() == Looper.getMainLooper());
        t1 t1Var2 = this.n0;
        if (t1Var2 == t1Var) {
            return;
        }
        if (t1Var2 != null) {
            t1Var2.l(this.U);
            if (t1Var2.t(27)) {
                View view = this.e0;
                if (view instanceof TextureView) {
                    t1Var2.K((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    t1Var2.Y((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.h0;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.n0 = t1Var;
        if (V()) {
            this.k0.setPlayer(t1Var);
        }
        P();
        S();
        T(true);
        if (t1Var == null) {
            w();
            return;
        }
        if (t1Var.t(27)) {
            View view2 = this.e0;
            if (view2 instanceof TextureView) {
                t1Var.A((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                t1Var.j((SurfaceView) view2);
            }
            O();
        }
        if (this.h0 != null && t1Var.t(28)) {
            this.h0.setCues(t1Var.r().a);
        }
        t1Var.B(this.U);
        A(false);
    }

    public void setRepeatToggleModes(int i) {
        d4.a.i(this.k0);
        this.k0.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        d4.a.i(this.V);
        this.V.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.s0 != i) {
            this.s0 = i;
            P();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        d4.a.i(this.k0);
        this.k0.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        d4.a.i(this.k0);
        this.k0.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        d4.a.i(this.k0);
        this.k0.setShowNextButton(z);
    }

    public void setShowOrHideSubtitles(String str) {
        this.c = str;
    }

    public void setShowPreviousButton(boolean z) {
        d4.a.i(this.k0);
        this.k0.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        d4.a.i(this.k0);
        this.k0.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        d4.a.i(this.k0);
        this.k0.setShowShuffleButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.W;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.g.a(s.W).b(charSequence);
    }

    public void setUseArtwork(boolean z) {
        d4.a.g((z && this.g0 == null) ? false : true);
        if (this.q0 != z) {
            this.q0 = z;
            T(false);
        }
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.ui.c cVar;
        t1 t1Var;
        boolean z2 = true;
        d4.a.g((z && this.k0 == null) ? false : true);
        if (!z && !hasOnClickListeners()) {
            z2 = false;
        }
        setClickable(z2);
        if (this.o0 == z) {
            return;
        }
        this.o0 = z;
        if (!V()) {
            com.google.android.exoplayer2.ui.c cVar2 = this.k0;
            if (cVar2 != null) {
                cVar2.A();
                cVar = this.k0;
                t1Var = null;
            }
            Q();
        }
        cVar = this.k0;
        t1Var = this.n0;
        cVar.setPlayer(t1Var);
        Q();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.e0;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public boolean t(KeyEvent keyEvent) {
        return V() && this.k0.y(keyEvent);
    }

    public void u(Boolean bool) {
        this.S = bool.booleanValue();
    }

    public final void v() {
        ImageView imageView = this.g0;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.g0.setVisibility(4);
        }
    }

    public void w() {
        com.google.android.exoplayer2.ui.c cVar = this.k0;
        if (cVar != null) {
            cVar.A();
        }
    }

    public void x() {
        if (this.E.getVisibility() == 0) {
            this.E.startAnimation(this.G);
            this.E.setVisibility(8);
        }
    }

    public final boolean y(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public final boolean z() {
        t1 t1Var = this.n0;
        return t1Var != null && t1Var.d() && this.n0.E();
    }

    public PlayerView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        boolean z7;
        SurfaceView textureView;
        super(context, attributeSet, i);
        this.c = "visible";
        this.f = -1.0f;
        Boolean bool = Boolean.FALSE;
        this.h = bool;
        this.i = bool;
        this.j = bool;
        this.k = bool;
        this.l = bool;
        this.m = bool;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.A = 0;
        this.K = false;
        this.P = 0;
        b bVar = new b();
        this.U = bVar;
        if (isInEditMode()) {
            this.V = null;
            this.W = null;
            this.e0 = null;
            this.f0 = false;
            this.g0 = null;
            this.h0 = null;
            this.i0 = null;
            this.j0 = null;
            this.k0 = null;
            this.l0 = null;
            this.m0 = null;
            ImageView imageView = new ImageView(context);
            if (k0.a >= 23) {
                s(context, getResources(), imageView);
            } else {
                r(context, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i9 = a4.u.c;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a4.y.B, i, 0);
            try {
                boolean hasValue = obtainStyledAttributes.hasValue(a4.y.L);
                int color = obtainStyledAttributes.getColor(a4.y.L, 0);
                int resourceId = obtainStyledAttributes.getResourceId(a4.y.H, i9);
                boolean z8 = obtainStyledAttributes.getBoolean(a4.y.N, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(a4.y.D, 0);
                boolean z9 = obtainStyledAttributes.getBoolean(a4.y.O, true);
                int i10 = obtainStyledAttributes.getInt(a4.y.M, 1);
                int i11 = obtainStyledAttributes.getInt(a4.y.I, 0);
                int i12 = obtainStyledAttributes.getInt(a4.y.K, 5000);
                boolean z10 = obtainStyledAttributes.getBoolean(a4.y.F, true);
                boolean z11 = obtainStyledAttributes.getBoolean(a4.y.C, true);
                int integer = obtainStyledAttributes.getInteger(a4.y.J, 0);
                this.t0 = obtainStyledAttributes.getBoolean(a4.y.G, this.t0);
                boolean z12 = obtainStyledAttributes.getBoolean(a4.y.E, true);
                obtainStyledAttributes.recycle();
                i5 = i11;
                i4 = integer;
                z3 = z12;
                z = z10;
                i3 = i12;
                i2 = resourceId;
                z2 = z11;
                z6 = z9;
                i8 = resourceId2;
                z5 = z8;
                i7 = color;
                z4 = hasValue;
                i6 = i10;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i2 = i9;
            i3 = 5000;
            z = true;
            i4 = 0;
            z2 = true;
            z3 = true;
            i5 = 0;
            i6 = 1;
            z4 = false;
            i7 = 0;
            z5 = true;
            i8 = 0;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout findViewById = findViewById(s.i);
        this.V = findViewById;
        if (findViewById != null) {
            I(findViewById, i5);
        }
        View findViewById2 = findViewById(s.O);
        this.W = findViewById2;
        if (findViewById2 != null && z4) {
            findViewById2.setBackgroundColor(i7);
        }
        if (findViewById == null || i6 == 0) {
            this.e0 = null;
            z7 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i6 == 2) {
                textureView = new TextureView(context);
            } else if (i6 == 3) {
                try {
                    int i13 = l.n;
                    this.e0 = (View) l.class.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    z7 = true;
                    this.e0.setLayoutParams(layoutParams);
                    this.e0.setOnClickListener(bVar);
                    this.e0.setClickable(false);
                    findViewById.addView(this.e0, 0);
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i6 != 4) {
                textureView = new SurfaceView(context);
            } else {
                try {
                    int i14 = k.c;
                    this.e0 = (View) k.class.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    z7 = false;
                    this.e0.setLayoutParams(layoutParams);
                    this.e0.setOnClickListener(bVar);
                    this.e0.setClickable(false);
                    findViewById.addView(this.e0, 0);
                } catch (Exception e2) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            }
            this.e0 = textureView;
            z7 = false;
            this.e0.setLayoutParams(layoutParams);
            this.e0.setOnClickListener(bVar);
            this.e0.setClickable(false);
            findViewById.addView(this.e0, 0);
        }
        this.f0 = z7;
        this.l0 = findViewById(s.a);
        this.m0 = findViewById(s.A);
        ImageView findViewById3 = findViewById(s.b);
        this.g0 = findViewById3;
        this.q0 = z5 && findViewById3 != null;
        if (i8 != 0) {
            this.r0 = E.b.getDrawable(getContext(), i8);
        }
        SubtitleView findViewById4 = findViewById(s.R);
        this.h0 = findViewById4;
        if (findViewById4 != null) {
            findViewById4.d();
            findViewById4.e();
        }
        View findViewById5 = findViewById(s.f);
        this.i0 = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setVisibility(8);
        }
        this.s0 = i4;
        TextView findViewById6 = findViewById(s.n);
        this.j0 = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setVisibility(8);
        }
        com.google.android.exoplayer2.ui.c findViewById7 = findViewById(s.j);
        View findViewById8 = findViewById(s.k);
        if (findViewById7 != null) {
            this.k0 = findViewById7;
        } else if (findViewById8 != null) {
            com.google.android.exoplayer2.ui.c cVar = new com.google.android.exoplayer2.ui.c(context, null, 0, attributeSet);
            this.k0 = cVar;
            cVar.setId(s.j);
            cVar.setLayoutParams(findViewById8.getLayoutParams());
            ViewGroup parent = findViewById8.getParent();
            int indexOfChild = parent.indexOfChild(findViewById8);
            parent.removeView(findViewById8);
            parent.addView(cVar, indexOfChild);
        } else {
            this.k0 = null;
        }
        com.google.android.exoplayer2.ui.c cVar2 = this.k0;
        this.w0 = cVar2 != null ? i3 : 0;
        this.z0 = z;
        this.x0 = z2;
        this.y0 = z3;
        this.o0 = z6 && cVar2 != null;
        if (cVar2 != null) {
            cVar2.A();
            this.k0.w(bVar);
        }
        if (z6) {
            setClickable(true);
        }
        Q();
    }
}
