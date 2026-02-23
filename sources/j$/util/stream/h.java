package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class H extends L implements n2 {
    static final G c;
    static final G d;

    static {
        f3 f3Var = f3.DOUBLE_VALUE;
        c = new G(true, f3Var, j$.util.k.a(), new s(1), new q(4));
        d = new G(false, f3Var, j$.util.k.a(), new s(1), new q(4));
    }

    public final void accept(double d2) {
        accept(Double.valueOf(d2));
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }

    public final Object get() {
        if (this.a) {
            return j$.util.k.d(((Double) this.b).doubleValue());
        }
        return null;
    }
}
