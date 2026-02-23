package com.google.android.exoplayer2.source.rtsp;

import b4.r;
import com.google.android.exoplayer2.source.rtsp.a;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m implements a.a {
    public final long a;

    public m(long j) {
        this.a = j;
    }

    public a a(int i) {
        l lVar = new l(this.a);
        l lVar2 = new l(this.a);
        try {
            lVar.a(K3.i.a(0));
            int localPort = lVar.getLocalPort();
            boolean z = localPort % 2 == 0;
            lVar2.a(K3.i.a(z ? localPort + 1 : localPort - 1));
            if (z) {
                lVar.j(lVar2);
                return lVar;
            }
            lVar2.j(lVar);
            return lVar2;
        } catch (IOException e) {
            r.a(lVar);
            r.a(lVar2);
            throw e;
        }
    }

    public a.a b() {
        return new k(this.a);
    }
}
