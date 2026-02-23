package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzahp implements Serializable, Iterable {
    public static final zzahp zza = new zzahz(zzajf.zzb);
    private static final zzahs zzb = new zzahy(null);
    private static final Comparator zzc = new zzahr();
    private int zzd = 0;

    public static zzahp zzb(byte[] bArr) {
        return new zzahz(bArr);
    }

    public static zzahu zzc(int i) {
        return new zzahu(i, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzd;
        if (i == 0) {
            int zzb2 = zzb();
            i = zzb(zzb2, 0, zzb2);
            if (i == 0) {
                i = 1;
            }
            this.zzd = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzaho(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            str = zzalw.zza(this);
        } else {
            str = zzalw.zza(zza(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{hexString, valueOf, str});
    }

    public abstract byte zza(int i);

    public final int zza() {
        return this.zzd;
    }

    public abstract zzahp zza(int i, int i2);

    public abstract String zza(Charset charset);

    public abstract void zza(zzahm zzahmVar) throws IOException;

    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract byte zzb(int i);

    public abstract int zzb();

    public abstract int zzb(int i, int i2, int i3);

    public abstract zzaia zzc();

    public final String zzd() {
        return zzb() == 0 ? "" : zza(zzajf.zza);
    }

    public final boolean zze() {
        return zzb() == 0;
    }

    public abstract boolean zzf();

    public final byte[] zzg() {
        int zzb2 = zzb();
        if (zzb2 == 0) {
            return zzajf.zzb;
        }
        byte[] bArr = new byte[zzb2];
        zza(bArr, 0, 0, zzb2);
        return bArr;
    }

    public static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public static int zza(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public static zzahp zza(String str) {
        return new zzahz(str.getBytes(zzajf.zza));
    }

    public static zzahp zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzahp zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zzahz(zzb.zza(bArr, i, i2));
    }
}
