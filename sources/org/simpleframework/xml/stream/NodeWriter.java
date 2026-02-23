package org.simpleframework.xml.stream;

import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class NodeWriter {
    private final Set active;
    private final OutputStack stack;
    private final boolean verbose;
    private final Formatter writer;

    public NodeWriter(Writer writer) {
        this(writer, new Format());
    }

    private void writeAttributes(OutputNode outputNode) throws Exception {
        NodeMap<String> attributes = outputNode.getAttributes();
        for (String str : attributes) {
            OutputNode outputNode2 = (OutputNode) attributes.get(str);
            this.writer.writeAttribute(str, outputNode2.getValue(), outputNode2.getPrefix(this.verbose));
        }
        this.active.remove(outputNode);
    }

    private void writeComment(OutputNode outputNode) throws Exception {
        String comment = outputNode.getComment();
        if (comment != null) {
            this.writer.writeComment(comment);
        }
    }

    private void writeEnd(OutputNode outputNode) throws Exception {
        String name = outputNode.getName();
        String prefix = outputNode.getPrefix(this.verbose);
        if (outputNode.getValue() != null) {
            writeValue(outputNode);
        }
        if (name != null) {
            this.writer.writeEnd(name, prefix);
            this.writer.flush();
        }
    }

    private void writeName(OutputNode outputNode) throws Exception {
        String prefix = outputNode.getPrefix(this.verbose);
        String name = outputNode.getName();
        if (name != null) {
            this.writer.writeStart(name, prefix);
        }
    }

    private void writeNamespaces(OutputNode outputNode) throws Exception {
        NamespaceMap<String> namespaces = outputNode.getNamespaces();
        for (String str : namespaces) {
            this.writer.writeNamespace(str, namespaces.getPrefix(str));
        }
    }

    private OutputNode writeStart(OutputNode outputNode, String str) throws Exception {
        OutputElement outputElement = new OutputElement(outputNode, this, str);
        if (str != null) {
            return this.stack.push(outputElement);
        }
        throw new NodeException("Can not have a null name");
    }

    private void writeValue(OutputNode outputNode) throws Exception {
        Mode mode = outputNode.getMode();
        String value = outputNode.getValue();
        if (value != null) {
            Iterator it = this.stack.iterator();
            while (it.hasNext()) {
                OutputNode outputNode2 = (OutputNode) it.next();
                if (mode != Mode.INHERIT) {
                    break;
                } else {
                    mode = outputNode2.getMode();
                }
            }
            this.writer.writeText(value, mode);
        }
        outputNode.setValue(null);
    }

    public void commit(OutputNode outputNode) throws Exception {
        if (this.stack.contains(outputNode)) {
            OutputNode pVar = this.stack.top();
            if (!isCommitted(pVar)) {
                writeStart(pVar);
            }
            while (this.stack.top() != outputNode) {
                writeEnd(this.stack.pop());
            }
            writeEnd(outputNode);
            this.stack.pop();
        }
    }

    public boolean isCommitted(OutputNode outputNode) {
        return !this.active.contains(outputNode);
    }

    public boolean isRoot(OutputNode outputNode) {
        return this.stack.bottom() == outputNode;
    }

    public void remove(OutputNode outputNode) throws Exception {
        if (this.stack.top() != outputNode) {
            throw new NodeException("Cannot remove node");
        }
        this.stack.pop();
    }

    public OutputNode writeElement(OutputNode outputNode, String str) throws Exception {
        if (this.stack.isEmpty()) {
            return writeStart(outputNode, str);
        }
        if (!this.stack.contains(outputNode)) {
            return null;
        }
        OutputNode pVar = this.stack.top();
        if (!isCommitted(pVar)) {
            writeStart(pVar);
        }
        while (this.stack.top() != outputNode) {
            writeEnd(this.stack.pop());
        }
        if (!this.stack.isEmpty()) {
            writeValue(outputNode);
        }
        return writeStart(outputNode, str);
    }

    public OutputNode writeRoot() throws Exception {
        OutputDocument outputDocument = new OutputDocument(this, this.stack);
        if (this.stack.isEmpty()) {
            this.writer.writeProlog();
        }
        return outputDocument;
    }

    public NodeWriter(Writer writer, Format format) {
        this(writer, format, false);
    }

    private void writeStart(OutputNode outputNode) throws Exception {
        writeComment(outputNode);
        writeName(outputNode);
        writeAttributes(outputNode);
        writeNamespaces(outputNode);
    }

    private NodeWriter(Writer writer, Format format, boolean z) {
        this.writer = new Formatter(writer, format);
        HashSet hashSet = new HashSet();
        this.active = hashSet;
        this.stack = new OutputStack(hashSet);
        this.verbose = z;
    }
}
