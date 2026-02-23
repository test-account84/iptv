package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class arz implements c.a, c.b {

    @VisibleForTesting
    protected final asj a;
    private final String b;
    private final String c;
    private final LinkedBlockingQueue d;
    private final HandlerThread e;
    private final aru f;
    private final long g;
    private final int h;

    public arz(Context context, int i, String str, String str2, aru aruVar) {
        this.b = str;
        this.h = i;
        this.c = str2;
        this.f = aruVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.e = handlerThread;
        handlerThread.start();
        this.g = System.currentTimeMillis();
        asj asjVar = new asj(context, handlerThread.getLooper(), this, this, 19621000);
        this.a = asjVar;
        this.d = new LinkedBlockingQueue();
        asjVar.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    public static ast b() {
        return new ast();
    }

    private final void e(int i, long j) {
        f(i, j, null);
    }

    private final void f(int i, long j, Exception exc) {
        this.f.c(i, System.currentTimeMillis() - j, exc);
    }

    public final aso a() {
        try {
            return this.a.a();
        } catch (IllegalStateException | DeadObjectException unused) {
            return null;
        }
    }

    public final ast c() {
        ast astVar;
        try {
            astVar = (ast) this.d.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            f(2009, this.g, e);
            astVar = null;
        }
        e(3004, this.g);
        if (astVar != null) {
            aru.g(astVar.c == 7 ? afj.c : afj.b);
        }
        return astVar == null ? b() : astVar;
    }

    public final void d() {
        asj asjVar = this.a;
        if (asjVar != null) {
            if (asjVar.isConnected() || this.a.isConnecting()) {
                this.a.disconnect();
            }
        }
    }

    public final void onConnected(Bundle bundle) {
        aso a = a();
        if (a != null) {
            try {
                ast f = a.f(new ass(this.h, this.b, this.c));
                e(5011, this.g);
                this.d.put(f);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public final void onConnectionFailed(w4.b bVar) {
        try {
            e(4012, this.g);
            this.d.put(b());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            e(4011, this.g);
            this.d.put(b());
        } catch (InterruptedException unused) {
        }
    }
}
