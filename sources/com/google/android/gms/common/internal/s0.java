package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s0 implements Handler.Callback {
    public final /* synthetic */ t0 a;

    public /* synthetic */ s0(t0 t0Var, r0 r0Var) {
        this.a = t0Var;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (t0.j(this.a)) {
                try {
                    o0 o0Var = (o0) message.obj;
                    q0 q0Var = (q0) t0.j(this.a).get(o0Var);
                    if (q0Var != null && q0Var.i()) {
                        if (q0Var.j()) {
                            q0Var.g("GmsClientSupervisor");
                        }
                        t0.j(this.a).remove(o0Var);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (t0.j(this.a)) {
            try {
                o0 o0Var2 = (o0) message.obj;
                q0 q0Var2 = (q0) t0.j(this.a).get(o0Var2);
                if (q0Var2 != null && q0Var2.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(o0Var2), new Exception());
                    ComponentName b = q0Var2.b();
                    if (b == null) {
                        b = o0Var2.a();
                    }
                    if (b == null) {
                        String c = o0Var2.c();
                        r.m(c);
                        b = new ComponentName(c, "unknown");
                    }
                    q0Var2.onServiceDisconnected(b);
                }
            } finally {
            }
        }
        return true;
    }
}
