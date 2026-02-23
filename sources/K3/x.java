package K3;

import android.net.Uri;
import d4.b0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x {
    public final long a;
    public final int b;
    public final Uri c;

    public x(long j, int i, Uri uri) {
        this.a = j;
        this.b = i;
        this.c = uri;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static s5.y a(java.lang.String r18, android.net.Uri r19) {
        /*
            s5.y$a r0 = new s5.y$a
            r0.<init>()
            java.lang.String r1 = ","
            r2 = r18
            java.lang.String[] r1 = d4.k0.i1(r2, r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L10:
            if (r4 >= r2) goto Lc4
            r5 = r1[r4]
            java.lang.String r6 = ";"
            java.lang.String[] r6 = d4.k0.i1(r5, r6)
            int r7 = r6.length
            r12 = 0
            r13 = 0
            r14 = -1
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L23:
            if (r12 >= r7) goto L94
            r8 = r6[r12]
            java.lang.String r9 = "="
            java.lang.String[] r9 = d4.k0.j1(r8, r9)     // Catch: java.lang.Exception -> L53
            r11 = r9[r3]     // Catch: java.lang.Exception -> L53
            r3 = 1
            r9 = r9[r3]     // Catch: java.lang.Exception -> L53
            int r10 = r11.hashCode()     // Catch: java.lang.Exception -> L53
            r3 = 113759(0x1bc5f, float:1.5941E-40)
            r17 = r1
            r1 = 2
            if (r10 == r3) goto L5f
            r3 = 116079(0x1c56f, float:1.62661E-40)
            if (r10 == r3) goto L55
            r3 = 1524180539(0x5ad9263b, float:3.05610524E16)
            if (r10 == r3) goto L49
            goto L69
        L49:
            java.lang.String r3 = "rtptime"
            boolean r3 = r11.equals(r3)     // Catch: java.lang.Exception -> L53
            if (r3 == 0) goto L69
            r3 = 2
            goto L6a
        L53:
            r0 = move-exception
            goto L8f
        L55:
            java.lang.String r3 = "url"
            boolean r3 = r11.equals(r3)     // Catch: java.lang.Exception -> L53
            if (r3 == 0) goto L69
            r3 = 0
            goto L6a
        L5f:
            java.lang.String r3 = "seq"
            boolean r3 = r11.equals(r3)     // Catch: java.lang.Exception -> L53
            if (r3 == 0) goto L69
            r3 = 1
            goto L6a
        L69:
            r3 = -1
        L6a:
            if (r3 == 0) goto L83
            r10 = 1
            if (r3 == r10) goto L7e
            if (r3 != r1) goto L78
            long r15 = java.lang.Long.parseLong(r9)     // Catch: java.lang.Exception -> L53
        L75:
            r1 = r19
            goto L89
        L78:
            r0 = 0
            O2.l1 r0 = O2.l1.c(r11, r0)     // Catch: java.lang.Exception -> L53
            throw r0     // Catch: java.lang.Exception -> L53
        L7e:
            int r14 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.Exception -> L53
            goto L75
        L83:
            r1 = r19
            android.net.Uri r13 = b(r9, r1)     // Catch: java.lang.Exception -> L53
        L89:
            int r12 = r12 + 1
            r1 = r17
            r3 = 0
            goto L23
        L8f:
            O2.l1 r0 = O2.l1.c(r8, r0)
            throw r0
        L94:
            r17 = r1
            r1 = r19
            if (r13 == 0) goto Lae
            java.lang.String r3 = r13.getScheme()
            if (r3 == 0) goto Lae
            r3 = -1
            r8 = r15
            if (r14 != r3) goto Lb0
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 == 0) goto Lae
            goto Lb0
        Lae:
            r0 = 0
            goto Lbf
        Lb0:
            K3.x r3 = new K3.x
            r3.<init>(r8, r14, r13)
            r0.h(r3)
            int r4 = r4 + 1
            r1 = r17
            r3 = 0
            goto L10
        Lbf:
            O2.l1 r0 = O2.l1.c(r5, r0)
            throw r0
        Lc4:
            s5.y r0 = r0.k()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: K3.x.a(java.lang.String, android.net.Uri):s5.y");
    }

    public static Uri b(String str, Uri uri) {
        d4.a.a(((String) d4.a.e(uri.getScheme())).equals("rtsp"));
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        Uri parse2 = Uri.parse("rtsp://" + str);
        String uri2 = uri.toString();
        if (((String) d4.a.e(parse2.getHost())).equals(uri.getHost())) {
            return parse2;
        }
        if (uri2.endsWith("/")) {
            return b0.e(uri2, str);
        }
        return b0.e(uri2 + "/", str);
    }
}
