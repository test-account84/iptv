package org.apache.http.protocol;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BasicHttpContext implements HttpContext {
    private final Map map;
    private final HttpContext parentContext;

    public BasicHttpContext() {
        this(null);
    }

    public void clear() {
        this.map.clear();
    }

    public Object getAttribute(String str) {
        HttpContext httpContext;
        Args.notNull(str, "Id");
        Object obj = this.map.get(str);
        return (obj != null || (httpContext = this.parentContext) == null) ? obj : httpContext.getAttribute(str);
    }

    public Object removeAttribute(String str) {
        Args.notNull(str, "Id");
        return this.map.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        Args.notNull(str, "Id");
        if (obj != null) {
            this.map.put(str, obj);
        } else {
            this.map.remove(str);
        }
    }

    public String toString() {
        return this.map.toString();
    }

    public BasicHttpContext(HttpContext httpContext) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext;
    }
}
