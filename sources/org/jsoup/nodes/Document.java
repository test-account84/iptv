package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Document extends Element {
    private String location;
    private OutputSettings outputSettings;
    private QuirksMode quirksMode;
    private boolean updateMetaCharset;

    public static class OutputSettings implements Cloneable {
        private Charset charset;
        private CharsetEncoder charsetEncoder;
        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private int indentAmount;
        private boolean outline;
        private boolean prettyPrint;
        private Syntax syntax;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            Charset forName = Charset.forName("UTF-8");
            this.charset = forName;
            this.charsetEncoder = forName.newEncoder();
            this.prettyPrint = true;
            this.outline = false;
            this.indentAmount = 1;
            this.syntax = Syntax.html;
        }

        public Charset charset() {
            return this.charset;
        }

        public CharsetEncoder encoder() {
            return this.charsetEncoder;
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public OutputSettings outline(boolean z) {
            this.outline = z;
            return this;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public Syntax syntax() {
            return this.syntax;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }

        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public OutputSettings indentAmount(int i) {
            Validate.isTrue(i >= 0);
            this.indentAmount = i;
            return this;
        }

        public boolean outline() {
            return this.outline;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public OutputSettings syntax(Syntax syntax) {
            this.syntax = syntax;
            return this;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            this.charsetEncoder = charset.newEncoder();
            return this;
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root"), str);
        this.outputSettings = new OutputSettings();
        this.quirksMode = QuirksMode.noQuirks;
        this.updateMetaCharset = false;
        this.location = str;
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        Element appendElement = document.appendElement("html");
        appendElement.appendElement("head");
        appendElement.appendElement("body");
        return document;
    }

    private void ensureMetaCharsetElement() {
        XmlDeclaration xmlDeclaration;
        if (this.updateMetaCharset) {
            OutputSettings.Syntax syntax = outputSettings().syntax();
            if (syntax == OutputSettings.Syntax.html) {
                Element first = select("meta[charset]").first();
                if (first == null) {
                    Element head = head();
                    if (head != null) {
                        first = head.appendElement("meta");
                        first.attr("charset", charset().displayName());
                    }
                } else {
                    first.attr("charset", charset().displayName());
                }
                select("meta[name=charset]").remove();
                return;
            }
            if (syntax == OutputSettings.Syntax.xml) {
                Node node = (Node) childNodes().get(0);
                if (node instanceof XmlDeclaration) {
                    XmlDeclaration xmlDeclaration2 = (XmlDeclaration) node;
                    if (xmlDeclaration2.attr("declaration").equals("xml")) {
                        xmlDeclaration2.attr("encoding", charset().displayName());
                        if (xmlDeclaration2.attr("version") != null) {
                            xmlDeclaration2.attr("version", "1.0");
                            return;
                        }
                        return;
                    }
                    xmlDeclaration = new XmlDeclaration("xml", this.baseUri, false);
                } else {
                    xmlDeclaration = new XmlDeclaration("xml", this.baseUri, false);
                }
                xmlDeclaration.attr("version", "1.0");
                xmlDeclaration.attr("encoding", charset().displayName());
                prependChild(xmlDeclaration);
            }
        }
    }

    private Element findFirstElementByTagName(String str, Node node) {
        if (node.nodeName().equals(str)) {
            return (Element) node;
        }
        Iterator it = node.childNodes.iterator();
        while (it.hasNext()) {
            Element findFirstElementByTagName = findFirstElementByTagName(str, (Node) it.next());
            if (findFirstElementByTagName != null) {
                return findFirstElementByTagName;
            }
        }
        return null;
    }

    private void normaliseStructure(String str, Element element) {
        Elements elementsByTag = getElementsByTag(str);
        Element first = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < elementsByTag.size(); i++) {
                Node node = (Node) elementsByTag.get(i);
                Iterator it = node.childNodes.iterator();
                while (it.hasNext()) {
                    arrayList.add((Node) it.next());
                }
                node.remove();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                first.appendChild((Node) it2.next());
            }
        }
        if (first.parent().equals(element)) {
            return;
        }
        element.appendChild(first);
    }

    private void normaliseTextNodes(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.childNodes) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(" ", ""));
            body().prependChild(node2);
        }
    }

    public Element body() {
        return findFirstElementByTagName("body", this);
    }

    public Charset charset() {
        return this.outputSettings.charset();
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str), baseUri());
    }

    public Element head() {
        return findFirstElementByTagName("head", this);
    }

    public String location() {
        return this.location;
    }

    public String nodeName() {
        return "#document";
    }

    public Document normalise() {
        Element findFirstElementByTagName = findFirstElementByTagName("html", this);
        if (findFirstElementByTagName == null) {
            findFirstElementByTagName = appendElement("html");
        }
        if (head() == null) {
            findFirstElementByTagName.prependElement("head");
        }
        if (body() == null) {
            findFirstElementByTagName.appendElement("body");
        }
        normaliseTextNodes(head());
        normaliseTextNodes(findFirstElementByTagName);
        normaliseTextNodes(this);
        normaliseStructure("head", findFirstElementByTagName);
        normaliseStructure("body", findFirstElementByTagName);
        ensureMetaCharsetElement();
        return this;
    }

    public String outerHtml() {
        return super.html();
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    public Element text(String str) {
        body().text(str);
        return this;
    }

    public String title() {
        Element first = getElementsByTag("title").first();
        return first != null ? StringUtil.normaliseWhitespace(first.text()).trim() : "";
    }

    public void updateMetaCharsetElement(boolean z) {
        this.updateMetaCharset = z;
    }

    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        this.outputSettings.charset(charset);
        ensureMetaCharsetElement();
    }

    public Document clone() {
        Document document = (Document) super.clone();
        document.outputSettings = this.outputSettings.clone();
        return document;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    public void title(String str) {
        Validate.notNull(str);
        Element first = getElementsByTag("title").first();
        if (first == null) {
            head().appendElement("title").text(str);
        } else {
            first.text(str);
        }
    }

    public boolean updateMetaCharsetElement() {
        return this.updateMetaCharset;
    }
}
