package P3;

import O2.A0;
import O2.D1;
import O2.z0;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d4.B;
import d4.F;
import d4.k0;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r extends O2.k implements Handler.Callback {
    public n A;
    public o B;
    public o C;
    public int D;
    public long E;
    public long F;
    public long G;
    public final Handler q;
    public final q r;
    public final l s;
    public final A0 t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public z0 y;
    public j z;

    public r(q qVar, Looper looper) {
        this(qVar, looper, l.a);
    }

    private long V(long j) {
        d4.a.g(j != -9223372036854775807L);
        d4.a.g(this.F != -9223372036854775807L);
        return j - this.F;
    }

    private void a0() {
        Z();
        ((j) d4.a.e(this.z)).release();
        this.z = null;
        this.x = 0;
    }

    public void G() {
        this.y = null;
        this.E = -9223372036854775807L;
        S();
        this.F = -9223372036854775807L;
        this.G = -9223372036854775807L;
        a0();
    }

    public void I(long j, boolean z) {
        this.G = j;
        S();
        this.u = false;
        this.v = false;
        this.E = -9223372036854775807L;
        if (this.x != 0) {
            b0();
        } else {
            Z();
            ((j) d4.a.e(this.z)).flush();
        }
    }

    public void O(z0[] z0VarArr, long j, long j2) {
        this.F = j2;
        this.y = z0VarArr[0];
        if (this.z != null) {
            this.x = 1;
        } else {
            X();
        }
    }

    public final void S() {
        d0(new f(y.z(), V(this.G)));
    }

    public final long T(long j) {
        int a = this.B.a(j);
        if (a == 0 || this.B.h() == 0) {
            return this.B.timeUs;
        }
        if (a != -1) {
            return this.B.c(a - 1);
        }
        return this.B.c(r2.h() - 1);
    }

    public final long U() {
        if (this.D == -1) {
            return Long.MAX_VALUE;
        }
        d4.a.e(this.B);
        if (this.D >= this.B.h()) {
            return Long.MAX_VALUE;
        }
        return this.B.c(this.D);
    }

    public final void W(k kVar) {
        B.e("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.y, kVar);
        S();
        b0();
    }

    public final void X() {
        this.w = true;
        this.z = this.s.b((z0) d4.a.e(this.y));
    }

    public final void Y(f fVar) {
        this.r.k(fVar.a);
        this.r.u(fVar);
    }

    public final void Z() {
        this.A = null;
        this.D = -1;
        o oVar = this.B;
        if (oVar != null) {
            oVar.release();
            this.B = null;
        }
        o oVar2 = this.C;
        if (oVar2 != null) {
            oVar2.release();
            this.C = null;
        }
    }

    public int a(z0 z0Var) {
        if (this.s.a(z0Var)) {
            return D1.a(z0Var.H == 0 ? 4 : 2);
        }
        return D1.a(F.r(z0Var.m) ? 1 : 0);
    }

    public final void b0() {
        a0();
        X();
    }

    public void c0(long j) {
        d4.a.g(p());
        this.E = j;
    }

    public boolean d() {
        return this.v;
    }

    public final void d0(f fVar) {
        Handler handler = this.q;
        if (handler != null) {
            handler.obtainMessage(0, fVar).sendToTarget();
        } else {
            Y(fVar);
        }
    }

    public boolean e() {
        return true;
    }

    public String getName() {
        return "TextRenderer";
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        Y((f) message.obj);
        return true;
    }

    public void u(long j, long j2) {
        boolean z;
        this.G = j;
        if (p()) {
            long j3 = this.E;
            if (j3 != -9223372036854775807L && j >= j3) {
                Z();
                this.v = true;
            }
        }
        if (this.v) {
            return;
        }
        if (this.C == null) {
            ((j) d4.a.e(this.z)).a(j);
            try {
                this.C = (o) ((j) d4.a.e(this.z)).b();
            } catch (k e) {
                W(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.B != null) {
            long U = U();
            z = false;
            while (U <= j) {
                this.D++;
                U = U();
                z = true;
            }
        } else {
            z = false;
        }
        o oVar = this.C;
        if (oVar != null) {
            if (oVar.isEndOfStream()) {
                if (!z && U() == Long.MAX_VALUE) {
                    if (this.x == 2) {
                        b0();
                    } else {
                        Z();
                        this.v = true;
                    }
                }
            } else if (oVar.timeUs <= j) {
                o oVar2 = this.B;
                if (oVar2 != null) {
                    oVar2.release();
                }
                this.D = oVar.a(j);
                this.B = oVar;
                this.C = null;
                z = true;
            }
        }
        if (z) {
            d4.a.e(this.B);
            d0(new f(this.B.b(j), V(T(j))));
        }
        if (this.x == 2) {
            return;
        }
        while (!this.u) {
            try {
                n nVar = this.A;
                if (nVar == null) {
                    nVar = (n) ((j) d4.a.e(this.z)).d();
                    if (nVar == null) {
                        return;
                    } else {
                        this.A = nVar;
                    }
                }
                if (this.x == 1) {
                    nVar.setFlags(4);
                    ((j) d4.a.e(this.z)).c(nVar);
                    this.A = null;
                    this.x = 2;
                    return;
                }
                int P = P(this.t, nVar, 0);
                if (P == -4) {
                    if (nVar.isEndOfStream()) {
                        this.u = true;
                        this.w = false;
                    } else {
                        z0 z0Var = this.t.b;
                        if (z0Var == null) {
                            return;
                        }
                        nVar.j = z0Var.q;
                        nVar.i();
                        this.w &= !nVar.isKeyFrame();
                    }
                    if (!this.w) {
                        ((j) d4.a.e(this.z)).c(nVar);
                        this.A = null;
                    }
                } else if (P == -3) {
                    return;
                }
            } catch (k e2) {
                W(e2);
                return;
            }
        }
    }

    public r(q qVar, Looper looper, l lVar) {
        super(3);
        this.r = (q) d4.a.e(qVar);
        this.q = looper == null ? null : k0.w(looper, this);
        this.s = lVar;
        this.t = new A0();
        this.E = -9223372036854775807L;
        this.F = -9223372036854775807L;
        this.G = -9223372036854775807L;
    }
}
