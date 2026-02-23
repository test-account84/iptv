package org.apache.http.client.protocol;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RequestDefaultHeaders implements HttpRequestInterceptor {
    private final Collection defaultHeaders;

    public RequestDefaultHeaders() {
        this(null);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            return;
        }
        Collection collection = (Collection) httpRequest.getParams().getParameter("http.default-headers");
        if (collection == null) {
            collection = this.defaultHeaders;
        }
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                httpRequest.addHeader((Header) it.next());
            }
        }
    }

    public RequestDefaultHeaders(Collection collection) {
        this.defaultHeaders = collection;
    }
}
