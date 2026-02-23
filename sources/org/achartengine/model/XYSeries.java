package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.achartengine.util.IndexXYMap;
import org.achartengine.util.XYEntry;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class XYSeries implements Serializable {
    private List mAnnotations;
    private double mMaxX;
    private double mMaxY;
    private double mMinX;
    private double mMinY;
    private final int mScaleNumber;
    private final IndexXYMap mStringXY;
    private String mTitle;
    private final IndexXYMap mXY;

    public XYSeries(String str) {
        this(str, 0);
    }

    private void initRange() {
        this.mMinX = Double.MAX_VALUE;
        this.mMaxX = -1.7976931348623157E308d;
        this.mMinY = Double.MAX_VALUE;
        this.mMaxY = -1.7976931348623157E308d;
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            updateRange(getX(i), getY(i));
        }
    }

    private void updateRange(double d, double d2) {
        this.mMinX = Math.min(this.mMinX, d);
        this.mMaxX = Math.max(this.mMaxX, d);
        this.mMinY = Math.min(this.mMinY, d2);
        this.mMaxY = Math.max(this.mMaxY, d2);
    }

    public synchronized void add(double d, double d2) {
        while (this.mXY.get(Double.valueOf(d)) != null) {
            try {
                d += getPadding(d);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mXY.put(Double.valueOf(d), Double.valueOf(d2));
        updateRange(d, d2);
    }

    public void addAnnotation(String str, double d, double d2) {
        this.mAnnotations.add(str);
        while (this.mStringXY.get(Double.valueOf(d)) != null) {
            d += getPadding(d);
        }
        this.mStringXY.put(Double.valueOf(d), Double.valueOf(d2));
    }

    public synchronized void clear() {
        clearAnnotations();
        clearSeriesValues();
    }

    public synchronized void clearAnnotations() {
        this.mAnnotations.clear();
        this.mStringXY.clear();
    }

    public synchronized void clearSeriesValues() {
        this.mXY.clear();
        initRange();
    }

    public String getAnnotationAt(int i) {
        return (String) this.mAnnotations.get(i);
    }

    public int getAnnotationCount() {
        return this.mAnnotations.size();
    }

    public double getAnnotationX(int i) {
        return ((Double) this.mStringXY.getXByIndex(i)).doubleValue();
    }

    public double getAnnotationY(int i) {
        return ((Double) this.mStringXY.getYByIndex(i)).doubleValue();
    }

    public int getIndexForKey(double d) {
        return this.mXY.getIndexForKey(Double.valueOf(d));
    }

    public synchronized int getItemCount() {
        return this.mXY.size();
    }

    public double getMaxX() {
        return this.mMaxX;
    }

    public double getMaxY() {
        return this.mMaxY;
    }

    public double getMinX() {
        return this.mMinX;
    }

    public double getMinY() {
        return this.mMinY;
    }

    public double getPadding(double d) {
        return Math.ulp(d);
    }

    public synchronized SortedMap getRange(double d, double d2, boolean z) {
        if (z) {
            try {
                SortedMap headMap = this.mXY.headMap(Double.valueOf(d));
                if (!headMap.isEmpty()) {
                    d = ((Double) headMap.lastKey()).doubleValue();
                }
                SortedMap tailMap = this.mXY.tailMap(Double.valueOf(d2));
                if (!tailMap.isEmpty()) {
                    Iterator it = tailMap.keySet().iterator();
                    d2 = it.hasNext() ? ((Double) it.next()).doubleValue() : d2 + ((Double) it.next()).doubleValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (d <= d2) {
            return this.mXY.subMap(Double.valueOf(d), Double.valueOf(d2));
        }
        return new TreeMap();
    }

    public int getScaleNumber() {
        return this.mScaleNumber;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public synchronized double getX(int i) {
        return ((Double) this.mXY.getXByIndex(i)).doubleValue();
    }

    public synchronized IndexXYMap getXYMap() {
        return this.mXY;
    }

    public synchronized double getY(int i) {
        return ((Double) this.mXY.getYByIndex(i)).doubleValue();
    }

    public synchronized void remove(int i) {
        try {
            XYEntry removeByIndex = this.mXY.removeByIndex(i);
            double doubleValue = ((Double) removeByIndex.getKey()).doubleValue();
            double doubleValue2 = ((Double) removeByIndex.getValue()).doubleValue();
            if (doubleValue == this.mMinX || doubleValue == this.mMaxX || doubleValue2 == this.mMinY || doubleValue2 == this.mMaxY) {
                initRange();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void removeAnnotation(int i) {
        this.mAnnotations.remove(i);
        this.mStringXY.removeByIndex(i);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public XYSeries(String str, int i) {
        this.mXY = new IndexXYMap();
        this.mMinX = Double.MAX_VALUE;
        this.mMaxX = -1.7976931348623157E308d;
        this.mMinY = Double.MAX_VALUE;
        this.mMaxY = -1.7976931348623157E308d;
        this.mAnnotations = new ArrayList();
        this.mStringXY = new IndexXYMap();
        this.mTitle = str;
        this.mScaleNumber = i;
        initRange();
    }

    public synchronized void add(int i, double d, double d2) {
        while (this.mXY.get(Double.valueOf(d)) != null) {
            try {
                d += getPadding(d);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mXY.put(i, Double.valueOf(d), Double.valueOf(d2));
        updateRange(d, d2);
    }
}
