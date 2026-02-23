package j$.util.stream;

import j$.util.Spliterators;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
class X2 extends Z2 implements LongConsumer {
    public void accept(long j) {
        x();
        long[] jArr = (long[]) this.e;
        int i = this.b;
        this.b = i + 1;
        jArr[i] = j;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }

    public final Object c(int i) {
        return new long[i];
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            f((LongConsumer) consumer);
        } else {
            if (N3.a) {
                N3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }
            j$.util.A.c((W2) spliterator(), consumer);
        }
    }

    public final Iterator iterator() {
        return Spliterators.h(spliterator());
    }

    protected final void s(Object obj, int i, int i2, Object obj2) {
        long[] jArr = (long[]) obj;
        LongConsumer longConsumer = (LongConsumer) obj2;
        while (i < i2) {
            longConsumer.accept(jArr[i]);
            i++;
        }
    }

    protected final int t(Object obj) {
        return ((long[]) obj).length;
    }

    public final String toString() {
        long[] jArr = (long[]) e();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(jArr)});
        }
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(jArr, 200))});
    }

    protected final Object[] w() {
        return new long[8][];
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public j$.util.K spliterator() {
        return new W2(this, 0, this.c, 0, this.b);
    }
}
