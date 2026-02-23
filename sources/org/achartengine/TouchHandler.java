package org.achartengine;

import android.graphics.RectF;
import android.view.MotionEvent;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.tools.Pan;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.Zoom;
import org.achartengine.tools.ZoomListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TouchHandler implements ITouchHandler {
    private GraphicalView graphicalView;
    private Pan mPan;
    private Zoom mPinchZoom;
    private DefaultRenderer mRenderer;
    private float oldX;
    private float oldX2;
    private float oldY;
    private float oldY2;
    private RectF zoomR;

    public TouchHandler(GraphicalView graphicalView, AbstractChart abstractChart) {
        this.zoomR = new RectF();
        this.graphicalView = graphicalView;
        this.zoomR = graphicalView.getZoomRectangle();
        this.mRenderer = abstractChart instanceof XYChart ? ((XYChart) abstractChart).getRenderer() : ((RoundChart) abstractChart).getRenderer();
        if (this.mRenderer.isPanEnabled()) {
            this.mPan = new Pan(abstractChart);
        }
        if (this.mRenderer.isZoomEnabled()) {
            this.mPinchZoom = new Zoom(abstractChart, true, 1.0f);
        }
    }

    private void applyZoom(float f, int i) {
        float min = Math.min(Math.max(f, 0.9f), 1.1f);
        Zoom zoom = this.mPinchZoom;
        if (zoom != null) {
            double d = min;
            if (d <= 0.9d || d >= 1.1d) {
                return;
            }
            zoom.setZoomRate(min);
            this.mPinchZoom.apply(i);
        }
    }

    public void addPanListener(PanListener panListener) {
        Pan pan = this.mPan;
        if (pan != null) {
            pan.addPanListener(panListener);
        }
    }

    public void addZoomListener(ZoomListener zoomListener) {
        Zoom zoom = this.mPinchZoom;
        if (zoom != null) {
            zoom.addZoomListener(zoomListener);
        }
    }

    public boolean handleTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mRenderer == null || action != 2) {
            if (action == 0) {
                this.oldX = motionEvent.getX(0);
                this.oldY = motionEvent.getY(0);
                DefaultRenderer defaultRenderer = this.mRenderer;
                if (defaultRenderer != null && defaultRenderer.isZoomEnabled() && this.zoomR.contains(this.oldX, this.oldY)) {
                    float f = this.oldX;
                    RectF rectF = this.zoomR;
                    if (f < rectF.left + (rectF.width() / 3.0f)) {
                        this.graphicalView.zoomIn();
                    } else {
                        float f2 = this.oldX;
                        RectF rectF2 = this.zoomR;
                        if (f2 < rectF2.left + ((rectF2.width() * 2.0f) / 3.0f)) {
                            this.graphicalView.zoomOut();
                        } else {
                            this.graphicalView.zoomReset();
                        }
                    }
                    return true;
                }
            } else if (action == 1 || action == 6) {
                this.oldX = 0.0f;
                this.oldY = 0.0f;
                this.oldX2 = 0.0f;
                this.oldY2 = 0.0f;
                if (action == 6) {
                    this.oldX = -1.0f;
                    this.oldY = -1.0f;
                }
            }
        } else if (this.oldX >= 0.0f || this.oldY >= 0.0f) {
            float x = motionEvent.getX(0);
            float y = motionEvent.getY(0);
            if (motionEvent.getPointerCount() > 1 && ((this.oldX2 >= 0.0f || this.oldY2 >= 0.0f) && this.mRenderer.isZoomEnabled())) {
                float x2 = motionEvent.getX(1);
                float y2 = motionEvent.getY(1);
                float abs = Math.abs(x - x2);
                float abs2 = Math.abs(y - y2);
                float abs3 = Math.abs(this.oldX - this.oldX2);
                float abs4 = Math.abs(this.oldY - this.oldY2);
                float abs5 = Math.abs(y - this.oldY) / Math.abs(x - this.oldX);
                float abs6 = Math.abs(y2 - this.oldY2) / Math.abs(x2 - this.oldX2);
                double d = abs5;
                if (d <= 0.25d && abs6 <= 0.25d) {
                    applyZoom(abs / abs3, 1);
                } else if (d < 3.73d || abs6 < 3.73d) {
                    applyZoom(Math.abs(x - this.oldX) >= Math.abs(y - this.oldY) ? abs / abs3 : abs2 / abs4, 0);
                } else {
                    applyZoom(abs2 / abs4, 2);
                }
                this.oldX2 = x2;
                this.oldY2 = y2;
            } else if (this.mRenderer.isPanEnabled()) {
                this.mPan.apply(this.oldX, this.oldY, x, y);
                this.oldX2 = 0.0f;
                this.oldY2 = 0.0f;
            }
            this.oldX = x;
            this.oldY = y;
            this.graphicalView.repaint();
            return true;
        }
        return !this.mRenderer.isClickEnabled();
    }

    public void removePanListener(PanListener panListener) {
        Pan pan = this.mPan;
        if (pan != null) {
            pan.removePanListener(panListener);
        }
    }

    public void removeZoomListener(ZoomListener zoomListener) {
        Zoom zoom = this.mPinchZoom;
        if (zoom != null) {
            zoom.removeZoomListener(zoomListener);
        }
    }
}
