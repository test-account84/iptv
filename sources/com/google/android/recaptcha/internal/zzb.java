package com.google.android.recaptcha.internal;

import G8.T;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzb {
    @NotNull
    public static final Task zza(@NotNull T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        t.i(new zza(taskCompletionSource, t));
        return taskCompletionSource.getTask();
    }
}
