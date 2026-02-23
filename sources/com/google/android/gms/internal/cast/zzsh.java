package com.google.android.gms.internal.cast;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzsh extends zzqz {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzus zzc = zzus.zzc();

    public static zzsp zzA(zzsp zzspVar) {
        int size = zzspVar.size();
        return zzspVar.zzg(size == 0 ? 10 : size + size);
    }

    public static Object zzC(Method method, Object obj, Object... objArr) {
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

    public static Object zzD(zztp zztpVar, String str, Object[] objArr) {
        return new zztz(zztpVar, str, objArr);
    }

    public static void zzG(Class cls, zzsh zzshVar) {
        zzshVar.zzF();
        zzb.put(cls, zzshVar);
    }

    private final int zza(zzua zzuaVar) {
        if (zzuaVar != null) {
            return zzuaVar.zza(this);
        }
        return zztx.zza().zzb(getClass()).zza(this);
    }

    public static zzsh zzv(Class cls) {
        Map map = zzb;
        zzsh zzshVar = (zzsh) map.get(cls);
        if (zzshVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzshVar = (zzsh) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzshVar == null) {
            zzshVar = (zzsh) ((zzsh) zzvb.zze(cls)).zzb(6, null, null);
            if (zzshVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzshVar);
        }
        return zzshVar;
    }

    public static zzsm zzx() {
        return zzsi.zze();
    }

    public static zzso zzy() {
        return zzte.zze();
    }

    public static zzsp zzz() {
        return zzty.zzd();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zztx.zza().zzb(getClass()).zzg(this, (zzsh) obj);
    }

    public final int hashCode() {
        if (zzJ()) {
            return zzr();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzr = zzr();
        this.zza = zzr;
        return zzr;
    }

    public final String toString() {
        return zztr.zza(this, super.toString());
    }

    public final /* synthetic */ zzto zzB() {
        return (zzse) zzb(5, null, null);
    }

    public final void zzE() {
        zztx.zza().zzb(getClass()).zzd(this);
        zzF();
    }

    public final void zzF() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzH(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzI(zzru zzruVar) throws IOException {
        zztx.zza().zzb(getClass()).zzf(this, zzrv.zza(zzruVar));
    }

    public final boolean zzJ() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object zzb(int i, Object obj, Object obj2);

    public final int zzp(zzua zzuaVar) {
        if (zzJ()) {
            int zza = zza(zzuaVar);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zza(zzuaVar);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final int zzr() {
        return zztx.zza().zzb(getClass()).zzb(this);
    }

    public final /* synthetic */ zztp zzs() {
        return (zzsh) zzb(6, null, null);
    }

    public final int zzt() {
        int i;
        if (zzJ()) {
            i = zza(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zza(null);
                if (i < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
            }
        }
        return i;
    }

    public final zzse zzu() {
        return (zzse) zzb(5, null, null);
    }

    public final zzsh zzw() {
        return (zzsh) zzb(4, null, null);
    }
}
