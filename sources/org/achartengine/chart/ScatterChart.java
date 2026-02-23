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
public class ScatterChart extends XYChart {
    private static final int SHAPE_WIDTH = 10;
    private static final float SIZE = 3.0f;
    public static final String TYPE = "Scatter";
    private float size;

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$org$achartengine$chart$PointStyle;

        static {
            int[] iArr = new int[PointStyle.values().length];
            $SwitchMap$org$achartengine$chart$PointStyle = iArr;
            try {
                iArr[PointStyle.X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.SQUARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.DIAMOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.POINT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ScatterChart() {
        this.size = 3.0f;
    }

    private void drawCircle(Canvas canvas, Paint paint, float f, float f2) {
        canvas.drawCircle(f, f2, this.size, paint);
    }

    private void drawDiamond(Canvas canvas, Paint paint, float[] fArr, float f, float f2) {
        fArr[0] = f;
        float f3 = this.size;
        fArr[1] = f2 - f3;
        fArr[2] = f - f3;
        fArr[3] = f2;
        fArr[4] = f;
        fArr[5] = f2 + f3;
        fArr[6] = f + f3;
        fArr[7] = f2;
        drawPath(canvas, fArr, paint, true);
    }

    private void drawSquare(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.size;
        canvas.drawRect(f - f3, f2 - f3, f + f3, f2 + f3, paint);
    }

    private void drawTriangle(Canvas canvas, Paint paint, float[] fArr, float f, float f2) {
        fArr[0] = f;
        float f3 = this.size;
        fArr[1] = (f2 - f3) - (f3 / 2.0f);
        fArr[2] = f - f3;
        float f4 = f2 + f3;
        fArr[3] = f4;
        fArr[4] = f + f3;
        fArr[5] = f4;
        drawPath(canvas, fArr, paint, true);
    }

    private void drawX(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.size;
        canvas.drawLine(f - f3, f2 - f3, f + f3, f2 + f3, paint);
        float f4 = this.size;
        canvas.drawLine(f + f4, f2 - f4, f - f4, f2 + f4, paint);
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
        XYSeriesRenderer xYSeriesRenderer = (XYSeriesRenderer) simpleSeriesRenderer;
        paint.setStyle(xYSeriesRenderer.isFillPoints() ? Paint.Style.FILL : Paint.Style.STROKE);
        switch (1.$SwitchMap$org$achartengine$chart$PointStyle[xYSeriesRenderer.getPointStyle().ordinal()]) {
            case 1:
                drawX(canvas, paint, f + 10.0f, f2);
                break;
            case 2:
                drawCircle(canvas, paint, f + 10.0f, f2);
                break;
            case 3:
                drawTriangle(canvas, paint, new float[6], f + 10.0f, f2);
                break;
            case 4:
                drawSquare(canvas, paint, f + 10.0f, f2);
                break;
            case 5:
                drawDiamond(canvas, paint, new float[8], f + 10.0f, f2);
                break;
            case 6:
                canvas.drawPoint(f + 10.0f, f2, paint);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void drawSeries(Canvas canvas, Paint paint, List list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        Paint.Style style;
        paint.setColor(xYSeriesRenderer.getColor());
        float strokeWidth = paint.getStrokeWidth();
        if (xYSeriesRenderer.isFillPoints()) {
            style = Paint.Style.FILL;
        } else {
            paint.setStrokeWidth(xYSeriesRenderer.getPointStrokeWidth());
            style = Paint.Style.STROKE;
        }
        paint.setStyle(style);
        int size = list.size();
        int i3 = 0;
        switch (1.$SwitchMap$org$achartengine$chart$PointStyle[xYSeriesRenderer.getPointStyle().ordinal()]) {
            case 1:
                paint.setStrokeWidth(xYSeriesRenderer.getPointStrokeWidth());
                while (i3 < size) {
                    drawX(canvas, paint, ((Float) list.get(i3)).floatValue(), ((Float) list.get(i3 + 1)).floatValue());
                    i3 += 2;
                }
                break;
            case 2:
                while (i3 < size) {
                    drawCircle(canvas, paint, ((Float) list.get(i3)).floatValue(), ((Float) list.get(i3 + 1)).floatValue());
                    i3 += 2;
                }
                break;
            case 3:
                float[] fArr = new float[6];
                while (i3 < size) {
                    drawTriangle(canvas, paint, fArr, ((Float) list.get(i3)).floatValue(), ((Float) list.get(i3 + 1)).floatValue());
                    i3 += 2;
                }
                break;
            case 4:
                while (i3 < size) {
                    drawSquare(canvas, paint, ((Float) list.get(i3)).floatValue(), ((Float) list.get(i3 + 1)).floatValue());
                    i3 += 2;
                }
                break;
            case 5:
                float[] fArr2 = new float[8];
                while (i3 < size) {
                    drawDiamond(canvas, paint, fArr2, ((Float) list.get(i3)).floatValue(), ((Float) list.get(i3 + 1)).floatValue());
                    i3 += 2;
                }
                break;
            case 6:
                while (i3 < size) {
                    canvas.drawPoint(((Float) list.get(i3)).floatValue(), ((Float) list.get(i3 + 1)).floatValue(), paint);
                    i3 += 2;
                }
                break;
        }
        paint.setStrokeWidth(strokeWidth);
    }

    public String getChartType() {
        return "Scatter";
    }

    public int getLegendShapeWidth(int i) {
        return 10;
    }

    public void setDatasetRenderer(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super.setDatasetRenderer(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.size = xYMultipleSeriesRenderer.getPointSize();
    }

    public ScatterChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.size = 3.0f;
        this.size = xYMultipleSeriesRenderer.getPointSize();
    }
}
