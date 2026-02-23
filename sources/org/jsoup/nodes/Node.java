package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class Node implements Cloneable {
    private static final List EMPTY_NODES = Collections.emptyList();
    Attributes attributes;
    String baseUri;
    List childNodes;
    Node parentNode;
    int siblingIndex;

    public class 1 implements NodeVisitor {
        final /* synthetic */ String val$baseUri;

        public 1(String str) {
            this.val$baseUri = str;
        }

        public void head(Node node, int i) {
            node.baseUri = this.val$baseUri;
        }

        public void tail(Node node, int i) {
        }
    }

    public static class OuterHtmlVisitor implements NodeVisitor {
        private StringBuilder accum;
        private Document.OutputSettings out;

        public OuterHtmlVisitor(StringBuilder sb, Document.OutputSettings outputSettings) {
            this.accum = sb;
            this.out = outputSettings;
        }

        public void head(Node node, int i) {
            node.outerHtmlHead(this.accum, i, this.out);
        }

        public void tail(Node node, int i) {
            if (node.nodeName().equals("#text")) {
                return;
            }
            node.outerHtmlTail(this.accum, i, this.out);
        }
    }

    public Node() {
        this.childNodes = EMPTY_NODES;
        this.attributes = null;
    }

    private void addSiblingHtml(int i, String str) {
        Validate.notNull(str);
        Validate.notNull(this.parentNode);
        List parseFragment = Parser.parseFragment(str, parent() instanceof Element ? (Element) parent() : null, baseUri());
        this.parentNode.addChildren(i, (Node[]) parseFragment.toArray(new Node[parseFragment.size()]));
    }

    private Element getDeepChild(Element element) {
        Elements children = element.children();
        return children.size() > 0 ? getDeepChild((Element) children.get(0)) : element;
    }

    private void reindexChildren(int i) {
        while (i < this.childNodes.size()) {
            ((Node) this.childNodes.get(i)).setSiblingIndex(i);
            i++;
        }
    }

    public String absUrl(String str) {
        Validate.notEmpty(str);
        return !hasAttr(str) ? "" : StringUtil.resolve(this.baseUri, attr(str));
    }

    public void addChildren(int i, Node... nodeArr) {
        Validate.noNullElements(nodeArr);
        for (int length = nodeArr.length - 1; length >= 0; length--) {
            Node node = nodeArr[length];
            reparentChild(node);
            ensureChildNodes();
            this.childNodes.add(i, node);
        }
        reindexChildren(i);
    }

    public Node after(String str) {
        addSiblingHtml(this.siblingIndex + 1, str);
        return this;
    }

    public String attr(String str) {
        Validate.notNull(str);
        return this.attributes.hasKey(str) ? this.attributes.get(str) : str.toLowerCase().startsWith("abs:") ? absUrl(str.substring(4)) : "";
    }

    public Attributes attributes() {
        return this.attributes;
    }

    public String baseUri() {
        return this.baseUri;
    }

    public Node before(String str) {
        addSiblingHtml(this.siblingIndex, str);
        return this;
    }

    public Node childNode(int i) {
        return (Node) this.childNodes.get(i);
    }

    public final int childNodeSize() {
        return this.childNodes.size();
    }

    public List childNodes() {
        return Collections.unmodifiableList(this.childNodes);
    }

    public Node[] childNodesAsArray() {
        return (Node[]) this.childNodes.toArray(new Node[childNodeSize()]);
    }

    public List childNodesCopy() {
        ArrayList arrayList = new ArrayList(this.childNodes.size());
        Iterator it = this.childNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(((Node) it.next()).clone());
        }
        return arrayList;
    }

    public Node doClone(Node node) {
        try {
            Node node2 = (Node) super.clone();
            node2.parentNode = node;
            node2.siblingIndex = node == null ? 0 : this.siblingIndex;
            Attributes attributes = this.attributes;
            node2.attributes = attributes != null ? attributes.clone() : null;
            node2.baseUri = this.baseUri;
            node2.childNodes = new ArrayList(this.childNodes.size());
            Iterator it = this.childNodes.iterator();
            while (it.hasNext()) {
                node2.childNodes.add((Node) it.next());
            }
            return node2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ensureChildNodes() {
        if (this.childNodes == EMPTY_NODES) {
            this.childNodes = new ArrayList(4);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        List list = this.childNodes;
        if (list == null ? node.childNodes != null : !list.equals(node.childNodes)) {
            return false;
        }
        Attributes attributes = this.attributes;
        Attributes attributes2 = node.attributes;
        if (attributes != null) {
            if (attributes.equals(attributes2)) {
                return true;
            }
        } else if (attributes2 == null) {
            return true;
        }
        return false;
    }

    public Document.OutputSettings getOutputSettings() {
        return (ownerDocument() != null ? ownerDocument() : new Document("")).outputSettings();
    }

    public boolean hasAttr(String str) {
        Validate.notNull(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (this.attributes.hasKey(substring) && !absUrl(substring).equals("")) {
                return true;
            }
        }
        return this.attributes.hasKey(str);
    }

    public int hashCode() {
        List list = this.childNodes;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Attributes attributes = this.attributes;
        return hashCode + (attributes != null ? attributes.hashCode() : 0);
    }

    public void indent(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append("\n");
        sb.append(StringUtil.padding(i * outputSettings.indentAmount()));
    }

    public Node nextSibling() {
        Node node = this.parentNode;
        if (node == null) {
            return null;
        }
        List list = node.childNodes;
        int i = this.siblingIndex + 1;
        if (list.size() > i) {
            return (Node) list.get(i);
        }
        return null;
    }

    public abstract String nodeName();

    public String outerHtml() {
        StringBuilder sb = new StringBuilder(128);
        outerHtml(sb);
        return sb.toString();
    }

    public abstract void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings);

    public abstract void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings);

    public Document ownerDocument() {
        if (this instanceof Document) {
            return (Document) this;
        }
        Node node = this.parentNode;
        if (node == null) {
            return null;
        }
        return node.ownerDocument();
    }

    public Node parent() {
        return this.parentNode;
    }

    public final Node parentNode() {
        return this.parentNode;
    }

    public Node previousSibling() {
        int i;
        Node node = this.parentNode;
        if (node != null && (i = this.siblingIndex) > 0) {
            return (Node) node.childNodes.get(i - 1);
        }
        return null;
    }

    public void remove() {
        Validate.notNull(this.parentNode);
        this.parentNode.removeChild(this);
    }

    public Node removeAttr(String str) {
        Validate.notNull(str);
        this.attributes.remove(str);
        return this;
    }

    public void removeChild(Node node) {
        Validate.isTrue(node.parentNode == this);
        int i = node.siblingIndex;
        this.childNodes.remove(i);
        reindexChildren(i);
        node.parentNode = null;
    }

    public void reparentChild(Node node) {
        Node node2 = node.parentNode;
        if (node2 != null) {
            node2.removeChild(node);
        }
        node.setParentNode(this);
    }

    public void replaceChild(Node node, Node node2) {
        Validate.isTrue(node.parentNode == this);
        Validate.notNull(node2);
        Node node3 = node2.parentNode;
        if (node3 != null) {
            node3.removeChild(node2);
        }
        int i = node.siblingIndex;
        this.childNodes.set(i, node2);
        node2.parentNode = this;
        node2.setSiblingIndex(i);
        node.parentNode = null;
    }

    public void replaceWith(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.replaceChild(this, node);
    }

    public void setBaseUri(String str) {
        Validate.notNull(str);
        traverse(new 1(str));
    }

    public void setParentNode(Node node) {
        Node node2 = this.parentNode;
        if (node2 != null) {
            node2.removeChild(this);
        }
        this.parentNode = node;
    }

    public void setSiblingIndex(int i) {
        this.siblingIndex = i;
    }

    public int siblingIndex() {
        return this.siblingIndex;
    }

    public List siblingNodes() {
        Node node = this.parentNode;
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> list = node.childNodes;
        ArrayList arrayList = new ArrayList(list.size() - 1);
        for (Node node2 : list) {
            if (node2 != this) {
                arrayList.add(node2);
            }
        }
        return arrayList;
    }

    public String toString() {
        return outerHtml();
    }

    public Node traverse(NodeVisitor nodeVisitor) {
        Validate.notNull(nodeVisitor);
        new NodeTraversor(nodeVisitor).traverse(this);
        return this;
    }

    public Node unwrap() {
        Validate.notNull(this.parentNode);
        Node node = this.childNodes.size() > 0 ? (Node) this.childNodes.get(0) : null;
        this.parentNode.addChildren(this.siblingIndex, childNodesAsArray());
        remove();
        return node;
    }

    public Node wrap(String str) {
        Validate.notEmpty(str);
        List parseFragment = Parser.parseFragment(str, parent() instanceof Element ? (Element) parent() : null, baseUri());
        Node node = (Node) parseFragment.get(0);
        if (node == null || !(node instanceof Element)) {
            return null;
        }
        Element element = (Element) node;
        Element deepChild = getDeepChild(element);
        this.parentNode.replaceChild(this, element);
        deepChild.addChildren(this);
        if (parseFragment.size() > 0) {
            for (int i = 0; i < parseFragment.size(); i++) {
                Node node2 = (Node) parseFragment.get(i);
                node2.parentNode.removeChild(node2);
                element.appendChild(node2);
            }
        }
        return this;
    }

    public Node(String str) {
        this(str, new Attributes());
    }

    public void addChildren(Node... nodeArr) {
        for (Node node : nodeArr) {
            reparentChild(node);
            ensureChildNodes();
            this.childNodes.add(node);
            node.setSiblingIndex(this.childNodes.size() - 1);
        }
    }

    public Node after(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex + 1, node);
        return this;
    }

    public Node attr(String str, String str2) {
        this.attributes.put(str, str2);
        return this;
    }

    public Node before(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex, node);
        return this;
    }

    public Node clone() {
        Node doClone = doClone(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(doClone);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            for (int i = 0; i < node.childNodes.size(); i++) {
                Node doClone2 = ((Node) node.childNodes.get(i)).doClone(node);
                node.childNodes.set(i, doClone2);
                linkedList.add(doClone2);
            }
        }
        return doClone;
    }

    public void outerHtml(StringBuilder sb) {
        new NodeTraversor(new OuterHtmlVisitor(sb, getOutputSettings())).traverse(this);
    }

    public Node(String str, Attributes attributes) {
        Validate.notNull(str);
        Validate.notNull(attributes);
        this.childNodes = EMPTY_NODES;
        this.baseUri = str.trim();
        this.attributes = attributes;
    }
}
