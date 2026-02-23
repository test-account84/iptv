package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class RoundChart extends AbstractChart {
    protected static final int NO_VALUE = Integer.MAX_VALUE;
    protected static final int SHAPE_WIDTH = 10;
    protected int mCenterX = Integer.MAX_VALUE;
    protected int mCenterY = Integer.MAX_VALUE;
    protected CategorySeries mDataset;
    protected DefaultRenderer mRenderer;

    public RoundChart(CategorySeries categorySeries, DefaultRenderer defaultRenderer) {
        this.mDataset = categorySeries;
        this.mRenderer = defaultRenderer;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        canvas.drawRect(f, f2 - 5.0f, f + 10.0f, f2 + 5.0f, paint);
    }

    public void drawTitle(Canvas canvas, int i, int i2, int i3, Paint paint) {
        if (this.mRenderer.isShowLabels()) {
            paint.setColor(this.mRenderer.getLabelsColor());
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(this.mRenderer.getChartTitleTextSize());
            drawString(canvas, this.mRenderer.getChartTitle(), i + (i3 / 2), i2 + this.mRenderer.getChartTitleTextSize(), paint);
        }
    }

    public int getCenterX() {
        return this.mCenterX;
    }

    public int getCenterY() {
        return this.mCenterY;
    }

    public int getLegendShapeWidth(int i) {
        return 10;
    }

    public DefaultRenderer getRenderer() {
        return this.mRenderer;
    }

    public void setCenterX(int i) {
        this.mCenterX = i;
    }

    public void setCenterY(int i) {
        this.mCenterY = i;
    }
}
