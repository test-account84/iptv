package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class r0 extends u0 implements o2 {
    public final void accept(int i) {
        if (this.a) {
            return;
        }
        IntPredicate intPredicate = null;
        intPredicate.test(i);
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.h(this, obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }

    public final /* synthetic */ void n(Integer num) {
        y0.g(this, num);
    }
}
