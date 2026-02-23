package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzakr implements zzalf {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzamk.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzakn zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final zzaky zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzakv zzo;
    private final zzajs zzp;
    private final zzame zzq;
    private final zzaiq zzr;
    private final zzakg zzs;

    private zzakr(int[] iArr, Object[] objArr, int i, int i2, zzakn zzaknVar, zzaky zzakyVar, boolean z, int[] iArr2, int i3, int i4, zzakv zzakvVar, zzajs zzajsVar, zzame zzameVar, zzaiq zzaiqVar, zzakg zzakgVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzaknVar instanceof zzajc;
        this.zzj = zzakyVar;
        this.zzh = zzaiqVar != null && zzaiqVar.zza(zzaknVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzakvVar;
        this.zzp = zzajsVar;
        this.zzq = zzameVar;
        this.zzr = zzaiqVar;
        this.zzg = zzaknVar;
        this.zzs = zzakgVar;
    }

    private static double zza(Object obj, long j) {
        return ((Double) zzamk.zze(obj, j)).doubleValue();
    }

    private static float zzb(Object obj, long j) {
        return ((Float) zzamk.zze(obj, j)).floatValue();
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static long zzd(Object obj, long j) {
        return ((Long) zzamk.zze(obj, j)).longValue();
    }

    private final zzalf zze(int i) {
        int i2 = (i / 3) << 1;
        zzalf zzalfVar = (zzalf) this.zzd[i2];
        if (zzalfVar != null) {
            return zzalfVar;
        }
        zzalf zza2 = zzalb.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private static int zzc(Object obj, long j) {
        return ((Integer) zzamk.zze(obj, j)).intValue();
    }

    private final zzajg zzd(int i) {
        return (zzajg) this.zzd[((i / 3) << 1) + 1];
    }

    private static zzamd zze(Object obj) {
        zzajc zzajcVar = (zzajc) obj;
        zzamd zzamdVar = zzajcVar.zzb;
        if (zzamdVar != zzamd.zzc()) {
            return zzamdVar;
        }
        zzamd zzd = zzamd.zzd();
        zzajcVar.zzb = zzd;
        return zzd;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzajc) {
            return ((zzajc) obj).zzu();
        }
        return true;
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static boolean zze(Object obj, long j) {
        return ((Boolean) zzamk.zze(obj, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f4 A[PHI: r3
      0x00f4: PHI (r3v9 java.lang.Object) = (r3v6 java.lang.Object), (r3v10 java.lang.Object) binds: [B:83:0x0110, B:76:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zzb(java.lang.Object):int");
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(Unknown Source:327)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(Unknown Source:85)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:136)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:137)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:137)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(Unknown Source:312)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:44)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:137)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(Unknown Source:6)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:22)
        */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzg(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.firebase-auth-api.zzajc
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.firebase-auth-api.zzajc r0 = (com.google.android.gms.internal.firebase-auth-api.zzajc) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzb(r2)
            r0.zza = r1
            r0.zzt()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L77
            int r2 = r7.zzc(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            long r3 = (long) r3
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r5
            int r2 = r2 >>> 20
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L74
        L3d:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.firebase-auth-api.zzakr.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L74
            com.google.android.gms.internal.firebase-auth-api.zzakg r6 = r7.zzs
            java.lang.Object r5 = r6.zzc(r5)
            r2.putObject(r8, r3, r5)
            goto L74
        L4f:
            com.google.android.gms.internal.firebase-auth-api.zzajs r2 = r7.zzp
            r2.zzb(r8, r3)
            goto L74
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzc(r8, r2, r1)
            if (r2 == 0) goto L74
        L5f:
            com.google.android.gms.internal.firebase-auth-api.zzalf r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.firebase-auth-api.zzakr.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzc(r3)
            goto L74
        L6d:
            boolean r2 = r7.zzc(r8, r1)
            if (r2 == 0) goto L74
            goto L5f
        L74:
            int r1 = r1 + 3
            goto L1d
        L77:
            com.google.android.gms.internal.firebase-auth-api.zzame r0 = r7.zzq
            r0.zzf(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L85
            com.google.android.gms.internal.firebase-auth-api.zzaiq r0 = r7.zzr
            r0.zzc(r8)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zzc(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzd(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zzd(java.lang.Object):boolean");
    }

    private final void zzb(Object obj, int i) {
        int zzb2 = zzb(i);
        long j = 1048575 & zzb2;
        if (j == 1048575) {
            return;
        }
        zzamk.zza(obj, j, (1 << (zzb2 >>> 20)) | zzamk.zzc(obj, j));
    }

    private final boolean zzc(Object obj, int i) {
        int zzb2 = zzb(i);
        long j = zzb2 & 1048575;
        if (j != 1048575) {
            return (zzamk.zzc(obj, j) & (1 << (zzb2 >>> 20))) != 0;
        }
        int zzc = zzc(i);
        long j2 = zzc & 1048575;
        switch ((zzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzamk.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzamk.zzb(obj, j2)) != 0;
            case 2:
                return zzamk.zzd(obj, j2) != 0;
            case 3:
                return zzamk.zzd(obj, j2) != 0;
            case 4:
                return zzamk.zzc(obj, j2) != 0;
            case 5:
                return zzamk.zzd(obj, j2) != 0;
            case 6:
                return zzamk.zzc(obj, j2) != 0;
            case 7:
                return zzamk.zzh(obj, j2);
            case 8:
                Object zze = zzamk.zze(obj, j2);
                if (zze instanceof String) {
                    return !((String) zze).isEmpty();
                }
                if (zze instanceof zzahp) {
                    return !zzahp.zza.equals(zze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzamk.zze(obj, j2) != null;
            case 10:
                return !zzahp.zza.equals(zzamk.zze(obj, j2));
            case 11:
                return zzamk.zzc(obj, j2) != 0;
            case 12:
                return zzamk.zzc(obj, j2) != 0;
            case 13:
                return zzamk.zzc(obj, j2) != 0;
            case 14:
                return zzamk.zzd(obj, j2) != 0;
            case 15:
                return zzamk.zzc(obj, j2) != 0;
            case 16:
                return zzamk.zzd(obj, j2) != 0;
            case 17:
                return zzamk.zze(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0203, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0210, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x021d, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x022b, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0239, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0247, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0255, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x034e, code lost:
    
        if (zza(r18, r11, r14, r16, r5) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x035e, code lost:
    
        if (zza(r18, r11, r14, r16, r5) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03db, code lost:
    
        if (zza(r18, r11, r14, r16, r5) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
    
        if (zzc(r18, r13, r11) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009a, code lost:
    
        r0 = com.google.android.gms.internal.firebase-auth-api.zzaik.zzc(r13, 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
    
        if (zzc(r18, r13, r11) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a5, code lost:
    
        r1 = com.google.android.gms.internal.firebase-auth-api.zzaik.zze(r13, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0109, code lost:
    
        if (zzc(r18, r13, r11) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010b, code lost:
    
        r0 = com.google.android.gms.internal.firebase-auth-api.zzaik.zza(r13, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x019d, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019f, code lost:
    
        r1 = (com.google.android.gms.internal.firebase-auth-api.zzaik.zzi(r13) + com.google.android.gms.internal.firebase-auth-api.zzaik.zzj(r0)) + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01b5, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c2, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cf, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01dc, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e9, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f6, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4 A[PHI: r0
      0x00d4: PHI (r0v186 java.lang.Object) = (r0v44 java.lang.Object), (r0v50 java.lang.Object), (r0v181 java.lang.Object), (r0v190 java.lang.Object) binds: [B:154:0x03cb, B:147:0x039b, B:56:0x00fa, B:47:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fd A[PHI: r0
      0x00fd: PHI (r0v177 java.lang.Object) = (r0v44 java.lang.Object), (r0v181 java.lang.Object) binds: [B:154:0x03cb, B:56:0x00fa] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 1400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zza(java.lang.Object):int");
    }

    private final void zzb(Object obj, int i, int i2) {
        zzamk.zza(obj, zzb(i2) & 1048575, i);
    }

    private final boolean zzc(Object obj, int i, int i2) {
        return zzamk.zzc(obj, (long) (zzb(i2) & 1048575)) == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x09b5, code lost:
    
        throw com.google.android.gms.internal.firebase-auth-api.zzaji.zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0561, code lost:
    
        if (r1 == 0) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0563, code lost:
    
        r12.add(com.google.android.gms.internal.firebase-auth-api.zzahp.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0571, code lost:
    
        if (r0 >= r7) goto L648;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0573, code lost:
    
        r1 = com.google.android.gms.internal.firebase-auth-api.zzahl.zzc(r15, r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0579, code lost:
    
        if (r11 != r14.zza) goto L650;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x057b, code lost:
    
        r0 = com.google.android.gms.internal.firebase-auth-api.zzahl.zzc(r15, r1, r14);
        r1 = r14.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0581, code lost:
    
        if (r1 < 0) goto L561;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0585, code lost:
    
        if (r1 > (r15.length - r0)) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0587, code lost:
    
        if (r1 != 0) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0569, code lost:
    
        r12.add(com.google.android.gms.internal.firebase-auth-api.zzahp.zza(r15, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x058e, code lost:
    
        throw com.google.android.gms.internal.firebase-auth-api.zzaji.zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0593, code lost:
    
        throw com.google.android.gms.internal.firebase-auth-api.zzaji.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0571, code lost:
    
        r12.add(com.google.android.gms.internal.firebase-auth-api.zzahp.zza(r15, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x06b8, code lost:
    
        if (r0.zzb != 0) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x06ba, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x06bd, code lost:
    
        r12.zza(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x06c0, code lost:
    
        if (r1 >= r7) goto L663;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x06c2, code lost:
    
        r2 = com.google.android.gms.internal.firebase-auth-api.zzahl.zzc(r15, r1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x06c8, code lost:
    
        if (r4 != r0.zza) goto L665;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x06ca, code lost:
    
        r1 = com.google.android.gms.internal.firebase-auth-api.zzahl.zzd(r15, r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x06d2, code lost:
    
        if (r0.zzb == 0) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x06bc, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x06bd, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0c98, code lost:
    
        if (r14 == r0) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0c9a, code lost:
    
        r27.putInt(r7, r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0ca0, code lost:
    
        r10 = r9.zzm;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0ca7, code lost:
    
        if (r10 >= r9.zzn) goto L639;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0ca9, code lost:
    
        r3 = (com.google.android.gms.internal.firebase-auth-api.zzamd) zza(r31, r9.zzl[r10], r3, r9.zzq, r31);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0cbf, code lost:
    
        if (r3 == null) goto L532;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0cc1, code lost:
    
        r9.zzq.zzb(r7, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0cc8, code lost:
    
        if (r6 != 0) goto L538;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0cca, code lost:
    
        if (r8 != r34) goto L536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0cd1, code lost:
    
        throw com.google.android.gms.internal.firebase-auth-api.zzaji.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0cd6, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0cd2, code lost:
    
        if (r8 > r34) goto L541;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0cd4, code lost:
    
        if (r11 != r6) goto L541;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0cdb, code lost:
    
        throw com.google.android.gms.internal.firebase-auth-api.zzaji.zzg();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0c69  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0c10  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0c7b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0888  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0895  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x063b  */
    /* JADX WARN: Type inference failed for: r1v132, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:235:0x0587 -> B:227:0x0563). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:262:0x0603 -> B:256:0x05e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:279:0x064b -> B:273:0x0622). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:317:0x06d2 -> B:311:0x06ba). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.firebase-auth-api.zzahk r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzahk):int");
    }

    private static int zza(byte[] bArr, int i, int i2, zzamr zzamrVar, Class cls, zzahk zzahkVar) throws IOException {
        int zzd;
        Long valueOf;
        Long valueOf2;
        Float valueOf3;
        int i3;
        long j;
        switch (zzakq.zza[zzamrVar.ordinal()]) {
            case 1:
                zzd = zzahl.zzd(bArr, i, zzahkVar);
                valueOf = Boolean.valueOf(zzahkVar.zzb != 0);
                zzahkVar.zzc = valueOf;
                return zzd;
            case 2:
                return zzahl.zza(bArr, i, zzahkVar);
            case 3:
                valueOf2 = Double.valueOf(zzahl.zza(bArr, i));
                zzahkVar.zzc = valueOf2;
                return i + 8;
            case 4:
            case 5:
                valueOf3 = Integer.valueOf(zzahl.zzc(bArr, i));
                zzahkVar.zzc = valueOf3;
                return i + 4;
            case 6:
            case 7:
                valueOf2 = Long.valueOf(zzahl.zzd(bArr, i));
                zzahkVar.zzc = valueOf2;
                return i + 8;
            case 8:
                valueOf3 = Float.valueOf(zzahl.zzb(bArr, i));
                zzahkVar.zzc = valueOf3;
                return i + 4;
            case 9:
            case 10:
            case 11:
                zzd = zzahl.zzc(bArr, i, zzahkVar);
                i3 = zzahkVar.zza;
                valueOf = Integer.valueOf(i3);
                zzahkVar.zzc = valueOf;
                return zzd;
            case 12:
            case 13:
                zzd = zzahl.zzd(bArr, i, zzahkVar);
                j = zzahkVar.zzb;
                valueOf = Long.valueOf(j);
                zzahkVar.zzc = valueOf;
                return zzd;
            case 14:
                return zzahl.zza(zzalb.zza().zza(cls), bArr, i, i2, zzahkVar);
            case 15:
                zzd = zzahl.zzc(bArr, i, zzahkVar);
                i3 = zzaia.zza(zzahkVar.zza);
                valueOf = Integer.valueOf(i3);
                zzahkVar.zzc = valueOf;
                return zzd;
            case 16:
                zzd = zzahl.zzd(bArr, i, zzahkVar);
                j = zzaia.zza(zzahkVar.zzb);
                valueOf = Long.valueOf(j);
                zzahkVar.zzc = valueOf;
                return zzd;
            case 17:
                return zzahl.zzb(bArr, i, zzahkVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zzb(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzc(obj2, i2, i)) {
            long zzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(obj2));
            }
            zzalf zze = zze(i);
            if (!zzc(obj, i2, i)) {
                if (zzg(object)) {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(obj, zzc, zza2);
                } else {
                    unsafe.putObject(obj, zzc, object);
                }
                zzb(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(obj, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    private final boolean zzc(Object obj, Object obj2, int i) {
        return zzc(obj, i) == zzc(obj2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.firebase-auth-api.zzakr zza(java.lang.Class r33, com.google.android.gms.internal.firebase-auth-api.zzakl r34, com.google.android.gms.internal.firebase-auth-api.zzakv r35, com.google.android.gms.internal.firebase-auth-api.zzajs r36, com.google.android.gms.internal.firebase-auth-api.zzame r37, com.google.android.gms.internal.firebase-auth-api.zzaiq r38, com.google.android.gms.internal.firebase-auth-api.zzakg r39) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zza(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzakl, com.google.android.gms.internal.firebase-auth-api.zzakv, com.google.android.gms.internal.firebase-auth-api.zzajs, com.google.android.gms.internal.firebase-auth-api.zzame, com.google.android.gms.internal.firebase-auth-api.zzaiq, com.google.android.gms.internal.firebase-auth-api.zzakg):com.google.android.gms.internal.firebase-auth-api.zzakr");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzb(java.lang.Object r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    public final Object zza() {
        return this.zzo.zza(this.zzg);
    }

    private final Object zza(int i, int i2, Map map, zzajg zzajgVar, Object obj, zzame zzameVar, Object obj2) {
        zzake zza2 = this.zzs.zza(zzf(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzajgVar.zza(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = zzameVar.zzc(obj2);
                }
                zzahu zzc = zzahp.zzc(zzakf.zza(zza2, entry.getKey(), entry.getValue()));
                try {
                    zzakf.zza(zzc.zzb(), zza2, entry.getKey(), entry.getValue());
                    zzameVar.zza(obj, i2, zzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    private final Object zza(Object obj, int i) {
        zzalf zze = zze(i);
        long zzc = zzc(i) & 1048575;
        if (!zzc(obj, i)) {
            return zze.zza();
        }
        Object object = zzb.getObject(obj, zzc);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    private final Object zza(Object obj, int i, int i2) {
        zzalf zze = zze(i2);
        if (!zzc(obj, i, i2)) {
            return zze.zza();
        }
        Object object = zzb.getObject(obj, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    private final Object zza(Object obj, int i, Object obj2, zzame zzameVar, Object obj3) {
        zzajg zzd;
        int i2 = this.zzc[i];
        Object zze = zzamk.zze(obj, zzc(i) & 1048575);
        return (zze == null || (zzd = zzd(i)) == null) ? obj2 : zza(i, i2, this.zzs.zze(zze), zzd, obj2, zzameVar, obj3);
    }

    private static Field zza(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zza(int i, Object obj, zzana zzanaVar) throws IOException {
        if (obj instanceof String) {
            zzanaVar.zza(i, (String) obj);
        } else {
            zzanaVar.zza(i, (zzahp) obj);
        }
    }

    private static void zza(zzame zzameVar, Object obj, zzana zzanaVar) throws IOException {
        zzameVar.zzb(zzameVar.zzd(obj), zzanaVar);
    }

    private final void zza(zzana zzanaVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzanaVar.zza(i, this.zzs.zza(zzf(i2)), this.zzs.zzd(obj));
        }
    }

    private final void zza(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzc(i2) & 1048575, obj2);
        zzb(obj, i, i2);
    }

    private final void zza(Object obj, int i, zzalc zzalcVar) throws IOException {
        long j;
        String zzp;
        if (zzg(i)) {
            j = i & 1048575;
            zzp = zzalcVar.zzr();
        } else {
            int i2 = i & 1048575;
            if (this.zzi) {
                j = i2;
                zzp = zzalcVar.zzq();
            } else {
                j = i2;
                zzp = zzalcVar.zzp();
            }
        }
        zzamk.zza(obj, j, zzp);
    }

    private final void zza(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzc(i) & 1048575, obj2);
        zzb(obj, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x05b2 A[Catch: all -> 0x00ca, TryCatch #4 {all -> 0x00ca, blocks: (B:50:0x00c4, B:13:0x00d2, B:32:0x05ad, B:34:0x05b2, B:35:0x05b7, B:64:0x00fe, B:65:0x010b, B:68:0x0113, B:69:0x0120, B:70:0x0124, B:71:0x0132, B:72:0x0140, B:73:0x014e, B:75:0x0158, B:78:0x015f, B:79:0x0164, B:80:0x016e, B:81:0x017c, B:82:0x0186, B:83:0x0195, B:84:0x0199, B:85:0x01a8, B:86:0x01b7, B:87:0x01c6, B:88:0x01d5, B:89:0x01e4, B:90:0x01f3, B:91:0x0202, B:92:0x0211, B:94:0x0221, B:95:0x0242, B:96:0x022b, B:98:0x0233, B:99:0x0253, B:100:0x0265, B:101:0x0273, B:102:0x0281, B:103:0x028f), top: B:49:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x05bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x05e6 A[LOOP:3: B:55:0x05e2->B:57:0x05e6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x05fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r18, com.google.android.gms.internal.firebase-auth-api.zzalc r19, com.google.android.gms.internal.firebase-auth-api.zzaio r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzalc, com.google.android.gms.internal.firebase-auth-api.zzaio):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:281:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r24, com.google.android.gms.internal.firebase-auth-api.zzana r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzana):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakr.zza(java.lang.Object, java.lang.Object):void");
    }

    private final void zza(Object obj, Object obj2, int i) {
        if (zzc(obj2, i)) {
            long zzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(obj2));
            }
            zzalf zze = zze(i);
            if (!zzc(obj, i)) {
                if (zzg(object)) {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(obj, zzc, zza2);
                } else {
                    unsafe.putObject(obj, zzc, object);
                }
                zzb(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(obj, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    public final void zza(Object obj, byte[] bArr, int i, int i2, zzahk zzahkVar) throws IOException {
        zza(obj, bArr, i, i2, 0, zzahkVar);
    }

    private final boolean zza(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzc(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zza(Object obj, int i, zzalf zzalfVar) {
        return zzalfVar.zzd(zzamk.zze(obj, i & 1048575));
    }
}
