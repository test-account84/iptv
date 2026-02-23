package de.blinkt.openvpn.core;

import de.blinkt.openvpn.core.G;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class w implements Runnable {
    public static final Pattern j = Pattern.compile("(\\d+).(\\d+) ([0-9a-f])+ (.*)");
    public String[] a;
    public Process c;
    public String d;
    public String e;
    public OpenVPNService f;
    public String g;
    public boolean h = false;
    public boolean i = false;

    public w(OpenVPNService openVPNService, String[] strArr, String str, String str2) {
        this.a = strArr;
        this.d = str;
        this.e = str2;
        this.f = openVPNService;
    }

    public final String a(String[] strArr, ProcessBuilder processBuilder) {
        String str;
        String replaceFirst = strArr[0].replaceFirst("/cache/.*$", "/lib");
        String str2 = (String) processBuilder.environment().get("LD_LIBRARY_PATH");
        if (str2 == null) {
            str = replaceFirst;
        } else {
            str = replaceFirst + ":" + str2;
        }
        if (replaceFirst.equals(this.d)) {
            return str;
        }
        return this.d + ":" + str;
    }

    public void b() {
        this.i = true;
    }

    public final void c(String[] strArr) {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, strArr);
        ProcessBuilder processBuilder = new ProcessBuilder(linkedList);
        processBuilder.environment().put("LD_LIBRARY_PATH", a(strArr, processBuilder));
        processBuilder.environment().put("TMPDIR", this.e);
        processBuilder.redirectErrorStream(true);
        try {
            Process start = processBuilder.start();
            this.c = start;
            start.getOutputStream().close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.c.getInputStream()));
            do {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                if (readLine.startsWith("Dump path: ")) {
                    this.g = readLine.substring(11);
                }
                if (readLine.startsWith("/data/data/de.blinkt.openvpn/cache/pievpn") || readLine.contains("syntax error")) {
                    this.h = true;
                }
                Matcher matcher = j.matcher(readLine);
                if (matcher.matches()) {
                    int parseInt = Integer.parseInt(matcher.group(3), 16);
                    String group = matcher.group(4);
                    int i = parseInt & 15;
                    G.c cVar = G.c.INFO;
                    if ((parseInt & 16) != 0) {
                        cVar = G.c.ERROR;
                    } else if ((parseInt & 32) != 0 || (parseInt & 64) != 0) {
                        cVar = G.c.WARNING;
                    } else if ((parseInt & 128) != 0) {
                        cVar = G.c.VERBOSE;
                    }
                    if (group.startsWith("MANAGEMENT: CMD")) {
                        i = Math.max(4, i);
                    }
                    boolean z = (group.endsWith("md too weak") && group.startsWith("OpenSSL: error")) || group.contains("error:140AB18E");
                    G.x(cVar, i, group);
                    if (z) {
                        G.p("OpenSSL reported a certificate with a weak hash, please the in app FAQ about weak hashes");
                    }
                } else {
                    G.u("P:" + readLine);
                }
            } while (!Thread.interrupted());
            throw new InterruptedException("OpenVpn process was killed form java code");
        } catch (InterruptedException e) {
            e = e;
            G.s("Error reading from output of OpenVPN process", e);
            d();
        } catch (IOException e2) {
            e = e2;
            G.s("Error reading from output of OpenVPN process", e);
            d();
        }
    }

    public void d() {
        this.c.destroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024b A[Catch: InterruptedException -> 0x0250, IllegalThreadStateException -> 0x0252, TRY_LEAVE, TryCatch #10 {InterruptedException -> 0x0250, IllegalThreadStateException -> 0x0252, blocks: (B:89:0x0247, B:91:0x024b), top: B:88:0x0247 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 837
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.blinkt.openvpn.core.w.run():void");
    }
}
