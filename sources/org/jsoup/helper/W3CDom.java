package org.jsoup.helper;

import java.io.StringWriter;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class W3CDom {
    protected DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public class W3CBuilder implements NodeVisitor {
        private Element dest;
        private final Document doc;

        public W3CBuilder(Document document) {
            this.doc = document;
        }

        private void copyAttributes(Node node, Element element) {
            Iterator it = node.attributes().iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                element.setAttribute(attribute.getKey(), attribute.getValue());
            }
        }

        public void head(Node node, int i) {
            Document document;
            String wholeData;
            Text createComment;
            if (node instanceof org.jsoup.nodes.Element) {
                org.jsoup.nodes.Element element = (org.jsoup.nodes.Element) node;
                Element createElement = this.doc.createElement(element.tagName());
                copyAttributes(element, createElement);
                Document document2 = this.dest;
                if (document2 == null) {
                    document2 = this.doc;
                }
                document2.appendChild(createElement);
                this.dest = createElement;
                return;
            }
            if (node instanceof TextNode) {
                document = this.doc;
                wholeData = ((TextNode) node).getWholeText();
            } else if (node instanceof Comment) {
                createComment = this.doc.createComment(((Comment) node).getData());
                this.dest.appendChild(createComment);
            } else {
                if (!(node instanceof DataNode)) {
                    return;
                }
                document = this.doc;
                wholeData = ((DataNode) node).getWholeData();
            }
            createComment = document.createTextNode(wholeData);
            this.dest.appendChild(createComment);
        }

        public void tail(Node node, int i) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.dest.getParentNode() instanceof Element)) {
                this.dest = this.dest.getParentNode();
            }
        }
    }

    public String asString(Document document) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }

    public void convert(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.isBlank(document.location())) {
            document2.setDocumentURI(document.location());
        }
        new NodeTraversor(new W3CBuilder(document2)).traverse(document.child(0));
    }

    public Document fromJsoup(org.jsoup.nodes.Document document) {
        Validate.notNull(document);
        try {
            Document newDocument = this.factory.newDocumentBuilder().newDocument();
            convert(document, newDocument);
            return newDocument;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }
}
