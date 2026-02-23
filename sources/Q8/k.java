package q8;

import kotlin.jvm.internal.C;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class k extends j implements kotlin.jvm.internal.h {
    public final int a;

    public k(int i, o8.d dVar) {
        super(dVar);
        this.a = i;
    }

    public int getArity() {
        return this.a;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String h = C.h(this);
        kotlin.jvm.internal.l.d(h, "renderLambdaToString(this)");
        return h;
    }
}
