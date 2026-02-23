package org.jsoup.safety;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Cleaner {
    private Whitelist whitelist;

    public final class CleaningVisitor implements NodeVisitor {
        private Element destination;
        private int numDiscarded;
        private final Element root;

        private CleaningVisitor(Element element, Element element2) {
            this.numDiscarded = 0;
            this.root = element;
            this.destination = element2;
        }

        public static /* synthetic */ int access$300(CleaningVisitor cleaningVisitor) {
            return cleaningVisitor.numDiscarded;
        }

        public void head(Node node, int i) {
            Node dataNode;
            if (!(node instanceof Element)) {
                if (node instanceof TextNode) {
                    dataNode = new TextNode(((TextNode) node).getWholeText(), node.baseUri());
                } else if ((node instanceof DataNode) && Cleaner.access$000(Cleaner.this).isSafeTag(node.parent().nodeName())) {
                    dataNode = new DataNode(((DataNode) node).getWholeData(), node.baseUri());
                }
                this.destination.appendChild(dataNode);
                return;
            }
            Element element = (Element) node;
            if (Cleaner.access$000(Cleaner.this).isSafeTag(element.tagName())) {
                ElementMeta access$100 = Cleaner.access$100(Cleaner.this, element);
                Element element2 = access$100.el;
                this.destination.appendChild(element2);
                this.numDiscarded += access$100.numAttribsDiscarded;
                this.destination = element2;
                return;
            }
            if (node == this.root) {
                return;
            }
            this.numDiscarded++;
        }

        public void tail(Node node, int i) {
            if ((node instanceof Element) && Cleaner.access$000(Cleaner.this).isSafeTag(node.nodeName())) {
                this.destination = this.destination.parent();
            }
        }

        public /* synthetic */ CleaningVisitor(Cleaner cleaner, Element element, Element element2, 1 r4) {
            this(element, element2);
        }
    }

    public static class ElementMeta {
        Element el;
        int numAttribsDiscarded;

        public ElementMeta(Element element, int i) {
            this.el = element;
            this.numAttribsDiscarded = i;
        }
    }

    public Cleaner(Whitelist whitelist) {
        Validate.notNull(whitelist);
        this.whitelist = whitelist;
    }

    public static /* synthetic */ Whitelist access$000(Cleaner cleaner) {
        return cleaner.whitelist;
    }

    public static /* synthetic */ ElementMeta access$100(Cleaner cleaner, Element element) {
        return cleaner.createSafeElement(element);
    }

    private int copySafeNodes(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(this, element, element2, null);
        new NodeTraversor(cleaningVisitor).traverse(element);
        return CleaningVisitor.access$300(cleaningVisitor);
    }

    private ElementMeta createSafeElement(Element element) {
        String tagName = element.tagName();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.valueOf(tagName), element.baseUri(), attributes);
        Iterator it = element.attributes().iterator();
        int i = 0;
        while (it.hasNext()) {
            Attribute attribute = (Attribute) it.next();
            if (this.whitelist.isSafeAttribute(tagName, element, attribute)) {
                attributes.put(attribute);
            } else {
                i++;
            }
        }
        attributes.addAll(this.whitelist.getEnforcedAttributes(tagName));
        return new ElementMeta(element2, i);
    }

    public Document clean(Document document) {
        Validate.notNull(document);
        Document createShell = Document.createShell(document.baseUri());
        if (document.body() != null) {
            copySafeNodes(document.body(), createShell.body());
        }
        return createShell;
    }

    public boolean isValid(Document document) {
        Validate.notNull(document);
        return copySafeNodes(document.body(), Document.createShell(document.baseUri()).body()) == 0;
    }
}
