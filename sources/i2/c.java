package I2;

import C2.p;
import C2.u;
import D2.m;
import J2.x;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c implements e {
    public static final Logger f = Logger.getLogger(u.class.getName());
    public final x a;
    public final Executor b;
    public final D2.e c;
    public final K2.d d;
    public final L2.b e;

    public c(Executor executor, D2.e eVar, x xVar, K2.d dVar, L2.b bVar) {
        this.b = executor;
        this.c = eVar;
        this.a = xVar;
        this.d = dVar;
        this.e = bVar;
    }

    public static /* synthetic */ Object b(c cVar, p pVar, C2.i iVar) {
        return cVar.d(pVar, iVar);
    }

    public static /* synthetic */ void c(c cVar, p pVar, z2.h hVar, C2.i iVar) {
        cVar.e(pVar, hVar, iVar);
    }

    public void a(p pVar, C2.i iVar, z2.h hVar) {
        this.b.execute(new a(this, pVar, hVar, iVar));
    }

    public final /* synthetic */ Object d(p pVar, C2.i iVar) {
        this.d.R(pVar, iVar);
        this.a.b(pVar, 1);
        return null;
    }

    public final /* synthetic */ void e(p pVar, z2.h hVar, C2.i iVar) {
        try {
            m mVar = this.c.get(pVar.b());
            if (mVar != null) {
                this.e.a(new b(this, pVar, mVar.a(iVar)));
                hVar.a(null);
            } else {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{pVar.b()});
                f.warning(format);
                hVar.a(new IllegalArgumentException(format));
            }
        } catch (Exception e) {
            f.warning("Error scheduling event " + e.getMessage());
            hVar.a(e);
        }
    }
}
