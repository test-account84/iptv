package X0;

import Q0.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends d {
    public static final String j = k.f("NetworkStateTracker");
    public final ConnectivityManager g;
    public b h;
    public a i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            k.c().a(g.j, "Network broadcast received", new Throwable[0]);
            g gVar = g.this;
            gVar.d(gVar.g());
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            k.c().a(g.j, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            g gVar = g.this;
            gVar.d(gVar.g());
        }

        public void onLost(Network network) {
            k.c().a(g.j, "Network connection lost", new Throwable[0]);
            g gVar = g.this;
            gVar.d(gVar.g());
        }
    }

    public g(Context context, c1.a aVar) {
        super(context, aVar);
        this.g = (ConnectivityManager) this.b.getSystemService("connectivity");
        if (j()) {
            this.h = new b();
        } else {
            this.i = new a();
        }
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public void e() {
        if (!j()) {
            k.c().a(j, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        try {
            k.c().a(j, "Registering network callback", new Throwable[0]);
            f.a(this.g, this.h);
        } catch (IllegalArgumentException | SecurityException e) {
            k.c().b(j, "Received exception while registering network callback", e);
        }
    }

    public void f() {
        if (!j()) {
            k.c().a(j, "Unregistering broadcast receiver", new Throwable[0]);
            this.b.unregisterReceiver(this.i);
            return;
        }
        try {
            k.c().a(j, "Unregistering network callback", new Throwable[0]);
            this.g.unregisterNetworkCallback(this.h);
        } catch (IllegalArgumentException | SecurityException e) {
            k.c().b(j, "Received exception while unregistering network callback", e);
        }
    }

    public V0.b g() {
        NetworkInfo activeNetworkInfo = this.g.getActiveNetworkInfo();
        boolean z = false;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean i = i();
        boolean a2 = K.a.a(this.g);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z = true;
        }
        return new V0.b(z2, i, a2, z);
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public V0.b b() {
        return g();
    }

    public boolean i() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = this.g.getNetworkCapabilities(e.a(this.g));
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            k.c().b(j, "Unable to validate active network", e);
            return false;
        }
    }
}
