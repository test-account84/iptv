package j$.util.stream;

import j$.util.Spliterators;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
class V2 extends Z2 implements IntConsumer {
    public void accept(int i) {
        x();
        int[] iArr = (int[]) this.e;
        int i2 = this.b;
        this.b = i2 + 1;
        iArr[i2] = i;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }

    public final Object c(int i) {
        return new int[i];
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            f((IntConsumer) consumer);
        } else {
            if (N3.a) {
                N3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                throw null;
            }
            j$.util.A.b((U2) spliterator(), consumer);
        }
    }

    public final Iterator iterator() {
        return Spliterators.g(spliterator());
    }

    protected final void s(Object obj, int i, int i2, Object obj2) {
        int[] iArr = (int[]) obj;
        IntConsumer intConsumer = (IntConsumer) obj2;
        while (i < i2) {
            intConsumer.accept(iArr[i]);
            i++;
        }
    }

    protected final int t(Object obj) {
        return ((int[]) obj).length;
    }

    public final String toString() {
        int[] iArr = (int[]) e();
        if (iArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(iArr)});
        }
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(iArr, 200))});
    }

    protected final Object[] w() {
        return new int[8][];
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public j$.util.H spliterator() {
        return new U2(this, 0, this.c, 0, this.b);
    }
}
