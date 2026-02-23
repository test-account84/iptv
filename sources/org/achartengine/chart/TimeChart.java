package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TimeChart extends LineChart {
    public static final long DAY = 86400000;
    public static final String TYPE = "Time";
    private String mDateFormat;
    private Double mStartPoint;

    public TimeChart() {
    }

    public void drawXLabels(List list, Double[] dArr, Canvas canvas, Paint paint, int i, int i2, int i3, double d, double d2, double d3) {
        int i4;
        int size = list.size();
        if (size > 0) {
            boolean isShowXLabels = this.mRenderer.isShowXLabels();
            boolean isShowGridY = this.mRenderer.isShowGridY();
            if (isShowGridY) {
                this.mGridPaint.setStyle(Paint.Style.STROKE);
                this.mGridPaint.setStrokeWidth(this.mRenderer.getGridLineWidth());
            }
            boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
            DateFormat dateFormat = getDateFormat(((Double) list.get(0)).doubleValue(), ((Double) list.get(size - 1)).doubleValue());
            int i5 = 0;
            while (i5 < size) {
                long round = Math.round(((Double) list.get(i5)).doubleValue());
                float f = (float) (i + ((round - d2) * d));
                if (isShowXLabels) {
                    paint.setColor(this.mRenderer.getXLabelsColor());
                    if (isShowTickMarks) {
                        float f2 = i3;
                        canvas.drawLine(f, f2, f, f2 + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                    }
                    i4 = i5;
                    drawText(canvas, dateFormat.format(new Date(round)), f, i3 + ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + this.mRenderer.getXLabelsPadding(), paint, this.mRenderer.getXLabelsAngle());
                } else {
                    i4 = i5;
                }
                if (isShowGridY) {
                    this.mGridPaint.setColor(this.mRenderer.getGridColor(0));
                    canvas.drawLine(f, i3, f, i2, this.mGridPaint);
                }
                i5 = i4 + 1;
            }
        }
        drawXTextLabels(dArr, canvas, paint, true, i, i2, i3, d, d2, d3);
    }

    public String getChartType() {
        return "Time";
    }

    public String getDateFormat() {
        return this.mDateFormat;
    }

    public List getXLabels(double d, double d2, int i) {
        int i2 = i;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (this.mRenderer.isXRoundedLabels()) {
            double d3 = 8.64E7d;
            if (this.mStartPoint == null) {
                this.mStartPoint = Double.valueOf((d - (d % 8.64E7d)) + 8.64E7d + (new Date(Math.round(d)).getTimezoneOffset() * 60000));
            }
            if (i2 > 25) {
                i2 = 25;
            }
            double d4 = (d2 - d) / i2;
            if (d4 <= 0.0d) {
                return arrayList;
            }
            if (d4 <= 8.64E7d) {
                while (true) {
                    double d5 = d3 / 2.0d;
                    if (d4 >= d5) {
                        break;
                    }
                    d3 = d5;
                }
            } else {
                while (d4 > d3) {
                    d3 *= 2.0d;
                }
            }
            double doubleValue = this.mStartPoint.doubleValue() - (Math.floor((this.mStartPoint.doubleValue() - d) / d3) * d3);
            while (doubleValue < d2) {
                int i4 = i3 + 1;
                if (i3 > i2) {
                    break;
                }
                arrayList.add(Double.valueOf(doubleValue));
                doubleValue += d3;
                i3 = i4;
            }
            return arrayList;
        }
        if (this.mDataset.getSeriesCount() <= 0) {
            return super.getXLabels(d, d2, i);
        }
        XYSeries seriesAt = this.mDataset.getSeriesAt(0);
        int itemCount = seriesAt.getItemCount();
        int i5 = -1;
        int i6 = 0;
        for (int i7 = 0; i7 < itemCount; i7++) {
            double x = seriesAt.getX(i7);
            if (d <= x && x <= d2) {
                i6++;
                if (i5 < 0) {
                    i5 = i7;
                }
            }
        }
        if (i6 < i2) {
            for (int i8 = i5; i8 < i5 + i6; i8++) {
                arrayList.add(Double.valueOf(seriesAt.getX(i8)));
            }
        } else {
            float f = i6 / i2;
            int i9 = 0;
            while (i3 < itemCount && i9 < i2) {
                double x2 = seriesAt.getX(Math.round(i3 * f));
                if (d <= x2 && x2 <= d2) {
                    arrayList.add(Double.valueOf(x2));
                    i9++;
                }
                i3++;
            }
        }
        return arrayList;
    }

    public void setDateFormat(String str) {
        this.mDateFormat = str;
    }

    public TimeChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
    }

    private DateFormat getDateFormat(double d, double d2) {
        if (this.mDateFormat != null) {
            try {
                return new SimpleDateFormat(this.mDateFormat);
            } catch (Exception unused) {
            }
        }
        double d3 = d2 - d;
        return (d3 <= 8.64E7d || d3 >= 4.32E8d) ? d3 < 8.64E7d ? DateFormat.getTimeInstance(2) : DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(3, 3);
    }
}
