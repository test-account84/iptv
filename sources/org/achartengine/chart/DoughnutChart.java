package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import org.achartengine.model.MultipleCategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DoughnutChart extends RoundChart {
    private MultipleCategorySeries mDataset;
    private int mStep;

    public DoughnutChart(MultipleCategorySeries multipleCategorySeries, DefaultRenderer defaultRenderer) {
        super(null, defaultRenderer);
        this.mDataset = multipleCategorySeries;
    }

    public void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        Paint paint2;
        DoughnutChart doughnutChart = this;
        Paint paint3 = paint;
        paint3.setAntiAlias(doughnutChart.mRenderer.isAntialiasing());
        paint3.setStyle(Paint.Style.FILL);
        paint3.setTextSize(doughnutChart.mRenderer.getLabelsTextSize());
        int legendSize = doughnutChart.getLegendSize(doughnutChart.mRenderer, i4 / 5, 0.0f);
        int i5 = i + i3;
        int categoriesCount = doughnutChart.mDataset.getCategoriesCount();
        String[] strArr = new String[categoriesCount];
        for (int i6 = 0; i6 < categoriesCount; i6++) {
            strArr[i6] = doughnutChart.mDataset.getCategory(i6);
        }
        int drawLegend = doughnutChart.mRenderer.isFitLegend() ? drawLegend(canvas, doughnutChart.mRenderer, strArr, i, i5, i2, i3, i4, legendSize, paint, true) : legendSize;
        int i7 = (i2 + i4) - drawLegend;
        drawBackground(doughnutChart.mRenderer, canvas, i, i2, i3, i4, paint, false, 0);
        doughnutChart.mStep = 7;
        double d = 0.2d / categoriesCount;
        double min = Math.min(Math.abs(i5 - i), Math.abs(i7 - i2));
        int scale = (int) (doughnutChart.mRenderer.getScale() * 0.35d * min);
        if (doughnutChart.mCenterX == Integer.MAX_VALUE) {
            doughnutChart.mCenterX = (i + i5) / 2;
        }
        if (doughnutChart.mCenterY == Integer.MAX_VALUE) {
            doughnutChart.mCenterY = (i7 + i2) / 2;
        }
        float f = scale;
        float f2 = f * 1.1f;
        ArrayList arrayList = new ArrayList();
        int i8 = scale;
        float f3 = 0.9f * f;
        int i9 = 0;
        while (i9 < categoriesCount) {
            int itemCount = doughnutChart.mDataset.getItemCount(i9);
            String[] strArr2 = new String[itemCount];
            double d2 = 0.0d;
            for (int i10 = 0; i10 < itemCount; i10++) {
                d2 += doughnutChart.mDataset.getValues(i9)[i10];
                strArr2[i10] = doughnutChart.mDataset.getTitles(i9)[i10];
            }
            float startAngle = doughnutChart.mRenderer.getStartAngle();
            int i11 = doughnutChart.mCenterX;
            int i12 = doughnutChart.mCenterY;
            RectF rectF = new RectF(i11 - i8, i12 - i8, i11 + i8, i12 + i8);
            float f4 = startAngle;
            int i13 = 0;
            while (i13 < itemCount) {
                paint3.setColor(doughnutChart.mRenderer.getSeriesRendererAt(i13).getColor());
                float f5 = (float) ((((float) doughnutChart.mDataset.getValues(i9)[i13]) / d2) * 360.0d);
                int i14 = i13;
                RectF rectF2 = rectF;
                canvas.drawArc(rectF, f4, f5, true, paint);
                String str = doughnutChart.mDataset.getTitles(i9)[i14];
                DefaultRenderer defaultRenderer = doughnutChart.mRenderer;
                float f6 = f3;
                drawLabel(canvas, str, defaultRenderer, arrayList, doughnutChart.mCenterX, doughnutChart.mCenterY, f6, f2, f4, f5, i, i5, defaultRenderer.getLabelsColor(), paint, true, false);
                f4 += f5;
                i13 = i14 + 1;
                doughnutChart = this;
                paint3 = paint;
                rectF = rectF2;
                itemCount = itemCount;
                strArr = strArr;
                categoriesCount = categoriesCount;
                f3 = f6;
                i9 = i9;
                min = min;
                i8 = i8;
            }
            float f7 = f3;
            int i15 = i9;
            double d3 = min;
            String[] strArr3 = strArr;
            int i16 = categoriesCount;
            double d4 = d3 * d;
            int i17 = (int) (i8 - d4);
            float f8 = (float) (f7 - (d4 - 2.0d));
            if (this.mRenderer.getBackgroundColor() != 0) {
                paint2 = paint;
                paint2.setColor(this.mRenderer.getBackgroundColor());
            } else {
                paint2 = paint;
                paint2.setColor(-1);
            }
            paint2.setStyle(Paint.Style.FILL);
            int i18 = this.mCenterX;
            int i19 = this.mCenterY;
            canvas.drawArc(new RectF(i18 - i17, i19 - i17, i18 + i17, i19 + i17), 0.0f, 360.0f, true, paint);
            i8 = i17 - 1;
            f3 = f8;
            doughnutChart = this;
            paint3 = paint2;
            strArr = strArr3;
            categoriesCount = i16;
            min = d3;
            i9 = i15 + 1;
        }
        arrayList.clear();
        drawLegend(canvas, doughnutChart.mRenderer, strArr, i, i5, i2, i3, i4, drawLegend, paint, false);
        drawTitle(canvas, i, i2, i3, paint);
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        int i2 = this.mStep - 1;
        this.mStep = i2;
        canvas.drawCircle((f + 10.0f) - i2, f2, i2, paint);
    }

    public int getLegendShapeWidth(int i) {
        return 10;
    }
}
