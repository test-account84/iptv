package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class Y1 extends a2 implements p2 {
    public final void accept(long j) {
        this.b++;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.j(this, obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }

    public final Object get() {
        return Long.valueOf(this.b);
    }

    public final void h(U1 u1) {
        this.b += ((a2) u1).b;
    }

    public final /* synthetic */ void k(Long l) {
        y0.i(this, l);
    }
}
