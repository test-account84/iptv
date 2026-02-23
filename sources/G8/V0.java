package G8;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class v0 extends z0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(v0.class, "_invoked");

    @NotNull
    private volatile /* synthetic */ int _invoked = 0;
    public final w8.l f;

    public v0(w8.l lVar) {
        this.f = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        z((Throwable) obj);
        return k8.q.a;
    }

    public void z(Throwable th) {
        if (g.compareAndSet(this, 0, 1)) {
            this.f.invoke(th);
        }
    }
}
