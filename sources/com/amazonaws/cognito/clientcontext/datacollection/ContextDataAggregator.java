package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ContextDataAggregator {
    private final List dataCollectors;

    public static class InstanceHolder {
        private static final ContextDataAggregator INSTANCE = new ContextDataAggregator((1) null);

        private InstanceHolder() {
        }

        public static /* synthetic */ ContextDataAggregator access$100() {
            return INSTANCE;
        }
    }

    private ContextDataAggregator() {
        this.dataCollectors = getDataCollectors();
    }

    private List getDataCollectors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ApplicationDataCollector());
        arrayList.add(new BuildDataCollector());
        arrayList.add(new DeviceDataCollector());
        return arrayList;
    }

    public static ContextDataAggregator getInstance() {
        return InstanceHolder.access$100();
    }

    private void removerNullEntries(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.remove(entry.getKey());
            }
        }
    }

    public Map getAggregatedData(Context context) {
        HashMap hashMap = new HashMap();
        Iterator it = this.dataCollectors.iterator();
        while (it.hasNext()) {
            hashMap.putAll(((DataCollector) it.next()).collect(context));
        }
        removerNullEntries(hashMap);
        return hashMap;
    }

    public /* synthetic */ ContextDataAggregator(1 r1) {
        this();
    }

    public ContextDataAggregator(List list) {
        this.dataCollectors = list;
    }
}
