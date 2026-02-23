package org.simpleframework.xml.core;

import java.util.Collections;
import java.util.Map;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class CompositeMapUnion implements Repeater {
    private final Context context;
    private final LabelMap elements;
    private final Group group;
    private final Expression path;
    private final Style style;
    private final Type type;

    public CompositeMapUnion(Context context, Group group, Expression expression, Type type) throws Exception {
        this.elements = group.getElements();
        this.style = context.getStyle();
        this.context = context;
        this.group = group;
        this.type = type;
        this.path = expression;
    }

    public Object read(InputNode inputNode) throws Exception {
        return ((Label) this.elements.get(this.path.getElement(inputNode.getName()))).getConverter(this.context).read(inputNode);
    }

    public boolean validate(InputNode inputNode) throws Exception {
        return ((Label) this.elements.get(this.path.getElement(inputNode.getName()))).getConverter(this.context).validate(inputNode);
    }

    public void write(OutputNode outputNode, Object obj) throws Exception {
        Map map = (Map) obj;
        if (!this.group.isInline() || !map.isEmpty()) {
            write(outputNode, map);
        } else {
            if (outputNode.isCommitted()) {
                return;
            }
            outputNode.remove();
        }
    }

    private void write(OutputNode outputNode, Object obj, Object obj2, Label label) throws Exception {
        Converter converter = label.getConverter(this.context);
        Map singletonMap = Collections.singletonMap(obj, obj2);
        if (!label.isInline()) {
            String element = this.style.getElement(label.getName());
            if (!outputNode.isCommitted()) {
                outputNode.setName(element);
            }
        }
        converter.write(outputNode, singletonMap);
    }

    public Object read(InputNode inputNode, Object obj) throws Exception {
        return ((Label) this.elements.get(this.path.getElement(inputNode.getName()))).getConverter(this.context).read(inputNode, obj);
    }

    private void write(OutputNode outputNode, Map map) throws Exception {
        for (Object obj : map.keySet()) {
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                Class cls = obj2.getClass();
                Label label = this.group.getLabel(cls);
                if (label == null) {
                    throw new UnionException("Value of %s not declared in %s with annotation %s", cls, this.type, this.group);
                }
                write(outputNode, obj, obj2, label);
            }
        }
    }
}
