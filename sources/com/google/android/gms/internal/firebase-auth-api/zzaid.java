package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaid extends zzaia {
    private final byte[] zze;
    private final boolean zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    private zzaid(byte[] bArr, int i, int i2, boolean z) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzg = i2 + i;
        this.zzi = i;
        this.zzj = i;
        this.zzf = z;
    }

    private final void zzaa() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = i - this.zzj;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    private final byte zzv() throws IOException {
        int i = this.zzi;
        if (i == this.zzg) {
            throw zzaji.zzi();
        }
        byte[] bArr = this.zze;
        this.zzi = i + 1;
        return bArr[i];
    }

    private final int zzw() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            throw zzaji.zzi();
        }
        byte[] bArr = this.zze;
        this.zzi = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final int zzx() throws IOException {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return i;
            }
        }
        return (int) zzm();
    }

    private final long zzy() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            throw zzaji.zzi();
        }
        byte[] bArr = this.zze;
        this.zzi = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final long zzz() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (bArr[i8] << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (bArr[i4] << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (bArr[i10] << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (bArr[i4] << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j6 ^ j3;
                        }
                    }
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzm();
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    public final int zzc() {
        return this.zzi - this.zzj;
    }

    public final int zzd() throws IOException {
        return zzx();
    }

    public final int zze() throws IOException {
        return zzw();
    }

    public final int zzf() throws IOException {
        return zzx();
    }

    public final int zzg() throws IOException {
        return zzw();
    }

    public final int zzh() throws IOException {
        return zzaia.zza(zzx());
    }

    public final int zzi() throws IOException {
        if (zzt()) {
            this.zzk = 0;
            return 0;
        }
        int zzx = zzx();
        this.zzk = zzx;
        if ((zzx >>> 3) != 0) {
            return zzx;
        }
        throw zzaji.zzc();
    }

    public final int zzj() throws IOException {
        return zzx();
    }

    public final long zzk() throws IOException {
        return zzy();
    }

    public final long zzl() throws IOException {
        return zzz();
    }

    public final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzv() & 128) == 0) {
                return j;
            }
        }
        throw zzaji.zze();
    }

    public final long zzn() throws IOException {
        return zzy();
    }

    public final long zzo() throws IOException {
        return zzaia.zza(zzz());
    }

    public final long zzp() throws IOException {
        return zzz();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.firebase-auth-api.zzahp zzq() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.zzx()
            if (r0 <= 0) goto L19
            int r1 = r3.zzg
            int r2 = r3.zzi
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zze
            com.google.android.gms.internal.firebase-auth-api.zzahp r1 = com.google.android.gms.internal.firebase-auth-api.zzahp.zza(r1, r2, r0)
            int r2 = r3.zzi
            int r2 = r2 + r0
            r3.zzi = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.firebase-auth-api.zzahp r0 = com.google.android.gms.internal.firebase-auth-api.zzahp.zza
            return r0
        L1e:
            if (r0 <= 0) goto L31
            int r1 = r3.zzg
            int r2 = r3.zzi
            int r1 = r1 - r2
            if (r0 > r1) goto L31
            int r0 = r0 + r2
            r3.zzi = r0
            byte[] r1 = r3.zze
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L37
        L31:
            if (r0 > 0) goto L41
            if (r0 != 0) goto L3c
            byte[] r0 = com.google.android.gms.internal.firebase-auth-api.zzajf.zzb
        L37:
            com.google.android.gms.internal.firebase-auth-api.zzahp r0 = com.google.android.gms.internal.firebase-auth-api.zzahp.zzb(r0)
            return r0
        L3c:
            com.google.android.gms.internal.firebase-auth-api.zzaji r0 = com.google.android.gms.internal.firebase-auth-api.zzaji.zzf()
            throw r0
        L41:
            com.google.android.gms.internal.firebase-auth-api.zzaji r0 = com.google.android.gms.internal.firebase-auth-api.zzaji.zzi()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzaid.zzq():com.google.android.gms.internal.firebase-auth-api.zzahp");
    }

    public final String zzr() throws IOException {
        int zzx = zzx();
        if (zzx > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (zzx <= i - i2) {
                String str = new String(this.zze, i2, zzx, zzajf.zza);
                this.zzi += zzx;
                return str;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx < 0) {
            throw zzaji.zzf();
        }
        throw zzaji.zzi();
    }

    public final String zzs() throws IOException {
        int zzx = zzx();
        if (zzx > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (zzx <= i - i2) {
                String zzb = zzaml.zzb(this.zze, i2, zzx);
                this.zzi += zzx;
                return zzb;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx <= 0) {
            throw zzaji.zzf();
        }
        throw zzaji.zzi();
    }

    public final boolean zzt() throws IOException {
        return this.zzi == this.zzg;
    }

    public final boolean zzu() throws IOException {
        return zzz() != 0;
    }

    public /* synthetic */ zzaid(byte[] bArr, int i, int i2, boolean z, zzaic zzaicVar) {
        this(bArr, i, i2, z);
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzg;
            int i3 = this.zzi;
            if (i <= i2 - i3) {
                this.zzi = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzaji.zzi();
        }
        throw zzaji.zzf();
    }

    public final int zzb(int i) throws zzaji {
        if (i < 0) {
            throw zzaji.zzf();
        }
        int zzc = i + zzc();
        if (zzc < 0) {
            throw zzaji.zzg();
        }
        int i2 = this.zzl;
        if (zzc > i2) {
            throw zzaji.zzi();
        }
        this.zzl = zzc;
        zzaa();
        return i2;
    }

    public final void zzc(int i) throws zzaji {
        if (this.zzk != i) {
            throw zzaji.zzb();
        }
    }

    public final void zzd(int i) {
        this.zzl = i;
        zzaa();
    }

    public final boolean zze(int i) throws IOException {
        int zzi;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i3 < 10) {
                    if (zzv() < 0) {
                        i3++;
                    }
                }
                throw zzaji.zze();
            }
            while (i3 < 10) {
                byte[] bArr = this.zze;
                int i4 = this.zzi;
                this.zzi = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzaji.zze();
            return true;
        }
        if (i2 == 1) {
            zzf(8);
            return true;
        }
        if (i2 == 2) {
            zzf(zzx());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzaji.zza();
            }
            zzf(4);
            return true;
        }
        do {
            zzi = zzi();
            if (zzi == 0) {
                break;
            }
        } while (zze(zzi));
        zzc(((i >>> 3) << 3) | 4);
        return true;
    }
}
