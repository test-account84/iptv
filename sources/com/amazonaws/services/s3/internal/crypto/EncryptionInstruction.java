package com.amazonaws.services.s3.internal.crypto;

import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EncryptionInstruction {
    private final byte[] encryptedSymmetricKey;
    private final Map materialsDescription;
    private final Cipher symmetricCipher;
    private final CipherFactory symmetricCipherFactory;

    public EncryptionInstruction(Map map, byte[] bArr, SecretKey secretKey, CipherFactory cipherFactory) {
        this.materialsDescription = map;
        this.encryptedSymmetricKey = bArr;
        this.symmetricCipherFactory = cipherFactory;
        this.symmetricCipher = cipherFactory.createCipher();
    }

    public CipherFactory getCipherFactory() {
        return this.symmetricCipherFactory;
    }

    public byte[] getEncryptedSymmetricKey() {
        return this.encryptedSymmetricKey;
    }

    public Map getMaterialsDescription() {
        return this.materialsDescription;
    }

    public Cipher getSymmetricCipher() {
        return this.symmetricCipher;
    }

    public EncryptionInstruction(Map map, byte[] bArr, SecretKey secretKey, Cipher cipher) {
        this.materialsDescription = map;
        this.encryptedSymmetricKey = bArr;
        this.symmetricCipher = cipher;
        this.symmetricCipherFactory = null;
    }
}
