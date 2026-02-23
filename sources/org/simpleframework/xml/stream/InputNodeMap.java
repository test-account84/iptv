package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class InputNodeMap extends LinkedHashMap implements NodeMap {
    private final InputNode source;

    public InputNodeMap(InputNode inputNode) {
        this.source = inputNode;
    }

    private void build(EventNode eventNode) {
        Iterator it = eventNode.iterator();
        while (it.hasNext()) {
            Attribute attribute = (Attribute) it.next();
            InputAttribute inputAttribute = new InputAttribute(this.source, attribute);
            if (!attribute.isReserved()) {
                put(inputAttribute.getName(), inputAttribute);
            }
        }
    }

    public InputNode get(String str) {
        return (InputNode) super.get(str);
    }

    public String getName() {
        return this.source.getName();
    }

    public InputNode getNode() {
        return this.source;
    }

    public Iterator iterator() {
        return keySet().iterator();
    }

    public InputNode put(String str, String str2) {
        InputAttribute inputAttribute = new InputAttribute(this.source, str, str2);
        if (str != null) {
            put(str, inputAttribute);
        }
        return inputAttribute;
    }

    public InputNode remove(String str) {
        return (InputNode) super.remove(str);
    }

    public InputNodeMap(InputNode inputNode, EventNode eventNode) {
        this.source = inputNode;
        build(eventNode);
    }
}
