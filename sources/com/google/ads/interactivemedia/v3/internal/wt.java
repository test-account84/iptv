package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class wt implements wq, dw {
    public static final avo a = avo.r(4800000L, 3100000L, 2100000L, 1500000L, 800000L);
    public static final avo b = avo.r(1500000L, 1000000L, 730000L, 440000L, 170000L);
    public static final avo c = avo.r(2200000L, 1400000L, 1100000L, 910000L, 620000L);
    public static final avo d = avo.r(3000000L, 1900000L, 1400000L, 1000000L, 660000L);
    public static final avo e = avo.r(6000000L, 4100000L, 3200000L, 1800000L, 1000000L);
    public static final avo f = avo.r(2800000L, 2400000L, 1600000L, 1100000L, 950000L);
    private static wt g;
    private final avs h;
    private final wo i;
    private final xi j;
    private final bn k;
    private final boolean l;
    private int m;
    private long n;
    private long o;
    private int p;
    private long q;
    private long r;
    private long s;
    private long t;

    @Deprecated
    public wt() {
        avs.d();
        bn bnVar = bn.a;
        throw null;
    }

    public static synchronized wt i(Context context) {
        wt wtVar;
        synchronized (wt.class) {
            try {
                if (g == null) {
                    Context applicationContext = context == null ? null : context.getApplicationContext();
                    int[] k = k(cq.M(context));
                    HashMap hashMap = new HashMap(8);
                    hashMap.put(0, 1000000L);
                    avo avoVar = a;
                    hashMap.put(2, (Long) avoVar.get(k[0]));
                    hashMap.put(3, (Long) b.get(k[1]));
                    hashMap.put(4, (Long) c.get(k[2]));
                    hashMap.put(5, (Long) d.get(k[3]));
                    hashMap.put(10, (Long) e.get(k[4]));
                    hashMap.put(9, (Long) f.get(k[5]));
                    hashMap.put(7, (Long) avoVar.get(k[0]));
                    g = ws.a(applicationContext, hashMap, 2000, bn.a, true);
                }
                wtVar = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wtVar;
    }

    public static /* synthetic */ void j(wt wtVar, int i) {
        wtVar.n(i);
    }

    public static /* bridge */ /* synthetic */ int[] k(String str) {
        return p(str);
    }

    private final long l(int i) {
        Long l = (Long) this.h.get(Integer.valueOf(i));
        if (l == null) {
            l = (Long) this.h.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    private final void m(int i, long j, long j2) {
        int i2;
        long j3;
        if (i == 0) {
            if (j != 0) {
                j3 = j;
            } else if (j2 == this.t) {
                return;
            } else {
                j3 = 0;
            }
            i2 = 0;
        } else {
            i2 = i;
            j3 = j;
        }
        this.t = j2;
        this.i.b(i2, j3, j2);
    }

    private final synchronized void n(int i) {
        int i2 = this.p;
        if (i2 == 0 || this.l) {
            if (i2 == i) {
                return;
            }
            this.p = i;
            if (i != 1 && i != 0 && i != 8) {
                this.s = l(i);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                m(this.m > 0 ? (int) (elapsedRealtime - this.n) : 0, this.o, this.s);
                this.n = elapsedRealtime;
                this.o = 0L;
                this.r = 0L;
                this.q = 0L;
                this.j.b();
            }
        }
    }

    private static boolean o(dc dcVar, boolean z) {
        return z && !dcVar.d(8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0aa0, code lost:
    
        return new int[]{4, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0114, code lost:
    
        if (r3.equals("XK") != false) goto L888;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0bd4, code lost:
    
        return new int[]{1, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x012c, code lost:
    
        if (r3.equals("WF") != false) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0768, code lost:
    
        return new int[]{4, 2, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0136, code lost:
    
        if (r3.equals("VU") != false) goto L638;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x086d, code lost:
    
        return new int[]{3, 3, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x014e, code lost:
    
        if (r3.equals("VI") != false) goto L642;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x087b, code lost:
    
        return new int[]{0, 2, 0, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0166, code lost:
    
        if (r3.equals("VE") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0170, code lost:
    
        if (r3.equals("VC") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x017a, code lost:
    
        if (r3.equals("VA") != false) goto L741;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0192, code lost:
    
        if (r3.equals("UY") != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01aa, code lost:
    
        if (r3.equals("UG") != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02ea, code lost:
    
        return new int[]{3, 3, 4, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01b4, code lost:
    
        if (r3.equals("UA") != false) goto L570;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0784, code lost:
    
        return new int[]{0, 2, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x01cc, code lost:
    
        if (r3.equals("TW") != false) goto L703;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x094f, code lost:
    
        return new int[]{0, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01d6, code lost:
    
        if (r3.equals("TV") != false) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x01fc, code lost:
    
        if (r3.equals("TO") != false) goto L824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0af4, code lost:
    
        return new int[]{3, 2, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0206, code lost:
    
        if (r3.equals("TN") != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0210, code lost:
    
        if (r3.equals("TM") != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0338, code lost:
    
        return new int[]{4, 2, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x021a, code lost:
    
        if (r3.equals("TL") != false) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x09fc, code lost:
    
        return new int[]{4, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0232, code lost:
    
        if (r3.equals("TJ") != false) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x024a, code lost:
    
        if (r3.equals("TG") != false) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x08b9, code lost:
    
        return new int[]{3, 4, 1, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0254, code lost:
    
        if (r3.equals("TD") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x025e, code lost:
    
        if (r3.equals("TC") != false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0286, code lost:
    
        return new int[]{1, 2, 1, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0275, code lost:
    
        if (r3.equals("SY") != false) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x027f, code lost:
    
        if (r3.equals("SX") != false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x028d, code lost:
    
        if (r3.equals("SV") != false) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x048d, code lost:
    
        return new int[]{2, 3, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02c1, code lost:
    
        if (r3.equals("SO") != false) goto L824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x02d9, code lost:
    
        if (r3.equals("SM") != false) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0baa, code lost:
    
        return new int[]{0, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x02e3, code lost:
    
        if (r3.equals("SL") != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x02f1, code lost:
    
        if (r3.equals("SK") != false) goto L808;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0abc, code lost:
    
        return new int[]{0, 0, 0, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x02fb, code lost:
    
        if (r3.equals("SI") != false) goto L613;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0817, code lost:
    
        return new int[]{1, 0, 0, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0305, code lost:
    
        if (r3.equals("SH") != false) goto L695;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x031d, code lost:
    
        if (r3.equals("SE") != false) goto L703;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0327, code lost:
    
        if (r3.equals("SD") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0331, code lost:
    
        if (r3.equals("SC") != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0377, code lost:
    
        if (r3.equals("RS") != false) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r3.equals("CI") != false) goto L711;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x05ca, code lost:
    
        return new int[]{1, 0, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x038f, code lost:
    
        if (r3.equals("RE") != false) goto L434;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x05ae, code lost:
    
        return new int[]{1, 2, 1, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x03b5, code lost:
    
        if (r3.equals("PT") != false) goto L703;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x096b, code lost:
    
        return new int[]{3, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x03db, code lost:
    
        if (r3.equals("PM") != false) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x03e5, code lost:
    
        if (r3.equals("PL") != false) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0442, code lost:
    
        return new int[]{1, 1, 2, 2, 4, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x03ee, code lost:
    
        if (r3.equals("PK") != false) goto L824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0406, code lost:
    
        if (r3.equals("PG") != false) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x057e, code lost:
    
        return new int[]{4, 3, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0410, code lost:
    
        if (r3.equals("PF") != false) goto L777;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0a50, code lost:
    
        return new int[]{2, 2, 2, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x041a, code lost:
    
        if (r3.equals("PE") != false) goto L605;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x07fb, code lost:
    
        return new int[]{1, 2, 4, 4, 4, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0424, code lost:
    
        if (r3.equals("PA") != false) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x043b, code lost:
    
        if (r3.equals("NZ") != false) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0449, code lost:
    
        if (r3.equals("NU") != false) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0459, code lost:
    
        return new int[]{4, 2, 2, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0452, code lost:
    
        if (r3.equals("NR") != false) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x046e, code lost:
    
        if (r3.equals("NO") != false) goto L733;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x09b6, code lost:
    
        return new int[]{0, 0, 2, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0486, code lost:
    
        if (r3.equals("NI") != false) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x04a2, code lost:
    
        if (r3.equals("NE") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        if (r3.equals("CG") != false) goto L699;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x04ba, code lost:
    
        if (r3.equals("NA") != false) goto L638;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0941, code lost:
    
        return new int[]{3, 4, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0518, code lost:
    
        if (r3.equals("MT") != false) goto L808;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0522, code lost:
    
        if (r3.equals("MS") != false) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x052c, code lost:
    
        if (r3.equals("MR") != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x053a, code lost:
    
        if (r3.equals("MQ") != false) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0833, code lost:
    
        return new int[]{2, 1, 2, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0544, code lost:
    
        if (r3.equals("MP") != false) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0554, code lost:
    
        return new int[]{0, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0066, code lost:
    
        if (r3.equals("CF") != false) goto L516;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x054d, code lost:
    
        if (r3.equals("MO") != false) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0577, code lost:
    
        if (r3.equals("ML") != false) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0593, code lost:
    
        if (r3.equals("MH") != false) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x059d, code lost:
    
        if (r3.equals("MG") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x06c8, code lost:
    
        return new int[]{4, 2, 4, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x05a7, code lost:
    
        if (r3.equals("MF") != false) goto L434;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x05c3, code lost:
    
        if (r3.equals("MD") != false) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x05ed, code lost:
    
        if (r3.equals("LY") != false) goto L824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x05f7, code lost:
    
        if (r3.equals("LV") != false) goto L703;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x062b, code lost:
    
        if (r3.equals("LR") != false) goto L711;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x0643, code lost:
    
        if (r3.equals("LI") != false) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:470:0x064d, code lost:
    
        if (r3.equals("LC") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0681, code lost:
    
        if (r3.equals("KY") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x068b, code lost:
    
        if (r3.equals("KW") != false) goto L737;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x09c4, code lost:
    
        return new int[]{1, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x06a3, code lost:
    
        if (r3.equals("KP") != false) goto L675;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x08ed, code lost:
    
        return new int[]{3, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x06ad, code lost:
    
        if (r3.equals("KN") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x06b7, code lost:
    
        if (r3.equals("KM") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x06c1, code lost:
    
        if (r3.equals("KI") != false) goto L516;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:0x06dd, code lost:
    
        if (r3.equals("KG") != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x007e, code lost:
    
        if (r3.equals("BN") != false) goto L745;
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:0x06eb, code lost:
    
        if (r3.equals("KE") != false) goto L675;
     */
    /* JADX WARN: Code restructure failed: missing block: B:524:0x071f, code lost:
    
        if (r3.equals("JE") != false) goto L543;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x09e0, code lost:
    
        return new int[]{2, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x073b, code lost:
    
        if (r3.equals("IS") != false) goto L703;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0761, code lost:
    
        if (r3.equals("IO") != false) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x077d, code lost:
    
        if (r3.equals("IM") != false) goto L570;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x078b, code lost:
    
        if (r3.equals("IL") != false) goto L773;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0088, code lost:
    
        if (r3.equals("BM") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0a42, code lost:
    
        return new int[]{1, 2, 2, 2, 3, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0795, code lost:
    
        if (r3.equals("IE") != false) goto L691;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0925, code lost:
    
        return new int[]{0, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x07bb, code lost:
    
        if (r3.equals("HT") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x07c5, code lost:
    
        if (r3.equals("HR") != false) goto L613;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0b48, code lost:
    
        return new int[]{1, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x07ea, code lost:
    
        if (r3.equals("GW") != false) goto L699;
     */
    /* JADX WARN: Code restructure failed: missing block: B:578:0x07f4, code lost:
    
        if (r3.equals("GU") != false) goto L605;
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x0810, code lost:
    
        if (r3.equals("GR") != false) goto L613;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        if (r3.equals("BL") != false) goto L741;
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x082c, code lost:
    
        if (r3.equals("GP") != false) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x0848, code lost:
    
        if (r3.equals("GM") != false) goto L840;
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x0b2c, code lost:
    
        return new int[]{4, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:600:0x0852, code lost:
    
        if (r3.equals("GL") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x085c, code lost:
    
        if (r3.equals("GI") != false) goto L868;
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0b8e, code lost:
    
        return new int[]{0, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0866, code lost:
    
        if (r3.equals("GH") != false) goto L638;
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x0874, code lost:
    
        if (r3.equals("GG") != false) goto L642;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x09d2, code lost:
    
        return new int[]{1, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x0882, code lost:
    
        if (r3.equals("GF") != false) goto L824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x089a, code lost:
    
        if (r3.equals("GD") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:622:0x08b2, code lost:
    
        if (r3.equals("GA") != false) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:628:0x08ce, code lost:
    
        if (r3.equals("FO") != false) goto L868;
     */
    /* JADX WARN: Code restructure failed: missing block: B:634:0x08e6, code lost:
    
        if (r3.equals("FK") != false) goto L675;
     */
    /* JADX WARN: Code restructure failed: missing block: B:648:0x091e, code lost:
    
        if (r3.equals("ES") != false) goto L691;
     */
    /* JADX WARN: Code restructure failed: missing block: B:650:0x092c, code lost:
    
        if (r3.equals("ER") != false) goto L695;
     */
    /* JADX WARN: Code restructure failed: missing block: B:652:0x093a, code lost:
    
        if (r3.equals("EG") != false) goto L699;
     */
    /* JADX WARN: Code restructure failed: missing block: B:654:0x0948, code lost:
    
        if (r3.equals("EE") != false) goto L703;
     */
    /* JADX WARN: Code restructure failed: missing block: B:660:0x0964, code lost:
    
        if (r3.equals("DZ") != false) goto L711;
     */
    /* JADX WARN: Code restructure failed: missing block: B:666:0x0980, code lost:
    
        if (r3.equals("DM") != false) goto L868;
     */
    /* JADX WARN: Code restructure failed: missing block: B:672:0x0998, code lost:
    
        if (r3.equals("DJ") != false) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:678:0x09af, code lost:
    
        if (r3.equals("CZ") != false) goto L733;
     */
    /* JADX WARN: Code restructure failed: missing block: B:680:0x09bd, code lost:
    
        if (r3.equals("CY") != false) goto L737;
     */
    /* JADX WARN: Code restructure failed: missing block: B:682:0x09cb, code lost:
    
        if (r3.equals("CX") != false) goto L741;
     */
    /* JADX WARN: Code restructure failed: missing block: B:684:0x09d9, code lost:
    
        if (r3.equals("CW") != false) goto L745;
     */
    /* JADX WARN: Code restructure failed: missing block: B:690:0x09f5, code lost:
    
        if (r3.equals("CU") != false) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:708:0x0a3b, code lost:
    
        if (r3.equals("CL") != false) goto L773;
     */
    /* JADX WARN: Code restructure failed: missing block: B:710:0x0a49, code lost:
    
        if (r3.equals("CK") != false) goto L777;
     */
    /* JADX WARN: Code restructure failed: missing block: B:724:0x0a81, code lost:
    
        if (r3.equals("BQ") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:730:0x0a99, code lost:
    
        if (r3.equals("BI") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:736:0x0ab5, code lost:
    
        if (r3.equals("BG") != false) goto L808;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c6, code lost:
    
        if (r3.equals("AR") != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:750:0x0aed, code lost:
    
        if (r3.equals("AZ") != false) goto L824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:764:0x0b25, code lost:
    
        if (r3.equals("AF") != false) goto L840;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x06e4, code lost:
    
        return new int[]{2, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:770:0x0b41, code lost:
    
        if (r3.equals("AD") != false) goto L848;
     */
    /* JADX WARN: Code restructure failed: missing block: B:788:0x0b87, code lost:
    
        if (r3.equals("BB") != false) goto L868;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d0, code lost:
    
        if (r3.equals("AQ") != false) goto L695;
     */
    /* JADX WARN: Code restructure failed: missing block: B:794:0x0ba3, code lost:
    
        if (r3.equals("AX") != false) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:804:0x0bcd, code lost:
    
        if (r3.equals("AL") != false) goto L888;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0933, code lost:
    
        return new int[]{4, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00da, code lost:
    
        if (r3.equals("ZW") != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0533, code lost:
    
        return new int[]{4, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0100, code lost:
    
        if (r3.equals("YT") != false) goto L543;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0726, code lost:
    
        return new int[]{4, 2, 2, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x010a, code lost:
    
        if (r3.equals("YE") != false) goto L800;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Attempt to invoke interface method 'java.util.Iterator java.util.List.iterator()' on a null object reference
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(Unknown Source:139)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(Unknown Source:6)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(Unknown Source:6)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(Unknown Source:34)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] p(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 6360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.wt.p(java.lang.String):int[]");
    }

    public final synchronized void a(dc dcVar, boolean z, int i) {
        if (o(dcVar, z)) {
            this.o += i;
        }
    }

    public final synchronized void b(dc dcVar, boolean z) {
        try {
            if (o(dcVar, z)) {
                af.w(this.m > 0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int i = (int) (elapsedRealtime - this.n);
                this.q += i;
                long j = this.r;
                long j2 = this.o;
                this.r = j + j2;
                if (i > 0) {
                    this.j.a((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                    if (this.q >= 2000 || this.r >= 524288) {
                        this.s = (long) this.j.c();
                    }
                    m(i, this.o, this.s);
                    this.n = elapsedRealtime;
                    this.o = 0L;
                }
                this.m--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c() {
    }

    public final synchronized void d(dc dcVar, boolean z) {
        try {
            if (o(dcVar, z)) {
                if (this.m == 0) {
                    this.n = SystemClock.elapsedRealtime();
                }
                this.m++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long e() {
        return this.s;
    }

    public final dw f() {
        return this;
    }

    public final void g(Handler handler, wp wpVar) {
        af.s(wpVar);
        this.i.a(handler, wpVar);
    }

    public final void h(wp wpVar) {
        this.i.c(wpVar);
    }

    public /* synthetic */ wt(Context context, Map map, int i, bn bnVar, boolean z) {
        this.h = avs.c(map);
        this.i = new wo();
        this.j = new xi(2000);
        this.k = bnVar;
        this.l = true;
        if (context == null) {
            this.p = 0;
            this.s = l(0);
            return;
        }
        ch b2 = ch.b(context);
        int a2 = b2.a();
        this.p = a2;
        this.s = l(a2);
        b2.d(new xv(this));
    }
}
