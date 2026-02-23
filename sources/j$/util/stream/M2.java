package j$.util.stream;

import j$.util.Objects;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public abstract class m2 implements q2 {
    protected final q2 a;

    public m2(q2 q2Var) {
        this.a = (q2) Objects.requireNonNull(q2Var);
    }

    public final /* synthetic */ void accept(double d) {
        y0.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i) {
        y0.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j) {
        y0.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public void l() {
        this.a.l();
    }

    public void m(long j) {
        this.a.m(j);
    }

    public boolean o() {
        return this.a.o();
    }
}
