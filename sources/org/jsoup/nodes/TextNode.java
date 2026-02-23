package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TextNode extends Node {
    private static final String TEXT_KEY = "text";
    String text;

    public TextNode(String str, String str2) {
        this.baseUri = str2;
        this.text = str;
    }

    public static TextNode createFromEncoded(String str, String str2) {
        return new TextNode(Entities.unescape(str), str2);
    }

    private void ensureAttributes() {
        if (this.attributes == null) {
            Attributes attributes = new Attributes();
            this.attributes = attributes;
            attributes.put("text", this.text);
        }
    }

    public static boolean lastCharIsWhitespace(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    public static String normaliseWhitespace(String str) {
        return StringUtil.normaliseWhitespace(str);
    }

    public static String stripLeadingWhitespace(String str) {
        return str.replaceFirst("^\\s+", "");
    }

    public String absUrl(String str) {
        ensureAttributes();
        return super.absUrl(str);
    }

    public String attr(String str) {
        ensureAttributes();
        return super.attr(str);
    }

    public Attributes attributes() {
        ensureAttributes();
        return super.attributes();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        String str = this.text;
        String str2 = ((TextNode) obj).text;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getWholeText() {
        Attributes attributes = this.attributes;
        return attributes == null ? this.text : attributes.get("text");
    }

    public boolean hasAttr(String str) {
        ensureAttributes();
        return super.hasAttr(str);
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.text;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public boolean isBlank() {
        return StringUtil.isBlank(getWholeText());
    }

    public String nodeName() {
        return "#text";
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void outerHtmlHead(java.lang.StringBuilder r7, int r8, org.jsoup.nodes.Document.OutputSettings r9) {
        /*
            r6 = this;
            boolean r0 = r9.prettyPrint()
            if (r0 == 0) goto L3d
            int r0 = r6.siblingIndex()
            if (r0 != 0) goto L24
            org.jsoup.nodes.Node r0 = r6.parentNode
            boolean r1 = r0 instanceof org.jsoup.nodes.Element
            if (r1 == 0) goto L24
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            org.jsoup.parser.Tag r0 = r0.tag()
            boolean r0 = r0.formatAsBlock()
            if (r0 == 0) goto L24
            boolean r0 = r6.isBlank()
            if (r0 == 0) goto L3a
        L24:
            boolean r0 = r9.outline()
            if (r0 == 0) goto L3d
            java.util.List r0 = r6.siblingNodes()
            int r0 = r0.size()
            if (r0 <= 0) goto L3d
            boolean r0 = r6.isBlank()
            if (r0 != 0) goto L3d
        L3a:
            r6.indent(r7, r8, r9)
        L3d:
            boolean r8 = r9.prettyPrint()
            if (r8 == 0) goto L58
            org.jsoup.nodes.Node r8 = r6.parent()
            boolean r8 = r8 instanceof org.jsoup.nodes.Element
            if (r8 == 0) goto L58
            org.jsoup.nodes.Node r8 = r6.parent()
            boolean r8 = org.jsoup.nodes.Element.preserveWhitespace(r8)
            if (r8 != 0) goto L58
            r8 = 1
            r4 = 1
            goto L5a
        L58:
            r8 = 0
            r4 = 0
        L5a:
            java.lang.String r1 = r6.getWholeText()
            r3 = 0
            r5 = 0
            r0 = r7
            r2 = r9
            org.jsoup.nodes.Entities.escape(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.TextNode.outerHtmlHead(java.lang.StringBuilder, int, org.jsoup.nodes.Document$OutputSettings):void");
    }

    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }

    public Node removeAttr(String str) {
        ensureAttributes();
        return super.removeAttr(str);
    }

    public TextNode splitText(int i) {
        Validate.isTrue(i >= 0, "Split offset must be not be negative");
        Validate.isTrue(i < this.text.length(), "Split offset must not be greater than current text length");
        String substring = getWholeText().substring(0, i);
        String substring2 = getWholeText().substring(i);
        text(substring);
        TextNode textNode = new TextNode(substring2, baseUri());
        if (parent() != null) {
            parent().addChildren(siblingIndex() + 1, textNode);
        }
        return textNode;
    }

    public String text() {
        return normaliseWhitespace(getWholeText());
    }

    public String toString() {
        return outerHtml();
    }

    public Node attr(String str, String str2) {
        ensureAttributes();
        return super.attr(str, str2);
    }

    public TextNode text(String str) {
        this.text = str;
        Attributes attributes = this.attributes;
        if (attributes != null) {
            attributes.put("text", str);
        }
        return this;
    }
}
