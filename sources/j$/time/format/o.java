package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class o implements j$.time.temporal.o {
    final /* synthetic */ j$.time.chrono.b a;
    final /* synthetic */ j$.time.temporal.o b;
    final /* synthetic */ j$.time.chrono.n c;
    final /* synthetic */ ZoneId d;

    o(j$.time.chrono.b bVar, j$.time.temporal.o oVar, j$.time.chrono.n nVar, ZoneId zoneId) {
        this.a = bVar;
        this.b = oVar;
        this.c = nVar;
        this.d = zoneId;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !rVar.u()) ? this.b.f(rVar) : bVar.f(rVar);
    }

    public final /* synthetic */ int i(j$.time.temporal.r rVar) {
        return j$.time.temporal.n.a(this, rVar);
    }

    public final w l(j$.time.temporal.r rVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !rVar.u()) ? this.b.l(rVar) : bVar.l(rVar);
    }

    public final long q(j$.time.temporal.r rVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !rVar.u()) ? this.b.q(rVar) : bVar.q(rVar);
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.e() ? this.c : tVar == j$.time.temporal.n.k() ? this.d : tVar == j$.time.temporal.n.i() ? this.b.t(tVar) : tVar.a(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.n nVar = this.c;
        if (nVar != null) {
            str = " with chronology " + nVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.b + str + str2;
    }
}
