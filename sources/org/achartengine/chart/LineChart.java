package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LineChart extends XYChart {
    private static final int SHAPE_WIDTH = 30;
    public static final String TYPE = "Line";
    private ScatterChart pointsChart;

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type;

        static {
            int[] iArr = new int[XYSeriesRenderer.FillOutsideLine.Type.values().length];
            $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type = iArr;
            try {
                iArr[XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.BELOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.ABOVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LineChart() {
    }

    public ClickableArea[] clickableAreasForPoints(List list, List list2, float f, int i, int i2) {
        int size = list.size();
        ClickableArea[] clickableAreaArr = new ClickableArea[size / 2];
        for (int i3 = 0; i3 < size; i3 += 2) {
            float selectableBuffer = this.mRenderer.getSelectableBuffer();
            int i4 = i3 + 1;
            clickableAreaArr[i3 / 2] = new ClickableArea(new RectF(((Float) list.get(i3)).floatValue() - selectableBuffer, ((Float) list.get(i4)).floatValue() - selectableBuffer, ((Float) list.get(i3)).floatValue() + selectableBuffer, ((Float) list.get(i4)).floatValue() + selectableBuffer), ((Double) list2.get(i3)).doubleValue(), ((Double) list2.get(i4)).doubleValue());
        }
        return clickableAreaArr;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        float strokeWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(((XYSeriesRenderer) simpleSeriesRenderer).getLineWidth());
        canvas.drawLine(f, f2, f + 30.0f, f2, paint);
        paint.setStrokeWidth(strokeWidth);
        if (isRenderPoints(simpleSeriesRenderer)) {
            this.pointsChart.drawLegendShape(canvas, simpleSeriesRenderer, f + 5.0f, f2, i, paint);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawSeries(android.graphics.Canvas r22, android.graphics.Paint r23, java.util.List r24, org.achartengine.renderer.XYSeriesRenderer r25, float r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.achartengine.chart.LineChart.drawSeries(android.graphics.Canvas, android.graphics.Paint, java.util.List, org.achartengine.renderer.XYSeriesRenderer, float, int, int):void");
    }

    public String getChartType() {
        return "Line";
    }

    public int getLegendShapeWidth(int i) {
        return 30;
    }

    public ScatterChart getPointsChart() {
        return this.pointsChart;
    }

    public boolean isRenderPoints(SimpleSeriesRenderer simpleSeriesRenderer) {
        return ((XYSeriesRenderer) simpleSeriesRenderer).getPointStyle() != PointStyle.POINT;
    }

    public void setDatasetRenderer(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super.setDatasetRenderer(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.pointsChart = new ScatterChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
    }

    public LineChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.pointsChart = new ScatterChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
    }
}
