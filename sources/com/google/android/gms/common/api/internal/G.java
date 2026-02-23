package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g implements Handler.Callback {
    public static final Status q = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status r = new Status(4, "The user must be signed in to make this API call.");
    public static final Object s = new Object();
    public static g t;
    public com.google.android.gms.common.internal.v d;
    public com.google.android.gms.common.internal.x e;
    public final Context f;
    public final w4.h g;
    public final com.google.android.gms.common.internal.L h;
    public final Handler o;
    public volatile boolean p;
    public long a = 10000;
    public boolean c = false;
    public final AtomicInteger i = new AtomicInteger(1);
    public final AtomicInteger j = new AtomicInteger(0);
    public final Map k = new ConcurrentHashMap(5, 0.75f, 1);
    public A l = null;
    public final Set m = new s.b();
    public final Set n = new s.b();

    public g(Context context, Looper looper, w4.h hVar) {
        this.p = true;
        this.f = context;
        zau zauVar = new zau(looper, this);
        this.o = zauVar;
        this.g = hVar;
        this.h = new com.google.android.gms.common.internal.L(hVar);
        if (C4.i.a(context)) {
            this.p = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static /* bridge */ /* synthetic */ Set A(g gVar) {
        return gVar.m;
    }

    public static /* bridge */ /* synthetic */ void B(g gVar, boolean z) {
        gVar.c = true;
    }

    public static /* bridge */ /* synthetic */ boolean c(g gVar) {
        return gVar.p;
    }

    public static Status f(b bVar, w4.b bVar2) {
        return new Status(bVar2, "API: " + bVar.b() + " is not available on this device. Connection failed with: " + String.valueOf(bVar2));
    }

    public static /* bridge */ /* synthetic */ long l(g gVar) {
        return gVar.a;
    }

    public static /* bridge */ /* synthetic */ Context m(g gVar) {
        return gVar.f;
    }

    public static /* bridge */ /* synthetic */ Handler n(g gVar) {
        return gVar.o;
    }

    public static /* bridge */ /* synthetic */ w4.h o(g gVar) {
        return gVar.g;
    }

    public static /* bridge */ /* synthetic */ Status p() {
        return r;
    }

    public static /* bridge */ /* synthetic */ Status q(b bVar, w4.b bVar2) {
        return f(bVar, bVar2);
    }

    public static /* bridge */ /* synthetic */ A r(g gVar) {
        return gVar.l;
    }

    public static g t(Context context) {
        g gVar;
        synchronized (s) {
            try {
                if (t == null) {
                    t = new g(context.getApplicationContext(), com.google.android.gms.common.internal.i.b().getLooper(), w4.h.q());
                }
                gVar = t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.common.internal.L u(g gVar) {
        return gVar.h;
    }

    public static /* bridge */ /* synthetic */ Object y() {
        return s;
    }

    public static /* bridge */ /* synthetic */ Map z(g gVar) {
        return gVar.k;
    }

    public final void C(com.google.android.gms.common.api.e eVar, int i, d dVar) {
        this.o.sendMessage(this.o.obtainMessage(4, new z0(new R0(i, dVar), this.j.get(), eVar)));
    }

    public final void D(com.google.android.gms.common.api.e eVar, int i, t tVar, TaskCompletionSource taskCompletionSource, s sVar) {
        j(taskCompletionSource, tVar.d(), eVar);
        this.o.sendMessage(this.o.obtainMessage(4, new z0(new T0(i, tVar, taskCompletionSource, sVar), this.j.get(), eVar)));
    }

    public final void E(com.google.android.gms.common.internal.p pVar, int i, long j, int i2) {
        this.o.sendMessage(this.o.obtainMessage(18, new y0(pVar, i, j, i2)));
    }

    public final void F(w4.b bVar, int i) {
        if (e(bVar, i)) {
            return;
        }
        Handler handler = this.o;
        handler.sendMessage(handler.obtainMessage(5, i, 0, bVar));
    }

    public final void G() {
        Handler handler = this.o;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void H(com.google.android.gms.common.api.e eVar) {
        Handler handler = this.o;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void a(A a) {
        synchronized (s) {
            try {
                if (this.l != a) {
                    this.l = a;
                    this.m.clear();
                }
                this.m.addAll(a.i());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(A a) {
        synchronized (s) {
            try {
                if (this.l == a) {
                    this.l = null;
                    this.m.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        if (this.c) {
            return false;
        }
        com.google.android.gms.common.internal.t a = com.google.android.gms.common.internal.s.b().a();
        if (a != null && !a.J()) {
            return false;
        }
        int a2 = this.h.a(this.f, 203400000);
        return a2 == -1 || a2 == 0;
    }

    public final boolean e(w4.b bVar, int i) {
        return this.g.A(this.f, bVar, i);
    }

    public final k0 g(com.google.android.gms.common.api.e eVar) {
        Map map = this.k;
        b apiKey = eVar.getApiKey();
        k0 k0Var = (k0) map.get(apiKey);
        if (k0Var == null) {
            k0Var = new k0(this, eVar);
            this.k.put(apiKey, k0Var);
        }
        if (k0Var.a()) {
            this.n.add(apiKey);
        }
        k0Var.C();
        return k0Var;
    }

    public final com.google.android.gms.common.internal.x h() {
        if (this.e == null) {
            this.e = com.google.android.gms.common.internal.w.a(this.f);
        }
        return this.e;
    }

    public final boolean handleMessage(Message message) {
        TaskCompletionSource b;
        Boolean valueOf;
        int i = message.what;
        k0 k0Var = null;
        switch (i) {
            case 1:
                this.a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.o.removeMessages(12);
                for (b bVar : this.k.keySet()) {
                    Handler handler = this.o;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.a);
                }
                return true;
            case 2:
                d.D.a(message.obj);
                throw null;
            case 3:
                for (k0 k0Var2 : this.k.values()) {
                    k0Var2.B();
                    k0Var2.C();
                }
                return true;
            case 4:
            case 8:
            case 13:
                z0 z0Var = (z0) message.obj;
                k0 k0Var3 = (k0) this.k.get(z0Var.c.getApiKey());
                if (k0Var3 == null) {
                    k0Var3 = g(z0Var.c);
                }
                if (!k0Var3.a() || this.j.get() == z0Var.b) {
                    k0Var3.D(z0Var.a);
                } else {
                    z0Var.a.a(q);
                    k0Var3.I();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                w4.b bVar2 = (w4.b) message.obj;
                Iterator it = this.k.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        k0 k0Var4 = (k0) it.next();
                        if (k0Var4.p() == i2) {
                            k0Var = k0Var4;
                        }
                    }
                }
                if (k0Var == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i2 + " while trying to fail enqueued calls.", new Exception());
                } else if (bVar2.H() == 13) {
                    k0.v(k0Var, new Status(17, "Error resolution was canceled by the user, original error message: " + this.g.g(bVar2.H()) + ": " + bVar2.I()));
                } else {
                    k0.v(k0Var, f(k0.t(k0Var), bVar2));
                }
                return true;
            case 6:
                if (this.f.getApplicationContext() instanceof Application) {
                    c.c(this.f.getApplicationContext());
                    c.b().a(new f0(this));
                    if (!c.b().e(true)) {
                        this.a = 300000L;
                    }
                }
                return true;
            case 7:
                g((com.google.android.gms.common.api.e) message.obj);
                return true;
            case 9:
                if (this.k.containsKey(message.obj)) {
                    ((k0) this.k.get(message.obj)).H();
                }
                return true;
            case 10:
                Iterator it2 = this.n.iterator();
                while (it2.hasNext()) {
                    k0 k0Var5 = (k0) this.k.remove((b) it2.next());
                    if (k0Var5 != null) {
                        k0Var5.I();
                    }
                }
                this.n.clear();
                return true;
            case 11:
                if (this.k.containsKey(message.obj)) {
                    ((k0) this.k.get(message.obj)).J();
                }
                return true;
            case 12:
                if (this.k.containsKey(message.obj)) {
                    ((k0) this.k.get(message.obj)).b();
                }
                return true;
            case 14:
                B b2 = (B) message.obj;
                b a = b2.a();
                if (this.k.containsKey(a)) {
                    boolean L = k0.L((k0) this.k.get(a), false);
                    b = b2.b();
                    valueOf = Boolean.valueOf(L);
                } else {
                    b = b2.b();
                    valueOf = Boolean.FALSE;
                }
                b.setResult(valueOf);
                return true;
            case 15:
                m0 m0Var = (m0) message.obj;
                if (this.k.containsKey(m0.b(m0Var))) {
                    k0.y((k0) this.k.get(m0.b(m0Var)), m0Var);
                }
                return true;
            case 16:
                m0 m0Var2 = (m0) message.obj;
                if (this.k.containsKey(m0.b(m0Var2))) {
                    k0.z((k0) this.k.get(m0.b(m0Var2)), m0Var2);
                }
                return true;
            case 17:
                i();
                return true;
            case 18:
                y0 y0Var = (y0) message.obj;
                if (y0Var.c == 0) {
                    h().a(new com.google.android.gms.common.internal.v(y0Var.b, Arrays.asList(new com.google.android.gms.common.internal.p[]{y0Var.a})));
                } else {
                    com.google.android.gms.common.internal.v vVar = this.d;
                    if (vVar != null) {
                        List I = vVar.I();
                        if (vVar.H() != y0Var.b || (I != null && I.size() >= y0Var.d)) {
                            this.o.removeMessages(17);
                            i();
                        } else {
                            this.d.J(y0Var.a);
                        }
                    }
                    if (this.d == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(y0Var.a);
                        this.d = new com.google.android.gms.common.internal.v(y0Var.b, arrayList);
                        Handler handler2 = this.o;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), y0Var.c);
                    }
                }
                return true;
            case 19:
                this.c = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }

    public final void i() {
        com.google.android.gms.common.internal.v vVar = this.d;
        if (vVar != null) {
            if (vVar.H() > 0 || d()) {
                h().a(vVar);
            }
            this.d = null;
        }
    }

    public final void j(TaskCompletionSource taskCompletionSource, int i, com.google.android.gms.common.api.e eVar) {
        x0 a;
        if (i == 0 || (a = x0.a(this, i, eVar.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        Handler handler = this.o;
        handler.getClass();
        task.addOnCompleteListener(new e0(handler), a);
    }

    public final int k() {
        return this.i.getAndIncrement();
    }

    public final k0 s(b bVar) {
        return (k0) this.k.get(bVar);
    }

    public final Task v(com.google.android.gms.common.api.e eVar) {
        B b = new B(eVar.getApiKey());
        this.o.sendMessage(this.o.obtainMessage(14, b));
        return b.b().getTask();
    }

    public final Task w(com.google.android.gms.common.api.e eVar, o oVar, v vVar, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        j(taskCompletionSource, oVar.e(), eVar);
        this.o.sendMessage(this.o.obtainMessage(8, new z0(new S0(new A0(oVar, vVar, runnable), taskCompletionSource), this.j.get(), eVar)));
        return taskCompletionSource.getTask();
    }

    public final Task x(com.google.android.gms.common.api.e eVar, k.a aVar, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        j(taskCompletionSource, i, eVar);
        this.o.sendMessage(this.o.obtainMessage(13, new z0(new U0(aVar, taskCompletionSource), this.j.get(), eVar)));
        return taskCompletionSource.getTask();
    }
}
