package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.KeyPairGeneratorSpec;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class KeyProvider18 implements KeyProvider {
    static final String ANDROID_KEY_STORE_NAME = "AndroidKeyStore";
    static final String AWS_KEY_VALUE_STORE_VERSION_1_KEY_STORE_ALIAS_FOR_RSA_SUFFIX = ".rsaKeyStoreAlias";
    static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    static final String CIPHER_PROVIDER_NAME_FOR_RSA = "AndroidOpenSSL";
    static final String CIPHER_RSA_MODE = "RSA/ECB/PKCS1Padding";
    static final String ENCRYPTED_AES_KEY = "AesGcmNoPadding18-encrypted-encryption-key";
    static final String KEY_ALGORITHM_AES = "AES";
    static final String KEY_ALGORITHM_RSA = "RSA";
    private static final Log logger = LogFactory.getLog(KeyProvider18.class);
    private Context context;
    private SecureRandom secureRandom;
    private SharedPreferences sharedPreferences;

    public KeyProvider18(Context context, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }

    private byte[] rsaDecrypt(String str, byte[] bArr) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load((KeyStore.LoadStoreParameter) null);
            KeyStore.PrivateKeyEntry entry = keyStore.getEntry(str, (KeyStore.ProtectionParameter) null);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
            cipher.init(2, entry.getPrivateKey());
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            logger.error("Exception occurred while decrypting the encrypted AES key. ", e);
            return null;
        }
    }

    private byte[] rsaEncrypt(String str, byte[] bArr) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load((KeyStore.LoadStoreParameter) null);
            KeyStore.PrivateKeyEntry entry = keyStore.getEntry(str, (KeyStore.ProtectionParameter) null);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
            cipher.init(1, entry.getCertificate().getPublicKey());
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            logger.error("Exception occurred while encrypting data. " + e.getMessage());
            return null;
        }
    }

    public synchronized void deleteKey(String str) {
        try {
            this.sharedPreferences.edit().remove("AesGcmNoPadding18-encrypted-encryption-key").apply();
        } catch (Exception e) {
            logger.error("Error in deleting the encrypted AES key identified by AesGcmNoPadding18-encrypted-encryption-key from SharedPreferences.", e);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load((KeyStore.LoadStoreParameter) null);
            keyStore.deleteEntry(str);
        } catch (Exception e2) {
            logger.error("Error in deleting the RSA Key identified by the keyAlias: " + str + " from AndroidKeyStore", e2);
        }
    }

    public synchronized Key generateKey(String str) throws KeyNotGeneratedException {
        SecretKey generateKey;
        try {
            KeyStore.getInstance("AndroidKeyStore").load((KeyStore.LoadStoreParameter) null);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(this.context).setAlias(str).setSubject(new X500Principal("CN=" + str)).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
            try {
                this.secureRandom = new SecureRandom();
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(256, this.secureRandom);
                generateKey = keyGenerator.generateKey();
                if (generateKey == null) {
                    throw new KeyNotGeneratedException("Error in generating the AES encryption key for the alias: AesGcmNoPadding18-encrypted-encryption-key");
                }
                byte[] encoded = generateKey.getEncoded();
                if (encoded == null || encoded.length == 0) {
                    throw new KeyNotGeneratedException("Error in generating the AES encryption key for the alias: AesGcmNoPadding18-encrypted-encryption-key");
                }
                byte[] rsaEncrypt = rsaEncrypt(str, encoded);
                if (rsaEncrypt == null || rsaEncrypt.length == 0) {
                    throw new KeyNotGeneratedException("Error in RSA encrypting the AES encryption key for the AES keyAlias: AesGcmNoPadding18-encrypted-encryption-key using the rsaKeyAlias: " + str);
                }
                String encodeAsString = Base64.encodeAsString(rsaEncrypt);
                if (encodeAsString == null) {
                    throw new KeyNotGeneratedException("Error in Base64 encoding of the Encrypted AES key for the AES keyAlias: AesGcmNoPadding18-encrypted-encryption-key using the rsaKeyAlias: " + str);
                }
                this.sharedPreferences.edit().putString("AesGcmNoPadding18-encrypted-encryption-key", encodeAsString).apply();
                logger.info("Generated and saved the Encrypted AES encryption key for the AES keyAlias: AesGcmNoPadding18-encrypted-encryption-key to SharedPreferences.");
            } catch (Exception e) {
                throw new KeyNotGeneratedException("Error in generating the AES key and RSA encrypting the AES key using the rsaKeyAlias: " + str + " in AndroidKeyStore", e);
            }
        } catch (Exception e2) {
            throw new KeyNotGeneratedException("Error in generating the RSA Encryption key for the rsaKeyAlias: " + str + " in AndroidKeyStore", e2);
        }
        return generateKey;
    }

    public synchronized Key retrieveKey(String str) throws KeyNotFoundException {
        byte[] rsaDecrypt;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load((KeyStore.LoadStoreParameter) null);
            if (!keyStore.containsAlias(str)) {
                throw new KeyNotFoundException("The RSA Key identified by the alias: " + str + " cannot be found in AndroidKeyStore");
            }
            if (!this.sharedPreferences.contains("AesGcmNoPadding18-encrypted-encryption-key")) {
                throw new KeyNotFoundException("SharedPreferences does not have the key for keyAlias: AesGcmNoPadding18-encrypted-encryption-key");
            }
            logger.debug("Loading the encryption key from SharedPreferences");
            String string = this.sharedPreferences.getString("AesGcmNoPadding18-encrypted-encryption-key", (String) null);
            if (string == null) {
                throw new KeyNotFoundException("Unable to retrieve the encrypted AES Key identified by AesGcmNoPadding18-encrypted-encryption-key from the SharedPreferences.");
            }
            byte[] decode = Base64.decode(string);
            if (decode == null || decode.length == 0) {
                throw new KeyNotFoundException("Unable to Base64 decode the encrypted AES key identified by: AesGcmNoPadding18-encrypted-encryption-key");
            }
            rsaDecrypt = rsaDecrypt(str, decode);
            if (rsaDecrypt == null || rsaDecrypt.length == 0) {
                throw new KeyNotFoundException("Unable to RSA decrypt the encrypted AES key identified by: AesGcmNoPadding18-encrypted-encryption-key using the RSA key identified by keyAlias: " + str);
            }
        } catch (Exception e) {
            throw new KeyNotFoundException("Error occurred while accessing AndroidKeyStore to retrieve the key for keyAlias: " + str, e);
        }
        return new SecretKeySpec(rsaDecrypt, "AES");
    }
}
