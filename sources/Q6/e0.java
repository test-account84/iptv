package q6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e0 implements Runnable {
    public static final Object g = new Object();
    public static Boolean h;
    public static Boolean i;
    public final Context a;
    public final I c;
    public final PowerManager.WakeLock d;
    public final d0 e;
    public final long f;

    public class a extends BroadcastReceiver {
        public e0 a;

        public a(e0 e0Var) {
            this.a = e0Var;
        }

        public void a() {
            if (e0.d()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            e0.a(e0.this).registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public synchronized void onReceive(Context context, Intent intent) {
            try {
                e0 e0Var = this.a;
                if (e0Var == null) {
                    return;
                }
                if (e0.c(e0Var)) {
                    if (e0.d()) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    e0.b(this.a).l(this.a, 0L);
                    context.unregisterReceiver(this);
                    this.a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public e0(d0 d0Var, Context context, I i2, long j) {
        this.e = d0Var;
        this.a = context;
        this.f = j;
        this.c = i2;
        this.d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static /* bridge */ /* synthetic */ Context a(e0 e0Var) {
        return e0Var.a;
    }

    public static /* bridge */ /* synthetic */ d0 b(e0 e0Var) {
        return e0Var.e;
    }

    public static /* bridge */ /* synthetic */ boolean c(e0 e0Var) {
        return e0Var.i();
    }

    public static /* bridge */ /* synthetic */ boolean d() {
        return j();
    }

    public static String e(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 142);
        sb.append("Missing Permission: ");
        sb.append(str);
        sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        return sb.toString();
    }

    public static boolean f(Context context) {
        boolean booleanValue;
        synchronized (g) {
            try {
                Boolean bool = i;
                Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                i = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    public static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (z || !Log.isLoggable("FirebaseMessaging", 3)) {
            return z;
        }
        Log.d("FirebaseMessaging", e(str));
        return false;
    }

    public static boolean h(Context context) {
        boolean booleanValue;
        synchronized (g) {
            try {
                Boolean bool = h;
                Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                h = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    public static boolean j() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    public final synchronized boolean i() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void run() {
        if (h(this.a)) {
            this.d.acquire(c.a);
        }
        try {
            try {
                this.e.n(true);
                if (!this.c.g()) {
                    this.e.n(false);
                    if (h(this.a)) {
                        try {
                            this.d.release();
                            return;
                        } catch (RuntimeException unused) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                            return;
                        }
                    }
                    return;
                }
                if (f(this.a) && !i()) {
                    new a(this).a();
                    if (h(this.a)) {
                        try {
                            this.d.release();
                            return;
                        } catch (RuntimeException unused2) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                            return;
                        }
                    }
                    return;
                }
                if (this.e.r()) {
                    this.e.n(false);
                } else {
                    this.e.s(this.f);
                }
                if (h(this.a)) {
                    try {
                        this.d.release();
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } catch (Throwable th) {
                if (h(this.a)) {
                    try {
                        this.d.release();
                    } catch (RuntimeException unused4) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseMessaging", valueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(valueOf) : new String("Failed to sync topics. Won't retry sync. "));
            this.e.n(false);
            if (h(this.a)) {
                try {
                    this.d.release();
                } catch (RuntimeException unused5) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
        }
    }
}
