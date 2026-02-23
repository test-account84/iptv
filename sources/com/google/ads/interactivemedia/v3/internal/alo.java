package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class alo implements OnFailureListener {
    public final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public /* synthetic */ alo(alq alqVar, int i) {
        this.b = i;
        this.a = alqVar;
    }

    public final void onFailure(Exception exc) {
        int i = this.b;
        if (i == 0) {
            ((TaskCompletionSource) this.a).setException(exc);
        } else if (i != 1) {
            ((alx) this.a).c(exc);
        } else {
            ((alq) this.a).b(exc);
        }
    }

    public /* synthetic */ alo(alx alxVar, int i) {
        this.b = i;
        this.a = alxVar;
    }

    public /* synthetic */ alo(TaskCompletionSource taskCompletionSource, int i) {
        this.b = i;
        this.a = taskCompletionSource;
    }
}
