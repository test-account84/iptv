package com.google.firebase.messaging;

import A5.f;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.b;
import g6.d;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k6.h;
import q6.D;
import q6.I;
import q6.O;
import q6.Z;
import q6.d0;
import q6.n;
import q6.o;
import q6.p;
import q6.q;
import q6.s;
import q6.t;
import q6.u;
import q6.v;
import q6.w;
import q6.x;
import q6.y;
import q6.z;
import z2.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FirebaseMessaging {
    public static final long m = TimeUnit.HOURS.toSeconds(8);
    public static b n;
    public static g o;
    public static ScheduledExecutorService p;
    public final f a;
    public final h b;
    public final Context c;
    public final D d;
    public final com.google.firebase.messaging.a e;
    public final a f;
    public final Executor g;
    public final Executor h;
    public final Task i;
    public final I j;
    public boolean k;
    public final Application.ActivityLifecycleCallbacks l;

    public class a {
        public final d a;
        public boolean b;
        public g6.b c;
        public Boolean d;

        public a(d dVar) {
            this.a = dVar;
        }

        public synchronized void a() {
            try {
                if (this.b) {
                    return;
                }
                Boolean d = d();
                this.d = d;
                if (d == null) {
                    z zVar = new z(this);
                    this.c = zVar;
                    this.a.a(A5.b.class, zVar);
                }
                this.b = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean b() {
            Boolean bool;
            try {
                a();
                bool = this.d;
            } catch (Throwable th) {
                throw th;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.a(FirebaseMessaging.this).v();
        }

        public /* synthetic */ void c(g6.a aVar) {
            if (b()) {
                FirebaseMessaging.b(FirebaseMessaging.this);
            }
        }

        public final Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context l = FirebaseMessaging.a(FirebaseMessaging.this).l();
            SharedPreferences sharedPreferences = l.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = l.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(l.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging(f fVar, i6.a aVar, j6.b bVar, j6.b bVar2, h hVar, g gVar, d dVar) {
        this(fVar, aVar, bVar, bVar2, hVar, gVar, dVar, new I(fVar.l()));
    }

    public static /* bridge */ /* synthetic */ f a(FirebaseMessaging firebaseMessaging) {
        return firebaseMessaging.a;
    }

    public static /* bridge */ /* synthetic */ void b(FirebaseMessaging firebaseMessaging) {
        firebaseMessaging.x();
    }

    public static synchronized FirebaseMessaging f() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(f.m());
        }
        return firebaseMessaging;
    }

    public static synchronized b g(Context context) {
        b bVar;
        synchronized (FirebaseMessaging.class) {
            try {
                if (n == null) {
                    n = new b(context);
                }
                bVar = n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(f fVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) fVar.j(FirebaseMessaging.class);
            r.n(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public static g k() {
        return o;
    }

    public static /* synthetic */ Task u(String str, d0 d0Var) {
        return d0Var.q(str);
    }

    public boolean A(b.a aVar) {
        return aVar == null || aVar.b(this.j.a());
    }

    public String c() {
        b.a j = j();
        if (!A(j)) {
            return j.a;
        }
        String c = I.c(this.a);
        try {
            return (String) Tasks.await(this.e.a(c, new w(this, c, j)));
        } catch (InterruptedException | ExecutionException e) {
            throw new IOException(e);
        }
    }

    public void d(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (p == null) {
                    p = new ScheduledThreadPoolExecutor(1, new D4.b("TAG"));
                }
                p.schedule(runnable, j, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Context e() {
        return this.c;
    }

    public final String h() {
        return "[DEFAULT]".equals(this.a.o()) ? "" : this.a.q();
    }

    public Task i() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.g.execute(new q6.r(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public b.a j() {
        return g(this.c).d(h(), I.c(this.a));
    }

    public final void l(String str) {
        if ("[DEFAULT]".equals(this.a.o())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(this.a.o());
                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new n(this.c).g(intent);
        }
    }

    public boolean m() {
        return this.f.b();
    }

    public boolean n() {
        return this.j.g();
    }

    public /* synthetic */ Task o(String str, b.a aVar, String str2) {
        g(this.c).f(h(), str, str2, this.j.a());
        if (aVar == null || !str2.equals(aVar.a)) {
            l(str2);
        }
        return Tasks.forResult(str2);
    }

    public /* synthetic */ Task p(String str, b.a aVar) {
        return this.d.d().onSuccessTask(s.a, new t(this, str, aVar));
    }

    public /* synthetic */ void q(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(c());
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    public /* synthetic */ void r() {
        if (m()) {
            x();
        }
    }

    public /* synthetic */ void s(d0 d0Var) {
        if (m()) {
            d0Var.p();
        }
    }

    public /* synthetic */ void t() {
        O.b(this.c);
    }

    public synchronized void v(boolean z) {
        this.k = z;
    }

    public final synchronized void w() {
        if (this.k) {
            return;
        }
        z(0L);
    }

    public final void x() {
        if (A(j())) {
            w();
        }
    }

    public Task y(String str) {
        return this.i.onSuccessTask(new u(str));
    }

    public synchronized void z(long j) {
        d(new Z(this, Math.min(Math.max(30L, j + j), m)), j);
        this.k = true;
    }

    public FirebaseMessaging(f fVar, i6.a aVar, j6.b bVar, j6.b bVar2, h hVar, g gVar, d dVar, I i) {
        this(fVar, aVar, hVar, gVar, dVar, i, new D(fVar, i, bVar, bVar2, hVar), o.d(), o.a());
    }

    public FirebaseMessaging(f fVar, i6.a aVar, h hVar, g gVar, d dVar, I i, D d, Executor executor, Executor executor2) {
        this.k = false;
        o = gVar;
        this.a = fVar;
        this.b = hVar;
        this.f = new a(dVar);
        Context l = fVar.l();
        this.c = l;
        p pVar = new p();
        this.l = pVar;
        this.j = i;
        this.h = executor;
        this.d = d;
        this.e = new com.google.firebase.messaging.a(executor);
        this.g = executor2;
        Application l2 = fVar.l();
        if (l2 instanceof Application) {
            l2.registerActivityLifecycleCallbacks(pVar);
        } else {
            String valueOf = String.valueOf(l2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 125);
            sb.append("Context ");
            sb.append(valueOf);
            sb.append(" was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        if (aVar != null) {
            aVar.a(new v(this));
        }
        executor2.execute(new x(this));
        Task e = d0.e(this, i, d, l, o.e());
        this.i = e;
        e.addOnSuccessListener(executor2, new q(this));
        executor2.execute(new y(this));
    }
}
