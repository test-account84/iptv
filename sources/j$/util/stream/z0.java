package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class Z0 extends T2 implements E0, z0 {
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ E0 i(long j, long j2, IntFunction intFunction) {
        return y0.t(this, j, j2);
    }

    public final E0 a() {
        return this;
    }

    public final K0 a() {
        return this;
    }

    public final /* synthetic */ void accept(int i) {
        y0.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j) {
        y0.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        y0.f(this, obj);
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
        super.d((double[]) obj, i);
    }

    public final Object e() {
        return (double[]) super.e();
    }

    public final void f(Object obj) {
        super.f((DoubleConsumer) obj);
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

    public final /* synthetic */ void q(Double d) {
        y0.e(this, d);
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
    public final /* synthetic */ void j(Double[] dArr, int i) {
        y0.n(this, dArr, i);
    }
}
