package H8;

import B8.h;
import G8.B0;
import G8.K0;
import G8.V;
import G8.b0;
import G8.d0;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.l;
import o8.g;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class d extends e implements V {

    @Nullable
    private volatile d _immediate;
    public final Handler d;
    public final String e;
    public final boolean f;
    public final d g;

    public d(Handler handler, String str) {
        this(handler, str, false);
    }

    public static /* synthetic */ void h0(d dVar, Runnable runnable) {
        k0(dVar, runnable);
    }

    public static final void k0(d dVar, Runnable runnable) {
        dVar.d.removeCallbacks(runnable);
    }

    public void c0(g gVar, Runnable runnable) {
        if (this.d.post(runnable)) {
            return;
        }
        i0(gVar, runnable);
    }

    public boolean d0(g gVar) {
        return (this.f && l.a(Looper.myLooper(), this.d.getLooper())) ? false : true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).d == this.d;
    }

    public int hashCode() {
        return System.identityHashCode(this.d);
    }

    public final void i0(g gVar, Runnable runnable) {
        B0.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        b0.b().c0(gVar, runnable);
    }

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public d f0() {
        return this.g;
    }

    public d0 t(long j, Runnable runnable, g gVar) {
        if (this.d.postDelayed(runnable, h.f(j, 4611686018427387903L))) {
            return new c(this, runnable);
        }
        i0(gVar, runnable);
        return K0.a;
    }

    public String toString() {
        String g0 = g0();
        if (g0 != null) {
            return g0;
        }
        String str = this.e;
        if (str == null) {
            str = this.d.toString();
        }
        if (!this.f) {
            return str;
        }
        return str + ".immediate";
    }

    public /* synthetic */ d(Handler handler, String str, int i, kotlin.jvm.internal.g gVar) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public d(Handler handler, String str, boolean z) {
        super(null);
        this.d = handler;
        this.e = str;
        this.f = z;
        this._immediate = z ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, str, true);
            this._immediate = dVar;
        }
        this.g = dVar;
    }
}
