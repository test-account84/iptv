package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class c1 extends e1 implements I0 {
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void j(Long[] lArr, int i) {
        y0.p(this, lArr, i);
    }

    public final J0 b(int i) {
        throw new IndexOutOfBoundsException();
    }

    public final /* bridge */ /* synthetic */ K0 b(int i) {
        b(i);
        throw null;
    }

    public final Object e() {
        return y0.z();
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        y0.s(this, consumer);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ I0 i(long j, long j2, IntFunction intFunction) {
        return y0.v(this, j, j2);
    }

    public final j$.util.N spliterator() {
        return Spliterators.d();
    }

    public final Spliterator spliterator() {
        return Spliterators.d();
    }
}
