package b0;

import b0.d;
import java.util.Arrays;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e {
    public static final d a() {
        return new a(null, true, 1, null);
    }

    public static final a b(d.b... bVarArr) {
        l.e(bVarArr, "pairs");
        a aVar = new a(null, false, 1, null);
        aVar.g((d.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        return aVar;
    }
}
