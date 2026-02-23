package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class p implements DoubleConsumer {
    public final /* synthetic */ q2 a;

    public /* synthetic */ p(q2 q2Var) {
        this.a = q2Var;
    }

    public final void accept(double d) {
        this.a.accept(d);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }
}
