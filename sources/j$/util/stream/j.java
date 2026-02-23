package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class J extends L implements p2 {
    static final G c;
    static final G d;

    static {
        f3 f3Var = f3.LONG_VALUE;
        c = new G(true, f3Var, j$.util.m.a(), new s(3), new q(6));
        d = new G(false, f3Var, j$.util.m.a(), new s(3), new q(6));
    }

    public final void accept(long j) {
        accept(Long.valueOf(j));
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }

    public final Object get() {
        if (this.a) {
            return j$.util.m.d(((Long) this.b).longValue());
        }
        return null;
    }
}
