package K3;

import O2.l1;
import O2.z0;
import Q2.a;
import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import d4.G;
import d4.L;
import d4.k0;
import s5.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o {
    public final h a;
    public final Uri b;

    public o(com.google.android.exoplayer2.source.rtsp.e eVar, a aVar, Uri uri) {
        d4.a.b(aVar.i.containsKey("control"), "missing attribute control");
        this.a = b(aVar);
        this.b = a(eVar, uri, (String) k0.j((String) aVar.i.get("control")));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017 A[PHI: r0
      0x0017: PHI (r0v3 java.lang.String) = (r0v1 java.lang.String), (r0v2 java.lang.String) binds: [B:6:0x0015, B:14:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri a(com.google.android.exoplayer2.source.rtsp.e r2, android.net.Uri r3, java.lang.String r4) {
        /*
            android.net.Uri r0 = android.net.Uri.parse(r4)
            boolean r1 = r0.isAbsolute()
            if (r1 == 0) goto Lb
            return r0
        Lb:
            java.lang.String r0 = "Content-Base"
            java.lang.String r1 = r2.d(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L20
        L17:
            java.lang.String r2 = r2.d(r0)
            android.net.Uri r3 = android.net.Uri.parse(r2)
            goto L2d
        L20:
            java.lang.String r0 = "Content-Location"
            java.lang.String r1 = r2.d(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L2d
            goto L17
        L2d:
            java.lang.String r2 = "*"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L36
            return r3
        L36:
            android.net.Uri$Builder r2 = r3.buildUpon()
            android.net.Uri$Builder r2 = r2.appendEncodedPath(r4)
            android.net.Uri r2 = r2.build()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: K3.o.a(com.google.android.exoplayer2.source.rtsp.e, android.net.Uri, java.lang.String):android.net.Uri");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static K3.h b(K3.a r13) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: K3.o.b(K3.a):K3.h");
    }

    public static byte[] c(String str) {
        byte[] decode = Base64.decode(str, 0);
        int length = decode.length;
        byte[] bArr = G.a;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(decode, 0, bArr2, bArr.length, decode.length);
        return bArr2;
    }

    public static int d(int i, String str) {
        return i != -1 ? i : str.equals("audio/ac3") ? 6 : 1;
    }

    public static a.b e(String str) {
        L l = new L(k0.L(str));
        d4.a.b(l.h(1) == 0, "Only supports audio mux version 0.");
        d4.a.b(l.h(1) == 1, "Only supports allStreamsSameTimeFraming.");
        l.r(6);
        d4.a.b(l.h(4) == 0, "Only supports one program.");
        d4.a.b(l.h(3) == 0, "Only supports one numLayer.");
        try {
            return Q2.a.e(l, false);
        } catch (l1 e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void f(z0.b bVar, A a, String str, int i, int i2) {
        String str2 = (String) a.get("profile-level-id");
        if (str2 == null && str.equals("MP4A-LATM")) {
            str2 = "30";
        }
        d4.a.b((str2 == null || str2.isEmpty()) ? false : true, "missing profile-level-id param");
        bVar.K("mp4a.40." + str2);
        bVar.V(s5.y.A(Q2.a.a(i2, i)));
    }

    public static void g(z0.b bVar, A a) {
        String a2;
        d4.a.b(a.containsKey("sprop-parameter-sets"), "missing sprop parameter");
        String[] i1 = k0.i1((String) d4.a.e((String) a.get("sprop-parameter-sets")), ",");
        d4.a.b(i1.length == 2, "empty sprop value");
        s5.y B = s5.y.B(c(i1[0]), c(i1[1]));
        bVar.V(B);
        byte[] bArr = (byte[]) B.get(0);
        G.c l = G.l(bArr, G.a.length, bArr.length);
        bVar.c0(l.h);
        bVar.S(l.g);
        bVar.n0(l.f);
        String str = (String) a.get("profile-level-id");
        if (str != null) {
            a2 = "avc1." + str;
        } else {
            a2 = d4.f.a(l.a, l.b, l.c);
        }
        bVar.K(a2);
    }

    public static void h(z0.b bVar, A a) {
        if (a.containsKey("sprop-max-don-diff")) {
            int parseInt = Integer.parseInt((String) d4.a.e((String) a.get("sprop-max-don-diff")));
            d4.a.b(parseInt == 0, "non-zero sprop-max-don-diff " + parseInt + " is not supported");
        }
        d4.a.b(a.containsKey("sprop-vps"), "missing sprop-vps parameter");
        String str = (String) d4.a.e((String) a.get("sprop-vps"));
        d4.a.b(a.containsKey("sprop-sps"), "missing sprop-sps parameter");
        String str2 = (String) d4.a.e((String) a.get("sprop-sps"));
        d4.a.b(a.containsKey("sprop-pps"), "missing sprop-pps parameter");
        s5.y D = s5.y.D(c(str), c(str2), c((String) d4.a.e((String) a.get("sprop-pps"))));
        bVar.V(D);
        byte[] bArr = (byte[]) D.get(1);
        G.a h = G.h(bArr, G.a.length, bArr.length);
        bVar.c0(h.m);
        bVar.S(h.l).n0(h.k);
        bVar.K(d4.f.c(h.a, h.b, h.c, h.d, h.h, h.i));
    }

    public static void i(z0.b bVar, A a) {
        String str = (String) a.get("config");
        if (str != null) {
            byte[] L = k0.L(str);
            bVar.V(s5.y.A(L));
            Pair f = d4.f.f(L);
            bVar.n0(((Integer) f.first).intValue()).S(((Integer) f.second).intValue());
        } else {
            bVar.n0(352).S(288);
        }
        String str2 = (String) a.get("profile-level-id");
        StringBuilder sb = new StringBuilder();
        sb.append("mp4v.");
        if (str2 == null) {
            str2 = "1";
        }
        sb.append(str2);
        bVar.K(sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.a.equals(oVar.a) && this.b.equals(oVar.b);
    }

    public int hashCode() {
        return ((217 + this.a.hashCode()) * 31) + this.b.hashCode();
    }
}
