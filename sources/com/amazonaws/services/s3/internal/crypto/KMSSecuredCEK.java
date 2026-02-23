package com.amazonaws.services.s3.internal.crypto;

import java.util.Map;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class KMSSecuredCEK extends SecuredCEK {
    static final String KEY_PROTECTION_MECHANISM = "kms";

    public KMSSecuredCEK(byte[] bArr, Map map) {
        super(bArr, "kms", map);
    }

    public static boolean isKMSKeyWrapped(String str) {
        return "kms".equals(str);
    }
}
