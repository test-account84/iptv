package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzef implements zzeo {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzfp.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzec zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdq zzl;
    private final zzff zzm;
    private final zzce zzn;
    private final zzei zzo;
    private final zzdx zzp;

    private zzef(int[] iArr, Object[] objArr, int i, int i2, zzec zzecVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzei zzeiVar, zzdq zzdqVar, zzff zzffVar, zzce zzceVar, zzdx zzdxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzceVar != null && zzceVar.zzf(zzecVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzeiVar;
        this.zzl = zzdqVar;
        this.zzm = zzffVar;
        this.zzn = zzceVar;
        this.zzg = zzecVar;
        this.zzp = zzdxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzeo zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzeo zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzfp.zzq(obj, j, (1 << (zzp >>> 20)) | zzfp.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzfp.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzfp.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzfp.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzfp.zzb(obj, j2)) != 0;
            case 2:
                return zzfp.zzd(obj, j2) != 0;
            case 3:
                return zzfp.zzd(obj, j2) != 0;
            case 4:
                return zzfp.zzc(obj, j2) != 0;
            case 5:
                return zzfp.zzd(obj, j2) != 0;
            case 6:
                return zzfp.zzc(obj, j2) != 0;
            case 7:
                return zzfp.zzw(obj, j2);
            case 8:
                Object zzf = zzfp.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzbq) {
                    return !zzbq.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzfp.zzf(obj, j2) != null;
            case 10:
                return !zzbq.zzb.equals(zzfp.zzf(obj, j2));
            case 11:
                return zzfp.zzc(obj, j2) != 0;
            case 12:
                return zzfp.zzc(obj, j2) != 0;
            case 13:
                return zzfp.zzc(obj, j2) != 0;
            case 14:
                return zzfp.zzd(obj, j2) != 0;
            case 15:
                return zzfp.zzc(obj, j2) != 0;
            case 16:
                return zzfp.zzd(obj, j2) != 0;
            case 17:
                return zzfp.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzeo zzeoVar) {
        return zzeoVar.zzk(zzfp.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcs) {
            return ((zzcs) obj).zzw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzfp.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzfp.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzfx zzfxVar) throws IOException {
        if (obj instanceof String) {
            zzfxVar.zzG(i, (String) obj);
        } else {
            zzfxVar.zzd(i, (zzbq) obj);
        }
    }

    public static zzfg zzd(Object obj) {
        zzcs zzcsVar = (zzcs) obj;
        zzfg zzfgVar = zzcsVar.zzc;
        if (zzfgVar != zzfg.zzc()) {
            return zzfgVar;
        }
        zzfg zzf = zzfg.zzf();
        zzcsVar.zzc = zzf;
        return zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.play_billing.zzef zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzdz r34, com.google.android.gms.internal.play_billing.zzei r35, com.google.android.gms.internal.play_billing.zzdq r36, com.google.android.gms.internal.play_billing.zzff r37, com.google.android.gms.internal.play_billing.zzce r38, com.google.android.gms.internal.play_billing.zzdx r39) {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzdz, com.google.android.gms.internal.play_billing.zzei, com.google.android.gms.internal.play_billing.zzdq, com.google.android.gms.internal.play_billing.zzff, com.google.android.gms.internal.play_billing.zzce, com.google.android.gms.internal.play_billing.zzdx):com.google.android.gms.internal.play_billing.zzef");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzfp.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzfp.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzfp.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzfp.zzf(obj, j)).longValue();
    }

    private final zzcw zzu(int i) {
        int i2 = i / 3;
        return (zzcw) this.zzd[i2 + i2 + 1];
    }

    private final zzeo zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzeo zzeoVar = (zzeo) objArr[i3];
        if (zzeoVar != null) {
            return zzeoVar;
        }
        zzeo zzb2 = zzel.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzeo zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzeo zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Code restructure failed: missing block: B:278:0x0538, code lost:
    
        if ((r1 instanceof com.google.android.gms.internal.play_billing.zzbq) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012a, code lost:
    
        if ((r1 instanceof com.google.android.gms.internal.play_billing.zzbq) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012d, code lost:
    
        r0 = com.google.android.gms.internal.play_billing.zzby.zzw(r0);
        r1 = com.google.android.gms.internal.play_billing.zzby.zzv((java.lang.String) r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 1728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zza(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f5 A[PHI: r1 r2
      0x00f5: PHI (r1v14 int) = (r1v9 int), (r1v15 int) binds: [B:83:0x0111, B:76:0x00f3] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r2v10 java.lang.Object) = (r2v7 java.lang.Object), (r2v11 java.lang.Object) binds: [B:83:0x0111, B:76:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzb(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:180:0x0711, code lost:
    
        if (r3 == 0) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0713, code lost:
    
        r12.add(com.google.android.gms.internal.play_billing.zzbq.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0721, code lost:
    
        if (r2 >= r42) goto L672;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0723, code lost:
    
        r3 = com.google.android.gms.internal.play_billing.zzbd.zzh(r40, r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0729, code lost:
    
        if (r11 != r10.zza) goto L674;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x072b, code lost:
    
        r2 = com.google.android.gms.internal.play_billing.zzbd.zzh(r40, r3, r10);
        r3 = r10.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0731, code lost:
    
        if (r3 < 0) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0735, code lost:
    
        if (r3 > (r40.length - r2)) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0737, code lost:
    
        if (r3 != 0) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0719, code lost:
    
        r12.add(com.google.android.gms.internal.play_billing.zzbq.zzl(r40, r2, r3));
        r2 = r2 + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x073e, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0743, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0744, code lost:
    
        r3 = r38;
        r0 = r40;
        r7 = r10;
        r13 = r15;
        r15 = r1;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0721, code lost:
    
        r12.add(com.google.android.gms.internal.play_billing.zzbq.zzl(r40, r2, r3));
        r2 = r2 + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x08b5, code lost:
    
        if (r7.zzb != 0) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x08b7, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x08ba, code lost:
    
        r12.zze(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x08bd, code lost:
    
        if (r8 >= r42) goto L688;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x08bf, code lost:
    
        r9 = com.google.android.gms.internal.play_billing.zzbd.zzh(r0, r8, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x08c5, code lost:
    
        if (r3 != r7.zza) goto L687;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x08c7, code lost:
    
        r8 = com.google.android.gms.internal.play_billing.zzbd.zzk(r0, r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x08cf, code lost:
    
        if (r7.zzb == 0) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x08b9, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x08ba, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0df6, code lost:
    
        if (r0 == r11) goto L567;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0df8, code lost:
    
        r36.putInt(r7, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0dfe, code lost:
    
        r0 = r13.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0e02, code lost:
    
        if (r0 >= r13.zzk) goto L658;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0e04, code lost:
    
        r1 = r13.zzi;
        r3 = r13.zzc;
        r1 = r1[r0];
        r3 = r3[r1];
        r3 = com.google.android.gms.internal.play_billing.zzfp.zzf(r7, r13.zzs(r1) & r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0e16, code lost:
    
        if (r3 != null) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0e21, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0e1e, code lost:
    
        if (r13.zzu(r1) != null) goto L659;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0e23, code lost:
    
        r3 = (com.google.android.gms.internal.play_billing.zzdw) r3;
        r0 = (com.google.android.gms.internal.play_billing.zzdv) r13.zzw(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0e2b, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0e2c, code lost:
    
        if (r9 != 0) goto L584;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0e2e, code lost:
    
        if (r8 != r14) goto L582;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0e35, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0e3a, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0e36, code lost:
    
        if (r8 > r14) goto L587;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0e38, code lost:
    
        if (r2 != r9) goto L587;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0e3f, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0d6f  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0d83  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0ab6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0ace A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:593:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:693:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0dc2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0ab3 A[PHI: r0 r3 r7 r11 r13 r14 r15 r36
      0x0ab3: PHI (r0v72 byte[]) = (r0v28 byte[]), (r0v30 byte[]), (r0v32 byte[]), (r0v42 byte[]), (r0v56 byte[]), (r0v71 byte[]), (r0v76 byte[]) binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]
      0x0ab3: PHI (r3v114 com.google.android.gms.internal.play_billing.zzef) = 
      (r3v75 com.google.android.gms.internal.play_billing.zzef)
      (r3v76 com.google.android.gms.internal.play_billing.zzef)
      (r3v77 com.google.android.gms.internal.play_billing.zzef)
      (r3v85 com.google.android.gms.internal.play_billing.zzef)
      (r3v95 com.google.android.gms.internal.play_billing.zzef)
      (r3v109 com.google.android.gms.internal.play_billing.zzef)
      (r3v119 com.google.android.gms.internal.play_billing.zzef)
     binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]
      0x0ab3: PHI (r7v32 com.google.android.gms.internal.play_billing.zzbc) = 
      (r7v12 com.google.android.gms.internal.play_billing.zzbc)
      (r7v13 com.google.android.gms.internal.play_billing.zzbc)
      (r7v14 com.google.android.gms.internal.play_billing.zzbc)
      (r7v20 com.google.android.gms.internal.play_billing.zzbc)
      (r7v27 com.google.android.gms.internal.play_billing.zzbc)
      (r7v31 com.google.android.gms.internal.play_billing.zzbc)
      (r7v37 com.google.android.gms.internal.play_billing.zzbc)
     binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]
      0x0ab3: PHI (r11v72 int) = (r11v31 int), (r11v31 int), (r11v31 int), (r11v59 int), (r11v31 int), (r11v31 int), (r11v31 int) binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]
      0x0ab3: PHI (r13v96 int) = (r13v77 int), (r13v78 int), (r13v79 int), (r13v85 int), (r13v92 int), (r13v95 int), (r13v101 int) binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]
      0x0ab3: PHI (r14v100 int) = (r14v72 int), (r14v73 int), (r14v74 int), (r14v80 int), (r14v93 int), (r14v97 int), (r14v105 int) binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]
      0x0ab3: PHI (r15v40 int) = (r15v16 int), (r15v17 int), (r15v18 int), (r15v21 int), (r15v30 int), (r15v37 int), (r15v45 int) binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]
      0x0ab3: PHI (r36v29 sun.misc.Unsafe) = 
      (r36v8 sun.misc.Unsafe)
      (r36v9 sun.misc.Unsafe)
      (r36v10 sun.misc.Unsafe)
      (r36v16 sun.misc.Unsafe)
      (r36v22 sun.misc.Unsafe)
      (r36v26 sun.misc.Unsafe)
      (r36v32 sun.misc.Unsafe)
     binds: [B:409:0x0a85, B:390:0x0a29, B:370:0x09d9, B:281:0x0869, B:210:0x075d, B:117:0x05ec, B:95:0x058d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:304:0x0737 -> B:296:0x0713). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:335:0x07eb -> B:329:0x07ca). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:354:0x083f -> B:348:0x0816). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:394:0x08cf -> B:388:0x08b7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r39, byte[] r40, int r41, int r42, int r43, com.google.android.gms.internal.play_billing.zzbc r44) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzbc):int");
    }

    public final Object zze() {
        return ((zzcs) this.zzg).zzl();
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
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzL(r8)
            if (r0 != 0) goto L8
            goto L85
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.play_billing.zzcs
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r8
            com.google.android.gms.internal.play_billing.zzcs r0 = (com.google.android.gms.internal.play_billing.zzcs) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzu(r2)
            r0.zza = r1
            r0.zzs()
        L1b:
            int[] r0 = r7.zzc
        L1d:
            int r2 = r0.length
            if (r1 >= r2) goto L77
            int r2 = r7.zzs(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzr(r2)
            long r3 = (long) r3
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
            sun.misc.Unsafe r2 = com.google.android.gms.internal.play_billing.zzef.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L74
            r6 = r5
            com.google.android.gms.internal.play_billing.zzdw r6 = (com.google.android.gms.internal.play_billing.zzdw) r6
            r6.zzc()
            r2.putObject(r8, r3, r5)
            goto L74
        L4f:
            com.google.android.gms.internal.play_billing.zzdq r2 = r7.zzl
            r2.zza(r8, r3)
            goto L74
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzM(r8, r2, r1)
            if (r2 == 0) goto L74
        L5f:
            com.google.android.gms.internal.play_billing.zzeo r2 = r7.zzv(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.play_billing.zzef.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
            goto L74
        L6d:
            boolean r2 = r7.zzI(r8, r1)
            if (r2 == 0) goto L74
            goto L5f
        L74:
            int r1 = r1 + 3
            goto L1d
        L77:
            com.google.android.gms.internal.play_billing.zzff r0 = r7.zzm
            r0.zzg(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L85
            com.google.android.gms.internal.play_billing.zzce r0 = r7.zzn
            r0.zzd(r8)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzf(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzg(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzg(java.lang.Object, java.lang.Object):void");
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzbcVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r25, com.google.android.gms.internal.play_billing.zzfx r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2020
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzi(java.lang.Object, com.google.android.gms.internal.play_billing.zzfx):void");
    }

    public final boolean zzj(Object obj, Object obj2) {
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzfp.zza(obj, j)) == Double.doubleToLongBits(zzfp.zza(obj2, j))) {
                        break;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzfp.zzb(obj, j)) == Float.floatToIntBits(zzfp.zzb(obj2, j))) {
                        break;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzfp.zzd(obj, j) == zzfp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzfp.zzd(obj, j) == zzfp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzfp.zzc(obj, j) == zzfp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzfp.zzd(obj, j) == zzfp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzfp.zzc(obj, j) == zzfp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzfp.zzw(obj, j) == zzfp.zzw(obj2, j)) {
                        break;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzfp.zzc(obj, j) == zzfp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzfp.zzc(obj, j) == zzfp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzfp.zzc(obj, j) == zzfp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzfp.zzd(obj, j) == zzfp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzfp.zzc(obj, j) == zzfp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzfp.zzd(obj, j) == zzfp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
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
                    if (!zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
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
                    long zzp = zzp(i) & 1048575;
                    if (zzfp.zzc(obj, zzp) == zzfp.zzc(obj2, zzp) && zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzn.zzb(obj).equals(this.zzn.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzk(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzk(java.lang.Object):boolean");
    }
}
