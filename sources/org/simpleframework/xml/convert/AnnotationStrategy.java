package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AnnotationStrategy implements Strategy {
    private final ConverterScanner scanner;
    private final Strategy strategy;

    public AnnotationStrategy() {
        this(new TreeStrategy());
    }

    private boolean isReference(Value value) {
        return value != null && value.isReference();
    }

    private boolean write(Type type, Object obj, NodeMap nodeMap) throws Exception {
        Converter converter = this.scanner.getConverter(type, obj);
        OutputNode outputNode = (OutputNode) nodeMap.getNode();
        if (converter == null) {
            return false;
        }
        converter.write(outputNode, obj);
        return true;
    }

    public Value read(Type type, NodeMap nodeMap, Map map) throws Exception {
        Value read = this.strategy.read(type, nodeMap, map);
        return isReference(read) ? read : read(type, nodeMap, read);
    }

    public AnnotationStrategy(Strategy strategy) {
        this.scanner = new ConverterScanner();
        this.strategy = strategy;
    }

    private Value read(Type type, NodeMap nodeMap, Value value) throws Exception {
        Converter converter = this.scanner.getConverter(type, value);
        InputNode inputNode = (InputNode) nodeMap.getNode();
        if (converter == null) {
            return value;
        }
        Object read = converter.read(inputNode);
        Class type2 = type.getType();
        if (value != null) {
            value.setValue(read);
        }
        return new Reference(value, read, type2);
    }

    public boolean write(Type type, Object obj, NodeMap nodeMap, Map map) throws Exception {
        boolean write = this.strategy.write(type, obj, nodeMap, map);
        return !write ? write(type, obj, nodeMap) : write;
    }
}
