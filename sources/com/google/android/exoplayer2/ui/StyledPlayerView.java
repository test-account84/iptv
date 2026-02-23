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
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.e;
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
public class StyledPlayerView extends FrameLayout implements a4.b {
    public boolean A;
    public int B;
    public final a a;
    public final AspectRatioFrameLayout c;
    public final View d;
    public final View e;
    public final boolean f;
    public final ImageView g;
    public final SubtitleView h;
    public final View i;
    public final TextView j;
    public final e k;
    public final FrameLayout l;
    public final FrameLayout m;
    public t1 n;
    public boolean o;
    public b p;
    public e.m q;
    public int r;
    public Drawable s;
    public int t;
    public boolean u;
    public p v;
    public CharSequence w;
    public int x;
    public boolean y;
    public boolean z;

    public final class a implements t1.d, View.OnLayoutChangeListener, View.OnClickListener, e.m, e.d {
        public final Q1.b a = new Q1.b();
        public Object c;

        public a() {
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void C(boolean z) {
            StyledPlayerView.h(StyledPlayerView.this);
        }

        public void E(int i) {
            StyledPlayerView.l(StyledPlayerView.this);
            StyledPlayerView.m(StyledPlayerView.this);
            StyledPlayerView.n(StyledPlayerView.this);
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
            if (StyledPlayerView.j(StyledPlayerView.this) != null) {
                StyledPlayerView.j(StyledPlayerView.this).setVisibility(4);
            }
        }

        public void S(t1.e eVar, t1.e eVar2, int i) {
            if (StyledPlayerView.o(StyledPlayerView.this) && StyledPlayerView.p(StyledPlayerView.this)) {
                StyledPlayerView.this.w();
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
            t1 t1Var = (t1) d4.a.e(StyledPlayerView.b(StyledPlayerView.this));
            Q1 w = t1Var.t(17) ? t1Var.w() : Q1.a;
            if (w.v()) {
                this.c = null;
            } else if (!t1Var.t(30) || t1Var.p().d()) {
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
            StyledPlayerView.k(StyledPlayerView.this, false);
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
            if (c.equals(C.f) || StyledPlayerView.b(StyledPlayerView.this) == null || StyledPlayerView.b(StyledPlayerView.this).getPlaybackState() == 1) {
                return;
            }
            StyledPlayerView.i(StyledPlayerView.this);
        }

        public void j0(boolean z, int i) {
            StyledPlayerView.l(StyledPlayerView.this);
            StyledPlayerView.n(StyledPlayerView.this);
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
            StyledPlayerView.f(StyledPlayerView.this);
            if (StyledPlayerView.g(StyledPlayerView.this) != null) {
                StyledPlayerView.g(StyledPlayerView.this).D(i);
            }
        }

        public void onClick(View view) {
            StyledPlayerView.e(StyledPlayerView.this);
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            StyledPlayerView.d((TextureView) view, StyledPlayerView.c(StyledPlayerView.this));
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            v1.x(this, i);
        }

        public /* synthetic */ void t(s1 s1Var) {
            v1.o(this, s1Var);
        }

        public void u(P3.f fVar) {
            if (StyledPlayerView.a(StyledPlayerView.this) != null) {
                StyledPlayerView.a(StyledPlayerView.this).setCues(fVar.a);
            }
        }

        public /* synthetic */ void z(int i) {
            v1.q(this, i);
        }
    }

    public interface b {
        void D(int i);
    }

    public interface c {
    }

    public StyledPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean E(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.r == 2) {
                    f = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                A(this.c, f);
                this.g.setScaleType(scaleType);
                this.g.setImageDrawable(drawable);
                this.g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void F(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    private boolean G() {
        t1 t1Var = this.n;
        if (t1Var == null) {
            return true;
        }
        int playbackState = t1Var.getPlaybackState();
        return this.y && !(this.n.t(17) && this.n.w().v()) && (playbackState == 1 || playbackState == 4 || !((t1) d4.a.e(this.n)).E());
    }

    private void I(boolean z) {
        if (R()) {
            this.k.setShowTimeoutMs(z ? 0 : this.x);
            this.k.m0();
        }
    }

    private void J() {
        if (!R() || this.n == null) {
            return;
        }
        if (!this.k.b0()) {
            z(true);
        } else if (this.A) {
            this.k.X();
        }
    }

    private void K() {
        t1 t1Var = this.n;
        C L = t1Var != null ? t1Var.L() : C.f;
        int i = L.a;
        int i2 = L.c;
        int i3 = L.d;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * L.e) / i2;
        View view = this.e;
        if (view instanceof TextureView) {
            if (f > 0.0f && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            if (this.B != 0) {
                view.removeOnLayoutChangeListener(this.a);
            }
            this.B = i3;
            if (i3 != 0) {
                this.e.addOnLayoutChangeListener(this.a);
            }
            q(this.e, this.B);
        }
        A(this.c, this.f ? 0.0f : f);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L() {
        /*
            r4 = this;
            android.view.View r0 = r4.i
            if (r0 == 0) goto L2b
            O2.t1 r0 = r4.n
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.t
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            O2.t1 r0 = r4.n
            boolean r0 = r0.E()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = 0
        L21:
            android.view.View r0 = r4.i
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerView.L():void");
    }

    private void M() {
        e eVar = this.k;
        String str = null;
        if (eVar != null && this.o) {
            if (!eVar.b0()) {
                setContentDescription(getResources().getString(w.l));
                return;
            } else if (this.A) {
                str = getResources().getString(w.e);
            }
        }
        setContentDescription(str);
    }

    private void N() {
        if (y() && this.z) {
            w();
        } else {
            z(false);
        }
    }

    private void O() {
        p pVar;
        TextView textView = this.j;
        if (textView != null) {
            CharSequence charSequence = this.w;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.j.setVisibility(0);
                return;
            }
            t1 t1Var = this.n;
            p1 n = t1Var != null ? t1Var.n() : null;
            if (n == null || (pVar = this.v) == null) {
                this.j.setVisibility(8);
            } else {
                this.j.setText((CharSequence) pVar.a(n).second);
                this.j.setVisibility(0);
            }
        }
    }

    private void P(boolean z) {
        t1 t1Var = this.n;
        if (t1Var == null || !t1Var.t(30) || t1Var.p().d()) {
            if (this.u) {
                return;
            }
            v();
            r();
            return;
        }
        if (z && !this.u) {
            r();
        }
        if (t1Var.p().e(2)) {
            v();
            return;
        }
        r();
        if (Q() && (D(t1Var) || E(this.s))) {
            return;
        }
        v();
    }

    private boolean Q() {
        if (this.r == 0) {
            return false;
        }
        d4.a.i(this.g);
        return true;
    }

    private boolean R() {
        if (!this.o) {
            return false;
        }
        d4.a.i(this.k);
        return true;
    }

    public static /* synthetic */ SubtitleView a(StyledPlayerView styledPlayerView) {
        return styledPlayerView.h;
    }

    public static /* synthetic */ t1 b(StyledPlayerView styledPlayerView) {
        return styledPlayerView.n;
    }

    public static /* synthetic */ int c(StyledPlayerView styledPlayerView) {
        return styledPlayerView.B;
    }

    public static /* synthetic */ void d(TextureView textureView, int i) {
        q(textureView, i);
    }

    public static /* synthetic */ void e(StyledPlayerView styledPlayerView) {
        styledPlayerView.J();
    }

    public static /* synthetic */ void f(StyledPlayerView styledPlayerView) {
        styledPlayerView.M();
    }

    public static /* synthetic */ b g(StyledPlayerView styledPlayerView) {
        return styledPlayerView.p;
    }

    public static /* synthetic */ c h(StyledPlayerView styledPlayerView) {
        styledPlayerView.getClass();
        return null;
    }

    public static /* synthetic */ void i(StyledPlayerView styledPlayerView) {
        styledPlayerView.K();
    }

    public static /* synthetic */ View j(StyledPlayerView styledPlayerView) {
        return styledPlayerView.d;
    }

    public static /* synthetic */ void k(StyledPlayerView styledPlayerView, boolean z) {
        styledPlayerView.P(z);
    }

    public static /* synthetic */ void l(StyledPlayerView styledPlayerView) {
        styledPlayerView.L();
    }

    public static /* synthetic */ void m(StyledPlayerView styledPlayerView) {
        styledPlayerView.O();
    }

    public static /* synthetic */ void n(StyledPlayerView styledPlayerView) {
        styledPlayerView.N();
    }

    public static /* synthetic */ boolean o(StyledPlayerView styledPlayerView) {
        return styledPlayerView.y();
    }

    public static /* synthetic */ boolean p(StyledPlayerView styledPlayerView) {
        return styledPlayerView.z;
    }

    private static void q(TextureView textureView, int i) {
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

    private void r() {
        View view = this.d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void s(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(k0.X(context, resources, q.f));
        imageView.setBackgroundColor(resources.getColor(o.a));
    }

    private static void t(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(k0.X(context, resources, q.f));
        imageView.setBackgroundColor(m.a(resources, o.a, null));
    }

    private void v() {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.g.setVisibility(4);
        }
    }

    private boolean x(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    private boolean y() {
        t1 t1Var = this.n;
        return t1Var != null && t1Var.t(16) && this.n.d() && this.n.E();
    }

    private void z(boolean z) {
        if (!(y() && this.z) && R()) {
            boolean z2 = this.k.b0() && this.k.getShowTimeoutMs() <= 0;
            boolean G = G();
            if (z || z2 || G) {
                I(G);
            }
        }
    }

    public void A(AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public void B() {
        GLSurfaceView gLSurfaceView = this.e;
        if (gLSurfaceView instanceof GLSurfaceView) {
            gLSurfaceView.onPause();
        }
    }

    public void C() {
        GLSurfaceView gLSurfaceView = this.e;
        if (gLSurfaceView instanceof GLSurfaceView) {
            gLSurfaceView.onResume();
        }
    }

    public final boolean D(t1 t1Var) {
        byte[] bArr;
        if (t1Var.t(18) && (bArr = t1Var.e0().k) != null) {
            return E(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
        }
        return false;
    }

    public void H() {
        I(G());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        t1 t1Var = this.n;
        if (t1Var != null && t1Var.t(16) && this.n.d()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean x = x(keyEvent.getKeyCode());
        if ((x && R() && !this.k.b0()) || u(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            z(true);
            return true;
        }
        if (x && R()) {
            z(true);
        }
        return false;
    }

    public List getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.m;
        if (frameLayout != null) {
            arrayList.add(new a4.a(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        e eVar = this.k;
        if (eVar != null) {
            arrayList.add(new a4.a(eVar, 1));
        }
        return y.r(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) d4.a.j(this.l, "exo_ad_overlay must be present for ad playback");
    }

    public int getArtworkDisplayMode() {
        return this.r;
    }

    public boolean getControllerAutoShow() {
        return this.y;
    }

    public boolean getControllerHideOnTouch() {
        return this.A;
    }

    public int getControllerShowTimeoutMs() {
        return this.x;
    }

    public Drawable getDefaultArtwork() {
        return this.s;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.m;
    }

    public t1 getPlayer() {
        return this.n;
    }

    public int getResizeMode() {
        d4.a.i(this.c);
        return this.c.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.h;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.r != 0;
    }

    public boolean getUseController() {
        return this.o;
    }

    public View getVideoSurfaceView() {
        return this.e;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!R() || this.n == null) {
            return false;
        }
        z(true);
        return true;
    }

    public boolean performClick() {
        J();
        return super.performClick();
    }

    public void setArtworkDisplayMode(int i) {
        d4.a.g(i == 0 || this.g != null);
        if (this.r != i) {
            this.r = i;
            P(false);
        }
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.b bVar) {
        d4.a.i(this.c);
        this.c.setAspectRatioListener(bVar);
    }

    public void setControllerAutoShow(boolean z) {
        this.y = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.z = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        d4.a.i(this.k);
        this.A = z;
        M();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(e.d dVar) {
        d4.a.i(this.k);
        this.k.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i) {
        d4.a.i(this.k);
        this.x = i;
        if (this.k.b0()) {
            H();
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(e.m mVar) {
        d4.a.i(this.k);
        e.m mVar2 = this.q;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            this.k.i0(mVar2);
        }
        this.q = mVar;
        if (mVar != null) {
            this.k.R(mVar);
            setControllerVisibilityListener((b) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        d4.a.g(this.j != null);
        this.w = charSequence;
        O();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.s != drawable) {
            this.s = drawable;
            P(false);
        }
    }

    public void setErrorMessageProvider(p pVar) {
        if (this.v != pVar) {
            this.v = pVar;
            O();
        }
    }

    public void setFullscreenButtonClickListener(c cVar) {
        d4.a.i(this.k);
        this.k.setOnFullScreenModeChangedListener(this.a);
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.u != z) {
            this.u = z;
            P(false);
        }
    }

    public void setPlayer(t1 t1Var) {
        d4.a.g(Looper.myLooper() == Looper.getMainLooper());
        d4.a.a(t1Var == null || t1Var.x() == Looper.getMainLooper());
        t1 t1Var2 = this.n;
        if (t1Var2 == t1Var) {
            return;
        }
        if (t1Var2 != null) {
            t1Var2.l(this.a);
            if (t1Var2.t(27)) {
                View view = this.e;
                if (view instanceof TextureView) {
                    t1Var2.K((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    t1Var2.Y((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.h;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.n = t1Var;
        if (R()) {
            this.k.setPlayer(t1Var);
        }
        L();
        O();
        P(true);
        if (t1Var == null) {
            w();
            return;
        }
        if (t1Var.t(27)) {
            View view2 = this.e;
            if (view2 instanceof TextureView) {
                t1Var.A((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                t1Var.j((SurfaceView) view2);
            }
            if (t1Var.p().f(2)) {
                K();
            }
        }
        if (this.h != null && t1Var.t(28)) {
            this.h.setCues(t1Var.r().a);
        }
        t1Var.B(this.a);
        z(false);
    }

    public void setRepeatToggleModes(int i) {
        d4.a.i(this.k);
        this.k.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        d4.a.i(this.c);
        this.c.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.t != i) {
            this.t = i;
            L();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        d4.a.i(this.k);
        this.k.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        d4.a.i(this.k);
        this.k.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        d4.a.i(this.k);
        this.k.setShowNextButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        d4.a.i(this.k);
        this.k.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        d4.a.i(this.k);
        this.k.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        d4.a.i(this.k);
        this.k.setShowShuffleButton(z);
    }

    public void setShowSubtitleButton(boolean z) {
        d4.a.i(this.k);
        this.k.setShowSubtitleButton(z);
    }

    public void setShowVrButton(boolean z) {
        d4.a.i(this.k);
        this.k.setShowVrButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.d;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    @Deprecated
    public void setUseArtwork(boolean z) {
        setArtworkDisplayMode(!z ? 1 : 0);
    }

    public void setUseController(boolean z) {
        e eVar;
        t1 t1Var;
        boolean z2 = true;
        d4.a.g((z && this.k == null) ? false : true);
        if (!z && !hasOnClickListeners()) {
            z2 = false;
        }
        setClickable(z2);
        if (this.o == z) {
            return;
        }
        this.o = z;
        if (!R()) {
            e eVar2 = this.k;
            if (eVar2 != null) {
                eVar2.X();
                eVar = this.k;
                t1Var = null;
            }
            M();
        }
        eVar = this.k;
        t1Var = this.n;
        eVar.setPlayer(t1Var);
        M();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.e;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public boolean u(KeyEvent keyEvent) {
        return R() && this.k.T(keyEvent);
    }

    public void w() {
        e eVar = this.k;
        if (eVar != null) {
            eVar.X();
        }
    }

    public StyledPlayerView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        boolean z6;
        boolean z7;
        SurfaceView textureView;
        super(context, attributeSet, i);
        a aVar = new a();
        this.a = aVar;
        if (isInEditMode()) {
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = false;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            ImageView imageView = new ImageView(context);
            if (k0.a >= 23) {
                t(context, getResources(), imageView);
            } else {
                s(context, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i10 = a4.u.e;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a4.y.c0, i, 0);
            try {
                boolean hasValue = obtainStyledAttributes.hasValue(a4.y.n0);
                int color = obtainStyledAttributes.getColor(a4.y.n0, 0);
                int resourceId = obtainStyledAttributes.getResourceId(a4.y.j0, i10);
                boolean z8 = obtainStyledAttributes.getBoolean(a4.y.p0, true);
                int i11 = obtainStyledAttributes.getInt(a4.y.d0, 1);
                int resourceId2 = obtainStyledAttributes.getResourceId(a4.y.f0, 0);
                boolean z9 = obtainStyledAttributes.getBoolean(a4.y.q0, true);
                int i12 = obtainStyledAttributes.getInt(a4.y.o0, 1);
                int i13 = obtainStyledAttributes.getInt(a4.y.k0, 0);
                int i14 = obtainStyledAttributes.getInt(a4.y.m0, 5000);
                z2 = obtainStyledAttributes.getBoolean(a4.y.h0, true);
                boolean z10 = obtainStyledAttributes.getBoolean(a4.y.e0, true);
                int integer = obtainStyledAttributes.getInteger(a4.y.l0, 0);
                this.u = obtainStyledAttributes.getBoolean(a4.y.i0, this.u);
                boolean z11 = obtainStyledAttributes.getBoolean(a4.y.g0, true);
                obtainStyledAttributes.recycle();
                z = z10;
                i5 = integer;
                z6 = z11;
                i4 = i13;
                i3 = i14;
                i2 = resourceId;
                z5 = z9;
                i9 = i11;
                i8 = color;
                i7 = resourceId2;
                z4 = z8;
                z3 = hasValue;
                i6 = i12;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i2 = i10;
            i3 = 5000;
            i4 = 0;
            z = true;
            z2 = true;
            i5 = 0;
            i6 = 1;
            i7 = 0;
            z3 = false;
            i8 = 0;
            z4 = true;
            i9 = 1;
            z5 = true;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout findViewById = findViewById(s.i);
        this.c = findViewById;
        if (findViewById != null) {
            F(findViewById, i4);
        }
        View findViewById2 = findViewById(s.O);
        this.d = findViewById2;
        if (findViewById2 != null && z3) {
            findViewById2.setBackgroundColor(i8);
        }
        if (findViewById == null || i6 == 0) {
            this.e = null;
            z7 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i6 == 2) {
                textureView = new TextureView(context);
            } else if (i6 == 3) {
                try {
                    int i15 = l.n;
                    this.e = (View) l.class.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    z7 = true;
                    this.e.setLayoutParams(layoutParams);
                    this.e.setOnClickListener(aVar);
                    this.e.setClickable(false);
                    findViewById.addView(this.e, 0);
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i6 != 4) {
                textureView = new SurfaceView(context);
            } else {
                try {
                    int i16 = k.c;
                    this.e = (View) k.class.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    z7 = false;
                    this.e.setLayoutParams(layoutParams);
                    this.e.setOnClickListener(aVar);
                    this.e.setClickable(false);
                    findViewById.addView(this.e, 0);
                } catch (Exception e2) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            }
            this.e = textureView;
            z7 = false;
            this.e.setLayoutParams(layoutParams);
            this.e.setOnClickListener(aVar);
            this.e.setClickable(false);
            findViewById.addView(this.e, 0);
        }
        this.f = z7;
        this.l = findViewById(s.a);
        this.m = findViewById(s.A);
        ImageView findViewById3 = findViewById(s.b);
        this.g = findViewById3;
        this.r = (!z4 || i9 == 0 || findViewById3 == null) ? 0 : i9;
        if (i7 != 0) {
            this.s = E.b.getDrawable(getContext(), i7);
        }
        SubtitleView findViewById4 = findViewById(s.R);
        this.h = findViewById4;
        if (findViewById4 != null) {
            findViewById4.d();
            findViewById4.e();
        }
        View findViewById5 = findViewById(s.f);
        this.i = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setVisibility(8);
        }
        this.t = i5;
        TextView findViewById6 = findViewById(s.n);
        this.j = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setVisibility(8);
        }
        e findViewById7 = findViewById(s.j);
        View findViewById8 = findViewById(s.k);
        if (findViewById7 != null) {
            this.k = findViewById7;
        } else if (findViewById8 != null) {
            e eVar = new e(context, null, 0, attributeSet);
            this.k = eVar;
            eVar.setId(s.j);
            eVar.setLayoutParams(findViewById8.getLayoutParams());
            ViewGroup parent = findViewById8.getParent();
            int indexOfChild = parent.indexOfChild(findViewById8);
            parent.removeView(findViewById8);
            parent.addView(eVar, indexOfChild);
        } else {
            this.k = null;
        }
        e eVar2 = this.k;
        this.x = eVar2 != null ? i3 : 0;
        this.A = z2;
        this.y = z;
        this.z = z6;
        this.o = z5 && eVar2 != null;
        if (eVar2 != null) {
            eVar2.Y();
            this.k.R(aVar);
        }
        if (z5) {
            setClickable(true);
        }
        M();
    }

    public void setControllerVisibilityListener(b bVar) {
        this.p = bVar;
        if (bVar != null) {
            setControllerVisibilityListener((e.m) null);
        }
    }
}
