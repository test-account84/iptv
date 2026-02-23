package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VisitorStrategy implements Strategy {
    private final Strategy strategy;
    private final Visitor visitor;

    public VisitorStrategy(Visitor visitor) {
        this(visitor, new TreeStrategy());
    }

    public Value read(Type type, NodeMap nodeMap, Map map) throws Exception {
        Visitor visitor = this.visitor;
        if (visitor != null) {
            visitor.read(type, nodeMap);
        }
        return this.strategy.read(type, nodeMap, map);
    }

    public boolean write(Type type, Object obj, NodeMap nodeMap, Map map) throws Exception {
        boolean write = this.strategy.write(type, obj, nodeMap, map);
        Visitor visitor = this.visitor;
        if (visitor != null) {
            visitor.write(type, nodeMap);
        }
        return write;
    }

    public VisitorStrategy(Visitor visitor, Strategy strategy) {
        this.strategy = strategy;
        this.visitor = visitor;
    }
}
