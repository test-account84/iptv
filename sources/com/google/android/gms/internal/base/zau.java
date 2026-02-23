package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zau extends Handler {
    private final Looper zaa;

    public zau() {
        this.zaa = Looper.getMainLooper();
    }

    public zau(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public zau(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
