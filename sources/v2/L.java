package V2;

import O2.H0;
import V2.h;
import android.net.Uri;
import b4.o;
import b4.x;
import d4.k0;
import java.util.Map;
import s5.c0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l implements B {
    public final Object a = new Object();
    public H0.f b;
    public y c;
    public o.a d;
    public String e;

    public y a(H0 h0) {
        y yVar;
        d4.a.e(h0.c);
        H0.f fVar = h0.c.d;
        if (fVar == null || k0.a < 18) {
            return y.a;
        }
        synchronized (this.a) {
            try {
                if (!k0.c(fVar, this.b)) {
                    this.b = fVar;
                    this.c = b(fVar);
                }
                yVar = (y) d4.a.e(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }

    public final y b(H0.f fVar) {
        o.a aVar = this.d;
        if (aVar == null) {
            aVar = new x.b().c(this.e);
        }
        Uri uri = fVar.d;
        M m = new M(uri == null ? null : uri.toString(), fVar.i, aVar);
        c0 l = fVar.f.h().l();
        while (l.hasNext()) {
            Map.Entry entry = (Map.Entry) l.next();
            m.e((String) entry.getKey(), (String) entry.getValue());
        }
        h a = new h.b().f(fVar.a, L.d).c(fVar.g).d(fVar.h).e(w5.f.l(fVar.k)).a(m);
        a.E(0, fVar.e());
        return a;
    }

    public void c(o.a aVar) {
        this.d = aVar;
    }
}
