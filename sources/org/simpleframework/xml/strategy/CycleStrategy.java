package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CycleStrategy implements Strategy {
    private final Contract contract;
    private final ReadState read;
    private final WriteState write;

    public CycleStrategy() {
        this("id", "reference");
    }

    public Value read(Type type, NodeMap nodeMap, Map map) throws Exception {
        ReadGraph find = this.read.find(map);
        if (find != null) {
            return find.read(type, nodeMap);
        }
        return null;
    }

    public boolean write(Type type, Object obj, NodeMap nodeMap, Map map) {
        WriteGraph find = this.write.find(map);
        if (find != null) {
            return find.write(type, obj, nodeMap);
        }
        return false;
    }

    public CycleStrategy(String str, String str2) {
        this(str, str2, "class");
    }

    public CycleStrategy(String str, String str2, String str3) {
        this(str, str2, str3, "length");
    }

    public CycleStrategy(String str, String str2, String str3, String str4) {
        Contract contract = new Contract(str, str2, str3, str4);
        this.contract = contract;
        this.write = new WriteState(contract);
        this.read = new ReadState(contract);
    }
}
