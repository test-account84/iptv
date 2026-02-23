package androidx.work.impl.background.systemalarm;

import Q0.k;
import Z0.p;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a implements R0.b {
    public static final String e = k.f("CommandHandler");
    public final Context a;
    public final Map c = new HashMap();
    public final Object d = new Object();

    public a(Context context) {
        this.a = context;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    public static Intent e(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    public static Intent f(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent g(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public void d(String str, boolean z) {
        synchronized (this.d) {
            try {
                R0.b bVar = (R0.b) this.c.remove(str);
                if (bVar != null) {
                    bVar.d(str, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(Intent intent, int i, d dVar) {
        k.c().a(e, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new b(this.a, i, dVar).a();
    }

    public final void i(Intent intent, int i, d dVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.d) {
            try {
                String string = extras.getString("KEY_WORKSPEC_ID");
                k c = k.c();
                String str = e;
                c.a(str, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
                if (this.c.containsKey(string)) {
                    k.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
                } else {
                    c cVar = new c(this.a, i, string, dVar);
                    this.c.put(string, cVar);
                    cVar.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(Intent intent, int i) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        k.c().a(e, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        d(string, z);
    }

    public final void k(Intent intent, int i, d dVar) {
        k.c().a(e, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        dVar.g().u();
    }

    public final void l(Intent intent, int i, d dVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k c = k.c();
        String str = e;
        c.a(str, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase q = dVar.g().q();
        q.c();
        try {
            p h = q.B().h(string);
            if (h == null) {
                k.c().h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (h.b.isFinished()) {
                k.c().h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                return;
            }
            long a = h.a();
            if (h.b()) {
                k.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(a)}), new Throwable[0]);
                T0.a.c(this.a, dVar.g(), string, a);
                dVar.k(new d.b(dVar, a(this.a), i));
            } else {
                k.c().a(str, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(a)}), new Throwable[0]);
                T0.a.c(this.a, dVar.g(), string, a);
            }
            q.r();
        } finally {
            q.g();
        }
    }

    public final void m(Intent intent, d dVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k.c().a(e, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        dVar.g().z(string);
        T0.a.a(this.a, dVar.g(), string);
        dVar.d(string, false);
    }

    public boolean o() {
        boolean z;
        synchronized (this.d) {
            z = !this.c.isEmpty();
        }
        return z;
    }

    public void p(Intent intent, int i, d dVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i, dVar);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i, dVar);
            return;
        }
        if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            k.c().b(e, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i, dVar);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i, dVar);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, dVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i);
        } else {
            k.c().h(e, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }
}
