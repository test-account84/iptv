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
final class ary implements c.a, c.b {

    @VisibleForTesting
    protected final asj a;
    private final String b;
    private final String c;
    private final LinkedBlockingQueue d;
    private final HandlerThread e;

    public ary(Context context, String str, String str2) {
        this.b = str;
        this.c = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.e = handlerThread;
        handlerThread.start();
        asj asjVar = new asj(context, handlerThread.getLooper(), this, this, 9200000);
        this.a = asjVar;
        this.d = new LinkedBlockingQueue();
        asjVar.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    public static agc a() {
        agl as = agc.as();
        as.am(32768L);
        return (agc) as.aY();
    }

    public final agc b() {
        agc agcVar;
        try {
            agcVar = (agc) this.d.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            agcVar = null;
        }
        return agcVar == null ? a() : agcVar;
    }

    public final aso c() {
        try {
            return this.a.a();
        } catch (IllegalStateException | DeadObjectException unused) {
            return null;
        }
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
        aso c = c();
        if (c != null) {
            try {
                try {
                    this.d.put(c.e(new ask(this.b, this.c)).a());
                } catch (Throwable unused) {
                    this.d.put(a());
                }
            } catch (InterruptedException unused2) {
            } catch (Throwable th) {
                d();
                this.e.quit();
                throw th;
            }
            d();
            this.e.quit();
        }
    }

    public final void onConnectionFailed(w4.b bVar) {
        try {
            this.d.put(a());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.d.put(a());
        } catch (InterruptedException unused) {
        }
    }
}
