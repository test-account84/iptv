package org.apache.http.impl.execchain;

import java.io.IOException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.params.HttpParams;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class HttpResponseProxy implements CloseableHttpResponse {
    private final ConnectionHolder connHolder;
    private final HttpResponse original;

    public HttpResponseProxy(HttpResponse httpResponse, ConnectionHolder connectionHolder) {
        this.original = httpResponse;
        this.connHolder = connectionHolder;
        ResponseEntityProxy.enchance(httpResponse, connectionHolder);
    }

    public void addHeader(String str, String str2) {
        this.original.addHeader(str, str2);
    }

    public void close() throws IOException {
        ConnectionHolder connectionHolder = this.connHolder;
        if (connectionHolder != null) {
            connectionHolder.close();
        }
    }

    public boolean containsHeader(String str) {
        return this.original.containsHeader(str);
    }

    public Header[] getAllHeaders() {
        return this.original.getAllHeaders();
    }

    public HttpEntity getEntity() {
        return this.original.getEntity();
    }

    public Header getFirstHeader(String str) {
        return this.original.getFirstHeader(str);
    }

    public Header[] getHeaders(String str) {
        return this.original.getHeaders(str);
    }

    public Header getLastHeader(String str) {
        return this.original.getLastHeader(str);
    }

    public Locale getLocale() {
        return this.original.getLocale();
    }

    @Deprecated
    public HttpParams getParams() {
        return this.original.getParams();
    }

    public ProtocolVersion getProtocolVersion() {
        return this.original.getProtocolVersion();
    }

    public StatusLine getStatusLine() {
        return this.original.getStatusLine();
    }

    public HeaderIterator headerIterator() {
        return this.original.headerIterator();
    }

    public void removeHeader(Header header) {
        this.original.removeHeader(header);
    }

    public void removeHeaders(String str) {
        this.original.removeHeaders(str);
    }

    public void setEntity(HttpEntity httpEntity) {
        this.original.setEntity(httpEntity);
    }

    public void setHeader(String str, String str2) {
        this.original.setHeader(str, str2);
    }

    public void setHeaders(Header[] headerArr) {
        this.original.setHeaders(headerArr);
    }

    public void setLocale(Locale locale) {
        this.original.setLocale(locale);
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.original.setParams(httpParams);
    }

    public void setReasonPhrase(String str) throws IllegalStateException {
        this.original.setReasonPhrase(str);
    }

    public void setStatusCode(int i) throws IllegalStateException {
        this.original.setStatusCode(i);
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i) {
        this.original.setStatusLine(protocolVersion, i);
    }

    public String toString() {
        return "HttpResponseProxy{" + this.original + '}';
    }

    public void addHeader(Header header) {
        this.original.addHeader(header);
    }

    public HeaderIterator headerIterator(String str) {
        return this.original.headerIterator(str);
    }

    public void setHeader(Header header) {
        this.original.setHeader(header);
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.original.setStatusLine(protocolVersion, i, str);
    }

    public void setStatusLine(StatusLine statusLine) {
        this.original.setStatusLine(statusLine);
    }
}
