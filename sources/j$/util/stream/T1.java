package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class t1 extends w1 implements o2 {
    private final int[] h;

    t1(Spliterator spliterator, b bVar, int[] iArr) {
        super(spliterator, bVar, iArr.length);
        this.h = iArr;
    }

    t1(t1 t1Var, Spliterator spliterator, long j, long j2) {
        super(t1Var, spliterator, j, j2, t1Var.h.length);
        this.h = t1Var.h;
    }

    public final void accept(int i) {
        int i2 = this.f;
        if (i2 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f));
        }
        int[] iArr = this.h;
        this.f = i2 + 1;
        iArr[i2] = i;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.h(this, obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }

    final w1 b(Spliterator spliterator, long j, long j2) {
        return new t1(this, spliterator, j, j2);
    }

    public final /* synthetic */ void n(Integer num) {
        y0.g(this, num);
    }
}
