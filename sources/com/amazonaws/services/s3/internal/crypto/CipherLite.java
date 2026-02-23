package com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class CipherLite {
    static final CipherLite NULL = new 1();
    private final Cipher cipher;
    private final int cipherMode;
    private final ContentCryptoScheme scheme;
    private final SecretKey secreteKey;

    public static class 1 extends CipherLite {
        public 1() {
            super(null);
        }

        public CipherLite createAuxiliary(long j) {
            return this;
        }

        public CipherLite createInverse() {
            return this;
        }
    }

    private CipherLite() {
        this.cipher = new NullCipher();
        this.scheme = null;
        this.secreteKey = null;
        this.cipherMode = -1;
    }

    public CipherLite createAuxiliary(long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return this.scheme.createAuxillaryCipher(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider(), j);
    }

    public CipherLite createInverse() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        int i = this.cipherMode;
        int i2 = 1;
        if (i != 2) {
            if (i != 1) {
                throw new UnsupportedOperationException();
            }
            i2 = 2;
        }
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), i2, this.cipher.getProvider());
    }

    public CipherLite createUsingIV(byte[] bArr) {
        return this.scheme.createCipherLite(this.secreteKey, bArr, this.cipherMode, this.cipher.getProvider());
    }

    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal();
    }

    public final int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public final String getCipherAlgorithm() {
        return this.cipher.getAlgorithm();
    }

    public final int getCipherMode() {
        return this.cipherMode;
    }

    public final Provider getCipherProvider() {
        return this.cipher.getProvider();
    }

    public final ContentCryptoScheme getContentCryptoScheme() {
        return this.scheme;
    }

    public final byte[] getIV() {
        return this.cipher.getIV();
    }

    public int getOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }

    public final String getSecretKeyAlgorithm() {
        return this.secreteKey.getAlgorithm();
    }

    public long mark() {
        return -1L;
    }

    public boolean markSupported() {
        return false;
    }

    public CipherLite recreate() {
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider());
    }

    public void reset() {
        throw new IllegalStateException("mark/reset not supported");
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        return this.cipher.update(bArr, i, i2);
    }

    public /* synthetic */ CipherLite(1 r1) {
        this();
    }

    public byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr);
    }

    public CipherLite(Cipher cipher, ContentCryptoScheme contentCryptoScheme, SecretKey secretKey, int i) {
        this.cipher = cipher;
        this.scheme = contentCryptoScheme;
        this.secreteKey = secretKey;
        this.cipherMode = i;
    }

    public byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr, i, i2);
    }
}
