package com.google.android.gms.internal.play_billing;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzcs extends zzay {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzfg zzc = zzfg.zzc();

    public static zzcs zzj(Class cls) {
        Map map = zzb;
        zzcs zzcsVar = (zzcs) map.get(cls);
        if (zzcsVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzcsVar = (zzcs) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzcsVar == null) {
            zzcsVar = (zzcs) ((zzcs) zzfp.zze(cls)).zzx(6, null, null);
            if (zzcsVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzcsVar);
        }
        return zzcsVar;
    }

    public static zzcs zzm(zzcs zzcsVar, byte[] bArr, zzcd zzcdVar) throws zzdc {
        zzcs zzz = zzz(zzcsVar, bArr, 0, bArr.length, zzcdVar);
        if (zzz == null || zzz.zzk()) {
            return zzz;
        }
        zzdc zza = new zzfe(zzz).zza();
        zza.zzf(zzz);
        throw zza;
    }

    public static zzcx zzn() {
        return zzct.zzf();
    }

    public static zzcz zzo() {
        return zzem.zze();
    }

    public static Object zzp(Method method, Object obj, Object... objArr) {
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

    public static Object zzq(zzec zzecVar, String str, Object[] objArr) {
        return new zzen(zzecVar, str, objArr);
    }

    public static void zzt(Class cls, zzcs zzcsVar) {
        zzcsVar.zzs();
        zzb.put(cls, zzcsVar);
    }

    public static final boolean zzv(zzcs zzcsVar, boolean z) {
        byte byteValue = ((Byte) zzcsVar.zzx(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzel.zza().zzb(zzcsVar.getClass()).zzk(zzcsVar);
        if (z) {
            zzcsVar.zzx(2, true != zzk ? null : zzcsVar, null);
        }
        return zzk;
    }

    private final int zzy(zzeo zzeoVar) {
        return zzel.zza().zzb(getClass()).zza(this);
    }

    private static zzcs zzz(zzcs zzcsVar, byte[] bArr, int i, int i2, zzcd zzcdVar) throws zzdc {
        if (i2 == 0) {
            return zzcsVar;
        }
        zzcs zzl = zzcsVar.zzl();
        try {
            zzeo zzb2 = zzel.zza().zzb(zzl.getClass());
            zzb2.zzh(zzl, bArr, 0, i2, new zzbc(zzcdVar));
            zzb2.zzf(zzl);
            return zzl;
        } catch (IndexOutOfBoundsException unused) {
            zzdc zzg = zzdc.zzg();
            zzg.zzf(zzl);
            throw zzg;
        } catch (zzdc e) {
            e.zzf(zzl);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzdc) {
                throw e2.getCause();
            }
            zzdc zzdcVar = new zzdc(e2);
            zzdcVar.zzf(zzl);
            throw zzdcVar;
        } catch (zzfe e3) {
            zzdc zza = e3.zza();
            zza.zzf(zzl);
            throw zza;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzel.zza().zzb(getClass()).zzj(this, (zzcs) obj);
    }

    public final int hashCode() {
        if (zzw()) {
            return zzd();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzd = zzd();
        this.zza = zzd;
        return zzd;
    }

    public final String toString() {
        return zzee.zza(this, super.toString());
    }

    public final /* synthetic */ zzeb zzE() {
        return (zzcn) zzx(5, null, null);
    }

    public final /* synthetic */ zzeb zzF() {
        zzcn zzcnVar = (zzcn) zzx(5, null, null);
        zzcnVar.zzc(this);
        return zzcnVar;
    }

    public final int zza(zzeo zzeoVar) {
        if (zzw()) {
            int zza = zzeoVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzeoVar.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final int zzd() {
        return zzel.zza().zzb(getClass()).zzb(this);
    }

    public final void zze(zzby zzbyVar) throws IOException {
        zzel.zza().zzb(getClass()).zzi(this, zzbz.zza(zzbyVar));
    }

    public final int zzf() {
        int i;
        if (zzw()) {
            i = zzy(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzy(null);
                if (i < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
            }
        }
        return i;
    }

    public final zzcn zzg() {
        return (zzcn) zzx(5, null, null);
    }

    public final /* synthetic */ zzec zzh() {
        return (zzcs) zzx(6, null, null);
    }

    public final zzcn zzi() {
        zzcn zzcnVar = (zzcn) zzx(5, null, null);
        zzcnVar.zzc(this);
        return zzcnVar;
    }

    public final boolean zzk() {
        return zzv(this, true);
    }

    public final zzcs zzl() {
        return (zzcs) zzx(4, null, null);
    }

    public final void zzr() {
        zzel.zza().zzb(getClass()).zzf(this);
        zzs();
    }

    public final void zzs() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzu(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzw() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object zzx(int i, Object obj, Object obj2);
}
