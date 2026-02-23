package org.achartengine.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class XYValueSeries extends XYSeries {
    private double mMaxValue;
    private double mMinValue;
    private List mValue;

    public XYValueSeries(String str) {
        super(str);
        this.mValue = new ArrayList();
        this.mMinValue = Double.MAX_VALUE;
        this.mMaxValue = -1.7976931348623157E308d;
    }

    private void initRange() {
        this.mMinValue = Double.MAX_VALUE;
        this.mMaxValue = -1.7976931348623157E308d;
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            updateRange(getValue(i));
        }
    }

    private void updateRange(double d) {
        this.mMinValue = Math.min(this.mMinValue, d);
        this.mMaxValue = Math.max(this.mMaxValue, d);
    }

    public synchronized void add(double d, double d2) {
        add(d, d2, 0.0d);
    }

    public synchronized void clear() {
        super.clear();
        this.mValue.clear();
        initRange();
    }

    public double getMaxValue() {
        return this.mMaxValue;
    }

    public double getMinValue() {
        return this.mMinValue;
    }

    public synchronized double getValue(int i) {
        return ((Double) this.mValue.get(i)).doubleValue();
    }

    public synchronized void remove(int i) {
        try {
            super.remove(i);
            double doubleValue = ((Double) this.mValue.remove(i)).doubleValue();
            if (doubleValue == this.mMinValue || doubleValue == this.mMaxValue) {
                initRange();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void add(double d, double d2, double d3) {
        super.add(d, d2);
        this.mValue.add(Double.valueOf(d3));
        updateRange(d3);
    }
}
