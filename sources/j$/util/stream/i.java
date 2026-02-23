package j$.util.stream;

import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class I extends L implements o2 {
    static final G c;
    static final G d;

    static {
        f3 f3Var = f3.INT_VALUE;
        c = new G(true, f3Var, j$.util.l.a(), new s(2), new q(5));
        d = new G(false, f3Var, j$.util.l.a(), new s(2), new q(5));
    }

    public final void accept(int i) {
        accept(Integer.valueOf(i));
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }

    public final Object get() {
        if (this.a) {
            return j$.util.l.d(((Integer) this.b).intValue());
        }
        return null;
    }
}
