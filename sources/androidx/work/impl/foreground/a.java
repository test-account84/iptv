package androidx.work.impl.foreground;

import Q0.e;
import Q0.k;
import R0.j;
import V0.c;
import V0.d;
import Z0.p;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a implements c, R0.b {
    public static final String l = k.f("SystemFgDispatcher");
    public Context a;
    public j c;
    public final c1.a d;
    public final Object e = new Object();
    public String f;
    public final Map g;
    public final Map h;
    public final Set i;
    public final d j;
    public b k;

    public class a implements Runnable {
        public final /* synthetic */ WorkDatabase a;
        public final /* synthetic */ String c;

        public a(WorkDatabase workDatabase, String str) {
            this.a = workDatabase;
            this.c = str;
        }

        public void run() {
            p h = this.a.B().h(this.c);
            if (h == null || !h.b()) {
                return;
            }
            synchronized (a.this.e) {
                a.this.h.put(this.c, h);
                a.this.i.add(h);
                a aVar = a.this;
                aVar.j.d(aVar.i);
            }
        }
    }

    public interface b {
        void a(int i, Notification notification);

        void c(int i, int i2, Notification notification);

        void d(int i);

        void stop();
    }

    public a(Context context) {
        this.a = context;
        j m = j.m(context);
        this.c = m;
        c1.a r = m.r();
        this.d = r;
        this.f = null;
        this.g = new LinkedHashMap();
        this.i = new HashSet();
        this.h = new HashMap();
        this.j = new d(this.a, r, this);
        this.c.o().c(this);
    }

    public static Intent a(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent e(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    public void b(List list) {
        if (list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(l, String.format("Constraints unmet for WorkSpec %s", new Object[]{str}), new Throwable[0]);
            this.c.y(str);
        }
    }

    public void d(String str, boolean z) {
        Map.Entry entry;
        synchronized (this.e) {
            try {
                p pVar = (p) this.h.remove(str);
                if (pVar != null ? this.i.remove(pVar) : false) {
                    this.j.d(this.i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar = (e) this.g.remove(str);
        if (str.equals(this.f) && this.g.size() > 0) {
            Iterator it = this.g.entrySet().iterator();
            do {
                entry = (Map.Entry) it.next();
            } while (it.hasNext());
            this.f = (String) entry.getKey();
            if (this.k != null) {
                e eVar2 = (e) entry.getValue();
                this.k.c(eVar2.c(), eVar2.a(), eVar2.b());
                this.k.d(eVar2.c());
            }
        }
        b bVar = this.k;
        if (eVar == null || bVar == null) {
            return;
        }
        k.c().a(l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(eVar.c()), str, Integer.valueOf(eVar.a())}), new Throwable[0]);
        bVar.d(eVar.c());
    }

    public void f(List list) {
    }

    public final void g(Intent intent) {
        k.c().d(l, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.c.h(UUID.fromString(stringExtra));
    }

    public final void h(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification parcelableExtra = intent.getParcelableExtra("KEY_NOTIFICATION");
        k.c().a(l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (parcelableExtra == null || this.k == null) {
            return;
        }
        this.g.put(stringExtra, new e(intExtra, parcelableExtra, intExtra2));
        if (TextUtils.isEmpty(this.f)) {
            this.f = stringExtra;
            this.k.c(intExtra, intExtra2, parcelableExtra);
            return;
        }
        this.k.a(intExtra, parcelableExtra);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            i |= ((e) ((Map.Entry) it.next()).getValue()).a();
        }
        e eVar = (e) this.g.get(this.f);
        if (eVar != null) {
            this.k.c(eVar.c(), i, eVar.b());
        }
    }

    public final void i(Intent intent) {
        k.c().d(l, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        this.d.b(new a(this.c.q(), intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    public void j(Intent intent) {
        k.c().d(l, "Stopping foreground service", new Throwable[0]);
        b bVar = this.k;
        if (bVar != null) {
            bVar.stop();
        }
    }

    public void k() {
        this.k = null;
        synchronized (this.e) {
            this.j.e();
        }
        this.c.o().i(this);
    }

    public void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
        } else if (!"ACTION_NOTIFY".equals(action)) {
            if ("ACTION_CANCEL_WORK".equals(action)) {
                g(intent);
                return;
            } else {
                if ("ACTION_STOP_FOREGROUND".equals(action)) {
                    j(intent);
                    return;
                }
                return;
            }
        }
        h(intent);
    }

    public void m(b bVar) {
        if (this.k != null) {
            k.c().b(l, "A callback already exists.", new Throwable[0]);
        } else {
            this.k = bVar;
        }
    }
}
