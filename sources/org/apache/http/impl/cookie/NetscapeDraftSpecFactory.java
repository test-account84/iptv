package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NetscapeDraftSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final CookieSpec cookieSpec;

    public NetscapeDraftSpecFactory() {
        this(null);
    }

    public CookieSpec create(HttpContext httpContext) {
        return this.cookieSpec;
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams == null) {
            return new NetscapeDraftSpec();
        }
        Collection collection = (Collection) httpParams.getParameter("http.protocol.cookie-datepatterns");
        return new NetscapeDraftSpec(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null);
    }

    public NetscapeDraftSpecFactory(String[] strArr) {
        this.cookieSpec = new NetscapeDraftSpec(strArr);
    }
}
