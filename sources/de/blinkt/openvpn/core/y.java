package de.blinkt.openvpn.core;

import android.content.Context;
import android.content.Intent;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import de.blinkt.openvpn.core.d;
import de.blinkt.openvpn.core.n;
import de.blinkt.openvpn.core.z;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Vector;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class y implements Runnable, n {
    public static final Vector r = new Vector();
    public final Handler a;
    public LocalSocket c;
    public f8.l d;
    public OpenVPNService e;
    public LocalServerSocket g;
    public LocalSocket j;
    public n.a l;
    public boolean m;
    public transient d q;
    public LinkedList f = new LinkedList();
    public boolean h = false;
    public long i = 0;
    public n.b k = n.b.noNetwork;
    public Runnable n = new x(this);
    public Runnable o = new a();
    public z.b p = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            y.g(y.this, d.a.SOCKS5, "127.0.0.1", Integer.toString(9050), false);
            z.d(y.i(y.this)).f(y.h(y.this));
        }
    }

    public class b implements z.b {
        public b() {
        }

        public void a() {
            G.m("Orbot not yet installed");
        }

        public void b(Intent intent) {
            StringBuilder sb = new StringBuilder();
            for (String str : intent.getExtras().keySet()) {
                Object obj = intent.getExtras().get(str);
                sb.append(String.format(Locale.ENGLISH, "%s - '%s'", new Object[]{str, obj == null ? "null" : obj.toString()}));
            }
            G.m("Got Orbot status: " + sb);
        }

        public void c(Intent intent, String str, int i) {
            y.k(y.this).removeCallbacks(y.j(y.this));
            y.g(y.this, d.a.SOCKS5, str, Integer.toString(i), false);
            z.d(y.i(y.this)).f(this);
        }

        public void d(Intent intent) {
            G.z("Orbot integration for external applications is disabled. Waiting %ds before connecting to the default port. Enable external app integration in Orbot or use Socks v5 config instead of Orbot to avoid this delay.");
        }
    }

    public y(f8.l lVar, OpenVPNService openVPNService) {
        this.d = lVar;
        this.e = openVPNService;
        this.a = new Handler(openVPNService.getMainLooper());
    }

    public static boolean I() {
        boolean z;
        Vector vector = r;
        synchronized (vector) {
            Iterator it = vector.iterator();
            z = false;
            while (it.hasNext()) {
                y yVar = (y) it.next();
                boolean o = yVar.o("signal SIGINT\n");
                try {
                    LocalSocket localSocket = yVar.c;
                    if (localSocket != null) {
                        localSocket.close();
                    }
                } catch (IOException unused) {
                }
                z = o;
            }
        }
        return z;
    }

    public static /* synthetic */ void f(y yVar) {
        yVar.n();
    }

    public static /* synthetic */ void g(y yVar, d.a aVar, String str, String str2, boolean z) {
        yVar.E(aVar, str, str2, z);
    }

    public static /* synthetic */ z.b h(y yVar) {
        return yVar.p;
    }

    public static /* synthetic */ OpenVPNService i(y yVar) {
        return yVar.e;
    }

    public static /* synthetic */ Runnable j(y yVar) {
        return yVar.o;
    }

    public static /* synthetic */ Handler k(y yVar) {
        return yVar.a;
    }

    public final void A(String str) {
        String[] split = str.split(",", 3);
        G.I(split[1], split[2].equals(",,") ? "" : split[2]);
    }

    public final void B(FileDescriptor fileDescriptor) {
        try {
            if (!this.e.protect(((Integer) FileDescriptor.class.getDeclaredMethod("getInt$", (Class[]) null).invoke(fileDescriptor, (Object[]) null)).intValue())) {
                G.z("Could not protect VPN socket");
            }
            l(fileDescriptor);
        } catch (InvocationTargetException e) {
            e = e;
            G.s("Failed to retrieve fd from socket (" + fileDescriptor + ")", e);
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve fd from socket: ");
            sb.append(fileDescriptor);
            Log.d("Openvpn", sb.toString());
        } catch (NullPointerException e2) {
            e = e2;
            G.s("Failed to retrieve fd from socket (" + fileDescriptor + ")", e);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to retrieve fd from socket: ");
            sb2.append(fileDescriptor);
            Log.d("Openvpn", sb2.toString());
        } catch (IllegalArgumentException e3) {
            e = e3;
            G.s("Failed to retrieve fd from socket (" + fileDescriptor + ")", e);
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Failed to retrieve fd from socket: ");
            sb22.append(fileDescriptor);
            Log.d("Openvpn", sb22.toString());
        } catch (NoSuchMethodException e4) {
            e = e4;
            G.s("Failed to retrieve fd from socket (" + fileDescriptor + ")", e);
            StringBuilder sb222 = new StringBuilder();
            sb222.append("Failed to retrieve fd from socket: ");
            sb222.append(fileDescriptor);
            Log.d("Openvpn", sb222.toString());
        } catch (IllegalAccessException e5) {
            e = e5;
            G.s("Failed to retrieve fd from socket (" + fileDescriptor + ")", e);
            StringBuilder sb2222 = new StringBuilder();
            sb2222.append("Failed to retrieve fd from socket: ");
            sb2222.append(fileDescriptor);
            Log.d("Openvpn", sb2222.toString());
        }
    }

    public void C() {
        if (this.h) {
            D();
        }
    }

    public final void D() {
        this.a.removeCallbacks(this.n);
        if (System.currentTimeMillis() - this.i < 5000) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException unused) {
            }
        }
        this.h = false;
        this.i = System.currentTimeMillis();
        o("hold release\n");
        o("bytecount 2\n");
        o("state on\n");
    }

    public final void E(d.a aVar, String str, String str2, boolean z) {
        String str3;
        if (aVar == d.a.NONE || str == null) {
            str3 = "proxy NONE\n";
        } else {
            G.t(a7.j.v8, str, str);
            str3 = String.format(Locale.ENGLISH, "proxy %s %s %s%s\n", new Object[]{aVar == d.a.HTTP ? "HTTP" : "SOCKS", str, str2, z ? " auto" : ""});
        }
        o(str3);
    }

    public final boolean F(String str, String str2) {
        if (!str2.equals("tun")) {
            G.p(String.format("Device type %s requested, but only tun is possible with the Android API, sorry!", new Object[]{str2}));
            return false;
        }
        ParcelFileDescriptor E1 = this.e.E1();
        if (E1 == null) {
            return false;
        }
        int fd = E1.getFd();
        try {
            Method declaredMethod = FileDescriptor.class.getDeclaredMethod("setInt$", new Class[]{Integer.TYPE});
            FileDescriptor fileDescriptor = new FileDescriptor();
            declaredMethod.invoke(fileDescriptor, new Object[]{Integer.valueOf(fd)});
            this.c.setFileDescriptorsForSend(new FileDescriptor[]{fileDescriptor});
            o(String.format("needok '%s' %s\n", new Object[]{str, "ok"}));
            this.c.setFileDescriptorsForSend((FileDescriptor[]) null);
            E1.close();
            return true;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | IOException | IllegalArgumentException e) {
            G.s("Could not send fd over socket", e);
            return false;
        }
    }

    public boolean G() {
        n.a aVar = this.l;
        if (aVar == null) {
            return false;
        }
        return aVar.a();
    }

    public void H() {
        this.a.removeCallbacks(this.n);
        if (this.h) {
            G.H(this.k);
        } else {
            o("signal SIGUSR1\n");
        }
    }

    public boolean a(boolean z) {
        boolean I = I();
        if (I) {
            this.m = true;
        }
        return I;
    }

    public void b(n.b bVar) {
        this.k = bVar;
        H();
    }

    public void c(String str) {
        o("cr-response " + str + "\n");
    }

    public void d(boolean z) {
        if (this.h) {
            C();
        } else {
            o(z ? "network-change samenetwork\n" : "network-change\n");
        }
    }

    public void e(n.a aVar) {
        this.l = aVar;
    }

    public final void l(FileDescriptor fileDescriptor) {
        try {
            Os.close(fileDescriptor);
        } catch (Exception e) {
            G.s("Failed to close fd (" + fileDescriptor + ")", e);
        }
    }

    public final void m(String str) {
        this.h = true;
        int parseInt = Integer.parseInt(str.split(":")[1]);
        if (!G()) {
            G.H(this.k);
            return;
        }
        if (parseInt > 1) {
            G.J("CONNECTRETRY", String.valueOf(parseInt), a7.j.K7, e.LEVEL_CONNECTING_NO_SERVER_REPLY_YET);
        }
        this.a.postDelayed(this.n, parseInt * 1000);
        if (parseInt > 5) {
            G.t(a7.j.K7, String.valueOf(parseInt));
        } else {
            G.l(a7.j.K7, String.valueOf(parseInt));
        }
    }

    public final /* synthetic */ void n() {
        if (G()) {
            D();
        }
    }

    public boolean o(String str) {
        try {
            LocalSocket localSocket = this.c;
            if (localSocket == null || localSocket.getOutputStream() == null) {
                return false;
            }
            this.c.getOutputStream().write(str.getBytes());
            this.c.getOutputStream().flush();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean p(Context context) {
        String str = context.getCacheDir().getAbsolutePath() + "/mgmtsocket";
        this.j = new LocalSocket();
        for (int i = 8; i > 0 && !this.j.isBound(); i--) {
            try {
                this.j.bind(new LocalSocketAddress(str, LocalSocketAddress.Namespace.FILESYSTEM));
            } catch (IOException unused) {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException unused2) {
                }
            }
        }
        try {
            this.g = new LocalServerSocket(this.j.getFileDescriptor());
            return true;
        } catch (IOException e) {
            G.r(e);
            return false;
        }
    }

    public final void q(String str, String str2) {
        G.J("AUTH_FAILED", str + str2, a7.j.r7, e.LEVEL_AUTH_FAILED);
    }

    public final void r(String str) {
        int indexOf = str.indexOf(44);
        G.G(Long.parseLong(str.substring(0, indexOf)), Long.parseLong(str.substring(indexOf + 1)));
    }

    public void resume() {
        C();
        this.k = n.b.noNetwork;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r7 = this;
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]
            java.lang.String r1 = ""
            java.util.Vector r2 = de.blinkt.openvpn.core.y.r
            monitor-enter(r2)
            r2.add(r7)     // Catch: java.lang.Throwable -> La7
            monitor-exit(r2)     // Catch: java.lang.Throwable -> La7
            android.net.LocalServerSocket r2 = r7.g     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            android.net.LocalSocket r2 = r2.accept()     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            r7.c = r2     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            android.net.LocalServerSocket r3 = r7.g     // Catch: java.lang.Exception -> L1f java.io.IOException -> L21
            r3.close()     // Catch: java.lang.Exception -> L1f java.io.IOException -> L21
            goto L25
        L1f:
            r0 = move-exception
            goto L66
        L21:
            r3 = move-exception
            de.blinkt.openvpn.core.G.r(r3)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
        L25:
            java.lang.String r3 = "version 3\n"
            r7.o(r3)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
        L2a:
            int r3 = r2.read(r0)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            r4 = -1
            if (r3 != r4) goto L32
            return
        L32:
            android.net.LocalSocket r4 = r7.c     // Catch: java.lang.Exception -> L1f java.io.IOException -> L39
            java.io.FileDescriptor[] r4 = r4.getAncillaryFileDescriptors()     // Catch: java.lang.Exception -> L1f java.io.IOException -> L39
            goto L40
        L39:
            r4 = move-exception
            java.lang.String r5 = "Error reading fds from socket"
            de.blinkt.openvpn.core.G.s(r5, r4)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            r4 = 0
        L40:
            if (r4 == 0) goto L4a
            java.util.LinkedList r5 = r7.f     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            java.util.Collections.addAll(r5, r4)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            goto L4a
        L48:
            r0 = move-exception
            goto L81
        L4a:
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            java.lang.String r5 = "UTF-8"
            r6 = 0
            r4.<init>(r0, r6, r3, r5)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            r3.<init>()     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            r3.append(r1)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            r3.append(r4)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            java.lang.String r1 = r7.u(r1)     // Catch: java.lang.Exception -> L1f java.io.IOException -> L48
            goto L2a
        L66:
            java.lang.String r1 = "openvpn"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "exception:"
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r1, r0)
            goto L9c
        L81:
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "socket closed"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L9c
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "Connection reset by peer"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L9c
            de.blinkt.openvpn.core.G.r(r0)
        L9c:
            java.util.Vector r0 = de.blinkt.openvpn.core.y.r
            monitor-enter(r0)
            r0.remove(r7)     // Catch: java.lang.Throwable -> La4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La4
            return
        La4:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La4
            throw r1
        La7:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> La7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.y.run():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.y.s(java.lang.String):void");
    }

    public final void t(String str) {
        if (str.startsWith("OPEN_URL:") || str.startsWith("CR_TEXT:") || str.startsWith("WEB_AUTH:")) {
            this.e.S1(str);
            return;
        }
        G.m("Info message from server:" + str);
    }

    public final String u(String str) {
        while (str.contains("\n")) {
            String[] split = str.split("\\r?\\n", 2);
            s(split[0]);
            str = split.length == 1 ? "" : split[1];
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:3:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 3
            r1 = 2
            java.lang.String r2 = ","
            r3 = 4
            java.lang.String[] r2 = r8.split(r2, r3)
            java.lang.String r4 = "OpenVPN"
            android.util.Log.d(r4, r8)
            r8 = 1
            r4 = r2[r8]
            r4.hashCode()
            r5 = -1
            int r6 = r4.hashCode()
            switch(r6) {
                case 68: goto L3d;
                case 70: goto L34;
                case 73: goto L29;
                case 87: goto L1e;
                default: goto L1c;
            }
        L1c:
            r8 = -1
            goto L47
        L1e:
            java.lang.String r8 = "W"
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L27
            goto L1c
        L27:
            r8 = 3
            goto L47
        L29:
            java.lang.String r8 = "I"
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L32
            goto L1c
        L32:
            r8 = 2
            goto L47
        L34:
            java.lang.String r6 = "F"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L47
            goto L1c
        L3d:
            java.lang.String r8 = "D"
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L46
            goto L1c
        L46:
            r8 = 0
        L47:
            switch(r8) {
                case 0: goto L53;
                case 1: goto L50;
                case 2: goto L4a;
                case 3: goto L4d;
                default: goto L4a;
            }
        L4a:
            de.blinkt.openvpn.core.G$c r8 = de.blinkt.openvpn.core.G.c.INFO
            goto L55
        L4d:
            de.blinkt.openvpn.core.G$c r8 = de.blinkt.openvpn.core.G.c.WARNING
            goto L55
        L50:
            de.blinkt.openvpn.core.G$c r8 = de.blinkt.openvpn.core.G.c.ERROR
            goto L55
        L53:
            de.blinkt.openvpn.core.G$c r8 = de.blinkt.openvpn.core.G.c.VERBOSE
        L55:
            r1 = r2[r1]
            int r1 = java.lang.Integer.parseInt(r1)
            r1 = r1 & 15
            r0 = r2[r0]
            java.lang.String r2 = "MANAGEMENT: CMD"
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L6b
            int r1 = java.lang.Math.max(r3, r1)
        L6b:
            de.blinkt.openvpn.core.G.x(r8, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.y.v(java.lang.String):void");
    }

    public final void w(String str) {
        String substring;
        String str2;
        String str3;
        String str4;
        int indexOf = str.indexOf(39) + 1;
        substring = str.substring(indexOf, str.indexOf(39, indexOf));
        str2 = str.split(":", 2)[1];
        substring.hashCode();
        switch (substring) {
            case "PROTECTFD":
                B((FileDescriptor) this.f.pollFirst());
                str4 = "ok";
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            case "IFCONFIG":
                String[] split = str2.split(" ");
                this.e.M1(split[0], split[1], Integer.parseInt(split[2]), split[3]);
                str4 = "ok";
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            case "ROUTE6":
                String[] split2 = str2.split(" ");
                this.e.m1(split2[0], split2[1]);
                str4 = "ok";
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            case "DNSDOMAIN":
                this.e.K1(str2);
                str4 = "ok";
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            case "HTTPPROXY":
                String[] split3 = str2.split(" ");
                if (split3.length == 2) {
                    this.e.i1(split3[0], Integer.parseInt(split3[1]));
                    str4 = "ok";
                    o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                    break;
                } else {
                    str3 = "Unrecognized HTTPPROXY cmd: " + Arrays.toString(split3) + " | " + str;
                    G.p(str3);
                    str4 = "ok";
                    o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                }
            case "DNSSERVER":
            case "DNS6SERVER":
                this.e.h1(str2);
                str4 = "ok";
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            case "OPENTUN":
                if (!F(substring, str2)) {
                    str4 = "cancel";
                    o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                    break;
                }
                break;
            case "ROUTE":
                String[] split4 = str2.split(" ");
                if (split4.length == 5) {
                    this.e.l1(split4[0], split4[1], split4[2], split4[4]);
                } else if (split4.length >= 3) {
                    this.e.l1(split4[0], split4[1], split4[2], null);
                } else {
                    str3 = "Unrecognized ROUTE cmd:" + Arrays.toString(split4) + " | " + str;
                    G.p(str3);
                }
                str4 = "ok";
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            case "IFCONFIG6":
                String[] split5 = str2.split(" ");
                this.e.O1(Integer.parseInt(split5[1]));
                this.e.N1(split5[0]);
                str4 = "ok";
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            case "PERSIST_TUN_ACTION":
                str4 = this.e.x1();
                o(String.format("needok '%s' %s\n", new Object[]{substring, str4}));
                break;
            default:
                Log.e("openvpn", "Unknown needok command " + str);
                break;
        }
    }

    public final void x(String str) {
        String str2;
        d dVar;
        try {
            if (str.startsWith("Auth-Token:")) {
                return;
            }
            int indexOf = str.indexOf(39) + 1;
            int indexOf2 = str.indexOf(39, indexOf);
            String substring = str.substring(indexOf, indexOf2);
            if (str.startsWith("Verification Failed")) {
                q(substring, str.substring(indexOf2 + 1));
                return;
            }
            String str3 = null;
            if (substring.equals("Private Key")) {
                str3 = this.d.w();
                str2 = null;
            } else if (substring.equals("Auth")) {
                str3 = this.d.v();
                str2 = this.d.B;
            } else if (!substring.equals("HTTP Proxy") || (dVar = this.q) == null) {
                str2 = null;
            } else {
                str3 = dVar.n;
                str2 = dVar.m;
            }
            if (str3 == null) {
                this.e.H1(a7.j.X4, substring);
                G.p(String.format("Openvpn requires Authentication type '%s' but no password/key information available", new Object[]{substring}));
            } else {
                if (str2 != null) {
                    o(String.format("username '%s' %s\n", new Object[]{substring, f8.l.I(str2)}));
                }
                o(String.format("password '%s' %s\n", new Object[]{substring, f8.l.I(str3)}));
            }
        } catch (StringIndexOutOfBoundsException unused) {
            G.p("Could not parse management Password command: " + str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ","
            r1 = 3
            java.lang.String[] r10 = r10.split(r0, r1)
            de.blinkt.openvpn.core.d$a r0 = de.blinkt.openvpn.core.d.a.NONE
            r1 = 0
            r2 = r10[r1]
            int r2 = java.lang.Integer.parseInt(r2)
            r3 = 1
            int r2 = r2 - r3
            f8.l r4 = r9.d
            de.blinkt.openvpn.core.d[] r4 = r4.Y
            int r5 = r4.length
            r6 = 0
            if (r5 <= r2) goto L27
            r2 = r4[r2]
            de.blinkt.openvpn.core.d$a r4 = r2.i
            java.lang.String r5 = r2.j
            java.lang.String r7 = r2.k
            boolean r8 = r2.l
            r9.q = r2
            goto L3e
        L27:
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r1] = r2
            java.lang.String r2 = "OpenVPN is asking for a proxy of an unknown connection entry (%d)"
            java.lang.String r2 = java.lang.String.format(r4, r2, r5)
            de.blinkt.openvpn.core.G.p(r2)
            r4 = r0
            r5 = r6
            r7 = r5
            r8 = 0
        L3e:
            if (r4 != r0) goto L5b
            f8.l r0 = r9.d
            java.net.SocketAddress r0 = de.blinkt.openvpn.core.D.a(r0)
            boolean r2 = r0 instanceof java.net.InetSocketAddress
            if (r2 == 0) goto L5b
            java.net.InetSocketAddress r0 = (java.net.InetSocketAddress) r0
            de.blinkt.openvpn.core.d$a r4 = de.blinkt.openvpn.core.d.a.HTTP
            java.lang.String r5 = r0.getHostName()
            int r0 = r0.getPort()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            goto L5c
        L5b:
            r1 = r8
        L5c:
            int r0 = r10.length
            r2 = 2
            if (r0 < r2) goto L74
            de.blinkt.openvpn.core.d$a r0 = de.blinkt.openvpn.core.d.a.HTTP
            if (r4 != r0) goto L74
            r10 = r10[r3]
            java.lang.String r0 = "UDP"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L74
            java.lang.String r10 = "Not using an HTTP proxy since the connection uses UDP"
            de.blinkt.openvpn.core.G.u(r10)
            goto L75
        L74:
            r6 = r5
        L75:
            de.blinkt.openvpn.core.d$a r10 = de.blinkt.openvpn.core.d.a.ORBOT
            if (r4 != r10) goto Lab
            int r10 = a7.j.L7
            de.blinkt.openvpn.core.e r0 = de.blinkt.openvpn.core.e.LEVEL_CONNECTING_NO_SERVER_REPLY_YET
            java.lang.String r1 = "WAIT_ORBOT"
            java.lang.String r2 = "Waiting for Orbot to start"
            de.blinkt.openvpn.core.G.J(r1, r2, r10, r0)
            de.blinkt.openvpn.core.OpenVPNService r10 = r9.e
            de.blinkt.openvpn.core.z r10 = de.blinkt.openvpn.core.z.d(r10)
            de.blinkt.openvpn.core.OpenVPNService r0 = r9.e
            boolean r0 = de.blinkt.openvpn.core.z.c(r0)
            if (r0 != 0) goto L97
            java.lang.String r0 = "Orbot does not seem to be installed!"
            de.blinkt.openvpn.core.G.p(r0)
        L97:
            android.os.Handler r0 = r9.a
            java.lang.Runnable r1 = r9.o
            r2 = 20000(0x4e20, double:9.8813E-320)
            r0.postDelayed(r1, r2)
            de.blinkt.openvpn.core.OpenVPNService r0 = r9.e
            de.blinkt.openvpn.core.z$b r1 = r9.p
            r10.b(r0, r1)
            r10.g()
            goto Lae
        Lab:
            r9.E(r4, r6, r7, r1)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.y.y(java.lang.String):void");
    }

    public final void z(String str) {
        String[] split = str.split(",");
        String y = this.d.y(this.e, split[0], split[1].equals("RSA_PKCS1_PADDING"));
        o("pk-sig\n");
        if (y == null) {
            o("\nEND\n");
            I();
        } else {
            o(y);
            o("\nEND\n");
        }
    }
}
