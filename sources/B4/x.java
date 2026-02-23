package b4;

import android.net.Uri;
import b4.C;
import d4.k0;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import s5.Z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class x extends g implements C {
    public final boolean e;
    public final int f;
    public final int g;
    public final String h;
    public final C.f i;
    public final C.f j;
    public final boolean k;
    public r5.n l;
    public s m;
    public HttpURLConnection n;
    public InputStream o;
    public boolean p;
    public int q;
    public long r;
    public long s;

    public static final class b implements C.b {
        public S b;
        public r5.n c;
        public String d;
        public boolean g;
        public boolean h;
        public final C.f a = new C.f();
        public int e = 8000;
        public int f = 8000;

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a() {
            x xVar = new x(this.d, this.e, this.f, this.g, this.a, this.c, this.h, null);
            S s = this.b;
            if (s != null) {
                xVar.g(s);
            }
            return xVar;
        }

        public b c(String str) {
            this.d = str;
            return this;
        }
    }

    public static class c extends s5.s {
        public final Map a;

        public c(Map map) {
            this.a = map;
        }

        public static /* synthetic */ boolean g(String str) {
            return k(str);
        }

        public static /* synthetic */ boolean h(Map.Entry entry) {
            return j(entry);
        }

        public static /* synthetic */ boolean j(Map.Entry entry) {
            return entry.getKey() != null;
        }

        public static /* synthetic */ boolean k(String str) {
            return str != null;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map a() {
            return this.a;
        }

        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return super.d(obj);
        }

        public Set entrySet() {
            return Z.b(super.entrySet(), new z());
        }

        public boolean equals(Object obj) {
            return obj != null && super.e(obj);
        }

        public int hashCode() {
            return super.f();
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public List get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        public Set keySet() {
            return Z.b(super.keySet(), new y());
        }

        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }
    }

    public x(String str, int i, int i2, boolean z, C.f fVar, r5.n nVar, boolean z2) {
        super(true);
        this.h = str;
        this.f = i;
        this.g = i2;
        this.e = z;
        this.i = fVar;
        this.l = nVar;
        this.j = new C.f();
        this.k = z2;
    }

    public static void C(HttpURLConnection httpURLConnection, long j) {
        int i;
        if (httpURLConnection == null || (i = k0.a) < 19 || i > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) d4.a.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", (Class[]) null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, (Object[]) null);
            }
        } catch (Exception unused) {
        }
    }

    private void F(long j, s sVar) {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int read = ((InputStream) k0.j(this.o)).read(bArr, 0, (int) Math.min(j, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new C.c((IOException) new InterruptedIOException(), sVar, 2000, 1);
            }
            if (read == -1) {
                throw new C.c(sVar, 2008, 1);
            }
            j -= read;
            t(read);
        }
    }

    public static boolean z(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ac, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.net.HttpURLConnection A(b4.s r26) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.x.A(b4.s):java.net.HttpURLConnection");
    }

    public final HttpURLConnection B(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) {
        HttpURLConnection D = D(url);
        D.setConnectTimeout(this.f);
        D.setReadTimeout(this.g);
        HashMap hashMap = new HashMap();
        C.f fVar = this.i;
        if (fVar != null) {
            hashMap.putAll(fVar.a());
        }
        hashMap.putAll(this.j.a());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            D.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a2 = D.a(j, j2);
        if (a2 != null) {
            D.setRequestProperty("Range", a2);
        }
        String str = this.h;
        if (str != null) {
            D.setRequestProperty("User-Agent", str);
        }
        D.setRequestProperty("Accept-Encoding", z ? "gzip" : "identity");
        D.setInstanceFollowRedirects(z2);
        D.setDoOutput(bArr != null);
        D.setRequestMethod(s.c(i));
        if (bArr != null) {
            D.setFixedLengthStreamingMode(bArr.length);
            D.connect();
            OutputStream outputStream = D.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            D.connect();
        }
        return D;
    }

    public HttpURLConnection D(URL url) {
        return url.openConnection();
    }

    public final int E(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.r;
        if (j != -1) {
            long j2 = j - this.s;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int read = ((InputStream) k0.j(this.o)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.s += read;
        t(read);
        return read;
    }

    public long a(s sVar) {
        byte[] bArr;
        this.m = sVar;
        long j = 0;
        this.s = 0L;
        this.r = 0L;
        v(sVar);
        try {
            HttpURLConnection A = A(sVar);
            this.n = A;
            this.q = A.getResponseCode();
            String responseMessage = A.getResponseMessage();
            int i = this.q;
            if (i < 200 || i > 299) {
                Map headerFields = A.getHeaderFields();
                if (this.q == 416) {
                    if (sVar.g == D.c(A.getHeaderField("Content-Range"))) {
                        this.p = true;
                        w(sVar);
                        long j2 = sVar.h;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = A.getErrorStream();
                try {
                    bArr = errorStream != null ? k0.p1(errorStream) : k0.f;
                } catch (IOException unused) {
                    bArr = k0.f;
                }
                byte[] bArr2 = bArr;
                x();
                throw new C.e(this.q, responseMessage, this.q == 416 ? new p(2008) : null, headerFields, sVar, bArr2);
            }
            String contentType = A.getContentType();
            r5.n nVar = this.l;
            if (nVar != null && !nVar.apply(contentType)) {
                x();
                throw new C.d(contentType, sVar);
            }
            if (this.q == 200) {
                long j3 = sVar.g;
                if (j3 != 0) {
                    j = j3;
                }
            }
            boolean z = z(A);
            if (z) {
                this.r = sVar.h;
            } else {
                long j4 = sVar.h;
                if (j4 != -1) {
                    this.r = j4;
                } else {
                    long b2 = D.b(A.getHeaderField("Content-Length"), A.getHeaderField("Content-Range"));
                    this.r = b2 != -1 ? b2 - j : -1L;
                }
            }
            try {
                this.o = A.getInputStream();
                if (z) {
                    this.o = new GZIPInputStream(this.o);
                }
                this.p = true;
                w(sVar);
                try {
                    F(j, sVar);
                    return this.r;
                } catch (IOException e) {
                    x();
                    if (e instanceof C.c) {
                        throw ((C.c) e);
                    }
                    throw new C.c(e, sVar, 2000, 1);
                }
            } catch (IOException e2) {
                x();
                throw new C.c(e2, sVar, 2000, 1);
            }
        } catch (IOException e3) {
            x();
            throw C.c.c(e3, sVar, 1);
        }
    }

    public void close() {
        try {
            InputStream inputStream = this.o;
            if (inputStream != null) {
                long j = this.r;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.s;
                }
                C(this.n, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new C.c(e, (s) k0.j(this.m), 2000, 3);
                }
            }
        } finally {
            this.o = null;
            x();
            if (this.p) {
                this.p = false;
                u();
            }
        }
    }

    public Map e() {
        HttpURLConnection httpURLConnection = this.n;
        return httpURLConnection == null ? s5.A.k() : new c(httpURLConnection.getHeaderFields());
    }

    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return E(bArr, i, i2);
        } catch (IOException e) {
            throw C.c.c(e, (s) k0.j(this.m), 2);
        }
    }

    public final void x() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                d4.B.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.n = null;
        }
    }

    public final URL y(URL url, String str, s sVar) {
        if (str == null) {
            throw new C.c("Null location redirect", sVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new C.c("Unsupported protocol redirect: " + protocol, sVar, 2001, 1);
            }
            if (this.e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new C.c("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", sVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new C.c((IOException) e, sVar, 2001, 1);
        }
    }

    public /* synthetic */ x(String str, int i, int i2, boolean z, C.f fVar, r5.n nVar, boolean z2, a aVar) {
        this(str, i, i2, z, fVar, nVar, z2);
    }
}
