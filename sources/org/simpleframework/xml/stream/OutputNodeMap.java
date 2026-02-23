package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OutputNodeMap extends LinkedHashMap implements NodeMap {
    private final OutputNode source;

    public OutputNodeMap(OutputNode outputNode) {
        this.source = outputNode;
    }

    public String getName() {
        return this.source.getName();
    }

    public Iterator iterator() {
        return keySet().iterator();
    }

    public OutputNode get(String str) {
        return (OutputNode) super.get(str);
    }

    public OutputNode getNode() {
        return this.source;
    }

    public OutputNode put(String str, String str2) {
        OutputAttribute outputAttribute = new OutputAttribute(this.source, str, str2);
        if (this.source != null) {
            put(str, outputAttribute);
        }
        return outputAttribute;
    }

    public OutputNode remove(String str) {
        return (OutputNode) super.remove(str);
    }
}
