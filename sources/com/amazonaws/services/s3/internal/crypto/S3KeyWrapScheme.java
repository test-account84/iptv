package com.amazonaws.services.s3.internal.crypto;

import java.security.Key;
import java.security.Provider;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class S3KeyWrapScheme {
    public static final String AES_WRAP = "AESWrap";
    static final S3KeyWrapScheme NONE = new 1();
    public static final String RSA_ECB_OAEP_WITH_SHA256_AND_MGF1_PADDING = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    public static class 1 extends S3KeyWrapScheme {
        public String getKeyWrapAlgorithm(Key key, Provider provider) {
            return null;
        }

        public String toString() {
            return "NONE";
        }
    }

    public String getKeyWrapAlgorithm(Key key, Provider provider) {
        String algorithm = key.getAlgorithm();
        if ("AES".equals(algorithm)) {
            return "AESWrap";
        }
        if ("RSA".equals(algorithm) && CryptoRuntime.isRsaKeyWrapAvailable(provider)) {
            return "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
        }
        return null;
    }

    public String toString() {
        return "S3KeyWrapScheme";
    }
}
