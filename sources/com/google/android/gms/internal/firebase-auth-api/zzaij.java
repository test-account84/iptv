package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaij implements zzalc {
    private final zzaia zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzaij(zzaia zzaiaVar) {
        zzaia zzaiaVar2 = (zzaia) zzajf.zza(zzaiaVar, "input");
        this.zza = zzaiaVar2;
        zzaiaVar2.zzd = this;
    }

    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    public final zzahp zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzu();
    }

    public final boolean zzt() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zze(i);
    }

    public static zzaij zza(zzaia zzaiaVar) {
        zzaij zzaijVar = zzaiaVar.zzd;
        return zzaijVar != null ? zzaijVar : new zzaij(zzaiaVar);
    }

    private final Object zzb(zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        Object zza = zzalfVar.zza();
        zzd(zza, zzalfVar, zzaioVar);
        zzalfVar.zzc(zza);
        return zza;
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzaji.zzg();
        }
    }

    private static void zzd(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzaji.zzg();
        }
    }

    public final void zze(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            if (i != 5) {
                throw zzaji.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzajd zzajdVar = (zzajd) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzajdVar.zzc(this.zza.zze());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        if (i2 != 5) {
            throw zzaji.zza();
        }
        do {
            zzajdVar.zzc(this.zza.zze());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    public final void zzf(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajy)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzj = this.zza.zzj();
            zzd(zzj);
            int zzc = this.zza.zzc() + zzj;
            do {
                list.add(Long.valueOf(this.zza.zzk()));
            } while (this.zza.zzc() < zzc);
            return;
        }
        zzajy zzajyVar = (zzajy) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzajyVar.zza(this.zza.zzk());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzj2 = this.zza.zzj();
        zzd(zzj2);
        int zzc2 = this.zza.zzc() + zzj2;
        do {
            zzajyVar.zza(this.zza.zzk());
        } while (this.zza.zzc() < zzc2);
    }

    public final void zzg(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajb)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            if (i != 5) {
                throw zzaji.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzajb zzajbVar = (zzajb) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzajbVar.zza(this.zza.zzb());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        if (i2 != 5) {
            throw zzaji.zza();
        }
        do {
            zzajbVar.zza(this.zza.zzb());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    public final void zzh(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzajd zzajdVar = (zzajd) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzf());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzajdVar.zzc(this.zza.zzf());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    public final void zzi(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajy)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzl()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzajy zzajyVar = (zzajy) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzajyVar.zza(this.zza.zzl());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzajyVar.zza(this.zza.zzl());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    public final void zzj(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < zzc);
                return;
            }
            if (i != 5) {
                throw zzaji.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzajd zzajdVar = (zzajd) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzajdVar.zzc(this.zza.zzg());
            } while (this.zza.zzc() < zzc2);
            return;
        }
        if (i2 != 5) {
            throw zzaji.zza();
        }
        do {
            zzajdVar.zzc(this.zza.zzg());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    public final void zzk(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajy)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzj = this.zza.zzj();
            zzd(zzj);
            int zzc = this.zza.zzc() + zzj;
            do {
                list.add(Long.valueOf(this.zza.zzn()));
            } while (this.zza.zzc() < zzc);
            return;
        }
        zzajy zzajyVar = (zzajy) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzajyVar.zza(this.zza.zzn());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzj2 = this.zza.zzj();
        zzd(zzj2);
        int zzc2 = this.zza.zzc() + zzj2;
        do {
            zzajyVar.zza(this.zza.zzn());
        } while (this.zza.zzc() < zzc2);
    }

    public final void zzl(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzajd zzajdVar = (zzajd) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzh());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzajdVar.zzc(this.zza.zzh());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    public final void zzm(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajy)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzajy zzajyVar = (zzajy) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzajyVar.zza(this.zza.zzo());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzajyVar.zza(this.zza.zzo());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    public final void zzn(List list) throws IOException {
        zza(list, false);
    }

    public final void zzo(List list) throws IOException {
        zza(list, true);
    }

    public final void zzp(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzajd zzajdVar = (zzajd) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzj());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzajdVar.zzc(this.zza.zzj());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    public final void zzq(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajy)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzajy zzajyVar = (zzajy) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzajyVar.zza(this.zza.zzp());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzajyVar.zza(this.zza.zzp());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    private final Object zza(zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        Object zza = zzalfVar.zza();
        zzc(zza, zzalfVar, zzaioVar);
        zzalfVar.zzc(zza);
        return zza;
    }

    private final void zzb(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzaji.zza();
        }
    }

    private final void zzc(Object obj, zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzalfVar.zza(obj, this, zzaioVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzaji.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzd(Object obj, zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        int zzj = this.zza.zzj();
        zzaia zzaiaVar = this.zza;
        if (zzaiaVar.zza >= zzaiaVar.zzb) {
            throw new zzaji("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzb = zzaiaVar.zzb(zzj);
        this.zza.zza++;
        zzalfVar.zza(obj, this, zzaioVar);
        this.zza.zzc(0);
        r5.zza--;
        this.zza.zzd(zzb);
    }

    private final Object zza(zzamr zzamrVar, Class cls, zzaio zzaioVar) throws IOException {
        switch (zzaii.zza[zzamrVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzalb.zza().zza(cls), zzaioVar);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    public final void zzb(Object obj, zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        zzb(2);
        zzd(obj, zzalfVar, zzaioVar);
    }

    public final void zzc(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzaim)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzj = this.zza.zzj();
            zzd(zzj);
            int zzc = this.zza.zzc() + zzj;
            do {
                list.add(Double.valueOf(this.zza.zza()));
            } while (this.zza.zzc() < zzc);
            return;
        }
        zzaim zzaimVar = (zzaim) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzaimVar.zza(this.zza.zza());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzj2 = this.zza.zzj();
        zzd(zzj2);
        int zzc2 = this.zza.zzc() + zzj2;
        do {
            zzaimVar.zza(this.zza.zza());
        } while (this.zza.zzc() < zzc2);
    }

    public final void zzd(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzajd zzajdVar = (zzajd) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzd());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzajdVar.zzc(this.zza.zzd());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    private final void zza(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw zzaji.zzi();
        }
    }

    public final void zzb(List list) throws IOException {
        int zzi;
        if ((this.zzb & 7) != 2) {
            throw zzaji.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    public final void zza(Object obj, zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        zzb(3);
        zzc(obj, zzalfVar, zzaioVar);
    }

    public final void zzb(List list, zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        int zzi;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzaji.zza();
        }
        do {
            list.add(zzb(zzalfVar, zzaioVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == i);
        this.zzd = zzi;
    }

    public final void zza(List list) throws IOException {
        int zzi;
        int zzi2;
        if (!(list instanceof zzahn)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzu()));
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi = this.zza.zzi();
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
            if (i != 2) {
                throw zzaji.zza();
            }
            int zzc = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
            } while (this.zza.zzc() < zzc);
            zza(zzc);
            return;
        }
        zzahn zzahnVar = (zzahn) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzahnVar.zza(this.zza.zzu());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        if (i2 != 2) {
            throw zzaji.zza();
        }
        int zzc2 = this.zza.zzc() + this.zza.zzj();
        do {
            zzahnVar.zza(this.zza.zzu());
        } while (this.zza.zzc() < zzc2);
        zza(zzc2);
    }

    @Deprecated
    public final void zza(List list, zzalf zzalfVar, zzaio zzaioVar) throws IOException {
        int zzi;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzaji.zza();
        }
        do {
            list.add(zza(zzalfVar, zzaioVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == i);
        this.zzd = zzi;
    }

    private final void zza(List list, boolean z) throws IOException {
        int zzi;
        int zzi2;
        if ((this.zzb & 7) != 2) {
            throw zzaji.zza();
        }
        if (!(list instanceof zzajt) || z) {
            do {
                list.add(z ? zzr() : zzq());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzajt zzajtVar = (zzajt) list;
        do {
            zzajtVar.zza(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi2 = this.zza.zzi();
            }
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        r7.zza.zzd(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.util.Map r8, com.google.android.gms.internal.firebase-auth-api.zzake r9, com.google.android.gms.internal.firebase-auth-api.zzaio r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.firebase-auth-api.zzaia r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.firebase-auth-api.zzaia r2 = r7.zza
            int r1 = r2.zzb(r1)
            java.lang.Object r2 = r9.zzb
            java.lang.Object r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L39
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5d
            com.google.android.gms.internal.firebase-auth-api.zzaia r5 = r7.zza     // Catch: java.lang.Throwable -> L39
            boolean r5 = r5.zzt()     // Catch: java.lang.Throwable -> L39
            if (r5 != 0) goto L5d
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L48
            if (r4 == r0) goto L3b
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.firebase-auth-api.zzaji r4 = new com.google.android.gms.internal.firebase-auth-api.zzaji     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            throw r4     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
        L39:
            r8 = move-exception
            goto L66
        L3b:
            com.google.android.gms.internal.firebase-auth-api.zzamr r4 = r9.zzc     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            java.lang.Object r5 = r9.zzd     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            goto L14
        L48:
            com.google.android.gms.internal.firebase-auth-api.zzamr r4 = r9.zza     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.firebase-auth-api.zzajl -> L50
            goto L14
        L50:
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L57
            goto L14
        L57:
            com.google.android.gms.internal.firebase-auth-api.zzaji r8 = new com.google.android.gms.internal.firebase-auth-api.zzaji     // Catch: java.lang.Throwable -> L39
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L39
            throw r8     // Catch: java.lang.Throwable -> L39
        L5d:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.firebase-auth-api.zzaia r8 = r7.zza
            r8.zzd(r1)
            return
        L66:
            com.google.android.gms.internal.firebase-auth-api.zzaia r9 = r7.zza
            r9.zzd(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzaij.zza(java.util.Map, com.google.android.gms.internal.firebase-auth-api.zzake, com.google.android.gms.internal.firebase-auth-api.zzaio):void");
    }
}
