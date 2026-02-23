package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class f4 extends e {
    private final b h;
    private final IntFunction i;
    private final boolean j;
    private long k;
    private long l;

    f4(b bVar, b bVar2, Spliterator spliterator, IntFunction intFunction) {
        super(bVar2, spliterator);
        this.h = bVar;
        this.i = intFunction;
        this.j = e3.ORDERED.q(bVar2.K());
    }

    f4(f4 f4Var, Spliterator spliterator) {
        super(f4Var, spliterator);
        this.h = f4Var.h;
        this.i = f4Var.i;
        this.j = f4Var.j;
    }

    protected final Object a() {
        boolean z = !d();
        C0 N = this.a.N((z && this.j && e3.SIZED.t(this.h.c)) ? this.h.G(this.b) : -1L, this.i);
        e4 k = ((d4) this.h).k(N, this.j && z);
        this.a.V(this.b, k);
        K0 a = N.a();
        this.k = a.count();
        this.l = k.g();
        return a;
    }

    protected final e e(Spliterator spliterator) {
        return new f4(this, spliterator);
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        K0 I;
        Object c;
        K0 k0;
        e eVar = this.d;
        if (eVar != null) {
            if (this.j) {
                f4 f4Var = (f4) eVar;
                long j = f4Var.l;
                this.l = j;
                if (j == f4Var.k) {
                    this.l = j + ((f4) this.e).l;
                }
            }
            f4 f4Var2 = (f4) eVar;
            long j2 = f4Var2.k;
            f4 f4Var3 = (f4) this.e;
            this.k = j2 + f4Var3.k;
            if (f4Var2.k == 0) {
                c = f4Var3.c();
            } else if (f4Var3.k == 0) {
                c = f4Var2.c();
            } else {
                I = y0.I(this.h.I(), (K0) ((f4) this.d).c(), (K0) ((f4) this.e).c());
                k0 = I;
                if (d() && this.j) {
                    k0 = k0.i(this.l, k0.count(), this.i);
                }
                f(k0);
            }
            I = (K0) c;
            k0 = I;
            if (d()) {
                k0 = k0.i(this.l, k0.count(), this.i);
            }
            f(k0);
        }
        super.onCompletion(countedCompleter);
    }
}
