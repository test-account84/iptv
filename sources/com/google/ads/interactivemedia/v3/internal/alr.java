package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsInitializeCallback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class alr implements SecureSignalsInitializeCallback {
    final /* synthetic */ alt a;

    public alr(alt altVar) {
        this.a = altVar;
    }

    public final void onFailure(Exception exc) {
        alt.d(this.a).trySetException(exc);
    }

    public final void onSuccess() {
        alt.d(this.a).trySetResult(null);
    }
}
