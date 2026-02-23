package h4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import w4.i;
import w4.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public w4.a a;
    public zzf b;
    public boolean c;
    public final Object d;
    public c e;
    public final Context f;
    public final long g;

    public static final class a {
        public final String a;
        public final boolean b;

        public a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public String toString() {
            String str = this.a;
            boolean z = this.b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    public a(Context context) {
        this(context, 30000L, false, false);
    }

    public static a a(Context context) {
        a aVar = new a(context, -1L, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.f(false);
            a h = aVar.h(-1);
            aVar.g(h, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", null);
            return h;
        } finally {
        }
    }

    public a b() {
        return h(-1);
    }

    public void d() {
        f(true);
    }

    public final void e() {
        r.l("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f == null || this.a == null) {
                    return;
                }
                try {
                    if (this.c) {
                        B4.b.b().c(this.f, this.a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.c = false;
                this.b = null;
                this.a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void f(boolean z) {
        r.l("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.c) {
                    e();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int j = i.h().j(context, 12451000);
                    if (j != 0 && j != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    w4.a aVar = new w4.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!B4.b.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.a = aVar;
                        try {
                            this.b = zze.zza(aVar.a(10000L, TimeUnit.MILLISECONDS));
                            this.c = true;
                            if (z) {
                                i();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new j(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void finalize() {
        e();
        super.finalize();
    }

    public final boolean g(a aVar, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", "1");
        if (aVar != null) {
            hashMap.put("limit_ad_tracking", true != aVar.b() ? "0" : "1");
            String a2 = aVar.a();
            if (a2 != null) {
                hashMap.put("ad_id_size", Integer.toString(a2.length()));
            }
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new b(this, hashMap).start();
        return true;
    }

    public final a h(int i) {
        a aVar;
        r.l("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.c) {
                    synchronized (this.d) {
                        c cVar = this.e;
                        if (cVar == null || !cVar.e) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        f(false);
                        if (!this.c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                r.m(this.a);
                r.m(this.b);
                try {
                    aVar = new a(this.b.zzc(), this.b.zze(true));
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        i();
        return aVar;
    }

    public final void i() {
        synchronized (this.d) {
            c cVar = this.e;
            if (cVar != null) {
                cVar.d.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.g;
            if (j > 0) {
                this.e = new c(this, j);
            }
        }
    }

    public a(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.d = new Object();
        r.m(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f = context;
        this.c = false;
        this.g = j;
    }

    public static void c(boolean z) {
    }
}
