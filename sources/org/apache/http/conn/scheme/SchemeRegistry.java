package org.apache.http.conn.scheme;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class SchemeRegistry {
    private final ConcurrentHashMap registeredSchemes = new ConcurrentHashMap();

    public final Scheme get(String str) {
        Args.notNull(str, "Scheme name");
        return (Scheme) this.registeredSchemes.get(str);
    }

    public final Scheme getScheme(String str) {
        Scheme scheme = get(str);
        if (scheme != null) {
            return scheme;
        }
        throw new IllegalStateException("Scheme '" + str + "' not registered.");
    }

    public final List getSchemeNames() {
        return new ArrayList(this.registeredSchemes.keySet());
    }

    public final Scheme register(Scheme scheme) {
        Args.notNull(scheme, "Scheme");
        return (Scheme) this.registeredSchemes.put(scheme.getName(), scheme);
    }

    public void setItems(Map map) {
        if (map == null) {
            return;
        }
        this.registeredSchemes.clear();
        this.registeredSchemes.putAll(map);
    }

    public final Scheme unregister(String str) {
        Args.notNull(str, "Scheme name");
        return (Scheme) this.registeredSchemes.remove(str);
    }

    public final Scheme getScheme(HttpHost httpHost) {
        Args.notNull(httpHost, "Host");
        return getScheme(httpHost.getSchemeName());
    }
}
