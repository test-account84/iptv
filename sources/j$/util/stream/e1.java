package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class E1 extends y0 {
    public final /* synthetic */ int h;
    final /* synthetic */ Object i;
    final /* synthetic */ Object j;
    final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ E1(f3 f3Var, Object obj, Object obj2, Object obj3, int i) {
        super(f3Var);
        this.h = i;
        this.i = obj;
        this.k = obj2;
        this.j = obj3;
    }

    public /* synthetic */ E1(f3 f3Var, BinaryOperator binaryOperator, Object obj, Supplier supplier, int i) {
        this.h = i;
        this.i = binaryOperator;
        this.k = obj;
        this.j = supplier;
    }

    public final U1 e0() {
        switch (this.h) {
            case 0:
                return new B1((Supplier) this.j, (ObjLongConsumer) this.k, (BinaryOperator) this.i);
            case 1:
                return new H1((Supplier) this.j, (ObjDoubleConsumer) this.k, (BinaryOperator) this.i);
            case 2:
                return new J1(this.j, (BiFunction) this.k, (BinaryOperator) this.i);
            case 3:
                return new N1((Supplier) this.j, (BiConsumer) this.k, (BiConsumer) this.i);
            default:
                return new R1((Supplier) this.j, (ObjIntConsumer) this.k, (BinaryOperator) this.i);
        }
    }
}
