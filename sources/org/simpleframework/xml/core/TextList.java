package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class TextList implements Repeater {
    private final CollectionFactory factory;
    private final Primitive primitive;
    private final Type type;

    public TextList(Context context, Type type, Label label) {
        ClassType classType = new ClassType(String.class);
        this.type = classType;
        this.factory = new CollectionFactory(context, type);
        this.primitive = new Primitive(context, classType);
    }

    public Object read(InputNode inputNode) throws Exception {
        Instance collectionFactory = this.factory.getInstance(inputNode);
        return collectionFactory.isReference() ? collectionFactory.getInstance() : read(inputNode, collectionFactory.getInstance());
    }

    public boolean validate(InputNode inputNode) throws Exception {
        return true;
    }

    public void write(OutputNode outputNode, Object obj) throws Exception {
        OutputNode parent = outputNode.getParent();
        Iterator it = ((Collection) obj).iterator();
        while (it.hasNext()) {
            this.primitive.write(parent, it.next());
        }
    }

    public Object read(InputNode inputNode, Object obj) throws Exception {
        Collection collection = (Collection) obj;
        Object read = this.primitive.read(inputNode);
        if (read != null) {
            collection.add(read);
        }
        return obj;
    }
}
