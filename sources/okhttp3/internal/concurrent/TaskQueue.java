package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import k8.q;
import kotlin.jvm.internal.l;
import l8.s;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class TaskQueue {

    @Nullable
    private Task activeTask;
    private boolean cancelActiveTask;

    @NotNull
    private final List futureTasks;

    @NotNull
    private final String name;
    private boolean shutdown;

    @NotNull
    private final TaskRunner taskRunner;

    public static final class AwaitIdleTask extends Task {

        @NotNull
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(Util.okHttpName + " awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }

        @NotNull
        public final CountDownLatch getLatch() {
            return this.latch;
        }

        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public static final class 1 extends Task {
        final /* synthetic */ a $block;
        final /* synthetic */ boolean $cancelable;
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(a aVar, String str, boolean z, String str2, boolean z2) {
            super(str2, z2);
            this.$block = aVar;
            this.$name = str;
            this.$cancelable = z;
        }

        public long runOnce() {
            this.$block.invoke();
            return -1L;
        }
    }

    public static final class 2 extends Task {
        final /* synthetic */ a $block;
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 2(a aVar, String str, String str2) {
            super(str2, false, 2, null);
            this.$block = aVar;
            this.$name = str;
        }

        public long runOnce() {
            return ((Number) this.$block.invoke()).longValue();
        }
    }

    public TaskQueue(@NotNull TaskRunner taskRunner, @NotNull String name) {
        l.e(taskRunner, "taskRunner");
        l.e(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String name, long j, boolean z, a block, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        boolean z2 = (i & 4) != 0 ? true : z;
        l.e(name, "name");
        l.e(block, "block");
        taskQueue.schedule(new 1(block, name, z2, name, z2), j);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String name, long j, a block, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        l.e(name, "name");
        l.e(block, "block");
        taskQueue.schedule(new 2(block, name, name), j);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        synchronized (this.taskRunner) {
            try {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                q qVar = q.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            l.b(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z = false;
        for (int size = this.futureTasks.size() - 1; size >= 0; size--) {
            if (((Task) this.futureTasks.get(size)).getCancelable()) {
                Task task2 = (Task) this.futureTasks.get(size);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void execute(@NotNull String name, long j, boolean z, @NotNull a block) {
        l.e(name, "name");
        l.e(block, "block");
        schedule(new 1(block, name, z, name, z), j);
    }

    @Nullable
    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    @NotNull
    public final List getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    @NotNull
    public final String getName$okhttp() {
        return this.name;
    }

    @NotNull
    public final List getScheduledTasks() {
        List L;
        synchronized (this.taskRunner) {
            L = s.L(this.futureTasks);
        }
        return L;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(@NotNull String name, long j, @NotNull a block) {
        l.e(name, "name");
        l.e(block, "block");
        schedule(new 2(block, name, name), j);
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task task, long j, boolean z) {
        StringBuilder sb;
        String str;
        l.e(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j2 = nanoTime + j;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j2) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j2);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z) {
                sb = new StringBuilder();
                str = "run again after ";
            } else {
                sb = new StringBuilder();
                str = "scheduled after ";
            }
            sb.append(str);
            sb.append(TaskLoggerKt.formatDuration(j2 - nanoTime));
            TaskLoggerKt.access$log(task, this, sb.toString());
        }
        Iterator it = this.futureTasks.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((Task) it.next()).getNextExecuteNanoTime$okhttp() - nanoTime > j) {
                break;
            }
            i++;
        }
        if (i == -1) {
            i = this.futureTasks.size();
        }
        this.futureTasks.add(i, task);
        return i == 0;
    }

    public final void setActiveTask$okhttp(@Nullable Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        synchronized (this.taskRunner) {
            try {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                q qVar = q.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(task, j);
    }

    public final void schedule(@NotNull Task task, long j) {
        l.e(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                q qVar = q.a;
            } else if (task.getCancelable()) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }
}
