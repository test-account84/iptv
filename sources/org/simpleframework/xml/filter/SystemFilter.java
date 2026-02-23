package org.simpleframework.xml.filter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SystemFilter implements Filter {
    private Filter filter;

    public SystemFilter() {
        this(null);
    }

    public String replace(String str) {
        String property = System.getProperty(str);
        if (property != null) {
            return property;
        }
        Filter filter = this.filter;
        if (filter != null) {
            return filter.replace(str);
        }
        return null;
    }

    public SystemFilter(Filter filter) {
        this.filter = filter;
    }
}
