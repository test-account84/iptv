package org.apache.http.config;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Registry implements Lookup {
    private final Map map;

    public Registry(Map map) {
        this.map = new ConcurrentHashMap(map);
    }

    public Object lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str.toLowerCase(Locale.ROOT));
    }

    public String toString() {
        return this.map.toString();
    }
}
