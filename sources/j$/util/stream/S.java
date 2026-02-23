package j$.util.stream;

import j$.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class s implements Supplier, Predicate, IntFunction, ToIntFunction, IntBinaryOperator, ObjIntConsumer, BiConsumer, ObjLongConsumer, LongBinaryOperator, ToLongFunction, LongFunction, Consumer {
    public final /* synthetic */ int a;

    public /* synthetic */ s(int i) {
        this.a = i;
    }

    public void accept(Object obj) {
    }

    public void accept(Object obj, int i) {
        switch (this.a) {
            case 10:
                ((j$.util.h) obj).accept(i);
                break;
            default:
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + i;
                break;
        }
    }

    public void accept(Object obj, long j) {
        switch (this.a) {
            case 17:
                ((j$.util.j) obj).accept(j);
                break;
            default:
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + j;
                break;
        }
    }

    public void accept(Object obj, Object obj2) {
        switch (this.a) {
            case 11:
                ((j$.util.h) obj).b((j$.util.h) obj2);
                break;
            case 16:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                break;
            case 20:
                ((j$.util.j) obj).b((j$.util.j) obj2);
                break;
            default:
                long[] jArr3 = (long[]) obj;
                long[] jArr4 = (long[]) obj2;
                jArr3[0] = jArr3[0] + jArr4[0];
                jArr3[1] = jArr3[1] + jArr4[1];
                break;
        }
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.a(this, predicate);
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
            case 11:
                break;
            case 16:
                break;
            case 20:
                break;
        }
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public Object apply(int i) {
        switch (this.a) {
            case 5:
                return new Object[i];
            case 6:
                return new Integer[i];
            case 8:
                return Integer.valueOf(i);
            case 21:
                return new Long[i];
            default:
                return new Object[i];
        }
    }

    public Object apply(long j) {
        return Long.valueOf(j);
    }

    public int applyAsInt(int i, int i2) {
        switch (this.a) {
            case 9:
                return Math.min(i, i2);
            case 12:
                return i + i2;
            default:
                return Math.max(i, i2);
        }
    }

    public int applyAsInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    public long applyAsLong(long j, long j2) {
        switch (this.a) {
            case 18:
                return Math.min(j, j2);
            case 26:
                return Math.max(j, j2);
            default:
                return j + j2;
        }
    }

    public long applyAsLong(Object obj) {
        return ((Long) obj).longValue();
    }

    public Object get() {
        switch (this.a) {
            case 0:
                return new double[3];
            case 14:
                return new long[2];
            default:
                return new long[2];
        }
    }

    public Predicate negate() {
        switch (this.a) {
        }
        return new j$.util.function.a(this, 2);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.h(this, predicate);
    }

    public boolean test(Object obj) {
        switch (this.a) {
            case 1:
                return ((j$.util.k) obj).c();
            case 2:
                return ((j$.util.l) obj).c();
            case 3:
                return ((j$.util.m) obj).c();
            default:
                return ((Optional) obj).c();
        }
    }
}
