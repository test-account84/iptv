package org.achartengine;

import android.graphics.RectF;
import android.view.MotionEvent;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.tools.Pan;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.ZoomListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TouchHandlerOld implements ITouchHandler {
    private GraphicalView graphicalView;
    private Pan mPan;
    private DefaultRenderer mRenderer;
    private float oldX;
    private float oldY;
    private RectF zoomR;

    public TouchHandlerOld(GraphicalView graphicalView, AbstractChart abstractChart) {
        this.zoomR = new RectF();
        this.graphicalView = graphicalView;
        this.zoomR = graphicalView.getZoomRectangle();
        this.mRenderer = abstractChart instanceof XYChart ? ((XYChart) abstractChart).getRenderer() : ((RoundChart) abstractChart).getRenderer();
        if (this.mRenderer.isPanEnabled()) {
            this.mPan = new Pan(abstractChart);
        }
    }

    public void addPanListener(PanListener panListener) {
        Pan pan = this.mPan;
        if (pan != null) {
            pan.addPanListener(panListener);
        }
    }

    public void addZoomListener(ZoomListener zoomListener) {
    }

    public boolean handleTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mRenderer == null || action != 2) {
            if (action == 0) {
                this.oldX = motionEvent.getX();
                this.oldY = motionEvent.getY();
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
            } else if (action == 1) {
                this.oldX = 0.0f;
                this.oldY = 0.0f;
            }
        } else if (this.oldX >= 0.0f || this.oldY >= 0.0f) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.mRenderer.isPanEnabled()) {
                this.mPan.apply(this.oldX, this.oldY, x, y);
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
    }
}
