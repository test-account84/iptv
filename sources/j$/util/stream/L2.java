package j$.util.stream;

import j$.util.Objects;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public abstract class l2 implements p2 {
    protected final q2 a;

    public l2(q2 q2Var) {
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

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.j(this, obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }

    public final /* synthetic */ void k(Long l) {
        y0.i(this, l);
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
