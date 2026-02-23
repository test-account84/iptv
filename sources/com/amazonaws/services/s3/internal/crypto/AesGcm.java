package com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AesGcm extends ContentCryptoScheme {
    private static final int DEFAULT_BLOCK_SIZE_IN_BYTES = 16;
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 12;
    private static final int DEFAULT_KEY_LENGTH_IN_BITS = 256;
    private static final int DEFAULT_TAG_LENGTH_IN_BITS = 128;

    public CipherLite createAuxillaryCipher(SecretKey secretKey, byte[] bArr, int i, Provider provider, long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        ContentCryptoScheme contentCryptoScheme = ContentCryptoScheme.AES_CTR;
        return contentCryptoScheme.createCipherLite(secretKey, contentCryptoScheme.adjustIV(bArr, j), i, provider);
    }

    public int getBlockSizeInBytes() {
        return 16;
    }

    public String getCipherAlgorithm() {
        return "AES/GCM/NoPadding";
    }

    public int getIVLengthInBytes() {
        return 12;
    }

    public String getKeyGeneratorAlgorithm() {
        return "AES";
    }

    public int getKeyLengthInBits() {
        return 256;
    }

    public long getMaxPlaintextSize() {
        return 68719476704L;
    }

    public String getSpecificCipherProvider() {
        return "BC";
    }

    public int getTagLengthInBits() {
        return 128;
    }

    public CipherLite newCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        return new GCMCipherLite(cipher, secretKey, i);
    }
}
