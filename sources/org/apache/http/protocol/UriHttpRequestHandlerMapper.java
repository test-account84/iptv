package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
    private final UriPatternMatcher matcher;

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher());
    }

    public String getRequestPath(HttpRequest httpRequest) {
        String uri = httpRequest.getRequestLine().getUri();
        int indexOf = uri.indexOf(63);
        return (indexOf == -1 && (indexOf = uri.indexOf(35)) == -1) ? uri : uri.substring(0, indexOf);
    }

    public HttpRequestHandler lookup(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return (HttpRequestHandler) this.matcher.lookup(getRequestPath(httpRequest));
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notNull(str, "Pattern");
        Args.notNull(httpRequestHandler, "Handler");
        this.matcher.register(str, httpRequestHandler);
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }

    public UriHttpRequestHandlerMapper(UriPatternMatcher uriPatternMatcher) {
        this.matcher = (UriPatternMatcher) Args.notNull(uriPatternMatcher, "Pattern matcher");
    }
}
