package j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class H1 extends V1 implements U1, n2 {
    final /* synthetic */ Supplier b;
    final /* synthetic */ ObjDoubleConsumer c;
    final /* synthetic */ BinaryOperator d;

    H1(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BinaryOperator binaryOperator) {
        this.b = supplier;
        this.c = objDoubleConsumer;
        this.d = binaryOperator;
    }

    public final void accept(double d) {
        this.c.accept(this.a, d);
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

    public final void h(U1 u1) {
        this.a = this.d.apply(this.a, ((H1) u1).a);
    }

    public final /* synthetic */ void l() {
    }

    public final void m(long j) {
        this.a = this.b.get();
    }

    public final /* synthetic */ boolean o() {
        return false;
    }

    public final /* synthetic */ void q(Double d) {
        y0.e(this, d);
    }
}
