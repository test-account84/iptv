package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Function$-CC;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class a implements Supplier, Consumer, BooleanSupplier, DoubleFunction, Function, LongFunction {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    public /* synthetic */ a(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public void accept(Object obj) {
        switch (this.a) {
            case 1:
                ((q2) this.b).accept(obj);
                break;
            default:
                ((List) this.b).add(obj);
                break;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$-CC.$default$andThen(this, function);
    }

    public Object apply(double d) {
        Object apply = ((DoubleFunction) this.b).apply(d);
        if (apply == null) {
            return null;
        }
        if (apply instanceof F) {
            return E.k((F) apply);
        }
        if (apply instanceof DoubleStream) {
            return D.k((DoubleStream) apply);
        }
        j$.util.e.a("java.util.stream.DoubleStream", apply.getClass());
        throw null;
    }

    public Object apply(long j) {
        Object apply = ((LongFunction) this.b).apply(j);
        if (apply == null) {
            return null;
        }
        if (apply instanceof n0) {
            return m0.k((n0) apply);
        }
        if (apply instanceof LongStream) {
            return l0.k((LongStream) apply);
        }
        j$.util.e.a("java.util.stream.LongStream", apply.getClass());
        throw null;
    }

    public Object apply(Object obj) {
        Object apply = ((Function) this.b).apply(obj);
        if (apply == null) {
            return null;
        }
        if (apply instanceof Stream) {
            return Stream.Wrapper.convert((Stream) apply);
        }
        if (apply instanceof java.util.stream.Stream) {
            return b3.k((java.util.stream.Stream) apply);
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        if (apply instanceof F) {
            return E.k((F) apply);
        }
        if (apply instanceof DoubleStream) {
            return D.k((DoubleStream) apply);
        }
        if (apply instanceof n0) {
            return m0.k((n0) apply);
        }
        if (apply instanceof LongStream) {
            return l0.k((LongStream) apply);
        }
        j$.util.e.a("java.util.stream.*Stream", apply.getClass());
        throw null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$-CC.$default$compose(this, function);
    }

    public Object get() {
        switch (this.a) {
            case 0:
                return ((b) this.b).M();
            default:
                return (Spliterator) this.b;
        }
    }

    public boolean getAsBoolean() {
        switch (this.a) {
            case 2:
                p3 p3Var = (p3) this.b;
                return p3Var.d.tryAdvance(p3Var.e);
            case 3:
                r3 r3Var = (r3) this.b;
                return r3Var.d.tryAdvance(r3Var.e);
            case 4:
                t3 t3Var = (t3) this.b;
                return t3Var.d.tryAdvance(t3Var.e);
            default:
                I3 i3 = (I3) this.b;
                return i3.d.tryAdvance(i3.e);
        }
    }
}
