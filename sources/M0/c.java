package m0;

import androidx.lifecycle.J;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public final List a = new ArrayList();

    public final void a(C8.c cVar, l lVar) {
        kotlin.jvm.internal.l.e(cVar, "clazz");
        kotlin.jvm.internal.l.e(lVar, "initializer");
        this.a.add(new f(v8.a.a(cVar), lVar));
    }

    public final J.b b() {
        Object[] array = this.a.toArray(new f[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        f[] fVarArr = (f[]) array;
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
