package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class s1 extends w1 implements n2 {
    private final double[] h;

    s1(Spliterator spliterator, b bVar, double[] dArr) {
        super(spliterator, bVar, dArr.length);
        this.h = dArr;
    }

    s1(s1 s1Var, Spliterator spliterator, long j, long j2) {
        super(s1Var, spliterator, j, j2, s1Var.h.length);
        this.h = s1Var.h;
    }

    public final void accept(double d) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f));
        }
        double[] dArr = this.h;
        this.f = i + 1;
        dArr[i] = d;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.f(this, obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }

    final w1 b(Spliterator spliterator, long j, long j2) {
        return new s1(this, spliterator, j, j2);
    }

    public final /* synthetic */ void q(Double d) {
        y0.e(this, d);
    }
}
