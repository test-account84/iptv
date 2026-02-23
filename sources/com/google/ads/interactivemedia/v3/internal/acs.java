package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class acs implements zh {
    private static final byte[] a;
    private static final s b;
    private int A;
    private int B;
    private int C;
    private boolean D;
    private zk E;
    private aae[] F;
    private aae[] G;
    private boolean H;
    private final bdy I;
    private final int c;
    private final List d;
    private final SparseArray e;
    private final cj f;
    private final cj g;
    private final cj h;
    private final byte[] i;
    private final cj j;
    private final co k;
    private final cj l;
    private final ArrayDeque m;
    private final ArrayDeque n;
    private final aae o;
    private int p;
    private int q;
    private long r;
    private int s;
    private cj t;
    private long u;
    private int v;
    private long w;
    private long x;
    private long y;
    private acr z;

    static {
        acu acuVar = acu.a;
        a = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
        r rVar = new r();
        rVar.ae("application/x-emsg");
        b = rVar.v();
    }

    public acs() {
        this(null);
    }

    private static o f(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            acd acdVar = (acd) list.get(i);
            if (acdVar.d == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] H = acdVar.a.H();
                UUID b2 = acz.b(H);
                if (b2 == null) {
                    cd.e("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new n(b2, "video/mp4", H));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new o((List) arrayList);
    }

    private final void g() {
        this.p = 0;
        this.s = 0;
    }

    private static void h(cj cjVar, int i, add addVar) throws as {
        cjVar.F(i + 8);
        int e = ace.e(cjVar.e());
        if ((e & 1) != 0) {
            throw as.d("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (e & 2) != 0;
        int l = cjVar.l();
        if (l == 0) {
            Arrays.fill(addVar.l, 0, addVar.e, false);
            return;
        }
        int i2 = addVar.e;
        if (l != i2) {
            throw as.a("Senc sample count " + l + " is different from fragment sample count" + i2, null);
        }
        Arrays.fill(addVar.l, 0, l, z);
        addVar.b(cjVar.a());
        cj cjVar2 = addVar.n;
        cjVar.A(cjVar2.H(), 0, cjVar2.d());
        addVar.n.F(0);
        addVar.o = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:336:0x071a, code lost:
    
        g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x071e, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:292:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void i(long r52) throws com.google.ads.interactivemedia.v3.internal.as {
        /*
            Method dump skipped, instructions count: 1823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.acs.i(long):void");
    }

    private static void j(int i) throws as {
        if (i >= 0) {
            return;
        }
        throw as.a("Unexpected negative value: " + i, null);
    }

    private static final acn k(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (acn) sparseArray.valueAt(0);
        }
        acn acnVar = (acn) sparseArray.get(i);
        af.s(acnVar);
        return acnVar;
    }

    public final boolean C(zi ziVar) throws IOException {
        return ada.a(ziVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:227:0x0094, code lost:
    
        r5 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0097, code lost:
    
        if (r35.p != 3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0099, code lost:
    
        r2 = r4.b();
        r35.A = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x00a3, code lost:
    
        if (r4.f >= r4.i) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x00a5, code lost:
    
        r36.i(r2);
        r1 = r4.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x00ac, code lost:
    
        if (r1 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x00af, code lost:
    
        r2 = r4.b.n;
        r1 = r1.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x00b5, code lost:
    
        if (r1 == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x00b7, code lost:
    
        r2.G(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x00c2, code lost:
    
        if (r4.b.c(r4.f) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x00c4, code lost:
    
        r2.G(r2.m() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x00d1, code lost:
    
        if (r4.j() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x00d3, code lost:
    
        r35.z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x00d5, code lost:
    
        r35.p = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x00d7, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x00e0, code lost:
    
        if (r4.d.a.g != r3) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x00e2, code lost:
    
        r35.A = r2 - 8;
        r36.i(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x00f7, code lost:
    
        if ("audio/ac4".equals(r4.d.a.f.l) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x00f9, code lost:
    
        r35.B = r4.c(r35.A, 7);
        com.google.ads.interactivemedia.v3.internal.yq.b(r35.A, r35.j);
        r4.a.e(r35.j, 7);
        r2 = r35.B + 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0113, code lost:
    
        r35.B = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x011d, code lost:
    
        r35.A += r2;
        r35.p = 4;
        r35.C = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0116, code lost:
    
        r2 = r4.c(r35.A, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0127, code lost:
    
        r2 = r4.d.a;
        r6 = r4.a;
        r7 = r4.e();
        r11 = r35.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0133, code lost:
    
        if (r11 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0135, code lost:
    
        r7 = r11.a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0139, code lost:
    
        r11 = r2.j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x013b, code lost:
    
        if (r11 != 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x013d, code lost:
    
        r2 = r35.B;
        r5 = r35.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0141, code lost:
    
        if (r2 >= r5) goto L372;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0143, code lost:
    
        r35.B += r6.a(r36, r5 - r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x022d, code lost:
    
        r22 = r4.a();
        r1 = r4.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0235, code lost:
    
        if (r1 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0237, code lost:
    
        r25 = r1.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x023e, code lost:
    
        r6.f(r7, r22, r35.A, 0, r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0251, code lost:
    
        if (r35.n.isEmpty() != false) goto L373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0253, code lost:
    
        r1 = (com.google.ads.interactivemedia.v3.internal.acq) r35.n.removeFirst();
        r35.v -= r1.c;
        r5 = r1.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0266, code lost:
    
        if (r1.b == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0268, code lost:
    
        r5 = r5 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0269, code lost:
    
        r2 = r35.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x026b, code lost:
    
        if (r2 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x026d, code lost:
    
        r5 = r2.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0271, code lost:
    
        r2 = r35.F;
        r15 = r2.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0275, code lost:
    
        if (r14 >= r15) goto L376;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0277, code lost:
    
        r2[r14].f(r5, 1, r1.c, r35.v, null);
        r14 = r14 + 1;
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x029a, code lost:
    
        if (r4.j() != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x029c, code lost:
    
        r35.z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x029f, code lost:
    
        r35.p = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x023c, code lost:
    
        r25 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x014e, code lost:
    
        r12 = r35.g.H();
        r12[0] = 0;
        r12[r3] = 0;
        r12[2] = 0;
        r14 = r11 + 1;
        r11 = 4 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0164, code lost:
    
        if (r35.B >= r35.A) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0166, code lost:
    
        r13 = r35.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x016a, code lost:
    
        if (r13 != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x016c, code lost:
    
        r36.g(r12, r11, r14);
        r35.g.F(r10);
        r13 = r35.g.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x017a, code lost:
    
        if (r13 <= 0) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x017c, code lost:
    
        r35.C = r13 - 1;
        r35.f.F(r10);
        r6.e(r35.f, 4);
        r6.e(r35.g, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0195, code lost:
    
        if (r35.G.length <= 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0197, code lost:
    
        r13 = r2.f.l;
        r17 = r12[4];
        r10 = com.google.ads.interactivemedia.v3.internal.zw.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x01a5, code lost:
    
        if ("video/avc".equals(r13) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x01a9, code lost:
    
        if ((r17 & 31) == r5) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x01ac, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x01bd, code lost:
    
        r35.D = r10;
        r35.B += 5;
        r35.A += r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x01ca, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x01b2, code lost:
    
        if ("video/hevc".equals(r13) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x01b9, code lost:
    
        if (((r17 & 126) >> r3) != 39) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x01bc, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x01d3, code lost:
    
        throw com.google.ads.interactivemedia.v3.internal.as.a("Invalid NAL length", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x01d6, code lost:
    
        if (r35.D == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x01d8, code lost:
    
        r35.h.B(r13);
        r36.g(r35.h.H(), 0, r35.C);
        r6.e(r35.h, r35.C);
        r5 = r35.C;
        r10 = r35.h;
        r10 = com.google.ads.interactivemedia.v3.internal.zw.b(r10.H(), r10.d());
        r35.h.F("video/hevc".equals(r2.f.l) ? 1 : 0);
        r35.h.E(r10);
        com.google.ads.interactivemedia.v3.internal.fz.l(r7, r35.h, r35.G);
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0220, code lost:
    
        r35.B += r5;
        r35.C -= r5;
        r5 = 6;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x021a, code lost:
    
        r5 = r6.a(r36, r13, false);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x072e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x05b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.google.ads.interactivemedia.v3.internal.zi r36, com.google.ads.interactivemedia.v3.internal.zy r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1845
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.acs.a(com.google.ads.interactivemedia.v3.internal.zi, com.google.ads.interactivemedia.v3.internal.zy):int");
    }

    public final void b(zk zkVar) {
        int i;
        this.E = zkVar;
        g();
        aae[] aaeVarArr = new aae[2];
        this.F = aaeVarArr;
        aae aaeVar = this.o;
        int i2 = 0;
        if (aaeVar != null) {
            aaeVarArr[0] = aaeVar;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.c & 4) != 0) {
            aaeVarArr[i] = this.E.i(100, 5);
            i3 = 101;
            i++;
        }
        aae[] aaeVarArr2 = (aae[]) cq.ai(this.F, i);
        this.F = aaeVarArr2;
        for (aae aaeVar2 : aaeVarArr2) {
            aaeVar2.b(b);
        }
        this.G = new aae[this.d.size()];
        while (i2 < this.G.length) {
            aae i4 = this.E.i(i3, 3);
            i4.b((s) this.d.get(i2));
            this.G[i2] = i4;
            i2++;
            i3++;
        }
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            ((acr) this.e.valueAt(i)).h();
        }
        this.n.clear();
        this.v = 0;
        this.w = j2;
        this.m.clear();
        g();
    }

    public acs(int i, co coVar, List list) {
        this(i, coVar, list, null);
    }

    public acs(int i, co coVar, List list, aae aaeVar) {
        this.c = i;
        this.k = coVar;
        this.d = Collections.unmodifiableList(list);
        this.o = aaeVar;
        this.I = new bdy((char[]) null);
        this.l = new cj(16);
        this.f = new cj(zw.a);
        this.g = new cj(5);
        this.h = new cj();
        byte[] bArr = new byte[16];
        this.i = bArr;
        this.j = new cj(bArr);
        this.m = new ArrayDeque();
        this.n = new ArrayDeque();
        this.e = new SparseArray();
        this.x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = zk.b;
        this.F = new aae[0];
        this.G = new aae[0];
    }

    public acs(byte[] bArr) {
        this(0, null, Collections.emptyList());
    }
}
