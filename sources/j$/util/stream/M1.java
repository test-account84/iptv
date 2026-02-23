package j$.util.stream;

import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class m1 extends o1 implements j$.util.N {
    public final void forEachRemaining(Object obj) {
        if (this.a == null) {
            return;
        }
        if (this.d != null) {
            while (tryAdvance(obj)) {
            }
            return;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            ((j$.util.N) spliterator).forEachRemaining(obj);
            return;
        }
        ArrayDeque b = b();
        while (true) {
            J0 j0 = (J0) o1.a(b);
            if (j0 == null) {
                this.a = null;
                return;
            }
            j0.f(obj);
        }
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public final boolean tryAdvance(Object obj) {
        J0 j0;
        if (!c()) {
            return false;
        }
        boolean tryAdvance = ((j$.util.N) this.d).tryAdvance(obj);
        if (!tryAdvance) {
            if (this.c == null && (j0 = (J0) o1.a(this.e)) != null) {
                j$.util.N spliterator = j0.spliterator();
                this.d = spliterator;
                return spliterator.tryAdvance(obj);
            }
            this.a = null;
        }
        return tryAdvance;
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }
}
