package com.onesignal;

import android.view.animation.Interpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class J1 implements Interpolator {
    public double a;
    public double b;

    public J1(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.718281828459045d, (-f) / this.a) * (-1.0d) * Math.cos(this.b * f)) + 1.0d);
    }
}
