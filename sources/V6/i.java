package V6;

import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i {
    public final boolean a;

    public i(boolean z) {
        this.a = z;
    }

    public void a(q[] qVarArr) {
        if (!this.a || qVarArr == null || qVarArr.length < 3) {
            return;
        }
        q qVar = qVarArr[0];
        qVarArr[0] = qVarArr[2];
        qVarArr[2] = qVar;
    }
}
