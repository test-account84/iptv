package f8;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.security.KeyChain;
import android.security.KeyChainException;
import android.text.TextUtils;
import android.util.Base64;
import de.blinkt.openvpn.core.A;
import de.blinkt.openvpn.core.B;
import de.blinkt.openvpn.core.F;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.H;
import de.blinkt.openvpn.core.NativeUtils;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.d;
import de.blinkt.openvpn.core.z;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import java.util.Vector;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l implements Serializable, Cloneable {
    public static String A0 = "8.8.8.8";
    public static String B0 = "8.8.4.4";
    public boolean V;
    public String W;
    public de.blinkt.openvpn.core.d[] Y;
    public String d;
    public String e;
    public String f;
    public String h;
    public String h0;
    public String i;
    public String i0;
    public String j;
    public String j0;
    public String l;
    public int l0;
    public String m;
    public String q;
    public String r;
    public transient PrivateKey t0;
    public String w;
    public transient boolean a = false;
    public int c = 2;
    public String g = "";
    public boolean k = false;
    public boolean n = false;
    public String o = A0;
    public String p = B0;
    public boolean s = false;
    public String t = "blinkt.de";
    public boolean u = true;
    public boolean v = true;
    public boolean x = true;
    public boolean y = false;
    public String z = "";
    public String A = "";
    public String B = "";
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    public String G = "";
    public String H = "1";
    public String I = "";
    public boolean J = true;
    public boolean K = true;
    public String L = "";
    public String M = "";
    public boolean N = false;
    public String O = "-1";
    public String P = "2";
    public String Q = "300";
    public boolean R = true;
    public String S = "";
    public int T = 3;
    public String U = null;
    public int X = 0;
    public boolean Z = false;
    public HashSet e0 = new HashSet();
    public boolean f0 = true;
    public boolean g0 = false;
    public int k0 = 0;
    public boolean m0 = false;
    public int n0 = 0;
    public String p0 = "openvpn.example.com";
    public String q0 = "1194";
    public boolean r0 = true;
    public boolean s0 = false;
    public String w0 = "";
    public boolean x0 = true;
    public boolean y0 = false;
    public String z0 = "";
    public UUID u0 = UUID.randomUUID();
    public int v0 = 9;
    public long o0 = System.currentTimeMillis();

    public class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        public void run() {
            l.this.o(this.a);
        }
    }

    public static class b extends Exception {
        public b(String str) {
            super(str);
        }
    }

    public enum c {
        NO_PADDING,
        PKCS1_PADDING
    }

    public l(String str) {
        this.Y = new de.blinkt.openvpn.core.d[0];
        this.d = str;
        this.Y = new de.blinkt.openvpn.core.d[]{new de.blinkt.openvpn.core.d()};
    }

    public static String C(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            G.r(e);
            str = "unknown";
        }
        return String.format(Locale.US, "%s %s", new Object[]{context.getPackageName(), str});
    }

    public static String D(String str, String str2) {
        if (str2 == null) {
            return String.format("%s %s\n", new Object[]{str, "file missing in config profile"});
        }
        if (!E(str2)) {
            return String.format(Locale.ENGLISH, "%s %s\n", new Object[]{str, I(str2)});
        }
        return String.format(Locale.ENGLISH, "<%s>\n%s\n</%s>\n", new Object[]{str, l(str2), str});
    }

    public static boolean E(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("[[INLINE]]") || str.startsWith("[[NAME]]");
    }

    public static String I(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
        if (replace.equals(str) && !replace.contains(" ") && !replace.contains("#") && !replace.contains(";") && !replace.equals("")) {
            return str;
        }
        return '\"' + replace + '\"';
    }

    public static boolean h(Context context) {
        return B.a(context).getBoolean("ovpn3", false);
    }

    public static String l(String str) {
        return !str.contains("[[INLINE]]") ? str : str.substring(str.indexOf("[[INLINE]]") + 10);
    }

    public UUID A() {
        return this.u0;
    }

    public String B() {
        return this.u0.toString().toLowerCase(Locale.ENGLISH);
    }

    public boolean F() {
        int i = this.c;
        return i == 3 || i == 5 || i == 6 || i == 7;
    }

    public final void G() {
        this.Y = new de.blinkt.openvpn.core.d[1];
        de.blinkt.openvpn.core.d dVar = new de.blinkt.openvpn.core.d();
        dVar.a = this.p0;
        dVar.c = this.q0;
        dVar.d = this.r0;
        dVar.e = "";
        this.Y[0] = dVar;
    }

    public int H(String str, String str2) {
        String str3;
        int i = this.c;
        if ((i == 1 || i == 6) && (((str3 = this.m) == null || str3.equals("")) && str == null)) {
            return a7.j.f5;
        }
        int i2 = this.c;
        if ((i2 == 0 || i2 == 5) && K() && TextUtils.isEmpty(this.M) && str == null) {
            return a7.j.G5;
        }
        if (!F()) {
            return 0;
        }
        if (TextUtils.isEmpty(this.B) || (TextUtils.isEmpty(this.A) && str2 == null)) {
            return a7.j.X4;
        }
        return 0;
    }

    public Intent J(Context context) {
        return z(context);
    }

    public boolean K() {
        String str;
        if (TextUtils.isEmpty(this.i)) {
            return false;
        }
        if (E(this.i)) {
            str = this.i;
        } else {
            char[] cArr = new char[2048];
            try {
                FileReader fileReader = new FileReader(this.i);
                String str2 = "";
                for (int read = fileReader.read(cArr); read > 0; read = fileReader.read(cArr)) {
                    str2 = str2 + new String(cArr, 0, read);
                }
                fileReader.close();
                str = str2;
            } catch (FileNotFoundException | IOException unused) {
            }
        }
        return str.contains("Proc-Type: 4,ENCRYPTED") || str.contains("-----BEGIN ENCRYPTED PRIVATE KEY-----");
    }

    public void L() {
        switch (this.v0) {
            case 0:
            case 1:
                this.V = false;
            case 2:
            case 3:
                G();
                this.f0 = true;
                if (this.e0 == null) {
                    this.e0 = new HashSet();
                }
                if (this.Y == null) {
                    this.Y = new de.blinkt.openvpn.core.d[0];
                }
            case 4:
            case 5:
                if (TextUtils.isEmpty(this.i0)) {
                    this.R = true;
                }
            case 6:
                for (de.blinkt.openvpn.core.d dVar : this.Y) {
                    if (dVar.i == null) {
                        dVar.i = d.a.NONE;
                    }
                }
            case 7:
                boolean z = this.g0;
                if (z) {
                    this.x0 = !z;
                }
            case 8:
                if (!TextUtils.isEmpty(this.I) && !this.I.equals("AES-256-GCM") && !this.I.equals("AES-128-GCM")) {
                    this.w0 = "AES-256-GCM:AES-128-GCM:" + this.I;
                    break;
                }
                break;
        }
        this.v0 = 9;
    }

    public final boolean M() {
        String str;
        if (this.F && (str = this.G) != null && str.contains("http-proxy-option ")) {
            return true;
        }
        for (de.blinkt.openvpn.core.d dVar : this.Y) {
            if (dVar.e()) {
                return true;
            }
        }
        return false;
    }

    public void N(Context context) {
        FileWriter fileWriter = new FileWriter(F.b(context));
        fileWriter.write(i(context, false));
        fileWriter.flush();
        fileWriter.close();
    }

    public void b(Context context) {
        int i = this.c;
        if ((i == 2 || i == 7) && this.t0 == null) {
            new Thread(new a(context)).start();
        }
    }

    public int c(Context context) {
        return d(context, h(context));
    }

    public int d(Context context, boolean z) {
        String str;
        int i = this.c;
        if (i == 2 || i == 7 || i == 8) {
            if (this.e == null) {
                return a7.j.q4;
            }
        } else if ((i == 0 || i == 5) && TextUtils.isEmpty(this.j) && !this.y0) {
            return a7.j.e4;
        }
        if (this.x && this.T == 0) {
            return a7.j.N0;
        }
        if ((!this.v || this.c == 4) && ((str = this.q) == null || e(str) == null)) {
            return a7.j.L2;
        }
        if (!this.u) {
            if (!TextUtils.isEmpty(this.w) && j(this.w).size() == 0) {
                return a7.j.D0;
            }
            if (!TextUtils.isEmpty(this.W) && j(this.W).size() == 0) {
                return a7.j.D0;
            }
        }
        if (this.n && TextUtils.isEmpty(this.h)) {
            return a7.j.H3;
        }
        int i2 = this.c;
        if ((i2 == 5 || i2 == 0) && (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.i))) {
            return a7.j.G3;
        }
        int i3 = this.c;
        if ((i3 == 0 || i3 == 5) && TextUtils.isEmpty(this.j)) {
            return a7.j.F3;
        }
        boolean z2 = true;
        for (de.blinkt.openvpn.core.d dVar : this.Y) {
            if (dVar.g) {
                z2 = false;
            }
        }
        if (z2) {
            return a7.j.d6;
        }
        if (z) {
            int i4 = this.c;
            if (i4 == 4) {
                return a7.j.Q4;
            }
            if (i4 == 1 || i4 == 6) {
                return a7.j.R4;
            }
            for (de.blinkt.openvpn.core.d dVar2 : this.Y) {
                d.a aVar = dVar2.i;
                if (aVar == d.a.ORBOT || aVar == d.a.SOCKS5) {
                    return a7.j.S4;
                }
            }
        }
        for (de.blinkt.openvpn.core.d dVar3 : this.Y) {
            if (dVar3.i == d.a.ORBOT) {
                if (M()) {
                    return a7.j.Q1;
                }
                if (!z.c(context)) {
                    return a7.j.u4;
                }
            }
        }
        return a7.j.j4;
    }

    public final String e(String str) {
        String[] split = str.split("/");
        if (split.length == 1) {
            split = (str + "/32").split("/");
        }
        if (split.length != 2) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(split[1]);
            if (parseInt >= 0 && parseInt <= 32) {
                long j = 4294967295 << (32 - parseInt);
                return split[0] + "  " + String.format(Locale.ENGLISH, "%d.%d.%d.%d", new Object[]{Long.valueOf((4278190080L & j) >> 24), Long.valueOf((16711680 & j) >> 16), Long.valueOf((65280 & j) >> 8), Long.valueOf(j & 255)});
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.u0.equals(((l) obj).u0);
        }
        return false;
    }

    public void f() {
        this.p0 = "unknown";
        this.v = false;
        this.k = false;
        this.u = false;
        this.K = false;
        this.y = false;
        this.x = false;
        this.N = false;
        this.V = true;
        this.m0 = false;
        this.X = 0;
        this.J = false;
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public l clone() {
        l lVar = (l) super.clone();
        lVar.u0 = UUID.randomUUID();
        lVar.Y = new de.blinkt.openvpn.core.d[this.Y.length];
        de.blinkt.openvpn.core.d[] dVarArr = this.Y;
        int length = dVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            lVar.Y[i2] = dVarArr[i].clone();
            i++;
            i2++;
        }
        lVar.e0 = (HashSet) this.e0.clone();
        return lVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0405  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String i(android.content.Context r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 1486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.l.i(android.content.Context, boolean):java.lang.String");
    }

    public final Collection j(String str) {
        Vector vector = new Vector();
        if (str == null) {
            return vector;
        }
        for (String str2 : str.split("[\n \t]")) {
            if (!str2.equals("")) {
                String e = e(str2);
                if (e == null) {
                    return vector;
                }
                vector.add(e);
            }
        }
        return vector;
    }

    public final Collection k(String str) {
        Vector vector = new Vector();
        if (str == null) {
            return vector;
        }
        for (String str2 : str.split("[\n \t]")) {
            if (!str2.equals("")) {
                vector.add(str2);
            }
        }
        return vector;
    }

    public final X509Certificate[] m(Context context) {
        String str;
        String str2 = this.j0;
        if (str2 == null || (str = this.e) == null) {
            throw new KeyChainException("Alias or external auth provider name not set");
        }
        return de.blinkt.openvpn.core.g.c(context, str2, str);
    }

    public final byte[] n(Context context, byte[] bArr, Bundle bundle) {
        if (TextUtils.isEmpty(this.j0)) {
            return null;
        }
        try {
            return de.blinkt.openvpn.core.g.d(context, this.j0, this.e, bArr, bundle);
        } catch (InterruptedException | KeyChainException e) {
            G.o(a7.j.L1, this.j0, e.getClass().toString(), e.getLocalizedMessage());
            return null;
        }
    }

    public String[] o(Context context) {
        return p(context, 5);
    }

    public synchronized String[] p(Context context, int i) {
        String stringWriter;
        String stringWriter2;
        String str;
        try {
            Context applicationContext = context.getApplicationContext();
            try {
                try {
                    X509Certificate[] m = this.c == 8 ? m(applicationContext) : s(applicationContext);
                    if (m == null) {
                        throw new b("No certificate returned from Keystore");
                    }
                    if (m.length > 1 || !TextUtils.isEmpty(this.j)) {
                        StringWriter stringWriter3 = new StringWriter();
                        PemWriter pemWriter = new PemWriter(stringWriter3);
                        for (int i2 = 1; i2 < m.length; i2++) {
                            pemWriter.writeObject(new PemObject("CERTIFICATE", m[i2].getEncoded()));
                        }
                        pemWriter.close();
                        stringWriter = stringWriter3.toString();
                    } else {
                        G.w(G.c.ERROR, "", applicationContext.getString(a7.j.Q2));
                        stringWriter = null;
                    }
                    if (TextUtils.isEmpty(this.j)) {
                        stringWriter2 = null;
                    } else {
                        try {
                            Certificate[] a2 = H.a(this.j);
                            StringWriter stringWriter4 = new StringWriter();
                            PemWriter pemWriter2 = new PemWriter(stringWriter4);
                            for (Certificate certificate : a2) {
                                pemWriter2.writeObject(new PemObject("CERTIFICATE", certificate.getEncoded()));
                            }
                            pemWriter2.close();
                            stringWriter2 = stringWriter4.toString();
                        } catch (Exception e) {
                            G.p("Could not read CA certificate" + e.getLocalizedMessage());
                        }
                    }
                    StringWriter stringWriter5 = new StringWriter();
                    if (m.length >= 1) {
                        X509Certificate x509Certificate = m[0];
                        PemWriter pemWriter3 = new PemWriter(stringWriter5);
                        pemWriter3.writeObject(new PemObject("CERTIFICATE", x509Certificate.getEncoded()));
                        pemWriter3.close();
                    }
                    String stringWriter6 = stringWriter5.toString();
                    if (stringWriter2 == null) {
                        str = null;
                    } else {
                        String str2 = stringWriter;
                        stringWriter = stringWriter2;
                        str = str2;
                    }
                    return new String[]{stringWriter, str, stringWriter6};
                } catch (AssertionError e2) {
                    if (i == 0) {
                        return null;
                    }
                    G.p(String.format("Failure getting Keystore Keys (%s), retrying", new Object[]{e2.getLocalizedMessage()}));
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e3) {
                        G.r(e3);
                    }
                    return p(applicationContext, i - 1);
                }
            } catch (KeyChainException e4) {
                e = e4;
                e.printStackTrace();
                G.o(a7.j.O2, e.getLocalizedMessage());
                G.n(a7.j.P2);
                return null;
            } catch (InterruptedException e5) {
                e = e5;
                e.printStackTrace();
                G.o(a7.j.O2, e.getLocalizedMessage());
                G.n(a7.j.P2);
                return null;
            } catch (b e6) {
                e = e6;
                e.printStackTrace();
                G.o(a7.j.O2, e.getLocalizedMessage());
                G.n(a7.j.P2);
                return null;
            } catch (IOException e7) {
                e = e7;
                e.printStackTrace();
                G.o(a7.j.O2, e.getLocalizedMessage());
                G.n(a7.j.P2);
                return null;
            } catch (IllegalArgumentException e8) {
                e = e8;
                e.printStackTrace();
                G.o(a7.j.O2, e.getLocalizedMessage());
                G.n(a7.j.P2);
                return null;
            } catch (CertificateException e9) {
                e = e9;
                e.printStackTrace();
                G.o(a7.j.O2, e.getLocalizedMessage());
                G.n(a7.j.P2);
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final byte[] q(byte[] bArr, boolean z) {
        PrivateKey t = t();
        try {
            if (!t.getAlgorithm().equals("EC")) {
                Cipher cipher = Cipher.getInstance(z ? "RSA/ECB/PKCS1PADDING" : "RSA/ECB/NoPadding");
                cipher.init(1, t);
                return cipher.doFinal(bArr);
            }
            Signature signature = Signature.getInstance("NONEwithECDSA");
            signature.initSign(t);
            signature.update(bArr);
            return signature.sign();
        } catch (NoSuchAlgorithmException e) {
            e = e;
            G.o(a7.j.S1, e.getClass().toString(), e.getLocalizedMessage());
            return null;
        } catch (IllegalBlockSizeException e2) {
            e = e2;
            G.o(a7.j.S1, e.getClass().toString(), e.getLocalizedMessage());
            return null;
        } catch (InvalidKeyException e3) {
            e = e3;
            G.o(a7.j.S1, e.getClass().toString(), e.getLocalizedMessage());
            return null;
        } catch (SignatureException e4) {
            e = e4;
            G.o(a7.j.S1, e.getClass().toString(), e.getLocalizedMessage());
            return null;
        } catch (BadPaddingException e5) {
            e = e5;
            G.o(a7.j.S1, e.getClass().toString(), e.getLocalizedMessage());
            return null;
        } catch (NoSuchPaddingException e6) {
            e = e6;
            G.o(a7.j.S1, e.getClass().toString(), e.getLocalizedMessage());
            return null;
        }
    }

    public final X509Certificate[] s(Context context) {
        this.t0 = KeyChain.getPrivateKey(context, this.e);
        return KeyChain.getCertificateChain(context, this.e);
    }

    public PrivateKey t() {
        return this.t0;
    }

    public String toString() {
        return this.d;
    }

    public String u() {
        return TextUtils.isEmpty(this.d) ? "No profile name" : this.d;
    }

    public String v() {
        String a2 = A.a(this.u0, true);
        return a2 != null ? a2 : this.A;
    }

    public String w() {
        String c2 = A.c(this.u0, true);
        if (c2 != null) {
            return c2;
        }
        int i = this.c;
        if (i != 0) {
            if (i != 1) {
                if (i != 5) {
                    if (i != 6) {
                        return null;
                    }
                }
            }
            return this.m;
        }
        return this.M;
    }

    public String x() {
        return String.format(Locale.US, "%d %s %s %s %s %s", new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.RELEASE, NativeUtils.a(), Build.BRAND, Build.BOARD, Build.MODEL});
    }

    public String y(Context context, String str, boolean z) {
        byte[] q;
        byte[] decode = Base64.decode(str, 0);
        if (this.c == 8) {
            c cVar = z ? c.PKCS1_PADDING : c.NO_PADDING;
            Bundle bundle = new Bundle();
            bundle.putInt("de.blinkt.openvpn.api.RSA_PADDING_TYPE", cVar.ordinal());
            q = n(context, decode, bundle);
        } else {
            q = q(decode, z);
        }
        if (q != null) {
            return Base64.encodeToString(q, 2);
        }
        return null;
    }

    public Intent z(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent(context, OpenVPNService.class);
        intent.putExtra(packageName + ".profileUUID", this.u0.toString());
        intent.putExtra(packageName + ".profileVersion", this.n0);
        return intent;
    }
}
