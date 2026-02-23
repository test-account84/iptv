package s4;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.internal.cast.zzcq;
import com.google.android.gms.internal.cast.zzct;
import com.google.android.gms.internal.cast.zzcu;
import com.google.android.gms.internal.cast.zzcv;
import com.google.android.gms.internal.cast.zzcw;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import java.util.Timer;
import n4.e;
import o4.u;
import o4.v;
import o4.x;
import o4.y;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a extends androidx.appcompat.app.b {
    public ImageView A;
    public ImageView B;
    public int[] C;
    public View E;
    public View F;
    public ImageView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public q4.b L;
    public r4.b M;
    public x N;
    public e.d O;
    public boolean P;
    public boolean Q;
    public Timer R;
    public String S;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public TextView x;
    public SeekBar y;
    public CastSeekBar z;
    public final y d = new s(this, null);
    public final i.b e = new q(this, null);
    public final ImageView[] D = new ImageView[4];

    public static /* bridge */ /* synthetic */ void A1(a aVar) {
        aVar.H1();
    }

    public static /* bridge */ /* synthetic */ void B1(a aVar) {
        aVar.I1();
    }

    public static /* bridge */ /* synthetic */ void C1(a aVar) {
        aVar.J1();
    }

    public static /* bridge */ /* synthetic */ ImageView u1(a aVar) {
        return aVar.G;
    }

    public static /* bridge */ /* synthetic */ TextView v1(a aVar) {
        return aVar.H;
    }

    public static /* bridge */ /* synthetic */ TextView w1(a aVar) {
        return aVar.J;
    }

    public static /* bridge */ /* synthetic */ TextView x1(a aVar) {
        return aVar.x;
    }

    public static /* bridge */ /* synthetic */ p4.i y1(a aVar) {
        return aVar.D1();
    }

    public static /* bridge */ /* synthetic */ void z1(a aVar, p4.i iVar) {
        aVar.G1(iVar);
    }

    public final p4.i D1() {
        o4.e c = this.N.c();
        if (c == null || !c.c()) {
            return null;
        }
        return c.r();
    }

    public final void E1(String str) {
        this.L.d(Uri.parse(str));
        this.F.setVisibility(8);
    }

    public final void F1(View view, int i, int i2, r4.b bVar) {
        ImageView findViewById = view.findViewById(i);
        if (i2 == o4.q.s) {
            findViewById.setVisibility(4);
            return;
        }
        if (i2 == o4.q.v) {
            findViewById.setBackgroundResource(this.f);
            Drawable b = t.b(this, this.t, this.h);
            Drawable b2 = t.b(this, this.t, this.g);
            Drawable b3 = t.b(this, this.t, this.i);
            findViewById.setImageDrawable(b2);
            bVar.i(findViewById, b2, b, b3, null, false);
            return;
        }
        if (i2 == o4.q.y) {
            findViewById.setBackgroundResource(this.f);
            findViewById.setImageDrawable(t.b(this, this.t, this.j));
            findViewById.setContentDescription(getResources().getString(o4.t.t));
            bVar.v(findViewById, 0);
            return;
        }
        if (i2 == o4.q.x) {
            findViewById.setBackgroundResource(this.f);
            findViewById.setImageDrawable(t.b(this, this.t, this.k));
            findViewById.setContentDescription(getResources().getString(o4.t.s));
            bVar.u(findViewById, 0);
            return;
        }
        if (i2 == o4.q.w) {
            findViewById.setBackgroundResource(this.f);
            findViewById.setImageDrawable(t.b(this, this.t, this.l));
            findViewById.setContentDescription(getResources().getString(o4.t.r));
            bVar.t(findViewById, 30000L);
            return;
        }
        if (i2 == o4.q.t) {
            findViewById.setBackgroundResource(this.f);
            findViewById.setImageDrawable(t.b(this, this.t, this.m));
            findViewById.setContentDescription(getResources().getString(o4.t.k));
            bVar.q(findViewById, 30000L);
            return;
        }
        if (i2 == o4.q.u) {
            findViewById.setBackgroundResource(this.f);
            findViewById.setImageDrawable(t.b(this, this.t, this.n));
            bVar.h(findViewById);
        } else if (i2 == o4.q.q) {
            findViewById.setBackgroundResource(this.f);
            findViewById.setImageDrawable(t.b(this, this.t, this.o));
            bVar.p(findViewById);
        }
    }

    public final void G1(p4.i iVar) {
        n4.r l;
        if (this.P || (l = iVar.l()) == null || iVar.r()) {
            return;
        }
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        n4.a J = l.J();
        if (J == null || J.R() == -1) {
            return;
        }
        if (!this.Q) {
            l lVar = new l(this, iVar);
            Timer timer = new Timer();
            this.R = timer;
            timer.scheduleAtFixedRate(lVar, 0L, 500L);
            this.Q = true;
        }
        if (J.R() - iVar.d() > 0.0f) {
            this.K.setVisibility(0);
            this.K.setText(getResources().getString(o4.t.h, new Object[]{Integer.valueOf((int) Math.ceil(r11 / 1000.0f))}));
            this.J.setClickable(false);
        } else {
            if (this.Q) {
                this.R.cancel();
                this.Q = false;
            }
            this.J.setVisibility(0);
            this.J.setClickable(true);
        }
    }

    public final void H1() {
        CastDevice q;
        o4.e c = this.N.c();
        if (c != null && (q = c.q()) != null) {
            String J = q.J();
            if (!TextUtils.isEmpty(J)) {
                this.x.setText(getResources().getString(o4.t.b, new Object[]{J}));
                return;
            }
        }
        this.x.setText("");
    }

    public final void I1() {
        MediaInfo j;
        n4.m Q;
        d.a i1;
        p4.i D1 = D1();
        if (D1 == null || !D1.q() || (j = D1.j()) == null || (Q = j.Q()) == null || (i1 = i1()) == null) {
            return;
        }
        i1.x(Q.J("com.google.android.gms.cast.metadata.TITLE"));
        String e = q4.x.e(Q);
        if (e != null) {
            i1.w(e);
        }
    }

    public final void J1() {
        n4.r l;
        CharSequence charSequence;
        BitmapDrawable drawable;
        Bitmap bitmap;
        Bitmap a;
        p4.i D1 = D1();
        if (D1 == null || (l = D1.l()) == null) {
            return;
        }
        CharSequence charSequence2 = null;
        if (!l.h0()) {
            this.K.setVisibility(8);
            this.J.setVisibility(8);
            this.E.setVisibility(8);
            this.B.setVisibility(8);
            this.B.setImageBitmap((Bitmap) null);
            return;
        }
        if (this.B.getVisibility() == 8 && (drawable = this.A.getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = drawable.getBitmap()) != null && (a = t.a(this, bitmap, 0.25f, 7.5f)) != null) {
            this.B.setImageBitmap(a);
            this.B.setVisibility(0);
        }
        n4.a J = l.J();
        if (J != null) {
            CharSequence P = J.P();
            charSequence2 = J.N();
            charSequence = P;
        } else {
            charSequence = null;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            E1(charSequence2);
        } else if (TextUtils.isEmpty(this.S)) {
            this.H.setVisibility(0);
            this.F.setVisibility(0);
            this.G.setVisibility(8);
        } else {
            E1(this.S);
        }
        TextView textView = this.I;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = getResources().getString(o4.t.a);
        }
        textView.setText(charSequence);
        if (C4.m.g()) {
            T.i.a(this.I, this.u);
        } else {
            this.I.setTextAppearance(this, this.u);
        }
        this.E.setVisibility(0);
        G1(D1);
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        x c = o4.b.e(this).c();
        this.N = c;
        if (c.c() == null) {
            finish();
        }
        r4.b bVar = new r4.b(this);
        this.M = bVar;
        bVar.S(this.e);
        setContentView(o4.s.b);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{c.a.M});
        this.f = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = obtainStyledAttributes((AttributeSet) null, v.b, o4.m.a, u.a);
        this.t = obtainStyledAttributes2.getResourceId(v.j, 0);
        this.g = obtainStyledAttributes2.getResourceId(v.s, 0);
        this.h = obtainStyledAttributes2.getResourceId(v.r, 0);
        this.i = obtainStyledAttributes2.getResourceId(v.A, 0);
        this.j = obtainStyledAttributes2.getResourceId(v.z, 0);
        this.k = obtainStyledAttributes2.getResourceId(v.y, 0);
        this.l = obtainStyledAttributes2.getResourceId(v.t, 0);
        this.m = obtainStyledAttributes2.getResourceId(v.o, 0);
        this.n = obtainStyledAttributes2.getResourceId(v.q, 0);
        this.o = obtainStyledAttributes2.getResourceId(v.k, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(v.l, 0);
        if (resourceId != 0) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(resourceId);
            com.google.android.gms.common.internal.r.a(obtainTypedArray.length() == 4);
            this.C = new int[obtainTypedArray.length()];
            for (int i = 0; i < obtainTypedArray.length(); i++) {
                this.C[i] = obtainTypedArray.getResourceId(i, 0);
            }
            obtainTypedArray.recycle();
        } else {
            int i2 = o4.q.s;
            this.C = new int[]{i2, i2, i2, i2};
        }
        this.s = obtainStyledAttributes2.getColor(v.n, 0);
        this.p = getResources().getColor(obtainStyledAttributes2.getResourceId(v.g, 0));
        this.q = getResources().getColor(obtainStyledAttributes2.getResourceId(v.f, 0));
        this.r = getResources().getColor(obtainStyledAttributes2.getResourceId(v.i, 0));
        this.u = obtainStyledAttributes2.getResourceId(v.h, 0);
        this.v = obtainStyledAttributes2.getResourceId(v.d, 0);
        this.w = obtainStyledAttributes2.getResourceId(v.e, 0);
        int resourceId2 = obtainStyledAttributes2.getResourceId(v.m, 0);
        if (resourceId2 != 0) {
            this.S = getApplicationContext().getResources().getString(resourceId2);
        }
        obtainStyledAttributes2.recycle();
        View findViewById = findViewById(o4.q.N);
        r4.b bVar2 = this.M;
        this.A = findViewById.findViewById(o4.q.i);
        this.B = findViewById.findViewById(o4.q.k);
        View findViewById2 = findViewById.findViewById(o4.q.j);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        bVar2.U(this.A, new p4.b(4, displayMetrics.widthPixels, displayMetrics.heightPixels), findViewById2, new o(this, null));
        this.x = findViewById.findViewById(o4.q.Y);
        View view = (ProgressBar) findViewById.findViewById(o4.q.T);
        Drawable indeterminateDrawable = view.getIndeterminateDrawable();
        int i3 = this.s;
        if (i3 != 0) {
            indeterminateDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
        }
        bVar2.s(view);
        View view2 = (TextView) findViewById.findViewById(o4.q.X);
        View view3 = (TextView) findViewById.findViewById(o4.q.M);
        this.y = findViewById.findViewById(o4.q.W);
        CastSeekBar castSeekBar = (CastSeekBar) findViewById.findViewById(o4.q.J);
        this.z = castSeekBar;
        bVar2.l(castSeekBar, 1000L);
        bVar2.w(view2, new zzcv(view2, bVar2.T()));
        bVar2.w(view3, new zzct(view3, bVar2.T()));
        View findViewById3 = findViewById.findViewById(o4.q.S);
        bVar2.w(findViewById3, new zzcu(findViewById3, bVar2.T()));
        View view4 = (RelativeLayout) findViewById.findViewById(o4.q.g0);
        zzcq zzcwVar = new zzcw(view4, this.z, bVar2.T());
        bVar2.w(view4, zzcwVar);
        bVar2.Y(zzcwVar);
        this.D[0] = (ImageView) findViewById.findViewById(o4.q.l);
        this.D[1] = (ImageView) findViewById.findViewById(o4.q.m);
        this.D[2] = (ImageView) findViewById.findViewById(o4.q.n);
        this.D[3] = (ImageView) findViewById.findViewById(o4.q.o);
        F1(findViewById, o4.q.l, this.C[0], bVar2);
        F1(findViewById, o4.q.m, this.C[1], bVar2);
        F1(findViewById, o4.q.p, o4.q.v, bVar2);
        F1(findViewById, o4.q.n, this.C[2], bVar2);
        F1(findViewById, o4.q.o, this.C[3], bVar2);
        View findViewById4 = findViewById(o4.q.b);
        this.E = findViewById4;
        this.G = findViewById4.findViewById(o4.q.c);
        this.F = this.E.findViewById(o4.q.a);
        TextView findViewById5 = this.E.findViewById(o4.q.e);
        this.I = findViewById5;
        findViewById5.setTextColor(this.r);
        this.I.setBackgroundColor(this.p);
        this.H = this.E.findViewById(o4.q.d);
        this.K = findViewById(o4.q.g);
        TextView findViewById6 = findViewById(o4.q.f);
        this.J = findViewById6;
        findViewById6.setOnClickListener(new j(this));
        r1(findViewById(o4.q.e0));
        d.a i1 = i1();
        if (i1 != null) {
            i1.t(true);
            i1.u(o4.p.o);
        }
        H1();
        I1();
        if (this.H != null && this.w != 0) {
            if (C4.m.g()) {
                T.i.a(this.H, this.v);
            } else {
                this.H.setTextAppearance(getApplicationContext(), this.v);
            }
            this.H.setTextColor(this.q);
            this.H.setText(this.w);
        }
        q4.b bVar3 = new q4.b(getApplicationContext(), new p4.b(-1, this.G.getWidth(), this.G.getHeight()));
        this.L = bVar3;
        bVar3.c(new i(this));
        zzr.zzd(zzln.CAF_EXPANDED_CONTROLLER);
    }

    public void onDestroy() {
        this.L.a();
        r4.b bVar = this.M;
        if (bVar != null) {
            bVar.S(null);
            this.M.y();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    public void onPause() {
        x xVar = this.N;
        if (xVar == null) {
            return;
        }
        o4.e c = xVar.c();
        e.d dVar = this.O;
        if (dVar != null && c != null) {
            c.t(dVar);
            this.O = null;
        }
        this.N.e(this.d, o4.e.class);
        super/*androidx.fragment.app.e*/.onPause();
    }

    public void onResume() {
        x xVar = this.N;
        if (xVar == null) {
            return;
        }
        xVar.a(this.d, o4.e.class);
        o4.e c = this.N.c();
        if (c == null || !(c.c() || c.d())) {
            finish();
        } else {
            m mVar = new m(this);
            this.O = mVar;
            c.p(mVar);
        }
        p4.i D1 = D1();
        boolean z = true;
        if (D1 != null && D1.q()) {
            z = false;
        }
        this.P = z;
        H1();
        J1();
        super/*androidx.fragment.app.e*/.onResume();
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        if (z) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            int i = systemUiVisibility ^ 2;
            if (C4.m.b()) {
                i = systemUiVisibility ^ 6;
            }
            if (C4.m.d()) {
                i ^= 4096;
            }
            getWindow().getDecorView().setSystemUiVisibility(i);
            setImmersive(true);
        }
    }
}
