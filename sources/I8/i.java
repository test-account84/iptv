package I8;

import G8.P;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class i extends r implements p {
    public final Throwable e;

    public i(Throwable th) {
        this.e = th;
    }

    public y B(m.b bVar) {
        return G8.p.a;
    }

    public final Throwable F() {
        Throwable th = this.e;
        return th == null ? new j("Channel was closed") : th;
    }

    public final Throwable G() {
        Throwable th = this.e;
        return th == null ? new k("Channel was closed") : th;
    }

    public y f(Object obj, m.b bVar) {
        return G8.p.a;
    }

    public String toString() {
        return "Closed@" + P.b(this) + '[' + this.e + ']';
    }

    public void d(Object obj) {
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public i a() {
        return this;
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public i A() {
        return this;
    }

    public void z() {
    }
}
