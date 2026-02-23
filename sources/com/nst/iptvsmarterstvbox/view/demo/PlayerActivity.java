package com.nst.iptvsmarterstvbox.view.demo;

import B3.C;
import B3.q;
import C3.e;
import O2.H0;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.v1;
import O2.y;
import P3.f;
import V2.L;
import V2.l;
import Z2.d;
import Z2.h;
import Z3.z;
import a7.j;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import b4.o;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import d4.k;
import d4.k0;
import d4.p;
import e4.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p3.B;
import p3.t;
import p3.u;
import r7.g;
import r7.r;
import z3.w;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PlayerActivity extends androidx.appcompat.app.b implements View.OnClickListener, StyledPlayerView.b {
    public StyledPlayerView d;
    public LinearLayout e;
    public TextView f;
    public y g;
    public boolean h;
    public Button i;
    public o.a j;
    public List k;
    public z l;
    public k m;
    public V1 n;
    public boolean o;
    public int p;
    public long q;
    public e r;
    public h.c s;
    public h.c.c t;

    public class b implements p {
        public b() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair a(p1 p1Var) {
            String string = PlayerActivity.this.getString(j.M1);
            u.b cause = p1Var.getCause();
            if (cause instanceof u.b) {
                u.b bVar = cause;
                t tVar = bVar.d;
                string = tVar == null ? bVar.getCause() instanceof B.c ? PlayerActivity.this.getString(j.R1) : bVar.c ? PlayerActivity.this.getString(j.P1, new Object[]{bVar.a}) : PlayerActivity.this.getString(j.O1, new Object[]{bVar.a}) : PlayerActivity.this.getString(j.N1, new Object[]{tVar.a});
            }
            return Pair.create(0, string);
        }

        public /* synthetic */ b(PlayerActivity playerActivity, a aVar) {
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
                PlayerActivity.w1(PlayerActivity.this);
            }
            PlayerActivity.x1(PlayerActivity.this);
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

        public void f0(V1 v1) {
            PlayerActivity.x1(PlayerActivity.this);
            if (v1 == PlayerActivity.y1(PlayerActivity.this)) {
                return;
            }
            if (v1.b(2) && !v1.g(2, true)) {
                PlayerActivity.A1(PlayerActivity.this, j.U1);
            }
            if (v1.b(1) && !v1.g(1, true)) {
                PlayerActivity.A1(PlayerActivity.this, j.T1);
            }
            PlayerActivity.z1(PlayerActivity.this, v1);
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
                PlayerActivity.this.g.g();
                PlayerActivity.this.g.prepare();
            } else {
                PlayerActivity.x1(PlayerActivity.this);
                PlayerActivity.w1(PlayerActivity.this);
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

        public /* synthetic */ c(PlayerActivity playerActivity, a aVar) {
            this();
        }
    }

    public static /* synthetic */ void A1(PlayerActivity playerActivity, int i) {
        playerActivity.S1(i);
    }

    public static List E1(Intent intent, com.nst.iptvsmarterstvbox.view.demo.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (H0 h0 : g.f(intent)) {
            arrayList.add(J1(h0, aVar.f(h0.c.a)));
        }
        return arrayList;
    }

    private /* synthetic */ void I1(DialogInterface dialogInterface) {
        this.h = false;
    }

    public static H0 J1(H0 h0, w wVar) {
        if (wVar == null) {
            return h0;
        }
        H0.c b2 = h0.b();
        b2.g(wVar.a).m(wVar.c).d(wVar.g).i(wVar.d).j(wVar.e);
        H0.f fVar = h0.c.d;
        if (fVar != null) {
            b2.e(fVar.c().m(wVar.f).i());
        }
        return b2.a();
    }

    private void R1() {
        this.e.setVisibility(0);
    }

    private void S1(int i) {
        T1(getString(i));
    }

    private void T1(String str) {
        Toast.makeText(getApplicationContext(), str, 1).show();
    }

    private void U1() {
        Button button = this.i;
        y yVar = this.g;
        button.setEnabled(yVar != null && com.nst.iptvsmarterstvbox.view.demo.b.b0(yVar));
    }

    private void V1() {
        y yVar = this.g;
        if (yVar != null) {
            this.o = yVar.E();
            this.p = this.g.X();
            this.q = Math.max(0L, this.g.R());
        }
    }

    private void W1() {
        y yVar = this.g;
        if (yVar != null) {
            this.l = yVar.y();
        }
    }

    public static /* synthetic */ void u1(PlayerActivity playerActivity, DialogInterface dialogInterface) {
        playerActivity.I1(dialogInterface);
    }

    public static /* synthetic */ e v1(PlayerActivity playerActivity, H0.b bVar) {
        return playerActivity.G1(bVar);
    }

    public static /* synthetic */ void w1(PlayerActivity playerActivity) {
        playerActivity.R1();
    }

    public static /* synthetic */ void x1(PlayerActivity playerActivity) {
        playerActivity.U1();
    }

    public static /* synthetic */ V1 y1(PlayerActivity playerActivity) {
        return playerActivity.n;
    }

    public static /* synthetic */ V1 z1(PlayerActivity playerActivity, V1 v1) {
        playerActivity.n = v1;
        return v1;
    }

    public void B1() {
        this.o = true;
        this.p = -1;
        this.q = -9223372036854775807L;
    }

    public final void C1() {
        this.s.k(this.g);
    }

    public void D(int i) {
        this.e.setVisibility(i);
    }

    public final List D1(Intent intent) {
        int i;
        String action = intent.getAction();
        if ("com.google.android.exoplayer.demo.action.VIEW_LIST".equals(action) || "com.google.android.exoplayer.demo.action.VIEW".equals(action)) {
            List E1 = E1(intent, r7.b.f(this));
            for (int i2 = 0; i2 < E1.size(); i2++) {
                H0 h0 = (H0) E1.get(i2);
                if (!k0.n(new H0[]{h0})) {
                    i = j.I1;
                } else {
                    if (k0.N0(this, new H0[]{h0})) {
                        return Collections.emptyList();
                    }
                    H0.f fVar = h0.c.d;
                    if (fVar != null && !L.z(fVar.a)) {
                        i = j.K1;
                    }
                }
                S1(i);
            }
            return E1;
        }
        T1(getString(j.c8, new Object[]{action}));
        finish();
        return Collections.emptyList();
    }

    public final C.a F1() {
        l lVar = new l();
        lVar.c(r7.b.g(this));
        h.c.a aVar = new h.c.a(this, this.d);
        h.c.c cVar = this.t;
        if (cVar != null) {
            aVar.b(cVar);
        }
        h.c a2 = aVar.a();
        this.s = a2;
        return new q(this).m(this.j).n(lVar).p(new r(this), this.d).q(new h.e(a2, new q(this).m(this.j)));
    }

    public final e G1(H0.b bVar) {
        if (this.r == null) {
            this.r = new d.b(this).a();
        }
        this.r.f(this.g);
        return this.r;
    }

    public boolean H1() {
        if (this.g == null) {
            Intent intent = getIntent();
            List D1 = D1(intent);
            this.k = D1;
            if (D1.isEmpty()) {
                return false;
            }
            this.n = V1.c;
            y.b u = new y.b(this).u(F1());
            Q1(u, intent.getBooleanExtra("prefer_extension_decoders", false));
            y j = u.j();
            this.g = j;
            j.i(this.l);
            this.g.B(new c(this, null));
            this.g.W(new d4.q());
            this.g.O(Q2.e.h, true);
            this.g.o(this.o);
            this.d.setPlayer(this.g);
            C1();
            k kVar = new k(this.g, this.f);
            this.m = kVar;
            kVar.i();
        }
        int i = this.p;
        boolean z = i != -1;
        if (z) {
            this.g.C(i, this.q);
        }
        this.g.h(this.k, !z);
        this.g.prepare();
        U1();
        return true;
    }

    public final void K1() {
        e eVar = this.r;
        if (eVar != null) {
            eVar.release();
            this.r = null;
            this.d.getAdViewGroup().removeAllViews();
        }
    }

    public void L1() {
        if (this.g != null) {
            W1();
            V1();
            M1();
            this.m.j();
            this.m = null;
            this.g.release();
            this.g = null;
            this.d.setPlayer((t1) null);
            this.k = Collections.emptyList();
        }
        e eVar = this.r;
        if (eVar != null) {
            eVar.f((t1) null);
        } else {
            this.d.getAdViewGroup().removeAllViews();
        }
    }

    public final void M1() {
        this.t = this.s.i();
        this.s = null;
    }

    public final void N1(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("server_side_ads_loader_state");
        if (bundle2 != null) {
            this.t = h.c.c.d.a(bundle2);
        }
    }

    public final void O1(Bundle bundle) {
        h.c.c cVar = this.t;
        if (cVar != null) {
            bundle.putBundle("server_side_ads_loader_state", cVar.h());
        }
    }

    public void P1() {
        setContentView(a7.g.Y3);
    }

    public final void Q1(y.b bVar, boolean z) {
        bVar.v(r7.b.b(this, z));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.d.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void onClick(View view) {
        if (view == this.i && !this.h && com.nst.iptvsmarterstvbox.view.demo.b.b0(this.g)) {
            this.h = true;
            com.nst.iptvsmarterstvbox.view.demo.b.P(this.g, new r7.q(this)).show(getSupportFragmentManager(), (String) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.j = r7.b.d(this);
        P1();
        this.e = findViewById(a7.f.s2);
        this.f = findViewById(a7.f.G2);
        Button findViewById = findViewById(a7.f.Xf);
        this.i = findViewById;
        findViewById.setOnClickListener(this);
        StyledPlayerView findViewById2 = findViewById(a7.f.Bc);
        this.d = findViewById2;
        findViewById2.setControllerVisibilityListener(this);
        this.d.setErrorMessageProvider(new b(this, null));
        this.d.requestFocus();
        if (bundle == null) {
            this.l = new z.a(this).B();
            B1();
            return;
        }
        this.l = z.C(bundle.getBundle("track_selection_parameters"));
        this.o = bundle.getBoolean("auto_play");
        this.p = bundle.getInt("item_index");
        this.q = bundle.getLong("position");
        N1(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        K1();
    }

    public void onNewIntent(Intent intent) {
        super/*androidx.fragment.app.e*/.onNewIntent(intent);
        L1();
        K1();
        B1();
        setIntent(intent);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        if (Build.VERSION.SDK_INT <= 23) {
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.B();
            }
            L1();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length == 0) {
            return;
        }
        if (iArr[0] == 0) {
            H1();
        } else {
            S1(j.O7);
            finish();
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        if (Build.VERSION.SDK_INT <= 23 || this.g == null) {
            H1();
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.C();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        W1();
        V1();
        bundle.putBundle("track_selection_parameters", this.l.h());
        bundle.putBoolean("auto_play", this.o);
        bundle.putInt("item_index", this.p);
        bundle.putLong("position", this.q);
        O1(bundle);
    }

    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT > 23) {
            H1();
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.C();
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT > 23) {
            StyledPlayerView styledPlayerView = this.d;
            if (styledPlayerView != null) {
                styledPlayerView.B();
            }
            L1();
        }
    }
}
