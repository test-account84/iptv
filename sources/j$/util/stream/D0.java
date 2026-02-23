package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class d0 implements LongConsumer {
    public final /* synthetic */ q2 a;

    public /* synthetic */ d0(q2 q2Var) {
        this.a = q2Var;
    }

    public final void accept(long j) {
        this.a.accept(j);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }
}
