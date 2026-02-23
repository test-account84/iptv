package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ g c;

    public b(h hVar, View view, boolean z, g gVar) {
        this.a = view;
        this.c = gVar;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.a.getParent() != null) {
            this.a.performClick();
        }
        this.c.zzb();
        return true;
    }
}
