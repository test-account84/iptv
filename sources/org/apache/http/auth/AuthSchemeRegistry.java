package org.apache.http.auth;

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
public final class AuthSchemeRegistry implements Lookup {
    private final ConcurrentHashMap registeredSchemes = new ConcurrentHashMap();

    public class 1 implements AuthSchemeProvider {
        final /* synthetic */ String val$name;

        public 1(String str) {
            this.val$name = str;
        }

        public AuthScheme create(HttpContext httpContext) {
            return AuthSchemeRegistry.this.getAuthScheme(this.val$name, ((HttpRequest) httpContext.getAttribute("http.request")).getParams());
        }
    }

    public AuthScheme getAuthScheme(String str, HttpParams httpParams) throws IllegalStateException {
        Args.notNull(str, "Name");
        AuthSchemeFactory authSchemeFactory = (AuthSchemeFactory) this.registeredSchemes.get(str.toLowerCase(Locale.ENGLISH));
        if (authSchemeFactory != null) {
            return authSchemeFactory.newInstance(httpParams);
        }
        throw new IllegalStateException("Unsupported authentication scheme: " + str);
    }

    public List getSchemeNames() {
        return new ArrayList(this.registeredSchemes.keySet());
    }

    public void register(String str, AuthSchemeFactory authSchemeFactory) {
        Args.notNull(str, "Name");
        Args.notNull(authSchemeFactory, "Authentication scheme factory");
        this.registeredSchemes.put(str.toLowerCase(Locale.ENGLISH), authSchemeFactory);
    }

    public void setItems(Map map) {
        if (map == null) {
            return;
        }
        this.registeredSchemes.clear();
        this.registeredSchemes.putAll(map);
    }

    public void unregister(String str) {
        Args.notNull(str, "Name");
        this.registeredSchemes.remove(str.toLowerCase(Locale.ENGLISH));
    }

    public AuthSchemeProvider lookup(String str) {
        return new 1(str);
    }
}
