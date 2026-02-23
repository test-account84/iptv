package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AesCbc extends ContentCryptoScheme {
    private static final int DEFAULT_BLOCK_SIZE_IN_BYTES = 16;
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 16;
    private static final int DEFAULT_KEY_LENGTH_IN_BITS = 256;

    public int getBlockSizeInBytes() {
        return 16;
    }

    public String getCipherAlgorithm() {
        return "AES/CBC/PKCS5Padding";
    }

    public int getIVLengthInBytes() {
        return 16;
    }

    public String getKeyGeneratorAlgorithm() {
        return "AES";
    }

    public int getKeyLengthInBits() {
        return 256;
    }

    public long getMaxPlaintextSize() {
        return 4503599627370496L;
    }
}
