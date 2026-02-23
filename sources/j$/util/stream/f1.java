package j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class F1 implements U1, n2 {
    private boolean a;
    private double b;
    final /* synthetic */ DoubleBinaryOperator c;

    F1(DoubleBinaryOperator doubleBinaryOperator) {
        this.c = doubleBinaryOperator;
    }

    public final void accept(double d) {
        if (this.a) {
            this.a = false;
        } else {
            d = this.c.applyAsDouble(this.b, d);
        }
        this.b = d;
    }

    public final /* synthetic */ void accept(int i) {
        y0.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j) {
        y0.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.f(this, obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }

    public final Object get() {
        return this.a ? j$.util.k.a() : j$.util.k.d(this.b);
    }

    public final void h(U1 u1) {
        F1 f1 = (F1) u1;
        if (f1.a) {
            return;
        }
        accept(f1.b);
    }

    public final /* synthetic */ void l() {
    }

    public final void m(long j) {
        this.a = true;
        this.b = 0.0d;
    }

    public final /* synthetic */ boolean o() {
        return false;
    }

    public final /* synthetic */ void q(Double d) {
        y0.e(this, d);
    }
}
