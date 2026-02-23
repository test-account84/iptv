package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ax {
    public abstract ay build();

    public abstract ax height(int i);

    public abstract ax left(int i);

    public ax locationOnScreenOfView(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return left(iArr[0]).top(iArr[1]).height(view.getHeight()).width(view.getWidth());
    }

    public abstract ax top(int i);

    public abstract ax width(int i);
}
