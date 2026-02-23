package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpRequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private final String method;
    private final HttpRequest original;
    private RequestLine requestLine;
    private final HttpHost target;
    private URI uri;
    private ProtocolVersion version;

    public static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper implements HttpEntityEnclosingRequest {
        private HttpEntity entity;

        public HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest, HttpHost httpHost) {
            super(httpEntityEnclosingRequest, httpHost, null);
            this.entity = httpEntityEnclosingRequest.getEntity();
        }

        public boolean expectContinue() {
            Header firstHeader = getFirstHeader("Expect");
            return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
        }

        public HttpEntity getEntity() {
            return this.entity;
        }

        public void setEntity(HttpEntity httpEntity) {
            this.entity = httpEntity;
        }
    }

    private HttpRequestWrapper(HttpRequest httpRequest, HttpHost httpHost) {
        HttpRequest httpRequest2 = (HttpRequest) Args.notNull(httpRequest, "HTTP request");
        this.original = httpRequest2;
        this.target = httpHost;
        this.version = httpRequest2.getRequestLine().getProtocolVersion();
        this.method = httpRequest2.getRequestLine().getMethod();
        this.uri = httpRequest instanceof HttpUriRequest ? ((HttpUriRequest) httpRequest).getURI() : null;
        setHeaders(httpRequest.getAllHeaders());
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest) {
        return wrap(httpRequest, null);
    }

    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String getMethod() {
        return this.method;
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    @Deprecated
    public HttpParams getParams() {
        if (this.params == null) {
            this.params = this.original.getParams().copy();
        }
        return this.params;
    }

    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : this.original.getProtocolVersion();
    }

    public RequestLine getRequestLine() {
        if (this.requestLine == null) {
            URI uri = this.uri;
            String aSCIIString = uri != null ? uri.toASCIIString() : this.original.getRequestLine().getUri();
            if (aSCIIString == null || aSCIIString.isEmpty()) {
                aSCIIString = "/";
            }
            this.requestLine = new BasicRequestLine(this.method, aSCIIString, getProtocolVersion());
        }
        return this.requestLine;
    }

    public HttpHost getTarget() {
        return this.target;
    }

    public URI getURI() {
        return this.uri;
    }

    public boolean isAborted() {
        return false;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
        this.requestLine = null;
    }

    public void setURI(URI uri) {
        this.uri = uri;
        this.requestLine = null;
    }

    public String toString() {
        return getRequestLine() + " " + this.headergroup;
    }

    public /* synthetic */ HttpRequestWrapper(HttpRequest httpRequest, HttpHost httpHost, 1 r3) {
        this(httpRequest, httpHost);
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest, HttpHost httpHost) {
        Args.notNull(httpRequest, "HTTP request");
        return httpRequest instanceof HttpEntityEnclosingRequest ? new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest, httpHost) : new HttpRequestWrapper(httpRequest, httpHost);
    }
}
