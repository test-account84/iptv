package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class u1 extends w1 implements p2 {
    private final long[] h;

    u1(Spliterator spliterator, b bVar, long[] jArr) {
        super(spliterator, bVar, jArr.length);
        this.h = jArr;
    }

    u1(u1 u1Var, Spliterator spliterator, long j, long j2) {
        super(u1Var, spliterator, j, j2, u1Var.h.length);
        this.h = u1Var.h;
    }

    public final void accept(long j) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f));
        }
        long[] jArr = this.h;
        this.f = i + 1;
        jArr[i] = j;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.j(this, obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }

    final w1 b(Spliterator spliterator, long j, long j2) {
        return new u1(this, spliterator, j, j2);
    }

    public final /* synthetic */ void k(Long l) {
        y0.i(this, l);
    }
}
