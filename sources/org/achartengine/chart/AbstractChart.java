package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class AbstractChart implements Serializable {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0054 A[PHI: r6
      0x0054: PHI (r6v4 float) = (r6v1 float), (r6v5 float) binds: [B:21:0x0073, B:9:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x001e A[PHI: r1 r3 r4
      0x001e: PHI (r1v6 float) = (r1v4 float), (r1v13 float) binds: [B:35:0x003c, B:27:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r3v1 float) = (r3v0 float), (r3v5 float) binds: [B:35:0x003c, B:27:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r4v2 float) = (r4v1 float), (r4v4 float) binds: [B:35:0x003c, B:27:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 float) = (r3v0 float), (r3v5 float) binds: [B:33:0x0036, B:4:0x0013] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static float[] calculateDrawPoints(float r6, float r7, float r8, float r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 146
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.achartengine.chart.AbstractChart.calculateDrawPoints(float, float, float, float, int, int):float[]");
    }

    private String getFitText(String str, float f, Paint paint) {
        int length = str.length();
        String str2 = str;
        int i = 0;
        while (paint.measureText(str2) > f && i < length) {
            i++;
            str2 = str.substring(0, length - i) + "...";
        }
        return i == length ? "..." : str2;
    }

    public abstract void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint);

    public void drawBackground(DefaultRenderer defaultRenderer, Canvas canvas, int i, int i2, int i3, int i4, Paint paint, boolean z, int i5) {
        if (defaultRenderer.isApplyBackgroundColor() || z) {
            if (z) {
                paint.setColor(i5);
            } else {
                paint.setColor(defaultRenderer.getBackgroundColor());
            }
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(i, i2, i + i3, i2 + i4, paint);
        }
    }

    /*  JADX ERROR: iliLiI1iLLIL in pass: LoopRegionVisitor
        LL1ili1iI1iI.iliLiI1iLLIL: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at ILlL1lil1i1i.iiIiLiL1LIiIII1.LL1ll1L1IL1LlII(Unknown Source:51)
        	at ILlL1lil1i1i.iiIiLiL1LIiIII1.L1IlILiL1l11Ll(Unknown Source:8)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(Unknown Source:0)
        */
    public void drawLabel(android.graphics.Canvas r18, java.lang.String r19, org.achartengine.renderer.DefaultRenderer r20, java.util.List r21, int r22, int r23, float r24, float r25, float r26, float r27, int r28, int r29, int r30, android.graphics.Paint r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.achartengine.chart.AbstractChart.drawLabel(android.graphics.Canvas, java.lang.String, org.achartengine.renderer.DefaultRenderer, java.util.List, int, int, float, float, float, float, int, int, int, android.graphics.Paint, boolean, boolean):void");
    }

    public int drawLegend(Canvas canvas, DefaultRenderer defaultRenderer, String[] strArr, int i, int i2, int i3, int i4, int i5, int i6, Paint paint, boolean z) {
        int i7;
        int i8;
        float f;
        float f2;
        String str;
        String[] strArr2 = strArr;
        float f3 = 32.0f;
        if (defaultRenderer.isShowLegend()) {
            float f4 = i;
            float f5 = ((i3 + i5) - i6) + 32.0f;
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(defaultRenderer.getLegendTextSize());
            int min = Math.min(strArr2.length, defaultRenderer.getSeriesRendererCount());
            float f6 = f4;
            int i9 = 0;
            while (i9 < min) {
                SimpleSeriesRenderer seriesRendererAt = defaultRenderer.getSeriesRendererAt(i9);
                float legendShapeWidth = getLegendShapeWidth(i9);
                if (seriesRendererAt.isShowLegendItem()) {
                    String str2 = strArr2[i9];
                    paint.setColor(strArr2.length == defaultRenderer.getSeriesRendererCount() ? seriesRendererAt.getColor() : -3355444);
                    int length = str2.length();
                    float[] fArr = new float[length];
                    paint.getTextWidths(str2, fArr);
                    float f7 = 0.0f;
                    i8 = min;
                    for (int i10 = 0; i10 < length; i10++) {
                        f7 += fArr[i10];
                    }
                    float f8 = legendShapeWidth + 10.0f + f7;
                    float f9 = f6 + f8;
                    if (i9 <= 0 || !getExceed(f9, defaultRenderer, i2, i4)) {
                        f = f3;
                        f2 = f6;
                    } else {
                        f5 += defaultRenderer.getLegendTextSize();
                        f9 = f4 + f8;
                        f = f3 + defaultRenderer.getLegendTextSize();
                        f2 = f4;
                    }
                    float f10 = f9;
                    float f11 = f5;
                    if (getExceed(f10, defaultRenderer, i2, i4)) {
                        float f12 = ((i2 - f2) - legendShapeWidth) - 10.0f;
                        if (isVertical(defaultRenderer)) {
                            f12 = ((i4 - f2) - legendShapeWidth) - 10.0f;
                        }
                        str = str2.substring(0, paint.breakText(str2, true, f12, fArr)) + "...";
                    } else {
                        str = str2;
                    }
                    if (z) {
                        i7 = i9;
                    } else {
                        i7 = i9;
                        drawLegendShape(canvas, seriesRendererAt, f2, f11, i9, paint);
                        drawString(canvas, str, f2 + legendShapeWidth + 5.0f, f11 + 5.0f, paint);
                    }
                    f6 = f2 + f8;
                    f5 = f11;
                    f3 = f;
                } else {
                    i7 = i9;
                    i8 = min;
                }
                i9 = i7 + 1;
                strArr2 = strArr;
                min = i8;
            }
        }
        return Math.round(f3 + defaultRenderer.getLegendTextSize());
    }

    public abstract void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint);

    public void drawPath(Canvas canvas, List list, Paint paint, boolean z) {
        Path path = new Path();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if (list.size() < 4) {
            return;
        }
        float[] calculateDrawPoints = calculateDrawPoints(((Float) list.get(0)).floatValue(), ((Float) list.get(1)).floatValue(), ((Float) list.get(2)).floatValue(), ((Float) list.get(3)).floatValue(), height, width);
        path.moveTo(calculateDrawPoints[0], calculateDrawPoints[1]);
        path.lineTo(calculateDrawPoints[2], calculateDrawPoints[3]);
        int size = list.size();
        for (int i = 4; i < size; i += 2) {
            int i2 = i - 1;
            if (((Float) list.get(i2)).floatValue() >= 0.0f || ((Float) list.get(i + 1)).floatValue() >= 0.0f) {
                float f = height;
                if (((Float) list.get(i2)).floatValue() <= f || ((Float) list.get(i + 1)).floatValue() <= f) {
                    float[] calculateDrawPoints2 = calculateDrawPoints(((Float) list.get(i - 2)).floatValue(), ((Float) list.get(i2)).floatValue(), ((Float) list.get(i)).floatValue(), ((Float) list.get(i + 1)).floatValue(), height, width);
                    if (!z) {
                        path.moveTo(calculateDrawPoints2[0], calculateDrawPoints2[1]);
                    }
                    path.lineTo(calculateDrawPoints2[2], calculateDrawPoints2[3]);
                }
            }
        }
        if (z) {
            path.lineTo(((Float) list.get(0)).floatValue(), ((Float) list.get(1)).floatValue());
        }
        canvas.drawPath(path, paint);
    }

    public void drawString(Canvas canvas, String str, float f, float f2, Paint paint) {
        if (str != null) {
            String[] split = str.split("\n");
            Rect rect = new Rect();
            int i = 0;
            for (int i2 = 0; i2 < split.length; i2++) {
                canvas.drawText(split[i2], f, i + f2, paint);
                String str2 = split[i2];
                paint.getTextBounds(str2, 0, str2.length(), rect);
                i = i + rect.height() + 5;
            }
        }
    }

    public boolean getExceed(float f, DefaultRenderer defaultRenderer, int i, int i2) {
        boolean z = f > ((float) i);
        if (isVertical(defaultRenderer)) {
            return f > ((float) i2);
        }
        return z;
    }

    public String getLabel(NumberFormat numberFormat, double d) {
        StringBuilder sb;
        if (numberFormat != null) {
            return numberFormat.format(d);
        }
        if (d == Math.round(d)) {
            sb = new StringBuilder();
            sb.append(Math.round(d));
        } else {
            sb = new StringBuilder();
            sb.append(d);
        }
        sb.append("");
        return sb.toString();
    }

    public abstract int getLegendShapeWidth(int i);

    public int getLegendSize(DefaultRenderer defaultRenderer, int i, float f) {
        int legendHeight = defaultRenderer.getLegendHeight();
        if (!defaultRenderer.isShowLegend() || legendHeight != 0) {
            i = legendHeight;
        }
        return (defaultRenderer.isShowLegend() || !defaultRenderer.isShowXLabels()) ? i : (int) (((defaultRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f);
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point) {
        return null;
    }

    public boolean isNullValue(double d) {
        return Double.isNaN(d) || Double.isInfinite(d) || d == Double.MAX_VALUE;
    }

    public boolean isVertical(DefaultRenderer defaultRenderer) {
        return (defaultRenderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer) defaultRenderer).getOrientation() == XYMultipleSeriesRenderer.Orientation.VERTICAL;
    }

    public void drawPath(Canvas canvas, float[] fArr, Paint paint, boolean z) {
        Path path = new Path();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if (fArr.length < 4) {
            return;
        }
        float[] calculateDrawPoints = calculateDrawPoints(fArr[0], fArr[1], fArr[2], fArr[3], height, width);
        path.moveTo(calculateDrawPoints[0], calculateDrawPoints[1]);
        path.lineTo(calculateDrawPoints[2], calculateDrawPoints[3]);
        int length = fArr.length;
        for (int i = 4; i < length; i += 2) {
            float f = fArr[i - 1];
            if (f >= 0.0f || fArr[i + 1] >= 0.0f) {
                float f2 = height;
                if (f <= f2 || fArr[i + 1] <= f2) {
                    float[] calculateDrawPoints2 = calculateDrawPoints(fArr[i - 2], f, fArr[i], fArr[i + 1], height, width);
                    if (!z) {
                        path.moveTo(calculateDrawPoints2[0], calculateDrawPoints2[1]);
                    }
                    path.lineTo(calculateDrawPoints2[2], calculateDrawPoints2[3]);
                }
            }
        }
        if (z) {
            path.lineTo(fArr[0], fArr[1]);
        }
        canvas.drawPath(path, paint);
    }
}
