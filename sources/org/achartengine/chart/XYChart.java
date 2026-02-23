package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.BasicStroke;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.util.MathHelper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class XYChart extends AbstractChart {
    private Point mCenter;
    protected XYMultipleSeriesDataset mDataset;
    protected transient Paint mGridPaint;
    protected XYMultipleSeriesRenderer mRenderer;
    private float mScale;
    private Rect mScreenR;
    private float mTranslate;
    private final Map mCalcRange = new HashMap();
    private Map clickableAreas = new HashMap();

    public XYChart() {
    }

    private int getLabelLinePos(Paint.Align align) {
        return align == Paint.Align.LEFT ? -4 : 4;
    }

    private List getValidLabels(List list) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Double d = (Double) it.next();
            if (d.isNaN()) {
                arrayList.remove(d);
            }
        }
        return arrayList;
    }

    private void setStroke(Paint.Cap cap, Paint.Join join, float f, Paint.Style style, PathEffect pathEffect, Paint paint) {
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f);
        paint.setPathEffect(pathEffect);
        paint.setStyle(style);
    }

    private void transform(Canvas canvas, float f, boolean z) {
        if (z) {
            float f2 = this.mScale;
            canvas.scale(1.0f / f2, f2);
            float f3 = this.mTranslate;
            canvas.translate(f3, -f3);
            canvas.rotate(-f, this.mCenter.getX(), this.mCenter.getY());
            return;
        }
        canvas.rotate(f, this.mCenter.getX(), this.mCenter.getY());
        float f4 = this.mTranslate;
        canvas.translate(-f4, f4);
        float f5 = this.mScale;
        canvas.scale(f5, 1.0f / f5);
    }

    public abstract ClickableArea[] clickableAreasForPoints(List list, List list2, float f, int i, int i2);

    /* JADX WARN: Removed duplicated region for block: B:184:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0b23  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0b97  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0c00  */
    /* JADX WARN: Removed duplicated region for block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0b4f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0b13  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r55, int r56, int r57, int r58, int r59, android.graphics.Paint r60) {
        /*
            Method dump skipped, instructions count: 3080
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.achartengine.chart.XYChart.draw(android.graphics.Canvas, int, int, int, int, android.graphics.Paint):void");
    }

    public void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List list, int i, int i2) {
        int i3;
        Object obj;
        if (list.size() <= 2) {
            for (int i4 = 0; i4 < list.size(); i4 += 2) {
                drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY((i4 / 2) + i2)), ((Float) list.get(i4)).floatValue(), ((Float) list.get(i4 + 1)).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, 0.0f);
            }
            return;
        }
        float floatValue = ((Float) list.get(0)).floatValue();
        float floatValue2 = ((Float) list.get(1)).floatValue();
        for (int i5 = 0; i5 < list.size(); i5 += 2) {
            if (i5 == 2) {
                i3 = 3;
                if (Math.abs(((Float) list.get(2)).floatValue() - ((Float) list.get(0)).floatValue()) > xYSeriesRenderer.getDisplayChartValuesDistance() || Math.abs(((Float) list.get(3)).floatValue() - ((Float) list.get(1)).floatValue()) > xYSeriesRenderer.getDisplayChartValuesDistance()) {
                    drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i2)), ((Float) list.get(0)).floatValue(), ((Float) list.get(1)).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, 0.0f);
                    drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i2 + 1)), ((Float) list.get(2)).floatValue(), ((Float) list.get(3)).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, 0.0f);
                    obj = list.get(2);
                    floatValue = ((Float) obj).floatValue();
                    floatValue2 = ((Float) list.get(i3)).floatValue();
                }
            } else if (i5 > 2 && (Math.abs(((Float) list.get(i5)).floatValue() - floatValue) > xYSeriesRenderer.getDisplayChartValuesDistance() || Math.abs(((Float) list.get(i5 + 1)).floatValue() - floatValue2) > xYSeriesRenderer.getDisplayChartValuesDistance())) {
                i3 = i5 + 1;
                drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY((i5 / 2) + i2)), ((Float) list.get(i5)).floatValue(), ((Float) list.get(i3)).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, 0.0f);
                obj = list.get(i5);
                floatValue = ((Float) obj).floatValue();
                floatValue2 = ((Float) list.get(i3)).floatValue();
            }
        }
    }

    public void drawPoints(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        ScatterChart pointsChart;
        if (!isRenderPoints(xYSeriesRenderer) || (pointsChart = getPointsChart()) == null) {
            return;
        }
        pointsChart.drawSeries(canvas, paint, list, xYSeriesRenderer, f, i, i2);
    }

    public abstract void drawSeries(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2);

    public void drawSeries(XYSeries xYSeries, Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, XYMultipleSeriesRenderer.Orientation orientation, int i2) {
        BasicStroke stroke = xYSeriesRenderer.getStroke();
        Paint.Cap strokeCap = paint.getStrokeCap();
        Paint.Join strokeJoin = paint.getStrokeJoin();
        float strokeMiter = paint.getStrokeMiter();
        PathEffect pathEffect = paint.getPathEffect();
        Paint.Style style = paint.getStyle();
        if (stroke != null) {
            setStroke(stroke.getCap(), stroke.getJoin(), stroke.getMiter(), Paint.Style.FILL_AND_STROKE, stroke.getIntervals() != null ? new DashPathEffect(stroke.getIntervals(), stroke.getPhase()) : null, paint);
        }
        drawSeries(canvas, paint, list, xYSeriesRenderer, f, i, i2);
        drawPoints(canvas, paint, list, xYSeriesRenderer, f, i, i2);
        paint.setTextSize(xYSeriesRenderer.getChartValuesTextSize());
        paint.setTextAlign(orientation == XYMultipleSeriesRenderer.Orientation.HORIZONTAL ? Paint.Align.CENTER : Paint.Align.LEFT);
        if (xYSeriesRenderer.isDisplayChartValues()) {
            paint.setTextAlign(xYSeriesRenderer.getChartValuesTextAlign());
            drawChartValuesText(canvas, xYSeries, xYSeriesRenderer, paint, list, i, i2);
        }
        if (stroke != null) {
            setStroke(strokeCap, strokeJoin, strokeMiter, style, pathEffect, paint);
        }
    }

    public void drawText(Canvas canvas, String str, float f, float f2, Paint paint, float f3) {
        float f4 = (-this.mRenderer.getOrientation().getAngle()) + f3;
        if (f4 != 0.0f) {
            canvas.rotate(f4, f, f2);
        }
        drawString(canvas, str, f, f2, paint);
        if (f4 != 0.0f) {
            canvas.rotate(-f4, f, f2);
        }
    }

    public void drawXLabels(List list, Double[] dArr, Canvas canvas, Paint paint, int i, int i2, int i3, double d, double d2, double d3) {
        float f;
        int size = list.size();
        boolean isShowXLabels = this.mRenderer.isShowXLabels();
        boolean isShowGridY = this.mRenderer.isShowGridY();
        if (isShowGridY) {
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setStrokeWidth(this.mRenderer.getGridLineWidth());
        }
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        for (int i4 = 0; i4 < size; i4++) {
            double doubleValue = ((Double) list.get(i4)).doubleValue();
            float f2 = (float) (i + ((doubleValue - d2) * d));
            if (isShowXLabels) {
                paint.setColor(this.mRenderer.getXLabelsColor());
                if (isShowTickMarks) {
                    float f3 = i3;
                    canvas.drawLine(f2, f3, f2, f3 + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                }
                f = f2;
                drawText(canvas, getLabel(this.mRenderer.getXLabelFormat(), doubleValue), f2, i3 + ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + this.mRenderer.getXLabelsPadding(), paint, this.mRenderer.getXLabelsAngle());
            } else {
                f = f2;
            }
            if (isShowGridY) {
                this.mGridPaint.setColor(this.mRenderer.getGridColor(0));
                canvas.drawLine(f, i3, f, i2, this.mGridPaint);
            }
        }
        drawXTextLabels(dArr, canvas, paint, isShowXLabels, i, i2, i3, d, d2, d3);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawXTextLabels(java.lang.Double[] r20, android.graphics.Canvas r21, android.graphics.Paint r22, boolean r23, int r24, int r25, int r26, double r27, double r29, double r31) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r22
            r10 = r26
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            boolean r11 = r0.isShowCustomTextGridX()
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            boolean r12 = r0.isShowTickMarks()
            if (r23 == 0) goto Lbe
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            int r0 = r0.getXLabelsColor()
            r9.setColor(r0)
            int r13 = r8.length
            r14 = 0
            r15 = 0
        L22:
            if (r15 >= r13) goto Lbe
            r6 = r8[r15]
            double r0 = r6.doubleValue()
            int r2 = (r29 > r0 ? 1 : (r29 == r0 ? 0 : -1))
            if (r2 > 0) goto Lb8
            double r0 = r6.doubleValue()
            int r2 = (r0 > r31 ? 1 : (r0 == r31 ? 0 : -1))
            if (r2 > 0) goto Lb8
            r5 = r24
            double r0 = (double) r5
            double r2 = r6.doubleValue()
            double r2 = r2 - r29
            double r2 = r2 * r27
            double r0 = r0 + r2
            float r4 = (float) r0
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            int r0 = r0.getXLabelsColor()
            r9.setColor(r0)
            r16 = 1077936128(0x40400000, float:3.0)
            if (r12 == 0) goto L69
            float r2 = (float) r10
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            float r0 = r0.getLabelsTextSize()
            float r0 = r0 / r16
            float r17 = r2 + r0
            r0 = r21
            r1 = r4
            r3 = r4
            r18 = r4
            r4 = r17
            r5 = r22
            r0.drawLine(r1, r2, r3, r4, r5)
            goto L6b
        L69:
            r18 = r4
        L6b:
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            java.lang.String r2 = r0.getXTextLabel(r6)
            float r6 = (float) r10
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            float r0 = r0.getLabelsTextSize()
            r1 = 1082130432(0x40800000, float:4.0)
            float r0 = r0 * r1
            float r0 = r0 / r16
            float r0 = r0 + r6
            org.achartengine.renderer.XYMultipleSeriesRenderer r1 = r7.mRenderer
            float r1 = r1.getXLabelsPadding()
            float r4 = r0 + r1
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            float r16 = r0.getXLabelsAngle()
            r0 = r19
            r1 = r21
            r3 = r18
            r5 = r22
            r17 = r6
            r6 = r16
            r0.drawText(r1, r2, r3, r4, r5, r6)
            if (r11 == 0) goto Lb8
            org.achartengine.renderer.XYMultipleSeriesRenderer r0 = r7.mRenderer
            int r0 = r0.getGridColor(r14)
            r9.setColor(r0)
            r6 = r25
            float r4 = (float) r6
            r0 = r21
            r1 = r18
            r2 = r17
            r3 = r18
            r5 = r22
            r0.drawLine(r1, r2, r3, r4, r5)
            goto Lba
        Lb8:
            r6 = r25
        Lba:
            int r15 = r15 + 1
            goto L22
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.achartengine.chart.XYChart.drawXTextLabels(java.lang.Double[], android.graphics.Canvas, android.graphics.Paint, boolean, int, int, int, double, double, double):void");
    }

    public void drawYLabels(Map map, Canvas canvas, Paint paint, int i, int i2, int i3, int i4, double[] dArr, double[] dArr2) {
        int i5;
        boolean z;
        int i6;
        int i7;
        boolean z2;
        XYMultipleSeriesRenderer.Orientation orientation;
        int i8;
        int i9;
        int i10;
        XYMultipleSeriesRenderer.Orientation orientation2;
        int i11;
        int i12;
        double d;
        Paint paint2 = paint;
        int i13 = i2;
        int i14 = i3;
        XYMultipleSeriesRenderer.Orientation orientation3 = this.mRenderer.getOrientation();
        boolean isShowGridX = this.mRenderer.isShowGridX();
        if (isShowGridX) {
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setStrokeWidth(this.mRenderer.getGridLineWidth());
        }
        boolean isShowYLabels = this.mRenderer.isShowYLabels();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        int i15 = i;
        int i16 = 0;
        while (i16 < i15) {
            paint2.setTextAlign(this.mRenderer.getYLabelsAlign(i16));
            List list = (List) map.get(Integer.valueOf(i16));
            int size = list.size();
            int i17 = 0;
            while (i17 < size) {
                Double d2 = (Double) list.get(i17);
                List list2 = list;
                double doubleValue = d2.doubleValue();
                Paint.Align yAxisAlign = this.mRenderer.getYAxisAlign(i16);
                int i18 = i17;
                if (this.mRenderer.getYTextLabel(d2, i16) != null) {
                    z = true;
                    i5 = i4;
                } else {
                    i5 = i4;
                    z = false;
                }
                float f = (float) (i5 - (dArr[i16] * (doubleValue - dArr2[i16])));
                if (orientation3 == XYMultipleSeriesRenderer.Orientation.HORIZONTAL) {
                    if (!isShowYLabels || z) {
                        i6 = i2;
                        i10 = i3;
                        i7 = size;
                        orientation2 = orientation3;
                        z2 = isShowGridX;
                        i11 = i16;
                    } else {
                        paint2.setColor(this.mRenderer.getYLabelsColor(i16));
                        if (yAxisAlign == Paint.Align.LEFT) {
                            if (isShowTickMarks) {
                                i6 = i2;
                                i7 = size;
                                orientation2 = orientation3;
                                z2 = isShowGridX;
                                d = doubleValue;
                                i12 = i16;
                                canvas.drawLine(getLabelLinePos(yAxisAlign) + i6, f, i6, f, paint);
                            } else {
                                i6 = i2;
                                i7 = size;
                                i12 = i16;
                                orientation2 = orientation3;
                                z2 = isShowGridX;
                                d = doubleValue;
                            }
                            drawText(canvas, getLabel(this.mRenderer.getYLabelFormat(i12), d), i6 - this.mRenderer.getYLabelsPadding(), f - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                            i11 = i12;
                            i10 = i3;
                        } else {
                            i6 = i2;
                            i7 = size;
                            int i19 = i16;
                            orientation2 = orientation3;
                            z2 = isShowGridX;
                            if (isShowTickMarks) {
                                float labelLinePos = getLabelLinePos(yAxisAlign) + i3;
                                i10 = i3;
                                canvas.drawLine(i3, f, labelLinePos, f, paint);
                            } else {
                                i10 = i3;
                            }
                            i11 = i19;
                            drawText(canvas, getLabel(this.mRenderer.getYLabelFormat(i19), doubleValue), i10 + this.mRenderer.getYLabelsPadding(), f - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                        }
                    }
                    if (z2) {
                        this.mGridPaint.setColor(this.mRenderer.getGridColor(i11));
                        canvas.drawLine(i6, f, i10, f, this.mGridPaint);
                    }
                    i8 = i11;
                    i9 = i10;
                    orientation = orientation2;
                } else {
                    i6 = i2;
                    i7 = size;
                    XYMultipleSeriesRenderer.Orientation orientation4 = orientation3;
                    z2 = isShowGridX;
                    if (orientation4 == XYMultipleSeriesRenderer.Orientation.VERTICAL) {
                        if (!isShowYLabels || z) {
                            orientation = orientation4;
                            i8 = i16;
                            i9 = i3;
                        } else {
                            paint2.setColor(this.mRenderer.getYLabelsColor(i16));
                            if (isShowTickMarks) {
                                orientation = orientation4;
                                i8 = i16;
                                canvas.drawLine(i3 - getLabelLinePos(yAxisAlign), f, i3, f, paint);
                            } else {
                                orientation = orientation4;
                                i8 = i16;
                            }
                            i9 = i3;
                            drawText(canvas, getLabel(this.mRenderer.getLabelFormat(), doubleValue), i3 + 10 + this.mRenderer.getYLabelsPadding(), f - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                        }
                        if (z2) {
                            this.mGridPaint.setColor(this.mRenderer.getGridColor(i8));
                            if (isShowTickMarks) {
                                canvas.drawLine(i9, f, i6, f, this.mGridPaint);
                            }
                        }
                    } else {
                        orientation = orientation4;
                        i8 = i16;
                        i9 = i3;
                    }
                }
                i17 = i18 + 1;
                i16 = i8;
                i13 = i6;
                i14 = i9;
                orientation3 = orientation;
                list = list2;
                size = i7;
                isShowGridX = z2;
                paint2 = paint;
            }
            i16++;
            paint2 = paint;
            i15 = i;
            i14 = i14;
            isShowGridX = isShowGridX;
        }
    }

    public double[] getCalcRange(int i) {
        return (double[]) this.mCalcRange.get(Integer.valueOf(i));
    }

    public abstract String getChartType();

    public XYMultipleSeriesDataset getDataset() {
        return this.mDataset;
    }

    public double getDefaultMinimum() {
        return Double.MAX_VALUE;
    }

    public ScatterChart getPointsChart() {
        return null;
    }

    public XYMultipleSeriesRenderer getRenderer() {
        return this.mRenderer;
    }

    public Rect getScreenR() {
        return this.mScreenR;
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point) {
        RectF rect;
        Map map = this.clickableAreas;
        if (map != null) {
            for (int size = map.size() - 1; size >= 0; size--) {
                if (this.clickableAreas.get(Integer.valueOf(size)) != null) {
                    int i = 0;
                    for (ClickableArea clickableArea : (List) this.clickableAreas.get(Integer.valueOf(size))) {
                        if (clickableArea != null && (rect = clickableArea.getRect()) != null && rect.contains(point.getX(), point.getY())) {
                            return new SeriesSelection(size, i, clickableArea.getX(), clickableArea.getY());
                        }
                        i++;
                    }
                }
            }
        }
        return super.getSeriesAndPointForScreenCoordinate(point);
    }

    public List getXLabels(double d, double d2, int i) {
        return MathHelper.getLabels(d, d2, i);
    }

    public Map getYLabels(double[] dArr, double[] dArr2, int i) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            hashMap.put(Integer.valueOf(i2), getValidLabels(MathHelper.getLabels(dArr[i2], dArr2[i2], this.mRenderer.getYLabels())));
        }
        return hashMap;
    }

    public boolean isRenderNullValues() {
        return false;
    }

    public boolean isRenderPoints(SimpleSeriesRenderer simpleSeriesRenderer) {
        return false;
    }

    public void setCalcRange(double[] dArr, int i) {
        this.mCalcRange.put(Integer.valueOf(i), dArr);
    }

    public void setDatasetRenderer(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        this.mDataset = xYMultipleSeriesDataset;
        this.mRenderer = xYMultipleSeriesRenderer;
    }

    public void setScreenR(Rect rect) {
        this.mScreenR = rect;
    }

    public double[] toRealPoint(float f, float f2) {
        return toRealPoint(f, f2, 0);
    }

    public double[] toScreenPoint(double[] dArr) {
        return toScreenPoint(dArr, 0);
    }

    public XYChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        this.mDataset = xYMultipleSeriesDataset;
        this.mRenderer = xYMultipleSeriesRenderer;
    }

    public double[] toRealPoint(float f, float f2, int i) {
        double[] calcRange;
        double xAxisMin = this.mRenderer.getXAxisMin(i);
        double xAxisMax = this.mRenderer.getXAxisMax(i);
        double yAxisMin = this.mRenderer.getYAxisMin(i);
        double yAxisMax = this.mRenderer.getYAxisMax(i);
        if ((!this.mRenderer.isMinXSet(i) || !this.mRenderer.isMaxXSet(i) || !this.mRenderer.isMinYSet(i) || !this.mRenderer.isMaxYSet(i)) && (calcRange = getCalcRange(i)) != null) {
            xAxisMin = calcRange[0];
            xAxisMax = calcRange[1];
            yAxisMin = calcRange[2];
            yAxisMax = calcRange[3];
        }
        if (this.mScreenR == null) {
            return new double[]{f, f2};
        }
        double width = (((f - r3.left) * (xAxisMax - xAxisMin)) / r3.width()) + xAxisMin;
        Rect rect = this.mScreenR;
        return new double[]{width, ((((rect.top + rect.height()) - f2) * (yAxisMax - yAxisMin)) / this.mScreenR.height()) + yAxisMin};
    }

    public double[] toScreenPoint(double[] dArr, int i) {
        double xAxisMin = this.mRenderer.getXAxisMin(i);
        double xAxisMax = this.mRenderer.getXAxisMax(i);
        double yAxisMin = this.mRenderer.getYAxisMin(i);
        double yAxisMax = this.mRenderer.getYAxisMax(i);
        if (!this.mRenderer.isMinXSet(i) || !this.mRenderer.isMaxXSet(i) || !this.mRenderer.isMinYSet(i) || !this.mRenderer.isMaxYSet(i)) {
            double[] calcRange = getCalcRange(i);
            xAxisMin = calcRange[0];
            xAxisMax = calcRange[1];
            yAxisMin = calcRange[2];
            yAxisMax = calcRange[3];
        }
        if (this.mScreenR == null) {
            return dArr;
        }
        double width = ((dArr[0] - xAxisMin) * r1.width()) / (xAxisMax - xAxisMin);
        Rect rect = this.mScreenR;
        return new double[]{width + rect.left, (((yAxisMax - dArr[1]) * rect.height()) / (yAxisMax - yAxisMin)) + this.mScreenR.top};
    }
}
