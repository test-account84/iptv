package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CubicLineChart extends LineChart {
    public static final String TYPE = "Cubic";
    private float mFirstMultiplier;
    private PathMeasure mPathMeasure;
    private float mSecondMultiplier;

    public CubicLineChart() {
        this.mFirstMultiplier = 0.33f;
        this.mSecondMultiplier = 1.0f - 0.33f;
    }

    private void calc(List list, Point point, int i, int i2, float f) {
        float floatValue = ((Float) list.get(i)).floatValue();
        float floatValue2 = ((Float) list.get(i + 1)).floatValue();
        float floatValue3 = ((Float) list.get(i2)).floatValue();
        float floatValue4 = ((Float) list.get(i2 + 1)).floatValue() - floatValue2;
        point.setX(floatValue + ((floatValue3 - floatValue) * f));
        point.setY(floatValue2 + (floatValue4 * f));
    }

    public void drawPath(Canvas canvas, List list, Paint paint, boolean z) {
        Path path = new Path();
        path.moveTo(((Float) list.get(0)).floatValue(), ((Float) list.get(1)).floatValue());
        int size = list.size();
        if (z) {
            size -= 4;
        }
        int i = size;
        Point point = new Point();
        Point point2 = new Point();
        Point point3 = new Point();
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 2;
            int i4 = i3 < i ? i3 : i2;
            int i5 = i2 + 4;
            int i6 = i5 < i ? i5 : i4;
            calc(list, point, i2, i4, this.mSecondMultiplier);
            point2.setX(((Float) list.get(i4)).floatValue());
            point2.setY(((Float) list.get(i4 + 1)).floatValue());
            calc(list, point3, i4, i6, this.mFirstMultiplier);
            path.cubicTo(point.getX(), point.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY());
            point2 = point2;
            i = i;
            i2 = i3;
        }
        int i7 = i;
        this.mPathMeasure = new PathMeasure(path, false);
        if (z) {
            for (int i8 = i7; i8 < i7 + 4; i8 += 2) {
                path.lineTo(((Float) list.get(i8)).floatValue(), ((Float) list.get(i8 + 1)).floatValue());
            }
            path.lineTo(((Float) list.get(0)).floatValue(), ((Float) list.get(1)).floatValue());
        }
        canvas.drawPath(path, paint);
    }

    public void drawPoints(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        ScatterChart pointsChart;
        if (!isRenderPoints(xYSeriesRenderer) || (pointsChart = getPointsChart()) == null) {
            return;
        }
        int length = (int) this.mPathMeasure.getLength();
        int size = list.size();
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < length; i3++) {
            this.mPathMeasure.getPosTan(i3, fArr, (float[]) null);
            double d = Double.MAX_VALUE;
            boolean z = true;
            for (int i4 = 0; i4 < size && z; i4 += 2) {
                double abs = Math.abs(((Float) list.get(i4)).floatValue() - fArr[0]);
                if (abs < 1.0d) {
                    list.set(i4 + 1, Float.valueOf(fArr[1]));
                    d = abs;
                }
                z = d > abs;
            }
        }
        pointsChart.drawSeries(canvas, paint, list, xYSeriesRenderer, f, i, i2);
    }

    public String getChartType() {
        return "Cubic";
    }

    public CubicLineChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, float f) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.mFirstMultiplier = f;
        this.mSecondMultiplier = 1.0f - f;
    }
}
