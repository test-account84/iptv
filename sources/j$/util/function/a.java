package j$.util.function;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class a implements BinaryOperator, Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return j$.com.android.tools.r8.a.a(this, predicate);
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.c(this, function);
    }

    public Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                if (((Comparator) this.b).compare(obj, obj2) < 0) {
                    break;
                }
                break;
            default:
                if (((Comparator) this.b).compare(obj, obj2) > 0) {
                    break;
                }
                break;
        }
        return obj2;
    }

    public Predicate negate() {
        return new a(this, 2);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return j$.com.android.tools.r8.a.h(this, predicate);
    }

    public boolean test(Object obj) {
        return !((Predicate) this.b).test(obj);
    }
}
