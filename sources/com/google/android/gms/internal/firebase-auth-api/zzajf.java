package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzajf {
    public static final byte[] zzb;
    private static final ByteBuffer zze;
    private static final zzaia zzf;
    private static final Charset zzc = Charset.forName("US-ASCII");
    static final Charset zza = Charset.forName("UTF-8");
    private static final Charset zzd = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zze = ByteBuffer.wrap(bArr);
        zzf = zzaia.zza(bArr, 0, bArr.length, false);
    }

    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static boolean zzc(byte[] bArr) {
        return zzaml.zza(bArr);
    }

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    public static Object zza(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static boolean zza(zzakn zzaknVar) {
        boolean z = zzaknVar instanceof zzahh;
        return false;
    }
}
