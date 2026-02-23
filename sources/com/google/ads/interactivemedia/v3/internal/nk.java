package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class nk implements nu {
    private final Object a = new Object();
    private aa b;
    private nt c;

    public final nt a(ai aiVar) {
        nt ntVar;
        af.s(aiVar.b);
        aa aaVar = aiVar.b.c;
        if (aaVar == null || cq.a < 18) {
            return nt.b;
        }
        synchronized (this.a) {
            try {
                if (!cq.V(aaVar, this.b)) {
                    this.b = aaVar;
                    dg dgVar = new dg();
                    dgVar.b(null);
                    oh ohVar = new oh(null, dgVar);
                    axq e = aaVar.b.g().e();
                    while (e.hasNext()) {
                        Map.Entry entry = (Map.Entry) e.next();
                        ohVar.a((String) entry.getKey(), (String) entry.getValue());
                    }
                    mz mzVar = new mz();
                    mzVar.c(aaVar.a, og.a);
                    mzVar.b(axy.c(aaVar.c));
                    nj a = mzVar.a(ohVar);
                    a.u(aaVar.a());
                    this.c = a;
                }
                ntVar = this.c;
                af.s(ntVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ntVar;
    }
}
