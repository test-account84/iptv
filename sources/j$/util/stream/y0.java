package j$.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class Y0 extends X0 implements z0 {
    public final E0 a() {
        int i = this.b;
        double[] dArr = this.a;
        if (i >= dArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(dArr.length)}));
    }

    public final /* bridge */ /* synthetic */ K0 a() {
        a();
        return this;
    }

    public final void accept(double d) {
        int i = this.b;
        double[] dArr = this.a;
        if (i >= dArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(dArr.length)}));
        }
        this.b = 1 + i;
        dArr[i] = d;
    }

    public final /* synthetic */ void accept(int i) {
        y0.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j) {
        y0.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.f(this, obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }

    public final void l() {
        int i = this.b;
        double[] dArr = this.a;
        if (i < dArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(dArr.length)}));
        }
    }

    public final void m(long j) {
        double[] dArr = this.a;
        if (j != dArr.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(dArr.length)}));
        }
        this.b = 0;
    }

    public final /* synthetic */ boolean o() {
        return false;
    }

    public final /* synthetic */ void q(Double d) {
        y0.e(this, d);
    }

    public final String toString() {
        double[] dArr = this.a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.b), Arrays.toString(dArr)});
    }
}
