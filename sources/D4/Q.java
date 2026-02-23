package d4;

import O2.H0;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.z0;
import P2.c;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class q implements P2.c {
    public static final NumberFormat e;
    public final String a;
    public final Q1.d b;
    public final Q1.b c;
    public final long d;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        e = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public q() {
        this("EventLogger");
    }

    public static String A0(int i) {
        return i != 0 ? i != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    public static String B0(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    public static String S(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT";
    }

    public static String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "?" : "INTERNAL" : "REMOVE" : "SKIP" : "SEEK_ADJUSTMENT" : "SEEK" : "AUTO_TRANSITION";
    }

    public static String v0(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    public static String w0(int i) {
        return i != 0 ? i != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE";
    }

    public static String x0(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "?" : "ALL" : "ONE" : "OFF";
    }

    public static String y0(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    public static String z0(long j) {
        return j == -9223372036854775807L ? "?" : e.format(j / 1000.0f);
    }

    public void A(c.a aVar, boolean z) {
        D0(aVar, "isPlaying", Boolean.toString(z));
    }

    public void B(c.a aVar, int i, long j, long j2) {
        F0(aVar, "audioTrackUnderrun", i + ", " + j + ", " + j2, null);
    }

    public void C(c.a aVar, H0 h0, int i) {
        E0("mediaItem [" + x(aVar) + ", reason=" + S(i) + "]");
    }

    public final void C0(c.a aVar, String str) {
        E0(v(aVar, str, null, null));
    }

    public void D(c.a aVar, Object obj, long j) {
        D0(aVar, "renderedFirstFrame", String.valueOf(obj));
    }

    public final void D0(c.a aVar, String str, String str2) {
        E0(v(aVar, str, str2, null));
    }

    public void E(c.a aVar, U2.e eVar) {
        C0(aVar, "videoDisabled");
    }

    public void E0(String str) {
        B.b(this.a, str);
    }

    public void F(c.a aVar, p1 p1Var) {
        G0(aVar, "playerFailed", p1Var);
    }

    public final void F0(c.a aVar, String str, String str2, Throwable th) {
        H0(v(aVar, str, str2, th));
    }

    public void G(c.a aVar, B3.x xVar) {
        D0(aVar, "upstreamDiscarded", z0.k(xVar.c));
    }

    public final void G0(c.a aVar, String str, Throwable th) {
        H0(v(aVar, str, null, th));
    }

    public /* synthetic */ void H(c.a aVar, R0 r0) {
        P2.b.H(this, aVar, r0);
    }

    public void H0(String str) {
        B.d(this.a, str);
    }

    public /* synthetic */ void I(c.a aVar, Exception exc) {
        P2.b.b(this, aVar, exc);
    }

    public final void I0(c.a aVar, String str, Exception exc) {
        F0(aVar, "internalError", str, exc);
    }

    public /* synthetic */ void J(c.a aVar, O2.u uVar) {
        P2.b.p(this, aVar, uVar);
    }

    public final void J0(q3.a aVar, String str) {
        for (int i = 0; i < aVar.f(); i++) {
            E0(str + aVar.e(i));
        }
    }

    public void K(c.a aVar, int i) {
        D0(aVar, "playbackSuppressionReason", w0(i));
    }

    public void L(c.a aVar) {
        C0(aVar, "drmSessionReleased");
    }

    public void M(c.a aVar, Q2.e eVar) {
        D0(aVar, "audioAttributes", eVar.a + "," + eVar.c + "," + eVar.d + "," + eVar.e);
    }

    public void N(c.a aVar, String str) {
        D0(aVar, "videoDecoderReleased", str);
    }

    public /* synthetic */ void O(c.a aVar, int i, int i2, int i3, float f) {
        P2.b.j0(this, aVar, i, i2, i3, f);
    }

    public /* synthetic */ void P(c.a aVar, boolean z) {
        P2.b.F(this, aVar, z);
    }

    public /* synthetic */ void Q(c.a aVar) {
        P2.b.O(this, aVar);
    }

    public /* synthetic */ void R(c.a aVar, z0 z0Var) {
        P2.b.h0(this, aVar, z0Var);
    }

    public void T(c.a aVar, U2.e eVar) {
        C0(aVar, "videoEnabled");
    }

    public /* synthetic */ void U(c.a aVar, Exception exc) {
        P2.b.b0(this, aVar, exc);
    }

    public void V(c.a aVar, int i) {
        D0(aVar, "state", y0(i));
    }

    public void W(c.a aVar, Exception exc) {
        I0(aVar, "drmSessionManagerError", exc);
    }

    public void X(c.a aVar, int i) {
        D0(aVar, "drmSessionAcquired", "state=" + i);
    }

    public void Y(c.a aVar, B3.x xVar) {
        D0(aVar, "downstreamFormat", z0.k(xVar.c));
    }

    public void Z(c.a aVar, String str) {
        D0(aVar, "audioDecoderReleased", str);
    }

    public void a(c.a aVar, z0 z0Var, U2.h hVar) {
        D0(aVar, "videoInputFormat", z0.k(z0Var));
    }

    public void a0(c.a aVar, B3.u uVar, B3.x xVar, IOException iOException, boolean z) {
        I0(aVar, "loadError", iOException);
    }

    public void b0(c.a aVar, boolean z) {
        D0(aVar, "shuffleModeEnabled", Boolean.toString(z));
    }

    public void c(c.a aVar) {
        C0(aVar, "drmKeysRestored");
    }

    public /* synthetic */ void c0(c.a aVar, long j) {
        P2.b.j(this, aVar, j);
    }

    public void d0(c.a aVar, q3.a aVar2) {
        E0("metadata [" + x(aVar));
        J0(aVar2, "  ");
        E0("]");
    }

    public /* synthetic */ void e(c.a aVar, int i) {
        P2.b.Q(this, aVar, i);
    }

    public void e0(c.a aVar, int i) {
        int n = aVar.b.n();
        int u = aVar.b.u();
        E0("timeline [" + x(aVar) + ", periodCount=" + n + ", windowCount=" + u + ", reason=" + A0(i));
        for (int i2 = 0; i2 < Math.min(n, 3); i2++) {
            aVar.b.k(i2, this.c);
            E0("  period [" + z0(this.c.o()) + "]");
        }
        if (n > 3) {
            E0("  ...");
        }
        for (int i3 = 0; i3 < Math.min(u, 3); i3++) {
            aVar.b.s(i3, this.b);
            E0("  window [" + z0(this.b.f()) + ", seekable=" + this.b.i + ", dynamic=" + this.b.j + "]");
        }
        if (u > 3) {
            E0("  ...");
        }
        E0("]");
    }

    public /* synthetic */ void f(c.a aVar) {
        P2.b.u(this, aVar);
    }

    public /* synthetic */ void f0(c.a aVar, boolean z, int i) {
        P2.b.P(this, aVar, z, i);
    }

    public void g(c.a aVar, boolean z) {
        D0(aVar, "loading", Boolean.toString(z));
    }

    public void g0(c.a aVar, String str, long j) {
        D0(aVar, "audioDecoderInitialized", str);
    }

    public /* synthetic */ void h(c.a aVar, Z3.z zVar) {
        P2.b.Y(this, aVar, zVar);
    }

    public void h0(c.a aVar, int i, long j) {
        D0(aVar, "droppedFrames", Integer.toString(i));
    }

    public /* synthetic */ void i(c.a aVar) {
        P2.b.T(this, aVar);
    }

    public /* synthetic */ void j(c.a aVar, Exception exc) {
        P2.b.k(this, aVar, exc);
    }

    public void j0(c.a aVar, boolean z, int i) {
        D0(aVar, "playWhenReady", z + ", " + v0(i));
    }

    public void k(c.a aVar, V1 v1) {
        q3.a aVar2;
        E0("tracks [" + x(aVar));
        s5.y c = v1.c();
        for (int i = 0; i < c.size(); i++) {
            V1.a aVar3 = (V1.a) c.get(i);
            E0("  group [");
            for (int i2 = 0; i2 < aVar3.a; i2++) {
                E0("    " + B0(aVar3.j(i2)) + " Track:" + i2 + ", " + z0.k(aVar3.c(i2)) + ", supported=" + k0.b0(aVar3.d(i2)));
            }
            E0("  ]");
        }
        boolean z = false;
        for (int i3 = 0; !z && i3 < c.size(); i3++) {
            V1.a aVar4 = (V1.a) c.get(i3);
            for (int i4 = 0; !z && i4 < aVar4.a; i4++) {
                if (aVar4.j(i4) && (aVar2 = aVar4.c(i4).k) != null && aVar2.f() > 0) {
                    E0("  Metadata [");
                    J0(aVar2, "    ");
                    E0("  ]");
                    z = true;
                }
            }
        }
        E0("]");
    }

    public void k0(c.a aVar) {
        C0(aVar, "drmKeysLoaded");
    }

    public void l(c.a aVar, z0 z0Var, U2.h hVar) {
        D0(aVar, "audioInputFormat", z0.k(z0Var));
    }

    public void l0(c.a aVar, boolean z) {
        D0(aVar, "skipSilenceEnabled", Boolean.toString(z));
    }

    public void m(c.a aVar) {
        C0(aVar, "drmKeysRemoved");
    }

    public /* synthetic */ void m0(c.a aVar, int i, boolean z) {
        P2.b.q(this, aVar, i, z);
    }

    public /* synthetic */ void n(c.a aVar, long j, int i) {
        P2.b.g0(this, aVar, j, i);
    }

    public /* synthetic */ void n0(c.a aVar, z0 z0Var) {
        P2.b.h(this, aVar, z0Var);
    }

    public void o(c.a aVar, int i, int i2) {
        D0(aVar, "surfaceSize", i + ", " + i2);
    }

    public void o0(c.a aVar, e4.C c) {
        D0(aVar, "videoSize", c.a + ", " + c.c);
    }

    public void p(c.a aVar, t1.e eVar, t1.e eVar2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("reason=");
        sb.append(b(i));
        sb.append(", PositionInfo:old [");
        sb.append("mediaItem=");
        sb.append(eVar.d);
        sb.append(", period=");
        sb.append(eVar.g);
        sb.append(", pos=");
        sb.append(eVar.h);
        if (eVar.j != -1) {
            sb.append(", contentPos=");
            sb.append(eVar.i);
            sb.append(", adGroup=");
            sb.append(eVar.j);
            sb.append(", ad=");
            sb.append(eVar.k);
        }
        sb.append("], PositionInfo:new [");
        sb.append("mediaItem=");
        sb.append(eVar2.d);
        sb.append(", period=");
        sb.append(eVar2.g);
        sb.append(", pos=");
        sb.append(eVar2.h);
        if (eVar2.j != -1) {
            sb.append(", contentPos=");
            sb.append(eVar2.i);
            sb.append(", adGroup=");
            sb.append(eVar2.j);
            sb.append(", ad=");
            sb.append(eVar2.k);
        }
        sb.append("]");
        D0(aVar, "positionDiscontinuity", sb.toString());
    }

    public void q(c.a aVar, U2.e eVar) {
        C0(aVar, "audioEnabled");
    }

    public /* synthetic */ void q0(c.a aVar, List list) {
        P2.b.o(this, aVar, list);
    }

    public /* synthetic */ void r(c.a aVar, P3.f fVar) {
        P2.b.n(this, aVar, fVar);
    }

    public /* synthetic */ void r0(c.a aVar, p1 p1Var) {
        P2.b.N(this, aVar, p1Var);
    }

    public /* synthetic */ void s(c.a aVar, String str, long j, long j2) {
        P2.b.d(this, aVar, str, j, j2);
    }

    public void s0(c.a aVar, U2.e eVar) {
        C0(aVar, "audioDisabled");
    }

    public void t(c.a aVar, s1 s1Var) {
        D0(aVar, "playbackParameters", s1Var.toString());
    }

    public /* synthetic */ void t0(c.a aVar, String str, long j, long j2) {
        P2.b.d0(this, aVar, str, j, j2);
    }

    public void u(c.a aVar, String str, long j) {
        D0(aVar, "videoDecoderInitialized", str);
    }

    public /* synthetic */ void u0(t1 t1Var, c.b bVar) {
        P2.b.z(this, t1Var, bVar);
    }

    public final String v(c.a aVar, String str, String str2, Throwable th) {
        String str3 = str + " [" + x(aVar);
        if (th instanceof p1) {
            str3 = str3 + ", errorCode=" + ((p1) th).d();
        }
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String f = B.f(th);
        if (!TextUtils.isEmpty(f)) {
            str3 = str3 + "\n  " + f.replace("\n", "\n  ") + '\n';
        }
        return str3 + "]";
    }

    public /* synthetic */ void w(c.a aVar, t1.b bVar) {
        P2.b.m(this, aVar, bVar);
    }

    public final String x(c.a aVar) {
        String str = "window=" + aVar.c;
        if (aVar.d != null) {
            str = str + ", period=" + aVar.b.f(aVar.d.a);
            if (aVar.d.b()) {
                str = (str + ", adGroup=" + aVar.d.b) + ", ad=" + aVar.d.c;
            }
        }
        return "eventTime=" + z0(aVar.a - this.d) + ", mediaPos=" + z0(aVar.e) + ", " + str;
    }

    public void z(c.a aVar, int i) {
        D0(aVar, "repeatMode", x0(i));
    }

    public q(Z3.u uVar) {
        this("EventLogger");
    }

    public q(String str) {
        this.a = str;
        this.b = new Q1.d();
        this.c = new Q1.b();
        this.d = SystemClock.elapsedRealtime();
    }

    public void d(c.a aVar, B3.u uVar, B3.x xVar) {
    }

    public void p0(c.a aVar, B3.u uVar, B3.x xVar) {
    }

    public void y(c.a aVar, B3.u uVar, B3.x xVar) {
    }

    public void i0(c.a aVar, int i, long j, long j2) {
    }
}
