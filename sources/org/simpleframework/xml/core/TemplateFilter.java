package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class TemplateFilter implements Filter {
    private Context context;
    private Filter filter;

    public TemplateFilter(Context context, Filter filter) {
        this.context = context;
        this.filter = filter;
    }

    public String replace(String str) {
        Object attribute = this.context.getAttribute(str);
        return attribute != null ? attribute.toString() : this.filter.replace(str);
    }
}
