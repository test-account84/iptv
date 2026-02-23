package M4;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f2 extends FutureTask implements Comparable {
    public final long a;
    public final boolean c;
    public final String d;
    public final /* synthetic */ i2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(i2 i2Var, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.e = i2Var;
        com.google.android.gms.common.internal.r.m(str);
        long andIncrement = i2.v().getAndIncrement();
        this.a = andIncrement;
        this.d = str;
        this.c = z;
        if (andIncrement == Long.MAX_VALUE) {
            i2Var.a.d().r().a("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        f2 f2Var = (f2) obj;
        boolean z = this.c;
        if (z == f2Var.c) {
            long j = this.a;
            long j2 = f2Var.a;
            if (j < j2) {
                return -1;
            }
            if (j <= j2) {
                this.e.a.d().t().b("Two tasks share the same index. index", Long.valueOf(this.a));
                return 0;
            }
        } else if (z) {
            return -1;
        }
        return 1;
    }

    public final void setException(Throwable th) {
        this.e.a.d().r().b(this.d, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(i2 i2Var, Callable callable, boolean z, String str) {
        super(callable);
        this.e = i2Var;
        com.google.android.gms.common.internal.r.m("Task exception on worker thread");
        long andIncrement = i2.v().getAndIncrement();
        this.a = andIncrement;
        this.d = "Task exception on worker thread";
        this.c = z;
        if (andIncrement == Long.MAX_VALUE) {
            i2Var.a.d().r().a("Tasks index overflow");
        }
    }
}
