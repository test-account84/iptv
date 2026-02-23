package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ h a;

    public a(h hVar) {
        this.a = hVar;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        h hVar = this.a;
        if (h.c(hVar) == null) {
            return true;
        }
        if (h.m(hVar, x, y) && h.e(this.a).g(x, y)) {
            return true;
        }
        h.c(this.a).zza();
        return true;
    }
}
