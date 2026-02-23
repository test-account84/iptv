package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class g4 extends c {
    private final b j;
    private final IntFunction k;
    private final boolean l;
    private long m;
    private boolean n;
    private volatile boolean o;

    g4(b bVar, b bVar2, Spliterator spliterator, IntFunction intFunction) {
        super(bVar2, spliterator);
        this.j = bVar;
        this.k = intFunction;
        this.l = e3.ORDERED.q(bVar2.K());
    }

    g4(g4 g4Var, Spliterator spliterator) {
        super(g4Var, spliterator);
        this.j = g4Var.j;
        this.k = g4Var.k;
        this.l = g4Var.l;
    }

    protected final Object a() {
        C0 N = this.a.N(-1L, this.k);
        q2 R = this.j.R(this.a.K(), N);
        b bVar = this.a;
        boolean B = bVar.B(this.b, bVar.W(R));
        this.n = B;
        if (B) {
            i();
        }
        K0 a = N.a();
        this.m = a.count();
        return a;
    }

    protected final e e(Spliterator spliterator) {
        return new g4(this, spliterator);
    }

    protected final void h() {
        this.i = true;
        if (this.l && this.o) {
            f(y0.L(this.j.I()));
        }
    }

    protected final Object j() {
        return y0.L(this.j.I());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCompletion(java.util.concurrent.CountedCompleter r9) {
        /*
            r8 = this;
            j$.util.stream.e r0 = r8.d
            if (r0 != 0) goto L6
            goto L89
        L6:
            j$.util.stream.g4 r0 = (j$.util.stream.g4) r0
            boolean r0 = r0.n
            j$.util.stream.e r1 = r8.e
            j$.util.stream.g4 r1 = (j$.util.stream.g4) r1
            boolean r1 = r1.n
            r0 = r0 | r1
            r8.n = r0
            boolean r0 = r8.l
            r1 = 0
            if (r0 == 0) goto L2a
            boolean r0 = r8.i
            if (r0 == 0) goto L2a
            r8.m = r1
            j$.util.stream.b r0 = r8.j
            j$.util.stream.f3 r0 = r0.I()
            j$.util.stream.e1 r0 = j$.util.stream.y0.L(r0)
            goto L86
        L2a:
            boolean r0 = r8.l
            if (r0 == 0) goto L41
            j$.util.stream.e r0 = r8.d
            j$.util.stream.g4 r0 = (j$.util.stream.g4) r0
            boolean r3 = r0.n
            if (r3 == 0) goto L41
            long r1 = r0.m
            r8.m = r1
            java.lang.Object r0 = r0.c()
            j$.util.stream.K0 r0 = (j$.util.stream.K0) r0
            goto L86
        L41:
            j$.util.stream.e r0 = r8.d
            j$.util.stream.g4 r0 = (j$.util.stream.g4) r0
            long r3 = r0.m
            j$.util.stream.e r5 = r8.e
            j$.util.stream.g4 r5 = (j$.util.stream.g4) r5
            long r6 = r5.m
            long r3 = r3 + r6
            r8.m = r3
            long r3 = r0.m
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 != 0) goto L5d
            java.lang.Object r0 = r5.c()
        L5a:
            j$.util.stream.K0 r0 = (j$.util.stream.K0) r0
            goto L86
        L5d:
            long r3 = r5.m
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 != 0) goto L68
            java.lang.Object r0 = r0.c()
            goto L5a
        L68:
            j$.util.stream.b r0 = r8.j
            j$.util.stream.f3 r0 = r0.I()
            j$.util.stream.e r1 = r8.d
            j$.util.stream.g4 r1 = (j$.util.stream.g4) r1
            java.lang.Object r1 = r1.c()
            j$.util.stream.K0 r1 = (j$.util.stream.K0) r1
            j$.util.stream.e r2 = r8.e
            j$.util.stream.g4 r2 = (j$.util.stream.g4) r2
            java.lang.Object r2 = r2.c()
            j$.util.stream.K0 r2 = (j$.util.stream.K0) r2
            j$.util.stream.M0 r0 = j$.util.stream.y0.I(r0, r1, r2)
        L86:
            r8.f(r0)
        L89:
            r0 = 1
            r8.o = r0
            super.onCompletion(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.g4.onCompletion(java.util.concurrent.CountedCompleter):void");
    }
}
