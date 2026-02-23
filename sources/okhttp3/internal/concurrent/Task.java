package okhttp3.internal.concurrent;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class Task {
    private final boolean cancelable;

    @NotNull
    private final String name;
    private long nextExecuteNanoTime;

    @Nullable
    private TaskQueue queue;

    public Task(@NotNull String name, boolean z) {
        l.e(name, "name");
        this.name = name;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1L;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    @Nullable
    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(@NotNull TaskQueue queue) {
        l.e(queue, "queue");
        TaskQueue taskQueue = this.queue;
        if (taskQueue == queue) {
            return;
        }
        if (!(taskQueue == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.queue = queue;
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long j) {
        this.nextExecuteNanoTime = j;
    }

    public final void setQueue$okhttp(@Nullable TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    public /* synthetic */ Task(String str, boolean z, int i, g gVar) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
