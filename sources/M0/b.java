package m0;

import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements J.b {
    public final f[] a;

    public b(f... fVarArr) {
        l.e(fVarArr, "initializers");
        this.a = fVarArr;
    }

    public I a(Class cls, a aVar) {
        l.e(cls, "modelClass");
        l.e(aVar, "extras");
        I i = null;
        for (f fVar : this.a) {
            if (l.a(fVar.a(), cls)) {
                Object invoke = fVar.b().invoke(aVar);
                i = invoke instanceof I ? (I) invoke : null;
            }
        }
        if (i != null) {
            return i;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }

    public /* synthetic */ I b(Class cls) {
        return K.a(this, cls);
    }
}
