package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AutoRetryHttpClient implements HttpClient {
    private final HttpClient backend;
    private final Log log;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public AutoRetryHttpClient() {
        this(new DefaultHttpClient(), new DefaultServiceUnavailableRetryStrategy());
    }

    public Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) throws IOException {
        return execute(httpHost, httpRequest, responseHandler, null);
    }

    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.backend.getParams();
    }

    public AutoRetryHttpClient(HttpClient httpClient) {
        this(httpClient, new DefaultServiceUnavailableRetryStrategy());
    }

    public Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpHost, httpRequest, httpContext));
    }

    public AutoRetryHttpClient(HttpClient httpClient, ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(httpClient, "HttpClient");
        Args.notNull(serviceUnavailableRetryStrategy, "ServiceUnavailableRetryStrategy");
        this.backend = httpClient;
        this.retryStrategy = serviceUnavailableRetryStrategy;
    }

    public Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler) throws IOException {
        return execute(httpUriRequest, responseHandler, (HttpContext) null);
    }

    public AutoRetryHttpClient(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this(new DefaultHttpClient(), serviceUnavailableRetryStrategy);
    }

    public Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpUriRequest, httpContext));
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        int i = 1;
        while (true) {
            HttpResponse execute = this.backend.execute(httpHost, httpRequest, httpContext);
            try {
                if (!this.retryStrategy.retryRequest(execute, i, httpContext)) {
                    return execute;
                }
                EntityUtils.consume(execute.getEntity());
                long retryInterval = this.retryStrategy.getRetryInterval();
                try {
                    this.log.trace("Wait for " + retryInterval);
                    Thread.sleep(retryInterval);
                    i++;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            } catch (RuntimeException e) {
                try {
                    EntityUtils.consume(execute.getEntity());
                } catch (IOException e2) {
                    this.log.warn("I/O error consuming response content", e2);
                }
                throw e;
            }
        }
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute(httpUriRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        URI uri = httpUriRequest.getURI();
        return execute(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), httpUriRequest, httpContext);
    }
}
