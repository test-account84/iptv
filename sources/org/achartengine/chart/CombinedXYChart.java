package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.Serializable;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CombinedXYChart extends XYChart {
    private XYCombinedChartDef[] chartDefinitions;
    private XYChart[] mCharts;
    private Class[] xyChartTypes;

    public static class XYCombinedChartDef implements Serializable {
        private int[] seriesIndex;
        private String type;

        public XYCombinedChartDef(String str, int... iArr) {
            this.type = str;
            this.seriesIndex = iArr;
        }

        public boolean containsSeries(int i) {
            return getChartSeriesIndex(i) >= 0;
        }

        public int getChartSeriesIndex(int i) {
            for (int i2 = 0; i2 < getSeriesIndex().length; i2++) {
                if (this.seriesIndex[i2] == i) {
                    return i2;
                }
            }
            return -1;
        }

        public int[] getSeriesIndex() {
            return this.seriesIndex;
        }

        public String getType() {
            return this.type;
        }
    }

    public CombinedXYChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, XYCombinedChartDef[] xYCombinedChartDefArr) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.xyChartTypes = new Class[]{TimeChart.class, LineChart.class, CubicLineChart.class, BarChart.class, BubbleChart.class, ScatterChart.class, RangeBarChart.class, RangeStackedBarChart.class};
        this.chartDefinitions = xYCombinedChartDefArr;
        int length = xYCombinedChartDefArr.length;
        this.mCharts = new XYChart[length];
        for (int i = 0; i < length; i++) {
            try {
                this.mCharts[i] = getXYChart(xYCombinedChartDefArr[i].getType());
            } catch (Exception unused) {
            }
            if (this.mCharts[i] == null) {
                throw new IllegalArgumentException("Unknown chart type " + xYCombinedChartDefArr[i].getType());
            }
            XYMultipleSeriesDataset xYMultipleSeriesDataset2 = new XYMultipleSeriesDataset();
            XYMultipleSeriesRenderer xYMultipleSeriesRenderer2 = new XYMultipleSeriesRenderer();
            for (int i2 : xYCombinedChartDefArr[i].getSeriesIndex()) {
                xYMultipleSeriesDataset2.addSeries(xYMultipleSeriesDataset.getSeriesAt(i2));
                xYMultipleSeriesRenderer2.addSeriesRenderer(xYMultipleSeriesRenderer.getSeriesRendererAt(i2));
            }
            xYMultipleSeriesRenderer2.setBarSpacing(xYMultipleSeriesRenderer.getBarSpacing());
            xYMultipleSeriesRenderer2.setPointSize(xYMultipleSeriesRenderer.getPointSize());
            this.mCharts[i].setDatasetRenderer(xYMultipleSeriesDataset2, xYMultipleSeriesRenderer2);
        }
    }

    private int getChartSeriesIndex(int i) {
        int i2 = 0;
        while (true) {
            XYCombinedChartDef[] xYCombinedChartDefArr = this.chartDefinitions;
            if (i2 >= xYCombinedChartDefArr.length) {
                throw new IllegalArgumentException("Unknown series with index " + i);
            }
            if (xYCombinedChartDefArr[i2].containsSeries(i)) {
                return this.chartDefinitions[i2].getChartSeriesIndex(i);
            }
            i2++;
        }
    }

    private XYChart getXYChart(int i) {
        int i2 = 0;
        while (true) {
            XYCombinedChartDef[] xYCombinedChartDefArr = this.chartDefinitions;
            if (i2 >= xYCombinedChartDefArr.length) {
                throw new IllegalArgumentException("Unknown series with index " + i);
            }
            if (xYCombinedChartDefArr[i2].containsSeries(i)) {
                return this.mCharts[i2];
            }
            i2++;
        }
    }

    public ClickableArea[] clickableAreasForPoints(List list, List list2, float f, int i, int i2) {
        return getXYChart(i).clickableAreasForPoints(list, list2, f, getChartSeriesIndex(i), i2);
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        getXYChart(i).drawLegendShape(canvas, simpleSeriesRenderer, f, f2, getChartSeriesIndex(i), paint);
    }

    public void drawSeries(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        XYChart xYChart = getXYChart(i);
        xYChart.setScreenR(getScreenR());
        xYChart.setCalcRange(getCalcRange(this.mDataset.getSeriesAt(i).getScaleNumber()), 0);
        xYChart.drawSeries(canvas, paint, list, xYSeriesRenderer, f, getChartSeriesIndex(i), i2);
    }

    public String getChartType() {
        return "Combined";
    }

    public int getLegendShapeWidth(int i) {
        return getXYChart(i).getLegendShapeWidth(getChartSeriesIndex(i));
    }

    public CombinedXYChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, XYCombinedChartDef[] xYCombinedChartDefArr, XYChart[] xYChartArr) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.xyChartTypes = new Class[]{TimeChart.class, LineChart.class, CubicLineChart.class, BarChart.class, BubbleChart.class, ScatterChart.class, RangeBarChart.class, RangeStackedBarChart.class};
        this.chartDefinitions = xYCombinedChartDefArr;
        this.mCharts = xYChartArr;
    }

    private XYChart getXYChart(String str) throws IllegalAccessException, InstantiationException {
        int length = this.xyChartTypes.length;
        XYChart xYChart = null;
        for (int i = 0; i < length && xYChart == null; i++) {
            XYChart xYChart2 = (XYChart) this.xyChartTypes[i].newInstance();
            if (str.equals(xYChart2.getChartType())) {
                xYChart = xYChart2;
            }
        }
        return xYChart;
    }

    public void drawSeries(XYSeries xYSeries, Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, XYMultipleSeriesRenderer.Orientation orientation, int i2) {
        XYChart xYChart = getXYChart(i);
        xYChart.setScreenR(getScreenR());
        xYChart.setCalcRange(getCalcRange(this.mDataset.getSeriesAt(i).getScaleNumber()), 0);
        xYChart.drawSeries(xYSeries, canvas, paint, list, xYSeriesRenderer, f, getChartSeriesIndex(i), orientation, i2);
    }
}
