package j$.util.stream;

import java.util.function.DoubleBinaryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class I1 extends y0 {
    final /* synthetic */ DoubleBinaryOperator h;
    final /* synthetic */ double i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    I1(f3 f3Var, DoubleBinaryOperator doubleBinaryOperator, double d) {
        super(f3Var);
        this.h = doubleBinaryOperator;
        this.i = d;
    }

    public final U1 e0() {
        return new D1(this.i, this.h);
    }
}
