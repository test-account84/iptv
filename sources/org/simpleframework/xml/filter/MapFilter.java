package org.simpleframework.xml.filter;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class MapFilter implements Filter {
    private Filter filter;
    private Map map;

    public MapFilter(Map map) {
        this(map, null);
    }

    public String replace(String str) {
        Map map = this.map;
        Object obj = map != null ? map.get(str) : null;
        if (obj != null) {
            return obj.toString();
        }
        Filter filter = this.filter;
        if (filter != null) {
            return filter.replace(str);
        }
        return null;
    }

    public MapFilter(Map map, Filter filter) {
        this.filter = filter;
        this.map = map;
    }
}
