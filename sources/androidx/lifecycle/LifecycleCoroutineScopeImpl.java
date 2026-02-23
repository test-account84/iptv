package androidx.lifecycle;

import G8.B0;
import androidx.lifecycle.j;
import java.util.concurrent.CancellationException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LifecycleCoroutineScopeImpl extends k implements n {
    public final j a;
    public final o8.g c;

    public void b(p pVar, j.b bVar) {
        kotlin.jvm.internal.l.e(pVar, "source");
        kotlin.jvm.internal.l.e(bVar, "event");
        if (c().b().compareTo(j.c.DESTROYED) <= 0) {
            c().c(this);
            B0.d(t(), (CancellationException) null, 1, (Object) null);
        }
    }

    public j c() {
        return this.a;
    }

    public o8.g t() {
        return this.c;
    }
}
