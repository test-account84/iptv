package com.google.android.gms.measurement;

import M4.T1;
import M4.U1;
import android.content.Context;
import android.content.Intent;
import k0.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class AppMeasurementReceiver extends a implements T1 {
    public U1 d;

    public void a(Context context, Intent intent) {
        a.c(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.d == null) {
            this.d = new U1(this);
        }
        this.d.a(context, intent);
    }
}
