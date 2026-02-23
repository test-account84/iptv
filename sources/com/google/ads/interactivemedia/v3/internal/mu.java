package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class mu extends Handler {
    final /* synthetic */ my a;
    private boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mu(my myVar, Looper looper) {
        super(looper);
        this.a = myVar;
    }

    public final void a(int i, Object obj, boolean z) {
        obtainMessage(i, new mv(sw.a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
    }

    public final synchronized void b() {
        removeCallbacksAndMessages((Object) null);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleMessage(Message message) {
        ok okVar;
        mv mvVar = (mv) message.obj;
        try {
            int i = message.what;
            if (i == 0) {
                okVar = this.a.b.b((zo) mvVar.d);
            } else {
                if (i != 1) {
                    throw new RuntimeException();
                }
                my myVar = this.a;
                okVar = myVar.b.c(myVar.c, (aeq) mvVar.d);
            }
        } catch (ok e) {
            mv mvVar2 = (mv) message.obj;
            if (mvVar2.b) {
                int i2 = mvVar2.e + 1;
                mvVar2.e = i2;
                if (i2 <= ws.c(3)) {
                    int i3 = sw.a;
                    SystemClock.elapsedRealtime();
                    SystemClock.elapsedRealtime();
                    long e2 = ws.e(new bdz(e.getCause() instanceof IOException ? (IOException) e.getCause() : new mx(e.getCause()), mvVar2.e));
                    if (e2 != -9223372036854775807L) {
                        synchronized (this) {
                            try {
                                if (!this.b) {
                                    sendMessageDelayed(Message.obtain(message), e2);
                                    return;
                                }
                            } finally {
                            }
                        }
                    }
                }
            }
            okVar = e;
        } catch (Exception e3) {
            cd.f("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e3);
            okVar = e3;
        }
        long j = mvVar.a;
        synchronized (this) {
            try {
                if (!this.b) {
                    this.a.d.obtainMessage(message.what, Pair.create(mvVar.d, okVar)).sendToTarget();
                }
            } finally {
            }
        }
    }
}
