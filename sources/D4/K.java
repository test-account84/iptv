package d4;

import O2.H0;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.v1;
import O2.z0;
import android.os.Looper;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class k {
    public final O2.y a;
    public final TextView b;
    public final b c;
    public boolean d;

    public final class b implements t1.d, Runnable {
        public b() {
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void E(int i) {
            k.this.k();
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

        public void S(t1.e eVar, t1.e eVar2, int i) {
            k.this.k();
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

        public /* synthetic */ void Y(Z3.z zVar) {
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

        public /* synthetic */ void j(e4.C c) {
            v1.E(this, c);
        }

        public void j0(boolean z, int i) {
            k.this.k();
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

        public /* synthetic */ void onRepeatModeChanged(int i) {
            v1.x(this, i);
        }

        public void run() {
            k.this.k();
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

        public /* synthetic */ b(k kVar, a aVar) {
            this();
        }
    }

    public k(O2.y yVar, TextView textView) {
        d4.a.a(yVar.x() == Looper.getMainLooper());
        this.a = yVar;
        this.b = textView;
        this.c = new b(this, null);
    }

    public static String b(e4.c cVar) {
        if (cVar == null || !cVar.g()) {
            return "";
        }
        return " colr:" + cVar.l();
    }

    public static String d(U2.e eVar) {
        if (eVar == null) {
            return "";
        }
        eVar.c();
        return " sib:" + eVar.d + " sb:" + eVar.f + " rb:" + eVar.e + " db:" + eVar.g + " mcdb:" + eVar.i + " dk:" + eVar.j;
    }

    public static String e(float f) {
        if (f == -1.0f || f == 1.0f) {
            return "";
        }
        return " par:" + String.format(Locale.US, "%.02f", new Object[]{Float.valueOf(f)});
    }

    public static String g(long j, int i) {
        return i == 0 ? "N/A" : String.valueOf((long) (j / i));
    }

    public String a() {
        z0 S = this.a.S();
        U2.e c0 = this.a.c0();
        if (S == null || c0 == null) {
            return "";
        }
        return "\n" + S.m + "(id:" + S.a + " hz:" + S.A + " ch:" + S.z + d(c0) + ")";
    }

    public String c() {
        return f() + h() + a();
    }

    public String f() {
        int playbackState = this.a.getPlaybackState();
        return String.format("playWhenReady:%s playbackState:%s item:%s", new Object[]{Boolean.valueOf(this.a.E()), playbackState != 1 ? playbackState != 2 ? playbackState != 3 ? playbackState != 4 ? "unknown" : "ended" : "ready" : "buffering" : "idle", Integer.valueOf(this.a.X())});
    }

    public String h() {
        z0 a2 = this.a.a();
        U2.e Q = this.a.Q();
        if (a2 == null || Q == null) {
            return "";
        }
        return "\n" + a2.m + "(id:" + a2.a + " r:" + a2.r + "x" + a2.s + b(a2.y) + e(a2.v) + d(Q) + " vfpo: " + g(Q.k, Q.l) + ")";
    }

    public final void i() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.B(this.c);
        k();
    }

    public final void j() {
        if (this.d) {
            this.d = false;
            this.a.l(this.c);
            this.b.removeCallbacks(this.c);
        }
    }

    public final void k() {
        this.b.setText(c());
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, 1000L);
    }
}
