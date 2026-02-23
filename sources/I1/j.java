package i1;

import android.os.SystemClock;
import h1.b;
import h1.n;
import h1.r;
import h1.s;
import h1.t;
import h1.u;
import h1.v;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j {

    public static class b {
        public final String a;
        public final u b;

        public b(String str, u uVar) {
            this.a = str;
            this.b = uVar;
        }

        public static /* synthetic */ u a(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ String b(b bVar) {
            return bVar.a;
        }

        public /* synthetic */ b(String str, u uVar, a aVar) {
            this(str, uVar);
        }
    }

    public static void a(n nVar, b bVar) {
        r C = nVar.C();
        int D = nVar.D();
        try {
            C.a(b.a(bVar));
            nVar.b(String.format("%s-retry [timeout=%s]", new Object[]{b.b(bVar), Integer.valueOf(D)}));
        } catch (u e) {
            nVar.b(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{b.b(bVar), Integer.valueOf(D)}));
            throw e;
        }
    }

    public static h1.k b(n nVar, long j, List list) {
        b.a s = nVar.s();
        if (s == null) {
            return new h1.k(304, (byte[]) null, true, j, list);
        }
        return new h1.k(304, s.a, true, j, e.a(list, s));
    }

    public static byte[] c(InputStream inputStream, int i, c cVar) {
        byte[] bArr;
        k kVar = new k(cVar, i);
        try {
            bArr = cVar.a(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    kVar.write(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            v.e("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    cVar.b(bArr);
                    kVar.close();
                    throw th;
                }
            }
            byte[] byteArray = kVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                v.e("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.b(bArr);
            kVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArr = null;
        }
    }

    public static void d(long j, n nVar, byte[] bArr, int i) {
        if (v.b || j > 3000) {
            v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", nVar, Long.valueOf(j), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i), Integer.valueOf(nVar.C().b()));
        }
    }

    public static b e(n nVar, IOException iOException, long j, f fVar, byte[] bArr) {
        if (iOException instanceof SocketTimeoutException) {
            return new b("socket", new t(), null);
        }
        if (iOException instanceof MalformedURLException) {
            throw new RuntimeException("Bad URL " + nVar.F(), iOException);
        }
        if (fVar == null) {
            if (nVar.U()) {
                return new b("connection", new h1.l(), null);
            }
            throw new h1.l(iOException);
        }
        int d = fVar.d();
        v.c("Unexpected response code %d for %s", Integer.valueOf(d), nVar.F());
        if (bArr == null) {
            return new b("network", new h1.j(), null);
        }
        h1.k kVar = new h1.k(d, bArr, false, SystemClock.elapsedRealtime() - j, fVar.c());
        if (d == 401 || d == 403) {
            return new b("auth", new h1.a(kVar), null);
        }
        if (d >= 400 && d <= 499) {
            throw new h1.d(kVar);
        }
        if (d < 500 || d > 599 || !nVar.V()) {
            throw new s(kVar);
        }
        return new b("server", new s(kVar), null);
    }
}
