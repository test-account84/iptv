package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q0 implements ServiceConnection, u0 {
    public final Map a = new HashMap();
    public int c = 2;
    public boolean d;
    public IBinder e;
    public final o0 f;
    public ComponentName g;
    public final /* synthetic */ t0 h;

    public q0(t0 t0Var, o0 o0Var) {
        this.h = t0Var;
        this.f = o0Var;
    }

    public final int a() {
        return this.c;
    }

    public final ComponentName b() {
        return this.g;
    }

    public final IBinder c() {
        return this.e;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.c = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (C4.m.m()) {
            StrictMode.setVmPolicy(p0.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
        }
        try {
            t0 t0Var = this.h;
            boolean d = t0.i(t0Var).d(t0.g(t0Var), str, this.f.b(t0.g(t0Var)), this, 4225, executor);
            this.d = d;
            if (d) {
                t0.h(this.h).sendMessageDelayed(t0.h(this.h).obtainMessage(1, this.f), t0.f(this.h));
            } else {
                this.c = 2;
                try {
                    t0 t0Var2 = this.h;
                    t0.i(t0Var2).c(t0.g(t0Var2), this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.a.remove(serviceConnection);
    }

    public final void g(String str) {
        t0.h(this.h).removeMessages(1, this.f);
        t0 t0Var = this.h;
        t0.i(t0Var).c(t0.g(t0Var), this);
        this.d = false;
        this.c = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.a.isEmpty();
    }

    public final boolean j() {
        return this.d;
    }

    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (t0.j(this.h)) {
            try {
                t0.h(this.h).removeMessages(1, this.f);
                this.e = iBinder;
                this.g = componentName;
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.c = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (t0.j(this.h)) {
            try {
                t0.h(this.h).removeMessages(1, this.f);
                this.e = null;
                this.g = componentName;
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.c = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
