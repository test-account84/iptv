package j$.util.stream;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class n extends m2 {
    public final /* synthetic */ int b;
    Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(b bVar, q2 q2Var, int i) {
        super(q2Var);
        this.b = i;
        this.c = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(q2 q2Var) {
        super(q2Var);
        this.b = 0;
    }

    public final void accept(Object obj) {
        switch (this.b) {
            case 0:
                if (!((HashSet) this.c).contains(obj)) {
                    ((HashSet) this.c).add(obj);
                    this.a.accept(obj);
                    break;
                }
                break;
            case 1:
                ((Consumer) ((u) this.c).n).accept(obj);
                this.a.accept(obj);
                break;
            case 2:
                if (((Predicate) ((u) this.c).n).test(obj)) {
                    this.a.accept(obj);
                    break;
                }
                break;
            case 3:
                this.a.accept(((f2) this.c).n.apply(obj));
                break;
            case 4:
                this.a.accept(((ToIntFunction) ((X) this.c).n).applyAsInt(obj));
                break;
            case 5:
                this.a.accept(((ToLongFunction) ((h0) this.c).n).applyAsLong(obj));
                break;
            default:
                this.a.accept(((ToDoubleFunction) ((z) this.c).n).applyAsDouble(obj));
                break;
        }
    }

    public void l() {
        switch (this.b) {
            case 0:
                this.c = null;
                this.a.l();
                break;
            default:
                super.l();
                break;
        }
    }

    public void m(long j) {
        switch (this.b) {
            case 0:
                this.c = new HashSet();
                this.a.m(-1L);
                break;
            case 1:
            default:
                super.m(j);
                break;
            case 2:
                this.a.m(-1L);
                break;
        }
    }
}
