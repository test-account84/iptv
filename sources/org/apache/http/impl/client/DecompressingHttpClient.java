package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DecompressingHttpClient implements HttpClient {
    private final HttpRequestInterceptor acceptEncodingInterceptor;
    private final HttpClient backend;
    private final HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient() {
        this(new DefaultHttpClient());
    }

    public Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, responseHandler, null);
    }

    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpClient getHttpClient() {
        return this.backend;
    }

    public HttpHost getHttpHost(HttpUriRequest httpUriRequest) {
        return URIUtils.extractHost(httpUriRequest.getURI());
    }

    public HttpParams getParams() {
        return this.backend.getParams();
    }

    public DecompressingHttpClient(HttpClient httpClient) {
        this(httpClient, new RequestAcceptEncoding(), new ResponseContentEncoding());
    }

    public Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            return responseHandler.handleResponse(execute);
        } finally {
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        }
    }

    public DecompressingHttpClient(HttpClient httpClient, HttpRequestInterceptor httpRequestInterceptor, HttpResponseInterceptor httpResponseInterceptor) {
        this.backend = httpClient;
        this.acceptEncodingInterceptor = httpRequestInterceptor;
        this.contentEncodingInterceptor = httpResponseInterceptor;
    }

    public Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler);
    }

    public Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        if (httpContext == null) {
            try {
                httpContext = new BasicHttpContext();
            } catch (HttpException e) {
                throw new ClientProtocolException((Throwable) e);
            }
        }
        HttpRequest entityEnclosingRequestWrapper = httpRequest instanceof HttpEntityEnclosingRequest ? new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest) : new RequestWrapper(httpRequest);
        this.acceptEncodingInterceptor.process(entityEnclosingRequestWrapper, httpContext);
        HttpResponse execute = this.backend.execute(httpHost, entityEnclosingRequestWrapper, httpContext);
        try {
            try {
                try {
                    this.contentEncodingInterceptor.process(execute, httpContext);
                    if (Boolean.TRUE.equals(httpContext.getAttribute("http.client.response.uncompressed"))) {
                        execute.removeHeaders("Content-Length");
                        execute.removeHeaders("Content-Encoding");
                        execute.removeHeaders("Content-MD5");
                    }
                    return execute;
                } catch (HttpException e2) {
                    EntityUtils.consume(execute.getEntity());
                    throw e2;
                }
            } catch (RuntimeException e3) {
                EntityUtils.consume(execute.getEntity());
                throw e3;
            }
        } catch (IOException e4) {
            EntityUtils.consume(execute.getEntity());
            throw e4;
        }
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, httpContext);
    }
}
