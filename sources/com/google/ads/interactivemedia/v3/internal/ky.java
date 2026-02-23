package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class ky implements Runnable {
    public final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public /* synthetic */ ky(im imVar, int i) {
        this.b = i;
        this.a = imVar;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.ads.interactivemedia.v3.internal.pg, java.lang.Object] */
    public final void run() {
        int i = this.b;
        if (i == 0) {
            lh.d((lh) this.a);
            return;
        }
        if (i == 1) {
            im.V((im) this.a);
            return;
        }
        if (i == 2) {
            ((lh) this.a).g();
        } else {
            if (i == 3) {
                this.a.n();
                return;
            }
            ((TaskCompletionSource) this.a).setResult(ata.b());
        }
    }

    public /* synthetic */ ky(lh lhVar, int i) {
        this.b = i;
        this.a = lhVar;
    }

    public /* synthetic */ ky(pg pgVar, int i) {
        this.b = i;
        this.a = pgVar;
    }

    public /* synthetic */ ky(TaskCompletionSource taskCompletionSource, int i) {
        this.b = i;
        this.a = taskCompletionSource;
    }
}
