package j$.util.function;

import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class b implements DoubleConsumer {
    public final /* synthetic */ DoubleConsumer a;
    public final /* synthetic */ DoubleConsumer b;

    public /* synthetic */ b(DoubleConsumer doubleConsumer, DoubleConsumer doubleConsumer2) {
        this.a = doubleConsumer;
        this.b = doubleConsumer2;
    }

    public final void accept(double d) {
        this.a.accept(d);
        this.b.accept(d);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }
}
