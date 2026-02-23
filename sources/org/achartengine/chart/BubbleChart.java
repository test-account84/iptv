package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYValueSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BubbleChart extends XYChart {
    private static final int MAX_BUBBLE_SIZE = 20;
    private static final int MIN_BUBBLE_SIZE = 2;
    private static final int SHAPE_WIDTH = 10;
    public static final String TYPE = "Bubble";

    public BubbleChart() {
    }

    private void drawCircle(Canvas canvas, Paint paint, float f, float f2, float f3) {
        canvas.drawCircle(f, f2, f3, paint);
    }

    public ClickableArea[] clickableAreasForPoints(List list, List list2, float f, int i, int i2) {
        int size = list.size();
        XYValueSeries xYValueSeries = (XYValueSeries) this.mDataset.getSeriesAt(i);
        double maxValue = 20.0d / xYValueSeries.getMaxValue();
        ClickableArea[] clickableAreaArr = new ClickableArea[size / 2];
        for (int i3 = 0; i3 < size; i3 += 2) {
            int i4 = i3 / 2;
            float value = (float) ((xYValueSeries.getValue(i2 + i4) * maxValue) + 2.0d);
            int i5 = i3 + 1;
            clickableAreaArr[i4] = new ClickableArea(new RectF(((Float) list.get(i3)).floatValue() - value, ((Float) list.get(i5)).floatValue() - value, ((Float) list.get(i3)).floatValue() + value, ((Float) list.get(i5)).floatValue() + value), ((Double) list2.get(i3)).doubleValue(), ((Double) list2.get(i5)).doubleValue());
        }
        return clickableAreaArr;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        drawCircle(canvas, paint, f + 10.0f, f2, 3.0f);
    }

    public void drawSeries(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.FILL);
        int size = list.size();
        XYValueSeries xYValueSeries = (XYValueSeries) this.mDataset.getSeriesAt(i);
        double maxValue = 20.0d / xYValueSeries.getMaxValue();
        for (int i3 = 0; i3 < size; i3 += 2) {
            drawCircle(canvas, paint, ((Float) list.get(i3)).floatValue(), ((Float) list.get(i3 + 1)).floatValue(), (float) ((xYValueSeries.getValue(i2 + (i3 / 2)) * maxValue) + 2.0d));
        }
    }

    public String getChartType() {
        return "Bubble";
    }

    public int getLegendShapeWidth(int i) {
        return 10;
    }

    public BubbleChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
    }
}
