package q8;

import o8.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class d extends a {

    @Nullable
    private final o8.g _context;

    @Nullable
    private transient o8.d intercepted;

    public d(o8.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    @NotNull
    public o8.g getContext() {
        o8.g gVar = this._context;
        kotlin.jvm.internal.l.b(gVar);
        return gVar;
    }

    @NotNull
    public final o8.d intercepted() {
        o8.d dVar = this.intercepted;
        if (dVar == null) {
            o8.e eVar = (o8.e) getContext().a(o8.e.d0);
            if (eVar == null || (dVar = eVar.o(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    public void releaseIntercepted() {
        o8.d dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b a = getContext().a(o8.e.d0);
            kotlin.jvm.internal.l.b(a);
            ((o8.e) a).T(dVar);
        }
        this.intercepted = c.a;
    }

    public d(o8.d dVar, o8.g gVar) {
        super(dVar);
        this._context = gVar;
    }
}
