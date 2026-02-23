package j$.util.stream;

import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class X1 extends a2 implements o2 {
    public final void accept(int i) {
        this.b++;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.h(this, obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }

    public final Object get() {
        return Long.valueOf(this.b);
    }

    public final void h(U1 u1) {
        this.b += ((a2) u1).b;
    }

    public final /* synthetic */ void n(Integer num) {
        y0.g(this, num);
    }
}
