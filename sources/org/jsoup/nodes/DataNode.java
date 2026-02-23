package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DataNode extends Node {
    private static final String DATA_KEY = "data";

    public DataNode(String str, String str2) {
        super(str2);
        this.attributes.put("data", str);
    }

    public static DataNode createFromEncoded(String str, String str2) {
        return new DataNode(Entities.unescape(str), str2);
    }

    public String getWholeData() {
        return this.attributes.get("data");
    }

    public String nodeName() {
        return "#data";
    }

    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append(getWholeData());
    }

    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }

    public DataNode setWholeData(String str) {
        this.attributes.put("data", str);
        return this;
    }

    public String toString() {
        return outerHtml();
    }
}
