package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public enum zzuo implements zzaje {
    KEM_UNKNOWN(0),
    DHKEM_X25519_HKDF_SHA256(1),
    DHKEM_P256_HKDF_SHA256(2),
    DHKEM_P384_HKDF_SHA384(3),
    DHKEM_P521_HKDF_SHA512(4),
    UNRECOGNIZED(-1);

    private static final zzajh zzg = new zzun();
    private final int zzi;

    zzuo(int i) {
        this.zzi = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzuo.class.getName());
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
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzuo zza(int i) {
        if (i == 0) {
            return KEM_UNKNOWN;
        }
        if (i == 1) {
            return DHKEM_X25519_HKDF_SHA256;
        }
        if (i == 2) {
            return DHKEM_P256_HKDF_SHA256;
        }
        if (i == 3) {
            return DHKEM_P384_HKDF_SHA384;
        }
        if (i != 4) {
            return null;
        }
        return DHKEM_P521_HKDF_SHA512;
    }
}
