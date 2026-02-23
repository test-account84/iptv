package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y implements OnCompleteListener {
    public final /* synthetic */ TaskCompletionSource a;
    public final /* synthetic */ z b;

    public y(z zVar, TaskCompletionSource taskCompletionSource) {
        this.b = zVar;
        this.a = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        z.b(this.b).remove(this.a);
    }
}
