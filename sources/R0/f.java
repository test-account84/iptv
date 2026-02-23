package R0;

import U0.m;
import Z0.p;
import Z0.q;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {
    public static final String a = Q0.k.f("Schedulers");

    public static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            m mVar = new m(context, jVar);
            a1.g.a(context, SystemJobService.class, true);
            Q0.k.c().a(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return mVar;
        }
        e c = c(context);
        if (c != null) {
            return c;
        }
        T0.b bVar = new T0.b(context);
        a1.g.a(context, SystemAlarmService.class, true);
        Q0.k.c().a(a, "Created SystemAlarmScheduler", new Throwable[0]);
        return bVar;
    }

    public static void b(androidx.work.a aVar, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        q B = workDatabase.B();
        workDatabase.c();
        try {
            List o = B.o(aVar.h());
            List k = B.k(200);
            if (o != null && o.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = o.iterator();
                while (it.hasNext()) {
                    B.m(((p) it.next()).a, currentTimeMillis);
                }
            }
            workDatabase.r();
            workDatabase.g();
            if (o != null && o.size() > 0) {
                p[] pVarArr = (p[]) o.toArray(new p[o.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    if (eVar.c()) {
                        eVar.e(pVarArr);
                    }
                }
            }
            if (k == null || k.size() <= 0) {
                return;
            }
            p[] pVarArr2 = (p[]) k.toArray(new p[k.size()]);
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (!eVar2.c()) {
                    eVar2.e(pVarArr2);
                }
            }
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }

    public static e c(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            Q0.k.c().a(a, String.format("Created %s", new Object[]{"androidx.work.impl.background.gcm.GcmScheduler"}), new Throwable[0]);
            return eVar;
        } catch (Throwable th) {
            Q0.k.c().a(a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
