package z1;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e {
    public final Executor a;
    public AtomicReference b = new AtomicReference();
    public final AtomicBoolean c = new AtomicBoolean();

    public static class a extends e {
        public final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Executor executor, Object obj) {
            super(executor);
            this.d = obj;
        }

        public Object d() {
            return this.d;
        }
    }

    public e(Executor executor) {
        this.a = executor;
    }

    public static e b(Object obj) {
        return new a(null, obj);
    }

    public final void a() {
        if (!this.c.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
    }

    public final Object c() {
        a();
        try {
            return d();
        } catch (Exception e) {
            throw new B1.b("Failed to perform store operation", e);
        }
    }

    public abstract Object d();
}
