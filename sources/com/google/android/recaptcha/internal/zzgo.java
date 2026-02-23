package com.google.android.recaptcha.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzgo extends zzei {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzjg zzc = zzjg.zzc();

    public static void zzC(Class cls, zzgo zzgoVar) {
        zzgoVar.zzB();
        zzb.put(cls, zzgoVar);
    }

    public static final boolean zzE(zzgo zzgoVar, boolean z) {
        byte byteValue = ((Byte) zzgoVar.zzh(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzih.zza().zzb(zzgoVar.getClass()).zzl(zzgoVar);
        if (z) {
            zzgoVar.zzh(2, true != zzl ? null : zzgoVar, null);
        }
        return zzl;
    }

    private final int zzf(zzil zzilVar) {
        if (zzilVar != null) {
            return zzilVar.zza(this);
        }
        return zzih.zza().zzb(getClass()).zza(this);
    }

    private static zzgo zzg(zzgo zzgoVar) throws zzgy {
        if (zzgoVar == null || zzgoVar.zzo()) {
            return zzgoVar;
        }
        zzgy zza = new zzje(zzgoVar).zza();
        zza.zzh(zzgoVar);
        throw zza;
    }

    private static zzgo zzi(zzgo zzgoVar, byte[] bArr, int i, int i2, zzfz zzfzVar) throws zzgy {
        zzgo zzs = zzgoVar.zzs();
        try {
            zzil zzb2 = zzih.zza().zzb(zzs.getClass());
            zzb2.zzi(zzs, bArr, 0, i2, new zzem(zzfzVar));
            zzb2.zzf(zzs);
            return zzs;
        } catch (zzgy e) {
            e = e;
            if (e.zzl()) {
                e = new zzgy(e);
            }
            e.zzh(zzs);
            throw e;
        } catch (zzje e2) {
            zzgy zza = e2.zza();
            zza.zzh(zzs);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgy) {
                throw e3.getCause();
            }
            zzgy zzgyVar = new zzgy(e3);
            zzgyVar.zzh(zzs);
            throw zzgyVar;
        } catch (IndexOutOfBoundsException unused) {
            zzgy zzj = zzgy.zzj();
            zzj.zzh(zzs);
            throw zzj;
        }
    }

    public static zzgm zzq(zzhy zzhyVar, Object obj, zzhy zzhyVar2, zzgr zzgrVar, int i, zzjv zzjvVar, Class cls) {
        return new zzgm(zzhyVar, "", null, new zzgl(null, i, zzjvVar, false, false), cls);
    }

    public static zzgo zzr(Class cls) {
        Map map = zzb;
        zzgo zzgoVar = (zzgo) map.get(cls);
        if (zzgoVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgoVar = (zzgo) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgoVar == null) {
            zzgoVar = (zzgo) ((zzgo) zzjp.zze(cls)).zzh(6, null, null);
            if (zzgoVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzgoVar);
        }
        return zzgoVar;
    }

    public static zzgo zzt(zzgo zzgoVar, InputStream inputStream) throws zzgy {
        zzff zzfdVar;
        int i = zzff.zzd;
        if (inputStream == null) {
            byte[] bArr = zzgw.zzd;
            int length = bArr.length;
            zzfdVar = zzff.zzH(bArr, 0, 0, false);
        } else {
            zzfdVar = new zzfd(inputStream, 4096, null);
        }
        zzfz zzfzVar = zzfz.zza;
        zzgo zzs = zzgoVar.zzs();
        try {
            zzil zzb2 = zzih.zza().zzb(zzs.getClass());
            zzb2.zzh(zzs, zzfg.zzq(zzfdVar), zzfzVar);
            zzb2.zzf(zzs);
            zzg(zzs);
            return zzs;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof zzgy) {
                throw e.getCause();
            }
            throw e;
        } catch (zzgy e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzgy(e);
            }
            e.zzh(zzs);
            throw e;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgy) {
                throw e3.getCause();
            }
            zzgy zzgyVar = new zzgy(e3);
            zzgyVar.zzh(zzs);
            throw zzgyVar;
        } catch (zzje e4) {
            zzgy zza = e4.zza();
            zza.zzh(zzs);
            throw zza;
        }
    }

    public static zzgo zzu(zzgo zzgoVar, byte[] bArr) throws zzgy {
        zzgo zzi = zzi(zzgoVar, bArr, 0, bArr.length, zzfz.zza);
        zzg(zzi);
        return zzi;
    }

    public static zzgt zzv() {
        return zzgp.zzf();
    }

    public static zzgv zzw() {
        return zzii.zze();
    }

    public static zzgv zzx(zzgv zzgvVar) {
        int size = zzgvVar.size();
        return zzgvVar.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzy(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Error cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw cause;
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        }
    }

    public static Object zzz(zzhy zzhyVar, String str, Object[] objArr) {
        return new zzij(zzhyVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzih.zza().zzb(getClass()).zzk(this, (zzgo) obj);
    }

    public final int hashCode() {
        if (zzF()) {
            return zzm();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzm = zzm();
        this.zza = zzm;
        return zzm;
    }

    public final String toString() {
        return zzia.zza(this, super.toString());
    }

    public final void zzA() {
        zzih.zza().zzb(getClass()).zzf(this);
        zzB();
    }

    public final void zzB() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzD(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzF() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzhx zzV() {
        return (zzgi) zzh(5, null, null);
    }

    public final /* synthetic */ zzhx zzW() {
        zzgi zzgiVar = (zzgi) zzh(5, null, null);
        zzgiVar.zzg(this);
        return zzgiVar;
    }

    public final /* synthetic */ zzhy zzX() {
        return (zzgo) zzh(6, null, null);
    }

    public final int zza(zzil zzilVar) {
        if (zzF()) {
            int zzf = zzf(zzilVar);
            if (zzf >= 0) {
                return zzf;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzf);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zzf2 = zzf(zzilVar);
        if (zzf2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzf2;
            return zzf2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzf2);
    }

    public final void zze(zzfk zzfkVar) throws IOException {
        zzih.zza().zzb(getClass()).zzj(this, zzfl.zza(zzfkVar));
    }

    public abstract Object zzh(int i, Object obj, Object obj2);

    public final int zzm() {
        return zzih.zza().zzb(getClass()).zzb(this);
    }

    public final int zzn() {
        int i;
        if (zzF()) {
            i = zzf(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzf(null);
                if (i < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
            }
        }
        return i;
    }

    public final boolean zzo() {
        return zzE(this, true);
    }

    public final zzgi zzp() {
        return (zzgi) zzh(5, null, null);
    }

    public final zzgo zzs() {
        return (zzgo) zzh(4, null, null);
    }
}
