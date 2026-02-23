package j$.util.stream;

import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class X extends b0 {
    public final /* synthetic */ int m;
    final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ X(b bVar, int i, Object obj, int i2) {
        super(bVar, i, 1);
        this.m = i2;
        this.n = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(b bVar, IntConsumer intConsumer) {
        super(bVar, 0, 1);
        this.m = 0;
        this.n = intConsumer;
    }

    final q2 R(int i, q2 q2Var) {
        switch (this.m) {
            case 0:
                return new W(this, q2Var, 1);
            case 1:
                return new Z(this, q2Var);
            case 2:
                return new n(this, q2Var, 4);
            default:
                return new d2(this, q2Var);
        }
    }
}
