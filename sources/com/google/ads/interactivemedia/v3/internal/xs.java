package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class xs extends HandlerThread implements Handler.Callback {
    private br a;
    private Handler b;
    private Error c;
    private RuntimeException d;
    private xt e;

    public xs() {
        super("ExoPlayer:PlaceholderSurface");
    }

    public final xt a(int i) {
        boolean z;
        start();
        this.b = new Handler(getLooper(), this);
        this.a = new br(this.b);
        synchronized (this) {
            z = false;
            this.b.obtainMessage(1, i, 0).sendToTarget();
            while (this.e == null && this.d == null && this.c == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.d;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.c;
        if (error != null) {
            throw error;
        }
        xt xtVar = this.e;
        af.s(xtVar);
        return xtVar;
    }

    public final void b() {
        af.s(this.b);
        this.b.sendEmptyMessage(2);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i != 2) {
                    return true;
                }
                try {
                    af.s(this.a);
                    this.a.c();
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                return true;
            }
            try {
                int i2 = message.arg1;
                af.s(this.a);
                this.a.b(i2);
                this.e = new xt(this, this.a.a(), i2 != 0);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e) {
                cd.c("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                this.d = e;
                synchronized (this) {
                    notify();
                }
            } catch (bs e2) {
                cd.c("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                this.d = new IllegalStateException(e2);
                synchronized (this) {
                    notify();
                }
            } catch (Error e3) {
                cd.c("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                this.c = e3;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }
}
