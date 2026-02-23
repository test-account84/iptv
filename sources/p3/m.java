package P3;

import O2.l1;
import O2.z0;
import d3.t;
import d3.w;
import d4.M;
import d4.k0;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class m implements d3.i {
    public final j a;
    public final z0 d;
    public d3.k g;
    public w h;
    public int i;
    public final d b = new d();
    public final M c = new M();
    public final List e = new ArrayList();
    public final List f = new ArrayList();
    public int j = 0;
    public long k = -9223372036854775807L;

    public m(j jVar, z0 z0Var) {
        this.a = jVar;
        this.d = z0Var.b().g0("text/x-exoplayer-cues").K(z0Var.m).G();
    }

    public void a(long j, long j2) {
        int i = this.j;
        d4.a.g((i == 0 || i == 5) ? false : true);
        this.k = j2;
        if (this.j == 2) {
            this.j = 1;
        }
        if (this.j == 4) {
            this.j = 3;
        }
    }

    public void b(d3.k kVar) {
        d4.a.g(this.j == 0);
        this.g = kVar;
        this.h = kVar.e(0, 3);
        this.g.q();
        this.g.n(new com.google.android.exoplayer2.extractor.f(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.h.d(this.d);
        this.j = 1;
    }

    public final void c() {
        n nVar;
        o oVar;
        try {
            Object d = this.a.d();
            while (true) {
                nVar = (n) d;
                if (nVar != null) {
                    break;
                }
                Thread.sleep(5L);
                d = this.a.d();
            }
            nVar.e(this.i);
            nVar.d.put(this.c.e(), 0, this.i);
            nVar.d.limit(this.i);
            this.a.c(nVar);
            Object b = this.a.b();
            while (true) {
                oVar = (o) b;
                if (oVar != null) {
                    break;
                }
                Thread.sleep(5L);
                b = this.a.b();
            }
            for (int i = 0; i < oVar.h(); i++) {
                byte[] a = this.b.a(oVar.b(oVar.c(i)));
                this.e.add(Long.valueOf(oVar.c(i)));
                this.f.add(new M(a));
            }
            oVar.release();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        } catch (k e) {
            throw l1.a("SubtitleDecoder failed.", e);
        }
    }

    public int d(d3.j jVar, t tVar) {
        int i = this.j;
        d4.a.g((i == 0 || i == 5) ? false : true);
        if (this.j == 1) {
            this.c.Q(jVar.getLength() != -1 ? w5.f.d(jVar.getLength()) : 1024);
            this.i = 0;
            this.j = 2;
        }
        if (this.j == 2 && e(jVar)) {
            c();
            g();
            this.j = 4;
        }
        if (this.j == 3 && f(jVar)) {
            g();
            this.j = 4;
        }
        return this.j == 4 ? -1 : 0;
    }

    public final boolean e(d3.j jVar) {
        int b = this.c.b();
        int i = this.i;
        if (b == i) {
            this.c.c(i + 1024);
        }
        int read = jVar.read(this.c.e(), this.i, this.c.b() - this.i);
        if (read != -1) {
            this.i += read;
        }
        long length = jVar.getLength();
        return (length != -1 && ((long) this.i) == length) || read == -1;
    }

    public final boolean f(d3.j jVar) {
        return jVar.b((jVar.getLength() > (-1L) ? 1 : (jVar.getLength() == (-1L) ? 0 : -1)) != 0 ? w5.f.d(jVar.getLength()) : 1024) == -1;
    }

    public final void g() {
        d4.a.i(this.h);
        d4.a.g(this.e.size() == this.f.size());
        long j = this.k;
        for (int g = j == -9223372036854775807L ? 0 : k0.g(this.e, Long.valueOf(j), true, true); g < this.f.size(); g++) {
            M m = (M) this.f.get(g);
            m.U(0);
            int length = m.e().length;
            this.h.b(m, length);
            this.h.f(((Long) this.e.get(g)).longValue(), 1, length, 0, null);
        }
    }

    public boolean h(d3.j jVar) {
        return true;
    }

    public void release() {
        if (this.j == 5) {
            return;
        }
        this.a.release();
        this.j = 5;
    }
}
