package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseBooleanArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p {
    private final SparseBooleanArray a = new SparseBooleanArray();
    private boolean b;

    public final q a() {
        af.w(!this.b);
        this.b = true;
        return new q(this.a);
    }

    public final void b(int i) {
        af.w(!this.b);
        this.a.append(i, true);
    }
}
