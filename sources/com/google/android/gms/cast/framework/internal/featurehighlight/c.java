package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements View.OnLayoutChangeListener {
    public final /* synthetic */ h a;

    public c(h hVar, Runnable runnable) {
        this.a = hVar;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a.k();
        this.a.removeOnLayoutChangeListener(this);
    }
}
