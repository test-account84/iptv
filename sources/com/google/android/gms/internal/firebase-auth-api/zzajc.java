package com.google.android.gms.internal.firebase-auth-api;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzajc extends zzahf {
    private static Map zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzamd zzb = zzamd.zzc();

    public static abstract class zza extends zzahe {
        protected zzajc zza;
        private final zzajc zzb;

        public zza(zzajc zzajcVar) {
            this.zzb = zzajcVar;
            if (zzajcVar.zzu()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = zzajcVar.zzo();
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, (Object) null, (Object) null);
            zzaVar.zza = (zzajc) zzg();
            return zzaVar;
        }

        public final zza zza(zzajc zzajcVar) {
            if (this.zzb.equals(zzajcVar)) {
                return this;
            }
            if (!this.zza.zzu()) {
                zzj();
            }
            zza(this.zza, zzajcVar);
            return this;
        }

        public final /* synthetic */ zzahe zzc() {
            return (zza) clone();
        }

        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public final zzajc zzf() {
            zzajc zzajcVar = (zzajc) zzg();
            if (zzajcVar.zzk()) {
                return zzajcVar;
            }
            throw new zzamc(zzajcVar);
        }

        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zzajc zzg() {
            if (!this.zza.zzu()) {
                return this.zza;
            }
            this.zza.zzs();
            return this.zza;
        }

        public final /* synthetic */ zzakn zzh() {
            return this.zzb;
        }

        public final void zzi() {
            if (this.zza.zzu()) {
                return;
            }
            zzj();
        }

        public void zzj() {
            zzajc zzo = this.zzb.zzo();
            zza(zzo, this.zza);
            this.zza = zzo;
        }

        public final boolean zzk() {
            return zzajc.zza(this.zza, false);
        }

        private static void zza(Object obj, Object obj2) {
            zzalb.zza().zza(obj).zza(obj, obj2);
        }
    }

    public static abstract class zzb extends zzajc implements zzakp {
        protected zzaiv zzc = zzaiv.zzb();

        public final zzaiv zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzaiv) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public static class zzc extends zzahg {
        private final zzajc zza;

        public zzc(zzajc zzajcVar) {
            this.zza = zzajcVar;
        }
    }

    public static class zzd extends zzaip {
    }

    public static final class zze implements zzaix {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzamr zzb() {
            throw new NoSuchMethodError();
        }

        public final zzanb zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzakm zza(zzakm zzakmVar, zzakn zzaknVar) {
            throw new NoSuchMethodError();
        }

        public final zzaks zza(zzaks zzaksVar, zzaks zzaksVar2) {
            throw new NoSuchMethodError();
        }
    }

    public enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    private final int zza() {
        return zzalb.zza().zza(this).zzb(this);
    }

    private final int zzb(zzalf zzalfVar) {
        return zzalfVar == null ? zzalb.zza().zza(this).zza(this) : zzalfVar.zza(this);
    }

    public static zzajj zzp() {
        return zzala.zzd();
    }

    public final int a_() {
        return this.zzd & Integer.MAX_VALUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzalb.zza().zza(this).zzb(this, (zzajc) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzu()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzako.zza(this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    public final /* synthetic */ zzakn zzh() {
        return (zzajc) zza(zzf.zzf, (Object) null, (Object) null);
    }

    public final boolean zzk() {
        return zza(this, true);
    }

    public final int zzl() {
        return zza((zzalf) null);
    }

    public final zza zzm() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final zza zzn() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    public final zzajc zzo() {
        return (zzajc) zza(zzf.zzd, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzakm zzq() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzakm zzr() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    public final void zzs() {
        zzalb.zza().zza(this).zzc(this);
        zzt();
    }

    public final void zzt() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean zzu() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    private static zzajc zzb(zzajc zzajcVar, zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        zzaia zzc2 = zzahpVar.zzc();
        zzajc zza2 = zza(zzajcVar, zzc2, zzaioVar);
        try {
            zzc2.zzc(0);
            return zza2;
        } catch (zzaji e) {
            throw e.zza(zza2);
        }
    }

    public final int zza(zzalf zzalfVar) {
        if (!zzu()) {
            if (a_() != Integer.MAX_VALUE) {
                return a_();
            }
            int zzb2 = zzb(zzalfVar);
            zzb(zzb2);
            return zzb2;
        }
        int zzb3 = zzb(zzalfVar);
        if (zzb3 >= 0) {
            return zzb3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzb3);
    }

    private static zzajc zza(zzajc zzajcVar) throws zzaji {
        if (zzajcVar == null || zzajcVar.zzk()) {
            return zzajcVar;
        }
        throw new zzamc(zzajcVar).zza().zza(zzajcVar);
    }

    public final void zzb(int i) {
        if (i >= 0) {
            this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
    }

    public static zzajc zza(zzajc zzajcVar, zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return zza(zzb(zzajcVar, zzahpVar, zzaioVar));
    }

    private static zzajc zza(zzajc zzajcVar, zzaia zzaiaVar, zzaio zzaioVar) throws zzaji {
        zzajc zzo = zzajcVar.zzo();
        try {
            zzalf zza2 = zzalb.zza().zza(zzo);
            zza2.zza(zzo, zzaij.zza(zzaiaVar), zzaioVar);
            zza2.zzc(zzo);
            return zzo;
        } catch (zzaji e) {
            e = e;
            if (e.zzk()) {
                e = new zzaji(e);
            }
            throw e.zza(zzo);
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzaji) {
                throw e2.getCause();
            }
            throw new zzaji(e2).zza(zzo);
        } catch (zzamc e3) {
            throw e3.zza().zza(zzo);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzaji) {
                throw e4.getCause();
            }
            throw e4;
        }
    }

    public static zzajc zza(zzajc zzajcVar, InputStream inputStream, zzaio zzaioVar) throws zzaji {
        zzaia zzaifVar;
        if (inputStream == null) {
            byte[] bArr = zzajf.zzb;
            zzaifVar = zzaia.zza(bArr, 0, bArr.length, false);
        } else {
            zzaifVar = new zzaif(inputStream, 4096, null);
        }
        return zza(zza(zzajcVar, zzaifVar, zzaioVar));
    }

    private static zzajc zza(zzajc zzajcVar, byte[] bArr, int i, int i2, zzaio zzaioVar) throws zzaji {
        zzajc zzo = zzajcVar.zzo();
        try {
            zzalf zza2 = zzalb.zza().zza(zzo);
            zza2.zza(zzo, bArr, 0, i2, new zzahk(zzaioVar));
            zza2.zzc(zzo);
            return zzo;
        } catch (zzamc e) {
            throw e.zza().zza(zzo);
        } catch (IndexOutOfBoundsException unused) {
            throw zzaji.zzi().zza(zzo);
        } catch (zzaji e2) {
            e = e2;
            if (e.zzk()) {
                e = new zzaji(e);
            }
            throw e.zza(zzo);
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaji) {
                throw e3.getCause();
            }
            throw new zzaji(e3).zza(zzo);
        }
    }

    public static zzajc zza(zzajc zzajcVar, byte[] bArr, zzaio zzaioVar) throws zzaji {
        return zza(zza(zzajcVar, bArr, 0, bArr.length, zzaioVar));
    }

    public static zzajc zza(Class cls) {
        zzajc zzajcVar = (zzajc) zzc.get(cls);
        if (zzajcVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzajcVar = (zzajc) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzajcVar == null) {
            zzajcVar = (zzajc) ((zzajc) zzamk.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (zzajcVar == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzajcVar);
        }
        return zzajcVar;
    }

    public static zzajj zza(zzajj zzajjVar) {
        int size = zzajjVar.size();
        return zzajjVar.zza(size == 0 ? 10 : size << 1);
    }

    public static Object zza(zzakn zzaknVar, String str, Object[] objArr) {
        return new zzald(zzaknVar, str, objArr);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
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

    public final void zza(zzaik zzaikVar) throws IOException {
        zzalb.zza().zza(this).zza((Object) this, (zzana) zzain.zza(zzaikVar));
    }

    public static void zza(Class cls, zzajc zzajcVar) {
        zzajcVar.zzt();
        zzc.put(cls, zzajcVar);
    }

    public static final boolean zza(zzajc zzajcVar, boolean z) {
        byte byteValue = ((Byte) zzajcVar.zza(zzf.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzalb.zza().zza(zzajcVar).zzd(zzajcVar);
        if (z) {
            zzajcVar.zza(zzf.zzb, zzd2 ? zzajcVar : null, (Object) null);
        }
        return zzd2;
    }
}
