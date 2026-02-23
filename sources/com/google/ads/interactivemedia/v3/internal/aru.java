package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aru {
    public static final /* synthetic */ int a = 0;
    private static volatile int f = afj.a;
    private final Context b;
    private final Executor c;
    private final Task d;
    private final boolean e;

    public aru(Context context, Executor executor, Task task, boolean z) {
        this.b = context;
        this.c = executor;
        this.d = task;
        this.e = z;
    }

    public static aru a(Context context, Executor executor, boolean z) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(z ? new jc(context, taskCompletionSource, 10) : new ky(taskCompletionSource, 4));
        return new aru(context, executor, taskCompletionSource.getTask(), z);
    }

    public static void g(int i) {
        f = i;
    }

    private final Task h(int i, long j, Exception exc, String str, String str2) {
        if (!this.e) {
            return this.d.continueWith(this.c, ars.a);
        }
        afl j2 = afk.j();
        j2.a(this.b.getPackageName());
        j2.e(j);
        j2.g(f);
        if (exc != null) {
            j2.f(atr.a(exc));
            j2.d(exc.getClass().getName());
        }
        if (str2 != null) {
            j2.b(str2);
        }
        if (str != null) {
            j2.c(str);
        }
        return this.d.continueWith(this.c, new art(j2, i, null));
    }

    public final void b(int i, String str) {
        h(i, 0L, null, null, str);
    }

    public final void c(int i, long j, Exception exc) {
        h(i, j, exc, null, null);
    }

    public final void d(int i, long j) {
        h(i, j, null, null, null);
    }

    public final void e(int i, long j, String str) {
        h(i, j, null, null, str);
    }

    public final void f(int i, long j, String str) {
        h(i, j, null, str, null);
    }
}
