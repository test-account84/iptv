package org.simpleframework.xml.stream;

import java.util.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class NodeExtractor extends LinkedList {
    public NodeExtractor(Document document) {
        extract(document);
    }

    private void extract(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement != null) {
            offer(documentElement);
            extract((org.w3c.dom.Node) documentElement);
        }
    }

    private void extract(org.w3c.dom.Node node) {
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            org.w3c.dom.Node item = childNodes.item(i);
            if (item.getNodeType() != 8) {
                offer(item);
                extract(item);
            }
        }
    }
}
