package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SecureCacheResponse;
import java.net.URI;
import java.net.URLConnection;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class JavaApiConverter {

    public static class 1 extends SecureCacheResponse {
        final /* synthetic */ ResponseBody val$body;
        final /* synthetic */ Handshake val$handshake;
        final /* synthetic */ Headers val$headers;
        final /* synthetic */ Response val$response;

        public 1(Handshake handshake, Headers headers, Response response, ResponseBody responseBody) {
            this.val$handshake = handshake;
            this.val$headers = headers;
            this.val$response = response;
            this.val$body = responseBody;
        }

        public InputStream getBody() throws IOException {
            ResponseBody responseBody = this.val$body;
            if (responseBody == null) {
                return null;
            }
            return responseBody.byteStream();
        }

        public String getCipherSuite() {
            Handshake handshake = this.val$handshake;
            if (handshake != null) {
                return handshake.cipherSuite();
            }
            return null;
        }

        public Map getHeaders() throws IOException {
            return OkHeaders.toMultimap(this.val$headers, StatusLine.get(this.val$response).toString());
        }

        public List getLocalCertificateChain() {
            Handshake handshake = this.val$handshake;
            if (handshake == null) {
                return null;
            }
            List localCertificates = handshake.localCertificates();
            if (localCertificates.size() > 0) {
                return localCertificates;
            }
            return null;
        }

        public Principal getLocalPrincipal() {
            Handshake handshake = this.val$handshake;
            if (handshake == null) {
                return null;
            }
            return handshake.localPrincipal();
        }

        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            Handshake handshake = this.val$handshake;
            if (handshake == null) {
                return null;
            }
            return handshake.peerPrincipal();
        }

        public List getServerCertificateChain() throws SSLPeerUnverifiedException {
            Handshake handshake = this.val$handshake;
            if (handshake == null) {
                return null;
            }
            List peerCertificates = handshake.peerCertificates();
            if (peerCertificates.size() > 0) {
                return peerCertificates;
            }
            return null;
        }
    }

    public static class 2 extends CacheResponse {
        final /* synthetic */ ResponseBody val$body;
        final /* synthetic */ Headers val$headers;
        final /* synthetic */ Response val$response;

        public 2(Headers headers, Response response, ResponseBody responseBody) {
            this.val$headers = headers;
            this.val$response = response;
            this.val$body = responseBody;
        }

        public InputStream getBody() throws IOException {
            ResponseBody responseBody = this.val$body;
            if (responseBody == null) {
                return null;
            }
            return responseBody.byteStream();
        }

        public Map getHeaders() throws IOException {
            return OkHeaders.toMultimap(this.val$headers, StatusLine.get(this.val$response).toString());
        }
    }

    public static class 3 extends ResponseBody {
        final /* synthetic */ Headers val$okHeaders;
        final /* synthetic */ BufferedSource val$source;

        public 3(Headers headers, BufferedSource bufferedSource) {
            this.val$okHeaders = headers;
            this.val$source = bufferedSource;
        }

        public long contentLength() {
            return OkHeaders.contentLength(this.val$okHeaders);
        }

        public MediaType contentType() {
            String str = this.val$okHeaders.get("Content-Type");
            if (str == null) {
                return null;
            }
            return MediaType.parse(str);
        }

        public BufferedSource source() {
            return this.val$source;
        }
    }

    public static final class CacheHttpURLConnection extends HttpURLConnection {
        private final Request request;
        private final Response response;

        public CacheHttpURLConnection(Response response) {
            super(response.request().url());
            Request request = response.request();
            this.request = request;
            this.response = response;
            ((HttpURLConnection) this).connected = true;
            ((HttpURLConnection) this).doOutput = response.body() == null;
            ((HttpURLConnection) this).method = request.method();
        }

        public static /* synthetic */ Response access$300(CacheHttpURLConnection cacheHttpURLConnection) {
            return cacheHttpURLConnection.response;
        }

        public void addRequestProperty(String str, String str2) {
            throw JavaApiConverter.access$000();
        }

        public void connect() throws IOException {
            throw JavaApiConverter.access$000();
        }

        public void disconnect() {
            throw JavaApiConverter.access$000();
        }

        public boolean getAllowUserInteraction() {
            return false;
        }

        public int getConnectTimeout() {
            return 0;
        }

        public Object getContent() throws IOException {
            throw JavaApiConverter.access$200();
        }

        public boolean getDefaultUseCaches() {
            return super.getDefaultUseCaches();
        }

        public boolean getDoInput() {
            return true;
        }

        public boolean getDoOutput() {
            return this.request.body() != null;
        }

        public InputStream getErrorStream() {
            return null;
        }

        public String getHeaderField(int i) {
            if (i >= 0) {
                return i == 0 ? StatusLine.get(this.response).toString() : this.response.headers().value(i - 1);
            }
            throw new IllegalArgumentException("Invalid header index: " + i);
        }

        public String getHeaderFieldKey(int i) {
            if (i >= 0) {
                if (i == 0) {
                    return null;
                }
                return this.response.headers().name(i - 1);
            }
            throw new IllegalArgumentException("Invalid header index: " + i);
        }

        public Map getHeaderFields() {
            return OkHeaders.toMultimap(this.response.headers(), StatusLine.get(this.response).toString());
        }

        public long getIfModifiedSince() {
            return 0L;
        }

        public InputStream getInputStream() throws IOException {
            throw JavaApiConverter.access$200();
        }

        public boolean getInstanceFollowRedirects() {
            return super.getInstanceFollowRedirects();
        }

        public OutputStream getOutputStream() throws IOException {
            throw JavaApiConverter.access$000();
        }

        public int getReadTimeout() {
            return 0;
        }

        public String getRequestMethod() {
            return this.request.method();
        }

        public Map getRequestProperties() {
            throw JavaApiConverter.access$100();
        }

        public String getRequestProperty(String str) {
            return this.request.header(str);
        }

        public int getResponseCode() throws IOException {
            return this.response.code();
        }

        public String getResponseMessage() throws IOException {
            return this.response.message();
        }

        public boolean getUseCaches() {
            return super.getUseCaches();
        }

        public void setAllowUserInteraction(boolean z) {
            throw JavaApiConverter.access$000();
        }

        public void setChunkedStreamingMode(int i) {
            throw JavaApiConverter.access$000();
        }

        public void setConnectTimeout(int i) {
            throw JavaApiConverter.access$000();
        }

        public void setDefaultUseCaches(boolean z) {
            super.setDefaultUseCaches(z);
        }

        public void setDoInput(boolean z) {
            throw JavaApiConverter.access$000();
        }

        public void setDoOutput(boolean z) {
            throw JavaApiConverter.access$000();
        }

        public void setFixedLengthStreamingMode(int i) {
            throw JavaApiConverter.access$000();
        }

        public void setIfModifiedSince(long j) {
            throw JavaApiConverter.access$000();
        }

        public void setInstanceFollowRedirects(boolean z) {
            throw JavaApiConverter.access$000();
        }

        public void setReadTimeout(int i) {
            throw JavaApiConverter.access$000();
        }

        public void setRequestMethod(String str) throws ProtocolException {
            throw JavaApiConverter.access$000();
        }

        public void setRequestProperty(String str, String str2) {
            throw JavaApiConverter.access$000();
        }

        public void setUseCaches(boolean z) {
            throw JavaApiConverter.access$000();
        }

        public boolean usingProxy() {
            return false;
        }

        public Object getContent(Class[] clsArr) throws IOException {
            throw JavaApiConverter.access$200();
        }

        public String getHeaderField(String str) {
            return str == null ? StatusLine.get(this.response).toString() : this.response.headers().get(str);
        }

        public void setFixedLengthStreamingMode(long j) {
            throw JavaApiConverter.access$000();
        }
    }

    public static final class CacheHttpsURLConnection extends DelegatingHttpsURLConnection {
        private final CacheHttpURLConnection delegate;

        public CacheHttpsURLConnection(CacheHttpURLConnection cacheHttpURLConnection) {
            super(cacheHttpURLConnection);
            this.delegate = cacheHttpURLConnection;
        }

        public long getContentLengthLong() {
            return c.a(this.delegate);
        }

        public long getHeaderFieldLong(String str, long j) {
            return d.a(this.delegate, str, j);
        }

        public HostnameVerifier getHostnameVerifier() {
            throw JavaApiConverter.access$400();
        }

        public SSLSocketFactory getSSLSocketFactory() {
            throw JavaApiConverter.access$400();
        }

        public Handshake handshake() {
            return CacheHttpURLConnection.access$300(this.delegate).handshake();
        }

        public void setFixedLengthStreamingMode(long j) {
            this.delegate.setFixedLengthStreamingMode(j);
        }

        public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            throw JavaApiConverter.access$000();
        }

        public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
            throw JavaApiConverter.access$000();
        }
    }

    private JavaApiConverter() {
    }

    public static /* synthetic */ RuntimeException access$000() {
        return throwRequestModificationException();
    }

    public static /* synthetic */ RuntimeException access$100() {
        return throwRequestHeaderAccessException();
    }

    public static /* synthetic */ RuntimeException access$200() {
        return throwResponseBodyAccessException();
    }

    public static /* synthetic */ RuntimeException access$400() {
        return throwRequestSslAccessException();
    }

    public static CacheResponse createJavaCacheResponse(Response response) {
        Headers headers = response.headers();
        ResponseBody body = response.body();
        return response.request().isHttps() ? new 1(response.handshake(), headers, response, body) : new 2(headers, response, body);
    }

    public static HttpURLConnection createJavaUrlConnection(Response response) {
        return response.request().isHttps() ? new CacheHttpsURLConnection(new CacheHttpURLConnection(response)) : new CacheHttpURLConnection(response);
    }

    private static ResponseBody createOkBody(Headers headers, InputStream inputStream) {
        return new 3(headers, Okio.buffer(Okio.source(inputStream)));
    }

    public static Request createOkRequest(URI uri, String str, Map map) {
        Request.Builder method = new Request.Builder().url(uri.toString()).method(str, null);
        if (map != null) {
            method.headers(extractOkHeaders(map));
        }
        return method.build();
    }

    public static Response createOkResponse(Request request, CacheResponse cacheResponse) throws IOException {
        List emptyList;
        Response.Builder builder = new Response.Builder();
        builder.request(request);
        StatusLine parse = StatusLine.parse(extractStatusLine(cacheResponse));
        builder.protocol(parse.protocol);
        builder.code(parse.code);
        builder.message(parse.message);
        Headers extractOkHeaders = extractOkHeaders(cacheResponse);
        builder.headers(extractOkHeaders);
        builder.body(createOkBody(extractOkHeaders, cacheResponse.getBody()));
        if (cacheResponse instanceof SecureCacheResponse) {
            SecureCacheResponse secureCacheResponse = (SecureCacheResponse) cacheResponse;
            try {
                emptyList = secureCacheResponse.getServerCertificateChain();
            } catch (SSLPeerUnverifiedException unused) {
                emptyList = Collections.emptyList();
            }
            List localCertificateChain = secureCacheResponse.getLocalCertificateChain();
            if (localCertificateChain == null) {
                localCertificateChain = Collections.emptyList();
            }
            builder.handshake(Handshake.get(secureCacheResponse.getCipherSuite(), emptyList, localCertificateChain));
        }
        return builder.build();
    }

    public static Map extractJavaHeaders(Request request) {
        return OkHeaders.toMultimap(request.headers(), null);
    }

    private static Headers extractOkHeaders(CacheResponse cacheResponse) throws IOException {
        return extractOkHeaders(cacheResponse.getHeaders());
    }

    private static Headers extractOkResponseHeaders(HttpURLConnection httpURLConnection) {
        return extractOkHeaders(httpURLConnection.getHeaderFields());
    }

    private static String extractStatusLine(CacheResponse cacheResponse) throws IOException {
        return extractStatusLine(cacheResponse.getHeaders());
    }

    private static List nullSafeImmutableList(Object[] objArr) {
        return objArr == null ? Collections.emptyList() : Util.immutableList(objArr);
    }

    private static RuntimeException throwRequestHeaderAccessException() {
        throw new UnsupportedOperationException("ResponseCache cannot access request headers");
    }

    private static RuntimeException throwRequestModificationException() {
        throw new UnsupportedOperationException("ResponseCache cannot modify the request.");
    }

    private static RuntimeException throwRequestSslAccessException() {
        throw new UnsupportedOperationException("ResponseCache cannot access SSL internals");
    }

    private static RuntimeException throwResponseBodyAccessException() {
        throw new UnsupportedOperationException("ResponseCache cannot access the response body.");
    }

    public static Response createOkResponse(URI uri, URLConnection uRLConnection) throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpURLConnection) uRLConnection;
        Response.Builder builder = new Response.Builder();
        Certificate[] certificateArr = null;
        builder.request(createOkRequest(uri, httpsURLConnection.getRequestMethod(), null));
        StatusLine parse = StatusLine.parse(extractStatusLine((HttpURLConnection) httpsURLConnection));
        builder.protocol(parse.protocol);
        builder.code(parse.code);
        builder.message(parse.message);
        Headers extractOkResponseHeaders = extractOkResponseHeaders(httpsURLConnection);
        builder.headers(extractOkResponseHeaders);
        builder.body(createOkBody(extractOkResponseHeaders, uRLConnection.getInputStream()));
        if (httpsURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
            try {
                certificateArr = httpsURLConnection2.getServerCertificates();
            } catch (SSLPeerUnverifiedException unused) {
            }
            builder.handshake(Handshake.get(httpsURLConnection2.getCipherSuite(), nullSafeImmutableList(certificateArr), nullSafeImmutableList(httpsURLConnection2.getLocalCertificates())));
        }
        return builder.build();
    }

    public static Headers extractOkHeaders(Map map) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    builder.add(str, (String) it.next());
                }
            }
        }
        return builder.build();
    }

    private static String extractStatusLine(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getHeaderField((String) null);
    }

    public static String extractStatusLine(Map map) {
        List list = (List) map.get((Object) null);
        if (list == null || list.size() == 0) {
            return null;
        }
        return (String) list.get(0);
    }
}
