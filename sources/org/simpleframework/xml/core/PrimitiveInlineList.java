package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class PrimitiveInlineList implements Repeater {
    private final Type entry;
    private final CollectionFactory factory;
    private final String parent;
    private final Primitive root;

    public PrimitiveInlineList(Context context, Type type, Type type2, String str) {
        this.factory = new CollectionFactory(context, type);
        this.root = new Primitive(context, type2);
        this.parent = str;
        this.entry = type2;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) throws Exception {
        return this.factory.setOverride(this.entry, obj, outputNode);
    }

    public Object read(InputNode inputNode) throws Exception {
        Collection collection = (Collection) this.factory.getInstance();
        if (collection != null) {
            return read(inputNode, collection);
        }
        return null;
    }

    public boolean validate(InputNode inputNode) throws Exception {
        InputNode parent = inputNode.getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            if (!this.root.validate(inputNode)) {
                return false;
            }
            inputNode = parent.getNext(name);
        }
        return true;
    }

    public void write(OutputNode outputNode, Object obj) throws Exception {
        OutputNode parent = outputNode.getParent();
        Mode mode = outputNode.getMode();
        if (!outputNode.isCommitted()) {
            outputNode.remove();
        }
        write(parent, obj, mode);
    }

    private void write(OutputNode outputNode, Object obj, Mode mode) throws Exception {
        for (Object obj2 : (Collection) obj) {
            if (obj2 != null) {
                OutputNode child = outputNode.getChild(this.parent);
                if (!isOverridden(child, obj2)) {
                    child.setMode(mode);
                    this.root.write(child, obj2);
                }
            }
        }
    }

    public Object read(InputNode inputNode, Object obj) throws Exception {
        Collection collection = (Collection) obj;
        return collection != null ? read(inputNode, collection) : read(inputNode);
    }

    private Object read(InputNode inputNode, Collection collection) throws Exception {
        InputNode parent = inputNode.getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            Object read = this.root.read(inputNode);
            if (read != null) {
                collection.add(read);
            }
            inputNode = parent.getNext(name);
        }
        return collection;
    }
}
