package org.achartengine.renderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DialRenderer extends DefaultRenderer {
    private double mAngleMin = 330.0d;
    private double mAngleMax = 30.0d;
    private double mMinValue = Double.MAX_VALUE;
    private double mMaxValue = -1.7976931348623157E308d;
    private double mMinorTickSpacing = Double.MAX_VALUE;
    private double mMajorTickSpacing = Double.MAX_VALUE;
    private List mVisualTypes = new ArrayList();

    public enum Type {
        NEEDLE,
        ARROW
    }

    public double getAngleMax() {
        return this.mAngleMax;
    }

    public double getAngleMin() {
        return this.mAngleMin;
    }

    public double getMajorTicksSpacing() {
        return this.mMajorTickSpacing;
    }

    public double getMaxValue() {
        return this.mMaxValue;
    }

    public double getMinValue() {
        return this.mMinValue;
    }

    public double getMinorTicksSpacing() {
        return this.mMinorTickSpacing;
    }

    public Type getVisualTypeForIndex(int i) {
        return i < this.mVisualTypes.size() ? (Type) this.mVisualTypes.get(i) : Type.NEEDLE;
    }

    public boolean isMaxValueSet() {
        return this.mMaxValue != -1.7976931348623157E308d;
    }

    public boolean isMinValueSet() {
        return this.mMinValue != Double.MAX_VALUE;
    }

    public void setAngleMax(double d) {
        this.mAngleMax = d;
    }

    public void setAngleMin(double d) {
        this.mAngleMin = d;
    }

    public void setMajorTicksSpacing(double d) {
        this.mMajorTickSpacing = d;
    }

    public void setMaxValue(double d) {
        this.mMaxValue = d;
    }

    public void setMinValue(double d) {
        this.mMinValue = d;
    }

    public void setMinorTicksSpacing(double d) {
        this.mMinorTickSpacing = d;
    }

    public void setVisualTypes(Type[] typeArr) {
        this.mVisualTypes.clear();
        this.mVisualTypes.addAll(Arrays.asList(typeArr));
    }
}
