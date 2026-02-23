package O2;

import O2.Q1;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class j implements t1 {
    public final Q1.d a = new Q1.d();

    public final void C(int i, long j) {
        q0(i, j, 10, false);
    }

    public final H0 G(int i) {
        return w().s(i, this.a).d;
    }

    public final long I() {
        Q1 w = w();
        if (w.v()) {
            return -9223372036854775807L;
        }
        return w.s(X(), this.a).f();
    }

    public final boolean M() {
        return n0() != -1;
    }

    public final boolean V() {
        Q1 w = w();
        return !w.v() && w.s(X(), this.a).i;
    }

    public final void b0() {
        u0(P(), 12);
    }

    public final void d0() {
        u0(-f0(), 11);
    }

    public final H0 f() {
        Q1 w = w();
        if (w.v()) {
            return null;
        }
        return w.s(X(), this.a).d;
    }

    public final void g() {
        s0(X(), 4);
    }

    public final boolean g0() {
        Q1 w = w();
        return !w.v() && w.s(X(), this.a).i();
    }

    public final void h0(int i, H0 h0) {
        T(i, s5.y.A(h0));
    }

    public final void i0(H0 h0) {
        j0(s5.y.A(h0));
    }

    public final boolean isPlaying() {
        return getPlaybackState() == 3 && E() && v() == 0;
    }

    public final void j0(List list) {
        T(Integer.MAX_VALUE, list);
    }

    public final int k() {
        return w().u();
    }

    public final int k0() {
        long U = U();
        long duration = getDuration();
        if (U == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return d4.k0.r((int) ((U * 100) / duration), 0, 100);
    }

    public final int l0() {
        return X();
    }

    public final void m() {
        if (w().v() || d()) {
            return;
        }
        boolean M = M();
        if (!g0() || V()) {
            if (!M || getCurrentPosition() > H()) {
                r0(0L, 7);
                return;
            }
        } else if (!M) {
            return;
        }
        v0(7);
    }

    public final int m0() {
        Q1 w = w();
        if (w.v()) {
            return -1;
        }
        return w.j(X(), o0(), Z());
    }

    public final int n0() {
        Q1 w = w();
        if (w.v()) {
            return -1;
        }
        return w.q(X(), o0(), Z());
    }

    public final int o0() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public final void p0(int i) {
        q0(X(), -9223372036854775807L, i, true);
    }

    public final void pause() {
        o(false);
    }

    public final void play() {
        o(true);
    }

    public final boolean q() {
        return m0() != -1;
    }

    public abstract void q0(int i, long j, int i2, boolean z);

    public final void r0(long j, int i) {
        q0(X(), j, i, false);
    }

    public final void s0(int i, int i2) {
        q0(i, -9223372036854775807L, i2, false);
    }

    public final void seekTo(long j) {
        r0(j, 5);
    }

    public final boolean t(int i) {
        return D().c(i);
    }

    public final void t0(int i) {
        int m0 = m0();
        if (m0 == -1) {
            return;
        }
        if (m0 == X()) {
            p0(i);
        } else {
            s0(m0, i);
        }
    }

    public final boolean u() {
        Q1 w = w();
        return !w.v() && w.s(X(), this.a).j;
    }

    public final void u0(long j, int i) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        r0(Math.max(currentPosition, 0L), i);
    }

    public final void v0(int i) {
        int n0 = n0();
        if (n0 == -1) {
            return;
        }
        if (n0 == X()) {
            p0(i);
        } else {
            s0(n0, i);
        }
    }

    public final void w0(H0 h0, boolean z) {
        h(s5.y.A(h0), z);
    }

    public final void x0(float f) {
        b(c().d(f));
    }

    public final void z() {
        if (w().v() || d()) {
            return;
        }
        if (q()) {
            t0(9);
        } else if (g0() && u()) {
            s0(X(), 9);
        }
    }
}
