package j$.util.function;

import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class e implements LongConsumer {
    public final /* synthetic */ LongConsumer a;
    public final /* synthetic */ LongConsumer b;

    public /* synthetic */ e(LongConsumer longConsumer, LongConsumer longConsumer2) {
        this.a = longConsumer;
        this.b = longConsumer2;
    }

    public final void accept(long j) {
        this.a.accept(j);
        this.b.accept(j);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }
}
