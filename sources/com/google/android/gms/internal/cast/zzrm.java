package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzrm implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzrm zzb = new zzrj(zzsq.zzd);
    private static final zzrl zzd;
    private int zzc = 0;

    static {
        int i = zzrb.zza;
        zzd = new zzrl(null);
        zza = new zzre();
    }

    public static int zzj(int i, int i2, int i3) {
        if (((i3 - i2) | i2) >= 0) {
            return i2;
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zze(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzrd(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzup.zza(this) : zzup.zza(zzf(0, 47)).concat("...")});
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract int zze(int i, int i2, int i3);

    public abstract zzrm zzf(int i, int i2);

    public abstract String zzg(Charset charset);

    public abstract void zzh(zzrc zzrcVar) throws IOException;

    public abstract boolean zzi();

    public final int zzk() {
        return this.zzc;
    }

    public final String zzl(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }
}
