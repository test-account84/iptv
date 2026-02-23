package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lr implements Handler.Callback {
    private final lp a;
    private lu e;
    private long f;
    private boolean g;
    private boolean h;
    private boolean i;
    private final wr j;
    private final TreeMap d = new TreeMap();
    private final Handler c = cq.B(this);
    private final aam b = new aam();

    public lr(lu luVar, lp lpVar, wr wrVar) {
        this.e = luVar;
        this.a = lpVar;
        this.j = wrVar;
    }

    public static /* bridge */ /* synthetic */ Handler a(lr lrVar) {
        return lrVar.c;
    }

    public static /* bridge */ /* synthetic */ aam c(lr lrVar) {
        return lrVar.b;
    }

    private final void i() {
        if (this.g) {
            this.h = true;
            this.g = false;
            ((lb) this.a).a.j();
        }
    }

    public final lq b() {
        return new lq(this, this.j);
    }

    public final void d() {
        this.i = true;
        this.c.removeCallbacksAndMessages((Object) null);
    }

    public final void e(lu luVar) {
        this.h = false;
        this.f = -9223372036854775807L;
        this.e = luVar;
        Iterator it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.e.h) {
                it.remove();
            }
        }
    }

    public final boolean f(long j) {
        lu luVar = this.e;
        boolean z = false;
        if (!luVar.d) {
            return false;
        }
        if (this.h) {
            return true;
        }
        Map.Entry ceilingEntry = this.d.ceilingEntry(Long.valueOf(luVar.h));
        if (ceilingEntry != null && ((Long) ceilingEntry.getValue()).longValue() < j) {
            long longValue = ((Long) ceilingEntry.getKey()).longValue();
            this.f = longValue;
            ((lb) this.a).a.i(longValue);
            z = true;
        }
        if (z) {
            i();
        }
        return z;
    }

    public final boolean g(boolean z) {
        if (!this.e.d) {
            return false;
        }
        if (this.h) {
            return true;
        }
        if (!z) {
            return false;
        }
        i();
        return true;
    }

    public final void h() {
        this.g = true;
    }

    public final boolean handleMessage(Message message) {
        if (this.i) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        lo loVar = (lo) message.obj;
        long j = loVar.a;
        long j2 = loVar.b;
        TreeMap treeMap = this.d;
        Long valueOf = Long.valueOf(j2);
        Long l = (Long) treeMap.get(valueOf);
        if (l == null || l.longValue() > j) {
            this.d.put(valueOf, Long.valueOf(j));
        }
        return true;
    }
}
