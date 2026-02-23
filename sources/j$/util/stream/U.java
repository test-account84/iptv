package j$.util.stream;

import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class u extends h2 {
    public final /* synthetic */ int m;
    final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(b bVar, int i, Object obj, int i2) {
        super(bVar, i, 1);
        this.m = i2;
        this.n = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(b bVar, Consumer consumer) {
        super(bVar, 0, 1);
        this.m = 3;
        this.n = consumer;
    }

    final q2 R(int i, q2 q2Var) {
        switch (this.m) {
            case 0:
                return new t(this, q2Var, 0);
            case 1:
                return new W(this, q2Var, 0);
            case 2:
                return new e0(this, q2Var, 0);
            case 3:
                return new n(this, q2Var, 1);
            default:
                return new n(this, q2Var, 2);
        }
    }
}
