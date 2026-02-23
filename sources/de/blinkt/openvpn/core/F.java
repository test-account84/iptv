package de.blinkt.openvpn.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.n;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class f extends BroadcastReceiver implements G.b, n.a {
    public final Handler a;
    public n d;
    public c i;
    public c j;
    public String k;
    public Runnable l;
    public NetworkInfo m;
    public LinkedList n;
    public int c = -1;
    public final int e = 60;
    public final long f = 65536;
    public final int g = 20;
    public c h = c.DISCONNECTED;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f fVar = f.this;
            c cVar = fVar.h;
            c cVar2 = c.PENDINGDISCONNECT;
            if (cVar != cVar2) {
                return;
            }
            c cVar3 = c.DISCONNECTED;
            fVar.h = cVar3;
            if (fVar.i == cVar2) {
                fVar.i = cVar3;
            }
            f.c(fVar).b(f.b(f.this));
        }
    }

    public static class b {
        public long a;
        public long b;

        public b(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public /* synthetic */ b(long j, long j2, a aVar) {
            this(j, j2);
        }
    }

    public enum c {
        SHOULDBECONNECTED,
        PENDINGDISCONNECT,
        DISCONNECTED
    }

    public f(n nVar) {
        c cVar = c.SHOULDBECONNECTED;
        this.i = cVar;
        this.j = cVar;
        this.k = null;
        this.l = new a();
        this.n = new LinkedList();
        this.d = nVar;
        nVar.e(this);
        this.a = new Handler();
    }

    public static /* synthetic */ n.b b(f fVar) {
        return fVar.g();
    }

    public static /* synthetic */ n c(f fVar) {
        return fVar.d;
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public void E(long j, long j2, long j3, long j4) {
        LinkedList linkedList;
        if (this.i != c.PENDINGDISCONNECT) {
            return;
        }
        this.n.add(new b(System.currentTimeMillis(), j3 + j4, null));
        while (true) {
            long j5 = ((b) this.n.getFirst()).a;
            long currentTimeMillis = System.currentTimeMillis() - 60000;
            linkedList = this.n;
            if (j5 > currentTimeMillis) {
                break;
            } else {
                linkedList.removeFirst();
            }
        }
        Iterator it = linkedList.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += ((b) it.next()).b;
        }
        if (j6 < 65536) {
            this.i = c.DISCONNECTED;
            G.t(a7.j.x6, "64 kB", 60);
            this.d.b(g());
        }
    }

    public boolean a() {
        return j();
    }

    public final void e() {
        this.n.add(new b(System.currentTimeMillis(), 65536L, null));
    }

    public final NetworkInfo f(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public final n.b g() {
        c cVar = this.j;
        c cVar2 = c.DISCONNECTED;
        return cVar == cVar2 ? n.b.userPause : this.i == cVar2 ? n.b.screenOff : this.h == cVar2 ? n.b.noNetwork : n.b.userPause;
    }

    public boolean h() {
        return this.j == c.DISCONNECTED;
    }

    public void i(Context context) {
        String format;
        NetworkInfo f = f(context);
        boolean z = B.a(context).getBoolean("netchangereconnect", true);
        if (f == null) {
            format = "not connected";
        } else {
            String subtypeName = f.getSubtypeName();
            if (subtypeName == null) {
                subtypeName = "";
            }
            String extraInfo = f.getExtraInfo();
            format = String.format("%2$s %4$s to %1$s %3$s", new Object[]{f.getTypeName(), f.getDetailedState(), extraInfo != null ? extraInfo : "", subtypeName});
        }
        if (f != null && f.getState() == NetworkInfo.State.CONNECTED) {
            int type = f.getType();
            c cVar = this.h;
            c cVar2 = c.PENDINGDISCONNECT;
            boolean z2 = cVar == cVar2;
            this.h = c.SHOULDBECONNECTED;
            NetworkInfo networkInfo = this.m;
            boolean z3 = networkInfo != null && networkInfo.getType() == f.getType() && d(this.m.getExtraInfo(), f.getExtraInfo());
            if (z2 && z3) {
                this.a.removeCallbacks(this.l);
                this.d.d(true);
            } else {
                if (this.i == cVar2) {
                    this.i = c.DISCONNECTED;
                }
                if (j()) {
                    this.a.removeCallbacks(this.l);
                    if (z2 || !z3) {
                        this.d.d(z3);
                    } else {
                        this.d.resume();
                    }
                }
                this.c = type;
                this.m = f;
            }
        } else if (f == null) {
            this.c = -1;
            if (z) {
                this.h = c.PENDINGDISCONNECT;
                this.a.postDelayed(this.l, 20000L);
            }
        }
        if (!format.equals(this.k)) {
            G.t(a7.j.X3, format);
        }
        G.m(String.format("Debug state info: %s, pause: %s, shouldbeconnected: %s, network: %s ", new Object[]{format, g(), Boolean.valueOf(j()), this.h}));
        this.k = format;
    }

    public final boolean j() {
        c cVar = this.i;
        c cVar2 = c.SHOULDBECONNECTED;
        return cVar == cVar2 && this.j == cVar2 && this.h == cVar2;
    }

    public void k(boolean z) {
        if (z) {
            this.j = c.DISCONNECTED;
        } else {
            boolean j = j();
            this.j = c.SHOULDBECONNECTED;
            if (j() && !j) {
                this.d.resume();
                return;
            }
        }
        this.d.b(g());
    }

    public void onReceive(Context context, Intent intent) {
        SharedPreferences a2 = B.a(context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            i(context);
            return;
        }
        if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean j = j();
                this.i = c.SHOULDBECONNECTED;
                this.a.removeCallbacks(this.l);
                if (j() != j) {
                    this.d.resume();
                    return;
                } else {
                    if (j()) {
                        return;
                    }
                    this.d.b(g());
                    return;
                }
            }
            return;
        }
        if (a2.getBoolean("screenoff", false)) {
            if (C.i() != null && !C.i().N) {
                G.n(a7.j.w6);
            }
            this.i = c.PENDINGDISCONNECT;
            e();
            c cVar = this.h;
            c cVar2 = c.DISCONNECTED;
            if (cVar == cVar2 || this.j == cVar2) {
                this.i = cVar2;
            }
        }
    }
}
