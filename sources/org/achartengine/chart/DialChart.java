package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DialRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DialChart extends RoundChart {
    private static final int NEEDLE_RADIUS = 10;
    private DialRenderer mRenderer;

    public DialChart(CategorySeries categorySeries, DialRenderer dialRenderer) {
        super(categorySeries, dialRenderer);
        this.mRenderer = dialRenderer;
    }

    private void drawNeedle(Canvas canvas, double d, int i, int i2, double d2, boolean z, Paint paint) {
        float[] fArr;
        double radians = d - Math.toRadians(90.0d);
        int sin = (int) (Math.sin(radians) * 10.0d);
        int cos = (int) (Math.cos(radians) * 10.0d);
        int sin2 = ((int) (Math.sin(d) * d2)) + i;
        int cos2 = ((int) (Math.cos(d) * d2)) + i2;
        if (z) {
            double d3 = 0.85d * d2;
            int sin3 = ((int) (d3 * Math.sin(d))) + i;
            int cos3 = ((int) (d3 * Math.cos(d))) + i2;
            float f = sin2;
            float f2 = cos2;
            fArr = new float[]{sin3 - sin, cos3 - cos, f, f2, sin3 + sin, cos3 + cos};
            float strokeWidth = paint.getStrokeWidth();
            paint.setStrokeWidth(5.0f);
            canvas.drawLine(i, i2, f, f2, paint);
            paint.setStrokeWidth(strokeWidth);
        } else {
            fArr = new float[]{i - sin, i2 - cos, sin2, cos2, i + sin, i2 + cos};
        }
        drawPath(canvas, fArr, paint, true);
    }

    private void drawTicks(Canvas canvas, double d, double d2, double d3, double d4, int i, int i2, double d5, double d6, double d7, Paint paint, boolean z) {
        double d8 = d;
        while (d8 <= d2) {
            double angleForValue = getAngleForValue(d8, d3, d4, d, d2);
            double sin = Math.sin(angleForValue);
            double cos = Math.cos(angleForValue);
            float f = i;
            int round = Math.round(((float) (d6 * sin)) + f);
            float f2 = i2;
            int round2 = Math.round(((float) (d6 * cos)) + f2);
            int round3 = Math.round(f + ((float) (sin * d5)));
            int round4 = Math.round(f2 + ((float) (cos * d5)));
            float f3 = round;
            float f4 = round2;
            double d9 = d8;
            canvas.drawLine(f3, f4, round3, round4, paint);
            if (z) {
                paint.setTextAlign(Paint.Align.LEFT);
                if (round <= round3) {
                    paint.setTextAlign(Paint.Align.RIGHT);
                }
                String str = d9 + "";
                long j = (long) d9;
                if (Math.round(d9) == j) {
                    str = j + "";
                }
                canvas.drawText(str, f3, f4, paint);
            }
            d8 = d9 + d7;
        }
    }

    private double getAngleForValue(double d, double d2, double d3, double d4, double d5) {
        return Math.toRadians(d2 + (((d - d4) * (d3 - d2)) / (d5 - d4)));
    }

    public void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        paint.setAntiAlias(this.mRenderer.isAntialiasing());
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(this.mRenderer.getLabelsTextSize());
        int legendSize = getLegendSize(this.mRenderer, i4 / 5, 0.0f);
        int i5 = i + i3;
        int itemCount = this.mDataset.getItemCount();
        String[] strArr = new String[itemCount];
        for (int i6 = 0; i6 < itemCount; i6++) {
            strArr[i6] = this.mDataset.getCategory(i6);
        }
        int drawLegend = this.mRenderer.isFitLegend() ? drawLegend(canvas, this.mRenderer, strArr, i, i5, i2, i3, i4, legendSize, paint, true) : legendSize;
        int i7 = (i2 + i4) - drawLegend;
        drawBackground(this.mRenderer, canvas, i, i2, i3, i4, paint, false, 0);
        int min = (int) (Math.min(Math.abs(i5 - i), Math.abs(i7 - i2)) * 0.35d * this.mRenderer.getScale());
        if (this.mCenterX == Integer.MAX_VALUE) {
            this.mCenterX = (i + i5) / 2;
        }
        if (this.mCenterY == Integer.MAX_VALUE) {
            this.mCenterY = (i7 + i2) / 2;
        }
        float f = min;
        float f2 = f * 0.9f;
        float f3 = f * 1.1f;
        double minValue = this.mRenderer.getMinValue();
        double maxValue = this.mRenderer.getMaxValue();
        double angleMin = this.mRenderer.getAngleMin();
        double angleMax = this.mRenderer.getAngleMax();
        if (!this.mRenderer.isMinValueSet() || !this.mRenderer.isMaxValueSet()) {
            int seriesRendererCount = this.mRenderer.getSeriesRendererCount();
            for (int i8 = 0; i8 < seriesRendererCount; i8++) {
                double value = this.mDataset.getValue(i8);
                if (!this.mRenderer.isMinValueSet()) {
                    minValue = Math.min(minValue, value);
                }
                if (!this.mRenderer.isMaxValueSet()) {
                    maxValue = Math.max(maxValue, value);
                }
            }
        }
        if (minValue == maxValue) {
            minValue *= 0.5d;
            maxValue *= 1.5d;
        }
        double d = minValue;
        double d2 = maxValue;
        paint.setColor(this.mRenderer.getLabelsColor());
        double minorTicksSpacing = this.mRenderer.getMinorTicksSpacing();
        double majorTicksSpacing = this.mRenderer.getMajorTicksSpacing();
        if (minorTicksSpacing == Double.MAX_VALUE) {
            minorTicksSpacing = (d2 - d) / 30.0d;
        }
        double d3 = minorTicksSpacing;
        double d4 = majorTicksSpacing == Double.MAX_VALUE ? (d2 - d) / 10.0d : majorTicksSpacing;
        double d5 = f3;
        drawTicks(canvas, d, d2, angleMin, angleMax, this.mCenterX, this.mCenterY, d5, min, d3, paint, false);
        double d6 = f2;
        drawTicks(canvas, d, d2, angleMin, angleMax, this.mCenterX, this.mCenterY, d5, d6, d4, paint, true);
        int seriesRendererCount2 = this.mRenderer.getSeriesRendererCount();
        for (int i9 = 0; i9 < seriesRendererCount2; i9++) {
            double angleForValue = getAngleForValue(this.mDataset.getValue(i9), angleMin, angleMax, d, d2);
            paint.setColor(this.mRenderer.getSeriesRendererAt(i9).getColor());
            drawNeedle(canvas, angleForValue, this.mCenterX, this.mCenterY, d6, this.mRenderer.getVisualTypeForIndex(i9) == DialRenderer.Type.ARROW, paint);
        }
        drawLegend(canvas, this.mRenderer, strArr, i, i5, i2, i3, i4, drawLegend, paint, false);
        drawTitle(canvas, i, i2, i3, paint);
    }
}
