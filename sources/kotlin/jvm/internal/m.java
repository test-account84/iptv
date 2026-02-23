package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class m implements h, Serializable {
    private final int arity;

    public m(int i) {
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        String i = C.i(this);
        l.d(i, "renderLambdaToString(this)");
        return i;
    }
}
