package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import java.util.ArrayList;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PieChart extends RoundChart {
    private PieMapper mPieMapper;

    public PieChart(CategorySeries categorySeries, DefaultRenderer defaultRenderer) {
        super(categorySeries, defaultRenderer);
        this.mPieMapper = new PieMapper();
    }

    public void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        int i5;
        float f;
        float f2;
        int i6;
        float f3;
        float f4;
        int i7;
        PieChart pieChart = this;
        Paint paint2 = paint;
        paint2.setAntiAlias(pieChart.mRenderer.isAntialiasing());
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextSize(pieChart.mRenderer.getLabelsTextSize());
        int legendSize = pieChart.getLegendSize(pieChart.mRenderer, i4 / 5, 0.0f);
        int i8 = i + i3;
        int itemCount = pieChart.mDataset.getItemCount();
        String[] strArr = new String[itemCount];
        double d = 0.0d;
        for (int i9 = 0; i9 < itemCount; i9++) {
            d += pieChart.mDataset.getValue(i9);
            strArr[i9] = pieChart.mDataset.getCategory(i9);
        }
        int drawLegend = pieChart.mRenderer.isFitLegend() ? drawLegend(canvas, pieChart.mRenderer, strArr, i, i8, i2, i3, i4, legendSize, paint, true) : legendSize;
        int i10 = (i2 + i4) - drawLegend;
        drawBackground(pieChart.mRenderer, canvas, i, i2, i3, i4, paint, false, 0);
        float startAngle = pieChart.mRenderer.getStartAngle();
        int min = (int) (Math.min(Math.abs(i8 - i), Math.abs(i10 - i2)) * 0.35d * pieChart.mRenderer.getScale());
        if (pieChart.mCenterX == Integer.MAX_VALUE) {
            pieChart.mCenterX = (i + i8) / 2;
        }
        if (pieChart.mCenterY == Integer.MAX_VALUE) {
            pieChart.mCenterY = (i10 + i2) / 2;
        }
        pieChart.mPieMapper.setDimensions(min, pieChart.mCenterX, pieChart.mCenterY);
        boolean z = !pieChart.mPieMapper.areAllSegmentPresent(itemCount);
        if (z) {
            pieChart.mPieMapper.clearPieSegments();
        }
        float f5 = min;
        float f6 = f5 * 0.9f;
        float f7 = f5 * 1.1f;
        int i11 = pieChart.mCenterX;
        int i12 = pieChart.mCenterY;
        RectF rectF = new RectF(i11 - min, i12 - min, i11 + min, i12 + min);
        ArrayList arrayList = new ArrayList();
        float f8 = startAngle;
        int i13 = 0;
        while (i13 < itemCount) {
            SimpleSeriesRenderer seriesRendererAt = pieChart.mRenderer.getSeriesRendererAt(i13);
            if (seriesRendererAt.isGradientEnabled()) {
                paint2.setShader(new RadialGradient(pieChart.mCenterX, pieChart.mCenterY, f7, seriesRendererAt.getGradientStartColor(), seriesRendererAt.getGradientStopColor(), Shader.TileMode.MIRROR));
            } else {
                paint2.setColor(seriesRendererAt.getColor());
            }
            float value = (float) pieChart.mDataset.getValue(i13);
            float f9 = (float) ((value / d) * 360.0d);
            if (seriesRendererAt.isHighlighted()) {
                double radians = Math.toRadians(90.0f - ((f9 / 2.0f) + f8));
                double d2 = min * 0.1d;
                i5 = i13;
                float sin = (float) (d2 * Math.sin(radians));
                float cos = (float) (d2 * Math.cos(radians));
                rectF.offset(sin, cos);
                f = f8;
                f2 = value;
                canvas.drawArc(rectF, f8, f9, true, paint);
                rectF.offset(-sin, -cos);
            } else {
                i5 = i13;
                f = f8;
                f2 = value;
                canvas.drawArc(rectF, f8, f9, true, paint);
            }
            paint2.setColor(seriesRendererAt.getColor());
            paint2.setShader((Shader) null);
            String category = pieChart.mDataset.getCategory(i5);
            DefaultRenderer defaultRenderer = pieChart.mRenderer;
            String[] strArr2 = strArr;
            int i14 = itemCount;
            int i15 = i5;
            float f10 = f2;
            RectF rectF2 = rectF;
            int i16 = min;
            drawLabel(canvas, category, defaultRenderer, arrayList, pieChart.mCenterX, pieChart.mCenterY, f6, f7, f, f9, i, i8, defaultRenderer.getLabelsColor(), paint, true, false);
            if (this.mRenderer.isDisplayValues()) {
                String label = getLabel(this.mRenderer.getSeriesRendererAt(i15).getChartValuesFormat(), this.mDataset.getValue(i15));
                DefaultRenderer defaultRenderer2 = this.mRenderer;
                i6 = i15;
                drawLabel(canvas, label, defaultRenderer2, arrayList, this.mCenterX, this.mCenterY, f6 / 2.0f, f7 / 2.0f, f, f9, i, i8, defaultRenderer2.getLabelsColor(), paint, false, true);
            } else {
                i6 = i15;
            }
            if (z) {
                f3 = f;
                f4 = f9;
                i7 = i6;
                this.mPieMapper.addPieSegment(i7, f10, f3, f4);
            } else {
                f3 = f;
                f4 = f9;
                i7 = i6;
            }
            f8 = f3 + f4;
            i13 = i7 + 1;
            pieChart = this;
            rectF = rectF2;
            strArr = strArr2;
            itemCount = i14;
            min = i16;
            paint2 = paint;
        }
        arrayList.clear();
        drawLegend(canvas, pieChart.mRenderer, strArr, i, i8, i2, i3, i4, drawLegend, paint, false);
        drawTitle(canvas, i, i2, i3, paint);
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point) {
        return this.mPieMapper.getSeriesAndPointForScreenCoordinate(point);
    }
}
