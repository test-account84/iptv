package org.achartengine.renderer;

import android.graphics.Paint;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BasicStroke implements Serializable {
    public static final BasicStroke DASHED;
    public static final BasicStroke DOTTED;
    public static final BasicStroke SOLID = new BasicStroke(Paint.Cap.BUTT, Paint.Join.MITER, 4.0f, null, 0.0f);
    private Paint.Cap mCap;
    private float[] mIntervals;
    private Paint.Join mJoin;
    private float mMiter;
    private float mPhase;

    static {
        Paint.Cap cap = Paint.Cap.ROUND;
        Paint.Join join = Paint.Join.BEVEL;
        DASHED = new BasicStroke(cap, join, 10.0f, new float[]{10.0f, 10.0f}, 1.0f);
        DOTTED = new BasicStroke(cap, join, 5.0f, new float[]{2.0f, 10.0f}, 1.0f);
    }

    public BasicStroke(Paint.Cap cap, Paint.Join join, float f, float[] fArr, float f2) {
        this.mCap = cap;
        this.mJoin = join;
        this.mMiter = f;
        this.mIntervals = fArr;
    }

    public Paint.Cap getCap() {
        return this.mCap;
    }

    public float[] getIntervals() {
        return this.mIntervals;
    }

    public Paint.Join getJoin() {
        return this.mJoin;
    }

    public float getMiter() {
        return this.mMiter;
    }

    public float getPhase() {
        return this.mPhase;
    }
}
