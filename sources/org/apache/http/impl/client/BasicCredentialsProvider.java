package org.apache.http.impl.client;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BasicCredentialsProvider implements CredentialsProvider {
    private final ConcurrentHashMap credMap = new ConcurrentHashMap();

    private static Credentials matchCredentials(Map map, AuthScope authScope) {
        Credentials credentials = (Credentials) map.get(authScope);
        if (credentials != null) {
            return credentials;
        }
        int i = -1;
        AuthScope authScope2 = null;
        for (AuthScope authScope3 : map.keySet()) {
            int match = authScope.match(authScope3);
            if (match > i) {
                authScope2 = authScope3;
                i = match;
            }
        }
        return authScope2 != null ? (Credentials) map.get(authScope2) : credentials;
    }

    public void clear() {
        this.credMap.clear();
    }

    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Authentication scope");
        return matchCredentials(this.credMap, authScope);
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        Args.notNull(authScope, "Authentication scope");
        this.credMap.put(authScope, credentials);
    }

    public String toString() {
        return this.credMap.toString();
    }
}
