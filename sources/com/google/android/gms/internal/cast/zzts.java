package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzts implements zzua {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzvb.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final zztp zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int[] zzh;
    private final int zzi;
    private final zztd zzj;
    private final zzur zzk;
    private final zzrx zzl;
    private final zztu zzm;
    private final zztk zzn;

    private zzts(int[] iArr, Object[] objArr, int i, int i2, zztp zztpVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zztu zztuVar, zztd zztdVar, zzur zzurVar, zzrx zzrxVar, zztk zztkVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzg = z;
        boolean z3 = false;
        if (zzrxVar != null && zzrxVar.zzc(zztpVar)) {
            z3 = true;
        }
        this.zzf = z3;
        this.zzh = iArr2;
        this.zzi = i3;
        this.zzm = zztuVar;
        this.zzj = zztdVar;
        this.zzk = zzurVar;
        this.zzl = zzrxVar;
        this.zze = zztpVar;
        this.zzn = zztkVar;
    }

    private final boolean zzA(Object obj, int i) {
        int zzn = zzn(i);
        long j = zzn & 1048575;
        if (j != 1048575) {
            return (zzvb.zzc(obj, j) & (1 << (zzn >>> 20))) != 0;
        }
        int zzp = zzp(i);
        long j2 = zzp & 1048575;
        switch (zzo(zzp)) {
            case 0:
                return Double.doubleToRawLongBits(zzvb.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzvb.zzb(obj, j2)) != 0;
            case 2:
                return zzvb.zzd(obj, j2) != 0;
            case 3:
                return zzvb.zzd(obj, j2) != 0;
            case 4:
                return zzvb.zzc(obj, j2) != 0;
            case 5:
                return zzvb.zzd(obj, j2) != 0;
            case 6:
                return zzvb.zzc(obj, j2) != 0;
            case 7:
                return zzvb.zzw(obj, j2);
            case 8:
                Object zzf = zzvb.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzrm) {
                    return !zzrm.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzvb.zzf(obj, j2) != null;
            case 10:
                return !zzrm.zzb.equals(zzvb.zzf(obj, j2));
            case 11:
                return zzvb.zzc(obj, j2) != 0;
            case 12:
                return zzvb.zzc(obj, j2) != 0;
            case 13:
                return zzvb.zzc(obj, j2) != 0;
            case 14:
                return zzvb.zzd(obj, j2) != 0;
            case 15:
                return zzvb.zzc(obj, j2) != 0;
            case 16:
                return zzvb.zzd(obj, j2) != 0;
            case 17:
                return zzvb.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzB(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzA(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzC(Object obj, int i, zzua zzuaVar) {
        return zzuaVar.zzh(zzvb.zzf(obj, i & 1048575));
    }

    private static boolean zzD(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzsh) {
            return ((zzsh) obj).zzJ();
        }
        return true;
    }

    private final boolean zzE(Object obj, int i, int i2) {
        return zzvb.zzc(obj, (long) (zzn(i2) & 1048575)) == i;
    }

    private static boolean zzF(Object obj, long j) {
        return ((Boolean) zzvb.zzf(obj, j)).booleanValue();
    }

    private static final void zzG(int i, Object obj, zzvi zzviVar) throws IOException {
        if (obj instanceof String) {
            zzviVar.zzD(i, (String) obj);
        } else {
            zzviVar.zzd(i, (zzrm) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.cast.zzts zzi(java.lang.Class r32, com.google.android.gms.internal.cast.zztm r33, com.google.android.gms.internal.cast.zztu r34, com.google.android.gms.internal.cast.zztd r35, com.google.android.gms.internal.cast.zzur r36, com.google.android.gms.internal.cast.zzrx r37, com.google.android.gms.internal.cast.zztk r38) {
        /*
            Method dump skipped, instructions count: 1013
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzi(java.lang.Class, com.google.android.gms.internal.cast.zztm, com.google.android.gms.internal.cast.zztu, com.google.android.gms.internal.cast.zztd, com.google.android.gms.internal.cast.zzur, com.google.android.gms.internal.cast.zzrx, com.google.android.gms.internal.cast.zztk):com.google.android.gms.internal.cast.zzts");
    }

    private static double zzj(Object obj, long j) {
        return ((Double) zzvb.zzf(obj, j)).doubleValue();
    }

    private static float zzk(Object obj, long j) {
        return ((Float) zzvb.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
    
        r3 = com.google.android.gms.internal.cast.zzru.zzx(r11 << 3) + 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a2, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        r3 = com.google.android.gms.internal.cast.zzru.zzx(r11 << 3) + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b1, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b3, code lost:
    
        r4 = r11 << 3;
        r3 = com.google.android.gms.internal.cast.zzru.zzu(zzm(r16, r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013a, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0142, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014a, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014c, code lost:
    
        r3 = com.google.android.gms.internal.cast.zzru.zzy(zzq(r16, r3));
        r4 = com.google.android.gms.internal.cast.zzru.zzx(r11 << 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0160, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0167, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016f, code lost:
    
        if (zzE(r16, r11, r5) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x019a, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x019c, code lost:
    
        r4 = com.google.android.gms.internal.cast.zzru.zzx(r11 << 3) + com.google.android.gms.internal.cast.zzru.zzx(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b3, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01c0, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01cd, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01da, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e7, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01f6, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0203, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0210, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x021d, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x022b, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0239, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0247, code lost:
    
        if (r3 > 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0255, code lost:
    
        if (r3 > 0) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzl(java.lang.Object r16) {
        /*
            Method dump skipped, instructions count: 1254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzl(java.lang.Object):int");
    }

    private static int zzm(Object obj, long j) {
        return ((Integer) zzvb.zzf(obj, j)).intValue();
    }

    private final int zzn(int i) {
        return this.zzc[i + 2];
    }

    private static int zzo(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzp(int i) {
        return this.zzc[i + 1];
    }

    private static long zzq(Object obj, long j) {
        return ((Long) zzvb.zzf(obj, j)).longValue();
    }

    private final zzua zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzua zzuaVar = (zzua) this.zzd[i3];
        if (zzuaVar != null) {
            return zzuaVar;
        }
        zzua zzb2 = zztx.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzt(Class cls, String str) {
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

    private final void zzu(Object obj, Object obj2, int i) {
        if (zzA(obj2, i)) {
            int zzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzua zzr = zzr(i);
            if (!zzA(obj, i)) {
                if (zzD(object)) {
                    Object zzc = zzr.zzc();
                    zzr.zze(zzc, object);
                    unsafe.putObject(obj, j, zzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzw(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzD(object2)) {
                Object zzc2 = zzr.zzc();
                zzr.zze(zzc2, object2);
                unsafe.putObject(obj, j, zzc2);
                object2 = zzc2;
            }
            zzr.zze(object2, object);
        }
    }

    private final void zzv(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzE(obj2, i2, i)) {
            int zzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzua zzr = zzr(i);
            if (!zzE(obj, i2, i)) {
                if (zzD(object)) {
                    Object zzc = zzr.zzc();
                    zzr.zze(zzc, object);
                    unsafe.putObject(obj, j, zzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzx(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzD(object2)) {
                Object zzc2 = zzr.zzc();
                zzr.zze(zzc2, object2);
                unsafe.putObject(obj, j, zzc2);
                object2 = zzc2;
            }
            zzr.zze(object2, object);
        }
    }

    private final void zzw(Object obj, int i) {
        int zzn = zzn(i);
        long j = 1048575 & zzn;
        if (j == 1048575) {
            return;
        }
        zzvb.zzq(obj, j, (1 << (zzn >>> 20)) | zzvb.zzc(obj, j));
    }

    private final void zzx(Object obj, int i, int i2) {
        zzvb.zzq(obj, zzn(i2) & 1048575, i);
    }

    private final void zzy(zzvi zzviVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzz(Object obj, Object obj2, int i) {
        return zzA(obj, i) == zzA(obj2, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x035b, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.cast.zzrm) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0110, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.cast.zzrm) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0113, code lost:
    
        r5 = r6 << 3;
        r4 = com.google.android.gms.internal.cast.zzru.zzw((java.lang.String) r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 1092
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zza(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f9 A[PHI: r3
      0x00f9: PHI (r3v8 java.lang.Object) = (r3v5 java.lang.Object), (r3v9 java.lang.Object) binds: [B:84:0x0115, B:77:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzb(java.lang.Object):int");
    }

    public final Object zzc() {
        return ((zzsh) this.zze).zzw();
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
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzD(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.cast.zzsh
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.cast.zzsh r0 = (com.google.android.gms.internal.cast.zzsh) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzH(r2)
            r0.zza = r1
            r0.zzF()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L76
            int r2 = r7.zzp(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzo(r2)
            long r3 = (long) r3
            r5 = 9
            if (r2 == r5) goto L6c
            r5 = 60
            if (r2 == r5) goto L54
            r5 = 68
            if (r2 == r5) goto L54
            switch(r2) {
                case 17: goto L6c;
                case 18: goto L4e;
                case 19: goto L4e;
                case 20: goto L4e;
                case 21: goto L4e;
                case 22: goto L4e;
                case 23: goto L4e;
                case 24: goto L4e;
                case 25: goto L4e;
                case 26: goto L4e;
                case 27: goto L4e;
                case 28: goto L4e;
                case 29: goto L4e;
                case 30: goto L4e;
                case 31: goto L4e;
                case 32: goto L4e;
                case 33: goto L4e;
                case 34: goto L4e;
                case 35: goto L4e;
                case 36: goto L4e;
                case 37: goto L4e;
                case 38: goto L4e;
                case 39: goto L4e;
                case 40: goto L4e;
                case 41: goto L4e;
                case 42: goto L4e;
                case 43: goto L4e;
                case 44: goto L4e;
                case 45: goto L4e;
                case 46: goto L4e;
                case 47: goto L4e;
                case 48: goto L4e;
                case 49: goto L4e;
                case 50: goto L3c;
                default: goto L3b;
            }
        L3b:
            goto L73
        L3c:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.cast.zzts.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L73
            r6 = r5
            com.google.android.gms.internal.cast.zztj r6 = (com.google.android.gms.internal.cast.zztj) r6
            r6.zzb()
            r2.putObject(r8, r3, r5)
            goto L73
        L4e:
            com.google.android.gms.internal.cast.zztd r2 = r7.zzj
            r2.zza(r8, r3)
            goto L73
        L54:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzE(r8, r2, r1)
            if (r2 == 0) goto L73
        L5e:
            com.google.android.gms.internal.cast.zzua r2 = r7.zzr(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.cast.zzts.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzd(r3)
            goto L73
        L6c:
            boolean r2 = r7.zzA(r8, r1)
            if (r2 == 0) goto L73
            goto L5e
        L73:
            int r1 = r1 + 3
            goto L1d
        L76:
            com.google.android.gms.internal.cast.zzur r0 = r7.zzk
            r0.zze(r8)
            boolean r0 = r7.zzf
            if (r0 == 0) goto L84
            com.google.android.gms.internal.cast.zzrx r0 = r7.zzl
            r0.zzb(r8)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzd(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zze(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r17, com.google.android.gms.internal.cast.zzvi r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzf(java.lang.Object, com.google.android.gms.internal.cast.zzvi):void");
    }

    public final boolean zzg(Object obj, Object obj2) {
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzp = zzp(i);
            long j = zzp & 1048575;
            switch (zzo(zzp)) {
                case 0:
                    if (zzz(obj, obj2, i) && Double.doubleToLongBits(zzvb.zza(obj, j)) == Double.doubleToLongBits(zzvb.zza(obj2, j))) {
                        break;
                    }
                    return false;
                case 1:
                    if (zzz(obj, obj2, i) && Float.floatToIntBits(zzvb.zzb(obj, j)) == Float.floatToIntBits(zzvb.zzb(obj2, j))) {
                        break;
                    }
                    return false;
                case 2:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 3:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 4:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 5:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 6:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 7:
                    if (zzz(obj, obj2, i) && zzvb.zzw(obj, j) == zzvb.zzw(obj2, j)) {
                        break;
                    }
                    return false;
                case 8:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 9:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 10:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 11:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 12:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 13:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 14:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 15:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 16:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 17:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    if (!zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        return false;
                    }
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzn = zzn(i) & 1048575;
                    if (zzvb.zzc(obj, zzn) == zzvb.zzc(obj2, zzn) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        break;
                    }
                    return false;
            }
        }
        if (!this.zzk.zzc(obj).equals(this.zzk.zzc(obj2))) {
            return false;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzl.zza(obj);
        this.zzl.zza(obj2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzh(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzh(java.lang.Object):boolean");
    }
}
