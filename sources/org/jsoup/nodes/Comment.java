package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Comment extends Node {
    private static final String COMMENT_KEY = "comment";

    public Comment(String str, String str2) {
        super(str2);
        this.attributes.put("comment", str);
    }

    public String getData() {
        return this.attributes.get("comment");
    }

    public String nodeName() {
        return "#comment";
    }

    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        if (outputSettings.prettyPrint()) {
            indent(sb, i, outputSettings);
        }
        sb.append("<!--");
        sb.append(getData());
        sb.append("-->");
    }

    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }

    public String toString() {
        return outerHtml();
    }
}
