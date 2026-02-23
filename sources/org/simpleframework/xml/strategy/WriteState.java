package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class WriteState extends WeakCache {
    private Contract contract;

    public WriteState(Contract contract) {
        this.contract = contract;
    }

    public WriteGraph find(Object obj) {
        WriteGraph writeGraph = (WriteGraph) fetch(obj);
        if (writeGraph != null) {
            return writeGraph;
        }
        WriteGraph writeGraph2 = new WriteGraph(this.contract);
        cache(obj, writeGraph2);
        return writeGraph2;
    }
}
