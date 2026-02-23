package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.j;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ReflectiveGenericLifecycleObserver implements n {
    public final Object a;
    public final b.a c;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.c = b.c.c(obj.getClass());
    }

    public void b(p pVar, j.b bVar) {
        this.c.a(pVar, bVar, this.a);
    }
}
