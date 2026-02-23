package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class a1 extends e1 implements E0 {
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void j(Double[] dArr, int i) {
        y0.n(this, dArr, i);
    }

    public final J0 b(int i) {
        throw new IndexOutOfBoundsException();
    }

    public final /* bridge */ /* synthetic */ K0 b(int i) {
        b(i);
        throw null;
    }

    public final Object e() {
        return y0.x();
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        y0.q(this, consumer);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ E0 i(long j, long j2, IntFunction intFunction) {
        return y0.t(this, j, j2);
    }

    public final j$.util.N spliterator() {
        return Spliterators.b();
    }

    public final Spliterator spliterator() {
        return Spliterators.b();
    }
}
