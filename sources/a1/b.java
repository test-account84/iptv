package a1;

import Q0.n;
import android.text.TextUtils;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements Runnable {
    public static final String d = Q0.k.f("EnqueueRunnable");
    public final R0.g a;
    public final R0.c c = new R0.c();

    public b(R0.g gVar) {
        this.a = gVar;
    }

    public static boolean b(R0.g gVar) {
        boolean c = c(gVar.g(), gVar.f(), (String[]) R0.g.l(gVar).toArray(new String[0]), gVar.d(), gVar.b());
        gVar.k();
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0142 A[PHI: r1 r9 r12 r13 r14
      0x0142: PHI (r1v1 java.lang.String[]) = 
      (r1v0 java.lang.String[])
      (r1v0 java.lang.String[])
      (r1v0 java.lang.String[])
      (r1v4 java.lang.String[])
      (r1v4 java.lang.String[])
     binds: [B:31:0x0064, B:32:0x0066, B:34:0x0074, B:141:0x0141, B:140:0x013f] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r9v2 boolean) = (r9v1 boolean), (r9v1 boolean), (r9v1 boolean), (r9v6 boolean), (r9v7 boolean) binds: [B:31:0x0064, B:32:0x0066, B:34:0x0074, B:141:0x0141, B:140:0x013f] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r12v2 boolean) = (r12v1 boolean), (r12v1 boolean), (r12v1 boolean), (r12v4 boolean), (r12v4 boolean) binds: [B:31:0x0064, B:32:0x0066, B:34:0x0074, B:141:0x0141, B:140:0x013f] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r13v2 boolean) = (r13v1 boolean), (r13v1 boolean), (r13v1 boolean), (r13v5 boolean), (r13v5 boolean) binds: [B:31:0x0064, B:32:0x0066, B:34:0x0074, B:141:0x0141, B:140:0x013f] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r14v2 boolean) = (r14v1 boolean), (r14v1 boolean), (r14v1 boolean), (r14v5 boolean), (r14v5 boolean) binds: [B:31:0x0064, B:32:0x0066, B:34:0x0074, B:141:0x0141, B:140:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d2 A[LOOP:5: B:84:0x01cc->B:86:0x01d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(R0.j r19, java.util.List r20, java.lang.String[] r21, java.lang.String r22, Q0.d r23) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.b.c(R0.j, java.util.List, java.lang.String[], java.lang.String, Q0.d):boolean");
    }

    public static boolean e(R0.g gVar) {
        List<R0.g> e = gVar.e();
        boolean z = false;
        if (e != null) {
            boolean z2 = false;
            for (R0.g gVar2 : e) {
                if (gVar2.j()) {
                    Q0.k.c().h(d, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", gVar2.c())}), new Throwable[0]);
                } else {
                    z2 |= e(gVar2);
                }
            }
            z = z2;
        }
        return b(gVar) | z;
    }

    public static void g(Z0.p pVar) {
        Q0.b bVar = pVar.j;
        String str = pVar.c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (bVar.f() || bVar.i()) {
            b.a aVar = new b.a();
            aVar.c(pVar.e).h("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.c = ConstraintTrackingWorker.class.getName();
            pVar.e = aVar.a();
        }
    }

    public static boolean h(R0.j jVar, String str) {
        try {
            Class cls = Class.forName(str);
            Iterator it = jVar.p().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(((R0.e) it.next()).getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase q = this.a.g().q();
        q.c();
        try {
            boolean e = e(this.a);
            q.r();
            return e;
        } finally {
            q.g();
        }
    }

    public Q0.n d() {
        return this.c;
    }

    public void f() {
        R0.j g = this.a.g();
        R0.f.b(g.k(), g.q(), g.p());
    }

    public void run() {
        try {
            if (this.a.h()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.a}));
            }
            if (a()) {
                g.a(this.a.g().j(), RescheduleReceiver.class, true);
                f();
            }
            this.c.a(Q0.n.a);
        } catch (Throwable th) {
            this.c.a(new n.b.a(th));
        }
    }
}
