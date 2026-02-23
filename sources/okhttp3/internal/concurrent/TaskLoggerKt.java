package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import w8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task task, TaskQueue taskQueue, String str) {
        log(task, taskQueue, str);
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String formatDuration(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r13v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */

    private static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(' ');
        E e = E.a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        l.d(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final Object logElapsed(@NotNull Task task, @NotNull TaskQueue queue, @NotNull a block) {
        long j;
        l.e(task, "task");
        l.e(queue, "queue");
        l.e(block, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            access$log(task, queue, "starting");
        } else {
            j = -1;
        }
        try {
            Object invoke = block.invoke();
            k.b(1);
            if (isLoggable) {
                access$log(task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j));
            }
            k.a(1);
            return invoke;
        } catch (Throwable th) {
            k.b(1);
            if (isLoggable) {
                access$log(task, queue, "failed a run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j));
            }
            k.a(1);
            throw th;
        }
    }

    public static final void taskLog(@NotNull Task task, @NotNull TaskQueue queue, @NotNull a messageBlock) {
        l.e(task, "task");
        l.e(queue, "queue");
        l.e(messageBlock, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            access$log(task, queue, (String) messageBlock.invoke());
        }
    }
}
