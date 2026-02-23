package com.google.ads.interactivemedia.v3.internal;

import android.media.Spatializer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class vx implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ wd a;

    public vx(wd wdVar) {
        this.a = wdVar;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        wd.f(this.a);
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        wd.f(this.a);
    }
}
