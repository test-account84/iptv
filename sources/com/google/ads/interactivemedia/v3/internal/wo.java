package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class wo {
    private final Object a;

    public wo() {
        this.a = new CopyOnWriteArrayList();
    }

    public final void a(Handler handler, wp wpVar) {
        af.s(wpVar);
        c(wpVar);
        ((CopyOnWriteArrayList) this.a).add(new wn(handler, wpVar));
    }

    public final void b(int i, long j, long j2) {
        Iterator it = ((CopyOnWriteArrayList) this.a).iterator();
        while (it.hasNext()) {
            wn wnVar = (wn) it.next();
            if (!wn.d(wnVar)) {
                wn.a(wnVar).post(new wm(wnVar, i, j, j2));
            }
        }
    }

    public final void c(wp wpVar) {
        Iterator it = ((CopyOnWriteArrayList) this.a).iterator();
        while (it.hasNext()) {
            wn wnVar = (wn) it.next();
            if (wn.b(wnVar) == wpVar) {
                wnVar.c();
                ((CopyOnWriteArrayList) this.a).remove(wnVar);
            }
        }
    }

    public final ao d(zi ziVar, aax aaxVar) throws IOException {
        ao aoVar = null;
        int i = 0;
        while (true) {
            try {
                ziVar.f(((cj) this.a).H(), 0, 10);
                ((cj) this.a).F(0);
                if (((cj) this.a).k() != 4801587) {
                    break;
                }
                ((cj) this.a).G(3);
                int h = ((cj) this.a).h();
                int i2 = h + 10;
                if (aoVar == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(((cj) this.a).H(), 0, bArr, 0, 10);
                    ziVar.f(bArr, 10, h);
                    aoVar = new aaz(aaxVar).c(bArr, i2);
                } else {
                    ziVar.e(h);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        ziVar.h();
        ziVar.e(i);
        return aoVar;
    }

    public wo(byte[] bArr) {
        this.a = new cj(10);
    }
}
