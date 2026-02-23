package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class b1 extends e1 implements G0 {
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void j(Integer[] numArr, int i) {
        y0.o(this, numArr, i);
    }

    public final J0 b(int i) {
        throw new IndexOutOfBoundsException();
    }

    public final /* bridge */ /* synthetic */ K0 b(int i) {
        b(i);
        throw null;
    }

    public final Object e() {
        return y0.y();
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        y0.r(this, consumer);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ G0 i(long j, long j2, IntFunction intFunction) {
        return y0.u(this, j, j2);
    }

    public final j$.util.N spliterator() {
        return Spliterators.c();
    }

    public final Spliterator spliterator() {
        return Spliterators.c();
    }
}
