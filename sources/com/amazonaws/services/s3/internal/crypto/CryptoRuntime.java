package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CryptoRuntime {
    private static final String BC_PROVIDER_FQCN = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    static final String BOUNCY_CASTLE_PROVIDER = "BC";
    private static final Log LOGGER = LogFactory.getLog(CryptoRuntime.class);

    public static final class AesGcm {
        private AesGcm() {
        }

        public static /* synthetic */ boolean access$000(Provider provider) {
            return check(provider);
        }

        private static boolean check(Provider provider) {
            try {
                Cipher.getInstance(ContentCryptoScheme.AES_GCM.getCipherAlgorithm(), provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static final class RsaEcbOaepWithSHA256AndMGF1Padding {
        private RsaEcbOaepWithSHA256AndMGF1Padding() {
        }

        public static /* synthetic */ boolean access$100(Provider provider) {
            return check(provider);
        }

        private static boolean check(Provider provider) {
            try {
                Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static synchronized void enableBouncyCastle() {
        synchronized (CryptoRuntime.class) {
            if (isBouncyCastleAvailable()) {
                return;
            }
            try {
                Security.addProvider((Provider) Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider").newInstance());
            } catch (Exception e) {
                LOGGER.debug("Bouncy Castle not available", e);
            }
        }
    }

    public static boolean isAesGcmAvailable(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return AesGcm.access$000(provider);
    }

    public static synchronized boolean isBouncyCastleAvailable() {
        boolean z;
        synchronized (CryptoRuntime.class) {
            z = Security.getProvider("BC") != null;
        }
        return z;
    }

    public static boolean isRsaKeyWrapAvailable(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return RsaEcbOaepWithSHA256AndMGF1Padding.access$100(provider);
    }
}
