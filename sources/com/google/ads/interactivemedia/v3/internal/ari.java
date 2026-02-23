package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ari extends aqw {
    final /* synthetic */ TaskCompletionSource a;

    public ari(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    public final void b(int i) {
        this.a.trySetException(new arf(i));
    }

    public final void c(arc arcVar) {
        this.a.trySetResult(arcVar.a());
    }
}
