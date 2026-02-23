package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RangeBarChart extends BarChart {
    public static final String TYPE = "RangeBar";

    public RangeBarChart() {
    }

    public void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List list, int i, int i2) {
        int i3;
        int i4;
        int seriesCount = this.mDataset.getSeriesCount();
        float halfDiffX = getHalfDiffX(list, list.size(), seriesCount);
        for (int i5 = i2 > 0 ? 2 : 0; i5 < list.size(); i5 += 4) {
            int i6 = i2 + (i5 / 2);
            float floatValue = ((Float) list.get(i5)).floatValue();
            if (this.mType == BarChart.Type.DEFAULT) {
                floatValue += ((i * 2) * halfDiffX) - ((seriesCount - 1.5f) * halfDiffX);
            }
            float f = floatValue;
            int i7 = i6 + 1;
            if (!isNullValue(xYSeries.getY(i7)) && list.size() > (i4 = i5 + 3)) {
                drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i7)), f, ((Float) list.get(i4)).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, 0.0f);
            }
            if (!isNullValue(xYSeries.getY(i6)) && list.size() > (i3 = i5 + 1)) {
                drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i6)), f, ((((Float) list.get(i3)).floatValue() + xYSeriesRenderer.getChartValuesTextSize()) + xYSeriesRenderer.getChartValuesSpacing()) - 3.0f, paint, 0.0f);
            }
        }
    }

    public void drawSeries(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        int i3;
        int seriesCount = this.mDataset.getSeriesCount();
        int size = list.size();
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.FILL);
        float halfDiffX = getHalfDiffX(list, size, seriesCount);
        int i4 = i2 > 0 ? 2 : 0;
        while (i4 < size) {
            int i5 = i4 + 3;
            if (list.size() > i5) {
                i3 = i4;
                drawBar(canvas, ((Float) list.get(i4)).floatValue(), ((Float) list.get(i4 + 1)).floatValue(), ((Float) list.get(i4 + 2)).floatValue(), ((Float) list.get(i5)).floatValue(), halfDiffX, seriesCount, i, paint);
            } else {
                i3 = i4;
            }
            i4 = i3 + 4;
        }
        paint.setColor(xYSeriesRenderer.getColor());
    }

    public String getChartType() {
        return "RangeBar";
    }

    public float getCoeficient() {
        return 0.5f;
    }

    public RangeBarChart(BarChart.Type type) {
        super(type);
    }

    public RangeBarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type);
    }
}
