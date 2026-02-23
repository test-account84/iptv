package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class I3 extends g3 {
    final void d() {
        a3 a3Var = new a3();
        this.h = a3Var;
        Objects.requireNonNull(a3Var);
        this.e = this.b.W(new H3(a3Var, 0));
        this.f = new a(this, 5);
    }

    final g3 e(Spliterator spliterator) {
        return new I3(this.b, spliterator, this.a);
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(consumer)) {
            }
            return;
        }
        Objects.requireNonNull(consumer);
        c();
        Objects.requireNonNull(consumer);
        H3 h3 = new H3(consumer, 1);
        this.b.V(this.d, h3);
        this.i = true;
    }

    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean a = a();
        if (a) {
            a3 a3Var = (a3) this.h;
            long j = this.g;
            if (a3Var.c != 0) {
                if (j >= a3Var.count()) {
                    throw new IndexOutOfBoundsException(Long.toString(j));
                }
                for (int i = 0; i <= a3Var.c; i++) {
                    long j2 = a3Var.d[i];
                    Object[] objArr = a3Var.f[i];
                    if (j < objArr.length + j2) {
                        obj = objArr[(int) (j - j2)];
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            if (j >= a3Var.b) {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            obj = a3Var.e[(int) j];
            consumer.accept(obj);
        }
        return a;
    }
}
