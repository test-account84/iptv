package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DocumentType extends Node {
    private static final String NAME = "name";
    private static final String PUBLIC_ID = "publicId";
    private static final String SYSTEM_ID = "systemId";

    public DocumentType(String str, String str2, String str3, String str4) {
        super(str4);
        attr("name", str);
        attr("publicId", str2);
        attr("systemId", str3);
    }

    private boolean has(String str) {
        return !StringUtil.isBlank(attr(str));
    }

    public String nodeName() {
        return "#doctype";
    }

    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append((outputSettings.syntax() != Document.OutputSettings.Syntax.html || has("publicId") || has("systemId")) ? "<!DOCTYPE" : "<!doctype");
        if (has("name")) {
            sb.append(" ");
            sb.append(attr("name"));
        }
        if (has("publicId")) {
            sb.append(" PUBLIC \"");
            sb.append(attr("publicId"));
            sb.append('\"');
        }
        if (has("systemId")) {
            sb.append(" \"");
            sb.append(attr("systemId"));
            sb.append('\"');
        }
        sb.append('>');
    }

    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }
}
