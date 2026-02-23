package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.SystemClock;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ps implements qm {
    final /* synthetic */ pv a;

    public /* synthetic */ ps(pv pvVar) {
        this.a = pvVar;
    }

    public final void j() {
        pv.o(this.a).remove(this);
    }

    public final boolean s(Uri uri, bdz bdzVar, boolean z) {
        pu puVar;
        if (pv.g(this.a) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            qg j = pv.j(this.a);
            int i = cq.a;
            List list = j.c;
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                pu puVar2 = (pu) pv.n(this.a).get(((qf) list.get(i3)).a);
                if (puVar2 != null && elapsedRealtime < pu.d(puVar2)) {
                    i2++;
                }
            }
            wv d = ws.d(new wu(1, 0, pv.j(this.a).c.size(), i2), bdzVar);
            if (d != null && d.a == 2 && (puVar = (pu) pv.n(this.a).get(uri)) != null) {
                pu.n(puVar, d.b);
            }
        }
        return false;
    }
}
