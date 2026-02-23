package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class i {
    public static final Object a = new Object();
    public static t0 b = null;
    public static HandlerThread c = null;
    public static Executor d = null;
    public static boolean e = false;

    public static i a(Context context) {
        synchronized (a) {
            try {
                if (b == null) {
                    b = new t0(context.getApplicationContext(), e ? b().getLooper() : context.getMainLooper(), d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    public static HandlerThread b() {
        synchronized (a) {
            try {
                HandlerThread handlerThread = c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                c = handlerThread2;
                handlerThread2.start();
                return c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void c(o0 o0Var, ServiceConnection serviceConnection, String str);

    public final void d(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        c(new o0(str, str2, 4225, z), serviceConnection, str3);
    }

    public abstract boolean e(o0 o0Var, ServiceConnection serviceConnection, String str, Executor executor);
}
