package org.apache.http.impl.client;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.protocol.HttpContext;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class HttpRequestTaskCallable implements Callable {
    private final FutureCallback callback;
    private final HttpContext context;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;
    private final HttpUriRequest request;
    private final ResponseHandler responseHandler;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);
    private final long scheduled = System.currentTimeMillis();
    private long started = -1;
    private long ended = -1;

    public HttpRequestTaskCallable(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler responseHandler, FutureCallback futureCallback, FutureRequestExecutionMetrics futureRequestExecutionMetrics) {
        this.httpclient = httpClient;
        this.responseHandler = responseHandler;
        this.request = httpUriRequest;
        this.context = httpContext;
        this.callback = futureCallback;
        this.metrics = futureRequestExecutionMetrics;
    }

    public Object call() throws Exception {
        if (this.cancelled.get()) {
            throw new IllegalStateException("call has been cancelled for request " + this.request.getURI());
        }
        try {
            this.metrics.getActiveConnections().incrementAndGet();
            this.started = System.currentTimeMillis();
            try {
                this.metrics.getScheduledConnections().decrementAndGet();
                Object execute = this.httpclient.execute(this.request, this.responseHandler, this.context);
                this.ended = System.currentTimeMillis();
                this.metrics.getSuccessfulConnections().increment(this.started);
                FutureCallback futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.completed(execute);
                }
                return execute;
            } catch (Exception e) {
                this.metrics.getFailedConnections().increment(this.started);
                this.ended = System.currentTimeMillis();
                FutureCallback futureCallback2 = this.callback;
                if (futureCallback2 != null) {
                    futureCallback2.failed(e);
                }
                throw e;
            }
        } finally {
            this.metrics.getRequests().increment(this.started);
            this.metrics.getTasks().increment(this.started);
            this.metrics.getActiveConnections().decrementAndGet();
        }
    }

    public void cancel() {
        this.cancelled.set(true);
        FutureCallback futureCallback = this.callback;
        if (futureCallback != null) {
            futureCallback.cancelled();
        }
    }

    public long getEnded() {
        return this.ended;
    }

    public long getScheduled() {
        return this.scheduled;
    }

    public long getStarted() {
        return this.started;
    }
}
