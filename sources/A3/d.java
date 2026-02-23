package A3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d {
    public final Context a;
    public final c b;
    public final A3.c c;
    public final Handler d = k0.z();
    public b e;
    public int f;
    public d g;

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            d.a(d.this);
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this();
        }
    }

    public interface c {
        void a(d dVar, int i);
    }

    public final class d extends ConnectivityManager.NetworkCallback {
        public boolean a;
        public boolean b;

        public d() {
        }

        public static /* synthetic */ void a(d dVar) {
            dVar.d();
        }

        public static /* synthetic */ void b(d dVar) {
            dVar.c();
        }

        public final /* synthetic */ void c() {
            if (d.c(d.this) != null) {
                d.a(d.this);
            }
        }

        public final /* synthetic */ void d() {
            if (d.c(d.this) != null) {
                d.d(d.this);
            }
        }

        public final void e() {
            d.b(d.this).post(new e(this));
        }

        public final void f() {
            d.b(d.this).post(new f(this));
        }

        public void onAvailable(Network network) {
            e();
        }

        public void onBlockedStatusChanged(Network network, boolean z) {
            if (z) {
                return;
            }
            f();
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (this.a && this.b == hasCapability) {
                if (hasCapability) {
                    f();
                }
            } else {
                this.a = true;
                this.b = hasCapability;
                e();
            }
        }

        public void onLost(Network network) {
            e();
        }

        public /* synthetic */ d(d dVar, a aVar) {
            this();
        }
    }

    public d(Context context, c cVar, A3.c cVar2) {
        this.a = context.getApplicationContext();
        this.b = cVar;
        this.c = cVar2;
    }

    public static /* synthetic */ void a(d dVar) {
        dVar.e();
    }

    public static /* synthetic */ Handler b(d dVar) {
        return dVar.d;
    }

    public static /* synthetic */ d c(d dVar) {
        return dVar.g;
    }

    public static /* synthetic */ void d(d dVar) {
        dVar.g();
    }

    public final void e() {
        int d2 = this.c.d(this.a);
        if (this.f != d2) {
            this.f = d2;
            this.b.a(this, d2);
        }
    }

    public A3.c f() {
        return this.c;
    }

    public final void g() {
        if ((this.f & 3) == 0) {
            return;
        }
        e();
    }

    public final void h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) d4.a.e((ConnectivityManager) this.a.getSystemService("connectivity"));
        d dVar = new d(this, null);
        this.g = dVar;
        X0.f.a(connectivityManager, dVar);
    }

    public int i() {
        String str;
        this.f = this.c.d(this.a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.c.r()) {
            if (k0.a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.c.f()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.c.k()) {
            if (k0.a >= 23) {
                str = "android.os.action.DEVICE_IDLE_MODE_CHANGED";
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                str = "android.intent.action.SCREEN_OFF";
            }
            intentFilter.addAction(str);
        }
        if (this.c.v()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        b bVar = new b(this, null);
        this.e = bVar;
        this.a.registerReceiver(bVar, intentFilter, (String) null, this.d);
        return this.f;
    }

    public void j() {
        this.a.unregisterReceiver((BroadcastReceiver) d4.a.e(this.e));
        this.e = null;
        if (k0.a < 24 || this.g == null) {
            return;
        }
        k();
    }

    public final void k() {
        ((ConnectivityManager) d4.a.e((ConnectivityManager) this.a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) d4.a.e(this.g));
        this.g = null;
    }
}
