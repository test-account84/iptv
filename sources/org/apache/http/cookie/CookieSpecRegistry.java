package org.apache.http.cookie;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.Lookup;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CookieSpecRegistry implements Lookup {
    private final ConcurrentHashMap registeredSpecs = new ConcurrentHashMap();

    public class 1 implements CookieSpecProvider {
        final /* synthetic */ String val$name;

        public 1(String str) {
            this.val$name = str;
        }

        public CookieSpec create(HttpContext httpContext) {
            return CookieSpecRegistry.this.getCookieSpec(this.val$name, ((HttpRequest) httpContext.getAttribute("http.request")).getParams());
        }
    }

    public CookieSpec getCookieSpec(String str) throws IllegalStateException {
        return getCookieSpec(str, null);
    }

    public List getSpecNames() {
        return new ArrayList(this.registeredSpecs.keySet());
    }

    public void register(String str, CookieSpecFactory cookieSpecFactory) {
        Args.notNull(str, "Name");
        Args.notNull(cookieSpecFactory, "Cookie spec factory");
        this.registeredSpecs.put(str.toLowerCase(Locale.ENGLISH), cookieSpecFactory);
    }

    public void setItems(Map map) {
        if (map == null) {
            return;
        }
        this.registeredSpecs.clear();
        this.registeredSpecs.putAll(map);
    }

    public void unregister(String str) {
        Args.notNull(str, "Id");
        this.registeredSpecs.remove(str.toLowerCase(Locale.ENGLISH));
    }

    public CookieSpec getCookieSpec(String str, HttpParams httpParams) throws IllegalStateException {
        Args.notNull(str, "Name");
        CookieSpecFactory cookieSpecFactory = (CookieSpecFactory) this.registeredSpecs.get(str.toLowerCase(Locale.ENGLISH));
        if (cookieSpecFactory != null) {
            return cookieSpecFactory.newInstance(httpParams);
        }
        throw new IllegalStateException("Unsupported cookie spec: " + str);
    }

    public CookieSpecProvider lookup(String str) {
        return new 1(str);
    }
}
