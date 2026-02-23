package org.achartengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.tools.FitZoom;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.Zoom;
import org.achartengine.tools.ZoomListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class GraphicalView extends View {
    private static final int ZOOM_BUTTONS_COLOR = Color.argb(175, 150, 150, 150);
    private Bitmap fitZoomImage;
    private AbstractChart mChart;
    private boolean mDrawn;
    private FitZoom mFitZoom;
    private Handler mHandler;
    private Paint mPaint;
    private Rect mRect;
    private DefaultRenderer mRenderer;
    private ITouchHandler mTouchHandler;
    private Zoom mZoomIn;
    private Zoom mZoomOut;
    private RectF mZoomR;
    private float oldX;
    private float oldY;
    private Bitmap zoomInImage;
    private Bitmap zoomOutImage;
    private int zoomSize;

    public class 1 implements Runnable {
        public 1() {
        }

        public void run() {
            GraphicalView.this.invalidate();
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ int val$bottom;
        final /* synthetic */ int val$left;
        final /* synthetic */ int val$right;
        final /* synthetic */ int val$top;

        public 2(int i, int i2, int i3, int i4) {
            this.val$left = i;
            this.val$top = i2;
            this.val$right = i3;
            this.val$bottom = i4;
        }

        public void run() {
            GraphicalView.this.invalidate(this.val$left, this.val$top, this.val$right, this.val$bottom);
        }
    }

    public GraphicalView(Context context, AbstractChart abstractChart) {
        int i;
        super(context);
        this.mRect = new Rect();
        this.mZoomR = new RectF();
        this.zoomSize = 50;
        this.mPaint = new Paint();
        this.mChart = abstractChart;
        this.mHandler = new Handler();
        AbstractChart abstractChart2 = this.mChart;
        this.mRenderer = abstractChart2 instanceof XYChart ? ((XYChart) abstractChart2).getRenderer() : ((RoundChart) abstractChart2).getRenderer();
        if (this.mRenderer.isZoomButtonsVisible()) {
            this.zoomInImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom_in.png"));
            this.zoomOutImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom_out.png"));
            this.fitZoomImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom-1.png"));
        }
        DefaultRenderer defaultRenderer = this.mRenderer;
        if ((defaultRenderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer) defaultRenderer).getMarginsColor() == 0) {
            ((XYMultipleSeriesRenderer) this.mRenderer).setMarginsColor(this.mPaint.getColor());
        }
        if ((this.mRenderer.isZoomEnabled() && this.mRenderer.isZoomButtonsVisible()) || this.mRenderer.isExternalZoomEnabled()) {
            this.mZoomIn = new Zoom(this.mChart, true, this.mRenderer.getZoomRate());
            this.mZoomOut = new Zoom(this.mChart, false, this.mRenderer.getZoomRate());
            this.mFitZoom = new FitZoom(this.mChart);
        }
        try {
            i = Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (Exception unused) {
            i = 7;
        }
        this.mTouchHandler = i < 7 ? new TouchHandlerOld(this, this.mChart) : new TouchHandler(this, this.mChart);
    }

    public void addPanListener(PanListener panListener) {
        this.mTouchHandler.addPanListener(panListener);
    }

    public void addZoomListener(ZoomListener zoomListener, boolean z, boolean z2) {
        Zoom zoom;
        if (z && (zoom = this.mZoomIn) != null) {
            zoom.addZoomListener(zoomListener);
            this.mZoomOut.addZoomListener(zoomListener);
        }
        if (z2) {
            this.mTouchHandler.addZoomListener(zoomListener);
        }
    }

    public AbstractChart getChart() {
        return this.mChart;
    }

    public SeriesSelection getCurrentSeriesAndPoint() {
        return this.mChart.getSeriesAndPointForScreenCoordinate(new Point(this.oldX, this.oldY));
    }

    public RectF getZoomRectangle() {
        return this.mZoomR;
    }

    public boolean isChartDrawn() {
        return this.mDrawn;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mRect);
        Rect rect = this.mRect;
        int i = rect.top;
        int i2 = rect.left;
        int width = rect.width();
        int height = this.mRect.height();
        if (this.mRenderer.isInScroll()) {
            width = getMeasuredWidth();
            height = getMeasuredHeight();
            i = 0;
            i2 = 0;
        }
        this.mChart.draw(canvas, i2, i, width, height, this.mPaint);
        DefaultRenderer defaultRenderer = this.mRenderer;
        if (defaultRenderer != null && defaultRenderer.isZoomEnabled() && this.mRenderer.isZoomButtonsVisible()) {
            this.mPaint.setColor(ZOOM_BUTTONS_COLOR);
            int max = Math.max(this.zoomSize, Math.min(width, height) / 7);
            this.zoomSize = max;
            float f = i + height;
            float f2 = i2 + width;
            this.mZoomR.set(r2 - (max * 3), f - (max * 0.775f), f2, f);
            RectF rectF = this.mZoomR;
            int i3 = this.zoomSize;
            canvas.drawRoundRect(rectF, i3 / 3, i3 / 3, this.mPaint);
            int i4 = this.zoomSize;
            float f3 = f - (i4 * 0.625f);
            canvas.drawBitmap(this.zoomInImage, f2 - (i4 * 2.75f), f3, (Paint) null);
            canvas.drawBitmap(this.zoomOutImage, f2 - (this.zoomSize * 1.75f), f3, (Paint) null);
            canvas.drawBitmap(this.fitZoomImage, f2 - (this.zoomSize * 0.75f), f3, (Paint) null);
        }
        this.mDrawn = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.oldX = motionEvent.getX();
            this.oldY = motionEvent.getY();
        }
        DefaultRenderer defaultRenderer = this.mRenderer;
        if (defaultRenderer != null && this.mDrawn && ((defaultRenderer.isPanEnabled() || this.mRenderer.isZoomEnabled()) && this.mTouchHandler.handleTouch(motionEvent))) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removePanListener(PanListener panListener) {
        this.mTouchHandler.removePanListener(panListener);
    }

    public synchronized void removeZoomListener(ZoomListener zoomListener) {
        try {
            Zoom zoom = this.mZoomIn;
            if (zoom != null) {
                zoom.removeZoomListener(zoomListener);
                this.mZoomOut.removeZoomListener(zoomListener);
            }
            this.mTouchHandler.removeZoomListener(zoomListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void repaint() {
        this.mHandler.post(new 1());
    }

    public void setZoomRate(float f) {
        Zoom zoom = this.mZoomIn;
        if (zoom == null || this.mZoomOut == null) {
            return;
        }
        zoom.setZoomRate(f);
        this.mZoomOut.setZoomRate(f);
    }

    public Bitmap toBitmap() {
        setDrawingCacheEnabled(false);
        if (!isDrawingCacheEnabled()) {
            setDrawingCacheEnabled(true);
        }
        if (this.mRenderer.isApplyBackgroundColor()) {
            setDrawingCacheBackgroundColor(this.mRenderer.getBackgroundColor());
        }
        setDrawingCacheQuality(1048576);
        return getDrawingCache(true);
    }

    public double[] toRealPoint(int i) {
        AbstractChart abstractChart = this.mChart;
        if (abstractChart instanceof XYChart) {
            return ((XYChart) abstractChart).toRealPoint(this.oldX, this.oldY, i);
        }
        return null;
    }

    public void zoomIn() {
        Zoom zoom = this.mZoomIn;
        if (zoom != null) {
            zoom.apply(0);
            repaint();
        }
    }

    public void zoomOut() {
        Zoom zoom = this.mZoomOut;
        if (zoom != null) {
            zoom.apply(0);
            repaint();
        }
    }

    public void zoomReset() {
        FitZoom fitZoom = this.mFitZoom;
        if (fitZoom != null) {
            fitZoom.apply();
            this.mZoomIn.notifyZoomResetListeners();
            repaint();
        }
    }

    public void repaint(int i, int i2, int i3, int i4) {
        this.mHandler.post(new 2(i, i2, i3, i4));
    }
}
