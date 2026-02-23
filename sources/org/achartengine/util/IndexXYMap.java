package org.achartengine.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class IndexXYMap extends TreeMap {
    private final List indexList = new ArrayList();
    private double maxXDifference = 0.0d;

    private void updateMaxXDifference() {
        if (this.indexList.size() < 2) {
            this.maxXDifference = 0.0d;
            return;
        }
        double doubleValue = ((Double) this.indexList.get(r0.size() - 1)).doubleValue();
        List list = this.indexList;
        if (Math.abs(doubleValue - ((Double) list.get(list.size() - 2)).doubleValue()) > this.maxXDifference) {
            double doubleValue2 = ((Double) this.indexList.get(r0.size() - 1)).doubleValue();
            List list2 = this.indexList;
            this.maxXDifference = Math.abs(doubleValue2 - ((Double) list2.get(list2.size() - 2)).doubleValue());
        }
    }

    public void clear() {
        updateMaxXDifference();
        super.clear();
        this.indexList.clear();
    }

    public XYEntry getByIndex(int i) {
        Object obj = this.indexList.get(i);
        return new XYEntry(obj, get(obj));
    }

    public int getIndexForKey(Object obj) {
        return Collections.binarySearch(this.indexList, obj, (Comparator) null);
    }

    public double getMaxXDifference() {
        return this.maxXDifference;
    }

    public Object getXByIndex(int i) {
        return this.indexList.get(i);
    }

    public Object getYByIndex(int i) {
        return get(this.indexList.get(i));
    }

    public Object put(int i, Object obj, Object obj2) {
        this.indexList.add(i, obj);
        updateMaxXDifference();
        return super.put(obj, obj2);
    }

    public XYEntry removeByIndex(int i) {
        Object remove = this.indexList.remove(i);
        return new XYEntry(remove, remove(remove));
    }

    public Object put(Object obj, Object obj2) {
        this.indexList.add(obj);
        updateMaxXDifference();
        return super.put(obj, obj2);
    }
}
