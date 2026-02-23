package M4;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class z4 extends G1 {
    public Handler c;
    public boolean d;
    public final y4 e;
    public final x4 f;
    public final v4 g;

    public z4(l2 l2Var) {
        super(l2Var);
        this.d = true;
        this.e = new y4(this);
        this.f = new x4(this);
        this.g = new v4(this);
    }

    public static /* bridge */ /* synthetic */ Handler o(z4 z4Var) {
        return z4Var.c;
    }

    public static /* bridge */ /* synthetic */ void p(z4 z4Var) {
        z4Var.u();
    }

    public static /* bridge */ /* synthetic */ void q(z4 z4Var, long j) {
        z4Var.h();
        z4Var.u();
        z4Var.a.d().v().b("Activity paused, time", Long.valueOf(j));
        z4Var.g.a(j);
        if (z4Var.a.z().D()) {
            z4Var.f.b(j);
        }
    }

    public static /* bridge */ /* synthetic */ void r(z4 z4Var, long j) {
        z4Var.h();
        z4Var.u();
        z4Var.a.d().v().b("Activity resumed, time", Long.valueOf(j));
        if (!z4Var.a.z().B(null, m1.I0) ? z4Var.a.z().D() || z4Var.a.F().r.b() : z4Var.a.z().D() || z4Var.d) {
            z4Var.f.c(j);
        }
        z4Var.g.b();
        y4 y4Var = z4Var.e;
        y4Var.a.h();
        if (y4Var.a.a.o()) {
            y4Var.b(y4Var.a.a.a().a(), false);
        }
    }

    public final boolean n() {
        return false;
    }

    public final void s(boolean z) {
        h();
        this.d = z;
    }

    public final boolean t() {
        h();
        return this.d;
    }

    public final void u() {
        h();
        if (this.c == null) {
            this.c = new zzby(Looper.getMainLooper());
        }
    }
}
