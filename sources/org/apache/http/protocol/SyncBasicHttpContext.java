package org.apache.http.protocol;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext() {
    }

    public synchronized void clear() {
        super.clear();
    }

    public synchronized Object getAttribute(String str) {
        return super.getAttribute(str);
    }

    public synchronized Object removeAttribute(String str) {
        return super.removeAttribute(str);
    }

    public synchronized void setAttribute(String str, Object obj) {
        super.setAttribute(str, obj);
    }

    public SyncBasicHttpContext(HttpContext httpContext) {
        super(httpContext);
    }
}
