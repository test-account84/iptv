package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfg implements zzik {
    private final zzff zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzfg(zzff zzffVar) {
        byte[] bArr = zzgw.zzd;
        this.zza = zzffVar;
        zzffVar.zzc = this;
    }

    private final void zzP(Object obj, zzil zzilVar, zzfz zzfzVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzilVar.zzh(obj, this, zzfzVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzgy.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzil zzilVar, zzfz zzfzVar) throws IOException {
        int zzn = this.zza.zzn();
        zzff zzffVar = this.zza;
        if (zzffVar.zza >= zzffVar.zzb) {
            throw new zzgy("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zze = zzffVar.zze(zzn);
        this.zza.zza++;
        zzilVar.zzh(obj, this, zzfzVar);
        this.zza.zzz(0);
        r5.zza--;
        this.zza.zzA(zze);
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw zzgy.zzj();
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzgy.zza();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzgy.zzg();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzgy.zzg();
        }
    }

    public static zzfg zzq(zzff zzffVar) {
        zzfg zzfgVar = zzffVar.zzc;
        return zzfgVar != null ? zzfgVar : new zzfg(zzffVar);
    }

    public final void zzA(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzhn)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzn = this.zza.zzn();
            zzU(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzd() < zzd);
            return;
        }
        zzhn zzhnVar = (zzhn) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzhnVar.zzf(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzn2 = this.zza.zzn();
        zzU(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            zzhnVar.zzf(this.zza.zzo());
        } while (this.zza.zzd() < zzd2);
    }

    public final void zzB(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzgg)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i != 5) {
                throw zzgy.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        zzgg zzggVar = (zzgg) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzn2 = this.zza.zzn();
            zzT(zzn2);
            int zzd2 = this.zza.zzd() + zzn2;
            do {
                zzggVar.zze(this.zza.zzc());
            } while (this.zza.zzd() < zzd2);
            return;
        }
        if (i2 != 5) {
            throw zzgy.zza();
        }
        do {
            zzggVar.zze(this.zza.zzc());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm2 = this.zza.zzm();
            }
        } while (zzm2 == this.zzb);
        this.zzd = zzm2;
    }

    @Deprecated
    public final void zzC(List list, zzil zzilVar, zzfz zzfzVar) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzgy.zza();
        }
        do {
            Object zze = zzilVar.zze();
            zzP(zze, zzilVar, zzfzVar);
            zzilVar.zzf(zze);
            list.add(zze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i);
        this.zzd = zzm;
    }

    public final void zzD(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzgp)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzgpVar.zzg(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzgpVar.zzg(this.zza.zzh());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final void zzE(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzhn)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzhn zzhnVar = (zzhn) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzhnVar.zzf(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzhnVar.zzf(this.zza.zzp());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final void zzF(List list, zzil zzilVar, zzfz zzfzVar) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzgy.zza();
        }
        do {
            Object zze = zzilVar.zze();
            zzQ(zze, zzilVar, zzfzVar);
            zzilVar.zzf(zze);
            list.add(zze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i);
        this.zzd = zzm;
    }

    public final void zzG(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzgp)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i != 5) {
                throw zzgy.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzn2 = this.zza.zzn();
            zzT(zzn2);
            int zzd2 = this.zza.zzd() + zzn2;
            do {
                zzgpVar.zzg(this.zza.zzk());
            } while (this.zza.zzd() < zzd2);
            return;
        }
        if (i2 != 5) {
            throw zzgy.zza();
        }
        do {
            zzgpVar.zzg(this.zza.zzk());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm2 = this.zza.zzm();
            }
        } while (zzm2 == this.zzb);
        this.zzd = zzm2;
    }

    public final void zzH(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzhn)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzn = this.zza.zzn();
            zzU(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                list.add(Long.valueOf(this.zza.zzt()));
            } while (this.zza.zzd() < zzd);
            return;
        }
        zzhn zzhnVar = (zzhn) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzhnVar.zzf(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzn2 = this.zza.zzn();
        zzU(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            zzhnVar.zzf(this.zza.zzt());
        } while (this.zza.zzd() < zzd2);
    }

    public final void zzI(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzgp)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzgpVar.zzg(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzgpVar.zzg(this.zza.zzl());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final void zzJ(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzhn)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Long.valueOf(this.zza.zzu()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzhn zzhnVar = (zzhn) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzhnVar.zzf(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzhnVar.zzf(this.zza.zzu());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzm;
        int zzm2;
        if ((this.zzb & 7) != 2) {
            throw zzgy.zza();
        }
        if (!(list instanceof zzhg) || z) {
            do {
                list.add(z ? zzs() : zzr());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        zzhg zzhgVar = (zzhg) list;
        do {
            zzhgVar.zzi(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm2 = this.zza.zzm();
            }
        } while (zzm2 == this.zzb);
        this.zzd = zzm2;
    }

    public final void zzL(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzgp)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzgpVar.zzg(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzgpVar.zzg(this.zza.zzn());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final void zzM(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzhn)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Long.valueOf(this.zza.zzv()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzhn zzhnVar = (zzhn) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzhnVar.zzf(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzhnVar.zzf(this.zza.zzv());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    public final boolean zzO() throws IOException {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzm();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    public final zzez zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    public final void zzt(Object obj, zzil zzilVar, zzfz zzfzVar) throws IOException {
        zzS(3);
        zzP(obj, zzilVar, zzfzVar);
    }

    public final void zzu(Object obj, zzil zzilVar, zzfz zzfzVar) throws IOException {
        zzS(2);
        zzQ(obj, zzilVar, zzfzVar);
    }

    public final void zzv(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzeo)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzeo zzeoVar = (zzeo) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzeoVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzeoVar.zze(this.zza.zzD());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) != 2) {
            throw zzgy.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    public final void zzx(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzft)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzn = this.zza.zzn();
            zzU(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                list.add(Double.valueOf(this.zza.zzb()));
            } while (this.zza.zzd() < zzd);
            return;
        }
        zzft zzftVar = (zzft) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzftVar.zze(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzn2 = this.zza.zzn();
        zzU(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            zzftVar.zze(this.zza.zzb());
        } while (this.zza.zzd() < zzd2);
    }

    public final void zzy(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzgp)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            if (i != 2) {
                throw zzgy.zza();
            }
            int zzd = this.zza.zzd() + this.zza.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzd() < zzd);
            zzR(zzd);
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzgpVar.zzg(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm2 = this.zza.zzm();
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        if (i2 != 2) {
            throw zzgy.zza();
        }
        int zzd2 = this.zza.zzd() + this.zza.zzn();
        do {
            zzgpVar.zzg(this.zza.zzf());
        } while (this.zza.zzd() < zzd2);
        zzR(zzd2);
    }

    public final void zzz(List list) throws IOException {
        int zzm;
        int zzm2;
        if (!(list instanceof zzgp)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i != 5) {
                throw zzgy.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzn2 = this.zza.zzn();
            zzT(zzn2);
            int zzd2 = this.zza.zzd() + zzn2;
            do {
                zzgpVar.zzg(this.zza.zzg());
            } while (this.zza.zzd() < zzd2);
            return;
        }
        if (i2 != 5) {
            throw zzgy.zza();
        }
        do {
            zzgpVar.zzg(this.zza.zzg());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm2 = this.zza.zzm();
            }
        } while (zzm2 == this.zzb);
        this.zzd = zzm2;
    }
}
