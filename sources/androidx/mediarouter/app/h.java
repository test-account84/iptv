package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d.u;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u0.H;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h extends u {
    public static final boolean Q = Log.isLoggable("MediaRouteCtrlDialog", 3);
    public ImageView A;
    public View B;
    public ImageView C;
    public TextView D;
    public TextView E;
    public String F;
    public MediaControllerCompat G;
    public e H;
    public MediaDescriptionCompat I;
    public d J;
    public Bitmap K;
    public Uri L;
    public boolean M;
    public Bitmap N;
    public int O;
    public final boolean P;
    public final L a;
    public final g c;
    public K d;
    public L.h e;
    public final List f;
    public final List g;
    public final List h;
    public final List i;
    public Context j;
    public boolean k;
    public boolean l;
    public long m;
    public final Handler n;
    public RecyclerView o;
    public h p;
    public j q;
    public Map r;
    public L.h s;
    public Map t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public ImageButton y;
    public Button z;

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                h.this.o();
                return;
            }
            if (i != 2) {
                return;
            }
            h hVar = h.this;
            if (hVar.s != null) {
                hVar.s = null;
                hVar.p();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            h.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            if (h.this.e.C()) {
                h.this.a.z(2);
            }
            h.this.dismiss();
        }
    }

    public class d extends AsyncTask {
        public final Bitmap a;
        public final Uri b;
        public int c;

        public d() {
            MediaDescriptionCompat mediaDescriptionCompat = h.this.I;
            Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
            if (h.h(iconBitmap)) {
                Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
                iconBitmap = null;
            }
            this.a = iconBitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = h.this.I;
            this.b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00ec  */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r9) {
            /*
                Method dump skipped, instructions count: 289
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.h.d.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        public Bitmap b() {
            return this.a;
        }

        public Uri c() {
            return this.b;
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            h hVar = h.this;
            hVar.J = null;
            if (O.c.a(hVar.K, this.a) && O.c.a(h.this.L, this.b)) {
                return;
            }
            h hVar2 = h.this;
            hVar2.K = this.a;
            hVar2.N = bitmap;
            hVar2.L = this.b;
            hVar2.O = this.c;
            hVar2.M = true;
            hVar2.m();
        }

        public final InputStream e(Uri uri) {
            InputStream openInputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                openInputStream = h.this.j.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                openConnection.setConnectTimeout(30000);
                openConnection.setReadTimeout(30000);
                openInputStream = openConnection.getInputStream();
            }
            if (openInputStream == null) {
                return null;
            }
            return new BufferedInputStream(openInputStream);
        }

        public void onPreExecute() {
            h.this.f();
        }
    }

    public final class e extends MediaControllerCompat.Callback {
        public e() {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            h.this.I = mediaMetadataCompat == null ? null : mediaMetadataCompat.getDescription();
            h.this.i();
            h.this.m();
        }

        public void onSessionDestroyed() {
            h hVar = h.this;
            MediaControllerCompat mediaControllerCompat = hVar.G;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.unregisterCallback(hVar.H);
                h.this.G = null;
            }
        }
    }

    public abstract class f extends RecyclerView.D {
        public L.h t;
        public final ImageButton u;
        public final MediaRouteVolumeSlider v;

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                h hVar = h.this;
                if (hVar.s != null) {
                    hVar.n.removeMessages(2);
                }
                f fVar = f.this;
                h.this.s = fVar.t;
                boolean z = !view.isActivated();
                int Q = z ? 0 : f.this.Q();
                f.this.R(z);
                f.this.v.setProgress(Q);
                f.this.t.G(Q);
                h.this.n.sendEmptyMessageDelayed(2, 500L);
            }
        }

        public f(View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
            super(view);
            this.u = imageButton;
            this.v = mediaRouteVolumeSlider;
            imageButton.setImageDrawable(androidx.mediarouter.app.i.k(h.this.j));
            androidx.mediarouter.app.i.v(h.this.j, mediaRouteVolumeSlider);
        }

        public void P(L.h hVar) {
            this.t = hVar;
            int s = hVar.s();
            this.u.setActivated(s == 0);
            this.u.setOnClickListener(new a());
            this.v.setTag(this.t);
            this.v.setMax(hVar.u());
            this.v.setProgress(s);
            this.v.setOnSeekBarChangeListener(h.this.q);
        }

        public int Q() {
            Integer num = (Integer) h.this.t.get(this.t.k());
            if (num == null) {
                return 1;
            }
            return Math.max(1, num.intValue());
        }

        public void R(boolean z) {
            if (this.u.isActivated() == z) {
                return;
            }
            this.u.setActivated(z);
            if (z) {
                h.this.t.put(this.t.k(), Integer.valueOf(this.v.getProgress()));
            } else {
                h.this.t.remove(this.t.k());
            }
        }

        public void S() {
            int s = this.t.s();
            R(s == 0);
            this.v.setProgress(s);
        }
    }

    public final class g extends L.a {
        public g() {
        }

        public void onRouteAdded(L l, L.h hVar) {
            h.this.o();
        }

        public void onRouteChanged(L l, L.h hVar) {
            L.h.a h;
            if (hVar == h.this.e && hVar.g() != null) {
                for (L.h hVar2 : hVar.q().f()) {
                    if (!h.this.e.l().contains(hVar2) && (h = h.this.e.h(hVar2)) != null && h.b() && !h.this.g.contains(hVar2)) {
                        h.this.p();
                        h.this.n();
                        return;
                    }
                }
            }
            h.this.o();
        }

        public void onRouteRemoved(L l, L.h hVar) {
            h.this.o();
        }

        public void onRouteSelected(L l, L.h hVar) {
            h hVar2 = h.this;
            hVar2.e = hVar;
            hVar2.u = false;
            hVar2.p();
            h.this.n();
        }

        public void onRouteUnselected(L l, L.h hVar) {
            h.this.o();
        }

        public void onRouteVolumeChanged(L l, L.h hVar) {
            f fVar;
            int s = hVar.s();
            if (h.Q) {
                Log.d("MediaRouteCtrlDialog", "onRouteVolumeChanged(), route.getVolume:" + s);
            }
            h hVar2 = h.this;
            if (hVar2.s == hVar || (fVar = (f) hVar2.r.get(hVar.k())) == null) {
                return;
            }
            fVar.S();
        }
    }

    public final class h extends RecyclerView.g {
        public final LayoutInflater e;
        public final Drawable f;
        public final Drawable g;
        public final Drawable h;
        public final Drawable i;
        public f j;
        public final int k;
        public final ArrayList d = new ArrayList();
        public final Interpolator l = new AccelerateDecelerateInterpolator();

        public class a extends Animation {
            public final /* synthetic */ int a;
            public final /* synthetic */ int c;
            public final /* synthetic */ View d;

            public a(int i, int i2, View view) {
                this.a = i;
                this.c = i2;
                this.d = view;
            }

            public void applyTransformation(float f, Transformation transformation) {
                int i = this.a;
                h.j(this.d, this.c + ((int) ((i - r0) * f)));
            }
        }

        public class b implements Animation.AnimationListener {
            public b() {
            }

            public void onAnimationEnd(Animation animation) {
                h hVar = h.this;
                hVar.v = false;
                hVar.p();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                h.this.v = true;
            }
        }

        public class c extends RecyclerView.D {
            public final View t;
            public final ImageView u;
            public final ProgressBar v;
            public final TextView w;
            public final float x;
            public L.h y;

            public class a implements View.OnClickListener {
                public a() {
                }

                public void onClick(View view) {
                    c cVar = c.this;
                    h.this.a.y(cVar.y);
                    c.this.u.setVisibility(4);
                    c.this.v.setVisibility(0);
                }
            }

            public c(View view) {
                super(view);
                this.t = view;
                this.u = view.findViewById(t0.f.d);
                ProgressBar findViewById = view.findViewById(t0.f.f);
                this.v = findViewById;
                this.w = view.findViewById(t0.f.e);
                this.x = androidx.mediarouter.app.i.h(h.this.j);
                androidx.mediarouter.app.i.t(h.this.j, findViewById);
            }

            private boolean Q(L.h hVar) {
                List l = h.this.e.l();
                return (l.size() == 1 && l.get(0) == hVar) ? false : true;
            }

            public void P(f fVar) {
                L.h hVar = (L.h) fVar.a();
                this.y = hVar;
                this.u.setVisibility(0);
                this.v.setVisibility(4);
                this.t.setAlpha(Q(hVar) ? 1.0f : this.x);
                this.t.setOnClickListener(new a());
                this.u.setImageDrawable(h.this.l0(hVar));
                this.w.setText(hVar.m());
            }
        }

        public class d extends f {
            public final TextView x;
            public final int y;

            public d(View view) {
                super(view, view.findViewById(t0.f.n), view.findViewById(t0.f.t));
                this.x = view.findViewById(t0.f.L);
                Resources resources = h.this.j.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(t0.d.i, typedValue, true);
                this.y = (int) typedValue.getDimension(displayMetrics);
            }

            public void T(f fVar) {
                h.j(this.a, h.this.n0() ? this.y : 0);
                L.h hVar = (L.h) fVar.a();
                super.P(hVar);
                this.x.setText(hVar.m());
            }

            public int U() {
                return this.y;
            }
        }

        public class e extends RecyclerView.D {
            public final TextView t;

            public e(View view) {
                super(view);
                this.t = view.findViewById(t0.f.g);
            }

            public void P(f fVar) {
                this.t.setText(fVar.a().toString());
            }
        }

        public class f {
            public final Object a;
            public final int b;

            public f(Object obj, int i) {
                this.a = obj;
                this.b = i;
            }

            public Object a() {
                return this.a;
            }

            public int b() {
                return this.b;
            }
        }

        public class g extends f {
            public final TextView A;
            public final RelativeLayout B;
            public final CheckBox C;
            public final float D;
            public final int E;
            public final int F;
            public final View.OnClickListener G;
            public final View x;
            public final ImageView y;
            public final ProgressBar z;

            public class a implements View.OnClickListener {
                public a() {
                }

                public void onClick(View view) {
                    g gVar = g.this;
                    boolean z = !gVar.V(gVar.t);
                    boolean y = g.this.t.y();
                    g gVar2 = g.this;
                    L l = h.this.a;
                    L.h hVar = gVar2.t;
                    if (z) {
                        l.c(hVar);
                    } else {
                        l.t(hVar);
                    }
                    g.this.W(z, !y);
                    if (y) {
                        List l2 = h.this.e.l();
                        for (L.h hVar2 : g.this.t.l()) {
                            if (l2.contains(hVar2) != z) {
                                f fVar = (f) h.this.r.get(hVar2.k());
                                if (fVar instanceof g) {
                                    ((g) fVar).W(z, true);
                                }
                            }
                        }
                    }
                    g gVar3 = g.this;
                    h.this.p0(gVar3.t, z);
                }
            }

            public g(View view) {
                super(view, view.findViewById(t0.f.n), view.findViewById(t0.f.t));
                this.G = new a();
                this.x = view;
                this.y = view.findViewById(t0.f.o);
                ProgressBar findViewById = view.findViewById(t0.f.q);
                this.z = findViewById;
                this.A = view.findViewById(t0.f.p);
                this.B = view.findViewById(t0.f.s);
                CheckBox findViewById2 = view.findViewById(t0.f.b);
                this.C = findViewById2;
                findViewById2.setButtonDrawable(androidx.mediarouter.app.i.e(h.this.j));
                androidx.mediarouter.app.i.t(h.this.j, findViewById);
                this.D = androidx.mediarouter.app.i.h(h.this.j);
                Resources resources = h.this.j.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(t0.d.h, typedValue, true);
                this.E = (int) typedValue.getDimension(displayMetrics);
                this.F = 0;
            }

            public void T(f fVar) {
                L.h hVar = (L.h) fVar.a();
                if (hVar == h.this.e && hVar.l().size() > 0) {
                    Iterator it = hVar.l().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        L.h hVar2 = (L.h) it.next();
                        if (!h.this.g.contains(hVar2)) {
                            hVar = hVar2;
                            break;
                        }
                    }
                }
                P(hVar);
                this.y.setImageDrawable(h.this.l0(hVar));
                this.A.setText(hVar.m());
                this.C.setVisibility(0);
                boolean V = V(hVar);
                boolean U = U(hVar);
                this.C.setChecked(V);
                this.z.setVisibility(4);
                this.y.setVisibility(0);
                this.x.setEnabled(U);
                this.C.setEnabled(U);
                this.u.setEnabled(U || V);
                this.v.setEnabled(U || V);
                this.x.setOnClickListener(this.G);
                this.C.setOnClickListener(this.G);
                h.j(this.B, (!V || this.t.y()) ? this.F : this.E);
                float f = 1.0f;
                this.x.setAlpha((U || V) ? 1.0f : this.D);
                CheckBox checkBox = this.C;
                if (!U && V) {
                    f = this.D;
                }
                checkBox.setAlpha(f);
            }

            public final boolean U(L.h hVar) {
                if (h.this.i.contains(hVar)) {
                    return false;
                }
                if (V(hVar) && h.this.e.l().size() < 2) {
                    return false;
                }
                if (!V(hVar)) {
                    return true;
                }
                L.h.a h = h.this.e.h(hVar);
                return h != null && h.d();
            }

            public boolean V(L.h hVar) {
                if (hVar.C()) {
                    return true;
                }
                L.h.a h = h.this.e.h(hVar);
                return h != null && h.a() == 3;
            }

            public void W(boolean z, boolean z2) {
                this.C.setEnabled(false);
                this.x.setEnabled(false);
                this.C.setChecked(z);
                if (z) {
                    this.y.setVisibility(4);
                    this.z.setVisibility(0);
                }
                if (z2) {
                    h.this.j0(this.B, z ? this.E : this.F);
                }
            }
        }

        public h() {
            this.e = LayoutInflater.from(h.this.j);
            this.f = androidx.mediarouter.app.i.g(h.this.j);
            this.g = androidx.mediarouter.app.i.q(h.this.j);
            this.h = androidx.mediarouter.app.i.m(h.this.j);
            this.i = androidx.mediarouter.app.i.n(h.this.j);
            this.k = h.this.j.getResources().getInteger(t0.g.a);
            r0();
        }

        private Drawable k0(L.h hVar) {
            int f2 = hVar.f();
            return f2 != 1 ? f2 != 2 ? hVar.y() ? this.i : this.f : this.h : this.g;
        }

        public void E(RecyclerView.D d2, int i) {
            int p = p(i);
            f m0 = m0(i);
            if (p == 1) {
                h.this.r.put(((L.h) m0.a()).k(), (f) d2);
                ((d) d2).T(m0);
            } else {
                if (p == 2) {
                    ((e) d2).P(m0);
                    return;
                }
                if (p == 3) {
                    h.this.r.put(((L.h) m0.a()).k(), (f) d2);
                    ((g) d2).T(m0);
                } else if (p != 4) {
                    Log.w("MediaRouteCtrlDialog", "Cannot bind item to ViewHolder because of wrong view type");
                } else {
                    ((c) d2).P(m0);
                }
            }
        }

        public RecyclerView.D L(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new d(this.e.inflate(t0.i.c, viewGroup, false));
            }
            if (i == 2) {
                return new e(this.e.inflate(t0.i.d, viewGroup, false));
            }
            if (i == 3) {
                return new g(this.e.inflate(t0.i.e, viewGroup, false));
            }
            if (i == 4) {
                return new c(this.e.inflate(t0.i.b, viewGroup, false));
            }
            Log.w("MediaRouteCtrlDialog", "Cannot create ViewHolder because of wrong view type");
            return null;
        }

        public void Z(RecyclerView.D d2) {
            super.Z(d2);
            h.this.r.values().remove(d2);
        }

        public void j0(View view, int i) {
            a aVar = new a(i, view.getLayoutParams().height, view);
            aVar.setAnimationListener(new b());
            aVar.setDuration(this.k);
            aVar.setInterpolator(this.l);
            view.startAnimation(aVar);
        }

        public Drawable l0(L.h hVar) {
            Uri j = hVar.j();
            if (j != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(h.this.j.getContentResolver().openInputStream(j), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException e2) {
                    Log.w("MediaRouteCtrlDialog", "Failed to load " + j, e2);
                }
            }
            return k0(hVar);
        }

        public f m0(int i) {
            return i == 0 ? this.j : (f) this.d.get(i - 1);
        }

        public int n() {
            return this.d.size() + 1;
        }

        public boolean n0() {
            h hVar = h.this;
            return hVar.P && hVar.e.l().size() > 1;
        }

        public int p(int i) {
            return m0(i).b();
        }

        public void p0(L.h hVar, boolean z) {
            List l = h.this.e.l();
            int max = Math.max(1, l.size());
            if (hVar.y()) {
                Iterator it = hVar.l().iterator();
                while (it.hasNext()) {
                    if (l.contains((L.h) it.next()) != z) {
                        max += z ? 1 : -1;
                    }
                }
            } else {
                max += z ? 1 : -1;
            }
            boolean n0 = n0();
            h hVar2 = h.this;
            boolean z2 = hVar2.P && max >= 2;
            if (n0 != z2) {
                RecyclerView.D Z = hVar2.o.Z(0);
                if (Z instanceof d) {
                    d dVar = (d) Z;
                    j0(dVar.a, z2 ? dVar.U() : 0);
                }
            }
        }

        public void q0() {
            h.this.i.clear();
            h hVar = h.this;
            hVar.i.addAll(androidx.mediarouter.app.f.g(hVar.g, hVar.g()));
            w();
        }

        public void r0() {
            this.d.clear();
            this.j = new f(h.this.e, 1);
            if (h.this.f.isEmpty()) {
                this.d.add(new f(h.this.e, 3));
            } else {
                Iterator it = h.this.f.iterator();
                while (it.hasNext()) {
                    this.d.add(new f((L.h) it.next(), 3));
                }
            }
            boolean z = false;
            if (!h.this.g.isEmpty()) {
                boolean z2 = false;
                for (L.h hVar : h.this.g) {
                    if (!h.this.f.contains(hVar)) {
                        if (!z2) {
                            H.b g2 = h.this.e.g();
                            String j = g2 != null ? g2.j() : null;
                            if (TextUtils.isEmpty(j)) {
                                j = h.this.j.getString(t0.j.q);
                            }
                            this.d.add(new f(j, 2));
                            z2 = true;
                        }
                        this.d.add(new f(hVar, 3));
                    }
                }
            }
            if (!h.this.h.isEmpty()) {
                for (L.h hVar2 : h.this.h) {
                    L.h hVar3 = h.this.e;
                    if (hVar3 != hVar2) {
                        if (!z) {
                            H.b g3 = hVar3.g();
                            String k = g3 != null ? g3.k() : null;
                            if (TextUtils.isEmpty(k)) {
                                k = h.this.j.getString(t0.j.r);
                            }
                            this.d.add(new f(k, 2));
                            z = true;
                        }
                        this.d.add(new f(hVar2, 4));
                    }
                }
            }
            q0();
        }
    }

    public static final class i implements Comparator {
        public static final i a = new i();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(L.h hVar, L.h hVar2) {
            return hVar.m().compareToIgnoreCase(hVar2.m());
        }
    }

    public class j implements SeekBar.OnSeekBarChangeListener {
        public j() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                L.h hVar = (L.h) seekBar.getTag();
                f fVar = (f) h.this.r.get(hVar.k());
                if (fVar != null) {
                    fVar.R(i == 0);
                }
                hVar.G(i);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            h hVar = h.this;
            if (hVar.s != null) {
                hVar.n.removeMessages(2);
            }
            h.this.s = (L.h) seekBar.getTag();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            h.this.n.sendEmptyMessageDelayed(2, 500L);
        }
    }

    public h(Context context) {
        this(context, 0);
    }

    public static Bitmap e(Bitmap bitmap, float f2, Context context) {
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setRadius(f2);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        createTyped.copyTo(copy);
        createFromBitmap.destroy();
        createTyped.destroy();
        create2.destroy();
        create.destroy();
        return copy;
    }

    public static boolean h(Bitmap bitmap) {
        return bitmap != null && bitmap.isRecycled();
    }

    public static void j(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    private void k(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.G;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.H);
            this.G = null;
        }
        if (token != null && this.l) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.j, token);
            this.G = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(this.H);
            MediaMetadataCompat metadata = this.G.getMetadata();
            this.I = metadata != null ? metadata.getDescription() : null;
            i();
            m();
        }
    }

    public void f() {
        this.M = false;
        this.N = null;
        this.O = 0;
    }

    public List g() {
        ArrayList arrayList = new ArrayList();
        for (L.h hVar : this.e.q().f()) {
            L.h.a h2 = this.e.h(hVar);
            if (h2 != null && h2.b()) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    public void i() {
        MediaDescriptionCompat mediaDescriptionCompat = this.I;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.I;
        Uri iconUri = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        d dVar = this.J;
        Bitmap b2 = dVar == null ? this.K : dVar.b();
        d dVar2 = this.J;
        Uri c2 = dVar2 == null ? this.L : dVar2.c();
        if (b2 != iconBitmap || (b2 == null && !O.c.a(c2, iconUri))) {
            d dVar3 = this.J;
            if (dVar3 != null) {
                dVar3.cancel(true);
            }
            d dVar4 = new d();
            this.J = dVar4;
            dVar4.execute(new Void[0]);
        }
    }

    public final boolean l() {
        if (this.s != null || this.u || this.v) {
            return true;
        }
        return !this.k;
    }

    public void m() {
        if (l()) {
            this.x = true;
            return;
        }
        this.x = false;
        if (!this.e.C() || this.e.w()) {
            dismiss();
        }
        if (!this.M || h(this.N) || this.N == null) {
            if (h(this.N)) {
                Log.w("MediaRouteCtrlDialog", "Can't set artwork image with recycled bitmap: " + this.N);
            }
            this.C.setVisibility(8);
            this.B.setVisibility(8);
            this.A.setImageBitmap((Bitmap) null);
        } else {
            this.C.setVisibility(0);
            this.C.setImageBitmap(this.N);
            this.C.setBackgroundColor(this.O);
            this.B.setVisibility(0);
            this.A.setImageBitmap(e(this.N, 10.0f, this.j));
        }
        f();
        MediaDescriptionCompat mediaDescriptionCompat = this.I;
        CharSequence title = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getTitle();
        boolean z = !TextUtils.isEmpty(title);
        MediaDescriptionCompat mediaDescriptionCompat2 = this.I;
        CharSequence subtitle = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getSubtitle() : null;
        boolean isEmpty = true ^ TextUtils.isEmpty(subtitle);
        if (z) {
            this.D.setText(title);
        } else {
            this.D.setText(this.F);
        }
        if (!isEmpty) {
            this.E.setVisibility(8);
        } else {
            this.E.setText(subtitle);
            this.E.setVisibility(0);
        }
    }

    public void n() {
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.f.addAll(this.e.l());
        for (L.h hVar : this.e.q().f()) {
            L.h.a h2 = this.e.h(hVar);
            if (h2 != null) {
                if (h2.b()) {
                    this.g.add(hVar);
                }
                if (h2.c()) {
                    this.h.add(hVar);
                }
            }
        }
        onFilterRoutes(this.g);
        onFilterRoutes(this.h);
        List list = this.f;
        i iVar = i.a;
        Collections.sort(list, iVar);
        Collections.sort(this.g, iVar);
        Collections.sort(this.h, iVar);
        this.p.r0();
    }

    public void o() {
        if (this.l) {
            if (SystemClock.uptimeMillis() - this.m < 300) {
                this.n.removeMessages(1);
                this.n.sendEmptyMessageAtTime(1, this.m + 300);
            } else {
                if (l()) {
                    this.w = true;
                    return;
                }
                this.w = false;
                if (!this.e.C() || this.e.w()) {
                    dismiss();
                }
                this.m = SystemClock.uptimeMillis();
                this.p.q0();
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
        this.a.b(this.d, this.c, 1);
        n();
        k(this.a.k());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t0.i.a);
        androidx.mediarouter.app.i.s(this.j, this);
        ImageButton findViewById = findViewById(t0.f.c);
        this.y = findViewById;
        findViewById.setColorFilter(-1);
        this.y.setOnClickListener(new b());
        Button findViewById2 = findViewById(t0.f.r);
        this.z = findViewById2;
        findViewById2.setTextColor(-1);
        this.z.setOnClickListener(new c());
        this.p = new h();
        RecyclerView findViewById3 = findViewById(t0.f.h);
        this.o = findViewById3;
        findViewById3.setAdapter(this.p);
        this.o.setLayoutManager(new LinearLayoutManager(this.j));
        this.q = new j();
        this.r = new HashMap();
        this.t = new HashMap();
        this.A = findViewById(t0.f.j);
        this.B = findViewById(t0.f.k);
        this.C = findViewById(t0.f.i);
        TextView findViewById4 = findViewById(t0.f.m);
        this.D = findViewById4;
        findViewById4.setTextColor(-1);
        TextView findViewById5 = findViewById(t0.f.l);
        this.E = findViewById5;
        findViewById5.setTextColor(-1);
        this.F = this.j.getResources().getString(t0.j.d);
        this.k = true;
        updateLayout();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = false;
        this.a.s(this.c);
        this.n.removeCallbacksAndMessages((Object) null);
        k(null);
    }

    public boolean onFilterRoute(L.h hVar) {
        return !hVar.w() && hVar.x() && hVar.E(this.d) && this.e != hVar;
    }

    public void onFilterRoutes(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (!onFilterRoute((L.h) list.get(size))) {
                list.remove(size);
            }
        }
    }

    public void p() {
        if (this.w) {
            o();
        }
        if (this.x) {
            m();
        }
    }

    public void setRouteSelector(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.d.equals(k)) {
            return;
        }
        this.d = k;
        if (this.l) {
            this.a.s(this.c);
            this.a.b(k, this.c, 1);
            n();
        }
    }

    public void updateLayout() {
        getWindow().setLayout(androidx.mediarouter.app.f.c(this.j), androidx.mediarouter.app.f.a(this.j));
        this.K = null;
        this.L = null;
        i();
        m();
        o();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h(Context context, int i2) {
        Context b2 = androidx.mediarouter.app.i.b(context, i2, false);
        super(b2, androidx.mediarouter.app.i.c(b2));
        this.d = K.c;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.n = new a();
        Context context2 = getContext();
        this.j = context2;
        L j2 = L.j(context2);
        this.a = j2;
        this.P = L.o();
        this.c = new g();
        this.e = j2.n();
        this.H = new e();
        k(j2.k());
    }
}
