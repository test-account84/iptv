package Q4;

import C4.h;
import C4.o;
import C4.q;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import d.D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public static final long r = TimeUnit.DAYS.toMillis(366);
    public static volatile ScheduledExecutorService s = null;
    public static final Object t = new Object();
    public static volatile e u = new c();
    public final Object a;
    public final PowerManager.WakeLock b;
    public int c;
    public Future d;
    public long e;
    public final Set f;
    public boolean g;
    public int h;
    public zzb i;
    public C4.e j;
    public WorkSource k;
    public final String l;
    public final String m;
    public final Context n;
    public final Map o;
    public AtomicInteger p;
    public final ScheduledExecutorService q;

    public a(Context context, int i, String str) {
        String packageName = context.getPackageName();
        this.a = new Object();
        this.c = 0;
        this.f = new HashSet();
        this.g = true;
        this.j = h.c();
        this.o = new HashMap();
        this.p = new AtomicInteger(0);
        r.n(context, "WakeLock: context must not be null");
        r.h(str, "WakeLock: wakeLockName must not be empty");
        this.n = context.getApplicationContext();
        this.m = str;
        this.i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.l = str;
        } else {
            String valueOf = String.valueOf(str);
            this.l = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i, str);
        this.b = newWakeLock;
        if (q.c(context)) {
            WorkSource b = q.b(context, o.b(packageName) ? context.getPackageName() : packageName);
            this.k = b;
            if (b != null) {
                i(newWakeLock, b);
            }
        }
        ScheduledExecutorService scheduledExecutorService = s;
        if (scheduledExecutorService == null) {
            synchronized (t) {
                try {
                    scheduledExecutorService = s;
                    if (scheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        s = scheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.q = scheduledExecutorService;
    }

    public static /* synthetic */ void e(a aVar) {
        synchronized (aVar.a) {
            try {
                if (aVar.b()) {
                    Log.e("WakeLock", String.valueOf(aVar.l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    aVar.g();
                    if (aVar.b()) {
                        aVar.c = 1;
                        aVar.h(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            Log.wtf("WakeLock", e.toString());
        }
    }

    public void a(long j) {
        this.p.incrementAndGet();
        long max = Math.max(Math.min(Long.MAX_VALUE, r), 1L);
        if (j > 0) {
            max = Math.min(j, max);
        }
        synchronized (this.a) {
            try {
                if (!b()) {
                    this.i = zzb.zza(false, null);
                    this.b.acquire();
                    this.j.b();
                }
                this.c++;
                this.h++;
                f(null);
                d dVar = (d) this.o.get((Object) null);
                if (dVar == null) {
                    dVar = new d(null);
                    this.o.put((Object) null, dVar);
                }
                dVar.a++;
                long b = this.j.b();
                long j2 = Long.MAX_VALUE - b > max ? b + max : Long.MAX_VALUE;
                if (j2 > this.e) {
                    this.e = j2;
                    Future future = this.d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.d = this.q.schedule(new b(this), max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.c > 0;
        }
        return z;
    }

    public void c() {
        if (this.p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.l).concat(" release without a matched acquire!"));
        }
        synchronized (this.a) {
            try {
                f(null);
                if (this.o.containsKey((Object) null)) {
                    d dVar = (d) this.o.get((Object) null);
                    if (dVar != null) {
                        int i = dVar.a - 1;
                        dVar.a = i;
                        if (i == 0) {
                            this.o.remove((Object) null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z) {
        synchronized (this.a) {
            this.g = z;
        }
    }

    public final String f(String str) {
        if (this.g) {
            TextUtils.isEmpty((CharSequence) null);
        }
        return null;
    }

    public final void g() {
        if (this.f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f);
        this.f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        D.a(arrayList.get(0));
        throw null;
    }

    public final void h(int i) {
        synchronized (this.a) {
            try {
                if (b()) {
                    if (this.g) {
                        int i2 = this.c - 1;
                        this.c = i2;
                        if (i2 > 0) {
                            return;
                        }
                    } else {
                        this.c = 0;
                    }
                    g();
                    Iterator it = this.o.values().iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).a = 0;
                    }
                    this.o.clear();
                    Future future = this.d;
                    if (future != null) {
                        future.cancel(false);
                        this.d = null;
                        this.e = 0L;
                    }
                    this.h = 0;
                    if (this.b.isHeld()) {
                        try {
                            try {
                                this.b.release();
                            } catch (RuntimeException e) {
                                if (!e.getClass().equals(RuntimeException.class)) {
                                    throw e;
                                }
                                Log.e("WakeLock", String.valueOf(this.l).concat(" failed to release!"), e);
                                if (this.i != null) {
                                }
                            }
                        } finally {
                            if (this.i != null) {
                                this.i = null;
                            }
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.l).concat(" should be held!"));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
