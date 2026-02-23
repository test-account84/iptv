package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class r1 extends X2 implements I0, B0 {
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ I0 i(long j, long j2, IntFunction intFunction) {
        return y0.v(this, j, j2);
    }

    public final I0 a() {
        return this;
    }

    public final K0 a() {
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

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.j(this, obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final J0 b(int i) {
        throw new IndexOutOfBoundsException();
    }

    public final /* bridge */ /* synthetic */ K0 b(int i) {
        b(i);
        throw null;
    }

    public final void d(Object obj, int i) {
        super.d((long[]) obj, i);
    }

    public final Object e() {
        return (long[]) super.e();
    }

    public final void f(Object obj) {
        super.f((LongConsumer) obj);
    }

    public final /* synthetic */ void k(Long l) {
        y0.i(this, l);
    }

    public final void l() {
    }

    public final void m(long j) {
        clear();
        v(j);
    }

    public final /* synthetic */ boolean o() {
        return false;
    }

    public final /* synthetic */ Object[] p(IntFunction intFunction) {
        return y0.m(this, intFunction);
    }

    public final /* synthetic */ int r() {
        return 0;
    }

    public final j$.util.N spliterator() {
        return super.spliterator();
    }

    public final Spliterator spliterator() {
        return super.spliterator();
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void j(Long[] lArr, int i) {
        y0.p(this, lArr, i);
    }
}
