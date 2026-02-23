package G8;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class r extends B {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(r.class, "_resumed");

    @NotNull
    private volatile /* synthetic */ int _resumed;

    public r(o8.d dVar, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + dVar + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }

    public final boolean c() {
        return c.compareAndSet(this, 0, 1);
    }
}
