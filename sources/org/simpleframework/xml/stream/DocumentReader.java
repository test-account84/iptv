package org.simpleframework.xml.stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class DocumentReader implements EventReader {
    private static final String RESERVED = "xml";
    private EventNode peek;
    private NodeExtractor queue;
    private NodeStack stack;

    public static class End extends EventToken {
        private End() {
        }

        public boolean isEnd() {
            return true;
        }

        public /* synthetic */ End(1 r1) {
            this();
        }
    }

    public static class Entry extends EventAttribute {
        private final org.w3c.dom.Node node;

        public Entry(org.w3c.dom.Node node) {
            this.node = node;
        }

        public String getName() {
            return this.node.getLocalName();
        }

        public String getPrefix() {
            return this.node.getPrefix();
        }

        public String getReference() {
            return this.node.getNamespaceURI();
        }

        public Object getSource() {
            return this.node;
        }

        public String getValue() {
            return this.node.getNodeValue();
        }

        public boolean isReserved() {
            String prefix = getPrefix();
            return prefix != null ? prefix.startsWith("xml") : getName().startsWith("xml");
        }
    }

    public static class Start extends EventElement {
        private final Element element;

        public Start(org.w3c.dom.Node node) {
            this.element = (Element) node;
        }

        public NamedNodeMap getAttributes() {
            return this.element.getAttributes();
        }

        public String getName() {
            return this.element.getLocalName();
        }

        public String getPrefix() {
            return this.element.getPrefix();
        }

        public String getReference() {
            return this.element.getNamespaceURI();
        }

        public Object getSource() {
            return this.element;
        }
    }

    public static class Text extends EventToken {
        private final org.w3c.dom.Node node;

        public Text(org.w3c.dom.Node node) {
            this.node = node;
        }

        public Object getSource() {
            return this.node;
        }

        public String getValue() {
            return this.node.getNodeValue();
        }

        public boolean isText() {
            return true;
        }
    }

    public DocumentReader(Document document) {
        this.queue = new NodeExtractor(document);
        NodeStack nodeStack = new NodeStack();
        this.stack = nodeStack;
        nodeStack.push(document);
    }

    private Entry attribute(org.w3c.dom.Node node) {
        return new Entry(node);
    }

    private Start build(Start start) {
        NamedNodeMap attributes = start.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Entry attribute = attribute(attributes.item(i));
            if (!attribute.isReserved()) {
                start.add(attribute);
            }
        }
        return start;
    }

    private EventNode convert(org.w3c.dom.Node node) throws Exception {
        if (node.getNodeType() != 1) {
            return text(node);
        }
        this.stack.push(node);
        return start(node);
    }

    private End end() {
        return new End(null);
    }

    private EventNode read() throws Exception {
        org.w3c.dom.Node node = (org.w3c.dom.Node) this.queue.peek();
        return node == null ? end() : read(node);
    }

    private Start start(org.w3c.dom.Node node) {
        Start start = new Start(node);
        return start.isEmpty() ? build(start) : start;
    }

    private Text text(org.w3c.dom.Node node) {
        return new Text(node);
    }

    public EventNode next() throws Exception {
        EventNode eventNode = this.peek;
        if (eventNode == null) {
            return read();
        }
        this.peek = null;
        return eventNode;
    }

    public EventNode peek() throws Exception {
        if (this.peek == null) {
            this.peek = next();
        }
        return this.peek;
    }

    private EventNode read(org.w3c.dom.Node node) throws Exception {
        org.w3c.dom.Node parentNode = node.getParentNode();
        org.w3c.dom.Node node2 = (org.w3c.dom.Node) this.stack.top();
        if (parentNode == node2) {
            this.queue.poll();
            return convert(node);
        }
        if (node2 != null) {
            this.stack.pop();
        }
        return end();
    }
}
