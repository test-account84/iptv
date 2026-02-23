package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Stack;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class XMLWriter {
    private static final String PROLOG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private Stack elementStack;
    private boolean rootElement;
    private final Writer writer;
    private final String xmlns;

    public XMLWriter(Writer writer) {
        this(writer, null);
    }

    private void append(String str) {
        try {
            this.writer.append(str);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to write XML document", e);
        }
    }

    private String escapeXMLEntities(String str) {
        if (str.contains("&")) {
            str = str.replace("&quot;", "\"").replace("&apos;", "'").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
        }
        return str.replace("&", "&amp;").replace("\"", "&quot;").replace("'", "&apos;").replace("<", "&lt;").replace(">", "&gt;");
    }

    public XMLWriter endElement() {
        append("</" + ((String) this.elementStack.pop()) + ">");
        return this;
    }

    public XMLWriter startElement(String str) {
        append("<" + str);
        if (this.rootElement && this.xmlns != null) {
            append(" xmlns=\"" + this.xmlns + "\"");
            this.rootElement = false;
        }
        append(">");
        this.elementStack.push(str);
        return this;
    }

    public XMLWriter value(Object obj) {
        append(escapeXMLEntities(obj.toString()));
        return this;
    }

    public XMLWriter(Writer writer, String str) {
        this.elementStack = new Stack();
        this.rootElement = true;
        this.writer = writer;
        this.xmlns = str;
        append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    public XMLWriter value(String str) {
        append(escapeXMLEntities(str));
        return this;
    }

    public XMLWriter value(Date date) {
        append(escapeXMLEntities(StringUtils.fromDate(date)));
        return this;
    }
}
