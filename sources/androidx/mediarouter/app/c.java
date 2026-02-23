package androidx.mediarouter.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.mediarouter.app.OverlayListView;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends androidx.appcompat.app.a {
    public static final boolean t0 = Log.isLoggable("MediaRouteCtrlDialog", 3);
    public static final int u0 = (int) TimeUnit.SECONDS.toMillis(30);
    public RelativeLayout A;
    public LinearLayout B;
    public View C;
    public OverlayListView D;
    public r E;
    public List F;
    public Set G;
    public Set H;
    public Set I;
    public SeekBar J;
    public q K;
    public L.h L;
    public int M;
    public int N;
    public int O;
    public final int P;
    public Map Q;
    public MediaControllerCompat R;
    public o S;
    public PlaybackStateCompat T;
    public MediaDescriptionCompat U;
    public n V;
    public Bitmap W;
    public Uri X;
    public boolean Y;
    public Bitmap Z;
    public final L c;
    public final p d;
    public final L.h e;
    public int e0;
    public Context f;
    public boolean f0;
    public boolean g;
    public boolean g0;
    public boolean h;
    public boolean h0;
    public int i;
    public boolean i0;
    public View j;
    public boolean j0;
    public Button k;
    public int k0;
    public Button l;
    public int l0;
    public ImageButton m;
    public int m0;
    public ImageButton n;
    public Interpolator n0;
    public MediaRouteExpandCollapseButton o;
    public Interpolator o0;
    public FrameLayout p;
    public Interpolator p0;
    public LinearLayout q;
    public Interpolator q0;
    public FrameLayout r;
    public final AccessibilityManager r0;
    public FrameLayout s;
    public Runnable s0;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public boolean x;
    public final boolean y;
    public LinearLayout z;

    public class a implements OverlayListView.a.a {
        public final /* synthetic */ L.h a;

        public a(L.h hVar) {
            this.a = hVar;
        }

        public void a() {
            c.this.I.remove(this.a);
            c.this.E.notifyDataSetChanged();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public void onGlobalLayout() {
            c.this.D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c.this.F();
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        public void onAnimationEnd(Animation animation) {
            c.this.o(true);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            c.this.E();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            PendingIntent sessionActivity;
            MediaControllerCompat mediaControllerCompat = c.this.R;
            if (mediaControllerCompat == null || (sessionActivity = mediaControllerCompat.getSessionActivity()) == null) {
                return;
            }
            try {
                sessionActivity.send();
                c.this.dismiss();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("MediaRouteCtrlDialog", sessionActivity + " was not sent, it had been canceled.");
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            c cVar = c.this;
            boolean z = !cVar.h0;
            cVar.h0 = z;
            if (z) {
                cVar.D.setVisibility(0);
            }
            c.this.z();
            c.this.I(true);
        }
    }

    public class i implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ boolean a;

        public i(boolean z) {
            this.a = z;
        }

        public void onGlobalLayout() {
            c.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c cVar = c.this;
            if (cVar.i0) {
                cVar.j0 = true;
            } else {
                cVar.J(this.a);
            }
        }
    }

    public class j extends Animation {
        public final /* synthetic */ int a;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;

        public j(int i, int i2, View view) {
            this.a = i;
            this.c = i2;
            this.d = view;
        }

        public void applyTransformation(float f, Transformation transformation) {
            c.C(this.d, this.a - ((int) ((r3 - this.c) * f)));
        }
    }

    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ Map a;
        public final /* synthetic */ Map c;

        public k(Map map, Map map2) {
            this.a = map;
            this.c = map2;
        }

        public void onGlobalLayout() {
            c.this.D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c.this.i(this.a, this.c);
        }
    }

    public class l implements Animation.AnimationListener {
        public l() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            c.this.D.b();
            c cVar = c.this;
            cVar.D.postDelayed(cVar.s0, cVar.k0);
        }
    }

    public final class m implements View.OnClickListener {
        public m() {
        }

        public void onClick(View view) {
            PlaybackStateCompat playbackStateCompat;
            int id = view.getId();
            if (id == 16908313 || id == 16908314) {
                if (c.this.e.C()) {
                    c.this.c.z(id == 16908313 ? 2 : 1);
                }
            } else {
                if (id == t0.f.C) {
                    c cVar = c.this;
                    if (cVar.R == null || (playbackStateCompat = cVar.T) == null) {
                        return;
                    }
                    int i = 0;
                    int i2 = playbackStateCompat.getState() != 3 ? 0 : 1;
                    if (i2 != 0 && c.this.v()) {
                        c.this.R.getTransportControls().pause();
                        i = t0.j.l;
                    } else if (i2 != 0 && c.this.x()) {
                        c.this.R.getTransportControls().stop();
                        i = t0.j.n;
                    } else if (i2 == 0 && c.this.w()) {
                        c.this.R.getTransportControls().play();
                        i = t0.j.m;
                    }
                    AccessibilityManager accessibilityManager = c.this.r0;
                    if (accessibilityManager == null || !accessibilityManager.isEnabled() || i == 0) {
                        return;
                    }
                    AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
                    obtain.setPackageName(c.this.f.getPackageName());
                    obtain.setClassName(m.class.getName());
                    obtain.getText().add(c.this.f.getString(i));
                    c.this.r0.sendAccessibilityEvent(obtain);
                    return;
                }
                if (id != t0.f.A) {
                    return;
                }
            }
            c.this.dismiss();
        }
    }

    public class n extends AsyncTask {
        public final Bitmap a;
        public final Uri b;
        public int c;
        public long d;

        public n() {
            MediaDescriptionCompat mediaDescriptionCompat = c.this.U;
            Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
            if (c.s(iconBitmap)) {
                Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
                iconBitmap = null;
            }
            this.a = iconBitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = c.this.U;
            this.b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00e8  */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r10) {
            /*
                Method dump skipped, instructions count: 285
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.n.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        public Bitmap b() {
            return this.a;
        }

        public Uri c() {
            return this.b;
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            c cVar = c.this;
            cVar.V = null;
            if (O.c.a(cVar.W, this.a) && O.c.a(c.this.X, this.b)) {
                return;
            }
            c cVar2 = c.this;
            cVar2.W = this.a;
            cVar2.Z = bitmap;
            cVar2.X = this.b;
            cVar2.e0 = this.c;
            cVar2.Y = true;
            c.this.G(SystemClock.uptimeMillis() - this.d > 120);
        }

        public final InputStream e(Uri uri) {
            InputStream openInputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                openInputStream = c.this.f.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                int i = c.u0;
                openConnection.setConnectTimeout(i);
                openConnection.setReadTimeout(i);
                openInputStream = openConnection.getInputStream();
            }
            if (openInputStream == null) {
                return null;
            }
            return new BufferedInputStream(openInputStream);
        }

        public void onPreExecute() {
            this.d = SystemClock.uptimeMillis();
            c.this.m();
        }
    }

    public final class o extends MediaControllerCompat.Callback {
        public o() {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            c.this.U = mediaMetadataCompat == null ? null : mediaMetadataCompat.getDescription();
            c.this.H();
            c.this.G(false);
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            c cVar = c.this;
            cVar.T = playbackStateCompat;
            cVar.G(false);
        }

        public void onSessionDestroyed() {
            c cVar = c.this;
            MediaControllerCompat mediaControllerCompat = cVar.R;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.unregisterCallback(cVar.S);
                c.this.R = null;
            }
        }
    }

    public final class p extends L.a {
        public p() {
        }

        public void onRouteChanged(L l, L.h hVar) {
            c.this.G(true);
        }

        public void onRouteUnselected(L l, L.h hVar) {
            c.this.G(false);
        }

        public void onRouteVolumeChanged(L l, L.h hVar) {
            SeekBar seekBar = (SeekBar) c.this.Q.get(hVar);
            int s = hVar.s();
            if (c.t0) {
                Log.d("MediaRouteCtrlDialog", "onRouteVolumeChanged(), route.getVolume:" + s);
            }
            if (seekBar == null || c.this.L == hVar) {
                return;
            }
            seekBar.setProgress(s);
        }
    }

    public class q implements SeekBar.OnSeekBarChangeListener {
        public final Runnable a = new a();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                c cVar = c.this;
                if (cVar.L != null) {
                    cVar.L = null;
                    if (cVar.f0) {
                        cVar.G(cVar.g0);
                    }
                }
            }
        }

        public q() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                L.h hVar = (L.h) seekBar.getTag();
                if (c.t0) {
                    Log.d("MediaRouteCtrlDialog", "onProgressChanged(): calling MediaRouter.RouteInfo.requestSetVolume(" + i + ")");
                }
                hVar.G(i);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            c cVar = c.this;
            if (cVar.L != null) {
                cVar.J.removeCallbacks(this.a);
            }
            c.this.L = (L.h) seekBar.getTag();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            c.this.J.postDelayed(this.a, 500L);
        }
    }

    public class r extends ArrayAdapter {
        public final float a;

        public r(Context context, List list) {
            super(context, 0, list);
            this.a = androidx.mediarouter.app.i.h(context);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(t0.i.i, viewGroup, false);
            } else {
                c.this.N(view);
            }
            L.h hVar = (L.h) getItem(i);
            if (hVar != null) {
                boolean x = hVar.x();
                TextView findViewById = view.findViewById(t0.f.N);
                findViewById.setEnabled(x);
                findViewById.setText(hVar.m());
                MediaRouteVolumeSlider findViewById2 = view.findViewById(t0.f.Y);
                androidx.mediarouter.app.i.w(viewGroup.getContext(), findViewById2, c.this.D);
                findViewById2.setTag(hVar);
                c.this.Q.put(hVar, findViewById2);
                findViewById2.c(!x);
                findViewById2.setEnabled(x);
                if (x) {
                    if (c.this.y(hVar)) {
                        findViewById2.setMax(hVar.u());
                        findViewById2.setProgress(hVar.s());
                        findViewById2.setOnSeekBarChangeListener(c.this.K);
                    } else {
                        findViewById2.setMax(100);
                        findViewById2.setProgress(100);
                        findViewById2.setEnabled(false);
                    }
                }
                view.findViewById(t0.f.X).setAlpha(x ? 255 : (int) (this.a * 255.0f));
                view.findViewById(t0.f.Z).setVisibility(c.this.I.contains(hVar) ? 4 : 0);
                Set set = c.this.G;
                if (set != null && set.contains(hVar)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnimation.setDuration(0L);
                    alphaAnimation.setFillEnabled(true);
                    alphaAnimation.setFillAfter(true);
                    view.clearAnimation();
                    view.startAnimation(alphaAnimation);
                }
            }
            return view;
        }

        public boolean isEnabled(int i) {
            return false;
        }
    }

    public c(Context context) {
        this(context, 0);
    }

    public static void C(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static boolean O(Uri uri, Uri uri2) {
        if (uri == null || !uri.equals(uri2)) {
            return uri == null && uri2 == null;
        }
        return true;
    }

    private void j(View view, int i2) {
        j jVar = new j(q(view), i2, view);
        jVar.setDuration(this.k0);
        jVar.setInterpolator(this.n0);
        view.startAnimation(jVar);
    }

    public static int q(View view) {
        return view.getLayoutParams().height;
    }

    public static boolean s(Bitmap bitmap) {
        return bitmap != null && bitmap.isRecycled();
    }

    public View A(Bundle bundle) {
        return null;
    }

    public final void B(boolean z) {
        List l2 = this.e.l();
        if (l2.isEmpty()) {
            this.F.clear();
        } else if (!androidx.mediarouter.app.f.i(this.F, l2)) {
            HashMap e2 = z ? androidx.mediarouter.app.f.e(this.D, this.E) : null;
            HashMap d2 = z ? androidx.mediarouter.app.f.d(this.f, this.D, this.E) : null;
            this.G = androidx.mediarouter.app.f.f(this.F, l2);
            this.H = androidx.mediarouter.app.f.g(this.F, l2);
            this.F.addAll(0, this.G);
            this.F.removeAll(this.H);
            this.E.notifyDataSetChanged();
            if (z && this.h0 && this.G.size() + this.H.size() > 0) {
                h(e2, d2);
                return;
            } else {
                this.G = null;
                this.H = null;
                return;
            }
        }
        this.E.notifyDataSetChanged();
    }

    public final void D(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.R;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.S);
            this.R = null;
        }
        if (token != null && this.h) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f, token);
            this.R = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(this.S);
            MediaMetadataCompat metadata = this.R.getMetadata();
            this.U = metadata != null ? metadata.getDescription() : null;
            this.T = this.R.getPlaybackState();
            H();
            G(false);
        }
    }

    public void E() {
        l(true);
        this.D.requestLayout();
        this.D.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public void F() {
        Set set = this.G;
        if (set == null || set.size() == 0) {
            o(true);
        } else {
            n();
        }
    }

    public void G(boolean z) {
        if (this.L != null) {
            this.f0 = true;
            this.g0 = z | this.g0;
            return;
        }
        this.f0 = false;
        this.g0 = false;
        if (!this.e.C() || this.e.w()) {
            dismiss();
            return;
        }
        if (this.g) {
            this.w.setText(this.e.m());
            this.k.setVisibility(this.e.a() ? 0 : 8);
            if (this.j == null && this.Y) {
                if (s(this.Z)) {
                    Log.w("MediaRouteCtrlDialog", "Can't set artwork image with recycled bitmap: " + this.Z);
                } else {
                    this.t.setImageBitmap(this.Z);
                    this.t.setBackgroundColor(this.e0);
                }
                m();
            }
            M();
            L();
            I(z);
        }
    }

    public void H() {
        if (this.j == null && u()) {
            if (!t() || this.y) {
                n nVar = this.V;
                if (nVar != null) {
                    nVar.cancel(true);
                }
                n nVar2 = new n();
                this.V = nVar2;
                nVar2.execute(new Void[0]);
            }
        }
    }

    public void I(boolean z) {
        this.r.requestLayout();
        this.r.getViewTreeObserver().addOnGlobalLayoutListener(new i(z));
    }

    public void J(boolean z) {
        int i2;
        Bitmap bitmap;
        int q2 = q(this.z);
        C(this.z, -1);
        K(k());
        View decorView = getWindow().getDecorView();
        decorView.measure(View.MeasureSpec.makeMeasureSpec(getWindow().getAttributes().width, 1073741824), 0);
        C(this.z, q2);
        if (this.j == null && (this.t.getDrawable() instanceof BitmapDrawable) && (bitmap = this.t.getDrawable().getBitmap()) != null) {
            i2 = p(bitmap.getWidth(), bitmap.getHeight());
            this.t.setScaleType(bitmap.getWidth() >= bitmap.getHeight() ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.FIT_CENTER);
        } else {
            i2 = 0;
        }
        int r2 = r(k());
        int size = this.F.size();
        int size2 = t() ? this.N * this.e.l().size() : 0;
        if (size > 0) {
            size2 += this.P;
        }
        int min = Math.min(size2, this.O);
        if (!this.h0) {
            min = 0;
        }
        int max = Math.max(i2, min) + r2;
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int height = rect.height() - (this.q.getMeasuredHeight() - this.r.getMeasuredHeight());
        if (this.j != null || i2 <= 0 || max > height) {
            if (q(this.D) + this.z.getMeasuredHeight() >= this.r.getMeasuredHeight()) {
                this.t.setVisibility(8);
            }
            max = min + r2;
            i2 = 0;
        } else {
            this.t.setVisibility(0);
            C(this.t, i2);
        }
        if (!k() || max > height) {
            this.A.setVisibility(8);
        } else {
            this.A.setVisibility(0);
        }
        K(this.A.getVisibility() == 0);
        int r3 = r(this.A.getVisibility() == 0);
        int max2 = Math.max(i2, min) + r3;
        if (max2 > height) {
            min -= max2 - height;
        } else {
            height = max2;
        }
        this.z.clearAnimation();
        this.D.clearAnimation();
        this.r.clearAnimation();
        LinearLayout linearLayout = this.z;
        if (z) {
            j(linearLayout, r3);
            j(this.D, min);
            j(this.r, height);
        } else {
            C(linearLayout, r3);
            C(this.D, min);
            C(this.r, height);
        }
        C(this.p, rect.height());
        B(z);
    }

    public final void K(boolean z) {
        int i2 = 0;
        this.C.setVisibility((this.B.getVisibility() == 0 && z) ? 0 : 8);
        LinearLayout linearLayout = this.z;
        if (this.B.getVisibility() == 8 && !z) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void L() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.L():void");
    }

    public final void M() {
        if (!this.y && t()) {
            this.B.setVisibility(8);
            this.h0 = true;
            this.D.setVisibility(0);
            z();
            I(false);
            return;
        }
        if ((this.h0 && !this.y) || !y(this.e)) {
            this.B.setVisibility(8);
        } else if (this.B.getVisibility() == 8) {
            this.B.setVisibility(0);
            this.J.setMax(this.e.u());
            this.J.setProgress(this.e.s());
            this.o.setVisibility(t() ? 0 : 8);
        }
    }

    public void N(View view) {
        C(view.findViewById(t0.f.Z), this.N);
        View findViewById = view.findViewById(t0.f.X);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int i2 = this.M;
        layoutParams.width = i2;
        layoutParams.height = i2;
        findViewById.setLayoutParams(layoutParams);
    }

    public final void h(Map map, Map map2) {
        this.D.setEnabled(false);
        this.D.requestLayout();
        this.i0 = true;
        this.D.getViewTreeObserver().addOnGlobalLayoutListener(new k(map, map2));
    }

    public void i(Map map, Map map2) {
        OverlayListView.a d2;
        Set set = this.G;
        if (set == null || this.H == null) {
            return;
        }
        int size = set.size() - this.H.size();
        l lVar = new l();
        int firstVisiblePosition = this.D.getFirstVisiblePosition();
        boolean z = false;
        for (int i2 = 0; i2 < this.D.getChildCount(); i2++) {
            View childAt = this.D.getChildAt(i2);
            L.h hVar = (L.h) this.E.getItem(firstVisiblePosition + i2);
            Rect rect = (Rect) map.get(hVar);
            int top = childAt.getTop();
            int i3 = rect != null ? rect.top : (this.N * size) + top;
            AnimationSet animationSet = new AnimationSet(true);
            Set set2 = this.G;
            if (set2 != null && set2.contains(hVar)) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                alphaAnimation.setDuration(this.l0);
                animationSet.addAnimation(alphaAnimation);
                i3 = top;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3 - top, 0.0f);
            translateAnimation.setDuration(this.k0);
            animationSet.addAnimation(translateAnimation);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setInterpolator(this.n0);
            if (!z) {
                animationSet.setAnimationListener(lVar);
                z = true;
            }
            childAt.clearAnimation();
            childAt.startAnimation(animationSet);
            map.remove(hVar);
            map2.remove(hVar);
        }
        for (Map.Entry entry : map2.entrySet()) {
            L.h hVar2 = (L.h) entry.getKey();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
            Rect rect2 = (Rect) map.get(hVar2);
            if (this.H.contains(hVar2)) {
                d2 = new OverlayListView.a(bitmapDrawable, rect2).c(1.0f, 0.0f).e(this.m0).f(this.n0);
            } else {
                d2 = new OverlayListView.a(bitmapDrawable, rect2).g(this.N * size).e(this.k0).f(this.n0).d(new a(hVar2));
                this.I.add(hVar2);
            }
            this.D.a(d2);
        }
    }

    public final boolean k() {
        return this.j == null && !(this.U == null && this.T == null);
    }

    public void l(boolean z) {
        Set set;
        int firstVisiblePosition = this.D.getFirstVisiblePosition();
        for (int i2 = 0; i2 < this.D.getChildCount(); i2++) {
            View childAt = this.D.getChildAt(i2);
            L.h hVar = (L.h) this.E.getItem(firstVisiblePosition + i2);
            if (!z || (set = this.G) == null || !set.contains(hVar)) {
                childAt.findViewById(t0.f.Z).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0L);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0L);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        this.D.c();
        if (z) {
            return;
        }
        o(false);
    }

    public void m() {
        this.Y = false;
        this.Z = null;
        this.e0 = 0;
    }

    public final void n() {
        c cVar = new c();
        int firstVisiblePosition = this.D.getFirstVisiblePosition();
        boolean z = false;
        for (int i2 = 0; i2 < this.D.getChildCount(); i2++) {
            View childAt = this.D.getChildAt(i2);
            if (this.G.contains((L.h) this.E.getItem(firstVisiblePosition + i2))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(this.l0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z) {
                    alphaAnimation.setAnimationListener(cVar);
                    z = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }

    public void o(boolean z) {
        this.G = null;
        this.H = null;
        this.i0 = false;
        if (this.j0) {
            this.j0 = false;
            I(z);
        }
        this.D.setEnabled(true);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = true;
        this.c.b(K.c, this.d, 2);
        D(this.c.k());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(17170445);
        setContentView(t0.i.h);
        findViewById(16908315).setVisibility(8);
        m mVar = new m();
        FrameLayout findViewById = findViewById(t0.f.J);
        this.p = findViewById;
        findViewById.setOnClickListener(new e());
        LinearLayout findViewById2 = findViewById(t0.f.I);
        this.q = findViewById2;
        findViewById2.setOnClickListener(new f());
        int d2 = androidx.mediarouter.app.i.d(this.f);
        Button findViewById3 = findViewById(16908314);
        this.k = findViewById3;
        findViewById3.setText(t0.j.h);
        this.k.setTextColor(d2);
        this.k.setOnClickListener(mVar);
        Button findViewById4 = findViewById(16908313);
        this.l = findViewById4;
        findViewById4.setText(t0.j.o);
        this.l.setTextColor(d2);
        this.l.setOnClickListener(mVar);
        this.w = findViewById(t0.f.N);
        ImageButton findViewById5 = findViewById(t0.f.A);
        this.n = findViewById5;
        findViewById5.setOnClickListener(mVar);
        this.s = findViewById(t0.f.G);
        this.r = findViewById(t0.f.H);
        g gVar = new g();
        ImageView findViewById6 = findViewById(t0.f.a);
        this.t = findViewById6;
        findViewById6.setOnClickListener(gVar);
        findViewById(t0.f.F).setOnClickListener(gVar);
        this.z = findViewById(t0.f.M);
        this.C = findViewById(t0.f.B);
        this.A = findViewById(t0.f.U);
        this.u = findViewById(t0.f.E);
        this.v = findViewById(t0.f.D);
        ImageButton findViewById7 = findViewById(t0.f.C);
        this.m = findViewById7;
        findViewById7.setOnClickListener(mVar);
        LinearLayout findViewById8 = findViewById(t0.f.V);
        this.B = findViewById8;
        findViewById8.setVisibility(8);
        SeekBar findViewById9 = findViewById(t0.f.Y);
        this.J = findViewById9;
        findViewById9.setTag(this.e);
        q qVar = new q();
        this.K = qVar;
        this.J.setOnSeekBarChangeListener(qVar);
        this.D = findViewById(t0.f.W);
        this.F = new ArrayList();
        r rVar = new r(this.D.getContext(), this.F);
        this.E = rVar;
        this.D.setAdapter(rVar);
        this.I = new HashSet();
        androidx.mediarouter.app.i.u(this.f, this.z, this.D, t());
        androidx.mediarouter.app.i.w(this.f, (MediaRouteVolumeSlider) this.J, this.z);
        HashMap hashMap = new HashMap();
        this.Q = hashMap;
        hashMap.put(this.e, this.J);
        MediaRouteExpandCollapseButton findViewById10 = findViewById(t0.f.K);
        this.o = findViewById10;
        findViewById10.setOnClickListener(new h());
        z();
        this.k0 = this.f.getResources().getInteger(t0.g.b);
        this.l0 = this.f.getResources().getInteger(t0.g.c);
        this.m0 = this.f.getResources().getInteger(t0.g.d);
        View A = A(bundle);
        this.j = A;
        if (A != null) {
            this.s.addView(A);
            this.s.setVisibility(0);
        }
        this.g = true;
        updateLayout();
    }

    public void onDetachedFromWindow() {
        this.c.s(this.d);
        D(null);
        this.h = false;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 25 && i2 != 24) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.y || !this.h0) {
            this.e.H(i2 == 25 ? -1 : 1);
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public int p(int i2, int i3) {
        return i2 >= i3 ? (int) (((this.i * i3) / i2) + 0.5f) : (int) (((this.i * 9.0f) / 16.0f) + 0.5f);
    }

    public final int r(boolean z) {
        if (!z && this.B.getVisibility() != 0) {
            return 0;
        }
        int paddingTop = this.z.getPaddingTop() + this.z.getPaddingBottom();
        if (z) {
            paddingTop += this.A.getMeasuredHeight();
        }
        if (this.B.getVisibility() == 0) {
            paddingTop += this.B.getMeasuredHeight();
        }
        return (z && this.B.getVisibility() == 0) ? this.C.getMeasuredHeight() + paddingTop : paddingTop;
    }

    public final boolean t() {
        return this.e.y() && this.e.l().size() > 1;
    }

    public final boolean u() {
        MediaDescriptionCompat mediaDescriptionCompat = this.U;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.U;
        Uri iconUri = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        n nVar = this.V;
        Bitmap b2 = nVar == null ? this.W : nVar.b();
        n nVar2 = this.V;
        Uri c2 = nVar2 == null ? this.X : nVar2.c();
        if (b2 != iconBitmap) {
            return true;
        }
        return b2 == null && !O(c2, iconUri);
    }

    public void updateLayout() {
        int b2 = androidx.mediarouter.app.f.b(this.f);
        getWindow().setLayout(b2, -2);
        View decorView = getWindow().getDecorView();
        this.i = (b2 - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = this.f.getResources();
        this.M = resources.getDimensionPixelSize(t0.d.c);
        this.N = resources.getDimensionPixelSize(t0.d.b);
        this.O = resources.getDimensionPixelSize(t0.d.d);
        this.W = null;
        this.X = null;
        H();
        G(false);
    }

    public boolean v() {
        return (this.T.getActions() & 514) != 0;
    }

    public boolean w() {
        return (this.T.getActions() & 516) != 0;
    }

    public boolean x() {
        return (this.T.getActions() & 1) != 0;
    }

    public boolean y(L.h hVar) {
        return this.x && hVar.t() == 1;
    }

    public void z() {
        this.n0 = this.h0 ? this.o0 : this.p0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, int i2) {
        Context b2 = androidx.mediarouter.app.i.b(context, i2, true);
        super(b2, androidx.mediarouter.app.i.c(b2));
        this.x = true;
        this.s0 = new d();
        this.f = getContext();
        this.S = new o();
        L j2 = L.j(this.f);
        this.c = j2;
        this.y = L.o();
        this.d = new p();
        this.e = j2.n();
        D(j2.k());
        this.P = this.f.getResources().getDimensionPixelSize(t0.d.e);
        this.r0 = (AccessibilityManager) this.f.getSystemService("accessibility");
        this.o0 = AnimationUtils.loadInterpolator(b2, t0.h.b);
        this.p0 = AnimationUtils.loadInterpolator(b2, t0.h.a);
        this.q0 = new AccelerateDecelerateInterpolator();
    }
}
