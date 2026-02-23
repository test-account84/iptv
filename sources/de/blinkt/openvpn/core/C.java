package de.blinkt.openvpn.core;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import de.blinkt.openvpn.core.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c {
    public Context a;
    public final String[] e;
    public HashSet f;
    public String i;
    public final String[] b = {"config", "tls-server"};
    public final String[] c = {"tls-client", "allow-recursive-routing", "askpass", "auth-nocache", "up", "down", "route-up", "ipchange", "route-pre-down", "auth-user-pass-verify", "block-outside-dns", "client-cert-not-required", "dhcp-release", "dhcp-renew", "dh", "group", "ip-win32", "ifconfig-nowarn", "management-hold", "management", "management-client", "management-query-remote", "management-query-passwords", "management-query-proxy", "management-external-key", "management-forget-disconnect", "management-signal", "management-log-cache", "management-up-down", "management-client-user", "management-client-group", "pause-exit", "preresolve", "plugin", "machine-readable-output", "persist-key", "push", "register-dns", "route-delay", "route-gateway", "route-metric", "route-method", "status", "script-security", "show-net-up", "suppress-timestamps", "tap-sleep", "tmp-dir", "tun-ipv6", "topology", "user", "win-sys"};
    public final String[][] d = {new String[]{"setenv", "IV_GUI_VER"}, new String[]{"setenv", "IV_SSO"}, new String[]{"setenv", "IV_PLAT_VER"}, new String[]{"setenv", "IV_OPENVPN_GUI_VERSION"}, new String[]{"engine", "dynamic"}, new String[]{"setenv", "CLIENT_CERT"}, new String[]{"resolv-retry", "60"}};
    public HashMap g = new HashMap();
    public HashMap h = new HashMap();

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public enum b {
        initial,
        readin_single_quote,
        reading_quoted,
        reading_unquoted,
        done
    }

    public c() {
        String[] strArr = {"local", "remote", "float", "port", "connect-retry", "connect-timeout", "connect-retry-max", "link-mtu", "tun-mtu", "tun-mtu-extra", "fragment", "mtu-disc", "local-port", "remote-port", "bind", "nobind", "proto", "http-proxy", "http-proxy-retry", "http-proxy-timeout", "http-proxy-option", "socks-proxy", "socks-proxy-retry", "http-proxy-user-pass", "explicit-exit-notify"};
        this.e = strArr;
        this.f = new HashSet(Arrays.asList(strArr));
    }

    public static void u(d dVar, String str) {
        String[] split = f8.l.l(str).split("\n");
        if (split.length >= 2) {
            dVar.m = split[0];
            dVar.n = split[1];
            dVar.l = true;
        }
    }

    public static void v(f8.l lVar, String str) {
        String[] split = f8.l.l(str).split("\n");
        if (split.length >= 2) {
            lVar.B = split[0];
            lVar.A = split[1];
        }
    }

    public final void a(String str, Vector vector) {
        String trim = ((String) vector.get(0)).trim();
        String trim2 = ((String) vector.get(1)).trim();
        File file = new File(str);
        try {
            if (file.exists()) {
                trim.substring(1, trim.length() - 1);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String str2 = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = (str2 + readLine) + "\n";
                }
                if (str2.endsWith("\n")) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
                vector.clear();
                vector.add("ca");
                vector.add("[[NAME]]" + trim2 + "[[INLINE]]" + str2);
            }
        } catch (Exception e) {
            Log.d("", "" + e);
        }
    }

    public final void b(f8.l lVar) {
        boolean z = false;
        for (String str : this.b) {
            if (this.g.containsKey(str)) {
                throw new a(String.format("Unsupported Option %s encountered in config file. Aborting", new Object[]{str}));
            }
        }
        for (String str2 : this.c) {
            this.g.remove(str2);
        }
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Vector) it.next()).iterator();
            while (it2.hasNext()) {
                if (!k((Vector) it2.next())) {
                    z = true;
                }
            }
        }
        if (z) {
            lVar.G = "# These options found in the config file do not map to config settings:\n" + lVar.G;
            Iterator it3 = this.g.values().iterator();
            while (it3.hasNext()) {
                lVar.G += j((Vector) it3.next());
            }
            lVar.F = true;
        }
    }

    public final void c(f8.l lVar, Vector vector, boolean z) {
        boolean z2 = false;
        if (z) {
            Iterator it = vector.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                Vector vector2 = (Vector) it.next();
                for (int i = 1; i < vector2.size(); i++) {
                    if (((String) vector2.get(i)).equals("block-local")) {
                        lVar.V = false;
                    } else if (((String) vector2.get(i)).equals("unblock-local")) {
                        lVar.V = true;
                    } else if (((String) vector2.get(i)).equals("!ipv4")) {
                        z3 = true;
                    } else if (((String) vector2.get(i)).equals("ipv6")) {
                        lVar.K = true;
                    }
                }
            }
            z2 = z3;
        }
        if (!z || z2) {
            return;
        }
        lVar.u = true;
    }

    public final void d(Vector vector, BufferedReader bufferedReader) {
        String trim = ((String) vector.get(0)).trim();
        if (!trim.startsWith("<") || !trim.endsWith(">")) {
            return;
        }
        String substring = trim.substring(1, trim.length() - 1);
        String format = String.format("</%s>", new Object[]{substring});
        String str = "[[INLINE]]";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                throw new a(String.format("No endtag </%s> for starttag <%s> found", new Object[]{substring, substring}));
            }
            if (readLine.trim().equals(format)) {
                if (str.endsWith("\n")) {
                    str = str.substring(0, str.length() - 1);
                }
                vector.clear();
                vector.add(substring);
                vector.add(str);
                return;
            }
            str = (str + readLine) + "\n";
        }
    }

    public final void e(Vector vector, BufferedReader bufferedReader, String str, String str2) {
        String trim = ((String) vector.get(0)).trim();
        if (!trim.startsWith("<") || !trim.endsWith(">")) {
            if (trim.equals("ca")) {
                String trim2 = ((String) vector.get(1)).trim();
                a(trim2 != null ? str.replaceAll(str2, trim2) : "", vector);
                return;
            }
            return;
        }
        String substring = trim.substring(1, trim.length() - 1);
        String format = String.format("</%s>", new Object[]{substring});
        String str3 = "[[INLINE]]";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                throw new a(String.format("No endtag </%s> for starttag <%s> found", new Object[]{substring, substring}));
            }
            if (readLine.trim().equals(format)) {
                if (str3.endsWith("\n")) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
                vector.clear();
                vector.add(substring);
                vector.add(str3);
                return;
            }
            str3 = (str3 + readLine) + "\n";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:198:0x049d A[PHI: r13
      0x049d: PHI (r13v9 int) = (r13v8 int), (r13v10 int) binds: [B:339:0x049b, B:197:0x0497] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f8.l f() {
        /*
            Method dump skipped, instructions count: 1911
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.c.f():f8.l");
    }

    public final void g(f8.l lVar) {
        if (lVar.z.equals(lVar.p0)) {
            lVar.z = "";
        }
    }

    public final Vector h(String str, int i, int i2) {
        Vector vector = (Vector) this.g.get(str);
        if (vector == null) {
            return null;
        }
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            Vector vector2 = (Vector) it.next();
            if (vector2.size() < i + 1 || vector2.size() > i2 + 1) {
                throw new a(String.format(Locale.getDefault(), "Option %s has %d parameters, expected between %d and %d", new Object[]{str, Integer.valueOf(vector2.size() - 1), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        }
        this.g.remove(str);
        return vector;
    }

    public final Vector i(String str, int i, int i2) {
        Vector h = h(str, i, i2);
        if (h == null) {
            return null;
        }
        return (Vector) h.lastElement();
    }

    public final String j(Vector vector) {
        Iterator it = vector.iterator();
        String str = "";
        while (it.hasNext()) {
            Vector vector2 = (Vector) it.next();
            if (!k(vector2)) {
                if (vector2.size() == 2 && "extra-certs".equals(vector2.get(0))) {
                    str = str + f8.l.D((String) vector2.get(0), (String) vector2.get(1));
                } else {
                    Iterator it2 = vector2.iterator();
                    while (it2.hasNext()) {
                        str = str + f8.l.I((String) it2.next()) + " ";
                    }
                    str = str + "\n";
                }
            }
        }
        return str;
    }

    public boolean k(Vector vector) {
        for (String[] strArr : this.d) {
            if (vector.size() >= strArr.length) {
                boolean z = true;
                for (int i = 0; i < strArr.length; i++) {
                    if (!strArr[i].equals(vector.get(i))) {
                        z = false;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean l(String str) {
        if (str.equals("udp") || str.equals("udp4") || str.equals("udp6")) {
            return true;
        }
        if (str.equals("tcp-client") || str.equals("tcp") || str.equals("tcp4") || str.endsWith("tcp4-client") || str.equals("tcp6") || str.endsWith("tcp6-client")) {
            return false;
        }
        throw new a("Unsupported option to --proto " + str);
    }

    public final String m(String str, Vector vector) {
        return Build.VERSION.SDK_INT > 26 ? de.blinkt.openvpn.core.b.a(str, vector) : TextUtils.join(str, vector);
    }

    public void n(Reader reader) {
        HashMap hashMap = new HashMap();
        hashMap.put("server-poll-timeout", "timeout-connect");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int i = 0;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                i++;
                if (readLine == null) {
                    return;
                }
                if (i == 1) {
                    if (readLine.startsWith("PK\u0003\u0004") || readLine.startsWith("PK\u0007\u00008")) {
                        break;
                    } else if (readLine.startsWith("\ufeff")) {
                        readLine = readLine.substring(1);
                    }
                }
                if (readLine.startsWith("# OVPN_ACCESS_SERVER_")) {
                    Vector s = s(readLine);
                    this.h.put((String) s.get(0), s);
                } else {
                    Vector r = r(readLine);
                    if (r.size() != 0) {
                        if (((String) r.get(0)).startsWith("--")) {
                            r.set(0, ((String) r.get(0)).substring(2));
                        }
                        d(r, bufferedReader);
                        String str = (String) r.get(0);
                        if (hashMap.get(str) != null) {
                            str = (String) hashMap.get(str);
                        }
                        if (!this.g.containsKey(str)) {
                            this.g.put(str, new Vector());
                        }
                        ((Vector) this.g.get(str)).add(r);
                    }
                }
            } catch (OutOfMemoryError e) {
                throw new a("File too large to parse: " + e.getLocalizedMessage());
            }
        }
        throw new a("Input looks like a ZIP Archive. Import is only possible for OpenVPN config files (.ovpn/.conf)");
    }

    public void o(Reader reader, String str, String str2, Context context) {
        this.a = context;
        HashMap hashMap = new HashMap();
        hashMap.put("server-poll-timeout", "timeout-connect");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int i = 0;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                i++;
                if (readLine == null) {
                    return;
                }
                if (i == 1) {
                    if (readLine.startsWith("PK\u0003\u0004") || readLine.startsWith("PK\u0007\u00008")) {
                        break;
                    } else if (readLine.startsWith("\ufeff")) {
                        readLine = readLine.substring(1);
                    }
                }
                if (readLine.startsWith("# OVPN_ACCESS_SERVER_")) {
                    Vector s = s(readLine);
                    this.h.put((String) s.get(0), s);
                } else {
                    Vector r = r(readLine);
                    if (r.size() != 0) {
                        if (((String) r.get(0)).startsWith("--")) {
                            r.set(0, ((String) r.get(0)).substring(2));
                        }
                        e(r, bufferedReader, str, str2);
                        String str3 = (String) r.get(0);
                        if (hashMap.get(str3) != null) {
                            str3 = (String) hashMap.get(str3);
                        }
                        if (!this.g.containsKey(str3)) {
                            this.g.put(str3, new Vector());
                        }
                        ((Vector) this.g.get(str3)).add(r);
                    }
                }
            } catch (OutOfMemoryError e) {
                throw new a("File too large to parse: " + e.getLocalizedMessage());
            }
        }
        throw new a("Input looks like a ZIP Archive. Import is only possible for OpenVPN config files (.ovpn/.conf)");
    }

    public final O.d p(String str, d dVar) {
        c cVar = new c();
        cVar.n(new StringReader(str.substring(10)));
        return cVar.q(dVar);
    }

    public final O.d q(d dVar) {
        d b2;
        int i = 0;
        if (dVar != null) {
            try {
                b2 = dVar.b();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            b2 = new d();
        }
        Vector i2 = i("port", 1, 1);
        if (i2 != null) {
            b2.c = (String) i2.get(1);
        }
        Vector i3 = i("rport", 1, 1);
        if (i3 != null) {
            b2.c = (String) i3.get(1);
        }
        Vector i4 = i("proto", 1, 1);
        if (i4 != null) {
            b2.d = l((String) i4.get(1));
        }
        Vector i5 = i("connect-timeout", 1, 1);
        if (i5 != null) {
            try {
                b2.h = Integer.parseInt((String) i5.get(1));
            } catch (NumberFormatException e2) {
                throw new a(String.format("Argument to connect-timeout (%s) must to be an integer: %s", new Object[]{i5.get(1), e2.getLocalizedMessage()}));
            }
        }
        Vector i6 = i("socks-proxy", 1, 2);
        if (i6 == null) {
            i6 = i("http-proxy", 2, 2);
        }
        if (i6 != null) {
            if (((String) i6.get(0)).equals("socks-proxy")) {
                b2.i = d.a.SOCKS5;
                b2.k = "1080";
            } else {
                b2.i = d.a.HTTP;
            }
            b2.j = (String) i6.get(1);
            if (i6.size() >= 3) {
                b2.k = (String) i6.get(2);
            }
        }
        Vector i7 = i("http-proxy-user-pass", 1, 1);
        if (i7 != null) {
            u(b2, (String) i7.get(1));
        }
        Vector h = h("remote", 1, 3);
        Vector vector = new Vector();
        for (Map.Entry entry : this.g.entrySet()) {
            if (dVar != null || this.f.contains(entry.getKey())) {
                b2.e += j((Vector) entry.getValue());
                vector.add((String) entry.getKey());
            }
        }
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            this.g.remove((String) it.next());
        }
        String str = b2.e;
        if (str != null && !"".equals(str.trim())) {
            b2.f = true;
        }
        if (h == null) {
            h = new Vector();
        }
        d[] dVarArr = new d[h.size()];
        Iterator it2 = h.iterator();
        while (it2.hasNext()) {
            Vector vector2 = (Vector) it2.next();
            try {
                dVarArr[i] = b2.b();
            } catch (CloneNotSupportedException e3) {
                e3.printStackTrace();
            }
            int size = vector2.size();
            if (size == 2) {
                dVarArr[i].a = (String) vector2.get(1);
            } else {
                if (size != 3) {
                    if (size == 4) {
                        dVarArr[i].d = l((String) vector2.get(3));
                    }
                }
                dVarArr[i].c = (String) vector2.get(2);
                dVarArr[i].a = (String) vector2.get(1);
            }
            i++;
        }
        return O.d.a(b2, dVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0056 A[PHI: r1
      0x0056: PHI (r1v7 de.blinkt.openvpn.core.c$b) = 
      (r1v2 de.blinkt.openvpn.core.c$b)
      (r1v2 de.blinkt.openvpn.core.c$b)
      (r1v2 de.blinkt.openvpn.core.c$b)
      (r1v2 de.blinkt.openvpn.core.c$b)
      (r1v2 de.blinkt.openvpn.core.c$b)
      (r1v10 de.blinkt.openvpn.core.c$b)
     binds: [B:66:0x0074, B:62:0x006b, B:63:0x006d, B:56:0x005c, B:58:0x0062, B:36:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Vector r(java.lang.String r15) {
        /*
            r14 = this;
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            int r1 = r15.length()
            if (r1 != 0) goto Lc
            return r0
        Lc:
            de.blinkt.openvpn.core.c$b r1 = de.blinkt.openvpn.core.c.b.initial
            java.lang.String r2 = ""
            r3 = 0
            r7 = r2
            r4 = 0
            r5 = 0
            r6 = 0
        L15:
            int r8 = r15.length()
            if (r4 >= r8) goto L20
            char r8 = r15.charAt(r4)
            goto L21
        L20:
            r8 = 0
        L21:
            r9 = 92
            if (r5 != 0) goto L2e
            if (r8 != r9) goto L2e
            de.blinkt.openvpn.core.c$b r10 = de.blinkt.openvpn.core.c.b.readin_single_quote
            if (r1 == r10) goto L2e
            r5 = 1
            goto L9b
        L2e:
            de.blinkt.openvpn.core.c$b r10 = de.blinkt.openvpn.core.c.b.initial
            r11 = 39
            r12 = 34
            if (r1 != r10) goto L58
            boolean r13 = r14.t(r8)
            if (r13 != 0) goto L77
            r1 = 59
            if (r8 == r1) goto Lb4
            r1 = 35
            if (r8 != r1) goto L46
            goto Lb4
        L46:
            if (r5 != 0) goto L4d
            if (r8 != r12) goto L4d
            de.blinkt.openvpn.core.c$b r1 = de.blinkt.openvpn.core.c.b.reading_quoted
            goto L77
        L4d:
            if (r5 != 0) goto L54
            if (r8 != r11) goto L54
            de.blinkt.openvpn.core.c$b r1 = de.blinkt.openvpn.core.c.b.readin_single_quote
            goto L77
        L54:
            de.blinkt.openvpn.core.c$b r1 = de.blinkt.openvpn.core.c.b.reading_unquoted
        L56:
            r6 = r8
            goto L77
        L58:
            de.blinkt.openvpn.core.c$b r13 = de.blinkt.openvpn.core.c.b.reading_unquoted
            if (r1 != r13) goto L67
            if (r5 != 0) goto L56
            boolean r11 = r14.t(r8)
            if (r11 == 0) goto L56
        L64:
            de.blinkt.openvpn.core.c$b r1 = de.blinkt.openvpn.core.c.b.done
            goto L77
        L67:
            de.blinkt.openvpn.core.c$b r13 = de.blinkt.openvpn.core.c.b.reading_quoted
            if (r1 != r13) goto L70
            if (r5 != 0) goto L56
            if (r8 != r12) goto L56
            goto L64
        L70:
            de.blinkt.openvpn.core.c$b r13 = de.blinkt.openvpn.core.c.b.readin_single_quote
            if (r1 != r13) goto L77
            if (r8 != r11) goto L56
            goto L64
        L77:
            de.blinkt.openvpn.core.c$b r8 = de.blinkt.openvpn.core.c.b.done
            if (r1 != r8) goto L81
            r0.add(r7)
            r7 = r2
            r6 = 0
            goto L82
        L81:
            r10 = r1
        L82:
            if (r5 == 0) goto L99
            if (r6 == 0) goto L99
            if (r6 == r9) goto L99
            if (r6 == r12) goto L99
            boolean r1 = r14.t(r6)
            if (r1 == 0) goto L91
            goto L99
        L91:
            de.blinkt.openvpn.core.c$a r15 = new de.blinkt.openvpn.core.c$a
            java.lang.String r0 = "Options warning: Bad backslash ('\\') usage"
            r15.<init>(r0)
            throw r15
        L99:
            r1 = r10
            r5 = 0
        L9b:
            if (r6 == 0) goto Lac
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r6)
            java.lang.String r7 = r8.toString()
        Lac:
            int r8 = r4 + 1
            int r9 = r15.length()
            if (r4 < r9) goto Lb5
        Lb4:
            return r0
        Lb5:
            r4 = r8
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.c.r(java.lang.String):java.util.Vector");
    }

    public final Vector s(String str) {
        String[] split = str.split("#\\sOVPN_ACCESS_SERVER_", 2)[1].split("=", 2);
        Vector vector = new Vector();
        Collections.addAll(vector, split);
        return vector;
    }

    public final boolean t(char c) {
        return Character.isWhitespace(c) || c == 0;
    }
}
