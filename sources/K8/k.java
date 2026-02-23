package k8;

import k8.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class k {
    public static final Object a(Throwable exception) {
        kotlin.jvm.internal.l.e(exception, "exception");
        return new j.b(exception);
    }

    public static final void b(Object obj) {
        if (obj instanceof j.b) {
            throw ((j.b) obj).a;
        }
    }
}
