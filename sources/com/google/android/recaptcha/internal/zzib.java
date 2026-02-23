package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzib implements zzil {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzjp.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhy zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzhm zzn;
    private final zzjf zzo;
    private final zzga zzp;
    private final zzie zzq;
    private final zzht zzr;

    private zzib(int[] iArr, Object[] objArr, int i, int i2, zzhy zzhyVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzie zzieVar, zzhm zzhmVar, zzjf zzjfVar, zzga zzgaVar, zzht zzhtVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhyVar instanceof zzgo;
        this.zzj = z;
        boolean z3 = false;
        if (zzgaVar != null && zzgaVar.zzj(zzhyVar)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzq = zzieVar;
        this.zzn = zzhmVar;
        this.zzo = zzjfVar;
        this.zzp = zzgaVar;
        this.zzg = zzhyVar;
        this.zzr = zzhtVar;
    }

    private static long zzA(Object obj, long j) {
        return ((Long) zzjp.zzf(obj, j)).longValue();
    }

    private final zzgs zzB(int i) {
        int i2 = i / 3;
        return (zzgs) this.zzd[i2 + i2 + 1];
    }

    private final zzil zzC(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzil zzilVar = (zzil) this.zzd[i3];
        if (zzilVar != null) {
            return zzilVar;
        }
        zzil zzb2 = zzih.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzD(Object obj, int i, Object obj2, zzjf zzjfVar, Object obj3) {
        int i2 = this.zzc[i];
        Object zzf = zzjp.zzf(obj, zzz(i) & 1048575);
        if (zzf == null || zzB(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzE(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzF(Object obj, int i) {
        zzil zzC = zzC(i);
        int zzz = zzz(i) & 1048575;
        if (!zzT(obj, i)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, zzz);
        if (zzW(object)) {
            return object;
        }
        Object zze = zzC.zze();
        if (object != null) {
            zzC.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzG(Object obj, int i, int i2) {
        zzil zzC = zzC(i2);
        if (!zzX(obj, i, i2)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, zzz(i2) & 1048575);
        if (zzW(object)) {
            return object;
        }
        Object zze = zzC.zze();
        if (object != null) {
            zzC.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzH(Class cls, String str) {
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

    private static void zzI(Object obj) {
        if (!zzW(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzJ(Object obj, Object obj2, int i) {
        if (zzT(obj2, i)) {
            int zzz = zzz(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzz;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzil zzC = zzC(i);
            if (!zzT(obj, i)) {
                if (zzW(object)) {
                    Object zze = zzC.zze();
                    zzC.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzM(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzW(object2)) {
                Object zze2 = zzC.zze();
                zzC.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzC.zzg(object2, object);
        }
    }

    private final void zzK(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzX(obj2, i2, i)) {
            int zzz = zzz(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzz;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzil zzC = zzC(i);
            if (!zzX(obj, i2, i)) {
                if (zzW(object)) {
                    Object zze = zzC.zze();
                    zzC.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzN(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzW(object2)) {
                Object zze2 = zzC.zze();
                zzC.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzC.zzg(object2, object);
        }
    }

    private final void zzL(Object obj, int i, zzik zzikVar) throws IOException {
        int i2;
        String zzr;
        if (zzS(i)) {
            i2 = i & 1048575;
            zzr = zzikVar.zzs();
        } else {
            i2 = i & 1048575;
            zzr = this.zzi ? zzikVar.zzr() : zzikVar.zzp();
        }
        zzjp.zzs(obj, i2, zzr);
    }

    private final void zzM(Object obj, int i) {
        int zzw = zzw(i);
        long j = 1048575 & zzw;
        if (j == 1048575) {
            return;
        }
        zzjp.zzq(obj, j, (1 << (zzw >>> 20)) | zzjp.zzc(obj, j));
    }

    private final void zzN(Object obj, int i, int i2) {
        zzjp.zzq(obj, zzw(i2) & 1048575, i);
    }

    private final void zzO(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzz(i) & 1048575, obj2);
        zzM(obj, i);
    }

    private final void zzP(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzz(i2) & 1048575, obj2);
        zzN(obj, i, i2);
    }

    private final void zzQ(zzjx zzjxVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzR(Object obj, Object obj2, int i) {
        return zzT(obj, i) == zzT(obj2, i);
    }

    private static boolean zzS(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzT(Object obj, int i) {
        int zzw = zzw(i);
        long j = zzw & 1048575;
        if (j != 1048575) {
            return (zzjp.zzc(obj, j) & (1 << (zzw >>> 20))) != 0;
        }
        int zzz = zzz(i);
        long j2 = zzz & 1048575;
        switch (zzy(zzz)) {
            case 0:
                return Double.doubleToRawLongBits(zzjp.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzjp.zzb(obj, j2)) != 0;
            case 2:
                return zzjp.zzd(obj, j2) != 0;
            case 3:
                return zzjp.zzd(obj, j2) != 0;
            case 4:
                return zzjp.zzc(obj, j2) != 0;
            case 5:
                return zzjp.zzd(obj, j2) != 0;
            case 6:
                return zzjp.zzc(obj, j2) != 0;
            case 7:
                return zzjp.zzw(obj, j2);
            case 8:
                Object zzf = zzjp.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzez) {
                    return !zzez.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzjp.zzf(obj, j2) != null;
            case 10:
                return !zzez.zzb.equals(zzjp.zzf(obj, j2));
            case 11:
                return zzjp.zzc(obj, j2) != 0;
            case 12:
                return zzjp.zzc(obj, j2) != 0;
            case 13:
                return zzjp.zzc(obj, j2) != 0;
            case 14:
                return zzjp.zzd(obj, j2) != 0;
            case 15:
                return zzjp.zzc(obj, j2) != 0;
            case 16:
                return zzjp.zzd(obj, j2) != 0;
            case 17:
                return zzjp.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzU(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzT(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzV(Object obj, int i, zzil zzilVar) {
        return zzilVar.zzl(zzjp.zzf(obj, i & 1048575));
    }

    private static boolean zzW(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgo) {
            return ((zzgo) obj).zzF();
        }
        return true;
    }

    private final boolean zzX(Object obj, int i, int i2) {
        return zzjp.zzc(obj, (long) (zzw(i2) & 1048575)) == i;
    }

    private static boolean zzY(Object obj, long j) {
        return ((Boolean) zzjp.zzf(obj, j)).booleanValue();
    }

    private static final void zzZ(int i, Object obj, zzjx zzjxVar) throws IOException {
        if (obj instanceof String) {
            zzjxVar.zzG(i, (String) obj);
        } else {
            zzjxVar.zzd(i, (zzez) obj);
        }
    }

    public static zzjg zzd(Object obj) {
        zzgo zzgoVar = (zzgo) obj;
        zzjg zzjgVar = zzgoVar.zzc;
        if (zzjgVar != zzjg.zzc()) {
            return zzjgVar;
        }
        zzjg zzf = zzjg.zzf();
        zzgoVar.zzc = zzf;
        return zzf;
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
    public static com.google.android.recaptcha.internal.zzib zzm(java.lang.Class r32, com.google.android.recaptcha.internal.zzhv r33, com.google.android.recaptcha.internal.zzie r34, com.google.android.recaptcha.internal.zzhm r35, com.google.android.recaptcha.internal.zzjf r36, com.google.android.recaptcha.internal.zzga r37, com.google.android.recaptcha.internal.zzht r38) {
        /*
            Method dump skipped, instructions count: 1013
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzm(java.lang.Class, com.google.android.recaptcha.internal.zzhv, com.google.android.recaptcha.internal.zzie, com.google.android.recaptcha.internal.zzhm, com.google.android.recaptcha.internal.zzjf, com.google.android.recaptcha.internal.zzga, com.google.android.recaptcha.internal.zzht):com.google.android.recaptcha.internal.zzib");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzjp.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzjp.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:185:0x034c, code lost:
    
        if ((r10 instanceof com.google.android.recaptcha.internal.zzez) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0117, code lost:
    
        if ((r10 instanceof com.google.android.recaptcha.internal.zzez) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011a, code lost:
    
        r11 = r12 << 3;
        r10 = com.google.android.recaptcha.internal.zzfk.zzx((java.lang.String) r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzp(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 1138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzp(java.lang.Object):int");
    }

    private static int zzq(Object obj, long j) {
        return ((Integer) zzjp.zzf(obj, j)).intValue();
    }

    private final int zzr(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzem zzemVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzE = zzE(i3);
        Object object = unsafe.getObject(obj, j);
        if (zzht.zzb(object)) {
            zzhs zzb2 = zzhs.zza().zzb();
            zzht.zzc(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        throw null;
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzem zzemVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzen.zzq(bArr, i))));
                    int i9 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i9;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzen.zzb(bArr, i))));
                    int i10 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int zzm = zzen.zzm(bArr, i, zzemVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzemVar.zzb));
                    unsafe.putInt(obj, j2, i4);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int zzj = zzen.zzj(bArr, i, zzemVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzemVar.zza));
                    unsafe.putInt(obj, j2, i4);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(zzen.zzq(bArr, i)));
                    int i11 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(zzen.zzb(bArr, i)));
                    int i12 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i12;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int zzm2 = zzen.zzm(bArr, i, zzemVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(zzemVar.zzb != 0));
                    unsafe.putInt(obj, j2, i4);
                    return zzm2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int zzj2 = zzen.zzj(bArr, i, zzemVar);
                    int i13 = zzemVar.zza;
                    if (i13 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !zzju.zzf(bArr, zzj2, zzj2 + i13)) {
                            throw zzgy.zzd();
                        }
                        unsafe.putObject(obj, j, new String(bArr, zzj2, i13, zzgw.zzb));
                        zzj2 += i13;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return zzj2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    Object zzG = zzG(obj, i4, i8);
                    int zzo = zzen.zzo(zzG, zzC(i8), bArr, i, i2, zzemVar);
                    zzP(obj, i4, i8, zzG);
                    return zzo;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int zza2 = zzen.zza(bArr, i, zzemVar);
                    unsafe.putObject(obj, j, zzemVar.zzc);
                    unsafe.putInt(obj, j2, i4);
                    return zza2;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int zzj3 = zzen.zzj(bArr, i, zzemVar);
                    int i14 = zzemVar.zza;
                    zzgs zzB = zzB(i8);
                    if (zzB == null || zzB.zza()) {
                        unsafe.putObject(obj, j, Integer.valueOf(i14));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        zzd(obj).zzj(i3, Long.valueOf(i14));
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int zzj4 = zzen.zzj(bArr, i, zzemVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzff.zzF(zzemVar.zza)));
                    unsafe.putInt(obj, j2, i4);
                    return zzj4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int zzm3 = zzen.zzm(bArr, i, zzemVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzff.zzG(zzemVar.zzb)));
                    unsafe.putInt(obj, j2, i4);
                    return zzm3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    Object zzG2 = zzG(obj, i4, i8);
                    int zzn = zzen.zzn(zzG2, zzC(i8), bArr, i, i2, (i3 & (-8)) | 4, zzemVar);
                    zzP(obj, i4, i8, zzG2);
                    return zzn;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x0268, code lost:
    
        if (r29.zzb != 0) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x026a, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x026d, code lost:
    
        r12.zze(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0270, code lost:
    
        if (r4 >= r19) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0272, code lost:
    
        r6 = com.google.android.recaptcha.internal.zzen.zzj(r17, r4, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0278, code lost:
    
        if (r20 == r29.zza) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x027b, code lost:
    
        r4 = com.google.android.recaptcha.internal.zzen.zzm(r17, r6, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0283, code lost:
    
        if (r29.zzb == 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x026c, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0286, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x026d, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0136, code lost:
    
        if (r4 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0138, code lost:
    
        r12.add(com.google.android.recaptcha.internal.zzez.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0146, code lost:
    
        if (r1 >= r19) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0148, code lost:
    
        r4 = com.google.android.recaptcha.internal.zzen.zzj(r17, r1, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x014e, code lost:
    
        if (r20 == r29.zza) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0151, code lost:
    
        r1 = com.google.android.recaptcha.internal.zzen.zzj(r17, r4, r29);
        r4 = r29.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0157, code lost:
    
        if (r4 < 0) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015b, code lost:
    
        if (r4 > (r17.length - r1)) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015d, code lost:
    
        if (r4 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013e, code lost:
    
        r12.add(com.google.android.recaptcha.internal.zzez.zzm(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0164, code lost:
    
        throw com.google.android.recaptcha.internal.zzgy.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0169, code lost:
    
        throw com.google.android.recaptcha.internal.zzgy.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x016a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0146, code lost:
    
        r12.add(com.google.android.recaptcha.internal.zzez.zzm(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01fd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x020d -> B:107:0x01e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:150:0x0283 -> B:144:0x026a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x015d -> B:62:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01c6 -> B:90:0x01a5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzt(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.recaptcha.internal.zzem r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1058
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.recaptcha.internal.zzem):int");
    }

    private final int zzu(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzx(i, 0);
    }

    private final int zzv(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzx(i, i2);
    }

    private final int zzw(int i) {
        return this.zzc[i + 2];
    }

    private final int zzx(int i, int i2) {
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

    private static int zzy(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzz(int i) {
        return this.zzc[i + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x035b, code lost:
    
        if ((r4 instanceof com.google.android.recaptcha.internal.zzez) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0110, code lost:
    
        if ((r4 instanceof com.google.android.recaptcha.internal.zzez) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0113, code lost:
    
        r5 = r6 << 3;
        r4 = com.google.android.recaptcha.internal.zzfk.zzx((java.lang.String) r4);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zza(java.lang.Object):int");
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
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzb(java.lang.Object):int");
    }

    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzem zzemVar) throws IOException {
        Unsafe unsafe;
        Object obj2;
        zzib zzibVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Object obj3;
        byte[] bArr2;
        int i12;
        zzem zzemVar2;
        long j;
        int i13;
        int i14;
        byte[] bArr3;
        int i15;
        int i16;
        Unsafe unsafe2;
        int i17;
        long j2;
        int zzm;
        Unsafe unsafe3;
        Object obj4;
        long j3;
        long j4;
        int i18;
        Unsafe unsafe4;
        int i19;
        zzib zzibVar2 = this;
        Object obj5 = obj;
        byte[] bArr4 = bArr;
        int i20 = i2;
        int i21 = i3;
        zzem zzemVar3 = zzemVar;
        int i22 = 3;
        zzI(obj);
        Unsafe unsafe5 = zzb;
        int i23 = -1;
        int i24 = i;
        int i25 = -1;
        int i26 = 0;
        int i27 = 1048575;
        int i28 = 0;
        int i29 = 0;
        while (true) {
            if (i24 < i20) {
                int i30 = i24 + 1;
                int i31 = bArr4[i24];
                if (i31 < 0) {
                    i30 = zzen.zzk(i31, bArr4, i30, zzemVar3);
                    i31 = zzemVar3.zza;
                }
                int i32 = i31 >>> 3;
                int zzv = i32 > i25 ? zzibVar2.zzv(i32, i26 / i22) : zzibVar2.zzu(i32);
                if (zzv == i23) {
                    i8 = i27;
                    i9 = i32;
                    unsafe = unsafe5;
                    i10 = i30;
                    i4 = i21;
                    i11 = 0;
                    i7 = i31;
                } else {
                    int i33 = i31 & 7;
                    int[] iArr = zzibVar2.zzc;
                    int i34 = iArr[zzv + 1];
                    int zzy = zzy(i34);
                    int i35 = i31;
                    long j5 = i34 & 1048575;
                    if (zzy <= 17) {
                        int i36 = iArr[zzv + 2];
                        int i37 = 1 << (i36 >>> 20);
                        int i38 = i36 & 1048575;
                        if (i38 != i27) {
                            if (i27 != 1048575) {
                                unsafe5.putInt(obj5, i27, i28);
                            }
                            i14 = i38;
                            i28 = unsafe5.getInt(obj5, i38);
                        } else {
                            i14 = i27;
                        }
                        switch (zzy) {
                            case 0:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                if (i33 == 1) {
                                    zzjp.zzo(obj5, j5, Double.longBitsToDouble(zzen.zzq(bArr3, i30)));
                                    i24 = i30 + 8;
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 1:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                if (i33 == 5) {
                                    zzjp.zzp(obj5, j5, Float.intBitsToFloat(zzen.zzb(bArr3, i30)));
                                    i24 = i30 + 4;
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                j2 = j5;
                                if (i33 == 0) {
                                    zzm = zzen.zzm(bArr3, i30, zzemVar3);
                                    unsafe3 = unsafe2;
                                    obj4 = obj;
                                    j3 = zzemVar3.zzb;
                                    unsafe3.putLong(obj4, j2, j3);
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i24 = zzm;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 4:
                            case 11:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                j4 = j5;
                                if (i33 == 0) {
                                    i24 = zzen.zzj(bArr3, i30, zzemVar3);
                                    i18 = zzemVar3.zza;
                                    unsafe2.putInt(obj5, j4, i18);
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 5:
                            case 14:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe4 = unsafe5;
                                i17 = i32;
                                if (i33 == 1) {
                                    unsafe2 = unsafe4;
                                    unsafe4.putLong(obj, j5, zzen.zzq(bArr3, i30));
                                    i24 = i30 + 8;
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                unsafe2 = unsafe4;
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 6:
                            case 13:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe4 = unsafe5;
                                i17 = i32;
                                if (i33 == 5) {
                                    unsafe4.putInt(obj5, j5, zzen.zzb(bArr3, i30));
                                    i24 = i30 + 4;
                                    i28 |= i37;
                                    i25 = i17;
                                    i27 = i14;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    unsafe5 = unsafe4;
                                    i26 = i16;
                                    bArr4 = bArr3;
                                    break;
                                }
                                unsafe2 = unsafe4;
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 7:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe4 = unsafe5;
                                i17 = i32;
                                if (i33 == 0) {
                                    int zzm2 = zzen.zzm(bArr3, i30, zzemVar3);
                                    zzjp.zzm(obj5, j5, zzemVar3.zzb != 0);
                                    i28 |= i37;
                                    i24 = zzm2;
                                    i25 = i17;
                                    i27 = i14;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    unsafe5 = unsafe4;
                                    i26 = i16;
                                    bArr4 = bArr3;
                                    break;
                                }
                                unsafe2 = unsafe4;
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 8:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe4 = unsafe5;
                                i17 = i32;
                                if (i33 == 2) {
                                    i24 = (536870912 & i34) == 0 ? zzen.zzg(bArr3, i30, zzemVar3) : zzen.zzh(bArr3, i30, zzemVar3);
                                    unsafe4.putObject(obj5, j5, zzemVar3.zzc);
                                    i28 |= i37;
                                    i25 = i17;
                                    i27 = i14;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    unsafe5 = unsafe4;
                                    i26 = i16;
                                    bArr4 = bArr3;
                                    break;
                                }
                                unsafe2 = unsafe4;
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 9:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                if (i33 == 2) {
                                    Object zzF = zzibVar2.zzF(obj5, i16);
                                    i24 = zzen.zzo(zzF, zzibVar2.zzC(i16), bArr, i30, i2, zzemVar);
                                    zzibVar2.zzO(obj5, i16, zzF);
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 10:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                if (i33 == 2) {
                                    int zza2 = zzen.zza(bArr3, i30, zzemVar3);
                                    unsafe2.putObject(obj5, j5, zzemVar3.zzc);
                                    i28 |= i37;
                                    i24 = zza2;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 12:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                j4 = j5;
                                if (i33 == 0) {
                                    i24 = zzen.zzj(bArr3, i30, zzemVar3);
                                    i18 = zzemVar3.zza;
                                    zzgs zzB = zzibVar2.zzB(i16);
                                    if (zzB != null && !zzB.zza()) {
                                        zzd(obj).zzj(i15, Long.valueOf(i18));
                                        i25 = i17;
                                        unsafe5 = unsafe2;
                                        i27 = i14;
                                        i26 = i16;
                                        i29 = i15;
                                        i23 = -1;
                                        i22 = 3;
                                        i20 = i2;
                                        i21 = i3;
                                        bArr4 = bArr3;
                                        break;
                                    }
                                    unsafe2.putInt(obj5, j4, i18);
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 15:
                                bArr3 = bArr;
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                j4 = j5;
                                if (i33 == 0) {
                                    i24 = zzen.zzj(bArr3, i30, zzemVar3);
                                    i18 = zzff.zzF(zzemVar3.zza);
                                    unsafe2.putInt(obj5, j4, i18);
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            case 16:
                                i15 = i35;
                                i16 = zzv;
                                unsafe2 = unsafe5;
                                i17 = i32;
                                bArr3 = bArr;
                                if (i33 == 0) {
                                    j2 = j5;
                                    zzm = zzen.zzm(bArr3, i30, zzemVar3);
                                    j3 = zzff.zzG(zzemVar3.zzb);
                                    unsafe3 = unsafe2;
                                    obj4 = obj;
                                    unsafe3.putLong(obj4, j2, j3);
                                    i28 |= i37;
                                    i25 = i17;
                                    unsafe5 = unsafe2;
                                    i24 = zzm;
                                    i27 = i14;
                                    i26 = i16;
                                    i29 = i15;
                                    i23 = -1;
                                    i22 = 3;
                                    i20 = i2;
                                    i21 = i3;
                                    bArr4 = bArr3;
                                    break;
                                }
                                i4 = i3;
                                i9 = i17;
                                unsafe = unsafe2;
                                i10 = i30;
                                i8 = i14;
                                i11 = i16;
                                i7 = i15;
                                break;
                            default:
                                if (i33 == 3) {
                                    Object zzF2 = zzibVar2.zzF(obj5, zzv);
                                    i24 = zzen.zzn(zzF2, zzibVar2.zzC(zzv), bArr, i30, i2, (i32 << 3) | 4, zzemVar);
                                    zzibVar2.zzO(obj5, zzv, zzF2);
                                    i28 |= i37;
                                    unsafe5 = unsafe5;
                                    i25 = i32;
                                    i27 = i14;
                                    i26 = zzv;
                                    i29 = i35;
                                    i23 = -1;
                                    i22 = 3;
                                    bArr4 = bArr;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                } else {
                                    i15 = i35;
                                    i16 = zzv;
                                    unsafe2 = unsafe5;
                                    i17 = i32;
                                    i4 = i3;
                                    i9 = i17;
                                    unsafe = unsafe2;
                                    i10 = i30;
                                    i8 = i14;
                                    i11 = i16;
                                    i7 = i15;
                                    break;
                                }
                        }
                    } else {
                        Unsafe unsafe6 = unsafe5;
                        if (zzy != 27) {
                            i8 = i27;
                            if (zzy <= 49) {
                                i9 = i32;
                                int i39 = i30;
                                i4 = i3;
                                i11 = zzv;
                                i29 = i35;
                                unsafe = unsafe6;
                                i24 = zzt(obj, bArr, i30, i2, i35, i9, i33, zzv, i34, zzy, j5, zzemVar);
                                if (i24 != i39) {
                                    obj5 = obj;
                                    bArr4 = bArr;
                                    i25 = i9;
                                    i20 = i2;
                                    zzemVar3 = zzemVar;
                                    i21 = i4;
                                    i27 = i8;
                                    i26 = i11;
                                    unsafe5 = unsafe;
                                    i23 = -1;
                                    i22 = 3;
                                    zzibVar2 = this;
                                } else {
                                    i10 = i24;
                                    i7 = i29;
                                }
                            } else {
                                i4 = i3;
                                i9 = i32;
                                i19 = i30;
                                unsafe = unsafe6;
                                i11 = zzv;
                                i29 = i35;
                                if (zzy != 50) {
                                    i24 = zzs(obj, bArr, i19, i2, i29, i9, i33, i34, zzy, j5, i11, zzemVar);
                                    if (i24 == i19) {
                                        i10 = i24;
                                        i7 = i29;
                                    }
                                } else if (i33 == 2) {
                                    i24 = zzr(obj, bArr, i19, i2, i11, j5, zzemVar);
                                    if (i24 == i19) {
                                        i10 = i24;
                                        i7 = i29;
                                    }
                                }
                                obj5 = obj;
                                bArr4 = bArr;
                                i25 = i9;
                                i20 = i2;
                                zzemVar3 = zzemVar;
                                i21 = i4;
                                i27 = i8;
                                i26 = i11;
                                unsafe5 = unsafe;
                                i23 = -1;
                                i22 = 3;
                                zzibVar2 = this;
                            }
                        } else if (i33 == 2) {
                            zzgv zzgvVar = (zzgv) unsafe6.getObject(obj5, j5);
                            if (!zzgvVar.zzc()) {
                                int size = zzgvVar.size();
                                zzgvVar = zzgvVar.zzd(size == 0 ? 10 : size + size);
                                unsafe6.putObject(obj5, j5, zzgvVar);
                            }
                            i24 = zzen.zze(zzibVar2.zzC(zzv), i35, bArr, i30, i2, zzgvVar, zzemVar);
                            i25 = i32;
                            unsafe5 = unsafe6;
                            i26 = zzv;
                            i29 = i35;
                            i27 = i27;
                            i23 = -1;
                            i22 = 3;
                            bArr4 = bArr;
                            i20 = i2;
                            i21 = i3;
                        } else {
                            i8 = i27;
                            i4 = i3;
                            i9 = i32;
                            i19 = i30;
                            unsafe = unsafe6;
                            i11 = zzv;
                            i29 = i35;
                        }
                        i10 = i19;
                        i7 = i29;
                    }
                }
                if (i7 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzemVar2 = zzemVar;
                        zzfz zzfzVar = zzemVar2.zzd;
                        if (zzfzVar != zzfz.zza) {
                            i12 = i9;
                            zzgm zza3 = zzfzVar.zza(this.zzg, i12);
                            if (zza3 != null) {
                                obj3 = obj;
                                zzgk zzgkVar = (zzgk) obj3;
                                zzgkVar.zzi();
                                zzge zzgeVar = zzgkVar.zzb;
                                zzjv zzjvVar = zza3.zzb.zzb;
                                Object obj6 = null;
                                if (zzjvVar == zzjv.zzn) {
                                    zzen.zzj(bArr, i10, zzemVar2);
                                    throw null;
                                }
                                switch (zzjvVar.ordinal()) {
                                    case 0:
                                        bArr2 = bArr;
                                        obj6 = Double.valueOf(Double.longBitsToDouble(zzen.zzq(bArr2, i10)));
                                        i10 += 8;
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 1:
                                        bArr2 = bArr;
                                        obj6 = Float.valueOf(Float.intBitsToFloat(zzen.zzb(bArr2, i10)));
                                        i10 += 4;
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 2:
                                    case 3:
                                        bArr2 = bArr;
                                        i10 = zzen.zzm(bArr2, i10, zzemVar2);
                                        j = zzemVar2.zzb;
                                        obj6 = Long.valueOf(j);
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 4:
                                    case 12:
                                        bArr2 = bArr;
                                        i10 = zzen.zzj(bArr2, i10, zzemVar2);
                                        i13 = zzemVar2.zza;
                                        obj6 = Integer.valueOf(i13);
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 5:
                                    case 15:
                                        bArr2 = bArr;
                                        obj6 = Long.valueOf(zzen.zzq(bArr2, i10));
                                        i10 += 8;
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 6:
                                    case 14:
                                        bArr2 = bArr;
                                        obj6 = Integer.valueOf(zzen.zzb(bArr2, i10));
                                        i10 += 4;
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 7:
                                        bArr2 = bArr;
                                        i10 = zzen.zzm(bArr2, i10, zzemVar2);
                                        obj6 = Boolean.valueOf(zzemVar2.zzb != 0);
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 8:
                                        bArr2 = bArr;
                                        i10 = zzen.zzg(bArr2, i10, zzemVar2);
                                        obj6 = zzemVar2.zzc;
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 9:
                                        int i40 = zzih.zza;
                                        throw null;
                                    case 10:
                                        int i41 = zzih.zza;
                                        throw null;
                                    case 11:
                                        bArr2 = bArr;
                                        i10 = zzen.zza(bArr2, i10, zzemVar2);
                                        obj6 = zzemVar2.zzc;
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 13:
                                        throw new IllegalStateException("Shouldn't reach here.");
                                    case 16:
                                        bArr2 = bArr;
                                        i10 = zzen.zzj(bArr2, i10, zzemVar2);
                                        i13 = zzff.zzF(zzemVar2.zza);
                                        obj6 = Integer.valueOf(i13);
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    case 17:
                                        bArr2 = bArr;
                                        i10 = zzen.zzm(bArr2, i10, zzemVar2);
                                        j = zzff.zzG(zzemVar2.zzb);
                                        obj6 = Long.valueOf(j);
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                    default:
                                        bArr2 = bArr;
                                        zzgeVar.zzi(zza3.zzb, obj6);
                                        i24 = i10;
                                        break;
                                }
                            } else {
                                i24 = zzen.zzi(i7, bArr, i10, i2, zzd(obj), zzemVar);
                                obj3 = obj;
                                bArr2 = bArr;
                            }
                            i20 = i2;
                            i25 = i12;
                            obj5 = obj3;
                            i29 = i7;
                            bArr4 = bArr2;
                            i21 = i4;
                            i27 = i8;
                            i26 = i11;
                            i23 = -1;
                            i22 = 3;
                            zzibVar2 = this;
                            zzemVar3 = zzemVar2;
                            unsafe5 = unsafe;
                        } else {
                            obj3 = obj;
                            bArr2 = bArr;
                            i12 = i9;
                        }
                    } else {
                        obj3 = obj;
                        bArr2 = bArr;
                        i12 = i9;
                        zzemVar2 = zzemVar;
                    }
                    i24 = zzen.zzi(i7, bArr, i10, i2, zzd(obj), zzemVar);
                    i20 = i2;
                    i25 = i12;
                    obj5 = obj3;
                    i29 = i7;
                    bArr4 = bArr2;
                    i21 = i4;
                    i27 = i8;
                    i26 = i11;
                    i23 = -1;
                    i22 = 3;
                    zzibVar2 = this;
                    zzemVar3 = zzemVar2;
                    unsafe5 = unsafe;
                } else {
                    zzibVar = this;
                    obj2 = obj;
                    i5 = i10;
                    i6 = i28;
                    i27 = i8;
                }
            } else {
                unsafe = unsafe5;
                obj2 = obj5;
                zzibVar = zzibVar2;
                i4 = i21;
                i5 = i24;
                i6 = i28;
                i7 = i29;
            }
        }
        if (i27 != 1048575) {
            unsafe.putInt(obj2, i27, i6);
        }
        for (int i42 = zzibVar.zzl; i42 < zzibVar.zzm; i42++) {
            zzD(obj, zzibVar.zzk[i42], null, zzibVar.zzo, obj);
        }
        if (i4 == 0) {
            if (i5 != i2) {
                throw zzgy.zzg();
            }
        } else if (i5 > i2 || i7 != i4) {
            throw zzgy.zzg();
        }
        return i5;
    }

    public final Object zze() {
        return ((zzgo) this.zzg).zzs();
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
    public final void zzf(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzW(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzgo
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.recaptcha.internal.zzgo r0 = (com.google.android.recaptcha.internal.zzgo) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzD(r2)
            r0.zza = r1
            r0.zzB()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L76
            int r2 = r7.zzz(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzy(r2)
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
            sun.misc.Unsafe r2 = com.google.android.recaptcha.internal.zzib.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L73
            r6 = r5
            com.google.android.recaptcha.internal.zzhs r6 = (com.google.android.recaptcha.internal.zzhs) r6
            r6.zzc()
            r2.putObject(r8, r3, r5)
            goto L73
        L4e:
            com.google.android.recaptcha.internal.zzhm r2 = r7.zzn
            r2.zzb(r8, r3)
            goto L73
        L54:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzX(r8, r2, r1)
            if (r2 == 0) goto L73
        L5e:
            com.google.android.recaptcha.internal.zzil r2 = r7.zzC(r1)
            sun.misc.Unsafe r5 = com.google.android.recaptcha.internal.zzib.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
            goto L73
        L6c:
            boolean r2 = r7.zzT(r8, r1)
            if (r2 == 0) goto L73
            goto L5e
        L73:
            int r1 = r1 + 3
            goto L1d
        L76:
            com.google.android.recaptcha.internal.zzjf r0 = r7.zzo
            r0.zzm(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L84
            com.google.android.recaptcha.internal.zzga r0 = r7.zzp
            r0.zzf(r8)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzf(java.lang.Object):void");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzg(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x05da A[LOOP:2: B:36:0x05d6->B:38:0x05da, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x05aa A[Catch: all -> 0x0108, TryCatch #2 {all -> 0x0108, blocks: (B:16:0x00e0, B:45:0x05a5, B:47:0x05aa, B:48:0x05af, B:107:0x02b9, B:110:0x02c2, B:111:0x02ce, B:112:0x02d2, B:113:0x02de, B:114:0x02e2, B:115:0x02ee, B:116:0x02f2, B:117:0x02fe, B:118:0x0302, B:119:0x030e, B:120:0x0312, B:121:0x031e, B:122:0x0322, B:123:0x032e, B:124:0x0332, B:125:0x033e, B:126:0x0343, B:127:0x034f, B:128:0x0354, B:129:0x0365, B:130:0x0376, B:131:0x0387, B:132:0x0398, B:133:0x03b4, B:134:0x03c2, B:135:0x03d3, B:136:0x03e8, B:138:0x03f1, B:139:0x0403, B:140:0x0415, B:141:0x0423, B:142:0x0431, B:143:0x043f, B:144:0x044d, B:145:0x045b, B:146:0x0469, B:147:0x0477, B:148:0x0485, B:149:0x0495, B:150:0x049a, B:151:0x04a7, B:152:0x04ac, B:153:0x04ba, B:154:0x04c8, B:155:0x04d6, B:157:0x04e3, B:160:0x04ea, B:161:0x04f0, B:162:0x04f7, B:163:0x0505, B:164:0x0513, B:165:0x0525, B:166:0x052d, B:167:0x053c, B:168:0x054b, B:169:0x055a, B:170:0x0569, B:171:0x0578, B:172:0x0587, B:173:0x0596), top: B:15:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x05b5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r18, com.google.android.recaptcha.internal.zzik r19, com.google.android.recaptcha.internal.zzfz r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzh(java.lang.Object, com.google.android.recaptcha.internal.zzik, com.google.android.recaptcha.internal.zzfz):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x02ed, code lost:
    
        if (r0 != r24) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x02ef, code lost:
    
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r15;
        r1 = r23;
        r6 = r25;
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0302, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0332, code lost:
    
        if (r0 != r14) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x034f, code lost:
    
        if (r0 != r14) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:63:0x0095. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.recaptcha.internal.zzem r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 964
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzem):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:282:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj(java.lang.Object r18, com.google.android.recaptcha.internal.zzjx r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzj(java.lang.Object, com.google.android.recaptcha.internal.zzjx):void");
    }

    public final boolean zzk(Object obj, Object obj2) {
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzz = zzz(i);
            long j = zzz & 1048575;
            switch (zzy(zzz)) {
                case 0:
                    if (zzR(obj, obj2, i) && Double.doubleToLongBits(zzjp.zza(obj, j)) == Double.doubleToLongBits(zzjp.zza(obj2, j))) {
                        break;
                    }
                    return false;
                case 1:
                    if (zzR(obj, obj2, i) && Float.floatToIntBits(zzjp.zzb(obj, j)) == Float.floatToIntBits(zzjp.zzb(obj2, j))) {
                        break;
                    }
                    return false;
                case 2:
                    if (zzR(obj, obj2, i) && zzjp.zzd(obj, j) == zzjp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 3:
                    if (zzR(obj, obj2, i) && zzjp.zzd(obj, j) == zzjp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 4:
                    if (zzR(obj, obj2, i) && zzjp.zzc(obj, j) == zzjp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 5:
                    if (zzR(obj, obj2, i) && zzjp.zzd(obj, j) == zzjp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 6:
                    if (zzR(obj, obj2, i) && zzjp.zzc(obj, j) == zzjp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 7:
                    if (zzR(obj, obj2, i) && zzjp.zzw(obj, j) == zzjp.zzw(obj2, j)) {
                        break;
                    }
                    return false;
                case 8:
                    if (zzR(obj, obj2, i) && zzin.zzY(zzjp.zzf(obj, j), zzjp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 9:
                    if (zzR(obj, obj2, i) && zzin.zzY(zzjp.zzf(obj, j), zzjp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 10:
                    if (zzR(obj, obj2, i) && zzin.zzY(zzjp.zzf(obj, j), zzjp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
                case 11:
                    if (zzR(obj, obj2, i) && zzjp.zzc(obj, j) == zzjp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 12:
                    if (zzR(obj, obj2, i) && zzjp.zzc(obj, j) == zzjp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 13:
                    if (zzR(obj, obj2, i) && zzjp.zzc(obj, j) == zzjp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 14:
                    if (zzR(obj, obj2, i) && zzjp.zzd(obj, j) == zzjp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 15:
                    if (zzR(obj, obj2, i) && zzjp.zzc(obj, j) == zzjp.zzc(obj2, j)) {
                        break;
                    }
                    return false;
                case 16:
                    if (zzR(obj, obj2, i) && zzjp.zzd(obj, j) == zzjp.zzd(obj2, j)) {
                        break;
                    }
                    return false;
                case 17:
                    if (zzR(obj, obj2, i) && zzin.zzY(zzjp.zzf(obj, j), zzjp.zzf(obj2, j))) {
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
                    if (!zzin.zzY(zzjp.zzf(obj, j), zzjp.zzf(obj2, j))) {
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
                    long zzw = zzw(i) & 1048575;
                    if (zzjp.zzc(obj, zzw) == zzjp.zzc(obj2, zzw) && zzin.zzY(zzjp.zzf(obj, j), zzjp.zzf(obj2, j))) {
                        break;
                    }
                    return false;
            }
        }
        if (!this.zzo.zzd(obj).equals(this.zzo.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzp.zzb(obj).equals(this.zzp.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzl(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzib.zzl(java.lang.Object):boolean");
    }
}
