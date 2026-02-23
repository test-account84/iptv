package B3;

import android.net.Uri;
import java.io.EOFException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements M {
    public final d3.o a;
    public d3.i b;
    public d3.j c;

    public c(d3.o oVar) {
        this.a = oVar;
    }

    public void a(long j, long j2) {
        ((d3.i) d4.a.e(this.b)).a(j, j2);
    }

    public void b() {
        d3.i iVar = this.b;
        if (iVar instanceof k3.f) {
            ((k3.f) iVar).j();
        }
    }

    public int c(d3.t tVar) {
        return ((d3.i) d4.a.e(this.b)).d((d3.j) d4.a.e(this.c), tVar);
    }

    public long d() {
        d3.j jVar = this.c;
        if (jVar != null) {
            return jVar.getPosition();
        }
        return -1L;
    }

    public void e(b4.k kVar, Uri uri, Map map, long j, long j2, d3.k kVar2) {
        d3.c cVar = new d3.c(kVar, j, j2);
        this.c = cVar;
        if (this.b != null) {
            return;
        }
        d3.i[] a = this.a.a(uri, map);
        if (a.length == 1) {
            this.b = a[0];
        } else {
            int length = a.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                d3.i iVar = a[i];
                try {
                } catch (EOFException unused) {
                    if (this.b != null || cVar.getPosition() == j) {
                    }
                } catch (Throwable th) {
                    d4.a.g(this.b != null || cVar.getPosition() == j);
                    cVar.f();
                    throw th;
                }
                if (iVar.h(cVar)) {
                    this.b = iVar;
                    d4.a.g(true);
                    cVar.f();
                    break;
                } else {
                    boolean z = this.b != null || cVar.getPosition() == j;
                    d4.a.g(z);
                    cVar.f();
                    i++;
                }
            }
            if (this.b == null) {
                throw new j0("None of the available extractors (" + d4.k0.O(a) + ") could read the stream.", (Uri) d4.a.e(uri));
            }
        }
        this.b.b(kVar2);
    }

    public void release() {
        d3.i iVar = this.b;
        if (iVar != null) {
            iVar.release();
            this.b = null;
        }
        this.c = null;
    }
}
