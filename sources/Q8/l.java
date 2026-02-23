package q8;

import kotlin.jvm.internal.C;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class l extends d implements kotlin.jvm.internal.h {
    private final int arity;

    public l(int i, o8.d dVar) {
        super(dVar);
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String h = C.h(this);
        kotlin.jvm.internal.l.d(h, "renderLambdaToString(this)");
        return h;
    }
}
