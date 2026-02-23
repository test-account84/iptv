package org.simpleframework.xml.stream;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Builder implements Style {
    private final Cache attributes = new ConcurrentCache();
    private final Cache elements = new ConcurrentCache();
    private final Style style;

    public Builder(Style style) {
        this.style = style;
    }

    public String getAttribute(String str) {
        String str2 = (String) this.attributes.fetch(str);
        if (str2 != null) {
            return str2;
        }
        String attribute = this.style.getAttribute(str);
        if (attribute != null) {
            this.attributes.cache(str, attribute);
        }
        return attribute;
    }

    public String getElement(String str) {
        String str2 = (String) this.elements.fetch(str);
        if (str2 != null) {
            return str2;
        }
        String element = this.style.getElement(str);
        if (element != null) {
            this.elements.cache(str, element);
        }
        return element;
    }

    public void setAttribute(String str, String str2) {
        this.attributes.cache(str, str2);
    }

    public void setElement(String str, String str2) {
        this.elements.cache(str, str2);
    }
}
