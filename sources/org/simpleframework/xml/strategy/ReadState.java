package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ReadState extends WeakCache {
    private final Contract contract;
    private final Loader loader = new Loader();

    public ReadState(Contract contract) {
        this.contract = contract;
    }

    private ReadGraph create(Object obj) throws Exception {
        ReadGraph readGraph = (ReadGraph) fetch(obj);
        if (readGraph != null) {
            return readGraph;
        }
        ReadGraph readGraph2 = new ReadGraph(this.contract, this.loader);
        cache(obj, readGraph2);
        return readGraph2;
    }

    public ReadGraph find(Object obj) throws Exception {
        ReadGraph readGraph = (ReadGraph) fetch(obj);
        return readGraph != null ? readGraph : create(obj);
    }
}
