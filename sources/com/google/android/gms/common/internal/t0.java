package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t0 extends i {
    public final HashMap f = new HashMap();
    public final Context g;
    public volatile Handler h;
    public final s0 i;
    public final B4.b j;
    public final long k;
    public final long l;
    public volatile Executor m;

    public t0(Context context, Looper looper, Executor executor) {
        s0 s0Var = new s0(this, null);
        this.i = s0Var;
        this.g = context.getApplicationContext();
        this.h = new zzi(looper, s0Var);
        this.j = B4.b.b();
        this.k = 5000L;
        this.l = 300000L;
        this.m = executor;
    }

    public static /* bridge */ /* synthetic */ long f(t0 t0Var) {
        return t0Var.l;
    }

    public static /* bridge */ /* synthetic */ Context g(t0 t0Var) {
        return t0Var.g;
    }

    public static /* bridge */ /* synthetic */ Handler h(t0 t0Var) {
        return t0Var.h;
    }

    public static /* bridge */ /* synthetic */ B4.b i(t0 t0Var) {
        return t0Var.j;
    }

    public static /* bridge */ /* synthetic */ HashMap j(t0 t0Var) {
        return t0Var.f;
    }

    public final void c(o0 o0Var, ServiceConnection serviceConnection, String str) {
        r.n(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            try {
                q0 q0Var = (q0) this.f.get(o0Var);
                if (q0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + o0Var.toString());
                }
                if (!q0Var.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + o0Var.toString());
                }
                q0Var.f(serviceConnection, str);
                if (q0Var.i()) {
                    this.h.sendMessageDelayed(this.h.obtainMessage(0, o0Var), this.k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e(o0 o0Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j;
        r.n(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            try {
                q0 q0Var = (q0) this.f.get(o0Var);
                if (executor == null) {
                    executor = this.m;
                }
                if (q0Var == null) {
                    q0Var = new q0(this, o0Var);
                    q0Var.d(serviceConnection, serviceConnection, str);
                    q0Var.e(str, executor);
                    this.f.put(o0Var, q0Var);
                } else {
                    this.h.removeMessages(0, o0Var);
                    if (q0Var.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + o0Var.toString());
                    }
                    q0Var.d(serviceConnection, serviceConnection, str);
                    int a = q0Var.a();
                    if (a == 1) {
                        serviceConnection.onServiceConnected(q0Var.b(), q0Var.c());
                    } else if (a == 2) {
                        q0Var.e(str, executor);
                    }
                }
                j = q0Var.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }
}
