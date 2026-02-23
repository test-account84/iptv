package de.blinkt.openvpn.core;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ProxyInfo;
import android.net.VpnService;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.d;
import de.blinkt.openvpn.core.h;
import de.blinkt.openvpn.core.l;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OpenVPNService extends VpnService implements G.e, Handler.Callback, G.b, h {
    public static boolean y = false;
    public String f;
    public f8.l h;
    public int k;
    public f m;
    public long p;
    public n q;
    public String s;
    public String t;
    public Handler u;
    public Toast v;
    public Runnable w;
    public ProxyInfo x;
    public final Vector a = new Vector();
    public final l c = new l();
    public final l d = new l();
    public final Object e = new Object();
    public Thread g = null;
    public String i = null;
    public de.blinkt.openvpn.core.a j = null;
    public String l = null;
    public boolean n = false;
    public boolean o = false;
    public final IBinder r = new a();

    public class a extends h.a {
        public a() {
        }

        public void H0(String str) {
            OpenVPNService.this.H0(str);
        }

        public void L0(String str) {
            OpenVPNService.this.L0(str);
        }

        public void T(boolean z) {
            OpenVPNService.this.T(z);
        }

        public boolean a(boolean z) {
            return OpenVPNService.this.a(z);
        }

        public boolean protect(int i) {
            return OpenVPNService.this.protect(i);
        }

        public boolean s(String str) {
            return OpenVPNService.this.s(str);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        public void run() {
            if (OpenVPNService.A(OpenVPNService.this) != null) {
                OpenVPNService.A(OpenVPNService.this).cancel();
            }
            String format = String.format(Locale.getDefault(), "%s - %s", new Object[]{OpenVPNService.d1(OpenVPNService.this).d, this.a});
            OpenVPNService openVPNService = OpenVPNService.this;
            OpenVPNService.c1(openVPNService, Toast.makeText(openVPNService.getBaseContext(), format, 0));
            OpenVPNService.A(OpenVPNService.this).show();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            OpenVPNService.e1(OpenVPNService.this);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            if (OpenVPNService.f1(OpenVPNService.this) != null) {
                OpenVPNService.this.T1();
            }
            OpenVPNService openVPNService = OpenVPNService.this;
            openVPNService.G1(OpenVPNService.g1(openVPNService));
        }
    }

    public static /* synthetic */ class e {
        public static final /* synthetic */ int[] a = new int[de.blinkt.openvpn.core.e.values().length];
    }

    public static /* synthetic */ Toast A(OpenVPNService openVPNService) {
        return openVPNService.v;
    }

    public static /* synthetic */ Toast c1(OpenVPNService openVPNService, Toast toast) {
        openVPNService.v = toast;
        return toast;
    }

    public static /* synthetic */ f8.l d1(OpenVPNService openVPNService) {
        return openVPNService.h;
    }

    public static /* synthetic */ void e1(OpenVPNService openVPNService) {
        openVPNService.Q1();
    }

    public static /* synthetic */ f f1(OpenVPNService openVPNService) {
        return openVPNService.m;
    }

    public static /* synthetic */ n g1(OpenVPNService openVPNService) {
        return openVPNService.q;
    }

    public static String y1(long j, boolean z, Resources resources) {
        if (z) {
            j *= 8;
        }
        double d2 = j;
        double d3 = z ? 1000 : 1024;
        int max = Math.max(0, Math.min((int) (Math.log(d2) / Math.log(d3)), 3));
        float pow = (float) (d2 / Math.pow(d3, max));
        return z ? max != 0 ? max != 1 ? max != 2 ? resources.getString(a7.j.m2, new Object[]{Float.valueOf(pow)}) : resources.getString(a7.j.k3, new Object[]{Float.valueOf(pow)}) : resources.getString(a7.j.N2, new Object[]{Float.valueOf(pow)}) : resources.getString(a7.j.V, new Object[]{Float.valueOf(pow)}) : max != 0 ? max != 1 ? max != 2 ? resources.getString(a7.j.A8, new Object[]{Float.valueOf(pow)}) : resources.getString(a7.j.C8, new Object[]{Float.valueOf(pow)}) : resources.getString(a7.j.B8, new Object[]{Float.valueOf(pow)}) : resources.getString(a7.j.z8, new Object[]{Float.valueOf(pow)});
    }

    public final boolean A1(String str) {
        return str != null && (str.startsWith("tun") || "(null)".equals(str) || "vpnservice-tun".equals(str));
    }

    public final boolean B1() {
        if (Build.VERSION.SDK_INT >= 29) {
            return u.a(this);
        }
        return false;
    }

    public final void C1(int i, Notification.Builder builder) {
        if (i != 0) {
            try {
                builder.getClass().getMethod("setPriority", new Class[]{Integer.TYPE}).invoke(builder, new Object[]{Integer.valueOf(i)});
                builder.getClass().getMethod("setUsesChronometer", new Class[]{Boolean.TYPE}).invoke(builder, new Object[]{Boolean.TRUE});
            } catch (NoSuchMethodException | InvocationTargetException | IllegalArgumentException | IllegalAccessException e2) {
                G.r(e2);
            }
        }
    }

    public final void D1(Notification.Builder builder, String str) {
        builder.setCategory(str);
        builder.setLocalOnly(true);
    }

    public void E(long j, long j2, long j3, long j4) {
        if (this.n) {
            P1(String.format(getString(a7.j.N7), new Object[]{y1(j, false, getResources()), y1(j3 / 2, true, getResources()), y1(j2, false, getResources()), y1(j4 / 2, true, getResources())}), null, "openvpn_bg", this.p, de.blinkt.openvpn.core.e.LEVEL_CONNECTED, null);
        }
    }

    public ParcelFileDescriptor E1() {
        int i;
        String string;
        String str;
        VpnService.Builder builder = new VpnService.Builder(this);
        G.t(a7.j.R2, new Object[0]);
        boolean z = !this.h.x0;
        if (z) {
            p1(builder);
        }
        de.blinkt.openvpn.core.a aVar = this.j;
        if (aVar == null && this.l == null) {
            G.p(getString(a7.j.P4));
            return null;
        }
        if (aVar != null) {
            if (!f8.l.h(this)) {
                j1();
            }
            try {
                de.blinkt.openvpn.core.a aVar2 = this.j;
                builder.addAddress(aVar2.a, aVar2.b);
            } catch (IllegalArgumentException e2) {
                G.o(a7.j.R0, this.j, e2.getLocalizedMessage());
                return null;
            }
        }
        String str2 = this.l;
        if (str2 != null) {
            String[] split = str2.split("/");
            try {
                builder.addAddress(split[0], Integer.parseInt(split[1]));
            } catch (IllegalArgumentException e3) {
                G.o(a7.j.I2, this.l, e3.getLocalizedMessage());
                return null;
            }
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            try {
                builder.addDnsServer(str3);
            } catch (IllegalArgumentException e4) {
                G.o(a7.j.R0, str3, e4.getLocalizedMessage());
            }
        }
        String str4 = Build.VERSION.RELEASE;
        builder.setMtu(this.k);
        Collection<l.a> f = this.c.f();
        Collection<l.a> f2 = this.d.f();
        if ("samsung".equals(Build.BRAND) && this.a.size() >= 1) {
            try {
                l.a aVar3 = new l.a(new de.blinkt.openvpn.core.a((String) this.a.get(0), 32), true);
                Iterator it2 = f.iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    if (((l.a) it2.next()).c(aVar3)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    G.z(String.format("Warning Samsung Android 5.0+ devices ignore DNS servers outside the VPN range. To enable DNS resolution a route to your DNS Server (%s) has been added.", new Object[]{this.a.get(0)}));
                    f.add(aVar3);
                }
            } catch (Exception unused) {
                if (!((String) this.a.get(0)).contains(":")) {
                    G.p("Error parsing DNS Server IP: " + ((String) this.a.get(0)));
                }
            }
        }
        l.a aVar4 = new l.a(new de.blinkt.openvpn.core.a("224.0.0.0", 3), true);
        for (l.a aVar5 : f) {
            try {
                if (aVar4.c(aVar5)) {
                    G.l(a7.j.s2, aVar5.toString());
                } else {
                    builder.addRoute(aVar5.i(), aVar5.c);
                }
            } catch (IllegalArgumentException e5) {
                G.p(getString(a7.j.r6) + aVar5 + " " + e5.getLocalizedMessage());
            }
        }
        for (l.a aVar6 : f2) {
            try {
                builder.addRoute(aVar6.j(), aVar6.c);
            } catch (IllegalArgumentException e6) {
                G.p(getString(a7.j.r6) + aVar6 + " " + e6.getLocalizedMessage());
            }
        }
        String str5 = this.i;
        if (str5 != null) {
            builder.addSearchDomain(str5);
        }
        String str6 = z ? "(not set, allowed)" : "(not set)";
        String str7 = str6;
        de.blinkt.openvpn.core.a aVar7 = this.j;
        if (aVar7 != null) {
            int i2 = aVar7.b;
            String str8 = aVar7.a;
            i = i2;
            str6 = str8;
        } else {
            i = -1;
        }
        String str9 = this.l;
        if (str9 != null) {
            str7 = str9;
        }
        if ((!this.c.e(false).isEmpty() || !this.d.e(false).isEmpty()) && B1()) {
            G.u("VPN lockdown enabled (do not allow apps to bypass VPN) enabled. Route exclusion will not allow apps to bypass VPN (e.g. bypass VPN for local networks)");
        }
        G.t(a7.j.Z2, str6, Integer.valueOf(i), str7, Integer.valueOf(this.k));
        G.t(a7.j.S0, TextUtils.join(", ", this.a), this.i);
        G.t(a7.j.u6, TextUtils.join(", ", this.c.e(true)), TextUtils.join(", ", this.d.e(true)));
        G.t(a7.j.t6, TextUtils.join(", ", this.c.e(false)), TextUtils.join(", ", this.d.e(false)));
        ProxyInfo proxyInfo = this.x;
        if (proxyInfo != null) {
            G.t(a7.j.K5, proxyInfo.getHost(), Integer.valueOf(this.x.getPort()));
        }
        G.l(a7.j.s6, TextUtils.join(", ", f), TextUtils.join(", ", f2));
        int i3 = Build.VERSION.SDK_INT;
        J1(builder);
        if (i3 >= 22) {
            s.a(builder, null);
        }
        if (i3 >= 29) {
            t.a(builder, false);
        }
        String str10 = this.h.d;
        de.blinkt.openvpn.core.a aVar8 = this.j;
        if (aVar8 == null || (str = this.l) == null) {
            int i4 = a7.j.R6;
            string = aVar8 != null ? getString(i4, new Object[]{str10, aVar8}) : getString(i4, new Object[]{str10, this.l});
        } else {
            string = getString(a7.j.S6, new Object[]{str10, aVar8, str});
        }
        builder.setSession(string);
        if (this.a.size() == 0) {
            G.t(a7.j.N8, new Object[0]);
        }
        L1(builder);
        this.s = w1();
        this.a.clear();
        this.c.c();
        this.d.c();
        this.j = null;
        this.l = null;
        this.i = null;
        this.x = null;
        builder.setConfigureIntent(t1());
        try {
            ParcelFileDescriptor establish = builder.establish();
            if (establish != null) {
                return establish;
            }
            throw new NullPointerException("Android establish() method returned null (Really broken network configuration?)");
        } catch (Exception e7) {
            G.n(a7.j.Y7);
            G.p(getString(a7.j.H1) + e7.getLocalizedMessage());
            return null;
        }
    }

    public void F1() {
        r1();
    }

    public synchronized void G1(n nVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        f fVar = new f(nVar);
        this.m = fVar;
        fVar.i(this);
        registerReceiver(this.m, intentFilter);
        G.a(this.m);
    }

    public void H0(String str) {
        new h8.b(this).a(str);
    }

    public void H1(int i, String str) {
        de.blinkt.openvpn.core.e eVar = de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT;
        G.J("NEED", "need " + str, i, eVar);
        P1(getString(i), getString(i), "openvpn_newstat", 0L, eVar, null);
    }

    public final boolean I1() {
        return ((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4;
    }

    public final void J1(VpnService.Builder builder) {
        boolean z = false;
        for (de.blinkt.openvpn.core.d dVar : this.h.Y) {
            if (dVar.i == d.a.ORBOT) {
                z = true;
            }
        }
        if (z) {
            G.m("VPN Profile uses at least one server entry with Orbot. Setting up VPN so that OrBot is not redirected over VPN.");
        }
        if (this.h.f0 && z) {
            try {
                builder.addDisallowedApplication("org.torproject.android");
            } catch (PackageManager.NameNotFoundException unused) {
                G.m("Orbot not installed?");
            }
        }
        try {
            builder.addAllowedApplication(getPackageName());
        } catch (PackageManager.NameNotFoundException e2) {
            G.p("This should not happen: " + e2.getLocalizedMessage());
        }
        f8.l lVar = this.h;
        if (lVar.f0) {
            G.l(a7.j.Q0, TextUtils.join(", ", lVar.e0));
        } else {
            G.l(a7.j.C, TextUtils.join(", ", lVar.e0));
        }
        if (this.h.g0) {
            builder.allowBypass();
            G.m("Apps may bypass VPN");
        }
    }

    public void K1(String str) {
        if (this.i == null) {
            this.i = str;
        }
    }

    public void L0(String str) {
        if (this.q != null) {
            this.q.c(Base64.encodeToString(str.getBytes(Charset.forName("UTF-8")), 0));
        }
    }

    public final void L1(VpnService.Builder builder) {
        ProxyInfo proxyInfo = this.x;
        if (proxyInfo != null && Build.VERSION.SDK_INT >= 29) {
            v.a(builder, proxyInfo);
        } else if (proxyInfo != null) {
            G.z("HTTP Proxy needs Android 10 or later.");
        }
    }

    public void M1(String str, String str2, int i, String str3) {
        long j;
        int i2;
        this.j = new de.blinkt.openvpn.core.a(str, str2);
        this.k = i;
        this.t = null;
        long c2 = de.blinkt.openvpn.core.a.c(str2);
        if (this.j.b == 32 && !str2.equals("255.255.255.255")) {
            if ("net30".equals(str3)) {
                j = -4;
                i2 = 30;
            } else {
                j = -2;
                i2 = 31;
            }
            long j2 = c2 & j;
            long b2 = this.j.b() & j;
            de.blinkt.openvpn.core.a aVar = this.j;
            if (j2 == b2) {
                aVar.b = i2;
            } else {
                aVar.b = 32;
                if (!"p2p".equals(str3)) {
                    G.y(a7.j.K2, str, str2, str3);
                }
            }
        }
        if (("p2p".equals(str3) && this.j.b < 32) || ("net30".equals(str3) && this.j.b < 30)) {
            G.y(a7.j.J2, str, str2, str3);
        }
        de.blinkt.openvpn.core.a aVar2 = this.j;
        int i3 = aVar2.b;
        if (i3 <= 31) {
            de.blinkt.openvpn.core.a aVar3 = new de.blinkt.openvpn.core.a(aVar2.a, i3);
            aVar3.d();
            k1(aVar3, true);
        }
        this.t = str2;
    }

    public void N1(String str) {
        this.l = str;
    }

    public void O1(int i) {
        this.k = i;
    }

    public final void P1(String str, String str2, String str3, long j, de.blinkt.openvpn.core.e eVar, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        int u1 = u1(eVar);
        Notification.Builder builder = new Notification.Builder(this);
        int i = str3.equals("openvpn_bg") ? -2 : str3.equals("openvpn_userreq") ? 2 : 0;
        f8.l lVar = this.h;
        builder.setContentTitle(lVar != null ? getString(a7.j.H4, new Object[]{lVar.d}) : getString(a7.j.I4));
        builder.setContentText(str);
        builder.setOnlyAlertOnce(true);
        builder.setOngoing(true);
        builder.setSmallIcon(u1);
        builder.setContentIntent(eVar == de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT ? PendingIntent.getActivity(this, 0, intent, 67108864) : t1());
        if (j != 0) {
            builder.setWhen(j);
        }
        int i2 = Build.VERSION.SDK_INT;
        C1(i, builder);
        o1(builder);
        D1(builder, "service");
        if (i2 >= 26) {
            com.amplifyframework.storage.s3.service.a.a(notificationManager, com.amplifyframework.storage.s3.service.b.a(str3, str3, 3));
            com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications.b.a(builder, str3);
            f8.l lVar2 = this.h;
            if (lVar2 != null) {
                D.p.a(builder, lVar2.B());
            }
        }
        if (str2 != null && !str2.equals("")) {
            builder.setTicker(str2);
        }
        Notification notification = builder.getNotification();
        int hashCode = str3.hashCode();
        notificationManager.notify(hashCode, notification);
        startForeground(hashCode, notification);
        String str4 = this.f;
        if (str4 != null && !str3.equals(str4)) {
            notificationManager.cancel(this.f.hashCode());
        }
        if (!I1() || i < 0) {
            return;
        }
        this.u.post(new b(str));
    }

    public final void Q1() {
        String str;
        Runnable runnable;
        try {
            this.h.N(this);
            String str2 = getApplicationInfo().nativeLibraryDir;
            try {
                str = getApplication().getCacheDir().getCanonicalPath();
            } catch (IOException e2) {
                e2.printStackTrace();
                str = "/tmp";
            }
            String[] a2 = F.a(this);
            this.o = true;
            R1();
            this.o = false;
            boolean h = f8.l.h(this);
            if (!h) {
                y yVar = new y(this.h, this);
                if (!yVar.p(this)) {
                    r1();
                    return;
                } else {
                    new Thread(yVar, "OpenVPNManagementThread").start();
                    this.q = yVar;
                    G.u("started Socket Thread");
                }
            }
            if (h) {
                n z1 = z1();
                runnable = (Runnable) z1;
                this.q = z1;
            } else {
                w wVar = new w(this, a2, str2, str);
                this.w = wVar;
                runnable = wVar;
            }
            synchronized (this.e) {
                Thread thread = new Thread(runnable, "OpenVPNProcessThread");
                this.g = thread;
                thread.start();
            }
            new Handler(getMainLooper()).post(new d());
        } catch (IOException e3) {
            G.s("Error writing config file", e3);
            r1();
        }
    }

    public final void R1() {
        if (this.q != null) {
            Runnable runnable = this.w;
            if (runnable != null) {
                ((w) runnable).b();
            }
            if (this.q.a(true)) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
            }
        }
        s1();
    }

    public void S1(String str) {
        String str2 = str.split(":", 2)[0];
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setSmallIcon(17301659);
        str2.hashCode();
        if (!str2.equals("CR_TEXT")) {
            G.p("Unknown SSO method found: " + str2);
            return;
        }
        CharSequence charSequence = str.split(":", 2)[1];
        int i = a7.j.C0;
        builder.setContentTitle(getString(i));
        builder.setContentText(charSequence);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, getPackageName() + ".activities.CredentialsPopup"));
        intent.putExtra("de.blinkt.openvpn.core.CR_TEXT_CHALLENGE", charSequence);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 67108864);
        G.K("USER_INPUT", "waiting for user input", i, de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT, intent);
        builder.setContentIntent(activity);
        int i2 = Build.VERSION.SDK_INT;
        C1(2, builder);
        D1(builder, "status");
        if (i2 >= 26) {
            com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications.b.a(builder, "openvpn_userreq");
        }
        notificationManager.notify(-370124770, builder.getNotification());
    }

    public void T(boolean z) {
        f fVar = this.m;
        if (fVar != null) {
            fVar.k(z);
        }
    }

    public synchronized void T1() {
        f fVar = this.m;
        if (fVar != null) {
            try {
                G.C(fVar);
                unregisterReceiver(this.m);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
            this.m = null;
        } else {
            this.m = null;
        }
    }

    public final void U1(f8.l lVar) {
        if (lVar == null) {
            return;
        }
        r.a(q.a(p.a(this, o.a())), lVar.B());
    }

    public void Z(String str) {
    }

    public boolean a(boolean z) {
        if (v1() != null) {
            return v1().a(z);
        }
        return false;
    }

    public IBinder asBinder() {
        return this.r;
    }

    public void c0(String str, String str2, int i, de.blinkt.openvpn.core.e eVar, Intent intent) {
        q1(str, eVar);
        if (this.g != null || y) {
            if (eVar == de.blinkt.openvpn.core.e.LEVEL_CONNECTED) {
                this.n = true;
                this.p = System.currentTimeMillis();
                String str3 = I1() ? "openvpn_newstat" : "openvpn_bg";
                P1(G.f(this), G.f(this), str3, 0L, eVar, intent);
            }
            this.n = false;
            P1(G.f(this), G.f(this), str3, 0L, eVar, intent);
        }
    }

    public void h1(String str) {
        this.a.add(str);
    }

    public boolean handleMessage(Message message) {
        Runnable callback = message.getCallback();
        if (callback == null) {
            return false;
        }
        callback.run();
        return true;
    }

    public boolean i1(String str, int i) {
        try {
            this.x = ProxyInfo.buildDirectProxy(str, i);
            return true;
        } catch (Exception e2) {
            G.p("Could not set proxy" + e2.getLocalizedMessage());
            return false;
        }
    }

    public final void j1() {
        Iterator it = m.a(this, false).iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("/");
            String str = split[0];
            int parseInt = Integer.parseInt(split[1]);
            if (!str.equals(this.j.a) && this.h.V) {
                this.c.a(new de.blinkt.openvpn.core.a(str, parseInt), false);
            }
        }
        if (this.h.V) {
            Iterator it2 = m.a(this, true).iterator();
            while (it2.hasNext()) {
                n1((String) it2.next(), false);
            }
        }
    }

    public void k1(de.blinkt.openvpn.core.a aVar, boolean z) {
        this.c.a(aVar, z);
    }

    public void l1(String str, String str2, String str3, String str4) {
        de.blinkt.openvpn.core.a aVar = new de.blinkt.openvpn.core.a(str, str2);
        boolean A1 = A1(str4);
        l.a aVar2 = new l.a(new de.blinkt.openvpn.core.a(str3, 32), false);
        de.blinkt.openvpn.core.a aVar3 = this.j;
        if (aVar3 == null) {
            G.p("Local IP address unset and received. Neither pushed server config nor local config specifies an IP addresses. Opening tun device is most likely going to fail.");
            return;
        }
        if (new l.a(aVar3, true).c(aVar2)) {
            A1 = true;
        }
        if (str3 != null && (str3.equals("255.255.255.255") || str3.equals(this.t))) {
            A1 = true;
        }
        if (aVar.b == 32 && !str2.equals("255.255.255.255")) {
            G.y(a7.j.p6, str, str2);
        }
        if (aVar.d()) {
            G.y(a7.j.q6, str, Integer.valueOf(aVar.b), aVar.a);
        }
        this.c.a(aVar, A1);
    }

    public void m1(String str, String str2) {
        n1(str, A1(str2));
    }

    public void n1(String str, boolean z) {
        String[] split = str.split("/");
        try {
            this.d.b(InetAddress.getAllByName(split[0])[0], Integer.parseInt(split[1]), z);
        } catch (UnknownHostException e2) {
            G.r(e2);
        }
    }

    public final void o1(Notification.Builder builder) {
        PendingIntent service;
        int i;
        int i2;
        Intent intent = new Intent(this, g8.a.class);
        intent.setAction("de.blinkt.openvpn.DISCONNECT_VPN");
        builder.addAction(a7.e.B0, getString(a7.j.d0), PendingIntent.getActivity(this, 0, intent, 67108864));
        Intent intent2 = new Intent(this, OpenVPNService.class);
        f fVar = this.m;
        if (fVar == null || !fVar.h()) {
            intent2.setAction("de.blinkt.openvpn.PAUSE_VPN");
            service = PendingIntent.getService(this, 0, intent2, 67108864);
            i = a7.e.U0;
            i2 = a7.j.a5;
        } else {
            intent2.setAction("de.blinkt.openvpn.RESUME_VPN");
            service = PendingIntent.getService(this, 0, intent2, 67108864);
            i = a7.e.V0;
            i2 = a7.j.n6;
        }
        builder.addAction(i, getString(i2), service);
    }

    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        return (action == null || !action.equals("de.blinkt.openvpn.START_SERVICE")) ? super.onBind(intent) : this.r;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        synchronized (this.e) {
            try {
                if (this.g != null) {
                    this.q.a(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar = this.m;
        if (fVar != null) {
            unregisterReceiver(fVar);
        }
        G.E(this);
        G.e();
    }

    public void onRevoke() {
        G.n(a7.j.d5);
        this.q.a(false);
        r1();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onStartCommand(android.content.Intent r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.OpenVPNService.onStartCommand(android.content.Intent, int, int):int");
    }

    public final void p1(VpnService.Builder builder) {
        builder.allowFamily(OsConstants.AF_INET);
        builder.allowFamily(OsConstants.AF_INET6);
    }

    public final void q1(String str, de.blinkt.openvpn.core.e eVar) {
        Intent intent = new Intent();
        intent.setAction("de.blinkt.openvpn.VPN_STATUS");
        intent.putExtra("status", eVar.toString());
        intent.putExtra("detailstatus", str);
        sendBroadcast(intent, "android.permission.ACCESS_NETWORK_STATE");
    }

    public final void r1() {
        synchronized (this.e) {
            this.g = null;
        }
        G.C(this);
        T1();
        C.s(this);
        this.w = null;
        if (this.o) {
            return;
        }
        stopForeground(!y);
        if (y) {
            return;
        }
        stopSelf();
        G.E(this);
    }

    public boolean s(String str) {
        return new h8.b(this).c(this, str);
    }

    public void s1() {
        synchronized (this.e) {
            Thread thread = this.g;
            if (thread != null) {
                thread.interrupt();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public PendingIntent t1() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, getPackageName() + ".activities.MainActivity"));
        intent.putExtra("PAGE", "graph");
        intent.addFlags(131072);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 67108864);
        intent.addFlags(131072);
        return activity;
    }

    public final int u1(de.blinkt.openvpn.core.e eVar) {
        int i = e.a[eVar.ordinal()];
        return a7.i.a;
    }

    public n v1() {
        return this.q;
    }

    public final String w1() {
        String str = "TUNCFG UNQIUE STRING ips:";
        if (this.j != null) {
            str = "TUNCFG UNQIUE STRING ips:" + this.j.toString();
        }
        if (this.l != null) {
            str = str + this.l;
        }
        return (((((str + "routes: " + TextUtils.join("|", this.c.e(true)) + TextUtils.join("|", this.d.e(true))) + "excl. routes:" + TextUtils.join("|", this.c.e(false)) + TextUtils.join("|", this.d.e(false))) + "dns: " + TextUtils.join("|", this.a)) + "domain: " + this.i) + "mtu: " + this.k) + "proxyInfo: " + this.x;
    }

    public String x1() {
        if (w1().equals(this.s)) {
            return "NOACTION";
        }
        String str = Build.VERSION.RELEASE;
        return "OPEN_BEFORE_CLOSE";
    }

    public final n z1() {
        try {
            return (n) Class.forName("de.blinkt.openvpn.core.OpenVPNThreadv3").getConstructor(new Class[]{OpenVPNService.class, f8.l.class}).newInstance(new Object[]{this, this.h});
        } catch (IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
