package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class alw implements OnFailureListener {
    public final /* synthetic */ alx a;
    public final /* synthetic */ alt b;

    public /* synthetic */ alw(alx alxVar, alt altVar) {
        this.a = alxVar;
        this.b = altVar;
    }

    public final void onFailure(Exception exc) {
        this.a.e(this.b, exc);
    }
}
