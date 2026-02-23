package i1;

import android.os.SystemClock;
import h1.n;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements h1.h {
    public final g a;
    public final a b;
    public final c c;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    public h1.k a(n nVar) {
        IOException iOException;
        f fVar;
        byte[] bArr;
        f a;
        int d;
        List c;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                a = this.b.a(nVar, e.c(nVar.s()));
                try {
                    d = a.d();
                    c = a.c();
                    break;
                } catch (IOException e) {
                    bArr = null;
                    fVar = a;
                    iOException = e;
                }
            } catch (IOException e2) {
                iOException = e2;
                fVar = null;
                bArr = null;
            }
            j.a(nVar, j.e(nVar, iOException, elapsedRealtime, fVar, bArr));
        }
        if (d == 304) {
            return j.b(nVar, SystemClock.elapsedRealtime() - elapsedRealtime, c);
        }
        InputStream a2 = a.a();
        byte[] c2 = a2 != null ? j.c(a2, a.b(), this.c) : new byte[0];
        j.d(SystemClock.elapsedRealtime() - elapsedRealtime, nVar, c2, d);
        if (d < 200 || d > 299) {
            throw new IOException();
        }
        return new h1.k(d, c2, false, SystemClock.elapsedRealtime() - elapsedRealtime, c);
    }

    public b(a aVar, c cVar) {
        this.b = aVar;
        this.a = aVar;
        this.c = cVar;
    }
}
