package B3;

import B3.C;
import B3.z;
import O2.H1;
import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v implements z, z.a {
    public final C.b a;
    public final long c;
    public final b4.b d;
    public C e;
    public z f;
    public z.a g;
    public a h;
    public boolean i;
    public long j = -9223372036854775807L;

    public interface a {
        void a(C.b bVar);

        void b(C.b bVar, IOException iOException);
    }

    public v(C.b bVar, b4.b bVar2, long j) {
        this.a = bVar;
        this.d = bVar2;
        this.c = j;
    }

    public void a(C.b bVar) {
        long r = r(this.c);
        z E = ((C) d4.a.e(this.e)).E(bVar, this.d, r);
        this.f = E;
        if (this.g != null) {
            E.s(this, r);
        }
    }

    public boolean b() {
        z zVar = this.f;
        return zVar != null && zVar.b();
    }

    public long c() {
        return ((z) d4.k0.j(this.f)).c();
    }

    public long d(long j, H1 h1) {
        return ((z) d4.k0.j(this.f)).d(j, h1);
    }

    public void e(z zVar) {
        ((z.a) d4.k0.j(this.g)).e(this);
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(this.a);
        }
    }

    public boolean f(long j) {
        z zVar = this.f;
        return zVar != null && zVar.f(j);
    }

    public long g() {
        return ((z) d4.k0.j(this.f)).g();
    }

    public void h(long j) {
        ((z) d4.k0.j(this.f)).h(j);
    }

    public long i(Z3.s[] sVarArr, boolean[] zArr, Y[] yArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.j;
        if (j3 == -9223372036854775807L || j != this.c) {
            j2 = j;
        } else {
            this.j = -9223372036854775807L;
            j2 = j3;
        }
        return ((z) d4.k0.j(this.f)).i(sVarArr, zArr, yArr, zArr2, j2);
    }

    public /* synthetic */ List k(List list) {
        return y.a(this, list);
    }

    public long l(long j) {
        return ((z) d4.k0.j(this.f)).l(j);
    }

    public long m() {
        return ((z) d4.k0.j(this.f)).m();
    }

    public long o() {
        return this.j;
    }

    public void p() {
        try {
            z zVar = this.f;
            if (zVar != null) {
                zVar.p();
            } else {
                C c = this.e;
                if (c != null) {
                    c.P();
                }
            }
        } catch (IOException e) {
            a aVar = this.h;
            if (aVar == null) {
                throw e;
            }
            if (this.i) {
                return;
            }
            this.i = true;
            aVar.b(this.a, e);
        }
    }

    public long q() {
        return this.c;
    }

    public final long r(long j) {
        long j2 = this.j;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    public void s(z.a aVar, long j) {
        this.g = aVar;
        z zVar = this.f;
        if (zVar != null) {
            zVar.s(this, r(this.c));
        }
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void j(z zVar) {
        ((z.a) d4.k0.j(this.g)).j(this);
    }

    public i0 u() {
        return ((z) d4.k0.j(this.f)).u();
    }

    public void v(long j, boolean z) {
        ((z) d4.k0.j(this.f)).v(j, z);
    }

    public void w(long j) {
        this.j = j;
    }

    public void x() {
        if (this.f != null) {
            ((C) d4.a.e(this.e)).Y(this.f);
        }
    }

    public void y(C c) {
        d4.a.g(this.e == null);
        this.e = c;
    }

    public void z(a aVar) {
        this.h = aVar;
    }
}
