package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsCollectSignalsCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class als implements SecureSignalsCollectSignalsCallback {
    final /* synthetic */ TaskCompletionSource a;
    final /* synthetic */ alt b;

    public als(alt altVar, TaskCompletionSource taskCompletionSource) {
        this.b = altVar;
        this.a = taskCompletionSource;
    }

    public final void onFailure(Exception exc) {
        this.a.trySetException(exc);
    }

    public final void onSuccess(String str) {
        this.a.trySetResult(com.google.ads.interactivemedia.v3.impl.data.bw.createBy3rdPartyData(alt.a(this.b).getVersion(), alt.a(this.b).getSDKVersion(), this.b.e(), str));
    }
}
