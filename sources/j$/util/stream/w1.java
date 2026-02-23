package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class W1 extends a2 implements n2 {
    public final void accept(double d) {
        this.b++;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.f(this, obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }

    public final Object get() {
        return Long.valueOf(this.b);
    }

    public final void h(U1 u1) {
        this.b += ((a2) u1).b;
    }

    public final /* synthetic */ void q(Double d) {
        y0.e(this, d);
    }
}
