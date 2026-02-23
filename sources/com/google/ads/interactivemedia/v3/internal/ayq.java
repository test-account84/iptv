package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Delayed;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ayq extends ayp implements ScheduledFuture, azd {
    private final azd a;
    private final ScheduledFuture b;

    public ayq(azd azdVar) {
        super(null);
        this.a = azdVar;
    }

    public final /* synthetic */ Object a() {
        return this.a;
    }

    public final azd b() {
        return this.a;
    }

    public final /* synthetic */ Future c() {
        return this.a;
    }

    public final boolean cancel(boolean z) {
        boolean cancel = c().cancel(z);
        if (cancel) {
            this.b.cancel(z);
        }
        return cancel;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.b.compareTo((Delayed) obj);
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.b.getDelay(timeUnit);
    }

    public ayq(azd azdVar, ScheduledFuture scheduledFuture) {
        this(azdVar);
        this.b = scheduledFuture;
    }
}
