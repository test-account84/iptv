package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class gw implements tk, no {
    final /* synthetic */ ha a;
    private final gy b;
    private tj c;
    private nn d;

    public gw(ha haVar, gy gyVar) {
        this.a = haVar;
        this.c = ha.d(haVar);
        this.d = ha.c(haVar);
        this.b = gyVar;
    }

    private final boolean m(int i, te teVar) {
        te teVar2 = null;
        if (teVar != null) {
            gy gyVar = this.b;
            int i2 = 0;
            while (true) {
                if (i2 >= gyVar.c.size()) {
                    break;
                }
                if (((te) gyVar.c.get(i2)).d == teVar.d) {
                    teVar2 = teVar.c(Pair.create(gyVar.b, teVar.a));
                    break;
                }
                i2++;
            }
            if (teVar2 == null) {
                return false;
            }
        }
        int i3 = i + this.b.d;
        tj tjVar = this.c;
        if (tjVar.a != i3 || !cq.V(tjVar.b, teVar2)) {
            this.c = ha.d(this.a).a(i3, teVar2, 0L);
        }
        nn nnVar = this.d;
        if (nnVar.a == i3 && cq.V(nnVar.b, teVar2)) {
            return true;
        }
        this.d = ha.c(this.a).a(i3, teVar2);
        return true;
    }

    public final void ae(int i, te teVar, tb tbVar) {
        if (m(i, teVar)) {
            this.c.c(tbVar);
        }
    }

    public final void af(int i, te teVar, sw swVar, tb tbVar) {
        if (m(i, teVar)) {
            this.c.e(swVar, tbVar);
        }
    }

    public final void ag(int i, te teVar, sw swVar, tb tbVar) {
        if (m(i, teVar)) {
            this.c.g(swVar, tbVar);
        }
    }

    public final void ah(int i, te teVar, sw swVar, tb tbVar, IOException iOException, boolean z) {
        if (m(i, teVar)) {
            this.c.i(swVar, tbVar, iOException, z);
        }
    }

    public final void ai(int i, te teVar, sw swVar, tb tbVar) {
        if (m(i, teVar)) {
            this.c.k(swVar, tbVar);
        }
    }

    public final void aj(int i, te teVar, tb tbVar) {
        if (m(i, teVar)) {
            this.c.m(tbVar);
        }
    }

    public final void ak(int i, te teVar) {
        if (m(i, teVar)) {
            this.d.c();
        }
    }

    public final void al(int i, te teVar) {
        if (m(i, teVar)) {
            this.d.d();
        }
    }

    public final void am(int i, te teVar, int i2) {
        if (m(i, teVar)) {
            this.d.e(i2);
        }
    }

    public final void an(int i, te teVar, Exception exc) {
        if (m(i, teVar)) {
            this.d.f(exc);
        }
    }

    public final void ao(int i, te teVar) {
        if (m(i, teVar)) {
            this.d.g();
        }
    }

    public final /* synthetic */ void ap() {
    }
}
