package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class h0 extends H {
    public long d;
    public boolean e;
    public kotlinx.coroutines.internal.a f;

    public static /* synthetic */ void g0(h0 h0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        h0Var.f0(z);
    }

    public static /* synthetic */ void l0(h0 h0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        h0Var.k0(z);
    }

    public final void f0(boolean z) {
        long h0 = this.d - h0(z);
        this.d = h0;
        if (h0 <= 0 && this.e) {
            shutdown();
        }
    }

    public final long h0(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void i0(Z z) {
        kotlinx.coroutines.internal.a aVar = this.f;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a();
            this.f = aVar;
        }
        aVar.a(z);
    }

    public long j0() {
        kotlinx.coroutines.internal.a aVar = this.f;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void k0(boolean z) {
        this.d += h0(z);
        if (z) {
            return;
        }
        this.e = true;
    }

    public final boolean m0() {
        return this.d >= h0(true);
    }

    public final boolean n0() {
        kotlinx.coroutines.internal.a aVar = this.f;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public abstract long o0();

    public final boolean p0() {
        Z z;
        kotlinx.coroutines.internal.a aVar = this.f;
        if (aVar == null || (z = (Z) aVar.d()) == null) {
            return false;
        }
        z.run();
        return true;
    }

    public boolean q0() {
        return false;
    }

    public abstract void shutdown();
}
