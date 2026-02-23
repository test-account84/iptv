package okhttp3.internal.concurrent;

import java.util.logging.Level;
import k8.q;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class TaskRunner$runnable$1 implements Runnable {
    final /* synthetic */ TaskRunner this$0;

    public TaskRunner$runnable$1(TaskRunner taskRunner) {
        this.this$0 = taskRunner;
    }

    public void run() {
        Task awaitTaskToRun;
        long j;
        while (true) {
            synchronized (this.this$0) {
                awaitTaskToRun = this.this$0.awaitTaskToRun();
            }
            if (awaitTaskToRun == null) {
                return;
            }
            TaskQueue queue$okhttp = awaitTaskToRun.getQueue$okhttp();
            l.b(queue$okhttp);
            boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
            if (isLoggable) {
                j = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime();
                TaskLoggerKt.access$log(awaitTaskToRun, queue$okhttp, "starting");
            } else {
                j = -1;
            }
            try {
                try {
                    TaskRunner.access$runTask(this.this$0, awaitTaskToRun);
                    q qVar = q.a;
                    if (isLoggable) {
                        TaskLoggerKt.access$log(awaitTaskToRun, queue$okhttp, "finished run in " + TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j));
                    }
                } finally {
                }
            } catch (Throwable th) {
                if (isLoggable) {
                    TaskLoggerKt.access$log(awaitTaskToRun, queue$okhttp, "failed a run in " + TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j));
                }
                throw th;
            }
        }
    }
}
