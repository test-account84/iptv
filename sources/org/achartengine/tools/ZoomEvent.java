package org.achartengine.tools;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ZoomEvent {
    private boolean mZoomIn;
    private float mZoomRate;

    public ZoomEvent(boolean z, float f) {
        this.mZoomIn = z;
        this.mZoomRate = f;
    }

    public float getZoomRate() {
        return this.mZoomRate;
    }

    public boolean isZoomIn() {
        return this.mZoomIn;
    }
}
