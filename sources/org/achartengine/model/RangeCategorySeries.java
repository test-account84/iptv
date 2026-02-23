package org.achartengine.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RangeCategorySeries extends CategorySeries {
    private List mMaxValues;

    public RangeCategorySeries(String str) {
        super(str);
        this.mMaxValues = new ArrayList();
    }

    public synchronized void add(double d, double d2) {
        super.add(d);
        this.mMaxValues.add(Double.valueOf(d2));
    }

    public synchronized void clear() {
        super.clear();
        this.mMaxValues.clear();
    }

    public double getMaximumValue(int i) {
        return ((Double) this.mMaxValues.get(i)).doubleValue();
    }

    public double getMinimumValue(int i) {
        return getValue(i);
    }

    public synchronized void remove(int i) {
        super.remove(i);
        this.mMaxValues.remove(i);
    }

    public XYSeries toXYSeries() {
        XYSeries xYSeries = new XYSeries(getTitle());
        int itemCount = getItemCount();
        int i = 0;
        while (i < itemCount) {
            int i2 = i + 1;
            xYSeries.add(i2, getMinimumValue(i));
            xYSeries.add(i + 1.000001d, getMaximumValue(i));
            i = i2;
        }
        return xYSeries;
    }

    public synchronized void add(String str, double d, double d2) {
        super.add(str, d);
        this.mMaxValues.add(Double.valueOf(d2));
    }
}
