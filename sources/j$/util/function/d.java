package j$.util.function;

import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class d implements IntConsumer {
    public final /* synthetic */ IntConsumer a;
    public final /* synthetic */ IntConsumer b;

    public /* synthetic */ d(IntConsumer intConsumer, IntConsumer intConsumer2) {
        this.a = intConsumer;
        this.b = intConsumer2;
    }

    public final void accept(int i) {
        this.a.accept(i);
        this.b.accept(i);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }
}
