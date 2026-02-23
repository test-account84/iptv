package j$.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class q1 extends p1 implements B0 {
    public final I0 a() {
        int i = this.b;
        long[] jArr = this.a;
        if (i >= jArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(jArr.length)}));
    }

    public final /* bridge */ /* synthetic */ K0 a() {
        a();
        return this;
    }

    public final /* synthetic */ void accept(double d) {
        y0.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i) {
        y0.k();
        throw null;
    }

    public final void accept(long j) {
        int i = this.b;
        long[] jArr = this.a;
        if (i >= jArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(jArr.length)}));
        }
        this.b = 1 + i;
        jArr[i] = j;
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

    public final void l() {
        int i = this.b;
        long[] jArr = this.a;
        if (i < jArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(jArr.length)}));
        }
    }

    public final void m(long j) {
        long[] jArr = this.a;
        if (j != jArr.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(jArr.length)}));
        }
        this.b = 0;
    }

    public final /* synthetic */ boolean o() {
        return false;
    }

    public final String toString() {
        long[] jArr = this.a;
        return String.format("LongFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.b), Arrays.toString(jArr)});
    }
}
