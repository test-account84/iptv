package R6;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e {
    public static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    public static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    public static final BigInteger[] c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
            i++;
        }
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(Unknown Source:327)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(Unknown Source:85)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:136)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:137)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(Unknown Source:134)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:44)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(Unknown Source:134)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:44)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:137)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(Unknown Source:6)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:22)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:45:0x0074. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.e.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static D6.e b(int[] r6, java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            Q6.c r3 = new Q6.c
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L68
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L53
            switch(r2) {
                case 900: goto L23;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
        L23:
            int r2 = g(r6, r4, r0)
            goto L5b
        L28:
            int r2 = d(r6, r4, r3)
            goto L5b
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            D6.d r1 = D6.d.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L5b
        L3e:
            int r2 = r4 + 2
            goto L5b
        L41:
            int r2 = r4 + 1
            goto L5b
        L44:
            x6.g r6 = x6.g.a()
            throw r6
        L49:
            int r2 = f(r6, r4, r0)
            goto L5b
        L4e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L5b
        L53:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L5b:
            int r4 = r6.length
            if (r2 >= r4) goto L63
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L63:
            x6.g r6 = x6.g.a()
            throw r6
        L68:
            int r6 = r0.length()
            if (r6 == 0) goto L7c
            D6.e r6 = new D6.e
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.m(r3)
            return r6
        L7c:
            x6.g r6 = x6.g.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.e.b(int[], java.lang.String):D6.e");
    }

    public static String c(int[] iArr, int i) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw x6.g.a();
    }

    public static int d(int[] iArr, int i, Q6.c cVar) {
        if (i + 2 > iArr[0]) {
            throw x6.g.a();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        cVar.j(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int g = g(iArr, i, sb);
        cVar.d(sb.toString());
        int i3 = iArr[g] == 923 ? g + 1 : -1;
        while (g < iArr[0]) {
            int i4 = iArr[g];
            if (i4 == 922) {
                g++;
                cVar.g(true);
            } else {
                if (i4 != 923) {
                    throw x6.g.a();
                }
                switch (iArr[g + 1]) {
                    case 0:
                        StringBuilder sb2 = new StringBuilder();
                        g = g(iArr, g + 2, sb2);
                        cVar.e(sb2.toString());
                        break;
                    case 1:
                        StringBuilder sb3 = new StringBuilder();
                        g = f(iArr, g + 2, sb3);
                        cVar.i(Integer.parseInt(sb3.toString()));
                        break;
                    case 2:
                        StringBuilder sb4 = new StringBuilder();
                        g = f(iArr, g + 2, sb4);
                        cVar.l(Long.parseLong(sb4.toString()));
                        break;
                    case 3:
                        StringBuilder sb5 = new StringBuilder();
                        g = g(iArr, g + 2, sb5);
                        cVar.k(sb5.toString());
                        break;
                    case 4:
                        StringBuilder sb6 = new StringBuilder();
                        g = g(iArr, g + 2, sb6);
                        cVar.b(sb6.toString());
                        break;
                    case 5:
                        StringBuilder sb7 = new StringBuilder();
                        g = f(iArr, g + 2, sb7);
                        cVar.f(Long.parseLong(sb7.toString()));
                        break;
                    case 6:
                        StringBuilder sb8 = new StringBuilder();
                        g = f(iArr, g + 2, sb8);
                        cVar.c(Integer.parseInt(sb8.toString()));
                        break;
                    default:
                        throw x6.g.a();
                }
            }
        }
        if (i3 != -1) {
            int i5 = g - i3;
            if (cVar.a()) {
                i5--;
            }
            cVar.h(Arrays.copyOfRange(iArr, i3, i5 + i3));
        }
        return g;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0036 A[PHI: r0
      0x0036: PHI (r0v2 R6.e$b) = 
      (r0v1 R6.e$b)
      (r0v1 R6.e$b)
      (r0v3 R6.e$b)
      (r0v1 R6.e$b)
      (r0v4 R6.e$b)
      (r0v1 R6.e$b)
      (r0v6 R6.e$b)
      (r0v1 R6.e$b)
      (r0v1 R6.e$b)
      (r0v7 R6.e$b)
      (r0v8 R6.e$b)
     binds: [B:4:0x001b, B:54:0x009e, B:47:0x0088, B:46:0x0084, B:38:0x0071, B:35:0x0066, B:39:0x0074, B:29:0x0090, B:27:0x0053, B:18:0x0039, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.e.e(int[], int[], int, java.lang.StringBuilder):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0007 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0038 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f(int[] r8, int r9, java.lang.StringBuilder r10) {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
        L6:
            r3 = 0
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L42
            if (r2 != 0) goto L42
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = 1
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
        L1d:
            r9 = r5
            goto L2e
        L1f:
            if (r6 == r4) goto L2d
            r4 = 901(0x385, float:1.263E-42)
            if (r6 == r4) goto L2d
            r4 = 928(0x3a0, float:1.3E-42)
            if (r6 == r4) goto L2d
            switch(r6) {
                case 922: goto L2d;
                case 923: goto L2d;
                case 924: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L1d
        L2d:
            r2 = 1
        L2e:
            int r4 = r3 % 15
            if (r4 == 0) goto L38
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L38
            if (r2 == 0) goto L7
        L38:
            if (r3 <= 0) goto L7
            java.lang.String r3 = c(r0, r3)
            r10.append(r3)
            goto L6
        L42:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.e.f(int[], int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0036. Please report as an issue. */
    public static int g(int[] iArr, int i, StringBuilder sb) {
        int i2 = iArr[0];
        int[] iArr2 = new int[(i2 - i) << 1];
        int[] iArr3 = new int[(i2 - i) << 1];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                z = true;
            } else {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i = i4;
        }
        e(iArr2, iArr3, i3, sb);
        return i;
    }
}
