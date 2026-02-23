package j$.util.stream;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class J1 extends V1 implements U1 {
    final /* synthetic */ Object b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ BinaryOperator d;

    J1(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.b = obj;
        this.c = biFunction;
        this.d = binaryOperator;
    }

    public final /* synthetic */ void accept(double d) {
        y0.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i) {
        y0.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j) {
        y0.l();
        throw null;
    }

    public final void accept(Object obj) {
        this.a = this.c.apply(this.a, obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final void h(U1 u1) {
        this.a = this.d.apply(this.a, ((J1) u1).a);
    }

    public final /* synthetic */ void l() {
    }

    public final void m(long j) {
        this.a = this.b;
    }

    public final /* synthetic */ boolean o() {
        return false;
    }
}
