package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class u2 extends b0 {
    final /* synthetic */ long m;
    final /* synthetic */ long n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u2(b bVar, int i, long j, long j2) {
        super(bVar, i, 0);
        this.m = j;
        this.n = j2;
    }

    final K0 O(b bVar, Spliterator spliterator, IntFunction intFunction) {
        long j;
        long j2;
        long G = bVar.G(spliterator);
        if (G > 0 && spliterator.hasCharacteristics(16384)) {
            return y0.G(bVar, y0.C(bVar.J(), spliterator, this.m, this.n), true);
        }
        if (e3.ORDERED.q(bVar.K())) {
            return (K0) new A2(this, bVar, spliterator, intFunction, this.m, this.n).invoke();
        }
        j$.util.H h = (j$.util.H) bVar.X(spliterator);
        long j3 = this.m;
        long j4 = this.n;
        if (j3 <= G) {
            j = j4 >= 0 ? Math.min(j4, G - j3) : G - j3;
            j2 = 0;
        } else {
            j = j4;
            j2 = j3;
        }
        return y0.G(this, new B3(h, j2, j), true);
    }

    final Spliterator P(b bVar, Spliterator spliterator) {
        long j;
        long j2;
        long G = bVar.G(spliterator);
        long j3 = this.n;
        if (G > 0 && spliterator.hasCharacteristics(16384)) {
            j$.util.H h = (j$.util.H) bVar.X(spliterator);
            long j4 = this.m;
            return new v3(h, j4, y0.B(j4, j3));
        }
        if (e3.ORDERED.q(bVar.K())) {
            return ((K0) new A2(this, bVar, spliterator, new c2(1), this.m, this.n).invoke()).spliterator();
        }
        j$.util.H h2 = (j$.util.H) bVar.X(spliterator);
        long j5 = this.m;
        if (j5 <= G) {
            long j6 = G - j5;
            if (j3 >= 0) {
                j6 = Math.min(j3, j6);
            }
            j = j6;
            j2 = 0;
        } else {
            j = j3;
            j2 = j5;
        }
        return new B3(h2, j2, j);
    }

    final q2 R(int i, q2 q2Var) {
        return new t2(this, q2Var);
    }
}
