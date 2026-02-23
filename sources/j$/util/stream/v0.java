package j$.util.stream;

import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class V0 extends M0 implements J0 {
    public final void d(Object obj, int i) {
        K0 k0 = this.a;
        ((J0) k0).d(obj, i);
        ((J0) this.b).d(obj, i + ((int) ((J0) k0).count()));
    }

    public final Object e() {
        long count = count();
        if (count >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object c = c((int) count);
        d(c, 0);
        return c;
    }

    public final void f(Object obj) {
        ((J0) this.a).f(obj);
        ((J0) this.b).f(obj);
    }

    public final /* synthetic */ Object[] p(IntFunction intFunction) {
        return y0.m(this, intFunction);
    }

    public final String toString() {
        long count = count();
        String name = getClass().getName();
        return count < 32 ? String.format("%s[%s.%s]", new Object[]{name, this.a, this.b}) : String.format("%s[size=%d]", new Object[]{name, Long.valueOf(count())});
    }
}
