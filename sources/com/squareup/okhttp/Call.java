package com.squareup.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.util.logging.Level;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    public class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        public ApplicationInterceptorChain(int i, Request request, boolean z) {
            this.index = i;
            this.request = request;
            this.forWebSocket = z;
        }

        public Connection connection() {
            return null;
        }

        public Response proceed(Request request) throws IOException {
            if (this.index >= Call.access$300(Call.this).interceptors().size()) {
                return Call.this.getResponse(request, this.forWebSocket);
            }
            ApplicationInterceptorChain applicationInterceptorChain = Call.this.new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket);
            Interceptor interceptor = (Interceptor) Call.access$300(Call.this).interceptors().get(this.index);
            Response intercept = interceptor.intercept(applicationInterceptorChain);
            if (intercept != null) {
                return intercept;
            }
            throw new NullPointerException("application interceptor " + interceptor + " returned null");
        }

        public Request request() {
            return this.request;
        }
    }

    public final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }

        public void cancel() {
            Call.this.cancel();
        }

        public void execute() {
            IOException e;
            boolean z;
            Response access$100;
            try {
                try {
                    access$100 = Call.access$100(Call.this, this.forWebSocket);
                    z = true;
                } catch (Throwable th) {
                    Call.access$300(Call.this).getDispatcher().finished(this);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                z = false;
            }
            try {
                if (Call.this.canceled) {
                    this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                } else {
                    this.responseCallback.onResponse(access$100);
                }
            } catch (IOException e3) {
                e = e3;
                if (z) {
                    Internal.logger.log(Level.INFO, "Callback failure for " + Call.access$200(Call.this), e);
                } else {
                    Call call = Call.this;
                    HttpEngine httpEngine = call.engine;
                    this.responseCallback.onFailure(httpEngine == null ? call.originalRequest : httpEngine.getRequest(), e);
                }
                Call.access$300(Call.this).getDispatcher().finished(this);
            }
            Call.access$300(Call.this).getDispatcher().finished(this);
        }

        public Call get() {
            return Call.this;
        }

        public String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        public Request request() {
            return Call.this.originalRequest;
        }

        public Object tag() {
            return Call.this.originalRequest.tag();
        }

        public /* synthetic */ AsyncCall(Call call, Callback callback, boolean z, 1 r4) {
            this(callback, z);
        }
    }

    public Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    public static /* synthetic */ Response access$100(Call call, boolean z) throws IOException {
        return call.getResponseWithInterceptorChain(z);
    }

    public static /* synthetic */ String access$200(Call call) {
        return call.toLoggableString();
    }

    public static /* synthetic */ OkHttpClient access$300(Call call) {
        return call.client;
    }

    private Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    private String toLoggableString() {
        return (this.canceled ? "canceled call" : "call") + " to " + this.originalRequest.httpUrl().resolve("/...");
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.cancel();
        }
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.squareup.okhttp.Response getResponse(com.squareup.okhttp.Request r13, boolean r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Call.getResponse(com.squareup.okhttp.Request, boolean):com.squareup.okhttp.Response");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Object tag() {
        return this.originalRequest.tag();
    }

    public void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new AsyncCall(this, callback, z, null));
    }
}
