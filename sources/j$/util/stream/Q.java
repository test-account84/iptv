package j$.util.stream;

import java.util.LinkedHashSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class q implements BiConsumer, ObjDoubleConsumer, Supplier, LongFunction, BinaryOperator, IntFunction, DoubleBinaryOperator, DoubleFunction, ToDoubleFunction {
    public final /* synthetic */ int a;

    public /* synthetic */ q(int i) {
        this.a = i;
    }

    public void accept(Object obj, double d) {
        switch (this.a) {
            case 1:
                double[] dArr = (double[]) obj;
                dArr[2] = dArr[2] + 1.0d;
                l.a(dArr, d);
                dArr[3] = dArr[3] + d;
                break;
            case 2:
            default:
                ((j$.util.g) obj).accept(d);
                break;
            case 3:
                double[] dArr2 = (double[]) obj;
                l.a(dArr2, d);
                dArr2[2] = dArr2[2] + d;
                break;
        }
    }

    public void accept(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                l.a(dArr, dArr2[0]);
                l.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                break;
            case 2:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                l.a(dArr3, dArr4[0]);
                l.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                break;
            case 20:
                ((LinkedHashSet) obj).add(obj2);
                break;
            case 21:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                break;
            default:
                ((j$.util.g) obj).b((j$.util.g) obj2);
                break;
        }
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
            case 0:
                break;
            case 2:
                break;
            case 20:
                break;
            case 21:
                break;
        }
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.c(this, function);
    }

    public Object apply(double d) {
        return Double.valueOf(d);
    }

    public Object apply(int i) {
        switch (this.a) {
            case 15:
                return new Object[i];
            default:
                return new Double[i];
        }
    }

    public Object apply(long j) {
        switch (this.a) {
            case 8:
                return y0.J(j);
            case 9:
            default:
                return y0.U(j);
            case 10:
                return y0.S(j);
        }
    }

    public Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case 9:
                return new S0((E0) obj, (E0) obj2);
            case 10:
            case 12:
            default:
                return new W0((K0) obj, (K0) obj2);
            case 11:
                return new T0((G0) obj, (G0) obj2);
            case 13:
                return new U0((I0) obj, (I0) obj2);
        }
    }

    public double applyAsDouble(double d, double d2) {
        switch (this.a) {
            case 22:
                return Math.min(d, d2);
            default:
                return Math.max(d, d2);
        }
    }

    public double applyAsDouble(Object obj) {
        return ((Double) obj).doubleValue();
    }

    public Object get() {
        switch (this.a) {
            case 4:
                return new H();
            case 5:
                return new I();
            case 6:
                return new J();
            case 7:
                return new K();
            case 16:
                return new j$.util.g();
            case 17:
                return new j$.util.h();
            case 18:
                return new j$.util.j();
            case 19:
                return new LinkedHashSet();
            default:
                return new double[4];
        }
    }
}
