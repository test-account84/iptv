package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import k8.a;
import k8.q;
import kotlin.jvm.internal.l;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;

    @NotNull
    private final OkHttpClient client;

    @Nullable
    private RealConnection connection;
    private final RealConnectionPool connectionPool;

    @Nullable
    private volatile RealConnection connectionToCancel;

    @NotNull
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;

    @Nullable
    private Exchange interceptorScopedExchange;

    @NotNull
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final 1 timeout;
    private boolean timeoutEarlyExit;

    public final class AsyncCall implements Runnable {

        @NotNull
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(@NotNull RealCall realCall, Callback responseCallback) {
            l.e(responseCallback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(@NotNull ExecutorService executorService) {
            l.e(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (Util.assertionsEnabled && Thread.holdsLock(dispatcher)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                l.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(dispatcher);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    IOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        @NotNull
        public final RealCall getCall() {
            return this.this$0;
        }

        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @NotNull
        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        @NotNull
        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@NotNull AsyncCall other) {
            l.e(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        public void run() {
            Throwable th;
            boolean z;
            IOException e;
            Dispatcher dispatcher;
            String str = "OkHttp " + this.this$0.redactedUrl$okhttp();
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName(str);
            try {
                RealCall.access$getTimeout$p(this.this$0).enter();
                try {
                    try {
                        z = true;
                    } catch (Throwable th2) {
                        this.this$0.getClient().dispatcher().finished$okhttp(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                }
                try {
                    this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain$okhttp());
                    dispatcher = this.this$0.getClient().dispatcher();
                } catch (IOException e3) {
                    e = e3;
                    if (z) {
                        Platform.Companion.get().log("Callback failure for " + RealCall.access$toLoggableString(this.this$0), 4, e);
                    } else {
                        this.responseCallback.onFailure(this.this$0, e);
                    }
                    dispatcher = this.this$0.getClient().dispatcher();
                    dispatcher.finished$okhttp(this);
                } catch (Throwable th4) {
                    th = th4;
                    this.this$0.cancel();
                    if (!z) {
                        IOException iOException = new IOException("canceled due to " + th);
                        a.a(iOException, th);
                        this.responseCallback.onFailure(this.this$0, iOException);
                    }
                    throw th;
                }
                dispatcher.finished$okhttp(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    public static final class CallReference extends WeakReference {

        @Nullable
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(@NotNull RealCall referent, @Nullable Object obj) {
            super(referent);
            l.e(referent, "referent");
            this.callStackTrace = obj;
        }

        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    public static final class 1 extends AsyncTimeout {
        public 1() {
        }

        public void timedOut() {
            RealCall.this.cancel();
        }
    }

    public RealCall(@NotNull OkHttpClient client, @NotNull Request originalRequest, boolean z) {
        l.e(client, "client");
        l.e(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z;
        this.connectionPool = client.connectionPool().getDelegate$okhttp();
        this.eventListener = client.eventListenerFactory().create(this);
        1 r4 = new 1();
        r4.timeout(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        q qVar = q.a;
        this.timeout = r4;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public static final /* synthetic */ 1 access$getTimeout$p(RealCall realCall) {
        return realCall.timeout;
    }

    public static final /* synthetic */ String access$toLoggableString(RealCall realCall) {
        return realCall.toLoggableString();
    }

    private final IOException callDone(IOException iOException) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z = Util.assertionsEnabled;
        if (z && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z && Thread.holdsLock(realConnection)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread currentThread2 = Thread.currentThread();
                l.d(currentThread2, "Thread.currentThread()");
                sb2.append(currentThread2.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(realConnection);
                throw new AssertionError(sb2.toString());
            }
            synchronized (realConnection) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
            } else {
                if (!(releaseConnectionNoEvents$okhttp == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        IOException timeoutExit = timeoutExit(iOException);
        if (iOException != null) {
            EventListener eventListener = this.eventListener;
            l.b(timeoutExit);
            eventListener.callFailed(this, timeoutExit);
        } else {
            this.eventListener.callEnd(this);
        }
        return timeoutExit;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private final IOException timeoutExit(IOException iOException) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(@NotNull RealConnection connection) {
        l.e(connection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(connection)) {
            if (!(this.connection == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        l.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(connection);
        throw new AssertionError(sb.toString());
    }

    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        RealConnection realConnection = this.connectionToCancel;
        if (realConnection != null) {
            realConnection.cancel();
        }
        this.eventListener.canceled(this);
    }

    public void enqueue(@NotNull Callback responseCallback) {
        l.e(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
    }

    public final void enterNetworkInterceptorExchange(@NotNull Request request, boolean z) {
        l.e(request, "request");
        if (!(this.interceptorScopedExchange == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            q qVar = q.a;
        }
        if (z) {
            this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
        }
    }

    @NotNull
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.timeout.enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            q qVar = q.a;
        }
        if (z && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }

    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Nullable
    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    @NotNull
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response getResponseWithInterceptorChain$okhttp() throws java.io.IOException {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List r0 = r0.interceptors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            l8.p.q(r2, r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            okhttp3.CookieJar r1 = r1.cookieJar()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            okhttp3.Cache r1 = r1.cache()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r10.forWebSocket
            if (r0 != 0) goto L4a
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List r0 = r0.networkInterceptors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            l8.p.q(r2, r0)
        L4a:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r10.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            okhttp3.Request r5 = r10.originalRequest
            okhttp3.OkHttpClient r0 = r10.client
            int r6 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r10.client
            int r7 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r10.client
            int r8 = r0.writeTimeoutMillis()
            r3 = 0
            r4 = 0
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r10.originalRequest     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            okhttp3.Response r2 = r9.proceed(r2)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            boolean r3 = r10.isCanceled()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            if (r3 != 0) goto L83
            r10.noMoreExchanges$okhttp(r0)
            return r2
        L83:
            okhttp3.internal.Util.closeQuietly(r2)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            throw r2     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
        L8e:
            r2 = move-exception
            goto La5
        L90:
            r1 = move-exception
            r2 = 1
            java.io.IOException r1 = r10.noMoreExchanges$okhttp(r1)     // Catch: java.lang.Throwable -> La0
            if (r1 != 0) goto La4
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> La0
            throw r1     // Catch: java.lang.Throwable -> La0
        La0:
            r1 = move-exception
            r2 = r1
            r1 = 1
            goto La5
        La4:
            throw r1     // Catch: java.lang.Throwable -> La0
        La5:
            if (r1 != 0) goto Laa
            r10.noMoreExchanges$okhttp(r0)
        Laa:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():okhttp3.Response");
    }

    @NotNull
    public final Exchange initExchange$okhttp(@NotNull RealInterceptorChain chain) {
        l.e(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            q qVar = q.a;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        l.b(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find(this.client, chain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    public final IOException messageDone$okhttp(@NotNull Exchange exchange, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        l.e(exchange, "exchange");
        boolean z4 = true;
        if (!l.a(exchange, this.exchange)) {
            return iOException;
        }
        synchronized (this) {
            z3 = false;
            if (z) {
                try {
                    if (!this.requestBodyOpen) {
                        if (z2 || !this.responseBodyOpen) {
                            z4 = false;
                        }
                    }
                    if (z) {
                        this.requestBodyOpen = false;
                    }
                    if (z2) {
                        this.responseBodyOpen = false;
                    }
                    boolean z5 = this.requestBodyOpen;
                    boolean z6 = (z5 || this.responseBodyOpen) ? false : true;
                    if (z5 || this.responseBodyOpen || this.expectMoreExchanges) {
                        z4 = false;
                    }
                    z3 = z6;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z2) {
                }
                z4 = false;
            }
            q qVar = q.a;
        }
        if (z3) {
            this.exchange = null;
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                realConnection.incrementSuccessCount$okhttp();
            }
        }
        return z4 ? callDone(iOException) : iOException;
    }

    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.expectMoreExchanges) {
                    this.expectMoreExchanges = false;
                    if (!this.requestBodyOpen && !this.responseBodyOpen) {
                        z = true;
                    }
                }
                q qVar = q.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z ? callDone(iOException) : iOException;
    }

    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        l.b(realConnection);
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnection);
            throw new AssertionError(sb.toString());
        }
        List calls = realConnection.getCalls();
        Iterator it = calls.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (l.a((RealCall) ((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        calls.remove(i);
        this.connection = null;
        if (calls.isEmpty()) {
            realConnection.setIdleAtNs$okhttp(System.nanoTime());
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
        }
        return null;
    }

    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        l.b(exchangeFinder);
        return exchangeFinder.retryAfterFailure();
    }

    public final void setConnectionToCancel(@Nullable RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    @NotNull
    public AsyncTimeout timeout() {
        return this.timeout;
    }

    public final void timeoutEarlyExit() {
        if (!(!this.timeoutEarlyExit)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.timeoutEarlyExit = true;
        this.timeout.exit();
    }

    @NotNull
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
