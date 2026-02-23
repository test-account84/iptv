package org.achartengine.renderer;

import java.io.Serializable;
import java.text.NumberFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SimpleSeriesRenderer implements Serializable {
    private NumberFormat mChartValuesFormat;
    private int mGradientStartColor;
    private double mGradientStartValue;
    private int mGradientStopColor;
    private double mGradientStopValue;
    private boolean mHighlighted;
    private BasicStroke mStroke;
    private int mColor = -16776961;
    private boolean mGradientEnabled = false;
    private boolean mShowLegendItem = true;
    private boolean mDisplayBoundingPoints = true;

    public NumberFormat getChartValuesFormat() {
        return this.mChartValuesFormat;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getGradientStartColor() {
        return this.mGradientStartColor;
    }

    public double getGradientStartValue() {
        return this.mGradientStartValue;
    }

    public int getGradientStopColor() {
        return this.mGradientStopColor;
    }

    public double getGradientStopValue() {
        return this.mGradientStopValue;
    }

    public BasicStroke getStroke() {
        return this.mStroke;
    }

    public boolean isDisplayBoundingPoints() {
        return this.mDisplayBoundingPoints;
    }

    public boolean isGradientEnabled() {
        return this.mGradientEnabled;
    }

    public boolean isHighlighted() {
        return this.mHighlighted;
    }

    public boolean isShowLegendItem() {
        return this.mShowLegendItem;
    }

    public void setChartValuesFormat(NumberFormat numberFormat) {
        this.mChartValuesFormat = numberFormat;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void setDisplayBoundingPoints(boolean z) {
        this.mDisplayBoundingPoints = z;
    }

    public void setGradientEnabled(boolean z) {
        this.mGradientEnabled = z;
    }

    public void setGradientStart(double d, int i) {
        this.mGradientStartValue = d;
        this.mGradientStartColor = i;
    }

    public void setGradientStop(double d, int i) {
        this.mGradientStopValue = d;
        this.mGradientStopColor = i;
    }

    public void setHighlighted(boolean z) {
        this.mHighlighted = z;
    }

    public void setShowLegendItem(boolean z) {
        this.mShowLegendItem = z;
    }

    public void setStroke(BasicStroke basicStroke) {
        this.mStroke = basicStroke;
    }
}
