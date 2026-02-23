package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class sg implements tk, no {
    final /* synthetic */ si a;
    private final Object b;
    private tj c;
    private nn d;

    public sg(si siVar, Object obj) {
        this.a = siVar;
        this.c = siVar.x(null);
        this.d = siVar.v(null);
        this.b = obj;
    }

    private final tb m(tb tbVar) {
        long c = this.a.c(this.b, tbVar.f);
        long c2 = this.a.c(this.b, tbVar.g);
        return (c == tbVar.f && c2 == tbVar.g) ? tbVar : new tb(tbVar.a, tbVar.b, tbVar.c, tbVar.d, c, c2);
    }

    private final boolean n(int i, te teVar) {
        te teVar2;
        if (teVar != null) {
            teVar2 = this.a.d(this.b, teVar);
            if (teVar2 == null) {
                return false;
            }
        } else {
            teVar2 = null;
        }
        int b = this.a.b(this.b, i);
        tj tjVar = this.c;
        if (tjVar.a != b || !cq.V(tjVar.b, teVar2)) {
            this.c = this.a.M(b, teVar2);
        }
        nn nnVar = this.d;
        if (nnVar.a == b && cq.V(nnVar.b, teVar2)) {
            return true;
        }
        this.d = this.a.w(b, teVar2);
        return true;
    }

    public final void ae(int i, te teVar, tb tbVar) {
        if (n(i, teVar)) {
            this.c.c(m(tbVar));
        }
    }

    public final void af(int i, te teVar, sw swVar, tb tbVar) {
        if (n(i, teVar)) {
            this.c.e(swVar, m(tbVar));
        }
    }

    public final void ag(int i, te teVar, sw swVar, tb tbVar) {
        if (n(i, teVar)) {
            this.c.g(swVar, m(tbVar));
        }
    }

    public final void ah(int i, te teVar, sw swVar, tb tbVar, IOException iOException, boolean z) {
        if (n(i, teVar)) {
            this.c.i(swVar, m(tbVar), iOException, z);
        }
    }

    public final void ai(int i, te teVar, sw swVar, tb tbVar) {
        if (n(i, teVar)) {
            this.c.k(swVar, m(tbVar));
        }
    }

    public final void aj(int i, te teVar, tb tbVar) {
        if (n(i, teVar)) {
            this.c.m(m(tbVar));
        }
    }

    public final void ak(int i, te teVar) {
        if (n(i, teVar)) {
            this.d.c();
        }
    }

    public final void al(int i, te teVar) {
        if (n(i, teVar)) {
            this.d.d();
        }
    }

    public final void am(int i, te teVar, int i2) {
        if (n(i, teVar)) {
            this.d.e(i2);
        }
    }

    public final void an(int i, te teVar, Exception exc) {
        if (n(i, teVar)) {
            this.d.f(exc);
        }
    }

    public final void ao(int i, te teVar) {
        if (n(i, teVar)) {
            this.d.g();
        }
    }

    public final /* synthetic */ void ap() {
    }
}
