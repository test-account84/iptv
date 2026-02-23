package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BarChart extends XYChart {
    private static final int SHAPE_WIDTH = 12;
    public static final String TYPE = "Bar";
    private List mPreviousSeriesPoints;
    protected Type mType;

    public enum Type {
        DEFAULT,
        STACKED,
        HEAPED
    }

    public BarChart() {
        this.mType = Type.DEFAULT;
    }

    public ClickableArea[] clickableAreasForPoints(List list, List list2, float f, int i, int i2) {
        int seriesCount = this.mDataset.getSeriesCount();
        int size = list.size();
        ClickableArea[] clickableAreaArr = new ClickableArea[size / 2];
        float halfDiffX = getHalfDiffX(list, size, seriesCount);
        for (int i3 = 0; i3 < size; i3 += 2) {
            float floatValue = ((Float) list.get(i3)).floatValue();
            int i4 = i3 + 1;
            float floatValue2 = ((Float) list.get(i4)).floatValue();
            Type type = this.mType;
            if (type == Type.STACKED || type == Type.HEAPED) {
                clickableAreaArr[i3 / 2] = new ClickableArea(new RectF(floatValue - halfDiffX, Math.min(floatValue2, f), floatValue + halfDiffX, Math.max(floatValue2, f)), ((Double) list2.get(i3)).doubleValue(), ((Double) list2.get(i4)).doubleValue());
            } else {
                float f2 = (floatValue - (seriesCount * halfDiffX)) + (i * 2 * halfDiffX);
                clickableAreaArr[i3 / 2] = new ClickableArea(new RectF(f2, Math.min(floatValue2, f), (2.0f * halfDiffX) + f2, Math.max(floatValue2, f)), ((Double) list2.get(i3)).doubleValue(), ((Double) list2.get(i4)).doubleValue());
            }
        }
        return clickableAreaArr;
    }

    public void drawBar(Canvas canvas, float f, float f2, float f3, float f4, float f5, int i, int i2, Paint paint) {
        float f6;
        float f7;
        int scaleNumber = this.mDataset.getSeriesAt(i2).getScaleNumber();
        Type type = this.mType;
        if (type == Type.STACKED || type == Type.HEAPED) {
            f6 = f - f5;
            f7 = f3 + f5;
        } else {
            f6 = (f - (i * f5)) + (i2 * 2 * f5);
            f7 = f6 + (2.0f * f5);
        }
        drawBar(canvas, f6, f4, f7, f2, scaleNumber, i2, paint);
    }

    public void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List list, int i, int i2) {
        String label;
        float floatValue;
        float f;
        int seriesCount = this.mDataset.getSeriesCount();
        int size = list.size();
        float halfDiffX = getHalfDiffX(list, size, seriesCount);
        for (int i3 = 0; i3 < size; i3 += 2) {
            double y = xYSeries.getY(i2 + (i3 / 2));
            if (!isNullValue(y)) {
                float floatValue2 = ((Float) list.get(i3)).floatValue();
                if (this.mType == Type.DEFAULT) {
                    floatValue2 += ((i * 2) * halfDiffX) - ((seriesCount - 1.5f) * halfDiffX);
                }
                float f2 = floatValue2;
                if (y >= 0.0d) {
                    label = getLabel(xYSeriesRenderer.getChartValuesFormat(), y);
                    floatValue = ((Float) list.get(i3 + 1)).floatValue();
                    f = xYSeriesRenderer.getChartValuesSpacing();
                } else {
                    label = getLabel(xYSeriesRenderer.getChartValuesFormat(), y);
                    floatValue = ((Float) list.get(i3 + 1)).floatValue() + xYSeriesRenderer.getChartValuesTextSize() + xYSeriesRenderer.getChartValuesSpacing();
                    f = 3.0f;
                }
                drawText(canvas, label, f2, floatValue - f, paint, 0.0f);
            }
        }
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        canvas.drawRect(f, f2 - 6.0f, f + 12.0f, f2 + 6.0f, paint);
    }

    public void drawSeries(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        int i3;
        BarChart barChart;
        Canvas canvas2;
        float f2;
        float f3;
        float f4;
        int i4;
        int i5;
        int seriesCount = this.mDataset.getSeriesCount();
        int size = list.size();
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.FILL);
        float halfDiffX = getHalfDiffX(list, size, seriesCount);
        int i6 = 0;
        while (i6 < size) {
            float floatValue = ((Float) list.get(i6)).floatValue();
            int i7 = i6 + 1;
            float floatValue2 = ((Float) list.get(i7)).floatValue();
            if (this.mType != Type.HEAPED || i <= 0) {
                i3 = i6;
                barChart = this;
                canvas2 = canvas;
                f2 = floatValue;
                f3 = f;
                f4 = halfDiffX;
                i4 = seriesCount;
                i5 = i;
            } else {
                f3 = ((Float) this.mPreviousSeriesPoints.get(i7)).floatValue();
                floatValue2 += f3 - f;
                list.set(i7, Float.valueOf(floatValue2));
                barChart = this;
                canvas2 = canvas;
                f2 = floatValue;
                f4 = halfDiffX;
                i4 = seriesCount;
                i5 = i;
                i3 = i6;
            }
            barChart.drawBar(canvas2, f2, f3, floatValue, floatValue2, f4, i4, i5, paint);
            i6 = i3 + 2;
        }
        paint.setColor(xYSeriesRenderer.getColor());
        this.mPreviousSeriesPoints = list;
    }

    public String getChartType() {
        return "Bar";
    }

    public float getCoeficient() {
        return 1.0f;
    }

    public double getDefaultMinimum() {
        return 0.0d;
    }

    public int getGradientPartialColor(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i) * f) + (Color.alpha(i2) * f2)), Math.round((Color.red(i) * f) + (Color.red(i2) * f2)), Math.round((Color.green(i) * f) + (Color.green(i2) * f2)), Math.round((f * Color.blue(i)) + (f2 * Color.blue(i2))));
    }

    public float getHalfDiffX(List list, int i, int i2) {
        float barWidth = this.mRenderer.getBarWidth();
        if (barWidth > 0.0f) {
            return barWidth / 2.0f;
        }
        float floatValue = (((Float) list.get(i - 2)).floatValue() - ((Float) list.get(0)).floatValue()) / (i > 2 ? i - 2 : i);
        if (floatValue == 0.0f) {
            floatValue = 10.0f;
        }
        Type type = this.mType;
        if (type != Type.STACKED && type != Type.HEAPED) {
            floatValue /= i2;
        }
        return (float) (floatValue / (getCoeficient() * (this.mRenderer.getBarSpacing() + 1.0d)));
    }

    public int getLegendShapeWidth(int i) {
        return 12;
    }

    public boolean isRenderNullValues() {
        return true;
    }

    public BarChart(Type type) {
        Type type2 = Type.DEFAULT;
        this.mType = type;
    }

    public void drawBar(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Paint paint) {
        float f5;
        float f6;
        float f7;
        float f8;
        int gradientPartialColor;
        if (f > f3) {
            f6 = f;
            f5 = f3;
        } else {
            f5 = f;
            f6 = f3;
        }
        if (f2 > f4) {
            f8 = f2;
            f7 = f4;
        } else {
            f7 = f2;
            f8 = f4;
        }
        SimpleSeriesRenderer seriesRendererAt = this.mRenderer.getSeriesRendererAt(i2);
        if (!seriesRendererAt.isGradientEnabled()) {
            if (Math.abs(f7 - f8) < 1.0f) {
                f8 = f7 < f8 ? f7 + 1.0f : f7 - 1.0f;
            }
            canvas.drawRect(Math.round(f5), Math.round(f7), Math.round(f6), Math.round(f8), paint);
            return;
        }
        float f9 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStopValue()}, i)[1];
        float f10 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStartValue()}, i)[1];
        float max = Math.max(f9, Math.min(f7, f8));
        float min = Math.min(f10, Math.max(f7, f8));
        int gradientStopColor = seriesRendererAt.getGradientStopColor();
        int gradientStartColor = seriesRendererAt.getGradientStartColor();
        if (f7 < f9) {
            paint.setColor(gradientStopColor);
            canvas.drawRect(Math.round(f5), Math.round(f7), Math.round(f6), Math.round(max), paint);
            gradientPartialColor = gradientStopColor;
        } else {
            gradientPartialColor = getGradientPartialColor(gradientStopColor, gradientStartColor, (f10 - max) / (f10 - f9));
        }
        if (f8 > f10) {
            paint.setColor(gradientStartColor);
            canvas.drawRect(Math.round(f5), Math.round(min), Math.round(f6), Math.round(f8), paint);
        } else {
            gradientStartColor = getGradientPartialColor(gradientStartColor, gradientStopColor, (min - f9) / (f10 - f9));
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{gradientStartColor, gradientPartialColor});
        gradientDrawable.setBounds(Math.round(f5), Math.round(max), Math.round(f6), Math.round(min));
        gradientDrawable.draw(canvas);
    }

    public BarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, Type type) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        Type type2 = Type.DEFAULT;
        this.mType = type;
    }
}
