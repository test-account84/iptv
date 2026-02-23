package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class alq {
    private final Context a;
    private final ExecutorService b;
    private final aib c;
    private final alm d;
    private final TaskCompletionSource e;
    private Integer f;

    public alq(Context context, ExecutorService executorService, alm almVar) {
        alp alpVar = new alp(null);
        this.e = new TaskCompletionSource();
        this.a = context;
        this.b = executorService;
        this.d = almVar;
        this.c = alpVar;
    }

    public final Map a() {
        try {
            Task task = this.e.getTask();
            return (Map) Tasks.await(this.f == null ? Tasks.forResult(null) : Tasks.withTimeout(task, r2.intValue(), TimeUnit.MILLISECONDS).addOnFailureListener(new alo(this, 1)));
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public final /* synthetic */ void b(Exception exc) {
        this.d.b(com.google.ads.interactivemedia.v3.impl.data.bi.PLATFORM_SIGNAL_COLLECTOR, com.google.ads.interactivemedia.v3.impl.data.bj.PLATFORM_COLLECT_SIGNALS, exc);
    }

    public final void c(Integer num) {
        this.f = num;
        Task forResult = Tasks.forResult(null);
        forResult.addOnSuccessListener(new aln(this.e));
        forResult.addOnFailureListener(new alo(this.e, 0));
    }
}
