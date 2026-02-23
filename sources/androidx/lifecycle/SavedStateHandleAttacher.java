package androidx.lifecycle;

import androidx.lifecycle.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SavedStateHandleAttacher implements n {
    public final D a;

    public SavedStateHandleAttacher(D d) {
        kotlin.jvm.internal.l.e(d, "provider");
        this.a = d;
    }

    public void b(p pVar, j.b bVar) {
        kotlin.jvm.internal.l.e(pVar, "source");
        kotlin.jvm.internal.l.e(bVar, "event");
        if (bVar == j.b.ON_CREATE) {
            pVar.getLifecycle().c(this);
            this.a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + bVar).toString());
        }
    }
}
