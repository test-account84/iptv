package com.nst.iptvsmarterstvbox.view.activity;

import B3.i0;
import O2.H0;
import O2.I1;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.v1;
import P3.f;
import Z3.m;
import Z3.z;
import a7.g;
import a7.j;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import b4.o;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.ui.e;
import d4.k0;
import d4.p;
import e4.C;
import java.util.Collections;
import java.util.List;
import p3.B;
import p3.t;
import p3.u;
import p7.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ExoPlayerMoviesSeriesActivity extends androidx.appcompat.app.b implements View.OnClickListener, e.m {
    public String B;
    public StyledPlayerView d;
    public LinearLayout e;
    public I1 f;
    public boolean g;
    public Button h;
    public o.a i;
    public List j;
    public m k;
    public m.d l;
    public i0 m;
    public boolean n;
    public int o;
    public long p;
    public SharedPreferences q;
    public SharedPreferences r;
    public Context s;
    public String t;
    public String y;
    public String u = "";
    public int v = -1;
    public int w = -1;
    public int x = 0;
    public String z = "";
    public String A = "";

    public class b implements p {
        public b() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair a(p1 p1Var) {
            String string = ExoPlayerMoviesSeriesActivity.this.getString(j.M1);
            u.b cause = p1Var.getCause();
            if (cause instanceof u.b) {
                u.b bVar = cause;
                t tVar = bVar.d;
                string = tVar == null ? bVar.getCause() instanceof B.c ? ExoPlayerMoviesSeriesActivity.this.getString(j.R1) : bVar.c ? ExoPlayerMoviesSeriesActivity.this.getString(j.P1, new Object[]{bVar.a}) : ExoPlayerMoviesSeriesActivity.this.getString(j.O1, new Object[]{bVar.a}) : ExoPlayerMoviesSeriesActivity.this.getString(j.N1, new Object[]{tVar.a});
            }
            return Pair.create(0, string);
        }

        public /* synthetic */ b(ExoPlayerMoviesSeriesActivity exoPlayerMoviesSeriesActivity, a aVar) {
            this();
        }
    }

    public class c implements t1.d {
        public c() {
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void E(int i) {
            if (i == 4) {
                ExoPlayerMoviesSeriesActivity.v1(ExoPlayerMoviesSeriesActivity.this);
            }
            ExoPlayerMoviesSeriesActivity.w1(ExoPlayerMoviesSeriesActivity.this);
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

        public /* synthetic */ void a0(O2.u uVar) {
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

        public void l0(p1 p1Var) {
            if (p1Var.a == 1002) {
                ExoPlayerMoviesSeriesActivity.this.f.g();
                ExoPlayerMoviesSeriesActivity.this.f.prepare();
            } else {
                ExoPlayerMoviesSeriesActivity.w1(ExoPlayerMoviesSeriesActivity.this);
                ExoPlayerMoviesSeriesActivity.v1(ExoPlayerMoviesSeriesActivity.this);
            }
        }

        public /* synthetic */ void m0(t1 t1Var, t1.c cVar) {
            v1.g(this, t1Var, cVar);
        }

        public /* synthetic */ void n0(boolean z) {
            v1.i(this, z);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            v1.x(this, i);
        }

        public /* synthetic */ void t(s1 s1Var) {
            v1.o(this, s1Var);
        }

        public /* synthetic */ void u(f fVar) {
            v1.c(this, fVar);
        }

        public /* synthetic */ void z(int i) {
            v1.q(this, i);
        }

        public /* synthetic */ c(ExoPlayerMoviesSeriesActivity exoPlayerMoviesSeriesActivity, a aVar) {
            this();
        }
    }

    private void D1(int i) {
        E1(getString(i));
    }

    private void E1(String str) {
        Toast.makeText(getApplicationContext(), str, 1).show();
    }

    private void F1() {
        Button button = this.h;
        I1 i1 = this.f;
        button.setEnabled(i1 != null && com.nst.iptvsmarterstvbox.view.demo.b.b0(i1));
    }

    private void G1() {
        I1 i1 = this.f;
        if (i1 != null) {
            this.n = i1.E();
            this.o = this.f.l0();
            this.p = Math.max(0L, this.f.R());
        }
    }

    private void H1() {
        m mVar = this.k;
        if (mVar != null) {
            this.l = mVar.K();
        }
    }

    public static /* synthetic */ void u1(ExoPlayerMoviesSeriesActivity exoPlayerMoviesSeriesActivity, DialogInterface dialogInterface) {
        exoPlayerMoviesSeriesActivity.z1(dialogInterface);
    }

    public static /* synthetic */ void v1(ExoPlayerMoviesSeriesActivity exoPlayerMoviesSeriesActivity) {
        exoPlayerMoviesSeriesActivity.C1();
    }

    public static /* synthetic */ void w1(ExoPlayerMoviesSeriesActivity exoPlayerMoviesSeriesActivity) {
        exoPlayerMoviesSeriesActivity.F1();
    }

    public void A1() {
        if (this.f != null) {
            H1();
            G1();
            this.f.release();
            this.f = null;
            this.j = Collections.emptyList();
            this.k = null;
        }
    }

    public void B1() {
        setContentView(g.Y3);
    }

    public final void C1() {
        this.e.setVisibility(0);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.d.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void o(int i) {
        this.e.setVisibility(i);
    }

    public void onClick(View view) {
        if (view == this.h && !this.g && com.nst.iptvsmarterstvbox.view.demo.b.b0(this.f)) {
            this.g = true;
            com.nst.iptvsmarterstvbox.view.demo.b.P(this.f, new A(this)).show(getSupportFragmentManager(), (String) null);
        }
    }

    public void onCreate(Bundle bundle) {
        this.s = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.i = r7.b.d(this);
        B1();
        this.e = findViewById(a7.f.s2);
        Button findViewById = findViewById(a7.f.Xf);
        this.h = findViewById;
        findViewById.setOnClickListener(this);
        StyledPlayerView findViewById2 = findViewById(a7.f.Bc);
        this.d = findViewById2;
        findViewById2.setControllerVisibilityListener(this);
        this.d.setErrorMessageProvider(new b(this, null));
        this.d.requestFocus();
        if (bundle == null) {
            this.l = new m.e(this).P();
            x1();
        } else {
            this.l = bundle.getParcelable("track_selector_parameters");
            this.n = bundle.getBoolean("auto_play");
            this.o = bundle.getInt("window");
            this.p = bundle.getLong("position");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super/*androidx.fragment.app.e*/.onNewIntent(intent);
        A1();
        x1();
        setIntent(intent);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        if (k0.a <= 23) {
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.B();
            }
            A1();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length == 0) {
            return;
        }
        if (iArr[0] == 0) {
            y1();
        } else {
            D1(j.O7);
            finish();
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        if (k0.a <= 23 || this.f == null) {
            y1();
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.C();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        H1();
        G1();
        bundle.putBundle("track_selector_parameters", this.l.h());
        bundle.putBoolean("auto_play", this.n);
        bundle.putInt("window", this.o);
        bundle.putLong("position", this.p);
    }

    public void onStart() {
        super.onStart();
        if (k0.a > 23) {
            y1();
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.C();
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (k0.a > 23) {
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.B();
            }
            A1();
        }
    }

    public void x1() {
        this.n = true;
        this.o = -1;
        this.p = -9223372036854775807L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0187 A[PHI: r17
      0x0187: PHI (r17v6 android.content.Intent) = 
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v7 android.content.Intent)
     binds: [B:74:0x01ab, B:76:0x01b1, B:78:0x01b9, B:80:0x01c3, B:72:0x01a6, B:28:0x0185] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean y1() {
        /*
            Method dump skipped, instructions count: 926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeriesActivity.y1():boolean");
    }

    public final /* synthetic */ void z1(DialogInterface dialogInterface) {
        this.g = false;
    }
}
