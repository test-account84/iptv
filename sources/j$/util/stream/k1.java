package j$.util.stream;

import j$.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class K1 implements U1 {
    private boolean a;
    private Object b;
    final /* synthetic */ BinaryOperator c;

    K1(BinaryOperator binaryOperator) {
        this.c = binaryOperator;
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

    public final void accept(Object obj) {
        if (this.a) {
            this.a = false;
        } else {
            obj = this.c.apply(this.b, obj);
        }
        this.b = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final Object get() {
        return this.a ? Optional.a() : Optional.d(this.b);
    }

    public final void h(U1 u1) {
        K1 k1 = (K1) u1;
        if (k1.a) {
            return;
        }
        accept(k1.b);
    }

    public final /* synthetic */ void l() {
    }

    public final void m(long j) {
        this.a = true;
        this.b = null;
    }

    public final /* synthetic */ boolean o() {
        return false;
    }
}
