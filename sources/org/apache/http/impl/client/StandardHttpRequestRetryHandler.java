package org.apache.http.impl.client;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class StandardHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {
    private final Map idempotentMethods;

    public StandardHttpRequestRetryHandler() {
        this(3, false);
    }

    public boolean handleAsIdempotent(HttpRequest httpRequest) {
        Boolean bool = (Boolean) this.idempotentMethods.get(httpRequest.getRequestLine().getMethod().toUpperCase(Locale.ROOT));
        return bool != null && bool.booleanValue();
    }

    public StandardHttpRequestRetryHandler(int i, boolean z) {
        super(i, z);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.idempotentMethods = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("GET", bool);
        concurrentHashMap.put("HEAD", bool);
        concurrentHashMap.put("PUT", bool);
        concurrentHashMap.put("DELETE", bool);
        concurrentHashMap.put("OPTIONS", bool);
        concurrentHashMap.put("TRACE", bool);
    }
}
