package org.achartengine.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesSelection {
    private int mPointIndex;
    private int mSeriesIndex;
    private double mValue;
    private double mXValue;

    public SeriesSelection(int i, int i2, double d, double d2) {
        this.mSeriesIndex = i;
        this.mPointIndex = i2;
        this.mXValue = d;
        this.mValue = d2;
    }

    public int getPointIndex() {
        return this.mPointIndex;
    }

    public int getSeriesIndex() {
        return this.mSeriesIndex;
    }

    public double getValue() {
        return this.mValue;
    }

    public double getXValue() {
        return this.mXValue;
    }
}
