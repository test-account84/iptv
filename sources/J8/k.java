package J8;

import G8.x0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.internal.x;
import o8.g;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class k {

    public static final class a extends m implements p {
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar) {
            super(2);
            this.a = iVar;
        }

        public final Integer a(int i, g.b bVar) {
            g.c key = bVar.getKey();
            g.b a = this.a.c.a(key);
            if (key != x0.b0) {
                return Integer.valueOf(bVar != a ? Integer.MIN_VALUE : i + 1);
            }
            x0 x0Var = (x0) a;
            x0 b = k.b((x0) bVar, x0Var);
            if (b == x0Var) {
                if (x0Var != null) {
                    i++;
                }
                return Integer.valueOf(i);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b + ", expected child of " + x0Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public static final void a(i iVar, o8.g gVar) {
        if (((Number) gVar.l(0, new a(iVar))).intValue() == iVar.d) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + iVar.c + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final x0 b(x0 x0Var, x0 x0Var2) {
        while (x0Var != null) {
            if (x0Var == x0Var2) {
                return x0Var;
            }
            if (!(x0Var instanceof x)) {
                return x0Var;
            }
            x0Var = ((x) x0Var).O0();
        }
        return null;
    }
}
