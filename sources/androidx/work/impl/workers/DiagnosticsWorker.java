package androidx.work.impl.workers;

import Q0.k;
import R0.j;
import Z0.g;
import Z0.h;
import Z0.p;
import Z0.q;
import Z0.t;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DiagnosticsWorker extends Worker {
    public static final String h = k.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static String s(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{pVar.a, pVar.c, num, pVar.b.name(), str, str2});
    }

    public static String t(Z0.k kVar, t tVar, h hVar, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"}));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            g a = hVar.a(pVar.a);
            sb.append(s(pVar, TextUtils.join(",", kVar.a(pVar.a)), a != null ? Integer.valueOf(a.b) : null, TextUtils.join(",", tVar.a(pVar.a))));
        }
        return sb.toString();
    }

    public ListenableWorker.a r() {
        WorkDatabase q = j.m(a()).q();
        q B = q.B();
        Z0.k z = q.z();
        t C = q.C();
        h y = q.y();
        List b = B.b(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List q2 = B.q();
        List k = B.k(200);
        if (b != null && !b.isEmpty()) {
            k c = k.c();
            String str = h;
            c.d(str, "Recently completed work:\n\n", new Throwable[0]);
            k.c().d(str, t(z, C, y, b), new Throwable[0]);
        }
        if (q2 != null && !q2.isEmpty()) {
            k c2 = k.c();
            String str2 = h;
            c2.d(str2, "Running work:\n\n", new Throwable[0]);
            k.c().d(str2, t(z, C, y, q2), new Throwable[0]);
        }
        if (k != null && !k.isEmpty()) {
            k c3 = k.c();
            String str3 = h;
            c3.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            k.c().d(str3, t(z, C, y, k), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
