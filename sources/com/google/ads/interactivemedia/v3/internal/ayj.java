package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.axz;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class ayj extends axz.i {
    private static final ayg b;
    private static final Logger c = Logger.getLogger(ayj.class.getName());
    private volatile int remaining;
    private volatile Set seenExceptions = null;

    static {
        ayg ayiVar;
        Throwable th;
        try {
            AtomicReferenceFieldUpdater.newUpdater(ayj.class, Set.class, "seenExceptions");
            ayiVar = new ayh(AtomicIntegerFieldUpdater.newUpdater(ayj.class, "remaining"));
            th = null;
        } catch (Error | RuntimeException e) {
            ayiVar = new ayi(null);
            th = e;
        }
        b = ayiVar;
        if (th != null) {
            c.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public ayj(int i) {
        this.remaining = i;
    }

    public static /* synthetic */ int t(ayj ayjVar) {
        int i = ayjVar.remaining - 1;
        ayjVar.remaining = i;
        return i;
    }

    public final int u() {
        return b.a(this);
    }

    public final void v() {
        this.seenExceptions = null;
    }
}
