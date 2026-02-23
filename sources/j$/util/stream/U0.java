package j$.util.stream;

import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class u0 implements q2 {
    boolean a;
    boolean b;

    u0(v0 v0Var) {
        this.b = !v0.i(v0Var);
    }

    public /* synthetic */ void accept(double d) {
        y0.a();
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        y0.k();
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        y0.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final /* synthetic */ void l() {
    }

    public final /* synthetic */ void m(long j) {
    }

    public final boolean o() {
        return this.a;
    }
}
