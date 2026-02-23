package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Strategy {
    Value read(Type type, NodeMap nodeMap, Map map) throws Exception;

    boolean write(Type type, Object obj, NodeMap nodeMap, Map map) throws Exception;
}
