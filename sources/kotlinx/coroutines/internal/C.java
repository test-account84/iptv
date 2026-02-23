package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class c extends u {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");

    @NotNull
    private volatile /* synthetic */ Object _consensus = b.a;

    public c a() {
        return this;
    }

    public final Object c(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == b.a) {
            obj2 = e(g(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(Object obj, Object obj2);

    public final Object e(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = b.a;
        return obj2 != obj3 ? obj2 : t.b.a(a, this, obj3, obj) ? obj : this._consensus;
    }

    public long f() {
        return 0L;
    }

    public abstract Object g(Object obj);
}
