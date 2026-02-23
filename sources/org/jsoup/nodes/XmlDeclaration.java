package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class XmlDeclaration extends Node {
    static final String DECL_KEY = "declaration";
    private final boolean isProcessingInstruction;

    public XmlDeclaration(String str, String str2, boolean z) {
        super(str2);
        this.attributes.put("declaration", str);
        this.isProcessingInstruction = z;
    }

    public String getWholeDeclaration() {
        String str = this.attributes.get("declaration");
        if (!str.equals("xml") || this.attributes.size() <= 1) {
            return this.attributes.get("declaration");
        }
        StringBuilder sb = new StringBuilder(str);
        String str2 = this.attributes.get("version");
        if (str2 != null) {
            sb.append(" version=\"");
            sb.append(str2);
            sb.append("\"");
        }
        String str3 = this.attributes.get("encoding");
        if (str3 != null) {
            sb.append(" encoding=\"");
            sb.append(str3);
            sb.append("\"");
        }
        return sb.toString();
    }

    public String nodeName() {
        return "#declaration";
    }

    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append("<");
        sb.append(this.isProcessingInstruction ? "!" : "?");
        sb.append(getWholeDeclaration());
        sb.append(">");
    }

    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }

    public String toString() {
        return outerHtml();
    }
}
