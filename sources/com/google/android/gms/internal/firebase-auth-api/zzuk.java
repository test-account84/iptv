package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public enum zzuk implements zzaje {
    AEAD_UNKNOWN(0),
    AES_128_GCM(1),
    AES_256_GCM(2),
    CHACHA20_POLY1305(3),
    UNRECOGNIZED(-1);

    private static final zzajh zzf = new zzuj();
    private final int zzh;

    zzuk(int i) {
        this.zzh = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzuk.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(zza());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzh;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzuk zza(int i) {
        if (i == 0) {
            return AEAD_UNKNOWN;
        }
        if (i == 1) {
            return AES_128_GCM;
        }
        if (i == 2) {
            return AES_256_GCM;
        }
        if (i != 3) {
            return null;
        }
        return CHACHA20_POLY1305;
    }
}
