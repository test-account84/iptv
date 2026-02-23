package org.simpleframework.xml.strategy;

import org.simpleframework.xml.stream.NodeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Visitor {
    void read(Type type, NodeMap nodeMap) throws Exception;

    void write(Type type, NodeMap nodeMap) throws Exception;
}
