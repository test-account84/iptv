package com.google.android.recaptcha.internal;

import G8.T;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import k8.q;
import kotlin.jvm.internal.m;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zza extends m implements l {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ T zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zza(TaskCompletionSource taskCompletionSource, T t) {
        super(1);
        this.zza = taskCompletionSource;
        this.zzb = t;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        Exception exc = (Throwable) obj;
        if (exc instanceof CancellationException) {
            this.zza.setException(exc);
        } else {
            Exception e = this.zzb.e();
            if (e == null) {
                this.zza.setResult(this.zzb.c());
            } else {
                TaskCompletionSource taskCompletionSource = this.zza;
                Exception exc2 = e instanceof Exception ? e : null;
                if (exc2 == null) {
                    exc2 = new RuntimeExecutionException(e);
                }
                taskCompletionSource.setException(exc2);
            }
        }
        return q.a;
    }
}
