package com.amazonaws.internal.keyvaluestore;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class KeyProvider23 implements KeyProvider {
    private static final String AES_KEY_ALGORITHM = "AES";
    private static final String ANDROID_KEY_STORE_NAME = "AndroidKeyStore";
    static final String AWS_KEY_VALUE_STORE_VERSION_1_KEY_STORE_ALIAS_FOR_AES_SUFFIX = ".aesKeyStoreAlias";
    private static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    private static final Log logger = LogFactory.getLog(KeyProvider23.class);

    public synchronized void deleteKey(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load((KeyStore.LoadStoreParameter) null);
            keyStore.deleteEntry(str);
        } catch (Exception e) {
            logger.error("Error in deleting the key for keyAlias: " + str + " from Android KeyStore.", e);
        }
    }

    public synchronized Key generateKey(String str) throws KeyNotGeneratedException {
        SecretKey generateKey;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load((KeyStore.LoadStoreParameter) null);
            if (keyStore.containsAlias(str)) {
                throw new KeyNotGeneratedException("Key already exists for the keyAlias: " + str + " in AndroidKeyStore");
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            g.a();
            keyGenerator.init(e.a(d.a(c.a(b.a(a.a(f.a(str, 3), new String[]{"GCM"}), new String[]{"NoPadding"}), 256), false)));
            generateKey = keyGenerator.generateKey();
            logger.info("Generated the encryption key identified by the keyAlias: " + str + " using AndroidKeyStore");
        } catch (Exception e) {
            throw new KeyNotGeneratedException("Cannot generate a key for alias: " + str + " in AndroidKeyStore", e);
        }
        return generateKey;
    }

    public synchronized Key retrieveKey(String str) throws KeyNotFoundException {
        Key key;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load((KeyStore.LoadStoreParameter) null);
                if (!keyStore.containsAlias(str)) {
                    throw new KeyNotFoundException("AndroidKeyStore does not contain the keyAlias: " + str);
                }
                Log log = logger;
                log.debug("AndroidKeyStore contains keyAlias " + str);
                log.debug("Loading the encryption key from Android KeyStore.");
                key = keyStore.getKey(str, (char[]) null);
                if (key == null) {
                    throw new KeyNotFoundException("Key is null even though the keyAlias: " + str + " is present in AndroidKeyStore");
                }
            } catch (Exception e) {
                throw new KeyNotFoundException("Error occurred while accessing AndroidKeyStore to retrieve the key for keyAlias: " + str, e);
            }
        } catch (Throwable th) {
            throw th;
        }
        return key;
    }
}
