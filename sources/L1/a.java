package l1;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends ThreadPoolExecutor {

    public static final class a extends FutureTask implements Comparable {
        public final q1.d a;

        public a(q1.d dVar) {
            super(dVar, (Object) null);
            this.a = dVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            k1.e e = this.a.e();
            k1.e e2 = aVar.a.e();
            return e == e2 ? this.a.c - aVar.a.c : e2.ordinal() - e.ordinal();
        }
    }

    public a(int i, ThreadFactory threadFactory) {
        super(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
    }

    public Future submit(Runnable runnable) {
        a aVar = new a((q1.d) runnable);
        execute(aVar);
        return aVar;
    }
}
