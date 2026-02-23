package com.google.android.gms.tasks;

import android.os.Looper;
import com.google.android.gms.common.internal.r;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class Tasks {
    private Tasks() {
    }

    public static Object await(Task task) throws ExecutionException, InterruptedException {
        r.k();
        r.i();
        r.n(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzadVar = new zzad(null);
        zzb(task, zzadVar);
        zzadVar.zza();
        return zza(task);
    }

    @Deprecated
    public static Task call(Callable callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static Task forCanceled() {
        zzw zzwVar = new zzw();
        zzwVar.zzc();
        return zzwVar;
    }

    public static Task forException(Exception exc) {
        zzw zzwVar = new zzw();
        zzwVar.zza(exc);
        return zzwVar;
    }

    public static Task forResult(Object obj) {
        zzw zzwVar = new zzw();
        zzwVar.zzb(obj);
        return zzwVar;
    }

    public static Task whenAll(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(null);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((Task) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzw zzwVar = new zzw();
        zzaf zzafVar = new zzaf(collection.size(), zzwVar);
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            zzb((Task) it2.next(), zzafVar);
        }
        return zzwVar;
    }

    public static Task whenAllComplete(Collection collection) {
        return whenAllComplete(TaskExecutors.MAIN_THREAD, collection);
    }

    public static Task whenAllSuccess(Collection collection) {
        return whenAllSuccess(TaskExecutors.MAIN_THREAD, collection);
    }

    public static Task withTimeout(Task task, long j, TimeUnit timeUnit) {
        r.n(task, "Task must not be null");
        r.b(j > 0, "Timeout must be positive");
        r.n(timeUnit, "TimeUnit must not be null");
        zzb zzbVar = new zzb();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(zzbVar);
        com.google.android.gms.internal.tasks.zza zzaVar = new com.google.android.gms.internal.tasks.zza(Looper.getMainLooper());
        zzaVar.postDelayed(new zzx(taskCompletionSource), timeUnit.toMillis(j));
        task.addOnCompleteListener(new zzy(zzaVar, taskCompletionSource, zzbVar));
        return taskCompletionSource.getTask();
    }

    private static Object zza(Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static void zzb(Task task, zzae zzaeVar) {
        Executor executor = TaskExecutors.zza;
        task.addOnSuccessListener(executor, zzaeVar);
        task.addOnFailureListener(executor, zzaeVar);
        task.addOnCanceledListener(executor, zzaeVar);
    }

    public static Object await(Task task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        r.k();
        r.i();
        r.n(task, "Task must not be null");
        r.n(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzadVar = new zzad(null);
        zzb(task, zzadVar);
        if (zzadVar.zzb(j, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @Deprecated
    public static Task call(Executor executor, Callable callable) {
        r.n(executor, "Executor must not be null");
        r.n(callable, "Callback must not be null");
        zzw zzwVar = new zzw();
        executor.execute(new zzz(zzwVar, callable));
        return zzwVar;
    }

    public static Task whenAll(Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(null) : whenAll((Collection) Arrays.asList(taskArr));
    }

    public static Task whenAllComplete(Executor executor, Collection collection) {
        return (collection == null || collection.isEmpty()) ? forResult(Collections.emptyList()) : whenAll(collection).continueWithTask(executor, new zzab(collection));
    }

    public static Task whenAllSuccess(Executor executor, Collection collection) {
        return (collection == null || collection.isEmpty()) ? forResult(Collections.emptyList()) : whenAll(collection).continueWith(executor, new zzaa(collection));
    }

    public static Task whenAllComplete(Executor executor, Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(Collections.emptyList()) : whenAllComplete(executor, (Collection) Arrays.asList(taskArr));
    }

    public static Task whenAllSuccess(Executor executor, Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(Collections.emptyList()) : whenAllSuccess(executor, (Collection) Arrays.asList(taskArr));
    }

    public static Task whenAllComplete(Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(Collections.emptyList()) : whenAllComplete((Collection) Arrays.asList(taskArr));
    }

    public static Task whenAllSuccess(Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? forResult(Collections.emptyList()) : whenAllSuccess((Collection) Arrays.asList(taskArr));
    }
}
