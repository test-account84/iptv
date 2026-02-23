package org.achartengine.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Pan extends AbstractTool {
    private boolean limitsReachedX;
    private boolean limitsReachedY;
    private List mPanListeners;

    public Pan(AbstractChart abstractChart) {
        super(abstractChart);
        this.mPanListeners = new ArrayList();
        this.limitsReachedX = false;
        this.limitsReachedY = false;
    }

    private double getAxisRatio(double[] dArr) {
        return Math.abs(dArr[1] - dArr[0]) / Math.abs(dArr[3] - dArr[2]);
    }

    private synchronized void notifyPanListeners() {
        Iterator it = this.mPanListeners.iterator();
        while (it.hasNext()) {
            ((PanListener) it.next()).panApplied();
        }
    }

    public synchronized void addPanListener(PanListener panListener) {
        this.mPanListeners.add(panListener);
    }

    public void apply(float f, float f2, float f3, float f4) {
        int i;
        double[] dArr;
        XYChart xYChart;
        int i2;
        boolean z;
        boolean z2;
        AbstractChart abstractChart = this.mChart;
        if (abstractChart instanceof XYChart) {
            int scalesCount = this.mRenderer.getScalesCount();
            double[] panLimits = this.mRenderer.getPanLimits();
            char c = 0;
            boolean z3 = panLimits != null && panLimits.length == 4;
            XYChart xYChart2 = (XYChart) this.mChart;
            boolean z4 = true;
            boolean z5 = true;
            int i3 = 0;
            boolean z6 = true;
            boolean z7 = true;
            while (i3 < scalesCount) {
                double[] range = getRange(i3);
                double[] calcRange = xYChart2.getCalcRange(i3);
                if (this.limitsReachedX && this.limitsReachedY) {
                    if (range[c] == range[1] && calcRange[c] == calcRange[1]) {
                        return;
                    }
                    if (range[2] == range[3] && calcRange[2] == calcRange[3]) {
                        return;
                    }
                }
                checkRange(range, i3);
                double[] realPoint = xYChart2.toRealPoint(f, f2, i3);
                double[] realPoint2 = xYChart2.toRealPoint(f3, f4, i3);
                double d = realPoint[c] - realPoint2[c];
                double d2 = realPoint[1] - realPoint2[1];
                double axisRatio = getAxisRatio(range);
                if (xYChart2.isVertical(this.mRenderer)) {
                    double d3 = (-d2) * axisRatio;
                    d2 = d / axisRatio;
                    d = d3;
                }
                if (this.mRenderer.isPanXEnabled()) {
                    if (panLimits != null) {
                        if (z4) {
                            z4 = panLimits[0] <= range[0] + d;
                        }
                        if (z5) {
                            z5 = panLimits[1] >= range[1] + d;
                        }
                    }
                    z = z4;
                    z2 = z5;
                    if (!z3 || (z && z2)) {
                        double d4 = range[0] + d;
                        double d5 = range[1] + d;
                        i2 = scalesCount;
                        i = i3;
                        dArr = range;
                        xYChart = xYChart2;
                        setXRange(d4, d5, i);
                        this.limitsReachedX = false;
                    } else {
                        this.limitsReachedX = true;
                        i = i3;
                        dArr = range;
                        xYChart = xYChart2;
                        i2 = scalesCount;
                    }
                } else {
                    i = i3;
                    dArr = range;
                    xYChart = xYChart2;
                    i2 = scalesCount;
                    z = z4;
                    z2 = z5;
                }
                if (this.mRenderer.isPanYEnabled()) {
                    if (panLimits != null) {
                        if (z6) {
                            z6 = panLimits[2] <= dArr[2] + d2;
                        }
                        if (z7) {
                            z7 = panLimits[3] >= dArr[3] + d2;
                        }
                    }
                    if (!z3 || (z6 && z7)) {
                        setYRange(dArr[2] + d2, dArr[3] + d2, i);
                        this.limitsReachedY = false;
                    } else {
                        this.limitsReachedY = true;
                    }
                }
                i3 = i + 1;
                xYChart2 = xYChart;
                z4 = z;
                z5 = z2;
                scalesCount = i2;
                c = 0;
            }
        } else {
            RoundChart roundChart = (RoundChart) abstractChart;
            roundChart.setCenterX(roundChart.getCenterX() + ((int) (f3 - f)));
            roundChart.setCenterY(roundChart.getCenterY() + ((int) (f4 - f2)));
        }
        notifyPanListeners();
    }

    public synchronized void removePanListener(PanListener panListener) {
        this.mPanListeners.remove(panListener);
    }
}
