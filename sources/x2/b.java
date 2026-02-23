package X2;

import O2.w0;
import android.net.Uri;
import android.text.TextUtils;
import b4.C;
import b4.D;
import b4.S;
import b4.g;
import b4.p;
import b4.s;
import b4.x;
import d4.e;
import d4.h;
import d4.k0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import r5.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b extends g implements C {
    public boolean A;
    public volatile long B;
    public final UrlRequest.Callback e;
    public final CronetEngine f;
    public final Executor g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final C.f n;
    public final C.f o;
    public final h p;
    public final e q;
    public n r;
    public final boolean s;
    public boolean t;
    public long u;
    public UrlRequest v;
    public s w;
    public ByteBuffer x;
    public UrlResponseInfo y;
    public IOException z;

    public class a extends UrlRequest.StatusListener {
        public final /* synthetic */ int[] a;
        public final /* synthetic */ h b;

        public a(int[] iArr, h hVar) {
            this.a = iArr;
            this.b = hVar;
        }

        public void onStatus(int i) {
            this.a[0] = i;
            this.b.f();
        }
    }

    public static final class b implements C.b {
        public final CronetEngine a;
        public final Executor b;
        public C.b e;
        public n f;
        public S g;
        public String h;
        public boolean l;
        public boolean m;
        public boolean n;
        public final C.f c = new C.f();
        public final x.b d = null;
        public int i = 3;
        public int j = 8000;
        public int k = 8000;

        public b(CronetEngine cronetEngine, Executor executor) {
            this.a = (CronetEngine) d4.a.e(cronetEngine);
            this.b = executor;
        }

        public C a() {
            if (this.a == null) {
                C.b bVar = this.e;
                return bVar != null ? bVar.a() : ((x.b) d4.a.e(this.d)).b();
            }
            b bVar2 = new b(this.a, this.b, this.i, this.j, this.k, this.l, this.m, this.h, this.c, this.f, this.n);
            S s = this.g;
            if (s != null) {
                bVar2.g(s);
            }
            return bVar2;
        }
    }

    public static final class c extends C.c {
        public final int e;

        public c(s sVar, int i, int i2) {
            super(sVar, i, 1);
            this.e = i2;
        }

        public c(IOException iOException, s sVar, int i, int i2) {
            super(iOException, sVar, i, 1);
            this.e = i2;
        }

        public c(String str, s sVar, int i, int i2) {
            super(str, sVar, i, 1);
            this.e = i2;
        }
    }

    public final class d extends UrlRequest.Callback {
        public d() {
        }

        public synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            try {
                if (urlRequest != b.x(b.this)) {
                    return;
                }
                if ((cronetException instanceof NetworkException) && ((NetworkException) cronetException).getErrorCode() == 1) {
                    b.D(b.this, new UnknownHostException());
                } else {
                    b.D(b.this, cronetException);
                }
                b.E(b.this).f();
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            if (urlRequest != b.x(b.this)) {
                return;
            }
            b.E(b.this).f();
        }

        public synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            if (urlRequest != b.x(b.this)) {
                return;
            }
            UrlRequest urlRequest2 = (UrlRequest) d4.a.e(b.x(b.this));
            s sVar = (s) d4.a.e(b.C(b.this));
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (sVar.c == 2 && (httpStatusCode == 307 || httpStatusCode == 308)) {
                b.D(b.this, new C.e(httpStatusCode, urlResponseInfo.getHttpStatusText(), null, urlResponseInfo.getAllHeaders(), sVar, k0.f));
                b.E(b.this).f();
                return;
            }
            if (b.F(b.this)) {
                b.G(b.this);
            }
            boolean z = b.H(b.this) && sVar.c == 2 && httpStatusCode == 302;
            if (!z && !b.I(b.this)) {
                urlRequest.followRedirect();
                return;
            }
            String J = b.J((List) urlResponseInfo.getAllHeaders().get("Set-Cookie"));
            if (!z && TextUtils.isEmpty(J)) {
                urlRequest.followRedirect();
                return;
            }
            urlRequest2.cancel();
            try {
                UrlRequest.Builder M = b.this.M((z || sVar.c != 2) ? sVar.g(Uri.parse(str)) : sVar.a().j(str).d(1).c(null).a());
                b.y(M, J);
                b.z(b.this, M.build());
                b.x(b.this).start();
            } catch (IOException e) {
                b.D(b.this, e);
            }
        }

        public synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (urlRequest != b.x(b.this)) {
                return;
            }
            b.A(b.this, urlResponseInfo);
            b.E(b.this).f();
        }

        public synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (urlRequest != b.x(b.this)) {
                return;
            }
            b.B(b.this, true);
            b.E(b.this).f();
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }
    }

    static {
        w0.a("goog.exo.cronet");
    }

    public b(CronetEngine cronetEngine, Executor executor, int i, int i2, int i3, boolean z, boolean z2, String str, C.f fVar, n nVar, boolean z3) {
        super(true);
        this.f = (CronetEngine) d4.a.e(cronetEngine);
        this.g = (Executor) d4.a.e(executor);
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = z;
        this.l = z2;
        this.m = str;
        this.n = fVar;
        this.r = nVar;
        this.s = z3;
        this.q = e.a;
        this.e = new d(this, null);
        this.o = new C.f();
        this.p = new h();
    }

    public static /* synthetic */ UrlResponseInfo A(b bVar, UrlResponseInfo urlResponseInfo) {
        bVar.y = urlResponseInfo;
        return urlResponseInfo;
    }

    public static /* synthetic */ boolean B(b bVar, boolean z) {
        bVar.A = z;
        return z;
    }

    public static /* synthetic */ s C(b bVar) {
        return bVar.w;
    }

    public static /* synthetic */ IOException D(b bVar, IOException iOException) {
        bVar.z = iOException;
        return iOException;
    }

    public static /* synthetic */ h E(b bVar) {
        return bVar.p;
    }

    public static /* synthetic */ boolean F(b bVar) {
        return bVar.k;
    }

    public static /* synthetic */ void G(b bVar) {
        bVar.U();
    }

    public static /* synthetic */ boolean H(b bVar) {
        return bVar.s;
    }

    public static /* synthetic */ boolean I(b bVar) {
        return bVar.l;
    }

    public static /* synthetic */ String J(List list) {
        return R(list);
    }

    public static void K(UrlRequest.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.addHeader("Cookie", str);
    }

    public static String N(Map map, String str) {
        List list = (List) map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public static int P(UrlRequest urlRequest) {
        h hVar = new h();
        int[] iArr = new int[1];
        urlRequest.getStatus(new a(iArr, hVar));
        hVar.a();
        return iArr[0];
    }

    public static boolean Q(UrlResponseInfo urlResponseInfo) {
        Iterator it = urlResponseInfo.getAllHeadersAsList().iterator();
        while (it.hasNext()) {
            if (((String) ((Map.Entry) it.next()).getKey()).equalsIgnoreCase("Content-Encoding")) {
                return !((String) r0.getValue()).equalsIgnoreCase("identity");
            }
        }
        return false;
    }

    public static String R(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return TextUtils.join(";", list);
    }

    public static /* synthetic */ UrlRequest x(b bVar) {
        return bVar.v;
    }

    public static /* synthetic */ void y(UrlRequest.Builder builder, String str) {
        K(builder, str);
    }

    public static /* synthetic */ UrlRequest z(b bVar, UrlRequest urlRequest) {
        bVar.v = urlRequest;
        return urlRequest;
    }

    public final boolean L() {
        long b2 = this.q.b();
        boolean z = false;
        while (!z && b2 < this.B) {
            z = this.p.b((this.B - b2) + 5);
            b2 = this.q.b();
        }
        return z;
    }

    public UrlRequest.Builder M(s sVar) {
        UrlRequest.Builder allowDirectExecutor = this.f.newUrlRequestBuilder(sVar.a.toString(), this.e, this.g).setPriority(this.h).allowDirectExecutor();
        HashMap hashMap = new HashMap();
        C.f fVar = this.n;
        if (fVar != null) {
            hashMap.putAll(fVar.a());
        }
        hashMap.putAll(this.o.a());
        hashMap.putAll(sVar.e);
        for (Map.Entry entry : hashMap.entrySet()) {
            allowDirectExecutor.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        if (sVar.d != null && !hashMap.containsKey("Content-Type")) {
            throw new c("HTTP request with non-empty body must set Content-Type", sVar, 1004, 0);
        }
        String a2 = D.a(sVar.g, sVar.h);
        if (a2 != null) {
            allowDirectExecutor.addHeader("Range", a2);
        }
        String str = this.m;
        if (str != null) {
            allowDirectExecutor.addHeader("User-Agent", str);
        }
        allowDirectExecutor.setHttpMethod(sVar.b());
        byte[] bArr = sVar.d;
        if (bArr != null) {
            allowDirectExecutor.setUploadDataProvider(new X2.a(bArr), this.g);
        }
        return allowDirectExecutor;
    }

    public final ByteBuffer O() {
        if (this.x == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32768);
            this.x = allocateDirect;
            allocateDirect.limit(0);
        }
        return this.x;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S(java.nio.ByteBuffer r6, b4.s r7) {
        /*
            r5 = this;
            org.chromium.net.UrlRequest r0 = r5.v
            java.lang.Object r0 = d4.k0.j(r0)
            org.chromium.net.UrlRequest r0 = (org.chromium.net.UrlRequest) r0
            r0.read(r6)
            r0 = 2
            r1 = 0
            d4.h r2 = r5.p     // Catch: java.net.SocketTimeoutException -> L1f java.lang.InterruptedException -> L21
            int r3 = r5.j     // Catch: java.net.SocketTimeoutException -> L1f java.lang.InterruptedException -> L21
            long r3 = (long) r3     // Catch: java.net.SocketTimeoutException -> L1f java.lang.InterruptedException -> L21
            boolean r2 = r2.b(r3)     // Catch: java.net.SocketTimeoutException -> L1f java.lang.InterruptedException -> L21
            if (r2 == 0) goto L19
            goto L46
        L19:
            java.net.SocketTimeoutException r2 = new java.net.SocketTimeoutException     // Catch: java.net.SocketTimeoutException -> L1f java.lang.InterruptedException -> L21
            r2.<init>()     // Catch: java.net.SocketTimeoutException -> L1f java.lang.InterruptedException -> L21
            throw r2     // Catch: java.net.SocketTimeoutException -> L1f java.lang.InterruptedException -> L21
        L1f:
            r2 = move-exception
            goto L23
        L21:
            goto L33
        L23:
            java.nio.ByteBuffer r3 = r5.x
            if (r6 != r3) goto L29
            r5.x = r1
        L29:
            b4.C$c r6 = new b4.C$c
            r1 = 2002(0x7d2, float:2.805E-42)
            r6.<init>(r2, r7, r1, r0)
        L30:
            r5.z = r6
            goto L46
        L33:
            java.nio.ByteBuffer r2 = r5.x
            if (r6 != r2) goto L39
            r5.x = r1
        L39:
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r6.interrupt()
            java.io.InterruptedIOException r6 = new java.io.InterruptedIOException
            r6.<init>()
            goto L30
        L46:
            java.io.IOException r6 = r5.z
            if (r6 == 0) goto L56
            boolean r1 = r6 instanceof b4.C.c
            if (r1 == 0) goto L51
            b4.C$c r6 = (b4.C.c) r6
            throw r6
        L51:
            b4.C$c r6 = b4.C.c.c(r6, r7, r0)
            throw r6
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.b.S(java.nio.ByteBuffer, b4.s):void");
    }

    public final byte[] T() {
        byte[] bArr = k0.f;
        ByteBuffer O = O();
        while (!this.A) {
            this.p.d();
            O.clear();
            S(O, (s) k0.j(this.w));
            O.flip();
            if (O.remaining() > 0) {
                int length = bArr.length;
                bArr = Arrays.copyOf(bArr, bArr.length + O.remaining());
                O.get(bArr, length, O.remaining());
            }
        }
        return bArr;
    }

    public final void U() {
        this.B = this.q.b() + this.i;
    }

    public final void V(long j, s sVar) {
        if (j == 0) {
            return;
        }
        ByteBuffer O = O();
        while (j > 0) {
            try {
                this.p.d();
                O.clear();
                S(O, sVar);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (this.A) {
                    throw new c(sVar, 2008, 14);
                }
                O.flip();
                d4.a.g(O.hasRemaining());
                int min = (int) Math.min(O.remaining(), j);
                O.position(O.position() + min);
                j -= min;
            } catch (IOException e) {
                if (e instanceof C.c) {
                    throw ((C.c) e);
                }
                throw new c(e, sVar, e instanceof SocketTimeoutException ? 2002 : 2001, 14);
            }
        }
    }

    public long a(s sVar) {
        byte[] bArr;
        String N;
        d4.a.e(sVar);
        d4.a.g(!this.t);
        this.p.d();
        U();
        this.w = sVar;
        try {
            UrlRequest build = M(sVar).build();
            this.v = build;
            build.start();
            v(sVar);
            try {
                boolean L = L();
                IOException iOException = this.z;
                if (iOException != null) {
                    String message = iOException.getMessage();
                    if (message == null || !r5.b.e(message).contains("err_cleartext_not_permitted")) {
                        throw new c(iOException, sVar, 2001, P(build));
                    }
                    throw new C.a(iOException, sVar);
                }
                if (!L) {
                    throw new c((IOException) new SocketTimeoutException(), sVar, 2002, P(build));
                }
                UrlResponseInfo urlResponseInfo = (UrlResponseInfo) d4.a.e(this.y);
                int httpStatusCode = urlResponseInfo.getHttpStatusCode();
                Map allHeaders = urlResponseInfo.getAllHeaders();
                long j = 0;
                if (httpStatusCode < 200 || httpStatusCode > 299) {
                    if (httpStatusCode == 416) {
                        if (sVar.g == D.c(N(allHeaders, "Content-Range"))) {
                            this.t = true;
                            w(sVar);
                            long j2 = sVar.h;
                            if (j2 != -1) {
                                return j2;
                            }
                            return 0L;
                        }
                    }
                    try {
                        bArr = T();
                    } catch (IOException unused) {
                        bArr = k0.f;
                    }
                    throw new C.e(httpStatusCode, urlResponseInfo.getHttpStatusText(), httpStatusCode == 416 ? new p(2008) : null, allHeaders, sVar, bArr);
                }
                n nVar = this.r;
                if (nVar != null && (N = N(allHeaders, "Content-Type")) != null && !nVar.apply(N)) {
                    throw new C.d(N, sVar);
                }
                if (httpStatusCode == 200) {
                    long j3 = sVar.g;
                    if (j3 != 0) {
                        j = j3;
                    }
                }
                if (Q(urlResponseInfo)) {
                    this.u = sVar.h;
                } else {
                    long j4 = sVar.h;
                    if (j4 != -1) {
                        this.u = j4;
                    } else {
                        long b2 = D.b(N(allHeaders, "Content-Length"), N(allHeaders, "Content-Range"));
                        this.u = b2 != -1 ? b2 - j : -1L;
                    }
                }
                this.t = true;
                w(sVar);
                V(j, sVar);
                return this.u;
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                throw new c((IOException) new InterruptedIOException(), sVar, 1004, -1);
            }
        } catch (IOException e) {
            if (e instanceof C.c) {
                throw ((C.c) e);
            }
            throw new c(e, sVar, 2000, 0);
        }
    }

    public synchronized void close() {
        try {
            UrlRequest urlRequest = this.v;
            if (urlRequest != null) {
                urlRequest.cancel();
                this.v = null;
            }
            ByteBuffer byteBuffer = this.x;
            if (byteBuffer != null) {
                byteBuffer.limit(0);
            }
            this.w = null;
            this.y = null;
            this.z = null;
            this.A = false;
            if (this.t) {
                this.t = false;
                u();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Map e() {
        UrlResponseInfo urlResponseInfo = this.y;
        return urlResponseInfo == null ? Collections.emptyMap() : urlResponseInfo.getAllHeaders();
    }

    public Uri getUri() {
        UrlResponseInfo urlResponseInfo = this.y;
        if (urlResponseInfo == null) {
            return null;
        }
        return Uri.parse(urlResponseInfo.getUrl());
    }

    public int read(byte[] bArr, int i, int i2) {
        d4.a.g(this.t);
        if (i2 == 0) {
            return 0;
        }
        if (this.u == 0) {
            return -1;
        }
        ByteBuffer O = O();
        if (!O.hasRemaining()) {
            this.p.d();
            O.clear();
            S(O, (s) k0.j(this.w));
            if (this.A) {
                this.u = 0L;
                return -1;
            }
            O.flip();
            d4.a.g(O.hasRemaining());
        }
        long j = this.u;
        if (j == -1) {
            j = Long.MAX_VALUE;
        }
        int d2 = (int) w5.h.d(j, O.remaining(), i2);
        O.get(bArr, i, d2);
        long j2 = this.u;
        if (j2 != -1) {
            this.u = j2 - d2;
        }
        t(d2);
        return d2;
    }
}
