package org.apache.http.impl.client;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.message.BasicHeaderIterator;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HttpContext;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultClientConnectionReuseStrategy extends DefaultConnectionReuseStrategy {
    public static final DefaultClientConnectionReuseStrategy INSTANCE = new DefaultClientConnectionReuseStrategy();

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        HttpRequest httpRequest = (HttpRequest) httpContext.getAttribute("http.request");
        if (httpRequest != null) {
            Header[] headers = httpRequest.getHeaders("Connection");
            if (headers.length != 0) {
                BasicTokenIterator basicTokenIterator = new BasicTokenIterator(new BasicHeaderIterator(headers, null));
                while (basicTokenIterator.hasNext()) {
                    if ("Close".equalsIgnoreCase(basicTokenIterator.nextToken())) {
                        return false;
                    }
                }
            }
        }
        return super.keepAlive(httpResponse, httpContext);
    }
}
