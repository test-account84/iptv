package q5;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import d.D;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y {
    public static final Map o = new HashMap();
    public final Context a;
    public final n b;
    public boolean g;
    public final Intent h;
    public ServiceConnection l;
    public IInterface m;
    public final com.google.android.play.core.integrity.q n;
    public final List d = new ArrayList();
    public final Set e = new HashSet();
    public final Object f = new Object();
    public final IBinder.DeathRecipient j = new q(this);
    public final AtomicInteger k = new AtomicInteger(0);
    public final String c = "IntegrityService";
    public final WeakReference i = new WeakReference((Object) null);

    public y(Context context, n nVar, String str, Intent intent, com.google.android.play.core.integrity.q qVar, t tVar, byte[] bArr) {
        this.a = context;
        this.b = nVar;
        this.h = intent;
        this.n = qVar;
    }

    public static /* bridge */ /* synthetic */ Context a(y yVar) {
        return yVar.a;
    }

    public static /* bridge */ /* synthetic */ ServiceConnection b(y yVar) {
        return yVar.l;
    }

    public static /* bridge */ /* synthetic */ IInterface d(y yVar) {
        return yVar.m;
    }

    public static /* bridge */ /* synthetic */ n f(y yVar) {
        return yVar.b;
    }

    public static /* bridge */ /* synthetic */ List g(y yVar) {
        return yVar.d;
    }

    public static /* synthetic */ void h(y yVar) {
        yVar.b.d("reportBinderDeath", new Object[0]);
        D.a(yVar.i.get());
        yVar.b.d("%s : Binder has died.", yVar.c);
        Iterator it = yVar.d.iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(yVar.s());
        }
        yVar.d.clear();
        yVar.t();
    }

    public static /* bridge */ /* synthetic */ void i(y yVar, ServiceConnection serviceConnection) {
        yVar.l = null;
    }

    public static /* bridge */ /* synthetic */ void j(y yVar, boolean z) {
        yVar.g = false;
    }

    public static /* bridge */ /* synthetic */ void k(y yVar, IInterface iInterface) {
        yVar.m = iInterface;
    }

    public static /* bridge */ /* synthetic */ void l(y yVar) {
        yVar.t();
    }

    public static /* bridge */ /* synthetic */ void m(y yVar, o oVar) {
        if (yVar.m != null || yVar.g) {
            if (!yVar.g) {
                oVar.run();
                return;
            } else {
                yVar.b.d("Waiting to bind to the service.", new Object[0]);
                yVar.d.add(oVar);
                return;
            }
        }
        yVar.b.d("Initiate binding to the service.", new Object[0]);
        yVar.d.add(oVar);
        x xVar = new x(yVar, null);
        yVar.l = xVar;
        yVar.g = true;
        if (yVar.a.bindService(yVar.h, xVar, 1)) {
            return;
        }
        yVar.b.d("Failed to bind to the service.", new Object[0]);
        yVar.g = false;
        Iterator it = yVar.d.iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(new z());
        }
        yVar.d.clear();
    }

    public static /* bridge */ /* synthetic */ void n(y yVar) {
        yVar.b.d("linkToDeath", new Object[0]);
        try {
            yVar.m.asBinder().linkToDeath(yVar.j, 0);
        } catch (RemoteException e) {
            yVar.b.c(e, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void o(y yVar) {
        yVar.b.d("unlinkToDeath", new Object[0]);
        yVar.m.asBinder().unlinkToDeath(yVar.j, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.c)) {
                    HandlerThread handlerThread = new HandlerThread(this.c, 10);
                    handlerThread.start();
                    map.put(this.c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.m;
    }

    public final void p(o oVar, TaskCompletionSource taskCompletionSource) {
        synchronized (this.f) {
            this.e.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new p(this, taskCompletionSource));
        }
        synchronized (this.f) {
            try {
                if (this.k.getAndIncrement() > 0) {
                    this.b.a("Already connected to the service.", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c().post(new r(this, oVar.c(), oVar));
    }

    public final /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f) {
            this.e.remove(taskCompletionSource);
        }
    }

    public final void r(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f) {
            this.e.remove(taskCompletionSource);
        }
        synchronized (this.f) {
            try {
                if (this.k.get() > 0 && this.k.decrementAndGet() > 0) {
                    this.b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                } else {
                    c().post(new s(this));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final RemoteException s() {
        return new RemoteException(String.valueOf(this.c).concat(" : Binder has died."));
    }

    public final void t() {
        synchronized (this.f) {
            try {
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    ((TaskCompletionSource) it.next()).trySetException(s());
                }
                this.e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
