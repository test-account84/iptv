package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class wx extends Handler implements Runnable {
    public final int a;
    final /* synthetic */ xc b;
    private final wy c;
    private final long d;
    private ww e;
    private IOException f;
    private int g;
    private Thread h;
    private boolean i;
    private volatile boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wx(xc xcVar, Looper looper, wy wyVar, ww wwVar, int i, long j) {
        super(looper);
        this.b = xcVar;
        this.c = wyVar;
        this.e = wwVar;
        this.a = i;
        this.d = j;
    }

    private final void d() {
        this.f = null;
        xc xcVar = this.b;
        ExecutorService d = xc.d(xcVar);
        wx c = xc.c(xcVar);
        af.s(c);
        d.execute(c);
    }

    private final void e() {
        xc.e(this.b, null);
    }

    public final void a(boolean z) {
        this.j = z;
        this.f = null;
        if (hasMessages(0)) {
            this.i = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                try {
                    this.i = true;
                    this.c.r();
                    Thread thread = this.h;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            e();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ww wwVar = this.e;
            af.s(wwVar);
            wwVar.bn(this.c, elapsedRealtime, elapsedRealtime - this.d, true);
            this.e = null;
        }
    }

    public final void b(int i) throws IOException {
        IOException iOException = this.f;
        if (iOException != null && this.g > i) {
            throw iOException;
        }
    }

    public final void c(long j) {
        af.w(xc.c(this.b) == null);
        xc.e(this.b, this);
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            d();
        }
    }

    public final void handleMessage(Message message) {
        if (this.j) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            d();
            return;
        }
        if (i == 3) {
            throw ((Error) message.obj);
        }
        e();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.d;
        ww wwVar = this.e;
        af.s(wwVar);
        if (this.i) {
            wwVar.bn(this.c, elapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            try {
                wwVar.bj(this.c, elapsedRealtime, j);
                return;
            } catch (RuntimeException e) {
                cd.c("LoadTask", "Unexpected exception handling load completed", e);
                xc.f(this.b, new xb(e));
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.f = iOException;
        int i3 = this.g + 1;
        this.g = i3;
        wv bk = wwVar.bk(this.c, elapsedRealtime, j, iOException, i3);
        if (wv.b(bk) == 3) {
            xc.f(this.b, this.f);
        } else if (wv.b(bk) != 2) {
            if (wv.b(bk) == 1) {
                this.g = 1;
            }
            c(wv.c(bk) != -9223372036854775807L ? wv.c(bk) : Math.min((this.g - 1) * 1000, 5000));
        }
    }

    public final void run() {
        Message obtainMessage;
        xb xbVar;
        boolean z;
        try {
            synchronized (this) {
                z = !this.i;
                this.h = Thread.currentThread();
            }
            if (z) {
                af.o("load:" + this.c.getClass().getSimpleName());
                try {
                    this.c.e();
                    af.p();
                } catch (Throwable th) {
                    af.p();
                    throw th;
                }
            }
            synchronized (this) {
                this.h = null;
                Thread.interrupted();
            }
            if (this.j) {
                return;
            }
            sendEmptyMessage(1);
        } catch (OutOfMemoryError e) {
            if (this.j) {
                return;
            }
            cd.c("LoadTask", "OutOfMemory error loading stream", e);
            xbVar = new xb(e);
            obtainMessage = obtainMessage(2, xbVar);
            obtainMessage.sendToTarget();
        } catch (Exception e2) {
            if (this.j) {
                return;
            }
            cd.c("LoadTask", "Unexpected exception loading stream", e2);
            xbVar = new xb(e2);
            obtainMessage = obtainMessage(2, xbVar);
            obtainMessage.sendToTarget();
        } catch (Error e3) {
            if (!this.j) {
                cd.c("LoadTask", "Unexpected error loading stream", e3);
                obtainMessage(3, e3).sendToTarget();
            }
            throw e3;
        } catch (IOException e4) {
            if (this.j) {
                return;
            }
            obtainMessage = obtainMessage(2, e4);
            obtainMessage.sendToTarget();
        }
    }
}
